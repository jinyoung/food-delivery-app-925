package fooddeliveryapp.domain;

import fooddeliveryapp.OrderApplication;
import fooddeliveryapp.domain.FoodDelivered;
import fooddeliveryapp.domain.OrderCancelled;
import fooddeliveryapp.domain.OrderPlaced;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodId;

    private String address;

    private String options;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        FoodDelivered foodDelivered = new FoodDelivered(this);
        foodDelivered.publishAfterCommit();

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void order() {
        //implement business logic here:

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    public void cancel() {
        //implement business logic here:

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();
    }

    public void confirmDelivery() {
        //implement business logic here:

        FoodDelivered foodDelivered = new FoodDelivered(this);
        foodDelivered.publishAfterCommit();
    }
}
//>>> DDD / Aggregate Root
