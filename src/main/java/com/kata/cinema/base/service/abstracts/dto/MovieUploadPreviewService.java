package com.kata.cinema.base.service.abstracts.dto;

import org.springframework.web.multipart.MultipartFile;

public interface MovieUploadPreviewService {
    String add(Long id, MultipartFile file);
}
