package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.ResultAnsverDao;
import ua.nure.ki.cards.data.ResultAnsver;

import java.util.List;

public class ResultAnsverService {
    private ResultAnsverDao resultAnsverDao;

    public ResultAnsverService() {
        resultAnsverDao = new ResultAnsverDao();
    }

    public List<ResultAnsver> findBy(int resultId) {
        resultAnsverDao.openCurrentSession();
        List<ResultAnsver> resultAnsvers = resultAnsverDao.findBy(resultId);
        resultAnsverDao.closeCurrentSession();
        return resultAnsvers;
    }

    public ResultAnsverDao getResultAnsverDao() {
        return resultAnsverDao;
    }
}
