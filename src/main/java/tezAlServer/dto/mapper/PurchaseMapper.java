package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Purchase;
import tezAlServer.dto.model.PurchaseDto;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    PurchaseDto toPurchaseDto(Purchase purchase);

    List<PurchaseDto> toPurchaseDtos(List<Purchase> purchases);

    Purchase toPurchase(PurchaseDto purchaseDto);
}
