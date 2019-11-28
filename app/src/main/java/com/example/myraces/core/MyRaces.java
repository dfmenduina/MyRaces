package com.example.myraces.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyRaces extends SQLiteOpenHelper {

    private static int version = 3;
    public static String nombre = "my_races";
    private String LOG_RACES = "MYRACES";
    public static String TABLA = "MyRaces";
    public static String RACE_ID = "_id";
    public static String RACE_NAME = "nombre";
    public static String RACE_DATE = "fecha";
    public static String RACE_TIME = "hora";
    public static String RACE_DIST = "distancia";
    public static String RACE_TYPE = "superficie";




    public MyRaces(Context context){
        super(context,nombre,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("DBManager",nombre + " creating: "+ TABLA);
        try {

            db.beginTransaction();
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLA + "(" +
                    RACE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    RACE_NAME + " string(75) NOT NULL, " +
                    RACE_DATE + " string(10) NOT NULL, " +
                    RACE_TIME + " string(5) NOT NULL, " +
                    RACE_DIST + " int NOT NULL, " +
                    RACE_TYPE + " string(10) NOT NULL)");

            db.setTransactionSuccessful();

        }catch (SQLException exc){
            Log.e(LOG_RACES, "Creando la base de datos: "+ exc.getMessage());
        }finally{
            db.endTransaction();
        }
        return;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("DBManager",nombre+" "+oldVersion+" -> "+newVersion);
        try {
            db.beginTransaction();
            db.execSQL("DROP TABLE IF EXISTS "+ TABLA);
            db.setTransactionSuccessful();
        }catch (SQLException exc){
            Log.e(LOG_RACES,"Eliminando la base de datos: "+exc.getMessage());
        }finally {
            db.endTransaction();
        }
    }

    public void guardar(Races race){
        final SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(RACE_NAME,race.getNombre());
        cv.put(RACE_DATE,race.getFecha());
        cv.put(RACE_TIME,race.getHora());
        cv.put(RACE_DIST, race.getDistancia());
        cv.put(RACE_TYPE,race.getSuperficie());

        try {
            DB.beginTransaction();
            DB.insert(TABLA,null,cv);
            DB.setTransactionSuccessful();

        }catch (SQLException exc){
            Log.e(LOG_RACES,"Insertando un nuevo registro: "+exc.getMessage());
        }finally {
            DB.endTransaction();
        }
    }

    public Cursor getAllCursor(){
        return this.getReadableDatabase().query(TABLA,null,null,null,null,null,RACE_DATE + " ASC");
    }
}
