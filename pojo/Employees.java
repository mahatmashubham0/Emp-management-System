/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author welcome
 */
public class Employees {

    public Employees(int empNO, String empName, double empSal) {
        this.empNO = empNO;
        this.empName = empName;
        this.empSal = empSal;
    }
    
    public Employees() {
        
    }
    
    private int empNO;
    private String empName;
    private double empSal;

    public int getEmpNO() {
        return empNO;
    }

    public void setEmpNO(int empNO) {
        this.empNO = empNO;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }
    
}
