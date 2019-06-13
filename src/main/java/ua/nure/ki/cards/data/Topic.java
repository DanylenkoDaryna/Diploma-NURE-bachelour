package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "topics")
public class Topic implements Serializable {

    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int topicId;
    @Column(name = "topic_name")
    private String topicName;
    @Column(name = "test_id")
    private int testId;
    @Column(name = "topic_disable")
    private int disable;

    public Topic(){
        this.setTopicId(0);
        this.setTopicName("Standard Topic Name");
        this.setTestId(0);
        this.setDisable(0);
    }

    public Topic(int TopicId, String TopicName, int TestId, int dis){
        this.setTopicId(TopicId);
        this.setTopicName(TopicName);
        this.setTestId(TestId);
        this.setDisable(dis);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", testId=" + testId +
                '}';
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getDisable() {
        return disable;
    }

    public void setDisable(int disable) {
        this.disable = disable;
    }


}
