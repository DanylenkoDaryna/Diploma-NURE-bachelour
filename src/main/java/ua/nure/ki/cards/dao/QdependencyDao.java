package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.Qdependency;

import java.util.List;

public class QdependencyDao {

    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public QdependencyDao(){
        hiberSessionUtill =new HibernateUtil();
    }

    public Session openCurrentSession() {
        setCurrentSession(hiberSessionUtill.getSessionFactory().openSession());
        return getCurrentSession();
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public List findBy(Integer questionId) {
        List<Qdependency> depends =  getCurrentSession().createQuery("from Qdependency Qd " +
                "where Qd.questionId = " + questionId ).list();
        return depends;
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
