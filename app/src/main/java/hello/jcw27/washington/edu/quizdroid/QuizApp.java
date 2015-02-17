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
        math.setDescriptionShort("The subject everyone hates.");

        Quiz mq1 = new Quiz();
        mq1.setQuestion("1 + 1 = ?");

        mq1.addAnswer("2");
        mq1.addAnswer("0");
        mq1.addAnswer("7");
        mq1.addAnswer("i");
        mq1.setCorrectAnswer(0);

        Quiz mq2 = new Quiz();
        mq2.setQuestion("6 + 4 = ?");

        mq2.addAnswer("7");
        mq2.addAnswer("10");
        mq2.addAnswer("12");
        mq2.addAnswer("6");
        mq2.setCorrectAnswer(1);

        math.addQuestion(mq1);
        math.addQuestion(mq2);
        topicList.add(math);

        Topic physics = new Topic();
        physics.setTopic("Physics");
        physics.setDescription("Physics Overview description goes right here. Wow this is an excellent overview. PHYSICS!");
        physics.setDescriptionShort("Even worse than math.");

        Quiz pq1 = new Quiz();
        pq1.setQuestion("Who came up with Newtons 3 laws of physics?");

        pq1.addAnswer("Edgar Allen Poe");
        pq1.addAnswer("Chingy");
        pq1.addAnswer("None of the above");
        pq1.addAnswer("Newton");
        pq1.setCorrectAnswer(3);


        Quiz pq2 = new Quiz();
        pq2.setQuestion("What is the equation for velocity");

        pq2.addAnswer("e=mc^2");
        pq2.addAnswer("x^2");
        pq2.addAnswer("v=d/t");
        pq2.addAnswer("Does not Exist");
        pq2.setCorrectAnswer(2);

        physics.addQuestion(pq1);
        physics.addQuestion(pq2);

        topicList.add(physics);

        Topic superhero = new Topic();
        superhero.setTopic("Marvel Super Heroes");
        superhero.setDescription("Marvel Super Hero Overview description goes right here. Wow this is an excellent overview. SUPERHERO!");
        superhero.setDescriptionShort("Making spandex cool since 1939");

        Quiz sq1 = new Quiz();
        sq1.setQuestion("Which of these is a superhero?");

        sq1.addAnswer("Superman");
        sq1.addAnswer("Cartman");
        sq1.addAnswer("Big Bird");
        sq1.addAnswer("Potato Man");
        sq1.setCorrectAnswer(0);


        Quiz sq2 = new Quiz();
        sq2.setQuestion("Which of these is not superhero?");

        sq2.addAnswer("Regina George");
        sq2.addAnswer("The Flash");
        sq2.addAnswer("Superman");
        sq2.addAnswer("BATMAN");
        sq2.setCorrectAnswer(2);

        superhero.addQuestion(sq1);
        superhero.addQuestion(sq2);
        topicList.add(superhero);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        initialize();
        Log.i("QuizApp", "QuizApp is accessed");
    }

    public void setCurrTopic(int num){
        this.currTopic = num;
    }

    public String getTopicAt(int num){
        return topicList.get(num).getTopic();

    }

    public void setCorrectAnswer(int num){
        getQuestion(topicList.get(currTopic).totalQuestions()).setCorrectAnswer(num);
    }

    public String getCorrectAnswer(){
        return getQuestion(topicList.get(currTopic).totalQuestions()).getCorrectAnswer();
    }

    public ArrayList<String> getAnswerList(){
        return getQuestion(getCurrentQuestionUserIsOn()).getAnswerList();
    }

    public void setTopic(String topic){
        topicList.get(currTopic).setTopic(topic);
    }

    public String getTopic(){
        return topicList.get(currTopic).getTopic();
    }

    public void setDescription(String description){
        topicList.get(currTopic).setDescription(description);
    }

    public String getDescription(){
        return topicList.get(currTopic).getDescription();
    }

    /*public void setQuestion(String question){
        topicList.get(currTopic).getQuestion(totalQuestions()).setQuestion(question);
    }*/

    public void addQuestion(Quiz question){
        topicList.get(currTopic).addQuestion(question);
    }

    public int getCurrentQuestionUserIsOn(){
        return topicList.get(currTopic).getCurrentQuestionUserIsOn();
    }

    public int setCurrentQuestionUserIsOn(int num){
        return topicList.get(currTopic).setCurrentQuestionUserIsOn(num);
    }

    public int totalQuestions(){
        return topicList.get(currTopic).totalQuestions();
    }

    public Quiz getQuestion(int index){
        return topicList.get(currTopic).getQuestion(index);
    }

    public ArrayList<Quiz> getQuestionList() {
        return topicList.get(currTopic).getQuestionList();
    }

    /*public void addAnswer(String answer){
        topicList.get(currTopic).getQuestion(totalQuestions()).addAnswer(answer);
    }*/

    public String getDescriptionShortAt(int num){
        return topicList.get(num).getDescriptionShort();
    }

    public void setDescriptionShort(String descriptionShort){
         topicList.get(currTopic).setDescriptionShort(descriptionShort);
    }
}
