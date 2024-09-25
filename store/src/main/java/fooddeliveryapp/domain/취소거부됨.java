package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class 취소거부됨 extends AbstractEvent {

    private Long id;
    private String reason;

    public 취소거부됨(Cook aggregate) {
        super(aggregate);
    }

    public 취소거부됨() {
        super();
    }
}
//>>> DDD / Domain Event
