package tezAlServer.dto.model;

import lombok.Data;

@Data
public class PurchaseDto {
    private Long id;
    private int count;
    private Float summ;
    private String publisher;
    private String barCode;
    private Float priceForOne;
    private  Long containerId;
    private  Long rawMaterialId;

}
