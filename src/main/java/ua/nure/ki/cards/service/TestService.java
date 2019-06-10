package ua.nure.ki.cards.service;



import ua.nure.ki.cards.dao.TestDao;
import ua.nure.ki.cards.data.Test;

import java.util.List;

public class TestService {

    private static TestDao testDao;

    public TestService() {
        testDao = new TestDao();
    }


    public Test findById(Integer id) {
        testDao.openCurrentSession();
        Test test = (Test)testDao.findById(id);
        testDao.closeCurrentSession();
        return test;
    }

    public List<Test> findAll() {
        testDao.openCurrentSession();
        List<Test> tests = testDao.findAll();
        testDao.closeCurrentSession();
        return tests;
    }

    public List<Test> findAllbyId(int id) {
        testDao.openCurrentSession();
        List<Test> tests = testDao.findAllbyId(id);
        testDao.closeCurrentSession();
        return tests;
    }

    public static TestDao getTestDao() {
        return testDao;
    }

}
