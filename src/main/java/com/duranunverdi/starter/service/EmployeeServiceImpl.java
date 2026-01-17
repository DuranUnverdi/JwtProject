package com.duranunverdi.starter.service;

import com.duranunverdi.starter.dto.DtoDepartment;
import com.duranunverdi.starter.dto.DtoEmployee;
import com.duranunverdi.starter.model.Department;
import com.duranunverdi.starter.model.Employee;
import com.duranunverdi.starter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        DtoEmployee dtoEmployee = new DtoEmployee();
        BeanUtils.copyProperties(employee, dtoEmployee);

        if (employee.getDepartment() != null) {
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(employee.getDepartment(), dtoDepartment);
            dtoEmployee.setDepartment(dtoDepartment);
        }

        return dtoEmployee;
    }



}
