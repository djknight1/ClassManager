package com.iloooo.utils;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

//  /home/feng/wepapp/root/WEB-INF/file/   taskPath/filename .doc(suffix)
public  class FileUtils {
    public static String FILE_PATH_PREFIX = "/WEB-INF/file/";

    public    static boolean update(MultipartFile file,String path,String serverPath) {
        int flag = 0;
        if (null != file) {
            String fullPath = serverPath + path;
            System.out.println(fullPath);
            for (int i = fullPath.length()-1; i >=0 ; i--) {
                if(fullPath.charAt(i)=='\\'){
                    flag = i;
                    break;
                }
            }
            String prefix= (serverPath+path).substring(0,flag+1);//文件保存路径
            System.out.println(prefix);
            //             ....../WEB-INF/file/2222/1160299021sfdsfsd.doc
            File fileDir=new File(prefix);
            System.out.println(fileDir.mkdirs());

            File localFile = new File(serverPath+path);
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
