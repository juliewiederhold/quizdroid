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

import java.util.ArrayList;


public class Question extends ActionBarActivity {
    ArrayList<String>questions = new ArrayList<>();
    ArrayList<String>answers = new ArrayList<>();
    ArrayList<String> correctAnswers = new ArrayList<>();
    int totalCorrect;
    int numQuestion;
    String userAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent parentCall = getIntent();
        final String topic = parentCall.getStringExtra("topic");
        questions = parentCall.getStringArrayListExtra("questions");
        answers = parentCall.getStringArrayListExtra("answers");
        numQuestion = parentCall.getIntExtra("questionNum", -1);
        totalCorrect = parentCall.getIntExtra("total", -1);
        correctAnswers = parentCall.getStringArrayListExtra("correctAnswers");

        if(totalCorrect == -1)
            totalCorrect = 0;

        TextView title = (TextView) findViewById(R.id.overViewTitle);
        TextView question = (TextView) findViewById(R.id.question);
        TextView answer1 = (TextView) findViewById(R.id.answer1);
        TextView answer2 = (TextView) findViewById(R.id.answer2);
        TextView answer3 = (TextView) findViewById(R.id.answer3);
        TextView answer4 = (TextView) findViewById(R.id.answer4);
        if(topic.equals("math")){
            title.setText("Math Question ");
        } else if(topic.equals("physics")){
            title.setText("Physics Question ");
        } else if(topic.equals("superhero")) {
            title.setText("Marvel Super Hero Question");
        }
        question.setText(questions.get(numQuestion));
        if(numQuestion == 0){
            answer1.setText(answers.get(0));
            answer2.setText(answers.get(1));
            answer3.setText(answers.get(2));
            answer4.setText(answers.get(3));
        } else {
            answer1.setText(answers.get(4));
            answer2.setText(answers.get(5));
            answer3.setText(answers.get(6));
            answer4.setText(answers.get(7));
        }

        Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                RadioGroup rb = (RadioGroup) findViewById(R.id.radiogroup);
                if(rb.getCheckedRadioButtonId() > 0){
                    Intent intent = new Intent(Question.this, BetweenQuestion.class);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        if(correctAnswers.get(numQuestion).equals(userAnswer))
                            totalCorrect++;
                        if(topic.equals("math"))
                            intent.putExtra("topic", "math");
                        else if(topic.equals("physics"))
                            intent.putExtra("topic", "physics");
                        else if(topic.equals("superhero"))
                            intent.putExtra("topic", "superhero");
                        intent.putExtra("questions", questions);
                        intent.putExtra("answers",  answers);
                        intent.putExtra("questionNum", numQuestion + 1);
                        intent.putExtra("total", totalCorrect);
                        intent.putExtra("correctAnswer", correctAnswers);
                        intent.putExtra("userAnswer", "You answered: " + userAnswer);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.answer1:
                if (checked){
                    if(numQuestion == 0)
                        userAnswer = answers.get(0);
                    else{
                        userAnswer = answers.get(4);
                    }

                }
                break;
            case R.id.answer2:
                if (checked) {
                    if(numQuestion == 0)
                        userAnswer = answers.get(1);
                    else
                        userAnswer = answers.get(5);
                }
                break;
            case R.id.answer3:
                if (checked) {
                    if(numQuestion == 0)
                        userAnswer = answers.get(2);
                    else
                        userAnswer = answers.get(6);
                }
                break;
            case R.id.answer4:
                if (checked) {
                    if(numQuestion == 0)
                        userAnswer = answers.get(3);
                    else
                        userAnswer = answers.get(7);
                }
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
