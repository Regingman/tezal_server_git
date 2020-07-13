package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Rate;
import tezAlServer.dto.mapper.RateMapper;
import tezAlServer.dto.model.RateDto;
import tezAlServer.service.RateService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с расценками")
@RestController
@RequestMapping("rate")
public class RateController {
    @Autowired
    private RateService rateService;
    @Autowired
    private RateMapper rateMapper;

    @ApiOperation(value = "Получения списка всех всех расценок")
    @GetMapping
    public ResponseEntity<List<RateDto>> List(){
        return ResponseEntity.ok(rateMapper.toRateDtos(rateService.findAll()));
    }

    @ApiOperation(value = "Получения списка всех товаров одного контейнера")
    @GetMapping("{id}/all")
    public ResponseEntity<List<RateDto>> getAllById(@PathVariable("id") Long id){
        return ResponseEntity.ok(rateMapper.toRateDtos(rateService.findAllById(id)));
    }

    @GetMapping("{id}")
    public ResponseEntity<RateDto> findById(@PathVariable Long id) {
        Optional<Rate> rate = rateService.findById(id);
        return (rate.isPresent()) ?
                ResponseEntity.ok(rateMapper.toRateDto(rate.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Создание расценки")
    @PostMapping
    public ResponseEntity<RateDto> create(@RequestBody RateDto  rateDto){
        rateService.save(rateMapper.toRate(rateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(rateDto);
    }

    @ApiOperation(value = "Обновление расценки")
    @PutMapping("{id}")
    public ResponseEntity<RateDto> update(@PathVariable("id") Long id,
            @RequestBody RateDto rateDto) {
        Rate rate = rateMapper.toRate(rateDto);
        rate.setId(id);
        rateService.save(rate);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(rateDto);
    }

    @ApiOperation(value = "Удаление расценки")
    @DeleteMapping("{id}")
    public  ResponseEntity<Rate> delete(@PathVariable("id") Long id){
        rateService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
