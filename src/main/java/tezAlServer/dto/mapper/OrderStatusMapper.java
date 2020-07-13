package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.OrderStatus;
import tezAlServer.dto.model.OrderStatusDto;

import java.util.List;

@Mapper
public interface OrderStatusMapper {

    OrderStatusDto toOrderStatusDto(OrderStatus orderStatus);

    List<OrderStatusDto> toOrderStatusDtos(List<OrderStatus> orderStatuses);

    OrderStatus toOrderStatus(OrderStatusDto orderStatusDto);
}
