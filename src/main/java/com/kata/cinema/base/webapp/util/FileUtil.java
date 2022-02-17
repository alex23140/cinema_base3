package com.kata.cinema.base.webapp.util;


import com.kata.cinema.base.exceptional.NotSupportingSuffix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class FileUtil {

    @Value("${my.preview}")
    private String dirPath;

    public void uploadFile(long id, MultipartFile file) {

        List<String> imageType = new ArrayList<>();
        imageType.add("jpg");
        imageType.add("jpeg");
        imageType.add("png");
        imageType.add("bmp");
        imageType.add("gif");

        // Получаем имя файла с суффиксом
        String originalFilename = file.getOriginalFilename();
        // Получаем суффиксный формат файла
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        if (imageType.contains(fileSuffix)) {
            String newFileName = id + "." + fileSuffix;
            String path = File.separator + newFileName;
            File destFile = new File( new java.io.File("").getAbsolutePath() + dirPath + path);

            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }

            try {
                file.transferTo(destFile);
            } catch (IOException e) {
                log.error("не удалось создать файл с movieId = {}", id);
            }
        } else {
            //TODO добавить handler в GlobalExceptionalHandler на эту exception
            throw new NotSupportingSuffix("the picture's suffix is illegal");
        }
    }
}

