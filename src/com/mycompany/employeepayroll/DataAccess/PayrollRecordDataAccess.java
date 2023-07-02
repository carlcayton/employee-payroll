	/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll.DataAccess;

import com.mycompany.employeepayroll.employee.Payroll.PayrollRecord;
import java.util.List;

/**
 *
 * @author Arian
 */
public interface PayrollRecordDataAccess {
 void savePayrollRecord(PayrollRecord payrollRecord);
    PayrollRecord getPayrollRecordById(int payrollId);
    List<PayrollRecord> getAllPayrollRecords();
    void updatePayrollRecord(PayrollRecord payrollRecord);
    void deletePayrollRecord(int payrollId);	
}
