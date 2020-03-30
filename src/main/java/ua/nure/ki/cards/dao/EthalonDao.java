package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.TestsEthalon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EthalonDao {
    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public EthalonDao(){
        hiberSessionUtill = new HibernateUtil();
    }

    public Session openCurrentSession() {
        setCurrentSession(hiberSessionUtill.getSessionFactory().openSession());
        return getCurrentSession();
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public List findBy(int questionId) {
        List<TestsEthalon> ethalons =  (List<TestsEthalon>) getCurrentSession().createQuery("from TestsEthalon TE " +
                "where TE.questionId = " + questionId ).list();
        return ethalons;
    }

    public int findMaxComplexity(int testId) {
        List<TestsEthalon> ethalons =  (List<TestsEthalon>) getCurrentSession().createQuery("from TestsEthalon TE " +
                "where TE.testId = " + testId ).list();
        ArrayList<Integer> tmp = new ArrayList<>();
                for(TestsEthalon te:ethalons){
                    tmp.add(te.getComplexity());
                }
                ;
        Collections.max(tmp);
        return Collections.max(tmp);
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
