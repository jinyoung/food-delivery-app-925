package fooddeliveryapp.domain;

import fooddeliveryapp.RiderApplication;
import fooddeliveryapp.domain.DeliveryRequested;
import fooddeliveryapp.domain.DeliveryUnavailable;
import fooddeliveryapp.domain.DriverAssigned;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        DeliveryRequested deliveryRequested = new DeliveryRequested(this);
        deliveryRequested.publishAfterCommit();

        DriverAssigned driverAssigned = new DriverAssigned(this);
        driverAssigned.publishAfterCommit();

        DeliveryUnavailable deliveryUnavailable = new DeliveryUnavailable(this);
        deliveryUnavailable.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void acceptDelivery() {
        //implement business logic here:

        DriverAssigned driverAssigned = new DriverAssigned(this);
        driverAssigned.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void requestDelivery(FoodPrepared foodPrepared) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryRequested deliveryRequested = new DeliveryRequested(delivery);
        deliveryRequested.publishAfterCommit();
        DeliveryUnavailable deliveryUnavailable = new DeliveryUnavailable(delivery);
        deliveryUnavailable.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(foodPrepared.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryRequested deliveryRequested = new DeliveryRequested(delivery);
            deliveryRequested.publishAfterCommit();
            DeliveryUnavailable deliveryUnavailable = new DeliveryUnavailable(delivery);
            deliveryUnavailable.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
