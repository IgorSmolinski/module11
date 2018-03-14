package com.igor.jdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManagerTestSuite {
        private static int counter=0;

        @Before
        public void startBefore(){
            counter++;
            System.out.println("*****************************");
            System.out.println("Start test number: " + counter);
            System.out.println("*****************************");
        }

        @Test
        public void testConnect() throws SQLException {
            //Given
            //When
            DBManager dbManager = DBManager.getInstance();
            //Then
            Assert.assertNotNull(dbManager.getConnection());
        }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DBManager dbManager = DBManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USER";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("SECONDNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUserAndPosts() throws SQLException{
        //Given
        DBManager dbManager = DBManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.SECONDNAME, P.USER_ID, COUNT(*) AS HOWMANYPOST\n" +
                "FROM USER AS U, POSTS AS P\n" +
                "WHERE P.USER_ID=U.ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*)>=2";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("HOWMANYPOST") + ", " +
                    rs.getString("U.FIRSTNAME") + ", " +
                    rs.getString("U.SECONDNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(2, counter);

    }
}
