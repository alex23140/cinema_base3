package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieUploadPreview;
import com.kata.cinema.base.dao.abstracts.model.MovieDao;
import com.kata.cinema.base.dao.impl.model.FileUtil;
import com.kata.cinema.base.models.entity.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Repository
public class MovieUploadPreviewImpl implements MovieUploadPreview {

    private final MovieDao movieDao;

    public MovieUploadPreviewImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public boolean add(Long id, MultipartFile file) {
        // нет такой записи в базе
        if (!movieDao.isExistById(id)) {
            return false;
        }
        //путь пустой
        if (file.isEmpty()) {
            return false;
        }

        boolean flag = false;
        try {
            flag = FileUtil.uploadFile(id, file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //обновляем запись
        if (flag) {
            Optional<Movie> movie = movieDao.getById(id);
            movie.get().setPreviewIsExist(true);
            movieDao.update( movie.get()  );
        }

        return flag;
    }
}
