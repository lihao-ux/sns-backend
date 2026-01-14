package com.ruoyi.employee.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.domain.dto.EmployeeSkillDto;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社員情報管理对象 employee
 * 
 * @author ruoyi
 * @date 2026-01-06
 */
public class Employee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 従業員ID */
    private Long employeeId;

    /** 従業員名 */
    @Excel(name = "従業員名")
    private String employeeName;

    /** 性別 */
    @Excel(name = "性別")
    private String employeeGender;

    /** ステータス */
    @Excel(name = "ステータス")
    private String employeeWorkStatus;

    /** 年齢 */
    @Excel(name = "年齢")
    private Long employeeAge;

    /** 日本語レベル */
    @Excel(name = "日本語レベル")
    private String employeeJapaneseLevel;

    /** 社員メール */
    @Excel(name = "社員メール")
    private String employeeMail;

    /** 社員誕生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "社員誕生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date employeeBirthday;

    /** 職務経験 */
    @Excel(name = "職務経験")
    private Integer employeeWorkExperience;

    /** 案件名 */
    @Excel(name = "案件名")
    private String employeeEvent;

    /** 技能情報 */
    List<EmployeeSkillDto> employeeSkills;

    public List<EmployeeSkillDto> getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(List<EmployeeSkillDto> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public void setEmployeeId(Long employeeId)
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }

    public void setEmployeeName(String employeeName) 
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() 
    {
        return employeeName;
    }

    public void setEmployeeGender(String employeeGender) 
    {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeGender() 
    {
        return employeeGender;
    }

    public void setEmployeeWorkStatus(String employeeWorkStatus) 
    {
        this.employeeWorkStatus = employeeWorkStatus;
    }

    public String getEmployeeWorkStatus() 
    {
        return employeeWorkStatus;
    }

    public void setEmployeeAge(Long employeeAge) 
    {
        this.employeeAge = employeeAge;
    }

    public Long getEmployeeAge() 
    {
        return employeeAge;
    }

    public void setEmployeeJapaneseLevel(String employeeJapaneseLevel) 
    {
        this.employeeJapaneseLevel = employeeJapaneseLevel;
    }

    public String getEmployeeJapaneseLevel() 
    {
        return employeeJapaneseLevel;
    }

    public void setEmployeeMail(String employeeMail) 
    {
        this.employeeMail = employeeMail;
    }

    public String getEmployeeMail() 
    {
        return employeeMail;
    }

    public void setEmployeeBirthday(Date employeeBirthday) 
    {
        this.employeeBirthday = employeeBirthday;
    }

    public Date getEmployeeBirthday() 
    {
        return employeeBirthday;
    }

    public void setEmployeeWorkExperience(Integer employeeWorkExperience) 
    {
        this.employeeWorkExperience = employeeWorkExperience;
    }

    public Integer getEmployeeWorkExperience() 
    {
        return employeeWorkExperience;
    }

    public void setEmployeeEvent(String employeeEvent) 
    {
        this.employeeEvent = employeeEvent;
    }

    public String getEmployeeEvent() 
    {
        return employeeEvent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("employeeId", getEmployeeId())
            .append("employeeName", getEmployeeName())
            .append("employeeGender", getEmployeeGender())
            .append("employeeWorkStatus", getEmployeeWorkStatus())
            .append("employeeAge", getEmployeeAge())
            .append("employeeJapaneseLevel", getEmployeeJapaneseLevel())
            .append("employeeMail", getEmployeeMail())
            .append("employeeBirthday", getEmployeeBirthday())
            .append("employeeWorkExperience", getEmployeeWorkExperience())
            .append("employeeEvent", getEmployeeEvent())
            .toString();
    }
}
