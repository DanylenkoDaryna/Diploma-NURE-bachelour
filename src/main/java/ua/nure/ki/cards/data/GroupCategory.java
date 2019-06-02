package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group_categories")
public class GroupCategory implements Serializable {
    @Id
    @Column(name = "group_category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int grCategId;
    @Column(name = "group_category_name")
    private String grCategName;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "concreteCategory", cascade = CascadeType.ALL)
    private List<Group> groups=new ArrayList<Group>(3);


    public GroupCategory(){
         this.setGrCategId(0);
         this.setGrCategName("Standart group category");
         this.setGroups(new ArrayList<Group>(3));
     }

    public GroupCategory(int groupCategid, String groupCategName){
        this.setGrCategId(groupCategid);
        this.setGrCategName(groupCategName);
    }

    @Override
    public String toString() {
        return "GroupCategory{" +
                "gr_categ_id=" + getGrCategId() +
                ", gr_categ_name='" + getGrCategName() + '\'' +
                '}';
    }

    public int getGrCategId() {
        return grCategId;
    }

    public void setGrCategId(int grCategId) {
        this.grCategId = grCategId;
    }

    public String getGrCategName() {
        return grCategName;
    }

    public void setGrCategName(String grCategName) {
        this.grCategName = grCategName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
