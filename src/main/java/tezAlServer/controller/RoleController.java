package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Role;
import tezAlServer.dto.mapper.RoleMapper;
import tezAlServer.dto.model.RoleDto;
import tezAlServer.service.RoleService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с ролями")
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    RoleMapper roleMapper;

    @ApiOperation(value = "Получения списка всех ролей")
    @GetMapping
    public ResponseEntity<List<RoleDto>> List(){
        return ResponseEntity.ok(roleMapper.toRoleDtos(roleService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleDto> getById(@PathVariable("id") Long id){
        Optional<Role> role = roleService.findById(id);
        return role.isPresent() ?
                ResponseEntity.ok(roleMapper.toRoleDto(role.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Создание роли")
    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody RoleDto  roleDto){
        roleService.save(roleMapper.toRole(roleDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(roleDto);
    }

    @ApiOperation(value = "Обновление роли")
    @PutMapping("{id}")
    public ResponseEntity<RoleDto> update(@PathVariable("id") Long id,
            @RequestBody RoleDto roleDto) {
        Role role = roleMapper.toRole(roleDto);
        role.setId(id);
        roleService.save(role);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roleDto);
    }

    @ApiOperation(value = "Удаление роли")
    @DeleteMapping("{id}")
    public  ResponseEntity<Role> delete(@PathVariable("id") Long id){
        roleService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
