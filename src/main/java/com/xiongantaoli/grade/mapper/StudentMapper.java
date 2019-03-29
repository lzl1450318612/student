package com.xiongantaoli.grade.mapper;


import com.xiongantaoli.grade.entity.Marker;
import com.xiongantaoli.grade.entity.Student;
import com.xiongantaoli.grade.entity.StudentsOfScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Long studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long studentid);

    List<Student> selectAllStudent(); // 查找所有学生

    List<Student> selectStudent(@Param("student")Student student,@Param("startScore")Integer startScore,@Param("endScore")Integer endScore);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectByMarkerName(@Param("markerName")String markerName); // 根据判卷人姓名查询学生

    Double selectAllAverage(); //查询所有学生平均分

    Double selectSelfAverage(@Param("markerName")String markerName); // 查询单独一个判卷人所判学生的平均分

    List<Marker> selectAllMarkerAverage(); // 查询出所有判卷人

    List<StudentsOfScore> selectStudentsOfScore();
}
