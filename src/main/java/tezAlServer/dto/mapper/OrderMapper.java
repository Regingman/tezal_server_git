package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Order;
import tezAlServer.dto.model.OrderDto;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDtos(List<Order> orders);

    Order toOrder(OrderDto orderDto);
}
