package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.CustomerDiscount;
import tezAlServer.dto.model.CustomerDiscountDto;

import java.util.List;

@Mapper
public interface CustomerDiscountMapper {

    CustomerDiscountDto toCustomerDiscountDto(CustomerDiscount customerDiscount);

    List<CustomerDiscountDto> toCustomerDiscountDtos(List<CustomerDiscount> customerDiscounts);

    CustomerDiscount toCustomerDiscount(CustomerDiscountDto customerDiscountDto);
}
