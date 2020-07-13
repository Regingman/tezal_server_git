package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Sale;
import tezAlServer.dto.model.SaleDto;

import java.util.List;

@Mapper
public interface SaleMapper {
    SaleDto toSaleDto(Sale sale);

    List<SaleDto> toSaleDtos(List<Sale> sales);

    Sale toSale(SaleDto saleDto);
}
