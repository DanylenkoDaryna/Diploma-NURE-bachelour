package ua.nure.ki.cards.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
//    @Column(name = "group_id")
//    private int groupId;
    @Column(name = "user_name")
    private String fullUsername;

   // private Username fio= new Username();

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "concreteUser", cascade = CascadeType.ALL)
    private List<Result> results=new ArrayList<Result>(4);

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL) @JoinColumn(name = "group_id")
    protected Group concreteGroup;

//    private class Username{
//
//        private String uSurName;
//        private String uName;
//        private String uMiddleName;
//
//        private Username(){
//            this.uSurName="";
//            this.uName="";
//            this.uMiddleName="";
//        }
//
//        private Username(String sName, String name, String mName){
//            this.setuSurName(sName);
//            this.setuName(name);
//            this.setuMiddleName(mName);
//        }
//
//        @Override
//        public String toString() {
//            return "Username{ "
//                     + uSurName + ' ' + uName + ' ' +
//                    uMiddleName + ' ' +
//                    '}';
//        }
//
//        String getuSurName() {
//            return uSurName;
//        }
//        public void setuSurName(String uSurName) {
//            this.uSurName = uSurName;
//        }
//
//        String getuName() {
//            return uName;
//        }
//        public void setuName(String uName) {
//            this.uName = uName;
//        }
//        String getuMiddleName() {
//            return uMiddleName;
//        }
//        public void setuMiddleName(String uMiddleName) {
//            this.uMiddleName = uMiddleName;
//        }
//    }

    {   concreteGroup=new Group();    }

    public User(){
        this.setUserId(0);
      //  this.setGroupId(0);
        this.setFullUesrname("Stndart username Pupkin");
    }

    public User(int uId, /*int groupId,*/ String uName){
        this.setUserId(uId);
       // this.setGroupId(groupId);
        this.setFullUesrname(uName);
        //convertStringIntoUsername(uName);
    }

//    public User(int uId, int groupId, String uName/*, String uSurName, String uMiddleName*/){
//        this.setUserId(uId);
//        this.setGroupId(groupId);
//
//        //this.setFio(new Username(uSurName,uName,uMiddleName));
//    }

    @Override
    public String toString() {
        return "" + getFullUsername();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public int getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(int groupId) {
//        this.groupId = groupId;
//    }

    public String getFullUsername() {
        return fullUsername;
    }

    public void setFullUesrname(String fullUesrname) {
        this.fullUsername = fullUesrname;
    }

//    public Username getFio() {
//        return fio;
//    }
//    public void setFio(Username fio) {
//        this.fio = fio;
//    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Group getConcreteGroup() {
        return concreteGroup;
    }

    public void setConcreteGroup(Group concreteGroup) {
        this.concreteGroup = concreteGroup;
    }

//    private void convertStringIntoUsername(String fullUsername){
//
//        String[] subStr = fullUsername.split(" ");
//        getFio().setuSurName(subStr[0]);
//        getFio().setuName(subStr[1]);
//        getFio().setuMiddleName(subStr[2]);
//
//    }
}
