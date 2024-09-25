package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryRequested extends AbstractEvent {

    public DeliveryRequested(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryRequested() {
        super();
    }
}
//>>> DDD / Domain Event
