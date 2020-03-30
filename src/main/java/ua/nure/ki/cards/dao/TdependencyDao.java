package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.TestDependency;

import java.util.List;

public class TdependencyDao {

    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public TdependencyDao(){
        hiberSessionUtill = new HibernateUtil();
    }

    public Session openCurrentSession() {
        setCurrentSession(hiberSessionUtill.getSessionFactory().openSession());
        return getCurrentSession();
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public List findBy(int testId) {
        List<TestDependency> ethalons =  (List<TestDependency>) getCurrentSession().createQuery("from TestDependency TD " +
                "where TD.testId = " + testId ).list();
        return ethalons;
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
