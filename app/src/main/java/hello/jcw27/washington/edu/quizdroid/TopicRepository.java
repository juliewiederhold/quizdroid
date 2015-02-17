package hello.jcw27.washington.edu.quizdroid;

import java.util.ArrayList;

/**
 * Created by Julie on 2/16/15.
 */
public interface TopicRepository {

    public String getQuestion();

    public String getCorrectAnswer();

    public String toString();

    public ArrayList<String> getAnswerList();

    public String getTopic();

    public String getDescription();

    public void addQuestion(Quiz question);

    public Quiz getQuestion(int index);

    public ArrayList<Quiz> getQuestionList();
}
