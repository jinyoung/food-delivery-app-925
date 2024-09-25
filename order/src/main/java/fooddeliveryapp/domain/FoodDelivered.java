package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FoodDelivered extends AbstractEvent {

    public FoodDelivered(Order aggregate) {
        super(aggregate);
    }

    public FoodDelivered() {
        super();
    }
}
//>>> DDD / Domain Event
