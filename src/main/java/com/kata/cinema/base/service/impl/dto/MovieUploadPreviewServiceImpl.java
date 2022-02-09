package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.MovieUploadPreview;
import com.kata.cinema.base.dao.impl.model.FileUtil;
import com.kata.cinema.base.service.abstracts.dto.MovieUploadPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MovieUploadPreviewServiceImpl implements MovieUploadPreviewService {

    private final MovieUploadPreview movieUploadPreview;
    @Autowired
    public MovieUploadPreviewServiceImpl(MovieUploadPreview movieUploadPreview) {
        this.movieUploadPreview = movieUploadPreview;
    }

    @Override
    public String add(Long id, MultipartFile file) {
        try {
            return FileUtil.uploadFile(id,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
