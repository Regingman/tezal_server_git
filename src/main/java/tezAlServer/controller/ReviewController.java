package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Review;
import tezAlServer.dto.mapper.ReviewMapper;
import tezAlServer.dto.model.ReviewDto;
import tezAlServer.service.ReviewService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с отзывами")
@RestController
@RequestMapping("review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewMapper reviewMapper;

    @ApiOperation(value = "Получения списка всех отзывов")
    @GetMapping
    public ResponseEntity<List<ReviewDto>> List(){
        return ResponseEntity.ok(reviewMapper.toReviewDtos(reviewService.findAll()));
    }

    @ApiOperation(value = "Получение информации об отзыве")
    @GetMapping("{id}")
    public ResponseEntity<ReviewDto> getOne(@PathVariable("id") Long id){
        Optional<Review> review = reviewService.findById(id);
        return review.isPresent() ?
                ResponseEntity.ok(reviewMapper.toReviewDto(review.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Получения списка всех отзывов одного контейнера")
    @GetMapping("{id}/all")
    public ResponseEntity<List<ReviewDto>> getAllById(@PathVariable("id") Long containerId){
        return ResponseEntity.ok(reviewMapper.toReviewDtos(reviewService.findAllByContainerId(containerId)));
    }

    @ApiOperation(value = "Создание контейнера")
    @PostMapping
    public ResponseEntity<ReviewDto> create(@RequestBody ReviewDto  reviewDto){
        reviewService.save(reviewMapper.toReview(reviewDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewDto);
    }

    @ApiOperation(value = "Обновление контейнера")
    @PutMapping("{id}")
    public ResponseEntity<ReviewDto> update(@PathVariable("id") Long id,
            @RequestBody ReviewDto reviewDto) {
        Review review = reviewMapper.toReview(reviewDto);
        review.setId(id);
        reviewService.save(review);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reviewDto);
    }

    @ApiOperation(value = "Удаление контейнера")
    @DeleteMapping("{id}")
    public  ResponseEntity<Review> delete(@PathVariable("id") Long id){
        reviewService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
