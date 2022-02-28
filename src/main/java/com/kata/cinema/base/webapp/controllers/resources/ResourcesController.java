package com.kata.cinema.base.webapp.controllers.resources;


import lombok.AllArgsConstructor;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.file.Files;

@Controller
@Validated
@AllArgsConstructor
@RequestMapping("/uploads")
public class ResourcesController {

    @GetMapping(
            produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE}
    )
    public @ResponseBody
    ResponseEntity<byte[]> getImageWithMediaType(HttpServletRequest request) {

        String imageName = request.getParameter("imageName");
        String path = request.getParameter("path");

        HttpHeaders headers = new HttpHeaders();
        byte[] media = new byte[0];

        try {
            FileInputStream fin = new FileInputStream(new java.io.File("").getAbsolutePath() + path + "/" + imageName);
            media = IOUtils.toByteArray(fin);
            return new ResponseEntity<>(media, headers, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(media, headers, HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(media, headers, HttpStatus.BAD_REQUEST);
        }

    }
}

