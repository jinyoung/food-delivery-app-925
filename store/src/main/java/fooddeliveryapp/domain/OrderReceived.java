package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderReceived extends AbstractEvent {

    public OrderReceived(Cook aggregate) {
        super(aggregate);
    }

    public OrderReceived() {
        super();
    }
}
//>>> DDD / Domain Event
