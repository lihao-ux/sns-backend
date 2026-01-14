package com.ruoyi.system.domain.dto;

public class EmployeeFreeQuryDto {
    private String[] employeeJapaneseLevels;
    private String[] technologyIds;
    private Integer employeeWorkExperience;

    public String[] getEmployeeJapaneseLevels() {
        return employeeJapaneseLevels;
    }

    public void setEmployeeJapaneseLevels(String[] employeeJapaneseLevels) {
        this.employeeJapaneseLevels = employeeJapaneseLevels;
    }

    public String[] getTechnologyIds() {
        return technologyIds;
    }

    public void setTechnologyIds(String[] technologyIds) {
        this.technologyIds = technologyIds;
    }

    public Integer getEmployeeWorkExperience() {
        return employeeWorkExperience;
    }

    public void setEmployeeWorkExperience(Integer employeeWorkExperience) {
        this.employeeWorkExperience = employeeWorkExperience;
    }
}
