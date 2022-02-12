package com.kata.cinema.base.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtil {

    @Value("${uploads_movies_preview}")
    private static String dirpath;


    public static boolean uploadFile(long id, MultipartFile file) {

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
            // Создаем путь где будет храниться, скаченный файл
            // каталог  id . fileSuffix
            String newFileName = id + "." + fileSuffix;
            String path = File.separator + newFileName;
            File destFile = new File(dirpath + path);
            // проверяем
            // если папка не существует, то создаем
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            try {
                file.transferTo(destFile);
                // скачали и записали файл
                return true;
            } catch (IOException e) {
                // ошибка при сохранении
                return false;
            }
        } else {
            // недопустимый файл
            //throw new Exception("the picture's suffix is illegal");
            return false;
        }
    }

}
