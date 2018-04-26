package com.iloooo.service.impl;

import com.iloooo.entity.Class;
import com.iloooo.entity.Homework;
import com.iloooo.entity.Task;
import com.iloooo.entity.Type;
import com.iloooo.dao.ClassDao;
import com.iloooo.dao.HomeworkDao;
import com.iloooo.dao.TaskDao;
import com.iloooo.dao.TypeDao;
import com.iloooo.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

import static com.iloooo.utils.DownloadUtils.zipFile;

@Service("downloadServiceImpl")
public class DownloadServiceImpl implements DownloadService {
    private TaskDao taskDao;
    private HomeworkDao homeworkDao;
    private ClassDao classDao;
    private TypeDao typeDao;

    @Autowired
    public DownloadServiceImpl(TaskDao taskDao, HomeworkDao homeworkDao, ClassDao classDao, TypeDao typeDao) {
        this.taskDao = taskDao;
        this.homeworkDao = homeworkDao;
        this.classDao = classDao;
        this.typeDao = typeDao;
    }


//    @Override
//    public void downloadAll(String path, String taskName){
//        System.out.println("download");
//        List<File> files = new ArrayList<File>();
//        File allfile = new File(path);
//        if (allfile.exists()){
//            File[] fileArr = allfile.listFiles();
//            for (File file2 : fileArr){
//                files.add(file2);
//            }
//        }
//
//        String fileName = taskName + ".zip";
//        String outFilePath = "F://";
//        File fileZip = new File(outFilePath + fileName);//临时文件
//
//        FileOutputStream outputStream = null;
//        ZipOutputStream zipOutputStream = null;
//        try{
//            outputStream = new FileOutputStream(fileZip);
//            zipOutputStream = new ZipOutputStream(outputStream);
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//            System.out.println("临时压缩包异常");
//        }
//
//        try{
//            zipFile(files, zipOutputStream);
//            zipOutputStream.close();
//            outputStream.close();
//            //this.downloadFile(fileZip, response,true);
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (ServletException e){
//            e.printStackTrace();;
//        }
//    }

}
