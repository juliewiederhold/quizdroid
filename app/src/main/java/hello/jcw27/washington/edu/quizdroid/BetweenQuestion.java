package hello.jcw27.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class BetweenQuestion extends ActionBarActivity {
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String>answers = new ArrayList<>();
    ArrayList<String> correctAnswers = new ArrayList<>();
    int totalCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_between_question);

        Intent parentCall = getIntent();
        final String topic = parentCall.getStringExtra("topic");
        questions = parentCall.getStringArrayListExtra("questions");
        answers = parentCall.getStringArrayListExtra("answers");
        final int numQuestion = parentCall.getIntExtra("questionNum", -1);
        totalCorrect = parentCall.getIntExtra("total", -1);
        String answer = parentCall.getStringExtra("userAnswer");
        correctAnswers = parentCall.getStringArrayListExtra("correctAnswer");

        TextView title = (TextView) findViewById(R.id.overViewTitle);
        TextView userAnswer = (TextView) findViewById(R.id.userAnswer);
        TextView correct = (TextView) findViewById(R.id.correctAnswer);
        TextView stats = (TextView) findViewById(R.id.stats);

        if(topic.equals("math")){
            title.setText("Math Answer Summary");
        } else if(topic.equals("physics")){
            title.setText("Physics Answer Summary");
        } else if(topic.equals("superhero")){
            title.setText("Marvel Super Hero Answer Summary");
        }
        userAnswer.setText(answer);
        String corAns = correctAnswers.get(numQuestion - 1);
        correct.setText("The answer is: " + corAns);
        stats.setText("You have answered " + totalCorrect + " of " + questions.size() + " correct");

        Button next = (Button) findViewById(R.id.next);
        if(numQuestion == questions.size()){
            TextView finish = (TextView) findViewById(R.id.next);
            finish.setText("Finish");
        }
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(numQuestion < questions.size()){
                    Intent intent = new Intent(BetweenQuestion.this, Question.class);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                            if(topic.equals("math"))
                                intent.putExtra("topic", "math");
                            else if(topic.equals("physics"))
                                intent.putExtra("topic", "physics");
                            else if(topic.equals("superhero"))
                                intent.putExtra("topic", "superhero");
                            intent.putExtra("questions", questions);
                            intent.putExtra("answers", answers);
                            intent.putExtra("questionNum", numQuestion);
                            intent.putExtra("total", totalCorrect);
                            intent.putExtra("correctAnswers", correctAnswers);
                            startActivity(intent);
                    }
                } else {
                    Intent intent = new Intent(BetweenQuestion.this, MainActivity.class);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_between_question, menu);
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
