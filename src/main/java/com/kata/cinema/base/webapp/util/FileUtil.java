package com.kata.cinema.base.webapp.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@PropertySource("classpath:application.properties")
public class FileUtil {

    @Value("${preview}")
    private static String dirpath;

    public static void uploadFile(long id, MultipartFile file) throws NotSupportingSuffix  {
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
            File destFile = new File( new java.io.File("").getAbsolutePath() + dirpath + path);

            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }

            try {
                file.transferTo(destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            throw new NotSupportingSuffix ();
        }
    }
}


class NotSupportingSuffix  extends Exception
{
    public String toString()
    {
        return "the picture's suffix is illegal";
    }
}