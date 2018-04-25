package com.iloooo.service;

import com.iloooo.entity.Task;
import com.iloooo.entity.Type;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {

    boolean updateHomework(MultipartFile file,long userId, long typeId, long taskId,String serverPath);



}
