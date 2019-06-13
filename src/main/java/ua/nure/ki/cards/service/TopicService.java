package ua.nure.ki.cards.service;

import ua.nure.ki.cards.dao.ResultDao;
import ua.nure.ki.cards.dao.TopicDao;
import ua.nure.ki.cards.data.Topic;

import java.util.List;

public class TopicService {

    private TopicDao topicDao;

    public TopicService() {
        topicDao = new TopicDao();
    }

    public List<Topic> findBy(int testid) {
        topicDao.openCurrentSession();
        List<Topic> topics = topicDao.findBy(testid);
        topicDao.closeCurrentSession();
        return topics;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }
}
