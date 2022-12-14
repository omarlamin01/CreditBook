package com.example.credit__book.Activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.credit__book.Adapter.OperationsAdapter;
import com.example.credit__book.Model.Operation;
import com.example.credit__book.R;

public class ViewReportCashbook extends AppCompatActivity {
    TextView CountOp ;
    OperationsAdapter opAD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report_cashbook);
        MyApplication context = (MyApplication) this.getApplicationContext();

        for(int i=0 ;i<10;i++){
            Operation listItem = new Operation("11-16-2022",100.00,"Cash in") ;
            context.getListOperations().add(listItem);
        }
        opAD = new OperationsAdapter(context.getListOperations());
        RecyclerView recyclerViewOperation = findViewById(R.id.recycleViewOperation);
        recyclerViewOperation.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOperation.setAdapter(opAD);
        recyclerViewOperation.setHasFixedSize(true);
        CountOp = findViewById(R.id.textViewoperation);
        CountOp.setText("Operations("+opAD.getItemCount()+")");
    }
}