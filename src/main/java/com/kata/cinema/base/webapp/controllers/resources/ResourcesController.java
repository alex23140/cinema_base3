package com.kata.cinema.base.webapp.controllers.resources;


import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@Validated
@AllArgsConstructor
public class ResourcesController {


    @GetMapping("/uploads/**")
    public ResponseEntity<Resource> downloadJpg2(HttpServletRequest request) throws Exception {

            String str = httpServletRequestToString(request);



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

    @RequestMapping(value = "/uploads/{jpgName}", method = RequestMethod.GET)
      public ResponseEntity<Resource> downloadJpg(
            @PathVariable String jpgName) throws IOException {

        //  Resource downloadResource = new InputStreamResource(soimeinputStream)
        //  Resource downloadResource = new ByteArrayResource(someByteArray)
        //  Resource downloadResource = new FileSystemResource(someFile)
        final ClassPathResource downloadResource = new ClassPathResource(jpgName);

        if (!downloadResource.exists()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        HttpHeaders headers = new HttpHeaders();

        // 1. set the correct content type
        headers.setContentType(MediaType.IMAGE_JPEG);

        // 2. set the correct content length, maybe stored in a db table
        headers.setContentLength(downloadResource.contentLength());

        // 3. if you want to force downloads, otherwise attachments might be displayed directly in the brwoser
        headers.setContentDispositionFormData("attachment", jpgName);

        return new ResponseEntity<>(downloadResource, headers, HttpStatus.OK);
    }
}

