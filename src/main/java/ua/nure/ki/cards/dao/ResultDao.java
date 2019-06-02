package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.Result;

import java.io.Serializable;
import java.util.List;

public class ResultDao implements IResultDao {

    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public ResultDao(){}

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
        Result result = (Result) getCurrentSession().get(Result.class, id);
        return result;
    }

    @Override
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
