package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Budget;
import tezAlServer.dto.mapper.BudgetMapper;
import tezAlServer.dto.model.BudgetDto;
import tezAlServer.service.BudgetService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с бюджетом")
@RestController
@RequestMapping("budget")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private BudgetMapper budgetMapper;

    @ApiOperation(value = "Получения списка всех бюджетов")
    @GetMapping
    public ResponseEntity<List<BudgetDto>> List(){
        return ResponseEntity.ok(budgetMapper.toBudgetDtos(budgetService.findAll()));
    }

    @ApiOperation(value = "Получение информации о бюджета")
    @GetMapping("{id}")
    public ResponseEntity<BudgetDto> findById(@PathVariable Long id) {
        Optional<Budget> budget = budgetService.findById(id);
        return (budget.isPresent()) ?
                ResponseEntity.ok(budgetMapper.toBudgetDto(budget.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Создание бюджета")
    @PostMapping
    public ResponseEntity<BudgetDto> create(@RequestBody BudgetDto  budgetDto){
        Budget budget = budgetMapper.toBudget(budgetDto);
        budgetService.save(budget);
        return ResponseEntity.status(HttpStatus.CREATED).body(budgetDto);
    }

    @ApiOperation(value = "Обновление бюджета")
    @PutMapping("{id}")
    public ResponseEntity<BudgetDto> update(@PathVariable("id") Long id,
            @RequestBody BudgetDto budgetDto) {
        Budget budget = budgetMapper.toBudget(budgetDto);
        budget.setId(id);
        budgetService.save(budget);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(budgetDto);
    }

    @ApiOperation(value = "Удаление бюджета")
    @DeleteMapping("{id}")
    public  ResponseEntity<Budget> delete(@PathVariable("id") Long id){
        budgetService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
