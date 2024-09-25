package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DriverAssigned extends AbstractEvent {

    public DriverAssigned(Delivery aggregate) {
        super(aggregate);
    }

    public DriverAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
