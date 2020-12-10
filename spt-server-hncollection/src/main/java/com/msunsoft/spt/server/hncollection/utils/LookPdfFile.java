package com.msunsoft.spt.server.hncollection.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class LookPdfFile {
    public static void lookPdfFile(String fileUrl, HttpServletResponse response) throws UnsupportedEncodingException {
        File file=new File("D:\\temp\\"+fileUrl);
        System.out.println("fileUrl==========================="+ fileUrl);

        String fileName=null;
        try {
            fileName=new String(fileUrl.getBytes("UTF-8"), "ISO-8859-1");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;fileName="+fileName);
        try {
            InputStream inputStream = new FileInputStream(file.getPath());
            OutputStream outputStream = response.getOutputStream();

            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
