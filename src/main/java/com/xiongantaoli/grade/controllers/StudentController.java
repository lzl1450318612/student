package com.xiongantaoli.grade.controllers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiongantaoli.grade.Service.StudentService;
import com.xiongantaoli.grade.entity.Student;
import com.xiongantaoli.grade.security.controller.ResourceController;
import com.xiongantaoli.grade.Service.ReceiveExcelService;
import com.xiongantaoli.grade.util.Utility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生成绩管理
 *
 * @author lhl
 *
 */
@Controller
@Transactional
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private StudentService studentService;
    @Autowired
    private HttpSession session;


    /**
     * @Description: 加载判卷人页面数据的controller
     * @Param: [model, pageNo, pageSize, studentid, startScore, endScore, result, updateResult, errorPointList]
     * @return: java.lang.String
     * @Author: LZL
     * @Date: 2019/1/20
     */
    @RequestMapping(value = "/selflist")
    public String selfIndex(Model model,
                            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, // 页码
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize, // 页面容纳条数
                            @RequestParam(value = "studentid", required = false, defaultValue = "") Long studentid, // 学生id
                            @RequestParam(value = "startScore", required = false, defaultValue = "0") Integer startScore, // 分数开始范围
                            @RequestParam(value = "endScore", required = false, defaultValue = "10") Integer endScore, // 分数结束范围
                            @RequestParam(value = "result", required = false, defaultValue = "") String result, // 上传excel结果
                            @RequestParam(value = "updateresult", required = false, defaultValue = "") String updateResult, // 修改结果
                            @RequestParam(value = "errorPointList", required = false, defaultValue = "") String errorPointList //错误excel单元格
                             )
    {

        String marker = Utility.getCurrentUsername(); // 获取当前登录的判卷人姓名

        Student student = new Student();

        student.setMarker(marker.trim()); // 设置查找此判卷人判的学生
        model.addAttribute("marker", marker.trim());

        System.out.println(model.toString());
        if (studentid != null && !"".equals(studentid)) {
            student.setStudentid(studentid);
            model.addAttribute("studentId", studentid);
        }

        PageHelper.startPage(pageNo, pageSize);
        List<Student> list = studentService.selectStudent(student,startScore,endScore); //获取学生信息

        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        if(!list.isEmpty())
        {
            double average = studentService.selectSelfAverage(marker); // 获取此判卷人所判学生的平均分
            //保留两位小数
            DecimalFormat df = new DecimalFormat("#.00");
            String average0  = df.format(average);
            model.addAttribute("average",average0);
        }
        if (pageNo > pageInfo.getPages())
        {
            pageNo = pageInfo.getPages();
            PageHelper.startPage(pageNo, pageSize);
            list = studentService.selectStudent(student,startScore,endScore);
            pageInfo = new PageInfo<Student>(list);
        }


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("uploadResult",result);
        model.addAttribute("updateResult",updateResult);
        model.addAttribute("errorPointList",errorPointList);

        return "student/selflist";
    }


    /**
     * 管理员加载数据的controller
     *
     * @return
     */
    @PreAuthorize("hasAuthority('/student/list')")
    @RequestMapping(value = "/list")
    public String index(Model model,
                        @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, // 页码
                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize, //页面容纳条数
                        @RequestParam(value = "marker", required = false, defaultValue = "") String marker, //判卷人
                        @RequestParam(value = "studentid", required = false, defaultValue = "") Long studentid, // 学生id
                        @RequestParam(value = "startScore", required = false, defaultValue = "0") Integer startScore, // 分数开始范围
                        @RequestParam(value = "endScore", required = false, defaultValue = "10") Integer endScore, // 分数结束范围
                        @RequestParam(value = "result", required = false, defaultValue = "") String result, // 上传excel结果
                        @RequestParam(value = "flag", required = false, defaultValue = "") String flag, // 下载结果
                        @RequestParam(value = "updateresult", required = false, defaultValue = "") String updateResult, // 修改结果
                        @RequestParam(value = "errorPointList", required = false, defaultValue = "") String errorPointList //错误excel单元格
                        ) {
        Student student = new Student();
        if (marker != null && !"".equals(marker.trim())) {
            student.setMarker(marker.trim());
            model.addAttribute("marker", marker.trim());
        }
        System.out.println(model.toString());
        if (studentid != null && !"".equals(studentid)) {
            student.setStudentid(studentid);
            model.addAttribute("studentId", studentid);
        }
        PageHelper.startPage(pageNo, pageSize);
        List<Student> list = studentService.selectStudent(student,startScore,endScore); // 查询学生信息

        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        if(!list.isEmpty())
        {
            double average = studentService.selectAllAverage(); // 获取平均分
            //保留两位小数
            DecimalFormat df = new DecimalFormat("#.00");
            String average0 = df.format(average);
            model.addAttribute("average", average0);
        }
        if (pageNo > pageInfo.getPages()) {
            pageNo = pageInfo.getPages();
            PageHelper.startPage(pageNo, pageSize);
            list = studentService.selectStudent(student,startScore,endScore);
            pageInfo = new PageInfo<Student>(list);
        }


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("uploadResult",result);
        model.addAttribute("downloadResult",flag);
        model.addAttribute("updateResult",updateResult);
        model.addAttribute("errorPointList",errorPointList);

        return "student/list";
    }

    /**
     * 删除
     *
     * @param
     * @param
     * @return
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/delete", produces = "application/json", consumes = "application/json")
    public Integer delete(@RequestBody Long[] ids) {
        try {
            for (long id : ids) {
                studentService.deleteByPrimaryKey(id); // 删除学生
            }
            return 1;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return 0;
    }


    /**
     * @Description: 修改学生信息的controller
     * @Param: [model, studentId, surname, givenName, email, userName, markerComments, score, marker]
     * @return: java.lang.String
     * @Author: LZL
     * @Date: 2019/1/20
     */
    @Transactional
    @RequestMapping(value = "/changeStu", produces = "application/json")
    public String changeStuInfo(Model model,@RequestParam(value = "stuId", required = true, defaultValue = "") Long studentId, // 学生的id
                              @RequestParam(value = "surname", required = true, defaultValue = "") String surname, // 学生的surname
                              @RequestParam(value = "givenName", required = true, defaultValue = "") String givenName, // 学生的givenname
                              @RequestParam(value = "email", required = true, defaultValue = "") String email, // 学生的邮箱
                              @RequestParam(value = "userName", required = true, defaultValue = "") String userName, // 学生的username
                              @RequestParam(value = "markerComments", required = true, defaultValue = "The student has no comments") String markerComments, // 评语
                              @RequestParam(value = "score", required = true, defaultValue = "") Integer score, // 分数
                              @RequestParam(value = "marker", required = true, defaultValue = "") String marker // 判卷人
                            )
    {
        Student student = new Student(studentId,surname,givenName,email,userName,markerComments,score,marker);
        int result = 0;
        try {
            result = studentService.updateByPrimaryKey(student); // 修改学生信息
        }catch (Exception e)
        {
            result = 0;
        }
        model.addAttribute("updateResult",result);
        return "forward:/student/list?updateresult="+result;
    }

    @Autowired
    private ReceiveExcelService receiveExcel;

    /**
     * @Description: 用来处理excel的controller方法
     * @Param: [request 用户发来的请求]
     * @return: void
     * @Author: LZL
     * @Date: 2019/1/12
     */

    @RequestMapping(value = "/excel")
    public String excel(Model model,
                        @RequestParam(value = "excel_input") MultipartFile file ,
                        HttpServletRequest request,
                        @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                        @RequestParam(value = "marker", required = false, defaultValue = "") String marker,
                        @RequestParam(value = "studentid", required = false, defaultValue = "") Long studentid)
    {
        String result = "false";
        List<com.xiongantaoli.grade.model.ExcelStatus> errorPointList = new ArrayList();
        try {
            errorPointList = receiveExcel.handleExcel(file,request,errorPointList); // 解析excel并插入数据库
        } catch (IOException e) {
            e.printStackTrace();
            result = "false";
            return "student/list";
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            result = "false";
            return "student/list";
        }
        if(errorPointList.isEmpty()) // 如果错误单元格列表为空，说明不正常（即使插入成功也应该有错误单元格列表，只不过只有一个元素，坐标是-1，-1）
        {
            result = "false";
        }
        else if(errorPointList.get(0).getLine() != -1) // 如果第一个元素的坐标不是-1，-1，说明插入有误
        {
            model.addAttribute("errorPointList",errorPointList);
            result = "false";
        }
        else // 插入成功
        {
            result = "true";
        }
        model.addAttribute("uploadResult",result);
        System.out.println(result);

        // 以下是重新加载页面数据来刷新页面
        Student student = new Student();

        if (marker != null && !"".equals(marker.trim())) {
            student.setMarker(marker.trim());
            model.addAttribute("marker", marker.trim());
        }
        System.out.println(model.toString());
        if (studentid != null && !"".equals(studentid)) {
            student.setStudentid(studentid);
            model.addAttribute("studentId", studentid);
        }
        PageHelper.startPage(pageNo, pageSize);

        List<Student> list = studentService.selectStudent(student,0,10);

        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        if (pageNo > pageInfo.getPages()) {
            pageNo = pageInfo.getPages();
            PageHelper.startPage(pageNo, pageSize);
            list = studentService.selectStudent(student,0,10);
            pageInfo = new PageInfo<Student>(list);
        }
        model.addAttribute("pageInfo", pageInfo);
        return "student/list";
    }

    @RequestMapping(value = "/getStatistic")
    public String getStatistic(Model model)
    {
        model.addAttribute("statistic",studentService.getStatics());
        return "student/statistic";
    }

    @RequestMapping(value = "/userexcel")
    public String userExcel(Model model,
                        @RequestParam(value = "excel_input") MultipartFile file ,
                        HttpServletRequest request,
                        @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                        @RequestParam(value = "studentid", required = false, defaultValue = "") Long studentid)
    {

        String result = "false";
        List<com.xiongantaoli.grade.model.ExcelStatus> errorPointList = new ArrayList();
        try {
            errorPointList = receiveExcel.handleExcel(file,request,errorPointList);
        } catch (IOException e) {
            e.printStackTrace();
            result = "false";
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            result = "false";
        }
        if(errorPointList.isEmpty())
        {
            result = "false";
        }
        else if(errorPointList.get(0).getLine() != -1)
        {
            model.addAttribute("errorPointList",errorPointList);
            result = "false";
        }
        else
        {
            result = "true";
        }
        model.addAttribute("uploadResult",result);
        System.out.println(result);
        Student student = new Student();

        //以下是根据marker的名字获取所判学生的信息

        String marker = Utility.getCurrentUsername();

        student.setMarker(marker.trim());
        model.addAttribute("marker", marker.trim());

        System.out.println(model.toString());
        if (studentid != null && !"".equals(studentid)) {
            student.setStudentid(studentid);
            model.addAttribute("studentId", studentid);
        }
        PageHelper.startPage(pageNo, pageSize);

        List<Student> list = studentService.selectStudent(student,0,10);

        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        if (pageNo > pageInfo.getPages()) {
            pageNo = pageInfo.getPages();
            PageHelper.startPage(pageNo, pageSize);
            list = studentService.selectStudent(student,0,10);
            pageInfo = new PageInfo<Student>(list);
        }
        model.addAttribute("pageInfo", pageInfo);
        return "student/selflist";
    }
}
