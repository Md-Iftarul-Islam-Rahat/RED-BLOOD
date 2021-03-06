package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bloodbank.R;

import models.BCollectorRegistration;
import models.DBHelper;

public class BCollectorRegtrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_collector_regtr);

        final DBHelper dbHelper = new DBHelper(this);

        Button btnadd = findViewById(R.id.coltrRegisterBotton);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Name,Email , Pass;

                Name = findViewById(R.id.coltrName);
                Email = findViewById(R.id.coltrEmail);
                Pass = findViewById(R.id.coltrPassword);


                String textName = Name.getText().toString();
                String textEmail = Email.getText().toString();
                String textPass = Pass.getText().toString();

                BCollectorRegistration bCollectorRegistration  = new BCollectorRegistration();

                bCollectorRegistration.setName(textName);
                bCollectorRegistration.setEmail(textEmail);
                bCollectorRegistration.setPassword(textPass);


                Long i = dbHelper.addBCollector(bCollectorRegistration);

                if( i >0){
                    Intent intent = new Intent(BCollectorRegtrActivity.this, CollectorLogRegActivity.class);
                    intent.putExtra("name", bCollectorRegistration.getName());
                    intent.putExtra("password", bCollectorRegistration.getPassword());
                    startActivity(intent);

                    Toast.makeText(BCollectorRegtrActivity.this, "Value inserted Successfully", Toast.LENGTH_SHORT).show();
                }
                Name.setText("");
                Email.setText("");
                Pass.setText("");
            }
        });
    }

}