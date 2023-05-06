package com.example.collegeconnect;
public class Studentinfo {

    private String studentname;
    private String emailstudent;
    private String course;
    private String mobile;
    private String city;


    public Studentinfo() {

    }


    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getEmailstudent() {
        return emailstudent;
    }
    public void setEmailstudent(String emailstudent)
    {
        this.emailstudent=emailstudent;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }



}

