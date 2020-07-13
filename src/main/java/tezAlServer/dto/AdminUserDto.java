package tezAlServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tezAlServer.domain.RoleType;
import tezAlServer.domain.User;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private int telephone;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setFirstName(username);
        user.setTelephonNumber(telephone);
        user.setStatus(RoleType.Status.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getFirstName());
        adminUserDto.setTelephone(user.getTelephonNumber());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }
}