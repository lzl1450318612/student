package com.xiongantaoli.grade.ServiceImpl;


import com.xiongantaoli.grade.entity.Student;
import com.xiongantaoli.grade.mapper.StudentMapper;
import com.xiongantaoli.grade.Service.DownloadService;
import com.xiongantaoli.grade.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： LZL
 * @Date： 2019/1/13
 * @Description： 下载Service的实现类
 */
@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private HttpServletRequest request;
//    @Autowired
//    private HttpServletResponse response;

//    @Override
//    public File createExcel(HttpServletRequest request, int version) {
//        Workbook wb = null;
//        OutputStream fileOut = null;
//        File file = null;
//        String path = request.getServletContext().getRealPath("/") + "download";
//        File fileDir = new File(path);
//
//        if(!fileDir.exists())//如果目录不存在，创建下载文件的根目录
//        {
//            fileDir.mkdir();
//        }
//
//        if(version == ExcelUtil.EXCEL_LOWVERSION) // 如果想生成2007以下版本的excel
//        {
//            wb = new HSSFWorkbook();
//            file = new File(path + File.separator + "workbook.xlsx");
//        }
//        else // 如果想生成2007以上版本的excel
//        {
//            wb = new XSSFWorkbook();
//            file = new File(path + File.separator + "workbook.xlsx");
//        }
//        CreationHelper creationHelper = wb.getCreationHelper();
//
//        Sheet sheet = wb.createSheet("new sheet"); // 建excel中的一个表
//
//        // 从数据库中查询出所有学生
//        List<Student> studentList = studentMapper.selectAllStudent();
//
//        int rowCount = 1;
//
//        Row rowTile = sheet.createRow(0);
//
//        // 输入列名
//        rowTile.createCell(0).setCellValue("Student ID");
//        rowTile.createCell(1).setCellValue("Surname");
//        rowTile.createCell(2).setCellValue("Given Name");
//        rowTile.createCell(3).setCellValue("Email");
//        rowTile.createCell(4).setCellValue("Username");
//        rowTile.createCell(5).setCellValue("Marker Comments");
//        rowTile.createCell(6).setCellValue("Score/10");
//        rowTile.createCell(7).setCellValue("Marker");
//
//
//        for(Student s : studentList) // 遍历查询出的学生
//        {
//            System.out.println(s.toString());
//            Row row = sheet.createRow(rowCount); // 新建一行
//            for(int j = 0;j < 8;j++)
//            {
//                switch (j) // 新建单元格并赋值
//                {
//                    case 0:
//                        row.createCell(j).setCellValue(s.getStudentid());
//                        break;
//                    case 1:
//                        row.createCell(j).setCellValue(s.getSurname());
//                        break;
//                    case 2:
//                        row.createCell(j).setCellValue(s.getGivenname());
//                        break;
//                    case 3:
//                        row.createCell(j).setCellValue(s.getEmail());
//                        break;
//                    case 4:
//                        row.createCell(j).setCellValue(s.getUsername());
//                        break;
//                    case 5:
//                        row.createCell(j).setCellValue(creationHelper.createRichTextString(s.getMarkercomments()));
//                        break;
//                    case 6:
//                        row.createCell(j).setCellValue(s.getScore());
//                        break;
//                    case 7:
//                        row.createCell(j).setCellValue(s.getMarker());
//                        break;
//                    default:
//                        break;
//                }
//            }
//            rowCount++;
//        }
//
//        try {
//            fileOut = new FileOutputStream(file);
//            // 写入excel文件
//            wb.write(fileOut);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }catch (IOException e)
//        {
//            e.printStackTrace();
//            return null;
//        }
//        try {
//            fileOut.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return file;
//    }

    /**
     * @Description: 下载的方法
     * @Param: [response HttpServletResponse对象, file 要下载的在服务器中的文件, FileName 用户下载时候的默认文件名]
     * @return: boolean 下载成功返回true，失败返回false
     * @Author: LZL
     * @Date: 2019/1/13
     */
//    @Override
//    public boolean download(File file, String fileName)
//    {
//    	try {
//			response.getOutputStream().close();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        if(file == null)
//        {
//            return false;
//        }
//        if(file.exists())
//        {
//            //判断文件父目录是否存在
//            response.setHeader("content-type", "application/octet-stream");
//            response.setContentType("application/octet-stream");
//            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);  //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
//            byte[] buff = new byte[1024];    //5.创建数据缓冲区
//            BufferedInputStream bis = null;
//            OutputStream os = null;
//            try {
//            	System.out.println("--------------------------");
//                os = response.getOutputStream(); //6.通过response对象获取OutputStream流
//                FileInputStream fileInputStream = new FileInputStream(file);
//                response.setHeader("Content-Length", String.valueOf(fileInputStream.getChannel().size()));
//                bis = new BufferedInputStream(fileInputStream);     //4.根据文件路径获取要下载的文件输入流
//                int i = bis.read(buff);         //7.将FileInputStream流写入到buffer缓冲区
//                while (i != -1) {
//                    os.write(buff, 0, buff.length); //8.使用将OutputStream缓冲区的数据输出到客户端浏览器
//                    os.flush();
//                    i = bis.read(buff);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (bis != null) {
//                    try {
//                        bis.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            try {
//                os.close();
//                bis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        
//        return true;
//    }

	@Override
	public File downloadPartExcel(int version, Long[] ids) {
		Workbook wb = null;
        OutputStream fileOut = null;
        File file = null;
        String path = request.getServletContext().getRealPath("/") + "download";
        File fileDir = new File(path);

        if(!fileDir.exists())//如果目录不存在，创建下载文件的根目录
        {
            fileDir.mkdir();
        }

        if(version == ExcelUtil.EXCEL_LOWVERSION) // 如果想生成2007以下版本的excel
        {
            wb = new HSSFWorkbook();
            file = new File(path + File.separator + "workbook.xlsx");
        }
        else // 如果想生成2007以上版本的excel
        {
            wb = new XSSFWorkbook();
            file = new File(path + File.separator + "workbook.xlsx");
        }
        CreationHelper creationHelper = wb.getCreationHelper();

        Sheet sheet = wb.createSheet("new sheet"); // 建excel中的一个表
        
        List<Student> studentList = new ArrayList<Student>();
        // 从数据库中查询出所有学生
        if(ids == null || ids.length == 0) {
        	studentList = studentMapper.selectAllStudent();
        }
        else {
	        for(Long id : ids) {
	        	Student student = studentMapper.selectByPrimaryKey(id);
	        	studentList.add(student);
	        }
        }

        int rowCount = 1;

        Row rowTile = sheet.createRow(0);

        // 输入列名
        rowTile.createCell(0).setCellValue("Student ID");
        rowTile.createCell(1).setCellValue("Surname");
        rowTile.createCell(2).setCellValue("Given Name");
        rowTile.createCell(3).setCellValue("Email");
        rowTile.createCell(4).setCellValue("Username");
        rowTile.createCell(5).setCellValue("Marker Comments");
        rowTile.createCell(6).setCellValue("Score/10");
        rowTile.createCell(7).setCellValue("Marker");


        for(Student s : studentList) // 遍历查询出的学生
        {
            System.out.println(s.toString());
            Row row = sheet.createRow(rowCount); // 新建一行
            for(int j = 0;j < 8;j++)
            {
                switch (j) // 新建单元格并赋值
                {
                    case 0:
                        row.createCell(j).setCellValue(s.getStudentid());
                        break;
                    case 1:
                        row.createCell(j).setCellValue(s.getSurname());
                        break;
                    case 2:
                        row.createCell(j).setCellValue(s.getGivenname());
                        break;
                    case 3:
                        row.createCell(j).setCellValue(s.getEmail());
                        break;
                    case 4:
                        row.createCell(j).setCellValue(s.getUsername());
                        break;
                    case 5:
                        row.createCell(j).setCellValue(creationHelper.createRichTextString(s.getMarkercomments()));
                        break;
                    case 6:
                        row.createCell(j).setCellValue(s.getScore());
                        break;
                    case 7:
                        row.createCell(j).setCellValue(s.getMarker());
                        break;
                    default:
                        break;
                }
            }
            rowCount++;
        }

        try {
            fileOut = new FileOutputStream(file);
            // 写入excel文件
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        try {
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
	}
}
