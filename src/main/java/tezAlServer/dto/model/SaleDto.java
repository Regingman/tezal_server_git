package tezAlServer.dto.model;

import lombok.Data;

@Data
public class SaleDto {
    private Long id;
    private int count;
    private Float summ;
    private Long rateId;
    private Long ordersId;
}
