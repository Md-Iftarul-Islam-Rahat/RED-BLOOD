package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bloodbank.R;

public class CollectorLogRegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collector_log_reg);

        Button cltrRegButton = findViewById(R.id.collectRegButton);
        cltrRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CollectorLogRegActivity.this, BCollectorRegtrActivity.class);
                startActivity(i);
            }
        });
        Button cltrLogButton = findViewById(R.id.collectorLogButton);
        cltrLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(NewActivity.this, "Hello", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(CollectorLogRegActivity.this, BCollectorLogActivity.class);
                startActivity(i);

            }
        });
    }
}