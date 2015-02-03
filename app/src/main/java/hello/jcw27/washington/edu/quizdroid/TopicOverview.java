package hello.jcw27.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class TopicOverview extends ActionBarActivity {

    ArrayList<String> mathQuestions = new ArrayList<String>();
    ArrayList<String> mathQuestionsAnswers = new ArrayList<String>();
    ArrayList<String> physicsQuestions = new ArrayList<String>();
    ArrayList<String> physicsQuestionsAnswers = new ArrayList<String>();
    ArrayList<String> superheroQuestions = new ArrayList<String>();
    ArrayList<String> superheroQuestionsAnswers = new ArrayList<String>();
    ArrayList<String> mathCorrectAnswers = new ArrayList<String>();
    ArrayList<String> physicsCorrectAnswers = new ArrayList<String>();
    ArrayList<String> superheroCorrectAnswers = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_overview);

        Intent parentCall = getIntent();
        final String topic = parentCall.getStringExtra("topic");

        mathQuestions.add("1 + 1 = ?");
        mathQuestions.add("4 + 6 = ?");
        mathQuestionsAnswers.add("2");

        mathCorrectAnswers.add("2");
        mathCorrectAnswers.add("10");

        mathQuestionsAnswers.add("0");
        mathQuestionsAnswers.add("7");
        mathQuestionsAnswers.add("i");

        mathQuestionsAnswers.add("7");
        mathQuestionsAnswers.add("10");
        mathQuestionsAnswers.add("12");
        mathQuestionsAnswers.add("6");


        physicsQuestions.add("Who came up with Newtons 3 laws of physics?");
        physicsQuestions.add("What is the equation for velocity");

        physicsCorrectAnswers.add("Newton");
        physicsCorrectAnswers.add("v=d/t");

        physicsQuestionsAnswers.add("Netwon");
        physicsQuestionsAnswers.add("Chingy");
        physicsQuestionsAnswers.add("Edgar Allan Poe");
        physicsQuestionsAnswers.add("None of the above");

        physicsQuestionsAnswers.add("e=mc^2");
        physicsQuestionsAnswers.add("v=d/t");
        physicsQuestionsAnswers.add("x^2");
        physicsQuestionsAnswers.add("Does Not exist");

        superheroQuestions.add("Which of these is a superhero?");
        superheroQuestionsAnswers.add("Superman");
        superheroQuestionsAnswers.add("Cartman");
        superheroQuestionsAnswers.add("Big Bird");
        superheroQuestionsAnswers.add("Potato Man");

        superheroCorrectAnswers.add("Superman");
        superheroCorrectAnswers.add("Regina George");

        superheroQuestions.add("Which of these is not superhero?");
        superheroQuestionsAnswers.add("Superman");
        superheroQuestionsAnswers.add("The Flash");
        superheroQuestionsAnswers.add("Regina George");
        superheroQuestionsAnswers.add("Batman");

        TextView title = (TextView) findViewById(R.id.overViewTitle);
        TextView descrip = (TextView) findViewById(R.id.overViewDescrip);
        TextView numQ = (TextView) findViewById(R.id.overViewNumQ);

        Button begin = (Button) findViewById(R.id.begin);

        if(topic.equals("math")){
            title.setText("Math Overview");
            descrip.setText("Math Overview description goes right here. Wow this is an excellent overview. MATH!");
            numQ.setText("Number of questions: 2");
        } else if(topic.equals("physics")){
            title.setText("Physics Overview");
            descrip.setText("Physics Overview description goes right here. Wow this is an excellent overview. PHYSICS!");
            numQ.setText("Number of questions: 2");
        } else if(topic.equals("superhero")){
            title.setText("Marvel Superhero Overview");
            descrip.setText("Marvel Superhero Overview description goes right here. Wow this is an excellent overview. SUPERHERO!");
            numQ.setText("Number of questions: 2");
        }



        begin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(TopicOverview.this, Question.class);
                if(topic.equals("math")){
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        intent.putExtra("topic", "math");
                        intent.putExtra("questions", mathQuestions);
                        intent.putExtra("answers", mathQuestionsAnswers);
                        intent.putExtra("correctAnswers", mathCorrectAnswers);
                        intent.putExtra("questionNum", 0);
                        intent.putExtra("totalCorrect", 0);
                        startActivity(intent);
                    }

                    finish();
                } else if(topic.equals("physics")){
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        intent.putExtra("topic", "physics");
                        intent.putExtra("questions", physicsQuestions);
                        intent.putExtra("answers", physicsQuestionsAnswers);
                        intent.putExtra("correctAnswers", physicsCorrectAnswers);
                        intent.putExtra("questionNum", 0);
                        intent.putExtra("totalCorrect", 0);
                        startActivity(intent);
                    }

                    finish();
                } else if(topic.equals("superhero")) {
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        intent.putExtra("topic", "superhero");
                        intent.putExtra("questions", superheroQuestions);
                        intent.putExtra("answers", superheroQuestionsAnswers);
                        intent.putExtra("correctAnswers", superheroCorrectAnswers);
                        intent.putExtra("questionNum", 0);
                        intent.putExtra("totalCorrect", 0);
                        startActivity(intent);
                    }
                    finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topic_overview, menu);
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
