package com.kata.cinema.base.dao.abstracts.dto;

import org.springframework.web.multipart.MultipartFile;

public interface MovieUploadPreview {
    boolean add(Long id, MultipartFile file);
}
