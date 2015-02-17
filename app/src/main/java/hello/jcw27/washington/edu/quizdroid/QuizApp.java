package hello.jcw27.washington.edu.quizdroid;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class QuizApp extends Application implements TopicRepository
{
    private ArrayList<Topic> topicList = new ArrayList<>();
    private int currTopic;

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
        Topic math = new Topic("Math", "Math Overview description goes right here. Wow this is an excellent overview. MATH!");
        math.addQuestion(new Quiz("1 + 1 = ?", "2", "0", "7", "i"));
        math.addQuestion(new Quiz("4 + 6 = ?", "10", "7", "12", "6"));
        topicList.add(math);


        Topic physics = new Topic("Physics", "Physics Overview description goes right here. Wow this is an excellent overview. PHYSICS!");
        physics.addQuestion(new Quiz("Who came up with Newtons 3 laws of physics?",
                    "Newton", "Chingy", "Edgar Allen Poe", "None of the above"));
        physics.addQuestion(new Quiz("What is the equation for velocity", "v=d/t", "e=c^2", "x^2", "Does not Exist"));
        topicList.add(physics);

        Topic superhero = new Topic("Marvel Super Heroes", "Marvel Super Hero Overview description goes right here. Wow this is an excellent overview. SUPERHERO!");
        superhero.addQuestion(new Quiz("Which of these is a superhero?", "Superman", "Cartman", "Big Bird", "Potato Man"));
        superhero.addQuestion(new Quiz("Which of these is not superhero?", "Regina George", "The Flash", "Superman", "BATMAN"));
        topicList.add(superhero);
    }

    public void setCurrTopic(int num){
        this.currTopic = num;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.i("QuizApp", "QuizApp is accessed");
    }

    public String getQuestion(){
        return question;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public String toString(){
        return question;
    }

    public ArrayList<String> getAnswerList(){
        return answerList;
    }

    public String getTopic(){
        return this.topicarray.get(currTopic).get;
    }

    public String getDescription(){
        return description;
    }

    public void addQuestion(Quiz question){
        questionList.add(question);
    }

    public Quiz getQuestion(int index){
        return questionList.get(index);
    }

    public ArrayList<Quiz> getQuestionList(){
        return questionList;
    }
}
