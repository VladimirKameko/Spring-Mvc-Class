package by.pvt.notification;

import by.pvt.pojo.ProductItem;
import by.pvt.product.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.logging.Logger;

@Service
@Transactional
public class NotificationService {
    private static final Logger log = Logger.getLogger("NotificationService");

    private Set<ProductItem> newProductItems;
    @Autowired
    NotificationRepo notificationRepo;
    @Autowired
    ProductItemRepository productItemRepository;

    @Scheduled(cron = "0/5 * * * * *")
    public void executeNotification() {
        log.info("new notification");

        Date lastDate = notificationRepo.getLastDate();
        List<ProductItem> newItems = productItemRepository.findProductByDate(lastDate);

        if (!newItems.isEmpty()) {
            getNewProductItems().clear();
            getNewProductItems().addAll(newItems);
            notificationRepo.updateDate();
        }

    }

    public Set<ProductItem> getNewProductItems() {
        if (newProductItems == null) {
            newProductItems = new HashSet<>();
        }
        return newProductItems;
    }

    public void setNewProductItems(Set<ProductItem> newProductItems) {
        this.newProductItems = newProductItems;
    }
}
