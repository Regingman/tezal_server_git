package tezAlServer.dto.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long id;
    private  Long ordersStatusId;
    private  Long clientId;
    private  Long containerId;
    private LocalDateTime deadlineDate;
}
