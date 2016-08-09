package acesmart.com.numerology5elements;

import android.provider.BaseColumns;

/**
 * Created by mylaptop on 8/9/2016.
 */
public final class CustomerDB {

    public CustomerDB(){

    }

    public static abstract class CustomerEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_customer";
        public static final String COLUMN_NAME_CUST_ID = "cust_id";
        public static final String COLUMN_NAME_CUST_NAME = "name";
        public static final String COLUMN_NAME_GENDER = "gender";
        public static final String COLUMN_NAME_DATE_OF_BIRTH = "date_of_birth";
        public static final String COLUMN_NAME_TIME_OF_BIRTH = "time_of_birth";
        public static final String COLUMN_NAME_RESULT = "result";
        public static final String COLUMN_NAME_ROOT = "root";
    }
}
