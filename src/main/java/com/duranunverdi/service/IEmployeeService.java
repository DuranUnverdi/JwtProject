package com.duranunverdi.service;

import com.duranunverdi.dto.DtoEmployee;

public interface IEmployeeService {
    DtoEmployee getEmployeeById(Long id);

}
