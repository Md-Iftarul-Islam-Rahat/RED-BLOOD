package activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.bloodbank.R;

import java.util.ArrayList;
import java.util.List;

import models.DBHelper;
import models.DonorInfo;

public class DonorInfoActivity extends AppCompatActivity {
    EditText FullName, NickName, Email, DOB, Gender, Blood_Group, Phone, Address, Country;
    Button btnAdd;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_info);
//validation below
//        FullName = findViewById(R.id.fullName);
//        NickName = findViewById(R.id.nickName);
//        Email = findViewById(R.id.donorEmail);
//        DOB = findViewById(R.id.dob);
//        Gender = findViewById(R.id.gender);
//        Blood_Group = findViewById(R.id.bloodGroup);
//        Phone = findViewById(R.id.phone);
//        Address = findViewById(R.id.address);
//        Country = findViewById(R.id.country);
        btnAdd = findViewById(R.id.donorSave);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.fullName,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.nickName,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.donorEmail,
                Patterns.EMAIL_ADDRESS,R.string.invalid_email);

        awesomeValidation.addValidation(this,R.id.phone,
                "[5-9]{1}[0-9]{9}$",R.string.invalid_numder);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(), "Field Validation Successful", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"validation faild",Toast.LENGTH_LONG).show();
                }
            }
        });


//end of validation code

        //start insert data to database

        final DBHelper dbHelper = new DBHelper(this);

        Button btnAdd = findViewById(R.id.donorSave);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FullName = findViewById(R.id.fullName);
                NickName = findViewById(R.id.nickName);
                Email= findViewById(R.id.donorEmail);
                DOB = findViewById(R.id.dob);
                Gender = findViewById(R.id.gender);
                Blood_Group = findViewById(R.id.bloodGroup);
                Phone = findViewById(R.id.phone);
                Address= findViewById(R.id.address);
                Country = findViewById(R.id.country);




                String textFName = FullName.getText().toString();
                String textNName = NickName.getText().toString();
                String textEmail = Email.getText().toString();
                String textDOB = DOB.getText().toString();
                String textGender = Gender.getText().toString();
                String textBGroup = Blood_Group.getText().toString();
                String textPhone = Phone.getText().toString();
                String textAddress = Address.getText().toString();
                String textCountry = Country.getText().toString();

                DonorInfo donorInfo  = new DonorInfo();

                donorInfo.setFull_Name(textFName);
                donorInfo.setNick_Name(textNName);
                donorInfo.setEmail(textEmail);
                donorInfo.setDob(textDOB);
                donorInfo.setGender(textGender);
                donorInfo.setBlood_group(textBGroup);
                donorInfo.setPhone(textPhone);
                donorInfo.setAddress(textAddress);
                donorInfo.setCountry(textCountry);

                Long i = dbHelper.addDonorInfo(donorInfo);

                if( i >0){
                    //Toast.makeText(DonorInfoActivity.this, "Donor info values inserted Successfully", Toast.LENGTH_SHORT).show();
                    String s = textNName+ "\n"+ "\n" + textEmail+ "\n"+ "\n" + textGender+ "\n"+ "\n" + textBGroup+ "\n"+ "\n"+ textPhone+ "\n"+ "\n"+ textAddress;
                    AlertDialog.Builder  builder = new AlertDialog.Builder(DonorInfoActivity.this);
                    builder.setTitle("Donors Information" );
                    builder.setMessage(s);
                    builder.setCancelable(true);
                    builder.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();

                        }
                    });
                    builder.show();

                }

                FullName.setText("");
                NickName.setText("");
                Email.setText("");
                DOB.setText("");
                Gender.setText("");
                Blood_Group.setText("");
                Phone.setText("");
                Address.setText("");
                Country.setText("");
            }
        });
    }

}