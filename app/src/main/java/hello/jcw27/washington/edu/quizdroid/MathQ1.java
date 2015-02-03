package hello.jcw27.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MathQ1 extends ActionBarActivity {

    String userAnswer;
    boolean correct;
    int totalCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_q1);

        TextView question1 = (TextView) findViewById(R.id.mathQ1);
        question1.setText("1 + 1 = ?");

        final TextView option1 = (TextView) findViewById(R.id.mathOp1);
        option1.setText("2");

        final TextView option2 = (TextView) findViewById(R.id.mathOp2);
        option2.setText("0");

        final TextView option3 = (TextView) findViewById(R.id.mathOp3);
        option3.setText("100");

        final TextView option4 = (TextView) findViewById(R.id.mathOp4);
        option4.setText("7");

        Button submit = (Button) findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                RadioGroup rb = (RadioGroup) findViewById(R.id.radiogroup);
                if(rb.getCheckedRadioButtonId() > 0){
                    Intent q1 = new Intent(MathQ1.this, BetweenQuestion.class);
                    if (q1.resolveActivity(getPackageManager()) != null) {
                        if(correct)
                            totalCorrect++;
                        q1.putExtra("topic", "math");
                        q1.putExtra("question", "math1");
                        q1.putExtra("total", totalCorrect);
                        startActivity(q1);
                    }
                }
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.mathOp1:
                if (checked){
                    correct = true;
                }
                break;
            case R.id.mathOp2:
                if (checked) {
                    correct = false;
                }
                break;
            case R.id.mathOp3:
                if (checked) {
                    correct = false;
                }
                break;
            case R.id.mathOp4:
                if (checked) {
                    correct = false;
                }
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math_q1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
