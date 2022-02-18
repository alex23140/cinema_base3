package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.MovieDao;

import com.kata.cinema.base.models.entity.Movie;
import com.kata.cinema.base.service.abstracts.entity.MovieService;
import com.kata.cinema.base.webapp.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MovieServiceImpl extends AbstractServiceImpl<Long, Movie> implements MovieService {

    private final MovieDao movieDao;
    private final FileUtil fileUtil;

    protected MovieServiceImpl(MovieDao movieDao, FileUtil fileUtil) {
        super(movieDao);
        this.movieDao = movieDao;
        this.fileUtil = fileUtil;
    }

    @Override
    public void movieUploadPreview(Long id, MultipartFile file) {
        fileUtil.uploadFile(id, file);
    }
}
