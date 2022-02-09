package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieUploadPreview;
import com.kata.cinema.base.dao.abstracts.model.MovieDao;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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

       //
        if (file.isEmpty()) {
           // throw new StorageException("Failed to store empty file.");
            return false;
        }

       // " /uploads/movies/preview"



        return true;
    }
}
