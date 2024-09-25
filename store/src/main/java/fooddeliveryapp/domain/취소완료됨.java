package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class 취소완료됨 extends AbstractEvent {

    private Long id;

    public 취소완료됨(Cook aggregate) {
        super(aggregate);
    }

    public 취소완료됨() {
        super();
    }
}
//>>> DDD / Domain Event
