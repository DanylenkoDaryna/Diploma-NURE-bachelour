package ua.nure.ki.cards.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
