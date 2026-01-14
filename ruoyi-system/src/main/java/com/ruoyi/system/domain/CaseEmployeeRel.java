package com.ruoyi.system.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CaseEmployeeRel {
    /**
     * ID（主キー）
     */
    private Long id;

    /**
     * 案件ID
     */
    private Long caseId;

    /**
     * 社員ID
     */
    private Long employeeId;

    /**
     * 社員名前
     */
    private Long employeeName;

    /**
     * 案件内役割（例：PM / SE / PG）
     */
    private String role;

    /**
     * 参画開始日
     */
    private LocalDate joinDate;

    /**
     * 作成日時
     */
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    private LocalDateTime updatedAt;

    public Long getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(Long employeeName) {
        this.employeeName = employeeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
