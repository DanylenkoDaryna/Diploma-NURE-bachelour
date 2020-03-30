package ua.nure.ki.cards.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory = createSessionFactory();

    private static SessionFactory createSessionFactory() {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(ua.nure.ki.cards.data.Result.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.User.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.Group.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.GroupCategory.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.Test.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.TestCategory.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.Topic.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.Qdependency.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.Question.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.Ansver.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.TestsEthalon.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.TestDependency.class)
                .addAnnotatedClass(ua.nure.ki.cards.data.ResultAnsver.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
