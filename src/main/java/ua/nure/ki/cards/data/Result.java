package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "results")
public class Result implements Serializable {
    @Id
    @Column(name = "result_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resultId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "test_id")
    private int testId;
    @Column(name = "group_id")
    private int groupId;
    @Column(name = "teacher_id")
    private int teacherId;
    @Column(name = "mark")
    private int mark;
    @Column(name = "start_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime startDateTime;
    @Column(name = "stop_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime stopDatetime;
    @Column(name = "time_of_test")
    private int timeOfTest;
    @Column(name = "average_alternative")
    private float averageAlternative;
    @Column(name = "percent")
    private float percent;
    @Column(name = "percent_simple")
    private float percentSimple;
    @Column(name = "hide_result")
    private int hideResult;
    @Column(name = "total_unit")
    private float totalUnit;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    protected User concreteUser;//connection of concrete result and concrete user for db

    {concreteUser=new User();}

    /* инфа будет о результатах*/

    private Result(){
        this.setResultId(0);
        this.setUserId(0);
        this.setTestId(0);
        this.setGroupId(0);
        this.setTeacherId(0);
        this.setMark(0);
        this.setStartDateTime(LocalDateTime.now());
        this.setStopDatetime(LocalDateTime.now());
        this.setTimeOfTest(0);
        this.setAverageAlternative(0);
        this.setPercent(0);
        this.setPercentSimple(0);
        this.setHideResult(0);
        this.setTotalUnit(0);
    }

    private Result(int ResultId, int UserId, int TestId, int GroupId, int TeacherId ,int Mark,LocalDateTime start,
                   LocalDateTime stop, int TimeOfTest,float Average,float Percent, float PercentSimple,int HideResult, float TotalUnit ){
        this.setResultId(ResultId);
        this.setUserId(UserId);
        this.setTestId(TestId);
        this.setGroupId(GroupId);
        this.setTeacherId(TeacherId);
        this.setMark(Mark);
        this.setStartDateTime(start);
        this.setStopDatetime(stop);
        this.setTimeOfTest(TimeOfTest);
        this.setAverageAlternative(Average);
        this.setPercent(Percent);
        this.setPercentSimple(PercentSimple);
        this.setHideResult(HideResult);
        this.setTotalUnit(TotalUnit);
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", userId=" + userId +
                ", testId=" + testId +
                ", groupId=" + groupId +
                ", teacherId=" + teacherId +
                ", mark=" + mark +
                ", startDateTime=" + startDateTime +
                ", stopDatetime=" + stopDatetime +
                ", timeOfTest=" + timeOfTest +
                ", averageAlternative=" + averageAlternative +
                ", percent=" + percent +
                ", percentSimple=" + percentSimple +
                ", hideResult=" + hideResult +
                ", totalUnit=" + totalUnit +
                '}';
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getStopDatetime() {
        return stopDatetime;
    }

    public void setStopDatetime(LocalDateTime stopDatetime) {
        this.stopDatetime = stopDatetime;
    }

    public int getTimeOfTest() {
        return timeOfTest;
    }

    public void setTimeOfTest(int timeOfTest) {
        this.timeOfTest = timeOfTest;
    }

    public float getAverageAlternative() {
        return averageAlternative;
    }

    public void setAverageAlternative(float averageAlternative) {
        this.averageAlternative = averageAlternative;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public float getPercentSimple() {
        return percentSimple;
    }

    public void setPercentSimple(float percentSimple) {
        this.percentSimple = percentSimple;
    }

    public Integer getHideResult() {
        return hideResult;
    }

    public void setHideResult(Integer hideResult) {
        this.hideResult = hideResult;
    }

    public float getTotalUnit() {
        return totalUnit;
    }

    public void setTotalUnit(float totalUnit) {
        this.totalUnit = totalUnit;
    }

    public User getConcreteUser() {
        return concreteUser;
    }

    public void setConcreteUser(User concreteUser) {
        this.concreteUser = concreteUser;
    }
}
