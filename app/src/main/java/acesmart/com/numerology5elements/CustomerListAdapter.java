package acesmart.com.numerology5elements;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mylaptop on 8/11/2016.
 */
public class CustomerListAdapter extends BaseAdapter {

    ShowNumbers showNumbers = new ShowNumbers();
    private Cursor c;
//    = getdatafromDB();

    public CustomerListAdapter(Cursor cursor){
        c = cursor;

    }
    @Override
    public int getCount() {
        return c.getCount();
    }

    @Override
    public Object getItem(int position) {

        c.moveToPosition(position);
        return         c;
    }

    @Override
    public long getItemId(int position) {
        return 0;
//        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) Main2Activity.appContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.detail_list, parent, false);
        }

        TextView tvname = (TextView) convertView.findViewById(R.id.tvCustName);
        TextView tvdob = (TextView) convertView.findViewById(R.id.tvCustDOB);
        TextView tvroot = (TextView) convertView.findViewById(R.id.tvRootNumber);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgicon);


        c.moveToPosition(position);
        int idx = -1;
        idx = c.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_CUST_NAME);
        String name = c.getString(idx);
        tvname.setText("Name : "  + name);

        idx = c.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_DATE_OF_BIRTH);
        String dob = c.getString(idx);
        tvdob.setText("Date of Birth :" + dob);

        idx = c.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_ROOT);
        String rootnumber = c.getString(idx);
        tvroot.setText("Root :" + rootnumber);

        idx = c.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_GENDER);
        String gender = c.getString(idx);
        if (gender.equals("Male")){
            imageView.setImageResource(R.drawable.man);

        }else{
            imageView.setImageResource(R.drawable.woman);

        }

        showNumbers.chooseColor(rootnumber,tvroot);


        notifyDataSetChanged();


        return convertView;


    }



    public Cursor getdatafromDB(){
        NumerologyDBHelper numerologyDBHelper = new NumerologyDBHelper(Main2Activity.appContext, null,null, 0);

        SQLiteDatabase db = numerologyDBHelper.getReadableDatabase();


        c = db.rawQuery("SELECT * FROM " + CustomerDB.CustomerEntry.TABLE_NAME, null);


        return c;

    }

    public void dbupdated(){

        c = getdatafromDB();
        notifyDataSetChanged();
    }



}
