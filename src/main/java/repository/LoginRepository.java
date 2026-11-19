package repository;


import db.HibernateUtill;
import model.dto.LoginDTO;
import model.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginRepository {

    Session session = HibernateUtill.getSession();

    public UserEntity CheckUserNameAndPassword(LoginDTO loginDTO) {
        String HQL = "FROM UserEntity WHERE userName = :userName AND password = :password";

        UserEntity userEntity = session.createQuery(HQL, UserEntity.class)
                .setParameter("userName", loginDTO.getUserName())
                .setParameter("password", loginDTO.getPassword())
                .uniqueResult();

        return userEntity;
    }
}
