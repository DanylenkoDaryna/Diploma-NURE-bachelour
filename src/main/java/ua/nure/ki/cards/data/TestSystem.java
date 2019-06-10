package ua.nure.ki.cards.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestSystem implements Serializable {

    private List<GroupCategory> SysGroupCategories;
    private List<TestCategory> SysTestCategories;

    public TestSystem(){
        setSysGroupCategories(new ArrayList<GroupCategory>(3));
        setSysTestCategories(new ArrayList<TestCategory>(3));
    }

    public TestSystem(ArrayList<GroupCategory> gc, ArrayList<TestCategory> tc){
        setSysGroupCategories(gc);
        setSysTestCategories(tc);
    }

    public void outputAllCroupCategories(){

        for(int i =0; i<getSysGroupCategories().size(); i++){
            System.out.println(getSysGroupCategories().get(i).getGrCategName() + " " +
                    getSysGroupCategories().get(i).getGrCategId() + " \n");
        }
    }

    public List<GroupCategory> getSysGroupCategories() {
        return SysGroupCategories;
    }

    public void setSysGroupCategories(List<GroupCategory> sysGroupCategories) {
        SysGroupCategories = sysGroupCategories;
    }

    public List<TestCategory> getSysTestCategories() {
        return SysTestCategories;
    }

    public void setSysTestCategories(List<TestCategory> sysTestCategories) {
        SysTestCategories = sysTestCategories;
    }
}
