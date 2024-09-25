package fooddeliveryapp.domain;

import fooddeliveryapp.domain.*;
import fooddeliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FoodPrepared extends AbstractEvent {

    private Long id;
    private String foodId;
    private String options;
    private String address;
}
