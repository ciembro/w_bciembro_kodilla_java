package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
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

    Employee johnSmith = new Employee("John", "Smith");
    Employee stephanieSmith = new Employee("Stephanie", "Smith");
    Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

    Company softwareMachine = new Company("Software Machine");
    Company softMachine = new Company("Soft Machine");
    Company dataMaesters = new Company("Data Maesters");
    Company greyMatter = new Company("Grey Matter");

    @Test
    void testGetCompanyByNameFrag(){
        //given
        companyDao.save(softMachine);
        int softMachineId = softMachine.getId();
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();

        //when
        List<Company> companies = companyDao.getByNameFragment("Software");
        //then
        try {
            assertEquals(1, companies.size());
        } finally {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(softMachineId);
        }
    }

    @Test
    void delete(){
        companyDao.deleteById(268);
        companyDao.deleteById(269);
        companyDao.deleteById(272);
        companyDao.deleteById(273);
    }

    private void createData(){
        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
    }
}