package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CookingStarted extends AbstractEvent {

    public CookingStarted(Cook aggregate) {
        super(aggregate);
    }

    public CookingStarted() {
        super();
    }
}
//>>> DDD / Domain Event
