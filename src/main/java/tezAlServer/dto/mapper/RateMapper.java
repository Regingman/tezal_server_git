package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Rate;
import tezAlServer.dto.model.RateDto;

import java.util.List;

@Mapper
public interface RateMapper {
    RateDto toRateDto(Rate rate);

    List<RateDto> toRateDtos(List<Rate> rates);

    Rate toRate(RateDto rateDto);
}
