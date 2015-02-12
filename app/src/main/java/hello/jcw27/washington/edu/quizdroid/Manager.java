package hello.jcw27.washington.edu.quizdroid;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Manager extends ActionBarActivity {
    public static String topic;
    public static int numQuestions = 2;
    public static String userAnswer;
    public static ArrayList<String> questions = new ArrayList<>();
    public static ArrayList<String> answers = new ArrayList<>();
    public static ArrayList<String> correctAnswers = new ArrayList<>();
    public static ArrayList<String> mathQuestions = new ArrayList<>();
    public static ArrayList<String> mathQuestionsAnswers = new ArrayList<>();
    public static ArrayList<String> physicsQuestions = new ArrayList<>();
    public static ArrayList<String> physicsQuestionsAnswers = new ArrayList<>();
    public static ArrayList<String> superheroQuestions = new ArrayList<>();
    public static ArrayList<String> superheroQuestionsAnswers = new ArrayList<>();
    public static ArrayList<String> mathCorrectAnswers = new ArrayList<>();
    public static ArrayList<String> physicsCorrectAnswers = new ArrayList<>();
    public static ArrayList<String> superheroCorrectAnswers = new ArrayList<>();
    public static int totalCorrect;
    public static int numQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);


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

        physicsQuestionsAnswers.add("Newton");
        physicsQuestionsAnswers.add("Chingy");
        physicsQuestionsAnswers.add("Edgar Allan Poe");
        physicsQuestionsAnswers.add("None of the above");

        physicsQuestionsAnswers.add("e=mc^2");
        physicsQuestionsAnswers.add("v=d/t");
        physicsQuestionsAnswers.add("x^2");
        physicsQuestionsAnswers.add("Does Not Exist");

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

        Intent parentCall = getIntent();
        topic = parentCall.getStringExtra("topic");

        if(topic.equals("math")){
            questions = mathQuestions;
            answers = mathQuestionsAnswers;
            correctAnswers = mathCorrectAnswers;
        } else if(topic.equals("physics")){
            questions = physicsQuestions;
            answers = physicsQuestionsAnswers;
            correctAnswers = physicsCorrectAnswers;
        } else if(topic.equals("superhero")){
            questions = superheroQuestions;
            answers = superheroQuestionsAnswers;
            correctAnswers = superheroCorrectAnswers;
        }

        totalCorrect = 0;
        numQuestion = 0;

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
                    if (numQuestion == 0)
                        userAnswer = answers.get(0);
                    else {
                        userAnswer = answers.get(4);
                    }

                }
                break;
            case R.id.answer2:
                if (checked) {
                    if (numQuestion == 0)
                        userAnswer = answers.get(1);
                    else
                        userAnswer = answers.get(5);
                }
                break;
            case R.id.answer3:
                if (checked) {
                    if (numQuestion == 0)
                        userAnswer = answers.get(2);
                    else
                        userAnswer = answers.get(6);
                }
                break;
            case R.id.answer4:
                if (checked) {
                    if (numQuestion == 0)
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

    /**
     * A placeholder fragment containing a simple view.
     */
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

            Button submit = (Button) rootView.findViewById(R.id.submitButton);
            final RadioGroup rb = (RadioGroup) rootView.findViewById(R.id.radiogroup);
            submit.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    if (rb.getCheckedRadioButtonId() > 0) {
                        if (correctAnswers.get(numQuestion).equals(userAnswer)) {
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
            String corAns = correctAnswers.get(numQuestion);
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

            if(topic.equals("math")){
                title.setText("Math Overview");
                descrip.setText("Math Overview description goes right here. Wow this is an excellent overview. MATH!");
                numQ.setText("Number of questions: " + numQuestions);
            } else if(topic.equals("physics")){
                title.setText("Physics Overview");
                descrip.setText("Physics Overview description goes right here. Wow this is an excellent overview. PHYSICS!");
                numQ.setText("Number of questions: " + numQuestions);
            } else if(topic.equals("superhero")){
                title.setText("Marvel Super Hero Overview");
                descrip.setText("Marvel Superhero Overview description goes right here. Wow this is an excellent overview. SUPERHERO!");
                numQ.setText("Number of questions: " + numQuestions);
            }
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
