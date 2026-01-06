package com.ruoyi.employee.service;

import java.util.List;
import com.ruoyi.employee.domain.Employee;

/**
 * 社員情報管理Service接口
 * 
 * @author ruoyi
 * @date 2026-01-06
 */
public interface IEmployeeService 
{
    /**
     * 查询社員情報管理
     * 
     * @param employeeId 社員情報管理主键
     * @return 社員情報管理
     */
    public Employee selectEmployeeByEmployeeId(Long employeeId);

    /**
     * 查询社員情報管理列表
     * 
     * @param employee 社員情報管理
     * @return 社員情報管理集合
     */
    public List<Employee> selectEmployeeList(Employee employee);

    /**
     * 新增社員情報管理
     * 
     * @param employee 社員情報管理
     * @return 结果
     */
    public int insertEmployee(Employee employee);

    /**
     * 修改社員情報管理
     * 
     * @param employee 社員情報管理
     * @return 结果
     */
    public int updateEmployee(Employee employee);

    /**
     * 批量删除社員情報管理
     * 
     * @param employeeIds 需要删除的社員情報管理主键集合
     * @return 结果
     */
    public int deleteEmployeeByEmployeeIds(Long[] employeeIds);

    /**
     * 删除社員情報管理信息
     * 
     * @param employeeId 社員情報管理主键
     * @return 结果
     */
    public int deleteEmployeeByEmployeeId(Long employeeId);
}
