package org.exemple.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    //Wild pediu para comentar: java.sql
    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = LoadProperties();

                String url = props.getProperty("dburl");

                conn = DriverManager.getConnection(url, props);

            }catch (SQLException e){
                throw new BdException(e.getMessage());
            }

        }

        return conn;
    }

    public static void closeConnection(){
        if (conn != null){

            try{
                conn.close();

            }catch (SQLException e){
                throw new BdException(e.getMessage());
            }
        }
    }

    public static Properties LoadProperties(){

        try(FileInputStream fs = new FileInputStream("bd.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch (IOException e){
            throw new BdException(e.getMessage());
        }
    }
}