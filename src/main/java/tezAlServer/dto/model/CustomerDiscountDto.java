package tezAlServer.dto.model;

import lombok.Data;

@Data
public class CustomerDiscountDto {
    private Long id;
    private Float summ;
    private Float percent;
    private Long clientId;
    private Long discountId;
}
