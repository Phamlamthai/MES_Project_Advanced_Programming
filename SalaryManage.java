/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manage;

import Interface.ActionSalary;
import Model.*;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Lenovo T460s
 */
public class SalaryManage implements ActionSalary<Salary, WorkingHours>{

    @Override
    public Object add(ArrayList<Salary> list, ArrayList<WorkingHours> list2) {
      Scanner sc = new Scanner(System.in);
      Salary salary = new Salary();
        System.out.println("Enter Salary ID : ");
        String SalaryID = sc.nextLine();
        while(checkID(list, SalaryID)){
            System.out.println("Salary ID is Valid ! Please Try Again : ");
            SalaryID = sc.nextLine();
        }
        while(SalaryID.contains(" ") || SalaryID.equals(" ")){
            System.out.println("Not Space ! Please Enter Again : ");
            SalaryID = sc.nextLine();
             }
            salary.setSalaryID(SalaryID);
            System.out.println("Enter Working ID : ");
            String workinghoursID = sc.nextLine();
            boolean check=true;
            while(check){
                for(int i=0;i<list2.size();i++){
                    if(list2.get(i).getWorkinghoursID().equals(workinghoursID)){
                        salary.setWorkingHoursID(list2.get(i));
                        check=false;
                    }
                }
                if (check) {
                System.out.println("Working ID is Invalid! Please Enter Working ID again: ");
                workinghoursID = sc.nextLine();
            }
            }
            System.out.println("Enter Date of receip  (dd/MM/yyyy) : ");
            String localDate = sc.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date timereceip = null;
            try {
                timereceip=format.parse(localDate);
            } catch (Exception e) {
                System.out.println("Invalid Date ");
            }
            salary.setDoReceip(timereceip);
            return  salary;
    }

    @Override
    public boolean edit(ArrayList<Salary> list, ArrayList<WorkingHours> list2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Salary ID: ");
        String salaryID = sc.nextLine();
        while (!checkID(list, salaryID)) {
            System.out.println("Salary ID is Invalid! Please Enter Salary ID again: ");
            salaryID = sc.nextLine();
        }
        while (salaryID.contains(" ") || salaryID.equals("")) {
            System.out.println("  *Please don't enter space! Please Enter Salary ID again* ");
            salaryID = sc.nextLine();
        }
        System.out.println("Enter Working ID: ");
        String workingID = sc.nextLine();
        boolean check = true;
        while (check) {
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).getWorkinghoursID().equals(workingID)) {
                    list.get(i).setWorkingHoursID(list2.get(i));
                    check = false;
                }
            }
            if (check) {
                System.out.println("Working ID is Invalid! Please Enter Working ID again: ");
                workingID = sc.nextLine();
            }
        }
        System.out.println("Enter Date Of Receip (dd/MM/yyyy): ");
        String localDate = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date timereceip = null;
        try {
            timereceip = format.parse(localDate);
        } catch (Exception e) {
            System.out.println("Invalid Date Format");

        }
        list.get(0).setDoReceip(timereceip);
        return true;
    }

    @Override
    public Object add(ArrayList<Salary> list) {
          return null;
    }

    @Override
    public boolean edit(ArrayList<Salary> list) {
         return false;
    }

    @Override
    public boolean delete(ArrayList<Salary> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Salary ID: ");
        String SalaryID = sc.nextLine();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getSalaryID().equals(SalaryID)){
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void show(ArrayList<Salary> list) {
         if (list.size() == 0) {
            System.out.println("No data");
        } else {
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "ID", "Employee ID",
                    "Employee Name", "Start Date", "End Date", "Day Off", "Total Days");
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "---------", "--------------",
                    "-----------------", "---------------------", "---------", "--------", "---------");
            for (int i = 0; i < list.size(); i++) {
                // Calculate working days
                Date startDate = list.get(i).workingHoursID.getStartDate();
                Date endDate = list.get(i).workingHoursID.getEndDate();
                long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
                long getTotalDays = days - list.get(i).workingHoursID.getDayoff();
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", list.get(i).getSalaryID(),
                        list.get(i).workingHoursID.getEmp().getEmpID(),
                        list.get(i).workingHoursID.getEmp().getEmpName(), list.get(i).workingHoursID.getStartDate(),
                        list.get(i).workingHoursID.getEndDate(), list.get(i).workingHoursID.getDayoff(), getTotalDays);
            }
        }
    }

    @Override
    public void search(ArrayList<Salary> list) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Working ID : ");
        String workinghoursID = sc.nextLine();
        for(int i=0;i<list.size();i++){
            Date startDate = list.get(i).workingHoursID.getStartDate();
            Date endDate = list.get(i).workingHoursID.getEndDate();
            Long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
            Long totalDays = days - list.get(i).workingHoursID.getDayoff();
            if(list.get(i).getWorkingHoursID().equals(workinghoursID)){
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "ID", "Employee ID",
                        "Employee Name", "Start Date", "End Date", "Day Off", "Total Days");
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", list.get(i).getSalaryID(),
                        list.get(i).workingHoursID.getEmp().getEmpID(),
                        list.get(i).workingHoursID.getEmp().getEmpName(), list.get(i).workingHoursID.getStartDate(),
                        list.get(i).workingHoursID.getEndDate(), list.get(i).workingHoursID.getDayoff(),
                        totalDays);
            }
        }
    }

    @Override
    public boolean checkID(ArrayList<Salary> list, String id) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getSalaryID().equals(id)){
                return true;
            }
        }
        return false;
    }
    
}
