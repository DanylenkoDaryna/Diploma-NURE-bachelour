package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.Result;
import ua.nure.ki.cards.data.User;

import java.io.Serializable;
import java.util.List;

public class UserDao implements IUserDao {
    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public UserDao(){}

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
        User user = (User) getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public List findAll() {
        return null;
    }

    public List findAllbyId(Integer id){
        List<User> users = (List<User>) getCurrentSession().createQuery("from User U where U.concreteGroup.groupId = " + id ).list();
        return users;
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
