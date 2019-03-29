package com.xiongantaoli.grade.ServiceImpl;

import com.xiongantaoli.grade.entity.Student;
import com.xiongantaoli.grade.mapper.StudentMapper;
import com.xiongantaoli.grade.model.ExcelStatus;
import com.xiongantaoli.grade.Service.ReceiveExcelService;
import com.xiongantaoli.grade.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： LZL
 * @Date： 2019/1/12
 * @Description： 用来接收excel的serviceImpl
 */

@Service("receiveExcel")
public class ReceiveExcelServiceImpl implements ReceiveExcelService {

    @Autowired
    private StudentMapper studentMapper;


    /**
     * @Description: 此方法用来接收excel并且调用方法来解析excel
     * @Param: [excelFile, request]
     * @return: boolean
     * @Author: LZL
     * @Date: 2019/1/17
     */
    @Override
    public List<ExcelStatus> handleExcel(MultipartFile excelFile , HttpServletRequest request , List<ExcelStatus> errorPointList) throws IOException, InvalidFormatException {
        //获取excel文件
        DiskFileItemFactory dfi = new DiskFileItemFactory();
        String fileName = excelFile.getOriginalFilename();
        String path = request.getServletContext().getRealPath("/") + "upload"; 	// 获得上传文件的存储路径
        File file=new File(path);
        path += File.separator + fileName;
        if(!file.exists()){
            file.mkdirs();
        }

        try {
            excelFile.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            List<ExcelStatus> fail = new ArrayList<ExcelStatus>();
            fail.add(new ExcelStatus(-1,-1));
            return fail;
        }
        try
        {
            errorPointList = parseExcel(path); // 解析excel文件并存入数据库,使用errorPointList获得发生错误的单元格坐标
        }
        catch (Exception e)
        {
            e.printStackTrace();
            List<ExcelStatus> fail = new ArrayList<ExcelStatus>();
            return fail;
        }

        System.out.println("存储路径："+path);
        new File(path).delete(); // 使用完成后删除用户的上传文件
        return errorPointList;
    }


    /**
     * @Description: 此方法用来解析excel文件并将数据存入数据库
     * @Param: [path] excel文件的路径
     * @return: void
     * @Author: LZL
     * @Date: 2019/1/12
     */
    @Transactional
    @Override
    public List<ExcelStatus> parseExcel(String path) throws InvalidFormatException, IOException {
        // 获取excel文件
        List<ExcelStatus> excelErrorPointList = new ArrayList<ExcelStatus>();
        Sheet sheet = null;
        try {
            NPOIFSFileSystem fs = null;
            fs = new NPOIFSFileSystem(new File(path));
            HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);
            fs.close();
            sheet = wb.getSheetAt(0); // 获取excel文件的第一个表（只有一个,所以索引是0）
        }
        catch (OfficeXmlFileException e)
        {
            // 如果产生这个异常，说明是xlsx类型而不是xls类型的文件，应该用XSSFWorkbook去读取而不是用HSSFWorkbook
            OPCPackage pkg = null;
            pkg = OPCPackage.open(new File(path));
            XSSFWorkbook wb = new XSSFWorkbook(pkg);
            pkg.close();
            sheet = wb.getSheetAt(0);
        }

        int rowNum = 0;
        boolean flag = false; // 用来标记当前是否有空单元格
        for(Row row:sheet) // 遍历这个表的所有行
        {
            if(rowNum == 0) // 跳过第一行标题行
            {
                rowNum++;
                continue;
            }
            System.out.println("===="+row.getFirstCellNum());
            System.out.println("===="+row.getLastCellNum());
//            if(ExcelUtil.isRowEmpty(row)) // 如果是空行就跳过
//            {
//                System.out.println("空行跳过");
//                continue;
//            }
            int length = row.getLastCellNum(); // 获取每一行有多少个单元格
            Student student = new Student();
            for (int i = 0;i<length;i++) // 遍历输出每一个单元格的值
            {
                Cell cell = row.getCell(i);
                if((cell == null||cell.getCellTypeEnum() == CellType.BLANK) && i != 5) // 表示此行存在空单元格
                {
                    flag = true;
                    System.out.println("此行存在空单元格，读取失败");
                    excelErrorPointList.add(new ExcelStatus(rowNum+1,i+1)); // 存储出错单元格的坐标
                }
                else
                {
                    switch (i) // 读取这行中各列的值封装成对象
                    {
                        case 0:
                            cell.setCellType(CellType.NUMERIC);
                            student.setStudentid((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            cell.setCellType(CellType.STRING);
                            student.setSurname(cell.getStringCellValue());
                            break;
                        case 2:
                            cell.setCellType(CellType.STRING);
                            student.setGivenname(cell.getStringCellValue());
                            break;
                        case 3:
                            cell.setCellType(CellType.STRING);
                            student.setEmail(cell.getStringCellValue());
                            break;
                        case 4:
                            cell.setCellType(CellType.STRING);
                            student.setUsername(cell.getStringCellValue());
                            break;
                        case 5:
                            if(cell == null || cell.getCellTypeEnum() == CellType.BLANK)
                            {
                                student.setMarkercomments("The student has no comments");
                                break;
                            }
                            else
                            {
                                cell.setCellType(CellType.STRING);
                                student.setMarkercomments(cell.getStringCellValue());
                                break;
                            }
                        case 6:
                            cell.setCellType(CellType.NUMERIC);
                            student.setScore((int) cell.getNumericCellValue());
                            break;
                        case 7:
                            cell.setCellType(CellType.STRING);
                            student.setMarker(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
            }
            rowNum++;
            if(!flag) //如果此行没有空单元格，才把这一行的数据插入数据库并输出
            {
                System.out.println(student.toString());

                //将这行数据插入到数据库
                try {
                    studentMapper.insert(student);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    flag = true;
                }
            }
        }

        System.out.println(flag);
        if(flag)
        {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); // 如果有错，触发事务回滚
        }
        else
        {
            excelErrorPointList.add(new ExcelStatus(-1,-1)); // 如果没有错误的单元格则将返回数组的第一个对象的坐标设置成（-1,-1）
        }
        return excelErrorPointList;
    }
}
