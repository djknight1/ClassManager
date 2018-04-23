package com.iloooo.utils;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

//  /home/feng/wepapp/root/WEB-INF/file/   taskPath/filename .doc(suffix)
public  class FileUtils {
    public static String FILE_PATH_PREFIX = "/WEB-INF/file/";

    public    static boolean update(MultipartFile file,String path,String serverPath) {
        if (null != file) {
            String fileName = file.getOriginalFilename();// 文件名称
            String prefix=serverPath+path.substring(path.lastIndexOf("/"));//文件保存路径

            File fileDir=new File(prefix);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
                return true;//fileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件为空");
        }
        return true;
    }

    public static String getFileSuffix(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }


}
