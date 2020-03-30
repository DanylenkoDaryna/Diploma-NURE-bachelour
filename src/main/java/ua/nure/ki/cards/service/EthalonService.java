package ua.nure.ki.cards.service;



import ua.nure.ki.cards.dao.EthalonDao;
import ua.nure.ki.cards.data.TestsEthalon;

import java.util.List;

public class EthalonService {

    private EthalonDao ethalonDao;

    public EthalonService() {
        ethalonDao = new EthalonDao();
    }

    public List<TestsEthalon> findBy(int questionId) {
        ethalonDao.openCurrentSession();
        List<TestsEthalon> ethalons = ethalonDao.findBy(questionId);
        ethalonDao.closeCurrentSession();
        return ethalons;
    }

    public int findMaxComplexity(int testId) {
        ethalonDao.openCurrentSession();
        int maxComplexity = ethalonDao.findMaxComplexity(testId);
        ethalonDao.closeCurrentSession();
        return maxComplexity;
    }

    public EthalonDao getEthalonDao() {
        return ethalonDao;
    }
}
