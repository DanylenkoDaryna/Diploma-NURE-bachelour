package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.Group;
import ua.nure.ki.cards.data.Result;

import java.io.Serializable;
import java.util.List;

public class GroupDao implements IGroupDao {
    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public GroupDao(){}

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
        Group group = (Group) getCurrentSession().get(Group.class, id);
        return group;
    }

    @Override
    public List findAll() {
        return null;
    }


    public List findAllbyId(Integer id){
        List<Group> groupTypes = (List<Group>) getCurrentSession().createQuery("from Group G where G.concreteCategory.grCategId = " + id ).list();
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
