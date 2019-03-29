package com.xiongantaoli.grade.model;

import com.xiongantaoli.grade.entity.Marker;
import com.xiongantaoli.grade.entity.StudentsOfScore;

import java.util.List;

/**
 * @Author： LZL
 * @Date： 2019/1/26
 * @Description： This is a class
 */
public class Statistic {
    private List<Marker> marker;
    private int[] studentsOfScores;

    public List<Marker> getMarker() {
        return marker;
    }

    public void setMarker(List<Marker> marker) {
        this.marker = marker;
    }

    public Statistic() {
    }

    public Statistic(List<Marker> marker, int[] studentsOfScores) {
        this.marker = marker;
        this.studentsOfScores = studentsOfScores;
    }

    public int[] getStudentsOfScores() {
        return studentsOfScores;
    }

    public void setStudentsOfScores(int[] studentsOfScores) {
        this.studentsOfScores = studentsOfScores;
    }
}
