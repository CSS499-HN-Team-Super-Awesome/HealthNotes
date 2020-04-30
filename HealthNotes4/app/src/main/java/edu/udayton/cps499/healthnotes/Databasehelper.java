package edu.udayton.cps499.healthnotes;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HealthNotesManager";
    private static final String TABLE_PROVIDERS = "Providers";
    private static final String TABLE_PRESCRIPTIONS = "Prescriptions";
    private static final String TABLE_USERS = "Users";

    private static final String LOG = "DatabaseHelper";

    // Column names for all tables
    private static final String KEY_ID = "id";
    private static final String KEY_Name = "name";
    private static final String KEY_CREATED_AT = "created_at";

    // Provider table column names
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_SPECIALTY = "specialty";
    //Prescription table column names
    private static final String KEY_STRENGTH = "strength";
    private static final String KEY_TIME = "time";
    // User table column names
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    // Table Create Statements
    // Provider table create statement
    private static final String CREATE_TABLE_PROVIDER = "CREATE TABLE " +
            TABLE_PROVIDERS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ADDRESS +
            " TEXT," + KEY_SPECIALTY + " INTEGER," + KEY_CREATED_AT +
            " DATETIME" + ")";

    // Prescription table create statement
    private static final String CREATE_TABLE_PRESCRIPTIONS = "CREATE TABLE " + TABLE_PRESCRIPTIONS +
            "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_STRENGTH + " TEXT," +
            KEY_CREATED_AT + " DATETIME" + ")";

    // User table create statement
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " +
            TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_USERNAME + " Text," + KEY_PASSWORD + " Text," +
            KEY_CREATED_AT + " DATETIME" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PROVIDER);
        db.execSQL(CREATE_TABLE_PRESCRIPTIONS);
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addProvider(Provider provider) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, provider.getName());
        //Add more values as necessary


        db.insert(TABLE_PROVIDERS, null, values);
    }
    Provider getProvider(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_PROVIDERS + " WHERE "
                + KEY_ID + " = " + KEY_Name;

        Log.e(LOG, selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Provider provider = new Provider();
        provider.setName(cursor.getString(cursor.getColumnIndex(KEY_Name)));
        return provider;
    }
    public List< Provider > getAllProviders() {
        List < Provider > providersList = new ArrayList< >() ;

        String selectQuery = "SELECT *FROM " + TABLE_PROVIDERS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Provider provider = new Provider();
                provider.setName(cursor.getString(0));
                providersList.add(provider);
            } while (cursor.moveToNext());
        }
        return providersList;
    }
    public int updateProvider(Provider provider) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(KEY_Name, Provider.getName());

        // updating row
        return db.update(TABLE_PROVIDERS, values, KEY_ID + " = ?",
                new String[] {
                    //    String.valueOf(provider.getId())
                });
    }
    public void deleteProvider(long ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PROVIDERS, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(ID)
                });
    }
    void addPrescription(Prescription prescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, prescription.getScriptName());
        // Add new values as necessary

        db.insert(TABLE_PRESCRIPTIONS, null, values);
    }
    Prescription getPrescription(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_PRESCRIPTIONS + " WHERE "
                + KEY_ID + " = " + KEY_Name;

        Log.e(LOG, selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Prescription prescription = new Prescription();
        prescription.setName(cursor.getString(cursor.getColumnIndex(KEY_Name)));
        return prescription;
    }
    public List < Prescription > getAllPrescriptions() {
        List < Prescription > prescriptionsList = new ArrayList < > ();

        String selectQuery = "SELECT * ,FROM" + TABLE_PRESCRIPTIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Prescription prescription = new Prescription();
                prescription.setName(cursor.getString(0));
                prescriptionsList.add(prescription);
            } while (cursor.moveToNext());
        }
        return prescriptionsList;
    }
    public int updatePrescription(Prescription prescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, prescription.getScriptName());

        // updating row
        return db.update(TABLE_PRESCRIPTIONS, values, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(prescription.getId())
                });
    }
    public void deletePrescription(long ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRESCRIPTIONS, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(ID)
                });
    }

    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_Name, user.getName());
        // Add new values as necessary


        db.insert(TABLE_USERS, null, values);
    }
    User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE "
                + KEY_ID + " = " + user_id;

        Log.e(LOG, selectQuery);

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        User user = new User();
        user.setName(cursor.getString(cursor.getColumnIndex(KEY_Name)))

        return user;
    }
    public List <User> getAllUsers() {
        List <User> usersList = new ArrayList < >() ;

        String selectQuery = "SELECT *, FROM" + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Provider provider = new Provider();
                provider.setName(cursor.getString(0));
                usersList.add(user);
            }
            while (cursor.moveToNext());
        }
        return usersList;
    }
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, user.getName());

        // updating row
        return db.update(TABLE_PRESCRIPTIONS, values, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(user.getId())
                });
    }
    public void deleteUser(long ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(ID)
                });
    }

}