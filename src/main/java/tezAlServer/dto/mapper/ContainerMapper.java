package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import tezAlServer.domain.Container;
import tezAlServer.dto.model.ContainerDto;

import java.util.List;

@Mapper
public interface ContainerMapper {

        ContainerDto toContainerDTO(Container container);

        List<ContainerDto> toContainerDTOs(List<Container> containers);

        Container toContainer(ContainerDto containerDto);
}
