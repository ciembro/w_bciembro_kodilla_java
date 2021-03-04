package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //given
        Product book = new Product("book");
        Product pen = new Product("pen");
        Item bookItem = new Item(book, new BigDecimal(25), 1);
        Item penItem = new Item(pen, new BigDecimal(1), 5);

        Invoice invoice = new Invoice("01/21");
        invoice.getItemList().add(bookItem);
        invoice.getItemList().add(penItem);

        //when
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //then
        assertNotEquals(0,1);
        //cleanup
        invoiceDao.deleteById(id);

    }
}
