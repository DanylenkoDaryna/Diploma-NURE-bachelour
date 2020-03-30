package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answers")
public class Ansver implements Serializable {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answerId;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "answer_true")
    private int answerTrue;

    public Ansver(){
        this.setAnswerId(0);
        this.setQuestionId(0);
        this.setAnswerTrue(0);
    }

    public Ansver(int AnswerId, int QuestionId, int AnswerTrue){
        this.setAnswerId(AnswerId);
        this.setQuestionId(QuestionId);
        this.setAnswerTrue(AnswerTrue);
    }

    @Override
    public String toString() {
        return "Ansver{" +
                "answerId=" + answerId +
                ", questionId=" + questionId +
                ", answerTrue=" + answerTrue +
                '}';
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(int answerTrue) {
        this.answerTrue = answerTrue;
    }
}
