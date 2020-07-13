package tezAlServer.dto.model;

import lombok.Data;
import tezAlServer.domain.Budget;
import tezAlServer.domain.ContainerCategory;

import java.time.LocalDateTime;

@Data
public class ContainerDto {
    private Long id;
    private String name;
    private int number;
    private Long budgetId;
    private Long containerCategoryId;
}
