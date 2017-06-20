package com.example.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.greendao.model.Customer;
import com.example.greendao.model.CustomerDao;
import com.example.greendao.model.Note;
import com.example.greendao.model.NoteDao;
import com.example.greendao.model.Order;
import com.example.greendao.model.OrderDao;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // warning: should never do this on the main thread, doing this here for brevity
        insertAndLoadNote();
        insertAndUpdateToMany();
    }

    private void insertAndLoadNote() {
        NoteDao noteDao = ExampleApp.getDaoSession(this).getNoteDao();

        Note note = new Note();
        note.setText("some text");
        note.setDate(new Date());
        noteDao.insert(note);

        note.setText("some new text");
        noteDao.update(note);

        Note noteLoaded = noteDao.load(note.getId());

        // load the example inserted on creating the database
        Note noteExample = noteDao.load(1L);
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
