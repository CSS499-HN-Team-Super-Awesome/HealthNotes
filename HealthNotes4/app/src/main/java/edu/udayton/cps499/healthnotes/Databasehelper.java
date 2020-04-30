package edu.udayton.cps499.healthnotes;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class Databasehelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HealthNotesManager";
    private static final String TABLE_PROVIDERS = "Providers";
    private static final String TABLE_PRESCRIPTIONS = "Prescriptions";
    private static final String TABLE_USERS = "Users";

    // Column names for all tables
    private static final String KEY_ID = "id";
    private static final String KEY_Name = "name";

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

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PROVIDER);
        db.execSQL(CREATE_TABLE_PRESCRIPTIONS);
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PROVIDERS);
        onCreate(db);
    }

    void addProvider(Provider provider) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, provider.getName());
        //Add more values as necessary


        db.insert(TABLE_PROVIDERS, null, values); db.close;
    }
    Provider getProvider(int id) {
        SQLiteDatabase db = db.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PROVIDERS, new String[](KEY_NAME), new String[](String.valueOf(id)), null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Provider provider = new Provider(Integer.parseInt(cursor.getString(0)));
        return provider;
    }
    public List < Provider > getAllProviders() {
        List < Provider > providersList = new ArrayList < >() ;

        String selectQuery = "SELECT *FROM" + TABLE_PROVIDERS;

        SQLiteDatabase db = this.getWritableDatabase;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst) {
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
        values.put(KEY_Name, Provider.getName());

        // updating row
        return db.update(TABLE_PROVIDERS, values, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(todo.getId())
                });
    }
    public void deleteToDo(long ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(ID)
                });
    }
    void addPrescription(Prescription prescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, prescription.getScriptName());
        // Add new values as necessary

        db.insert(TABLE_PRESCRIPTIONS, null, values); db.close;
    }
    Provider getPrescription(int id) {
        SQLiteDatabase db = db.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRESCRIPTIONS, new String[](KEY_NAME), new String[](String.valueOf(id)), null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Prescription prescription = new Prescription(Integer.parseInt(cursor.getString(0)));
        return provider;
    }
    public List < Prescriptions > getAllPrescriptions() {
        List < Prescriptions > prescriptionsList = new ArrayList < > ();

        String selectQuery = "SELECT *FROM" + TABLE_PRESCRIPTIONS;

        SQLiteDatabase db = this.getWritableDatabase;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst) {
            do {
                Prescritption prescription = new Prescription();
                prescription.setName(cursor.getString(0));
                prescriptionsList.add(prescription);
            } while (cursor.moveToNext());
        }
        return prescriptionsList;
    }
    public int updatePrescription(Prescription prescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, prescription.getScriptName();

        // updating row
        return db.update(TABLE_PRESCRIPTIONS, values, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(todo.getId())
                });
    }
    public void deletePrescription(long ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(ID)
                });
    }

    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        // Add new values as necessary


        db.insert(TABLE_USERS, null, values); db.close;
    }
    Provider getUser(int id) {
        SQLiteDatabase db = db.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[](KEY_NAME), new String[](String.valueOf(id)), null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        User user = new User(Integer.parseInt(cursor.getString(0)));
        return provider;
    }
    public List < User > getAllUsers() {
        List < Users > usersList = new ArrayList < >() ;

        String selectQuery = "SELECT *FROM" + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst) {
            do {
                Provider provider = new Provider();
                provider.setName(cursor.getString(0));
                providersList.add(provider);
            }
            while (cursor.moveToNext());
        }
        return providersList;
    }
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());

        // updating row
        return db.update(TABLE_PRESCRIPTIONS, values, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(todo.getId())
                });
    }
    public void deleteToDo(long ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[] {
                        String.valueOf(ID)
                });
    }

}