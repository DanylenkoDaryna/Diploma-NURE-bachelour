package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.GroupCategoryDao;
import ua.nure.ki.cards.data.GroupCategory;

import java.util.List;

public class GroupCategoryService {

    private static GroupCategoryDao groupCategoryDao;

    public GroupCategoryService() {
        groupCategoryDao = new GroupCategoryDao();
    }


    public GroupCategory findById(Integer id) {
        groupCategoryDao.openCurrentSession();
        GroupCategory groupCategory = (GroupCategory)groupCategoryDao.findById(id);
        groupCategoryDao.closeCurrentSession();
        return groupCategory;
    }

    public List<GroupCategory> findAll() {
        groupCategoryDao.openCurrentSession();
        List<GroupCategory> groupCategorys = groupCategoryDao.findAll();
        groupCategoryDao.closeCurrentSession();
        return groupCategorys;
    }

    public static GroupCategoryDao getGroupCategoryDao() {
        return groupCategoryDao;
    }

}
