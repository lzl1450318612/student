package com.xiongantaoli.grade.Service;

import java.util.List;
import com.xiongantaoli.grade.entity.Student;


/**
 * @Author：  宋博通
 * @Date： 2019/1/12
 * @Description： 接收未收到邮件的学生列表的service
 */
public interface GetEmailService {
    public List<Student> getEmail();
}
