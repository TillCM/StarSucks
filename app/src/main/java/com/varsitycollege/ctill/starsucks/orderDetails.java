package com.varsitycollege.ctill.starsucks;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class orderDetails extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener datepickerlistner;
    String product,date,size,time;
    ImageView calander ;
    TextView tv_product,tv_date;

    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        tv_product = findViewById(R.id.tv_Product);
        tv_date = findViewById(R.id.tv_Size);

        calander = findViewById(R.id.img_calendar);

        order = new Order();
        product = getIntent().getStringExtra("Product");

        order.setProductDescription(product);
        tv_product.setText(order.productDescription);



        calander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(orderDetails.this, "clicked", Toast.LENGTH_SHORT).show();
                // Access the calendar
                Calendar datpickerCal = Calendar.getInstance();
                int year = datpickerCal.get(Calendar.YEAR);
                int month  = datpickerCal.get(Calendar.MONTH);
                int day = datpickerCal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog ordersDatePicker = new DatePickerDialog(orderDetails.this,
                        android.R.style.Theme_DeviceDefault,datepickerlistner,year,month,day);

                ordersDatePicker.show();

            }
        });

        datepickerlistner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {

                date = year+" "+month+" "+day ;
                tv_date.setText(date);

            }
        };






    }
}
