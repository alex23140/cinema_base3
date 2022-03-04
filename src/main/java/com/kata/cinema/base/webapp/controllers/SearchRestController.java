package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.models.dto.SearchDto;
import com.kata.cinema.base.service.abstracts.dto.SearchDtoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
@Validated
@AllArgsConstructor
public class SearchRestController {
    private final SearchDtoService searchDtoService;

//    пример запроса /api/search/notFullName?notFullName=movie&limit=3

    @ApiOperation(value = "получтить SearchDto по неполному имени и лимиту", notes = "получтить SearchDto по неполному имени и лимиту", response = SearchDto.class)
    @GetMapping("/notFullName")
    public ResponseEntity<SearchDto> getSearchDto(@RequestParam String notFullName, @RequestParam(defaultValue = "3") int limit) {
        return ResponseEntity.ok(searchDtoService.getSearchDto(notFullName, limit));
    }

}
