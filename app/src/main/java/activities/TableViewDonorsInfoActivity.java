package activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bloodbank.R;

import java.util.List;

import models.DBHelper;
import models.DonorInfo;

public class TableViewDonorsInfoActivity extends AppCompatActivity {

    TableLayout tableLayout;
    TextView text1, text2,text3,text4,text5;
    Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_view_donors_info);
        tableLayout = findViewById(R.id.tableLayout);


        try{
            View tableRow = LayoutInflater.from(this).inflate(R.layout.table_rows, null, false);


        text1 = tableRow.findViewById(R.id.textFullName);
        text2 = tableRow.findViewById(R.id.textGender);
        text3 = tableRow.findViewById(R.id.textBloodGroup);
        text4 = tableRow.findViewById(R.id.textPhone);
        text5 = tableRow.findViewById(R.id.textAddress);


        text1.setText("Full Name");
        text2.setText("Gender");
        text3.setText("Blood Group");
        text4.setText("Phone");
        text5.setText("Address");

        tableLayout.addView(tableRow);

        DBHelper dbHelper = new DBHelper(this);
        List<DonorInfo> donorInfos = dbHelper.donorInfoList();

        for(int i = 0; i<donorInfos.size(); i++){

            Log.d("1", donorInfos.get(i).getFull_Name());

            View tableRow1 = LayoutInflater.from(this).inflate(R.layout.table_rows, null, false);


            text1 = tableRow1.findViewById(R.id.textFullName);
            text2 = tableRow1.findViewById(R.id.textGender);
            text3 = tableRow1.findViewById(R.id.textBloodGroup);
            text4 = tableRow1.findViewById(R.id.textPhone);
            text5 = tableRow1.findViewById(R.id.textAddress);

            text1.setText(donorInfos.get(i).getFull_Name());
            text2.setText(donorInfos.get(i).getGender());
            text3.setText(donorInfos.get(i).getBlood_group());
            text4.setText(donorInfos.get(i).getPhone());
            text5.setText(donorInfos.get(i).getAddress());


            tableLayout.addView(tableRow1);

            tableRow1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    TableRow row = (TableRow) view;
                    TextView t1 = (TextView) row.getChildAt(1);
                    TextView t2 = (TextView) row.getChildAt(5);
                    TextView t3 = (TextView) row.getChildAt(6);
                    TextView t4 = (TextView) row.getChildAt(7);
                    TextView t5 = (TextView) row.getChildAt(8);



                    String s = t1.getText().toString() + " " + t2.getText().toString()+ " " +
                            t3.getText().toString()+ " " + t4.getText().toString()
                            + " " + t5.getText().toString();

                    Toast.makeText(TableViewDonorsInfoActivity.this, s, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }catch (Exception e){

        }
    }
}