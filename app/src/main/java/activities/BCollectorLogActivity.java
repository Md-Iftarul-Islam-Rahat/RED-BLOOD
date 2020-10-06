package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bloodbank.R;

import models.BCollectorRegistration;
import models.DBHelper;

public class BCollectorLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_collector_log);

    }

    public void loginUser(View view){
        try {
            Log.d("Login", "printed...........");
            EditText email = findViewById(R.id.coltrLoginEmail);
            EditText password = findViewById(R.id.coltrLoginPassword);

            String textEmail = email.getText().toString();
            String textPassword = password.getText().toString();

            BCollectorRegistration bCollectorRegistration = new BCollectorRegistration();

            bCollectorRegistration.setEmail(textEmail);
            bCollectorRegistration.setPassword(textPassword);

            DBHelper rDB = new DBHelper(this);
            BCollectorRegistration u = rDB.loginUser(bCollectorRegistration);
            if(u != null){
                Intent i = new Intent(BCollectorLogActivity.this, SearchBloodActivity.class);
                i.putExtra("email", u.getEmail());
                i.putExtra("password", u.getPassword());
                startActivity(i);
            }else{
                Toast.makeText(this, "Email/Password Incorrect", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(this, "Email/Password field blank", Toast.LENGTH_SHORT).show();
        };
    }
}