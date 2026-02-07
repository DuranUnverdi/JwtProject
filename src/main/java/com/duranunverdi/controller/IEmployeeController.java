package com.duranunverdi.controller;

import com.duranunverdi.dto.DtoEmployee;

public interface IEmployeeController {
    public DtoEmployee getEmployeeById(Long id);
}
