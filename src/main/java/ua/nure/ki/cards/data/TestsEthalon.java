package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tests_ethalon")
public class TestsEthalon implements Serializable {

    @Id
    @Column(name = "ethalon_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ethalonId;
    @Column(name = "test_id")
    private int testId;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "complexity")
    private int complexity;
    @Column(name = "importance")
    private int importance;

    public TestsEthalon(){
        this.setEthalonId(0);
        this.setTestId(0);
        this.setQuestionId(0);
        this.setComplexity(1);
        this.setImportance(1);
    }

    public TestsEthalon(int EthalonId, int TestId, int QuestionId, int Complexity, int Importance){
        this.setEthalonId(EthalonId);
        this.setTestId(TestId);
        this.setQuestionId(QuestionId);
        this.setComplexity(Complexity);
        this.setImportance(Importance);
    }

    @Override
    public String toString() {
        return "TestsEthalon{" +
                "ethalonId=" + ethalonId +
                ", testId=" + testId +
                ", questionId=" + questionId +
                ", complexity=" + complexity +
                ", importance=" + importance +
                '}';
    }

    public int getEthalonId() {
        return ethalonId;
    }

    public void setEthalonId(int ethalonId) {
        this.ethalonId = ethalonId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

}
