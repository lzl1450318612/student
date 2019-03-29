package com.xiongantaoli.grade.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @Author： LZL
 * @Date： 2019/1/14
 * @Description： This is a class
 */
public interface DownloadService {

//    File createExcel(HttpServletRequest request, int version);
    
    /**
     * 用来到处部分数据
     * @param request
     * @param version
     * @author HRX
     * @return
     */
    File downloadPartExcel(int version , Long[] ids);

//    boolean download(File file, String FileName);
}
