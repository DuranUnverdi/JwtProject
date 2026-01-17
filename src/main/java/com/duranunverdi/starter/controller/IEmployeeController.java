package com.duranunverdi.starter.controller;

import com.duranunverdi.starter.dto.DtoDepartment;
import com.duranunverdi.starter.dto.DtoEmployee;

public interface IEmployeeController {
    public DtoEmployee getEmployeeById(Long id);
}
