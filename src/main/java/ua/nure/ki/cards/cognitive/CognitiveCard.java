package ua.nure.ki.cards.cognitive;

import ua.nure.ki.cards.data.Test;

import java.util.ArrayList;
import java.util.List;

public class CognitiveCard {

    private int cardId;
    private int userId;

    private List<Test> course;

    private int complexity;
    private int importance;
    private Relation cardRelations;

    public CognitiveCard(){
            setCardId(0);
            setUserId(0);
            setCourse(new ArrayList<>(3));
            setComplexity(0);
            setImportance(0);
            setCardRelations(new Relation());
    }

    public CognitiveCard(int card_id, int user_id, List<Test> tests, int complex, int important, Relation relations){
        setCardId(card_id);
        setUserId(user_id);
        setCourse(tests);
        setComplexity(complex);
        setImportance(important);
        setCardRelations(relations);
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Test> getCourse() {
        return course;
    }

    public void setCourse(List<Test> course) {
        this.course = course;
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

    public void setImportance(int imp) {
        importance = imp;
    }

    public Relation getCardRelations() {
        return cardRelations;
    }

    public void setCardRelations(Relation cardRelations) {
        this.cardRelations = cardRelations;
    }

}
