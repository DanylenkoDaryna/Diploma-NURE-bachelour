package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.TdependencyDao;
import ua.nure.ki.cards.data.TestDependency;

import java.util.List;

public class TdependencyServie {
    private TdependencyDao tdependencyDao;

    public TdependencyServie() {
        tdependencyDao = new TdependencyDao();
    }

    public List<TestDependency> findBy(int testId) {
        tdependencyDao.openCurrentSession();
        List<TestDependency> depends = tdependencyDao.findBy(testId);
        tdependencyDao.closeCurrentSession();
        return depends;
    }

    public TdependencyDao getTdependencyDao() {
        return tdependencyDao;
    }
}
