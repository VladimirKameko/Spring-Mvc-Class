package by.pvt.product;

import by.pvt.pojo.ProductItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class ProductItemRepository {



    @Autowired
    SessionFactory sessionFactory;


    public List<ProductItem> findProduct(int count, boolean isTopProduct) {

        return sessionFactory.getCurrentSession()
                .createQuery("from ProductItem pi where pi.isTopProduct=:param1", ProductItem.class)
                .setParameter("param1", isTopProduct)
                .setCacheable(true)
                .setMaxResults(count)
                .list();
    }

    public List<ProductItem> findProductByName(String serchStr) {

        return sessionFactory.getCurrentSession()
                .createQuery("from ProductItem pi where pi.name like :param1", ProductItem.class)
                .setParameter("param1", "%" + serchStr + "%")
                .setCacheable(true)
                .setMaxResults(10)
                .list();

    }

    public ProductItem findProductById(Long id) {

        return sessionFactory.getCurrentSession()
                .get(ProductItem.class, id);

    }

    public void save(ProductItem productItem) {
        sessionFactory.getCurrentSession()
                .persist(productItem);

    }


    public List<ProductItem> findProductByDate(Date lastDate) {
        List<ProductItem> list = sessionFactory.getCurrentSession()
                .createQuery("from ProductItem pi where pi.updateDate > :param", ProductItem.class)
                .setParameter("param", lastDate)
                .setCacheable(true)
                .list();
        return list;
    }
}
