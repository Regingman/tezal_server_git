package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Discount;
import tezAlServer.dto.model.DiscountDto;

import java.util.List;

@Mapper
public interface DiscountMapper {
    DiscountDto toDiscountDto(Discount discount);

    List<DiscountDto> toDiscountDtos(List<Discount> discounts);

    Discount toDiscount(DiscountDto discountDto);
}
