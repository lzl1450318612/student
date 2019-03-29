package com.xiongantaoli.grade.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiongantaoli.grade.mapper.StudentMapper;
import com.xiongantaoli.grade.Service.GetEmailService;

/**
 * @Author：  宋博通
 * @Date： 2019/1/12
 * @Description： 用来获取未发送邮件的学生列表的serviceImpl
 */

@Service("GetEmailService")
public class GetEmailServiceImpl implements GetEmailService {
	
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public List<com.xiongantaoli.grade.entity.Student> getEmail() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllStudent();
	}

}


