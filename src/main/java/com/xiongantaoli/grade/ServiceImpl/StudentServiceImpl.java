package com.xiongantaoli.grade.ServiceImpl;

import com.xiongantaoli.grade.Service.StudentService;
import com.xiongantaoli.grade.entity.Student;
import com.xiongantaoli.grade.entity.StudentsOfScore;
import com.xiongantaoli.grade.mapper.StudentMapper;
import com.xiongantaoli.grade.model.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： LZL
 * @Date： 2019/1/19
 * @Description： This is a class
 */

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Long studentid) {
        return studentMapper.deleteByPrimaryKey(studentid);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Long studentid) {
        return studentMapper.selectByPrimaryKey(studentid);
    }

    @Override
    public List<Student> selectAllStudent() {
        return studentMapper.selectAllStudent();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public List<Student> selectStudent(Student student, Integer startScore, Integer endScore) {
        return studentMapper.selectStudent(student, startScore, endScore);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> selectByMarkerName(String markerName) {
        return studentMapper.selectByMarkerName(markerName);
    }

    @Override
    public Double selectAllAverage() {
        return studentMapper.selectAllAverage();
    }

    @Override
    public Double selectSelfAverage(String markerName) {
        return studentMapper.selectSelfAverage(markerName);
    }

    @Override
    public Statistic getStatics() {
        List<StudentsOfScore> studentsOfScores = studentMapper.selectStudentsOfScore();
        List<StudentsOfScore> result = new ArrayList<>();
        int[] resultScores={0,0,0,0,0,0,0,0,0,0};
        for (StudentsOfScore s:studentsOfScores)
        {
            int a = (int) s.getScore();
            if(a == 10)
            {
                resultScores[9]+=s.getStudentNum();
            }
            resultScores[a]+=s.getStudentNum();
        }
        return new Statistic(studentMapper.selectAllMarkerAverage(),resultScores); // 返回统计数据
    }
}
