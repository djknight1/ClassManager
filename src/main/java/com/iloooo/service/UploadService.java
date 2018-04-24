package com.iloooo.service;

import com.iloooo.entity.Task;
import com.iloooo.entity.Type;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
    List<Task> getTaskNow();

    List<Type> getTypeAll();

    boolean updateHomework(MultipartFile file,long userId, long typeId, long taskId,String serverPath);

    Task getTaskByTypeId(long typeId);


}
