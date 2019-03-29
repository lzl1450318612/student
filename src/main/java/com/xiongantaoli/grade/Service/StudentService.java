package com.xiongantaoli.grade.Service;

import com.xiongantaoli.grade.entity.Student;
import com.xiongantaoli.grade.model.Statistic;
import java.util.List;

/**
 * @Author： LZL
 * @Date： 2019/1/19
 * @Description： This is a class
 */
public interface StudentService {

    int deleteByPrimaryKey(Long studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long studentid);

    List<Student> selectAllStudent(); // 查找所有学生

    List<Student> selectStudent(Student student, Integer startScore, Integer endScore);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectByMarkerName(String markerName); // 通过评卷人姓名查找学生

    Double selectAllAverage(); //查询所有学生平均分

    Double selectSelfAverage(String markerName); // 查询单独一个判卷人的平均分

    Statistic getStatics(); // 得到统计信息（包括每个判卷人的平均分，不同分段的学生人数）


}
