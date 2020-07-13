package tezAlServer.dto.model;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private  String firstName;
    private  String lastName;
    private  String patronymic;
    private  int telephonNumber;
    private  String email;
    private  String password;
}
