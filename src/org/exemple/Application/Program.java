package org.exemple.Application;

import org.exemple.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DB.getConnection();

            st = conn.createStatement();
            rs = st.executeQuery("select * from department");

            while(rs.next()){
                System.out.println(rs.getInt("id") + " - "
                        + rs.getString("Name"));
            }

        }catch(SQLException e){
            e.printStackTrace();

        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection();
        }


        try{

            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from seller");

            while(rs.next()){
                System.out.println(rs.getInt("id") + " - "
                        + rs.getString("Name") + " - "
                        + rs.getString("Email") + " - "
                        + rs.getDate("BirthDate") + " - "
                        + rs.getDouble("BaseSalary") + " - "
                        + rs.getInt("DepartmentId")
                );
            }

        }catch(SQLException e){
            e.printStackTrace();

        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection();
        }

    }

}