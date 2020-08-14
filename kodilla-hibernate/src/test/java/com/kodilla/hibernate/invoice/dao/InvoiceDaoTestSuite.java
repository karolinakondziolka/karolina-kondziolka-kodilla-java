package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    public void testInvoiceDaoSave(){

        //Given
        Product product1 = new Product("radio");
        Product product2 = new Product("glass");
        Product product3 = new Product("wheel");
        Product product4 = new Product("switch");

        Invoice invoice1 = new Invoice("8354567");
        Invoice invoice2 = new Invoice("8351234");
        Invoice invoice3 = new Invoice("8358901");
        Invoice invoice4 = new Invoice("8350001");

        Item item1 = new Item(product1, new BigDecimal(400),10,new BigDecimal(4000));
        Item item2 = new Item(product2, new BigDecimal(500),4,new BigDecimal(2000));
        Item item3 = new Item(product3, new BigDecimal(0.15),1000,new BigDecimal(150));
        Item item4 = new Item(product4, new BigDecimal(0.015),1000,new BigDecimal(15));

        product1.getItem().add(item1);
        product2.getItem().add(item2);
        product3.getItem().add(item3);
        product4.getItem().add(item4);

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);
        item4.setProduct(product4);

        invoice1.getItems().add(item1);
        invoice2.getItems().add(item2);
        invoice3.getItems().add(item3);
        invoice4.getItems().add(item4);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice2);
        item3.setInvoice(invoice3);
        item4.setInvoice(invoice4);

        //When
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        productDao.save(product4);

        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        invoiceDao.save(invoice3);
        invoiceDao.save(invoice4);

        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);
        itemDao.save(item4);

        int item1Id = item1.getId();
        int item2Id = item2.getId();
        int item3Id = item3.getId();
        int item4Id = item4.getId();

        //Then
        Assert.assertNotEquals(0, item1Id);
        Assert.assertNotEquals(0, item2Id);
        Assert.assertNotEquals(0, item3Id);
        Assert.assertNotEquals(0, item4Id);

        //CleanUp
        itemDao.deleteAll();
        productDao.deleteAll();
        invoiceDao.deleteAll();

    }
}
