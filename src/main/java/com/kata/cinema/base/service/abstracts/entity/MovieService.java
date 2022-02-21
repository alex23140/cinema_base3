package com.kata.cinema.base.service.abstracts.entity;

import com.kata.cinema.base.models.entity.Movie;
import org.springframework.web.multipart.MultipartFile;

public interface MovieService extends AbstractService<Long, Movie> {

    void movieUploadPreview(Long id, MultipartFile file);
}
