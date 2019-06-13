package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.QuestionDao;
import ua.nure.ki.cards.data.Question;

import java.util.List;

public class QuestionService {

    private QuestionDao questionDao;

    public QuestionService() {
        questionDao = new QuestionDao();
    }

    public List<Question> findBy(int topicid) {
        questionDao.openCurrentSession();
        List<Question> questions = questionDao.findAllBy(topicid);
        questionDao.closeCurrentSession();
        return questions;
    }

    public QuestionDao getTopicDao() {
        return questionDao;
    }
}
