package fooddeliveryapp.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fooddeliveryapp.config.kafka.KafkaProcessor;
import fooddeliveryapp.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderReceived'"
    )
    public void wheneverOrderReceived_노티(
        @Payload OrderReceived orderReceived
    ) {
        OrderReceived event = orderReceived;
        System.out.println(
            "\n\n##### listener 노티 : " + orderReceived + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingStarted'"
    )
    public void wheneverCookingStarted_노티(
        @Payload CookingStarted cookingStarted
    ) {
        CookingStarted event = cookingStarted;
        System.out.println(
            "\n\n##### listener 노티 : " + cookingStarted + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodPrepared'"
    )
    public void wheneverFoodPrepared_노티(@Payload FoodPrepared foodPrepared) {
        FoodPrepared event = foodPrepared;
        System.out.println(
            "\n\n##### listener 노티 : " + foodPrepared + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryUnavailable'"
    )
    public void wheneverDeliveryUnavailable_노티(
        @Payload DeliveryUnavailable deliveryUnavailable
    ) {
        DeliveryUnavailable event = deliveryUnavailable;
        System.out.println(
            "\n\n##### listener 노티 : " + deliveryUnavailable + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
