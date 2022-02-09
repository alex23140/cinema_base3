package com.kata.cinema.base.dao.impl.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtil {

    private static String dirpath= "/uploads/movies/preview";

    public static boolean uploadFile(long id, MultipartFile file) throws Exception {

        // Сначала проверяем формат изображения
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
            // id . fileSuffix
            String newFileName = id + "." + fileSuffix;
            String path = File.separator + newFileName;
            File destFile = new File(dirpath + path);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            try {
                file.transferTo(destFile);





                // скачали и записали файл
                return true;
            } catch (IOException e) {
                return false;
            }
        } else {
            // недопустимый файл
            throw new Exception("the picture's suffix is illegal");
        }
    }

}
