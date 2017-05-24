package com.otterairways.otterairways;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import	android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static java.lang.String.valueOf;

/**
 * Created by Mohamad on 5/3/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME="FlightDB";
    private static final String TABLE_FLIGHTS="flights";
    private static final String TABLE_CUSTOMER="customer";
    private static final String TABLE_RESERVE="reserve";
    private static final int DATABASE_VERSION=1;
    //columns in DATA BASE
    private static final String Key_flight="flight";
    private static final String Key_arrival="arrival";
    private static final String Key_departure=" departure";
    private static final String Key_tickets="tickets";
    private static final String Key_time="time";
    private static final String Key_price="price";
    private static final String Key_username="username";
    private static final String Key_password="password";
    private static final String Key_Rusername="rusername";
    private static final String Key_rflight="rflight";
    private static final String Key_rarrival="rarrival";
    private static final String Key_rdeparture="rdeparture";
    private static final String Key_rtime="rtime";
    private static final String Key_rprice="rprice";
    private static final String KEY_ID = "id";

    private static final String TAG = "SQLiteAppLog";


    public MySQLiteHelper(Context context)

    {
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create a table called "books"

        String CREATE_flights_TABLE =
                "CREATE TABLE flights ( " +
                        "flight TEXT, " +
                        "Departure TEXT, " +
                        "arrival TEXT, " +
                        "tickets INTEGER, " +
                        "time TEXT, " +
                        "price TEXT )";
        String CREATE_customer_TABLE =
                "CREATE TABLE customer ( " +
                        "username TEXT, " +
                        "password TEXT )";

        String CREATE_reserve_TABLE=
                "CREATE TABLE reserve ( " +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "rusername TEXT, " +
                        "rflight TEXT, " +
                        "rDeparture TEXT, " +
                        "rarrival TEXT, " +
                        "rtime TEXT, " +
                        "rprice TEXT )";



        // Execute an SQL statement to create the table
        db.execSQL(CREATE_flights_TABLE);
        db.execSQL(CREATE_customer_TABLE);
        db.execSQL(CREATE_reserve_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS flights");
        db.execSQL("DROP TABLE IF EXISTS customer");
        db.execSQL("DROP TABLE IF EXISTS reserve");


        // create fresh books table
        this.onCreate(db);
    }

    public void addFlight(Flights flights)
    {
        Log.d(TAG, "addflight() - " + flights.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(Key_flight,flights.get_f_number()); // get title
        values.put(Key_departure,flights.get_departure()); // get author
        values.put(Key_arrival,flights.get_arrival());
        values.put(Key_tickets,flights.get_tickets());
        values.put(Key_time,flights.get_time());
        values.put(Key_price,flights.get_price());


        // 3. insert
        db.insert(TABLE_FLIGHTS,null,values);
        // key/value -> keys = column names/ values = column values

        // 4. close - release the reference of writable DB
        db.close();
    }
    public void addCustomer(Customer customer)
    {
        Log.d(TAG, "addCustomer() - " + customer.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(Key_username, customer.get_u_name()); // get title
        values.put(Key_password, customer.get_pass()); // get author
        // 3. insert
        db.insert(TABLE_CUSTOMER,null,values); // key/value -> keys = column names/ values = column values
        // 4. close - release the reference of writable DB
        db.close();
    }
    public void addReservation(Reserve reserve)
    {
        Log.d(TAG, "addReservation() - " + reserve.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(Key_Rusername,reserve.get_u_name()); // get title
        values.put(Key_rflight,reserve.get_f_number());// get author
        values.put(Key_rdeparture,reserve.get_departure());
        values.put(Key_rarrival,reserve.get_arrival());
        values.put(Key_rprice,reserve.get_price());
        values.put(Key_rtime,reserve.get_time());



        // 3. insert
        db.insert(TABLE_RESERVE,null,values); // key/value -> keys = column names/ values = column values

        // 4. close - release the reference of writable DB
        db.close();
    }
    public void updateFlight(Flights flights)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String where = Key_flight+ "='"+flights.get_f_number()+"'";
        values.put(Key_tickets,flights.get_tickets()-1);


        db.update(TABLE_FLIGHTS, values, where,null);



        // It's a good practice to use parameter ?, instead of concatenate string
        //db.update(TABLE_FLIGHTS, values,Key_tickets + "= ?", new String[] { String.valueOf(flights.get_tickets()) });
        db.close(); // Closing database connection
    }
    public ArrayList<Flights> getAllFlights() {
        ArrayList<Flights> Flight = new ArrayList<Flights>();

        String query = "SELECT  * FROM " + TABLE_FLIGHTS; // Build a query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // Go over each row, build book and add it to an array list called “books”
        Flights flight = null;
        if (cursor.moveToFirst()) {
            do {
                flight= new Flights();
                flight.set_f_number(cursor.getString(0));
                flight.set_departure(cursor.getString(1));
                flight.set_arrival(cursor.getString(2));
                flight.set_tickets(Integer.parseInt(cursor.getString(3)));
                flight.set_time(cursor.getString(4));
                flight.set_price(cursor.getString(5));
                Flight.add(flight);
            } while (cursor.moveToNext());
        }
        cursor.close();
        Log.d(TAG, "getAllFlights() - " + Flight.toString());  // Debugging purpose
        return Flight;
    }
    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> Customers = new ArrayList<Customer>();

        String query = "SELECT  * FROM " + TABLE_CUSTOMER; // Build a query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // Go over each row, build book and add it to an array list called “books”
        Customer customer = null;
        if (cursor.moveToFirst()) {
            do {
                customer= new Customer();
                customer.set_u_name(cursor.getString(0));
                customer.set_pass(cursor.getString(1));
                Customers.add(customer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        Log.d(TAG, "getAllCustomer() - " + Customers.toString());  // Debugging purpose
        return Customers;
    }
    public ArrayList<Reserve> getAllReservations() {
        ArrayList<Reserve> Reservations = new ArrayList<Reserve>();

        String query = "SELECT  * FROM " + TABLE_RESERVE; // Build a query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // Go over each row, build book and add it to an array list called “books”
        Reserve Reservation = null;
        if (cursor.moveToFirst()) {
            do {
                Reservation= new Reserve();
                Reservation.set_id(Integer.parseInt(cursor.getString(0)));
                Reservation.set_u_name(cursor.getString(1));
                Reservation.set_f_number(cursor.getString(2));
                Reservation.set_departure(cursor.getString(3));
                Reservation.set_arrival(cursor.getString(4));
                Reservation.set_time(cursor.getString(5));
                Reservation.set_price(cursor.getString(6));
                Reservations.add(Reservation);
            } while (cursor.moveToNext());
        }
        cursor.close();
        Log.d(TAG, "getAllReservations() - " + Reservations.toString());  // Debugging purpose
        return Reservations;
    }
    public void deleteFlight(Flights flights)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String where = Key_flight+ "='"+flights.get_f_number()+"'";


        db.delete(TABLE_FLIGHTS,where,null);



        // It's a good practice to use parameter ?, instead of concatenate string
        //db.update(TABLE_FLIGHTS, values,Key_tickets + "= ?", new String[] { String.valueOf(flights.get_tickets()) });
        db.close(); // Closing database connection
    }
    public void deleteReservation(Reserve reservation) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_RESERVE,
                KEY_ID+" = ?",
                new String[] { String.valueOf(reservation.get_id()) });

        // 3. close
        db.close();

        Log.d(TAG, "deleteReservation() - " + reservation.toString());
    }
}






