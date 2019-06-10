package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.TestCategoryDao;
import ua.nure.ki.cards.data.TestCategory;

import java.util.List;

public class TestCategoryService {

    private static TestCategoryDao testCategoryDao;

    public TestCategoryService() {
        testCategoryDao = new TestCategoryDao();
    }

    public TestCategory findById(Integer id) {
        testCategoryDao.openCurrentSession();
        TestCategory testCategory = (TestCategory)testCategoryDao.findById(id);
        testCategoryDao.closeCurrentSession();
        return testCategory;
    }

    public List<TestCategory> findAll() {
        testCategoryDao.openCurrentSession();
        List<TestCategory> testCategorys = testCategoryDao.findAll();
        testCategoryDao.closeCurrentSession();
        return testCategorys;
    }

    public static TestCategoryDao getTestCategoryDao() {

        return testCategoryDao;
    }
}
