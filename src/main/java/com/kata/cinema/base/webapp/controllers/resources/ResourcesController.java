package com.kata.cinema.base.webapp.controllers.resources;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;

@Controller
@Validated
@AllArgsConstructor
public class ResourcesController {

    @Value("${uploads_movies_preview}")
    private static String dirpath;


    @GetMapping("/uploads/**", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE} )
    public ResponseEntity<byte[]> downloadJpg2(HttpServletRequest request) throws Exception {

        String strFile = httpServletRequestToString(request);

        File fileName = new File(strFile);

        if (fileName.exists()) {
            byte[] bytes = Files.readAllBytes(fileName.toPath());
            return ResponseEntity.ok().body(bytes);
        } else {
            // не существует
            byte[] bytes = new byte[0];
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bytes);
        }
    }
 
    String httpServletRequestToString(HttpServletRequest request) throws Exception {

        ServletInputStream mServletInputStream = request.getInputStream();
        byte[] httpInData = new byte[request.getContentLength()];
        int retVal = -1;
        StringBuilder stringBuilder = new StringBuilder();

        while ((retVal = mServletInputStream.read(httpInData)) != -1) {
            for (int i = 0; i < retVal; i++) {
                stringBuilder.append(Character.toString((char) httpInData[i]));
            }
        }
        return stringBuilder.toString();
    }

}

