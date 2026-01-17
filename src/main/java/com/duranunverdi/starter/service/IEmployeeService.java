package com.duranunverdi.starter.service;

import com.duranunverdi.starter.dto.DtoEmployee;

public interface IEmployeeService {
    DtoEmployee getEmployeeById(Long id);

}
