package com.ruoyi.system.domain.dto;

public class EmployeeQuryDto extends com.ruoyi.employee.domain.Employee {
    private String[] employeeJapaneseLevels;
    // Getter
    public String[] getEmployeeJapaneseLevels() {
        return employeeJapaneseLevels;
    }

    // Setter
    public void setEmployeeJapaneseLevels(String[] employeeJapaneseLevels) {
        this.employeeJapaneseLevels = employeeJapaneseLevels;
    }
}
