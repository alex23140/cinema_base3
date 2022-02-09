package com.kata.cinema.base.service.abstracts.dto;

import org.springframework.web.multipart.MultipartFile;

public interface MovieUploadPreviewService {
    boolean add(Long id, MultipartFile file);
}
