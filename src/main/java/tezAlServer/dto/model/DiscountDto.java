package tezAlServer.dto.model;

import lombok.Data;

@Data
public class DiscountDto {
    private Long id;
    private Float summ;
    private Float percent;
    private Long containerId;
}
