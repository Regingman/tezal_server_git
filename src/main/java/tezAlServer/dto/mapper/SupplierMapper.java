package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Supplier;
import tezAlServer.dto.model.SupplierDto;

import java.util.List;

@Mapper
public interface SupplierMapper {
    SupplierDto toSupplierDto(Supplier supplier);

    List<SupplierDto> toSupplierDtos(List<Supplier> suppliers);

    Supplier toSupplier(SupplierDto supplierDto);
}
