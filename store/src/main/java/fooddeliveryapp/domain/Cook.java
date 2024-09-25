package fooddeliveryapp.domain;

import fooddeliveryapp.StoreApplication;
import fooddeliveryapp.domain.CookingStarted;
import fooddeliveryapp.domain.FoodPrepared;
import fooddeliveryapp.domain.OrderReceived;
import fooddeliveryapp.domain.취소거부됨;
import fooddeliveryapp.domain.취소완료됨;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
//<<< DDD / Aggregate Root
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String foodId;

    private String options;

    private String address;

    @PostPersist
    public void onPostPersist() {
        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();

        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

        FoodPrepared foodPrepared = new FoodPrepared(this);
        foodPrepared.publishAfterCommit();

        취소완료됨 취소완료됨 = new 취소완료됨(this);
        취소완료됨.publishAfterCommit();

        취소거부됨 취소거부됨 = new 취소거부됨(this);
        취소거부됨.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void accept() {
        //implement business logic here:

        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();
    }

    public void startCook() {
        //implement business logic here:

        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();
    }

    public void finishCook() {
        //implement business logic here:

        FoodPrepared foodPrepared = new FoodPrepared(this);
        foodPrepared.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void 주문등록(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void 취소처리(OrderCancelled orderCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        취소완료됨 취소완료됨 = new 취소완료됨(cook);
        취소완료됨.publishAfterCommit();
        취소거부됨 취소거부됨 = new 취소거부됨(cook);
        취소거부됨.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);

            취소완료됨 취소완료됨 = new 취소완료됨(cook);
            취소완료됨.publishAfterCommit();
            취소거부됨 취소거부됨 = new 취소거부됨(cook);
            취소거부됨.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
