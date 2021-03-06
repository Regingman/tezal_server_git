package tezAlServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tezAlServer.domain.User;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String username;
    private int telephone;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setFirstName(username);
        user.setTelephonNumber(telephone);

        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getFirstName());
        userDto.setTelephone(user.getTelephonNumber());

        return userDto;
    }
}
