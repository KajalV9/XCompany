package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private Gender gender;
    private Employee manager;
    private List<Employee> directReports = new ArrayList<>();
    private List<Employee> teamMates;



    public Employee(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.directReports = new ArrayList<>();
        this.teamMates = new ArrayList<>();
    }

    public void assignManager(Employee employee) {
        employee.directReports.add(this);
        this.teamMates.add(employee);
        this.teamMates.addAll(employee.directReports);

    }


    public Employee getManager() {
        return manager;
    }


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone
    // before implementing the logic.
    // This will ensure that the project can be compiled successfully.


    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (gender != other.gender)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public List<Employee> getDirectReportees() {
        return directReports;
    }

    public List<Employee> getTeamMates() {
        return teamMates;
    }


}
