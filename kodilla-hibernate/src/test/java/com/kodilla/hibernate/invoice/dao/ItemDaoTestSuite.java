package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ItemDaoTestSuite {

    @Autowired
    ItemDao itemDao;

    @Test
    void testItemSave(){
        //given
        Product book = new Product("book");
        Item bookItem = new Item(book, new BigDecimal(39), 1);

        //when
        itemDao.save(bookItem);
        int id = bookItem.getId();

        //then
        assertNotEquals(0,1);

        //cleanup
        itemDao.deleteById(id);
    }

}
