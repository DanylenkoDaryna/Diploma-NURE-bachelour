package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "questions")
public class Question implements Serializable {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;
    @Column(name = "topic_id")
    private int topicId;
    @Column(name = "question_difficulty")
    private int questionDifficulty;

public Question(){
        this.setQuestionId(0);
        this.setTopicId(0);
        this.setQuestionDifficulty(0);
    }

    public Question(int QuestionId, int TopicId, int QuestionDifficulty){
        this.setQuestionId(QuestionId);
        this.setTopicId(TopicId);
        this.setQuestionDifficulty(QuestionDifficulty);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", topicId=" + topicId +
                ", questionDifficulty=" + questionDifficulty +
                '}';
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(int questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }



}
