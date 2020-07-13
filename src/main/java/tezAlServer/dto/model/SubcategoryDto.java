package tezAlServer.dto.model;

import lombok.Data;

@Data
public class SubcategoryDto {
    private Long id;
    private  String name;
    private  Long categoryId;
}
