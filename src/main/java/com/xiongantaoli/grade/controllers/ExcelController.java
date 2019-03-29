package com.xiongantaoli.grade.controllers;


import com.xiongantaoli.grade.Service.DownloadService;
import com.xiongantaoli.grade.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author： LZL
 * @Date： 2019/1/12
 * @Description： 这是处理excel的controller
 */

@Controller
public class ExcelController {

    @Autowired
    private DownloadService downloadService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    /**
     * @Description: 用来导出所有excel的controller方法
     * @Param: [request, response]
     * @return: void
     * @Author: LZL
     * @Date: 2019/1/14
     */

//    @RequestMapping(value="/downloadExcel")
//    public String downloadExcel()
//    {	
//    	
//        boolean flag = false;
//        try {
//            flag = downloadService.download(downloadService.createExcel(request, ExcelUtil.EXCEL_HIGHVERSION), "MyExcel.xlsx"); // 下载excel
//        }catch (Exception e)
//        {
//            flag = false;
//        }
//        return "forward:/student/list?flag="+flag;
//    }


    /**
     * @Description: 根据选中的学生id导出部分excel的方法
     * @Param: [ids 学生id]
     * @return: java.util.Map<java.lang.String,java.lang.String>
     * @Author: HRX
     * @Date: 2019/1/19
     */
    @ResponseBody
    @RequestMapping(value="/downloadPartExcel")
    public Map<String,String> downloadPartExcel(@RequestBody Long[] ids)
    {

    	for(Long id : ids)
    		System.out.println(id);
    	
        boolean flag = false;
        Map<String,String> result = new HashMap<String,String>();
        try {
            flag = true;
            File file = downloadService.downloadPartExcel(ExcelUtil.EXCEL_HIGHVERSION ,ids);
            FileInputStream inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int)file.length()];
            inputFile.read(buffer);
            inputFile.close();
            result.put("file", Base64Utils.encodeToString(buffer));
            result.put("filename", "MyExcel.xlsx");
        }catch (Exception e)
        {
            flag = false;
        }
        return result;
    }


}
