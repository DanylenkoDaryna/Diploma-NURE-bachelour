package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.Result;
import ua.nure.ki.cards.data.TestCategory;

import java.io.Serializable;
import java.util.List;

public class TestCategoryDao implements ICategoryDao {
    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public TestCategoryDao(){}

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
        TestCategoryDao testCategoryDao = (TestCategoryDao) getCurrentSession().get(TestCategoryDao.class, id);
        return testCategoryDao;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List findAll() {
        List<TestCategory> testTypes = (List<TestCategory>) getCurrentSession().createQuery("from TestCategory").list();
        return testTypes;
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
