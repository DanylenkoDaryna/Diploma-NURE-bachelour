package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test_categories")
public class TestCategory implements Serializable {
    @Id
    @Column(name = "test_category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int testCategId;
    @Column(name = "test_category_name")
    private String testCategName;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "TestCategory", cascade = CascadeType.ALL)
    private List<Test> tests = new ArrayList<Test>(10);

    public TestCategory(){
        this.setTestCategId(0);
        this.setTestCategName("Standart test category");
    }

    public TestCategory(int testCategId, String testCategName){
        this.setTestCategId(testCategId);
        this.setTestCategName(testCategName);
    }

    @Override
    public String toString() {
        return "TestCategory{" +
                "testCategId=" + getTestCategId() +
                ", testCategName='" + getTestCategName() + '\'' +
                "} \n";
    }

    public int getTestCategId() {
        return testCategId;
    }

    public void setTestCategId(int testCategId) {
        this.testCategId = testCategId;
    }

    public String getTestCategName() {
        return testCategName;
    }

    public void setTestCategName(String testCategName) {
        this.testCategName = testCategName;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
