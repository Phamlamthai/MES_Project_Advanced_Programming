
package Main;
import java.util.Scanner;
import Interface.Action;
import Interface.AdminBuilder;
import Interface.itera;
import Manage.*;
import java.util.ArrayList;
import Model.*;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
public class Main {
    public static void main(String[] args) {
        // admin for two people
        Adminer admin1 = new Admin_C_B().
                setID("Admin-01").
                setName("Pham Lam Thai").
                setEmail("Thaiplbhaf200110@fpt.edu.vn").
                setPhone(200110).
                setRole("ADMIN").
                build();
        Adminer admin2 = new Admin_C_B().
                setID("Admin-02").
                setName("Nguyen Lan Huong").
                setEmail("Huongnlbh260503@fpt.edu.vn").
                setPhone(050623).
                setRole("Marketing ").
                build();
        
        
        // manage 
        Department de1 = new Department("BRT", "Brand_Team", 15.0);
        Department de2 = new Department("MKT", "Marketing_service", 18.0);
        Department de3 = new Department("DEV", "Developer", 25.0);
        
        Position po1 = new Position("Sel", "Seller", 13.0);
        Position po2 = new Position("Med", "Media", 12.0);
        Position po3 = new Position("Dgt", "Digital", 9.5);
        
        Employee emp1 = new Employee("BHAF200110", "Pham Lam Thai", "Thaiplbhaf200110@gmail", de3, po1);
        Employee emp2 = new Employee("BHAF200111", "Pham Lam Thai 2", "Thai2plbhaf200111@gmail", de2, po3);
        Employee emp3 = new Employee("BHAF200112", "Pham Lam Thai 2", "Thai3plbhaf200112@gmail", de1, po2);
        
        //System.out.println("--------Welcome To Manage Employee System By Pham Lam Thai---------");
        
        WorkingHoursManage whM = new WorkingHoursManage();
        ArrayList<WorkingHours> workList = new ArrayList<WorkingHours>();
        
        SalaryManage slm = new SalaryManage();
        ArrayList<Salary> salarylist = new ArrayList<Salary>();
        
        DepartmentManage depM = new DepartmentManage();
        ArrayList<Department> depList = new ArrayList<Department>();
        
        PositionManage posM = new PositionManage();
        ArrayList<Position> posList = new ArrayList<Position>();
        
        EmployeeManage empM = new EmployeeManage();
        ArrayList<Employee> empList = new ArrayList<Employee>();
        
        depList.add(de1);
        depList.add(de2);
        depList.add(de3);
        
        posList.add(po1);
        posList.add(po2);
        posList.add(po3);
        
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        
        while(true){
            System.out.println("_________________________________________________________________");
            System.out.println("                      BTEC FPT COLLEGE");
            System.out.println("_________________________________________________________________");
            System.out.println("||||                                                                             ");
            System.out.println("||||  Welcome To  Employee Management System              ");
            System.out.println("||||        [1]   Department Manage                                   ");
            System.out.println("||||        [2]   Position Manage                                        ");
            System.out.println("||||        [3]   Employee Manage                                     ");
            System.out.println("||||        [4]   Working Hours Manage                               ");
            System.out.println("||||        [5]   Salary Manage                                         ");
            System.out.println("||||        [6]   Exit                                                         ");
            System.out.println("||||        [7]   Chat with Supporter 24/24                          ");
            System.out.println("||||        [8]   Design Pattern                                          ");
            System.out.println("||||                                                                            ");
            System.out.println("________________________________________________________________");
            System.out.println("                   Designed By Pham Lam Thai");
            System.out.println("________________________________________________________________");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Number : ");
            int choose = sc.nextInt();
            switch(choose){
                case 1:
                    boolean checkdep =true;
                    int depchoose=0;
                    while(true){
                        System.out.println("===========================================");
                        System.out.println("||                                                                                                              ");
                        System.out.println("||            Department Management System                                                     ");
                        System.out.println("||      [1]   Add Department                                                                            ");
                        System.out.println("||      [2]   Edit Department                                                                             ");
                        System.out.println("||      [3]   Delete Department                                                                         ");
                        System.out.println("||      [4]   Show Department                                                                          ");
                        System.out.println("||      [5]   Search Department                                                                         ");
                        System.out.println("||      [6]   Back Home                                                                                    ");
                        System.out.println("||                                                                                                                ");
                        System.out.println("===========================================");
                        System.out.println("Enter Number : ");
                        depchoose = sc.nextInt();
                        
                        switch(depchoose){
                            case 1:
                                depList.add(depM.add(depList));
                                break;
                            case 2:
                                depM.edit(depList);
                                break;
                            case 3:
                                depM.delete(depList);
                                break;
                            case 4:
                                depM.show(depList);
                                break;
                            case 5:
                                depM.search(depList);
                                break;
                            case 6:
                                checkdep=false;
                                break;
                            default:
                                System.out.println("Please Try again ! ");
                                break;
                        }
                        if(checkdep==false){
                            break;
                        }
                    }
                    break;
                case 2: 
                    boolean checkpos = true;
                    int choosePos=0;
                    while(true){
                        System.out.println("=====================================");
                        System.out.println("||                                                                           ");
                        System.out.println("||            Position Management System                      ");
                        System.out.println("||      [1]   Add Position                                             ");
                        System.out.println("||      [2]   Edit Position                                              ");
                        System.out.println("||      [3]   Delete Position                                          ");
                        System.out.println("||      [4]   Show Position                                           ");
                        System.out.println("||      [5]   Search Position                                         ");
                        System.out.println("||      [6]   Back                                                        ");
                        System.out.println("||                                                                          ");
                        System.out.println("=====================================");
                        System.out.println("Enter Number : ");
                        choosePos=sc.nextInt();
                        switch(choosePos){
                            case 1:
                                posList.add(posM.add(posList));
                                break;
                            case 2:
                                posM.edit(posList);
                                break;
                            case 3:
                                posM.delete(posList);
                                break;
                            case 4:
                                posM.show(posList);
                                break;
                            case 5:
                                posM.search(posList);
                                break;
                            case 6:
                                checkpos=false;
                                break;
                            default:
                                System.out.println("Please Try Again ! ");
                                break;
                        }
                        if(checkpos==false){
                            break;
                        }
                    }
                     break;
                
                case 3:
                    boolean checkEmp=true;
                    int chooseEmp = 0;
                    while(true){
                         System.out.println("==================================");
                        System.out.println("||                                                                                         ");
                        System.out.println("||            Employee Management System                                   ");
                        System.out.println("||      [1]   Add Employee                                                          ");
                        System.out.println("||      [2]   Edit Employee                                                           ");
                        System.out.println("||      [3]   Delete Employee                                                       ");
                        System.out.println("||      [4]   Show Employee                                                        ");
                        System.out.println("||      [5]   Search Employee                                                        ");
                        System.out.println("||      [6]   Back                                                                        ");
                        System.out.println("||                                                                                          ");
                        System.out.println("===================================");
                        System.out.println("Enter Number : ");

                        chooseEmp = sc.nextInt();
                        switch(chooseEmp){
                            case 1:
                                empList.add(empM.add(empList, depList, posList));
                                break;
                            case 2:
                                empM.edit(empList);
                                break;
                            case 3:
                                empM.delete(empList);
                                break;
                            case 4:
                                empM.show(empList);
                                break;
                            case 5:
                                empM.search(empList);
                                break;
                            case 6:
                                checkEmp=false;
                                break;
                            default:
                                System.out.println("Please Try Again : ");
                                break;
                        }
                        if(checkEmp==false){
                            break;
                        }
                    }
                    break;
                case 4:
                    boolean checkWork=true;
                    int workinghourChoose = 0;
                    while(true){
                        System.out.println("===========================================");
                        System.out.println("||                                                                                         ");
                        System.out.println("||            Working Hours Management System                           ");
                        System.out.println("||      [1]   Add Working Hours                                                ");
                        System.out.println("||      [2]   Edit Working Hours                                                  ");
                        System.out.println("||      [3]   Delete Working Hours                                               ");
                        System.out.println("||      [4]   Show Working Hours                                                ");
                        System.out.println("||      [5]   Search Working Hours                                              ");
                        System.out.println("||      [6]   Back                                                                       ");
                        System.out.println("||                                                                                          ");
                        System.out.println("===========================================");
                        System.out.println("Enter Number: ");
                        workinghourChoose = sc.nextInt();
                        switch(workinghourChoose){
                            case 1:
                                workList.add(whM.add(workList));
                                break;
                            case 2:
                                whM.edit(workList);
                                break;
                            case 3:
                                whM.delete(workList);
                                break;
                            case 4:
                                whM.show(workList);
                                break;
                            case 5:
                                whM.search(workList);
                                break;
                            case 6:
                                checkWork = false;
                                break;
                            default:
                                System.out.println("Please Try again ! ");
                                break;
                        }
                        if(checkWork==false){
                            break;
                        }
                    }
                    break;
                case 5:
                    boolean checkSalary = true;
                    int chooseSalary = 0;
                    while(true){
                         System.out.println("===========================================");
                        System.out.println("||                                                                                         ||");
                        System.out.println("||            Salary Management System                                        ||");
                        System.out.println("||      [1]   Add Salary                                                               ||");
                        System.out.println("||      [2]   Edit Salary                                                                ||");
                        System.out.println("||      [3]   Delete Salary                                                            ||");
                        System.out.println("||      [4]   Show Salary                                                             ||");
                        System.out.println("||      [5]   Search Salary                                                            ||");
                        System.out.println("||      [6]   Back                                                                        ||");
                        System.out.println("||                                                                                          ||");
                        System.out.println("===========================================");
                        System.out.println("Enter Number: ");
                        chooseSalary = sc.nextInt();
                        switch(chooseSalary){
                            case 1:
                                salarylist.add(slm.add(salarylist));
                                break;
                            case 2:
                                slm.edit(salarylist);
                                break;
                            case 3:
                                slm.delete(salarylist);
                                break;
                            case 4:
                                slm.show(salarylist);
                                break;
                            case 5: 
                                slm.search(salarylist);
                                break;
                            case 6:
                                checkSalary=false;
                                break;
                            default:
                                System.out.println("Please try again ");
                                break;
                        }
                        if(checkSalary==false){
                            break;
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                case 7:
                    break;
                case 8:
                    // Iterator
                    Employee_Repository employee_Repository = new Employee_Repository();
                    for(itera iterator = employee_Repository.getIterator(); iterator.hasNext();){
                        String employee = (String) iterator.next();
                        System.out.println("Employee: " + employee);
                    }
                    break;
            }
                
        }
        
    }
    
}
