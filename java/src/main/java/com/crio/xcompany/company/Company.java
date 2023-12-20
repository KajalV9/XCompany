package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Company {
    private String companyName;
    private Employee founder;
    private Map<String, Employee> employeeBook;
    private Map<Employee, List<Employee>> empManagerMap;



    private Company(String companyName, Employee founder) {
        this.companyName = companyName;
        this.founder = founder;
        employeeBook = new HashMap<String, Employee>();
        employeeBook.put(founder.getName(), founder);
        empManagerMap = new HashMap<>();

    }


    public static Company create(String companyName, Employee founder) {
        return new Company(companyName, founder);
    }


    public String getCompanyName() {
        return companyName;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone
    // for each functionality before implementing the logic.
    // This will ensure that the project can be compiled successfully.
    public void registerEmployee(String employeeName, Gender gender) {

        Employee employee = new Employee(employeeName, gender);
        employeeBook.put(employeeName, employee);

    }


    public void assignManager(String employeeName, String managerName) {
        getEmployee(employeeName).assignManager(getEmployee(managerName));

    }


    public Employee getEmployee(String employeeName) {
        return employeeBook.get(employeeName);
    }


    public List<Employee> getDirectReports(String managerName) {
        return getEmployee(managerName).getDirectReportees();
    }


    public List<Employee> getTeamMates(String employeeName) {
        return getEmployee(employeeName).getTeamMates();
    }


    public void deleteEmployee(String employeeName) {
        employeeBook.remove(employeeName);
    }


    public List<List<Employee>> getEmployeeHierarchy(String managerName) {
        List<List<Employee>> empHierarchyList = new ArrayList<>();

        Queue<Employee> q = new LinkedList<>();
        q.add(getEmployee(managerName));

        while(!q.isEmpty()){
            Integer size = q.size();
            List<Employee> empList = new ArrayList<>();

            while(size > 0){
                Employee e = q.poll();
                empList.add(e);
                size--;
                for(Employee ee:e.getDirectReportees()){
                    q.add(ee);
                }

            }

            empHierarchyList.add(empList);
        }

        return empHierarchyList;
    }

}
