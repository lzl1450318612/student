package com.xiongantaoli.grade.controllers;



import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;

import com.xiongantaoli.grade.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiongantaoli.grade.entity.Student;
import com.xiongantaoli.grade.mapper.StudentMapper;
import com.xiongantaoli.grade.Service.GetEmailService;
import com.xiongantaoli.grade.util.Sendmail;

/**
 * @Author： 宋博通
 * @Date： 2019/1/16
 * @Description： This is a class
 */
@ResponseBody
@Controller
public class SendEmailController {

    @Autowired
    private GetEmailService getEmailService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/sendmail",produces = "application/json", consumes = "application/json")
    public Integer email(@RequestBody Long[] ids)
    {
    	//群发件到学生列表
    	int j = 0;
    	if(ids.length == 0) {
    		List<Student> AA=getEmailService.getEmail();

    		System.out.print("");
    		System.out.print(AA.get(0).getEmail());
    		System.out.print(AA.get(0).getMarkercomments());
    		System.out.print("");

    		for(int i = 0;i < AA.size(); i ++) {
    			String toEmail = (String)AA.get(i).getEmail();
    			String subjects = "Your grade has been delivered";
    			String contents0 = "Name: "+(String)AA.get(i).getGivenname()+" "+(String)AA.get(i).getSurname()
    					+"                "+"Score: "+(String)AA.get(i).getMarkercomments()
    					+"                "+"Comment: "+(String)AA.get(i).getMarkercomments()
    					+"                "+"Given By Teacher: "+(String)AA.get(i).getUsername();						
    			String contents = contents0;
    			String fujian = "C:\\Users\\Song\\Desktop\\index.html";
    			try {
    				Sendmail.send_email(toEmail,subjects,contents,fujian);
    			} catch (IOException | MessagingException e) {
    				// TODO Auto-generated catch block
    				j++;
    			}   	
    		}
    	}else {

    		for (long id : ids) {
    			Student BB = studentService.selectByPrimaryKey(id);

    			String toEmail = (String)BB.getEmail();
    			String subjects = "Your grade has been delivered";
    			String contents0 = "Name: "+(String)BB.getGivenname()+" "+(String)BB.getSurname()
						+"                "+"Score: "+(String)BB.getMarkercomments()
						+"                "+"Comment: "+(String)BB.getMarkercomments()
						+"                "+"Given By Teacher: "+(String)BB.getUsername();						
    			String contents = contents0;
    			String fujian = "C:\\Users\\Song\\Desktop\\index.html";
    			try {
    				Sendmail.send_email(toEmail,subjects,contents,fujian);
    			} catch (IOException | MessagingException e) {
    				// TODO Auto-generated catch block
    				j++;
    			} 
    		}
    	}
    	return j;
    }

}
