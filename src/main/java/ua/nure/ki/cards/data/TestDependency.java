package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_dependencies")
public class TestDependency implements Serializable {

    @Id
    @Column(name = "dependency_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dependencyId;
    @Column(name = "test_id")
    private int testId;
    @Column(name = "dependency_of")
    private int dependencyOf;
    @Column(name = "weight")
    private int weight;

    public TestDependency(){

        this.setDependencyId(0);
        this.setTestId(0);
        this.setDependencyOf(0);
        this.setWeight(1);
    }

    public TestDependency(int DependencyId, int TestId, int DependencyOfId, int Weight){

        this.setDependencyId(DependencyId);
        this.setTestId(TestId);
        this.setDependencyOf(DependencyOfId);
        this.setWeight(Weight);
    }

    @Override
    public String toString() {
        return "TestDependency{" +
                "dependencyId=" + dependencyId +
                ", testId=" + testId +
                ", dependencyOf=" + dependencyOf +
                ", weight=" + weight +
                '}';
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getDependencyOf() {
        return dependencyOf;
    }

    public void setDependencyOf(int dependencyOf) {
        this.dependencyOf = dependencyOf;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
