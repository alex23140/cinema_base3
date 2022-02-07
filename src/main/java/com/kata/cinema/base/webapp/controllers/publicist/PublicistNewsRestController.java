package com.kata.cinema.base.webapp.controllers.publicist;

import com.kata.cinema.base.mapper.NewsMapper;
import com.kata.cinema.base.models.dto.NewsDto;
import com.kata.cinema.base.models.enums.Rubric;
import com.kata.cinema.base.service.abstracts.dto.NewsDtoService;
import com.kata.cinema.base.service.abstracts.entity.NewsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/publicist/news")
public class PublicistNewsRestController {

    private final NewsDtoService dtoService;
    private final NewsService newsService;
    private final NewsMapper newsMapper;

    public PublicistNewsRestController(NewsDtoService dtoService, NewsService newsService, NewsMapper newsMapper) {
        this.dtoService = dtoService;
        this.newsService = newsService;
        this.newsMapper = newsMapper;
    }

    @GetMapping
    public ResponseEntity<List<NewsDto>> getAll(
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "rubric") Rubric rubric) {
        List<NewsDto> news = dtoService.getAllByDateAndRubric(startDate, endDate, rubric);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewsDto> createNews(@RequestBody NewsDto newsDto) {
        newsService.create(newsMapper.toEntity(newsDto));
        return new ResponseEntity<>(newsDto, HttpStatus.CREATED);
    }
}
