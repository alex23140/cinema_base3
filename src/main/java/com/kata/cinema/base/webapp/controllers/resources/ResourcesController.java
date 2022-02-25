package com.kata.cinema.base.webapp.controllers.resources;


import lombok.AllArgsConstructor;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Controller
@Validated
@AllArgsConstructor
@RequestMapping("/uploads")
public class ResourcesController {

    @GetMapping(produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE} )
    public byte[] downloadJpg2(String ImageName) {

        // open image
        File imgPath = new File("/uploads/"+ImageName);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(imgPath);
            // get DataBufferBytes from Raster
            WritableRaster raster = bufferedImage .getRaster();
            DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

            return data.getData();
        } catch (IOException e) {
            e.printStackTrace();



            return null;
        }


    }

    @GetMapping(
            value = "/get-image-with-media-type",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody
    byte[] getImageWithMediaType() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
        return IOUtils.toByteArray(in);
    }

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = "/image/{imageid}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getImageWithMediaType(@PathVariable int imageid) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:color.jpg");
        File file = resource.getFile();
        byte[] fileContent = Files.readAllBytes(file.toPath());

        InputStream in = new ByteArrayInputStream(fileContent);
        return IOUtils.toByteArray(in);
    }



}

