package tezAlServer.dto.model;

import lombok.Data;

@Data
public class RateDto {
    private Long id;
    private  Float wholesalePrice;
    private  Float retailPrice;
    private  Float quantityInStock;
    private  Long rawMaterialId;
    private  Long containerId;
}
