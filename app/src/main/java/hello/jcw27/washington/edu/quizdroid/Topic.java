package hello.jcw27.washington.edu.quizdroid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Julie on 2/13/15.
 */
public class Topic implements Serializable{

    private String topic;
    private String description;
    private ArrayList<Quiz> questionList = new ArrayList<>();

    public Topic(){}

    public void setTopic(String topic){
        this.topic = topic;
    }

    public String getTopic(){
        return topic;
    }

    public void setDescription(String description){
        this.description = description;
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
