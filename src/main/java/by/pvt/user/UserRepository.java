package by.pvt.user;

import by.pvt.pojo.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class UserRepository {


    @Autowired
    private SessionFactory sessionFactory;

    public Long findUserCountByLogin(String userName) {

        return sessionFactory.getCurrentSession()
                .createQuery("from AppUser where username  like:param1", AppUser.class)
                .setParameter("param1", userName)
                .getResultStream()
                .count();
    }

    public AppUser findUserByLogin(String userName) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from AppUser where username  like:param1", AppUser.class)
                    .setParameter("param1", userName)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void save(AppUser user) {

        sessionFactory.getCurrentSession().persist(user);
    }
}
