package hello.jcw27.washington.edu.quizdroid;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Julie on 2/13/15.
 */
public class Quiz implements Serializable {

    private String question;
    private String correctAnswer;
    private ArrayList<String> answerList = new ArrayList<>();

    public Quiz(String question, String correctAnswer, String answer1, String answer2, String answer3){
        this.question = question;
        this.correctAnswer = correctAnswer;
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(correctAnswer);
        answerList.add(answer3);
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
}
