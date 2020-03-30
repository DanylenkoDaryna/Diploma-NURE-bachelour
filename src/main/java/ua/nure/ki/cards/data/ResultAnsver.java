package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "results_answers")
public class ResultAnsver implements Serializable {

    @Id
    @Column(name = "ra_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resultAnsverId;
    @Column(name = "result_id")
    private int resultId;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "answer_id")
    private int answerId;

    public ResultAnsver(){
        this.setResultAnsverId(0);
        this.setResultId(0);
        this.setQuestionId(0);
        this.setAnswerId(0);
    }

    public ResultAnsver(int resultAnsverId, int resultId, int questionId, int answerId){
        this.setResultAnsverId(resultAnsverId);
        this.setResultId(resultId);
        this.setQuestionId(questionId);
        this.setAnswerId(answerId);
    }

    @Override
    public String toString() {
        return "ResultAnsver{" +
                "resultAnsverId=" + resultAnsverId +
                ", resultId=" + resultId +
                ", questionId=" + questionId +
                ", answerId=" + answerId +
                '}';
    }

    public int getResultAnsverId() {
        return resultAnsverId;
    }

    public void setResultAnsverId(int resultAnsverId) {
        this.resultAnsverId = resultAnsverId;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
