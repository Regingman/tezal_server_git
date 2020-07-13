package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Role;
import tezAlServer.dto.model.RoleDto;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleDto toRoleDto(Role role);

    List<RoleDto> toRoleDtos(List<Role> roles);

    Role toRole(RoleDto roleDto);
}
