package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.Question;

import java.util.List;

public class QuestionDao {
    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public QuestionDao(){
        hiberSessionUtill =new HibernateUtil();
    }

    public Session openCurrentSession() {
        setCurrentSession(hiberSessionUtill.getSessionFactory().openSession());
        return getCurrentSession();
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public List findAllBy(Integer topicid) {
        List<Question> questions =  getCurrentSession().createQuery("from Question Q " +
                "where Q.topicId = " + topicid ).list();
        return questions;
    }

    public List findAll() {
        return null;
    }

    public HibernateUtil getHiberSessionUtill() {
        return hiberSessionUtill;
    }

    public void setHiberSessionUtill(HibernateUtil hiberSessionUtill) {
        this.hiberSessionUtill = hiberSessionUtill;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
}
