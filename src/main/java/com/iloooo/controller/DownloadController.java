package com.iloooo.controller;

import com.iloooo.service.impl.DownloadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

import static com.iloooo.utils.DownloadUtils.zipFile;

@Controller
@RequestMapping("/download")
public class DownloadController {
    @Autowired
    private DownloadServiceImpl downloadService;

    @RequestMapping("")
    public String downloadFiles(HttpServletRequest request, HttpServletResponse response, String path, String taskName)
            throws ServletException, IOException{
        System.out.println("download");
        List<File> files = new ArrayList<File>();
        File allfile = new File(path);
        if (allfile.exists()){
            File[] fileArr = allfile.listFiles();
            for (File file2 : fileArr){
                files.add(file2);
            }
        }

        String fileName = taskName + ".zip";
        String outFilePath = "F://";
        File fileZip = new File(outFilePath + fileName);//临时文件

        FileOutputStream outputStream = null;
        ZipOutputStream zipOutputStream = null;
        try{
            outputStream = new FileOutputStream(fileZip);
            zipOutputStream = new ZipOutputStream(outputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("临时压缩包异常");
        }

        try{
            zipFile(files, zipOutputStream);
            zipOutputStream.close();
            outputStream.close();
            this.downloadFile(fileZip, response,true);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ServletException e){
            e.printStackTrace();;
        }

        return "admin";
    }

    public void downloadFile(File file, HttpServletResponse response, boolean isDelete) {
        try {
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("UTF-8"),"ISO-8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            if(isDelete)
            {
                file.delete();        //是否将生成的服务器端文件删除
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
