package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bloodbank.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button dnrButton = findViewById(R.id.becomeBlDonorButton);
        dnrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, DonorInfoActivity.class);
                startActivity(i);
            }
        });

//        Button donorsViewlButton = findViewById(R.id.donorsViewButton);
//        donorsViewlButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Toast.makeText(NewActivity.this, "Hello", Toast.LENGTH_SHORT).show();
//
//                Intent i = new Intent(HomeActivity.this, TableViewDonorsInfoActivity.class);
//                startActivity(i);
//
//            }
//        });

        Button collectBlButton = findViewById(R.id.collectBlButton);
        collectBlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(NewActivity.this, "Hello", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(HomeActivity.this, CollectorLogRegActivity.class);
                startActivity(i);

            }
        });


    }
}