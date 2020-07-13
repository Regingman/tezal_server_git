package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.User;
import tezAlServer.dto.model.UserDto;

import java.util.List;

@Mapper
public interface UserMapper {

        UserDto toClientDto(User user);

        List<UserDto> toClientDtos(List<User> users);

        User toClient(UserDto userDto);
}
