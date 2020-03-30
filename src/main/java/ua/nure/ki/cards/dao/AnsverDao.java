package ua.nure.ki.cards.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.ki.cards.data.Ansver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnsverDao {

    private HibernateUtil hiberSessionUtill;
    private Session currentSession;
    private Transaction currentTransaction;

    public AnsverDao(){
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
        List<Ansver> ansvers =  (List<Ansver>) getCurrentSession().createQuery("from Ansver A " +
                "where A.questionId = " + questionId ).list();
        return ansvers;
    }

    public Ansver findAnsver(int questionId) {
        List<Ansver> ansvers =  (List<Ansver>) getCurrentSession().createQuery("from Ansver A " +
                "where A.questionId = " + questionId ).list();

        List<Integer> ids= new ArrayList<>();
        for(Ansver a:ansvers){
            ids.add(a.getAnswerId());
        }

        int maxId= Collections.max(ids);
        Ansver resultAnsver =  new Ansver();
        for(int i=0; i<ansvers.size(); i++){
            if(ansvers.get(i).getAnswerId()==maxId){
                resultAnsver=ansvers.get(i);
            }
        }
        return resultAnsver;
    }

    public Ansver findAnsverById(Integer id) {
        Ansver ansver = (Ansver) getCurrentSession().get(Ansver.class, id);
        return ansver;
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
