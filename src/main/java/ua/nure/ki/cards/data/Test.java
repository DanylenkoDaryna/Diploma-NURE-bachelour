package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tests")
public class Test implements Serializable {

    @Id
    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int testId;
    @Column(name = "test_category_id")
    private int testCategId;
    @Column(name = "test_name")
    private String testName;
    @Column(name = "test_disable")
    private int testDisable;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "test_category_id")
    protected TestCategory concreteTestCategory;

    {concreteTestCategory=new TestCategory();}

    public Test(){
        this.setTestId(0);
        this.setTestCategId(0);
        this.setTestName("Standart test");
        this.setTestDisable(0);
    }

    public Test(int tId, int tCategId, String tName, int tDisabl){
        this.setTestId(tId);
        this.setTestCategId(tCategId);
        this.setTestName(tName);
        this.setTestDisable(tDisabl);
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", testCategId=" + testCategId +
                ", testName='" + testName  +
                ", testDisable='" + testDisable +'}';
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getTestCategId() {
        return testCategId;
    }

    public void setTestCategId(int testCategId) {
        this.testCategId = testCategId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestDisable() {
        return testDisable;
    }

    public void setTestDisable(int testDisable) {
        this.testDisable = testDisable;
    }

    public TestCategory getConcreteTestCategory() {
        return concreteTestCategory;
    }

    public void setConcreteTestCategory(TestCategory concreteTestCategory) {
        this.concreteTestCategory = concreteTestCategory;
    }
}
