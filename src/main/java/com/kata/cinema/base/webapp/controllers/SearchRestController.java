package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.SearchDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;
import com.kata.cinema.base.service.abstracts.dto.SearchDtoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api/search")
@Validated
@AllArgsConstructor
public class SearchRestController {
    private  final SearchDtoService searchDtoService;

    @ApiOperation(value = "получить список Movie по неполному имени", notes = "получить список Movie по неполному имени", responseContainer = "list", response = SearchMovieDto.class)
    @GetMapping("/notFullName/{notFullName}")
    public ResponseEntity<List<SearchMovieDto>> getFastSearchMovieDto(@PathVariable("notFullName") String notFullName) {
        return ResponseEntity.ok(searchDtoService.getFastSearchMovieDto(notFullName));
    }

    @ApiOperation(value = "получтить SearchDto по умолчанию", notes = "получтить SearchDto по умолчанию = 3 шт", response = SearchDto.class)
    @GetMapping("/")
    public ResponseEntity<SearchDto> getSearchDto() {
        return ResponseEntity.ok(searchDtoService.getSearchDto(3).get());
    }

    @ApiOperation(value = "получтить SearchDto по лимиту", notes = "получтить SearchDto по лимиту", response = SearchDto.class)
    @GetMapping("/{limit}")
    public ResponseEntity<SearchDto> getSearchDto(@Positive @PathVariable("limit") int limit) {
        return ResponseEntity.ok(searchDtoService.getSearchDto(limit).get());
    }
}
