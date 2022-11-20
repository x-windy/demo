package com.test.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest {
    @Test
    void getConnTest(){
        Connection connection = DBUtil.getConn();
        System.out.println(connection);
    }


}