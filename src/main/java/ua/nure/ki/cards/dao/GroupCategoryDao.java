package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.nure.ki.cards.data.GroupCategory;
import ua.nure.ki.cards.data.Result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GroupCategoryDao implements ICategoryDao {
    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public GroupCategoryDao(){}

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
        GroupCategoryDao groupCategoryDao = (GroupCategoryDao) getCurrentSession().get(GroupCategoryDao.class, id);
        return groupCategoryDao;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List findAll() {
        List<GroupCategory> groupTypes = (List<GroupCategory>) getCurrentSession().createQuery("from GroupCategory").list();
        return groupTypes;
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
