package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.QdependencyDao;
import ua.nure.ki.cards.data.Qdependency;

import java.util.List;

public class QdependencyService {
    private QdependencyDao qdependencyDao;

    public QdependencyService() {
        qdependencyDao = new QdependencyDao();
    }

    public List<Qdependency> findBy(int questionId) {
        qdependencyDao.openCurrentSession();
        List<Qdependency> depends = qdependencyDao.findBy(questionId);
        qdependencyDao.closeCurrentSession();
        return depends;
    }

    public QdependencyDao getTopicDao() {
        return qdependencyDao;
    }
}
