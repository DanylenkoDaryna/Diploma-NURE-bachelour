package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.ResultDao;
import ua.nure.ki.cards.data.Result;
import java.util.List;

public class ResultService {

       private ResultDao resultDao;

    public ResultService() {
        resultDao = new ResultDao();
    }


    public Result findById(Integer id) {
        getResultDao().openCurrentSession();
        Result result = (Result)resultDao.findById(id);
        resultDao.closeCurrentSession();
        return result;
    }

    public List<Result> findAll() {
        resultDao.openCurrentSession();
        List<Result> results = resultDao.findAll();
        resultDao.closeCurrentSession();
        return results;
    }

    public List<Result> findAllby(int groupId, int userId, int testId) {
        resultDao.openCurrentSession();
        List<Result> results = resultDao.findAllby(groupId,userId,testId);
        resultDao.closeCurrentSession();
        return results;
    }

    public ResultDao getResultDao() {
        return resultDao;
    }

}
