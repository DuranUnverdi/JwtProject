package com.duranunverdi.controller.impl;

import com.duranunverdi.controller.IEmployeeController;
import com.duranunverdi.dto.DtoEmployee;
import com.duranunverdi.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerImpl implements IEmployeeController {
    private final IEmployeeService service;

    @Override
    @GetMapping("/employee/{id}")
    public DtoEmployee getEmployeeById(@PathVariable(value="id") Long id) {
        return service.getEmployeeById(id);
    }
}
