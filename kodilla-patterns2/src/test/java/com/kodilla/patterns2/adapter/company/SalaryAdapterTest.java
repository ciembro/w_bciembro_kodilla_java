package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryAdapterTest {

    @Test
    void testTotalSalary() {
        //given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();

        //when
        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());

        //then
        System.out.println(totalSalary);
        assertEquals(27750, totalSalary, 0);
    }
}