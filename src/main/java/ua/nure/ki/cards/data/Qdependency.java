package ua.nure.ki.cards.data;

import javax.persistence.*;

@Entity
@Table(name = "question_dependencies")
public class Qdependency {

    @Id
    @Column(name = "dependency_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dependencyId;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "dependence_id")
    private int dependenceOfId;
    @Column(name = "weight")
    private int weight;

    public Qdependency(){
        this.setDependencyId(0);
        this.setQuestionId(0);
        this.setDependenceOfId(0);
        this.setWeight(1);
    }

    public Qdependency(int DependencyId, int QuestionId, int DependenceOfId, int Weight){
        this.setDependencyId(DependencyId);
        this.setQuestionId(QuestionId);
        this.setDependenceOfId(DependenceOfId);
        this.setWeight(Weight);
    }

    @Override
    public String toString() {
        return "Qdependency{" +
                "dependencyId=" + dependencyId +
                ", questionId=" + questionId +
                ", dependenceOfId=" + dependenceOfId +
                ", weight=" + weight +
                '}';
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getDependenceOfId() {
        return dependenceOfId;
    }

    public void setDependenceOfId(int dependenceOfId) {
        this.dependenceOfId = dependenceOfId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
