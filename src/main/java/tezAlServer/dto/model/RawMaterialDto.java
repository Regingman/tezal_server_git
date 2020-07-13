package tezAlServer.dto.model;

import lombok.Data;

@Data
public class RawMaterialDto {
    private Long id;
    private  String name;
    private  Long unitId;
    private String description;
    private Float volume;
    private int amountInBlock;
    private  Long subcategoryId;
}
