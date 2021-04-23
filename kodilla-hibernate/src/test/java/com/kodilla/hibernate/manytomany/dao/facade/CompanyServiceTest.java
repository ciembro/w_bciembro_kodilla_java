package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;


    Employee stephanieSmith = new Employee("Stephanie", "Smith");
    Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

    Company softwareMachine = new Company("Software Machine");
    Company softMachine = new Company("Soft Machine");

    @Test
    void testGetCompanyByNameFrag(){
        //given
        companyDao.save(softMachine);
        int softMachineId = softMachine.getId();
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();

        //when
        List<Company> companies = companyService.getCompaniesByNameFrag("Soft");
        //then
        try {
            assertEquals(2, companies.size());
        } finally {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(softMachineId);
        }
    }

    @Test
    void testGetEmployeeByNameFragment(){
        //given
        employeeDao.save(stephanieSmith);
        int stephanieId = stephanieSmith.getId();
        employeeDao.save(lindaKovalsky);
        int lindaId = lindaKovalsky.getId();
        //when
        List<Employee> employees = companyService.getEmployeesByNameFrag("mit");

        //then
        try {
            assertEquals(1, employees.size());
        } finally {
            employeeDao.deleteById(stephanieId);
            employeeDao.deleteById(lindaId);
        }
    }

}