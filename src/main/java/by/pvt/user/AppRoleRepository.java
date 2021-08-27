package by.pvt.user;

import by.pvt.pojo.AppRole;
import by.pvt.pojo.RoleName;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AppRoleRepository {
    @Autowired
    SessionFactory sessionFactory;

    public AppRole findRoleByName(RoleName roleName) {
        try {
           return sessionFactory.getCurrentSession().createQuery("from AppRole where roleName like :param1", AppRole.class)
                    .setParameter("param1", roleName)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> getRoleNames(){
        return sessionFactory.getCurrentSession()
                .createQuery("select roleName from AppRole",RoleName.class)
                .list()
                .stream()
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
