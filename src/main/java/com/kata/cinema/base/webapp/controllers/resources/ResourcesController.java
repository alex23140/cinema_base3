package com.kata.cinema.base.webapp.controllers.resources;


import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/uploads")
@Slf4j
public class ResourcesController {

    @GetMapping(produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public ResponseEntity<byte[]> getImageWithMediaType(HttpServletRequest request) {

        String imageName = request.getParameter("imageName");
        String path = request.getParameter("path");

        HttpHeaders headers = new HttpHeaders();
        byte[] media = new byte[0];

        try {
            FileInputStream fin = new FileInputStream(new java.io.File("").getAbsolutePath() + path + "/" + imageName);
            media = IOUtils.toByteArray(fin);
            return new ResponseEntity<>(media, headers, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            log.error("файл не найден ", new java.io.File("").getAbsolutePath() + path + "/" + imageName);
            return new ResponseEntity<>(media, headers, HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(media, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

