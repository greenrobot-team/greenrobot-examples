package com.example.greendao;

import com.example.greendao.model.Customer;
import com.example.greendao.model.CustomerDao;
import com.example.greendao.model.Order;
import com.example.greendao.model.OrderDao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // warning: should never do this on the main thread, doing this here for brevity
        insertAndUpdateToMany();
    }

    private void insertAndUpdateToMany() {
        CustomerDao customerDao = ExampleApp.getDaoSession(this).getCustomerDao();
        OrderDao orderDao = ExampleApp.getDaoSession(this).getOrderDao();

        Customer customer = new Customer();
        customerDao.insert(customer);

        // get the to-many list before inserting the new entity
        // otherwise the new entity might be in the list twice
        List<Order> orders = customer.getOrders();

        // create the new entity
        Order newOrder = new Order();
        newOrder.setDate(new Date());

        // set the foreign key property
        newOrder.setCustomerId(customer.getId());

        // persist the new entity
        orderDao.insert(newOrder);
        // add it to the to-many list
        orders.add(newOrder);
    }
}
