package com.xiongantaoli.grade.entity;

public class Student {
    private Long studentid; // 学生id

    private String surname; //学生的surName

    private String givenname; // 学生的givenName

    private String email; // 学生的邮箱

    private String username; // 学生的userName

    private String markercomments; // 学生的教师评价

    private Integer score; // 学生的分数

    private String marker; // 此学生的判卷人

    public Student() {
    }

    public Student(Long studentid, String surname, String givenname, String email, String username, String markercomments, Integer score, String marker) {
        this.studentid = studentid;
        this.surname = surname;
        this.givenname = givenname;
        this.email = email;
        this.username = username;
        this.markercomments = markercomments;
        this.score = score;
        this.marker = marker;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", surname='" + surname + '\'' +
                ", givenname='" + givenname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", markercomments='" + markercomments + '\'' +
                ", score=" + score +
                ", marker='" + marker + '\'' +
                '}';
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname == null ? null : surname.trim();
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname == null ? null : givenname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMarkercomments() {
        return markercomments;
    }

    public void setMarkercomments(String markercomments) {
        this.markercomments = markercomments == null ? null : markercomments.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker == null ? null : marker.trim();
    }
}