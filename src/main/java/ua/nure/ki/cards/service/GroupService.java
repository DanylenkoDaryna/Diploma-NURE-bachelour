package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.GroupDao;
import ua.nure.ki.cards.data.Group;

import java.util.List;

public class GroupService {

    private static GroupDao groupDao;

    public GroupService() {
        groupDao = new GroupDao();
    }


    public Group findById(Integer id) {
        groupDao.openCurrentSession();
        Group group = (Group)groupDao.findById(id);
        groupDao.closeCurrentSession();
        return group;
    }

    public List<Group> findAll() {
        groupDao.openCurrentSession();
        List<Group> groups = groupDao.findAll();
        groupDao.closeCurrentSession();
        return groups;
    }

    public List<Group> findAllbyId(int id) {
        groupDao.openCurrentSession();
        List<Group> groups = groupDao.findAllbyId(id);
        groupDao.closeCurrentSession();
        return groups;
    }

    public static GroupDao getGroupDao() {
        return groupDao;
    }
}
