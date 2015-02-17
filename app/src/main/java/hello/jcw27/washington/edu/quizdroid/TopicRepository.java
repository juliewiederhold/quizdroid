package hello.jcw27.washington.edu.quizdroid;

import java.util.ArrayList;

/**
 * Created by Julie on 2/16/15.
 */
public interface TopicRepository {
    public int getCurrentQuestionUserIsOn();

    public int setCurrentQuestionUserIsOn(int num);

    public void setCorrectAnswer(int num);

    public String getCorrectAnswer();

    public ArrayList<String> getAnswerList();

    //public void addAnswer(String answer);

    public void setTopic(String topic);

    public String getTopic();

    public void setDescription(String description);

    public String getDescription();

    public int totalQuestions();

    public void addQuestion(Quiz question);

    //public void setQuestion(String question);

    public Quiz getQuestion(int index);

    public ArrayList<Quiz> getQuestionList();

    public String getDescriptionShort();
}
