package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.bloodbank.R;

import java.util.List;

import models.DBHelper;
import models.DonorInfo;

public class SearchBloodActivity extends AppCompatActivity {
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_blood);

        btnSearch = findViewById(R.id.buttonSearchBlood);
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent donorsViewTable = new Intent(SearchBloodActivity.this, TableViewDonorsInfoActivity.class);
//                startActivity(donorsViewTable);
//            }
//        });



    }

    EditText searchBlood;

    public List<DonorInfo> searchblood(View view){

        searchBlood = findViewById(R.id.serachReqrBlood);

        String textSearchBlood = searchBlood.getText().toString();

        DBHelper dbHelper = new DBHelper(this);
        List<DonorInfo> listDonor = dbHelper.searchBlood(textSearchBlood);

        for(int i = 0; i<listDonor.size(); i++){


            Log.d("Donar List = ", listDonor.get(i).getFull_Name());
        }

    return listDonor;
    }

}