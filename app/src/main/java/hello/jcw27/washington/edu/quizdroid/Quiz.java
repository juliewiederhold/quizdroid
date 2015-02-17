package hello.jcw27.washington.edu.quizdroid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Julie on 2/13/15.
 */
public class Quiz implements Serializable {

    private String question;
    private int correctAnswer;
    private ArrayList<String> answerList = new ArrayList<>();

    public Quiz(){}

    public void setQuestion(String question){
        this.question = question;
    }

    public String getQuestion(){
        return question;
    }

    public void setCorrectAnswer(int num){
        this.correctAnswer = num;
    }

    public int getCorrectAnswer(){
        return correctAnswer;
    }

    public ArrayList<String> getAnswerList(){
        return answerList;
    }

    public void addAnswer(String answer){
        answerList.add(answer);
    }
}
