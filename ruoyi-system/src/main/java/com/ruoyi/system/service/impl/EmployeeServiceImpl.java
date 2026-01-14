package com.ruoyi.employee.service.impl;

import java.util.List;

import com.ruoyi.system.domain.dto.EmployeeFreeQuryDto;
import com.ruoyi.system.domain.dto.EmployeeQuryDto;
import com.ruoyi.system.domain.dto.EmployeeSkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.employee.mapper.EmployeeMapper;
import com.ruoyi.employee.domain.Employee;
import com.ruoyi.employee.service.IEmployeeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 社員情報管理Service业务层处理
 *
 * @author ruoyi
 * @date 2026-01-06
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询社員情報管理
     *
     * @param employeeId 社員情報管理主键
     * @return 社員情報管理
     */
    @Override
    public Employee selectEmployeeByEmployeeId(Long employeeId) {
        Employee employee = employeeMapper.selectEmployeeByEmployeeId(employeeId);
        List<EmployeeSkillDto> employeeSkillDtos = employeeMapper.getEmployeeSkills(employeeId);
        employee.setEmployeeSkills(employeeSkillDtos);
        return employee;
    }

    /**
     * 查询社員情報管理列表
     *
     * @param employee 社員情報管理
     * @return 社員情報管理
     */
    @Override
    public List<Employee> selectEmployeeList(EmployeeQuryDto employee) {
        return employeeMapper.selectEmployeeList(employee);
    }

    /**
     * 新增社員情報管理
     *
     * @param employee 社員情報管理
     * @return 结果
     */
    @Override
    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    /**
     * 修改社員情報管理
     *
     * @param employee 社員情報管理
     * @return 结果
     */
    @Override
    @Transactional
    public int updateEmployee(Employee employee) {
        List<EmployeeSkillDto> employeeSkills = employee.getEmployeeSkills();
        for (EmployeeSkillDto employeeSkill : employeeSkills) {
            if (employeeSkill.getEmployeeTechnologyId() == null) {
                int i = employeeMapper.addEmployeeSkill(employeeSkill, employee.getEmployeeId());
            }
        }

        int i = 1;
        return employeeMapper.updateEmployee(employee);
    }

    /**
     * 批量删除社員情報管理
     *
     * @param employeeIds 需要删除的社員情報管理主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeByEmployeeIds(Long[] employeeIds) {
        return employeeMapper.deleteEmployeeByEmployeeIds(employeeIds);
    }

    /**
     * 删除社員情報管理信息
     *
     * @param employeeId 社員情報管理主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeByEmployeeId(Long employeeId) {
        return employeeMapper.deleteEmployeeByEmployeeId(employeeId);
    }

    @Override
    public int delEmployeeSkillById(Long employeeTechnologyId) {
        return employeeMapper.delEmployeeSkillById(employeeTechnologyId);
    }

    @Override
    public List<Employee> getFreeEmployeeList(EmployeeFreeQuryDto employeeFreeQuryDto) {
        return employeeMapper.getFreeEmployeeList(employeeFreeQuryDto);
    }
}
