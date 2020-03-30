package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.AnsverDao;
import ua.nure.ki.cards.data.Ansver;

import java.util.List;

public class AnsverService {
    private AnsverDao ansverDao;

    public AnsverService() {
        ansverDao = new AnsverDao();
    }

    public List<Ansver> findBy(int questionId) {
        ansverDao.openCurrentSession();
        List<Ansver> ansvers = ansverDao.findBy(questionId);
        ansverDao.closeCurrentSession();
        return ansvers;
    }

    public Ansver findAnsver(int questionId) {
        ansverDao.openCurrentSession();
        Ansver ansver = ansverDao.findAnsver(questionId);
        ansverDao.closeCurrentSession();
        return ansver;
    }

    public Ansver findAnsverById(Integer id) {
        ansverDao.openCurrentSession();
        Ansver answer = ansverDao.findAnsverById(id);
        ansverDao.closeCurrentSession();
        return answer;
    }

    public AnsverDao getAnsverDao() {
        return ansverDao;
    }
}
