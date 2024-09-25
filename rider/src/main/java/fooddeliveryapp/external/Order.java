package fooddeliveryapp.external;

import java.util.Date;
import lombok.Data;

@Data
public class Order {

    private Long id;
    private String foodId;
    private String address;
    private String options;
}
