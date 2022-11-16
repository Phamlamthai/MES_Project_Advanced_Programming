/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manage;

import Interface.*;
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
public class WorkingHoursManage implements ActionWorkingHours<WorkingHours, Employee>{

    @Override
    public Object add(ArrayList<WorkingHours> list, ArrayList<Employee> list2) {
        WorkingHours wh = new WorkingHours();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Working Hours ID: ");
        String whID = sc.nextLine();
        while (checkID(list, whID)) {
            System.out.println("Working Hours ID is Invalid! Please Enter Working Hours ID again: ");
            whID = sc.nextLine();
        }
        while (whID.contains(" ") || whID.equals("")) {
            System.out.println("[SOS]   *Please don't enter space! Please Enter Working Hours ID again* ");
            whID = sc.nextLine();
        }
        wh.setWorkingHoursID(whID);
        System.out.println("Enter Employee ID: ");
        String empID = sc.nextLine();
        int countwh = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getEmpID().equals(empID)) {
                wh.setEmp(list2.get(i));
            } else {
                countwh++;
            }
        }

        if (countwh == 0) {
            System.out.println("Employee ID is Invalid! Please Enter Employee ID again: ");
            empID = sc.nextLine();
            while (checkID(list, empID)) {
                System.out.println("Employee ID is Invalid! Please Enter Employee ID again: ");
                empID = sc.nextLine();
            }
            while (empID.contains(" ") || empID.equals("")) {
                System.out.println("Not Spcae ");
                empID = sc.nextLine();
            }
        }
        System.out.println("Enter Working Hours Start Date (dd/MM/yyyy): ");
        String whStartDate = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date startTime = null;
        try {
            startTime = format.parse(whStartDate);
        } catch (Exception e) {
            System.out.println("Invalid Date Format");
        }
        wh.setStartDate(startTime);
        System.out.println("Enter Working Hours End Date (dd/MM/yyyy): ");
        String whEndDate = sc.nextLine();
        Date endTime = null;
        try {
            endTime = format.parse(whEndDate);
            // End Date must be greater than Start Date
            if (endTime.compareTo(startTime) < 1) {
                System.out.println("End Date must be greater than Start Date");
                whEndDate = sc.nextLine();
                endTime = format.parse(whEndDate);
            }

        } catch (Exception e) {
            System.out.println("Invalid Date Format");
        }
        wh.setEndDate(endTime);
        System.out.println("Enter Working Hours Day Off: ");
        int whDayOff = sc.nextInt();
        wh.setDayOff(whDayOff);
        return wh;
        
    }

    @Override
    public boolean edit(ArrayList<WorkingHours> list, ArrayList<Employee> list2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter WorkingHours ID : ");
        String wkID = sc.nextLine();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getWorkinghoursID().equals(wkID)){
                System.out.println("Enter employee ID : ");
                String empID = sc.nextLine();
                int count =0;
                for(int j=0;j<list2.size();j++){
                    if(list2.get(i).getEmpID().equals(empID)){
                        list.get(i).setEmp(list2.get(j));
                    }else{
                        count++;
                    }
                }
                if(count==0){
                    System.out.println("Employee ID is valid ! ");
                    empID = sc.nextLine();
                    while(checkID(list, empID)){
                        System.out.println("Employee Id is valid --------- PLease Enter Employee ID Again : ");
                        empID = sc.nextLine();
                    }
                    while(empID.contains(" ") || empID.equals("")){
                        System.out.println("Not Space __________ Please try again : ");
                        empID = sc.nextLine();
                    }
                }
                System.out.println("Enter WorkingHours Start Date (dd/MM/yyyy): ");
                String whStartDate = sc.nextLine();
                SimpleDateFormat format = new SimpleDateFormat();
                Date startTime = null;
                try {
                    startTime =format.parse(whStartDate);
                } catch (Exception e) {
                    System.out.println("Invalid Date Format ");
                }
                list.get(i).setStartDate(startTime);
                System.out.println("Enter Working Hours DayOff : ");
                int whdayoff = sc.nextInt();
                list.get(i).setDayOff(whdayoff);
                return true;
            }
        }
        return false;
    }

    @Override
    public void show(ArrayList<WorkingHours> list) {
        if(list.size()==0){
            System.out.println("No Data ");
        }else{
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "ID", "Employee ID",
                    "Employee Name", "Start Date", "End Date", "Day Off", "Total Days");
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "---------", "------------------",
                    "-----------------", "------------------------------", "------------------------------", "--------",
                    "---------");
            for(int i=0;i<list.size();i++){
                Date startDate = list.get(i).getStartDate();
                Date endDate = list.get(i).getEndDate();
                Long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
                long TotalDays =days - list.get(i).getDayoff();
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", list.get(i).getWorkinghoursID(),
                        list.get(i).getEmp().getEmpID(), list.get(i).getEmp().getEmpName(), list.get(i).getStartDate(),
                        list.get(i).getEndDate(), list.get(i).getDayoff(), TotalDays);
            }
        }
    }

    @Override
    public Object add(ArrayList<WorkingHours> list) {
        return null;
    }
   

    @Override
    public boolean edit(ArrayList<WorkingHours> list) {
        return false;
    }

    @Override
    public boolean delete(ArrayList<WorkingHours> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter WorkingHours ID : ");
        String workinghoursID = sc.nextLine();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getWorkinghoursID().equals(workinghoursID)){
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void search(ArrayList<WorkingHours> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID : ");
        String empID = sc.nextLine();
        if(checkID(list, empID)){
            System.out.println("Not Found ! ");
        }else{
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "ID", "Employee ID",
                    "Employee Name", "Start Date", "End Date", "Day Off", "Total Days");
            System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", "---------", "------------------",
                    "-----------------", "------------------------------", "------------------------------", "--------",
                    "---------");
            for(int i=0;i<list.size();i++){
                Date startDate = list.get(i).getStartDate();
                Date endDate = list.get(i).getEndDate();
                Long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
                long TotalDays = days - list.get(i).getDayoff();
                System.out.printf("|%-10s|%-20s|%-20s|%-40s|%-40s|%-10s|%-10s|%n", list.get(i).getWorkinghoursID(),
                        list.get(i).getEmp().getEmpID(), list.get(i).getEmp().getEmpName(), list.get(i).getStartDate(),
                        list.get(i).getEndDate(), list.get(i).getDayoff(), TotalDays);
            }
        }
    }

    @Override
    public boolean checkID(ArrayList<WorkingHours> list, String id) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getWorkinghoursID().equals(id)){
                return true;
            }
        }
        return false;
    }
    
}
