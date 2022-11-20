package com.test.pojo;

public class UserInfo {
    private String sUserId;
    private String sPasswd;
    private String sUname;
    private String sEmail;
    private String sRole;

    public String getsUserId() {
        return sUserId;
    }

    public void setsUserId(String sUserId) {
        this.sUserId = sUserId;
    }

    public String getsPasswd() {
        return sPasswd;
    }

    public void setsPasswd(String sPasswd) {
        this.sPasswd = sPasswd;
    }

    public String getsUname() {
        return sUname;
    }

    public void setsUname(String sUname) {
        this.sUname = sUname;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsRole() {
        return sRole;
    }

    public void setsRole(String sRole) {
        this.sRole = sRole;
    }
}
