package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.User;
import tezAlServer.dto.mapper.UserMapper;
import tezAlServer.dto.model.UserDto;
import tezAlServer.service.UserService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с клиентами")
@RestController
@RequestMapping("client")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "Получения списка всех клиентов")
    @GetMapping
    public ResponseEntity<List<UserDto>> List(){
        return ResponseEntity.ok(userMapper.toClientDtos(userService.findAll()));
    }

    @ApiOperation(value = "Получения информации клиента по id")
    @GetMapping("{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){
        Optional<User> client = userService.findById(id);
        return (client.isPresent()) ?
                ResponseEntity.ok(userMapper.toClientDto(client.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Создание клиента")
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
        userService.save(userMapper.toClient(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @ApiOperation(value = "Обновление клиента")
    @PutMapping("{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long id,
                                          @RequestBody UserDto userDto) {
        User user = userMapper.toClient(userDto);
        user.setId(id);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDto);
    }

    @ApiOperation(value = "Удаление клиента")
    @DeleteMapping("{id}")
    public  ResponseEntity<User> delete(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
