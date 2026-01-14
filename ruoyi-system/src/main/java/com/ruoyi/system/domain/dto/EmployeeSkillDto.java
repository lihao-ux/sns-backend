package com.ruoyi.system.domain.dto;

public class EmployeeSkillDto {
    /** 社員技能関連ID */
    private Long employeeTechnologyId;
    /** 技術ID */
    private Long technologyId;
    /** 習熟度 */
    private String proficiencyLevel;
    /** 経験年数 */
    private Integer experienceYears;

    public Long getEmployeeTechnologyId() {
        return employeeTechnologyId;
    }

    public void setEmployeeTechnologyId(Long employeeTechnologyId) {
        this.employeeTechnologyId = employeeTechnologyId;
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(Long technologyId) {
        this.technologyId = technologyId;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }
}
