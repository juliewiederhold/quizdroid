package hello.jcw27.washington.edu.quizdroid;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class QuizApp extends Application implements TopicRepository
{
    private ArrayList<Topic> topicList = new ArrayList<>();
    private int currTopic;
    private int numQuestion;

    private static QuizApp instance;
    public QuizApp()
    {
        if (instance == null){
            instance = this;
            initialize();
        }
        else {
            Log.e("QuizApp", "MORE THAN ONE CONSTRUCTED!");
            throw new RuntimeException("Multiple app exception");
        }
    }

    public static QuizApp getInstance() {
        return instance;
    }

    public void initialize(){
        Topic math = new Topic();
        math.setTopic("Math");
        math.setDescription("Math Overview description goes right here. Wow this is an excellent overview. MATH!");

        Quiz mq1 = new Quiz();
        mq1.setQuestion("1 + 1 = ?");

        mq1.addAnswer("2");
        mq1.addAnswer("0");
        mq1.addAnswer("7");
        mq1.addAnswer("i");
        mq1.setCorrectAnswer(0);
        math.addQuestion(mq1);

        Quiz mq2 = new Quiz();
        mq2.setQuestion("6 + 4 = ?");

        mq2.addAnswer("7");
        mq2.addAnswer("10");
        mq2.addAnswer("12");
        mq2.addAnswer("6");
        mq2.setCorrectAnswer(1);
        math.addQuestion(mq2);
        topicList.add(math);


        Topic physics = new Topic();
        physics.setTopic("Physics");
        physics.setDescription("Physics Overview description goes right here. Wow this is an excellent overview. PHYSICS!");

        Quiz pq1 = new Quiz();
        pq1.setQuestion("Who came up with Newtons 3 laws of physics?");

        pq1.addAnswer();
        pq1.addAnswer("Chingy");
        pq1.addAnswer("7");
        pq1.addAnswer("Newton");
        pq1.setCorrectAnswer(4);
        physics.addQuestion(pq1);

        Quiz pq2 = new Quiz();
        pq2.setQuestion("What is the equation for velocity");

        pq2.addAnswer("7");
        pq2.addAnswer("10");
        pq2.addAnswer("12");
        pq2.addAnswer("6");
        pq2.setCorrectAnswer(1);
        physics.addQuestion(pq2);

        physics.addQuestion(new Quiz(
                    , "Chingy", "Edgar Allen Poe", "None of the above"));
        physics.addQuestion(new Quiz(, "v=d/t", "e=c^2", "x^2", "Does not Exist"));
        topicList.add(physics);

        Topic superhero = new Topic();
        superhero.setTopic("Marvel Super Heroes");
        superhero.setDescription("Marvel Super Hero Overview description goes right here. Wow this is an excellent overview. SUPERHERO!");
        superhero.addQuestion(new Quiz("Which of these is a superhero?", "Superman", "Cartman", "Big Bird", "Potato Man"));
        superhero.addQuestion(new Quiz("Which of these is not superhero?", "Regina George", "The Flash", "Superman", "BATMAN"));
        topicList.add(superhero);
    }

    public void setCurrTopic(int num){
        this.currTopic = num;
    }

    public void setNumQuestion(int num){
        this.numQuestion = num;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.i("QuizApp", "QuizApp is accessed");
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public ArrayList<String> getAnswerList(){
        return getQuestion(numQuestion).getAnswerList();
    }

    public String getTopic(){
        return topicList.get(currTopic).getTopic();
    }

    public String getDescription(){
        return topicList.get(currTopic).getDescription();
    }

    public void addQuestion(Quiz question){
        topicList.get(currTopic).addQuestion(question);
    }

    public Quiz getQuestion(int index){
        return topicList.get(currTopic).getQuestion(index);
    }

    public ArrayList<Quiz> getQuestionList(){
        return topicList.get(currTopic).getQuestionList();
    }
}
