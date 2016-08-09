package acesmart.com.numerology5elements;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mylaptop on 8/9/2016.
 */
public class NumerologyDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Numerology.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + CustomerDB.CustomerEntry.TABLE_NAME + " (" +
                    CustomerDB.CustomerEntry._ID + " INTEGER PRIMARY KEY," +
                    CustomerDB.CustomerEntry.COLUMN_NAME_CUST_ID + TEXT_TYPE + COMMA_SEP +
                    CustomerDB.CustomerEntry.COLUMN_NAME_CUST_NAME + TEXT_TYPE + COMMA_SEP +
                    CustomerDB.CustomerEntry.COLUMN_NAME_GENDER + TEXT_TYPE + COMMA_SEP +
                    CustomerDB.CustomerEntry.COLUMN_NAME_DATE_OF_BIRTH + TEXT_TYPE + COMMA_SEP +
                    CustomerDB.CustomerEntry.COLUMN_NAME_TIME_OF_BIRTH + TEXT_TYPE + COMMA_SEP +
                    CustomerDB.CustomerEntry.COLUMN_NAME_RESULT + TEXT_TYPE + COMMA_SEP +
                    CustomerDB.CustomerEntry.COLUMN_NAME_ROOT + TEXT_TYPE +
                    " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CustomerDB.CustomerEntry.TABLE_NAME;
    private static final String SQL_DELETE_FROM_TABLE =
            "DELETE FROM " + CustomerDB.CustomerEntry.TABLE_NAME;
    private Context context;

    public NumerologyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}