package models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "blood";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_DONOR_INFO = "donorInfo";
    private static final String TABLE_BCOLLECTOR_REGISTER = "bcollector_register";



//Donor Info Table columns name
    private static final String KEY_ID = "id";
    private static final String DONOR_FULL_NAME = "full_Name";
    private static final String DONOR_NICKNAME = "nick_Name";
    private static final String DONOR_EMAIL = "email";
    private static final String DONOR_DOB = "dob";
    private static final String DONOR_GENDER = "gender";
    private static final String DONOR_BLOOD_GROUP = "blood_group";
    private static final String DONOR_PHONE = "phone";
    private static final String DONOR_ADDRESS = "address";
    private static final String DONOR_COUNTRY = "country";


    //Blood Collector Register Table columns name
    private static final String COLLECTOR_NAME = "name";
    private static final String COLLECTOR_EMAIL = "email";
    private static final String COLLECTOR_PASSWORD = "password";
    private static final String COLLECTOR_CONFIRM_PASSWORD = "confirm_password";
    //Donor info table Query
    private static final String CREATE_TABLE_DONOR_INFO = "CREATE TABLE "
            + TABLE_DONOR_INFO + "(" + KEY_ID + " INTEGER PRIMARY KEY , " + DONOR_FULL_NAME
            + " TEXT," + DONOR_NICKNAME + " TEXT," +DONOR_EMAIL +" TEXT ,"+ DONOR_DOB + " TEXT,"+ DONOR_GENDER + " TEXT,"
            + DONOR_BLOOD_GROUP + " TEXT," + DONOR_PHONE + " TEXT," + DONOR_ADDRESS +" TEXT," +DONOR_COUNTRY +" TEXT " + " )";

    //Blood Collector Register table Query
    private static final String CREATE_TABLE_COLLECTOR_REGISTER = "CREATE TABLE "
            + TABLE_BCOLLECTOR_REGISTER + "(" + KEY_ID + " INTEGER PRIMARY KEY , " + COLLECTOR_NAME
            + " TEXT," + COLLECTOR_EMAIL + " TEXT,"+ COLLECTOR_PASSWORD +" TEXT," + COLLECTOR_CONFIRM_PASSWORD +" TEXT " + " )";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_DONOR_INFO);
        sqLiteDatabase.execSQL(CREATE_TABLE_COLLECTOR_REGISTER);

    }
//Blood Donor Info saved/Add method
    public long addDonorInfo(DonorInfo donorInfo){
        Log.d("DonorInfo","table created");
        ContentValues values = new ContentValues();
        values.put("full_Name", donorInfo.getFull_Name());
        values.put("nick_Name", donorInfo.getNick_Name());
        values.put("email", donorInfo.getEmail());
        values.put("dob", donorInfo.getDob());
        values.put("gender", donorInfo.getGender());
        values.put("blood_group", donorInfo.getBlood_group());
        values.put("phone", donorInfo.getPhone());
        values.put("address", donorInfo.getAddress());
        values.put("country", donorInfo.getCountry());

        SQLiteDatabase database = this.getWritableDatabase();

        long i = database.insert(TABLE_DONOR_INFO,null,values);
        database.close();
        return i;
    }
//Blood Collector Registered Code............../////////////////////////////
    public long addBCollector(BCollectorRegistration bCollectorRegistration){
        ContentValues values = new ContentValues();
        values.put("name", bCollectorRegistration.getName());
        values.put("email", bCollectorRegistration.getEmail());
        values.put("password", bCollectorRegistration.getPassword());
        values.put("confirm_password", bCollectorRegistration.getConfirm_password());


        SQLiteDatabase database = this.getWritableDatabase();

        long i = database.insert(TABLE_BCOLLECTOR_REGISTER,null,values);
        database.close();
        return i;

    }
//Blood Collector Login Code///////////////////////////............................
    public BCollectorRegistration loginUser(BCollectorRegistration bCollectorRegistration){
        Log.d("BCollentor Login", "printed.........");
        String sql = "Select * from bcollector_register where email = ? AND password = ?";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor c = database.rawQuery(sql, new String[]{bCollectorRegistration.getEmail(), bCollectorRegistration.getPassword()});
        if(c.moveToFirst()){
            Log.d("Login", c.getString(1));
            BCollectorRegistration u = new BCollectorRegistration();
            u.setName(c.getString(1));
            u.setEmail(c.getString(2));
            u.setPassword(c.getString(3));
            u.setConfirm_password(c.getString(4));
            return u;
        }else{
            return null;
        }
    }

    public List<DonorInfo> searchBlood(String blood_group){
        Log.d("Donor Info", "printed");
        String sql = "select * from " + TABLE_DONOR_INFO + " where "+DONOR_BLOOD_GROUP+"=?";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor c = database.rawQuery(sql, new String[]{blood_group});
        List<DonorInfo> donorInfoList = new ArrayList<DonorInfo>();
        if(c.moveToFirst()){
            do{
                DonorInfo donorInfo = new DonorInfo();
                donorInfo.setFull_Name(c.getString(1));
                donorInfo.setNick_Name(c.getString(2));
                donorInfo.setEmail(c.getString(3));
                donorInfo.setDob(c.getString(4));
                donorInfo.setGender(c.getString(5));
                donorInfo.setBlood_group(c.getString(6));
                donorInfo.setPhone(c.getString(7));
                donorInfo.setAddress(c.getString(8));
                donorInfo.setCountry(c.getString(9));
                donorInfoList.add(donorInfo);
//                Log.d("Dbhelper searchloodh = ", donorInfoList.get(0).getFull_Name());
            }while (c.moveToNext());
            return donorInfoList;
        }else{
            Log.d("Dbhelper = ", "searchBlood = return null.");
            return null;
        }
    }




    public List<DonorInfo> donorInfoList(){
        Log.d("Donor Info", "printed");
        String sql = "select * from " + TABLE_DONOR_INFO;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor c = database.rawQuery(sql, new String[]{});
        List<DonorInfo> donorInfoList = new ArrayList<DonorInfo>();
        if(c.moveToFirst()){
            do{
                DonorInfo donorInfo = new DonorInfo();
                donorInfo.setFull_Name(c.getString(1));
                donorInfo.setNick_Name(c.getString(2));
                donorInfo.setEmail(c.getString(3));
                donorInfo.setDob(c.getString(4));
                donorInfo.setGender(c.getString(5));
                donorInfo.setBlood_group(c.getString(6));
                donorInfo.setPhone(c.getString(7));
                donorInfo.setAddress(c.getString(8));
                donorInfo.setCountry(c.getString(9));
                donorInfoList.add(donorInfo);
            }while (c.moveToNext());
            //Log.d("Register", "printed");
            return donorInfoList;
        }else{
            Log.d("", "null");
            return null;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
