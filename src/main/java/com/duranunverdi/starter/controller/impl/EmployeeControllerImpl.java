package com.duranunverdi.starter.controller.impl;

import com.duranunverdi.starter.controller.IEmployeeController;
import com.duranunverdi.starter.dto.DtoEmployee;
import com.duranunverdi.starter.service.EmployeeServiceImpl;
import com.duranunverdi.starter.service.IEmployeeService;
import lombok.Getter;
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
