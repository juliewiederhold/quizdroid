package hello.jcw27.washington.edu.quizdroid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Julie on 2/13/15.
 */
public class Topic implements Serializable{

    private String topic;
    private String descriptionLong;
    private String descriptionShort;
    private int currentQuestionUserIsOn = 0;
    private ArrayList<Quiz> questionList = new ArrayList<>();

    public Topic(){}

    public int getCurrentQuestionUserIsOn(){
        return currentQuestionUserIsOn;
    }

    public int setCurrentQuestionUserIsOn(int num){
        currentQuestionUserIsOn = num;
        return currentQuestionUserIsOn;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public String getTopic(){
        return topic;
    }

    public void setDescription(String description){
        this.descriptionLong = description;
    }

    public String getDescription(){
        return descriptionLong;
    }

    public void setDescriptionShort(String description){
        this.descriptionShort = description;
    }

    public String getDescriptionShort(){
        return descriptionShort;
    }


    public int totalQuestions(){
        return questionList.size();
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
