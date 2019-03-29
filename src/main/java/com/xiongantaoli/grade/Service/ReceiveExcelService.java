package com.xiongantaoli.grade.Service;

import com.xiongantaoli.grade.model.ExcelStatus;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @Author： LZL
 * @Date： 2019/1/12
 * @Description： 接收excel的service
 */
public interface ReceiveExcelService {

    /**
     * @Description: 用来接收excel的方法
     * @Param:  request HttpRequest请求对象
     * @return:
     * @Author: LZL
     * @Date: 2019/1/12
     */
    public List<com.xiongantaoli.grade.model.ExcelStatus> handleExcel(MultipartFile file , HttpServletRequest request , List<com.xiongantaoli.grade.model.ExcelStatus> errorPointList) throws IOException, InvalidFormatException;

    /**
     * @Description: 用来解析并将excel中数据存入数据库的方法
     * @Param:
     * @return:
     * @Author: LZL
     * @Date: 2019/1/12
     */
    public List<ExcelStatus> parseExcel(String path) throws IOException, InvalidFormatException;
}
