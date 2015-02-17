package hello.jcw27.washington.edu.quizdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;


public class Manager extends ActionBarActivity implements Serializable{
    public static String topic;
    public static String userAnswer;
    public static Topic t;
    public static ArrayList<Quiz> questions = new ArrayList<>();
    public static ArrayList<String> answers = new ArrayList<>();
    public static int totalCorrect;
    public static int numQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        topic = QuizApp.getInstance().getTopic();
        questions = QuizApp.getInstance().getQuestionList();
        answers = QuizApp.getInstance().getAnswerList();
        totalCorrect = 0;
        numQuestion = QuizApp.getInstance().getNumQuestion();
        /*Intent parentCall = getIntent();
        topic = parentCall.getStringExtra("topic");

        if(topic.equals("math")){

        } else if(topic.equals("physics")){
            t = new Topic("Physics", "Physics Overview description goes right here. Wow this is an excellent overview. PHYSICS!");
            t.addQuestion(new Quiz("Who came up with Newtons 3 laws of physics?",
                    "Newton", "Chingy", "Edgar Allen Poe", "None of the above"));
            t.addQuestion(new Quiz("What is the equation for velocity", "v=d/t", "e=c^2", "x^2", "Does not Exist"));
        } else if(topic.equals("superhero")){
            t = new Topic("Marvel Super Heroes", "Marvel Super Hero Overview description goes right here. Wow this is an excellent overview. SUPERHERO!");
            t.addQuestion(new Quiz("Which of these is a superhero?", "Superman", "Cartman", "Big Bird", "Potato Man"));
            t.addQuestion(new Quiz("Which of these is not superhero?", "Regina George", "The Flash", "Superman", "BATMAN"));
        }*/

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        Fragment topic = new TopicsOverview();

        if (savedInstanceState == null) {
                    fragmentTransaction.add(R.id.container, topic)
                    .addToBackStack("topicsOverview")
                    .commit();
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer1:
                if (checked) {
                    userAnswer = answers.get(0);
                }
                break;
            case R.id.answer2:
                if (checked) {
                    userAnswer = answers.get(1);
                }
                break;
            case R.id.answer3:
                if (checked) {
                    userAnswer = answers.get(2);
                }
                break;
            case R.id.answer4:
                if (checked) {
                    userAnswer = answers.get(3);
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_manager, menu);
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

    public static class Questions extends Fragment {

        public Questions() {
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_question, container, false);

            TextView title = (TextView) rootView.findViewById(R.id.overViewTitle);
            TextView question = (TextView) rootView.findViewById(R.id.question);
            TextView answer1 = (TextView) rootView.findViewById(R.id.answer1);
            TextView answer2 = (TextView) rootView.findViewById(R.id.answer2);
            TextView answer3 = (TextView) rootView.findViewById(R.id.answer3);
            TextView answer4 = (TextView) rootView.findViewById(R.id.answer4);

            if(topic.equals("math")){
                title.setText("Math");
            } else if(topic.equals("physics")){
                title.setText("Physics Overview");
            } else if(topic.equals("superhero")){
                title.setText("Marvel Super Hero Overview");
            }

            question.setText((CharSequence) questions.get(numQuestion).getQuestion());
            answers = t.getQuestion(numQuestion).getAnswerList();
            answer1.setText(answers.get(0));
            answer2.setText(answers.get(1));
            answer3.setText(answers.get(2));
            answer4.setText(answers.get(3));

            Button submit = (Button) rootView.findViewById(R.id.submitButton);
            final RadioGroup rb = (RadioGroup) rootView.findViewById(R.id.radiogroup);
            submit.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    if (rb.getCheckedRadioButtonId() > 0) {
                        if (questions.get(numQuestion).getCorrectAnswer().equals(userAnswer)) {
                            totalCorrect++;
                        }
                        FragmentTransaction transaction = getFragmentManager().beginTransaction().replace(R.id.container, new BetweenQuestions());
                        transaction.setCustomAnimations(R.animator.slide_left, R.animator.slide_right);
                        transaction.addToBackStack("questions");
                        transaction.commit();
                    }
                }

            });

            return rootView;
        }
    }

    public static class BetweenQuestions extends Fragment{

        // Creates a fragment to display the between questions page
        public BetweenQuestions(){

        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_between_question, container, false);

            TextView title = (TextView) rootView.findViewById(R.id.overViewTitle);
            TextView userResponse = (TextView) rootView.findViewById(R.id.userAnswer);
            TextView correct = (TextView) rootView.findViewById(R.id.correctAnswer);
            TextView stats = (TextView) rootView.findViewById(R.id.stats);

            if(topic.equals("math")){
                title.setText("Math Answer Summary");
            } else if(topic.equals("physics")){
                title.setText("Physics Answer Summary");
            } else if(topic.equals("superhero")){
                title.setText("Marvel Super Hero Answer Summary");
            }
            userResponse.setText("You answered: " + userAnswer);
            String corAns = questions.get(numQuestion).getCorrectAnswer();
            correct.setText("The answer is: " + corAns);
            stats.setText("You have answered " + totalCorrect + " of " + questions.size() + " correct");

            numQuestion++;
            Button next = (Button) rootView.findViewById(R.id.next);
            if(numQuestion == questions.size()){
                TextView finish = (TextView) rootView.findViewById(R.id.next);
                finish.setText("Finish");
            }
            next.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(numQuestion < questions.size()){
                        FragmentTransaction transaction = getFragmentManager().beginTransaction().replace(R.id.container, new Questions());
                        transaction.setCustomAnimations(R.animator.slide_left, R.animator.slide_right);
                        transaction.addToBackStack("betweenQuestion" + numQuestion);
                        transaction.commit();
                    } else {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivityForResult(intent, 1);
                        getActivity().finish();
                    }

                }
            });

            return rootView;
        }
    }

    public static class TopicsOverview extends Fragment{

        // Creates a fragment to display the topic overview
        public TopicsOverview(){

        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = (ViewGroup) inflater.inflate(R.layout.activity_topic_overview, container, false);

            TextView title = (TextView) rootView.findViewById(R.id.overViewTitle);
            TextView descrip = (TextView) rootView.findViewById(R.id.overViewDescrip);
            TextView numQ = (TextView) rootView.findViewById(R.id.overViewNumQ);

            title.setText(t.getTopic());
            descrip.setText(t.getDescription());
            numQ.setText("Number of questions: " + numQuestion);

            Button beginButton = (Button) rootView.findViewById(R.id.beginButton);
            beginButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    FragmentTransaction transaction = getFragmentManager().beginTransaction().replace(R.id.container, new Questions());
                    transaction.setCustomAnimations(R.animator.slide_left, R.animator.slide_right);
                    transaction.addToBackStack("topicOverview");
                    transaction.commit();
                }
            });

            return rootView;
        }
    }
}
