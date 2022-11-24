package com.test.pojo;

public class Course {
    private String sCourseNo;
    private String sCname;
    private String dtOpenDate;
    private String sTeacher;
    private int iWeekCnt;
    private String sIndexURL;
    private String sStatuse;

    public String getsCourseNo() {
        return sCourseNo;
    }

    public void setsCourseNo(String sCourseNo) {
        this.sCourseNo = sCourseNo;
    }

    public String getsCname() {
        return sCname;
    }

    public void setsCname(String sCname) {
        this.sCname = sCname;
    }

    public String getDtOpenDate() {
        return dtOpenDate;
    }

    public void setDtOpenDate(String dtOpenDate) {
        this.dtOpenDate = dtOpenDate;
    }

    public String getsTeacher() {
        return sTeacher;
    }

    public void setsTeacher(String sTeacher) {
        this.sTeacher = sTeacher;
    }

    public int getiWeekCnt() {
        return iWeekCnt;
    }

    public void setiWeekCnt(int iWeekCnt) {
        this.iWeekCnt = iWeekCnt;
    }

    public String getsIndexURL() {
        return sIndexURL;
    }

    public void setsIndexURL(String sIndexURL) {
        this.sIndexURL = sIndexURL;
    }

    public String getsStatuse() {
        return sStatuse;
    }

    public void setsStatuse(String sStatuse) {
        this.sStatuse = sStatuse;
    }
}
