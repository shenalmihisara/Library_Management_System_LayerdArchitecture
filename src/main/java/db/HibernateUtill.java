package db;

import model.entity.MemberEntity;
import model.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtill {
    public static Session getSession(){
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(UserEntity.class)
                .addAnnotatedClass(MemberEntity.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        return sessionFactory.openSession();
    }
}
