package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.Result;
import ua.nure.ki.cards.data.Test;

import java.io.Serializable;
import java.util.List;

public class TestDao implements ITestDao {
    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public TestDao(){}

    public Session openCurrentSession() {
        currentSession = hiberSessionUtill.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = openCurrentSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    @Override
    public Object findById(Integer id) {
        TestDao testDao = (TestDao) getCurrentSession().get(TestDao.class, id);
        return testDao;
    }

    @Override
    public List findAll() {
        return null;
    }

    public List findAllbyId(Integer id){
        List<Test> tests = (List<Test>) getCurrentSession().createQuery("from Test T where T.concreteTestCategory.testCategId = " + id ).list();
        return tests;
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
