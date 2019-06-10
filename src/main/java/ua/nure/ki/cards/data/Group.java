package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group implements Serializable {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;
//    @Column(name = "group_category_id")
//    private int grCategId;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_disable")
    private int groupDisable;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "concreteGroup", cascade = CascadeType.ALL)
    private List<User> users=new ArrayList<User>(5);

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "group_category_id")
    protected GroupCategory concreteCategory;


    {concreteCategory=new GroupCategory();}

    public Group(){
        this.setGroupId(0);
        //this.setGrCategId(0);
        this.setGroupName("Standart group");
        this.setGroupDisable(0);
    }

    public Group(int grId, /*int grCategId,*/ String grName, int grDisable){
        this.setGroupId(grId);
      //  this.setGrCategId(grCategId);
        this.setGroupName(grName);
        this.setGroupDisable(grDisable);
    }

    @Override
    public String toString() {
        return "" + getGroupName();
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

//    public int getGrCategId() {
//        return grCategId;
//    }
//
//    public void setGrCategId(int grCategId) {
//        this.grCategId = grCategId;
//    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupDisable() {
        return groupDisable;
    }

    public void setGroupDisable(int groupDisable) {
        this.groupDisable = groupDisable;
    }

    public List<User> getUsers() {         return users;     }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public GroupCategory getConcreteCategory() {
        return concreteCategory;
    }

    public void setConcreteCategory(GroupCategory concreteCategory) {
        this.concreteCategory = concreteCategory;
    }
}
