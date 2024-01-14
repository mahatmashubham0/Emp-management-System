/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DbConnection;
import empmgmt.pojo.Employees;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmpDao {
    public static boolean addEmp(Employees e)throws SQLException {
        Connection con = DbConnection.DbConnection();
        PreparedStatement ps = con.prepareStatement("insert into emp value(?,?,?)");
        ps.setInt(1,e.getEmpNO());
        ps.setString(2,e.getEmpName());
        ps.setDouble(3,e.getEmpSal());
        int result = ps.executeUpdate(); // if we want to insert data only use executeUpdate
        
        return 1 == result;
    }
    
    public static Employees findEmpByEmpNO(int empNo)throws SQLException {
        Connection con = DbConnection.DbConnection();
        PreparedStatement ps = con.prepareStatement("select * from emp where empNO = ?");
        ps.setInt(1, empNo);
        ResultSet rs = ps.executeQuery();
        Employees e = null;
        if(rs.next()) {
            e = new Employees();
            e.setEmpNO(empNo);
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
        }
        return e;
    }
    
    public static List<Employees> getAllEmployees()throws SQLException {
        Connection con = DbConnection.DbConnection();
        Statement st = con.createStatement();
        List<Employees> empList = new ArrayList<>();
        ResultSet rs = st.executeQuery("select * from emp");
        while(rs.next()) {
            Employees e = new Employees(rs.getInt(1),rs.getString(2),rs.getDouble(3));
            empList.add(e);
        }
        return empList;
    }
}
