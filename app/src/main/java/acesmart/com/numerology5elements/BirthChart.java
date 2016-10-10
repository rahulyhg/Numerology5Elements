package acesmart.com.numerology5elements;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.HashMap;
import java.util.Map;

public class BirthChart extends AppCompatActivity {

    String custname ="", custdob = "";
    String custid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birth_chart);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                custname = "";custdob = "";
            } else {
                custname = extras.getString("name");
                custdob = extras.getString("dob");
                custid = extras.getString("custid");
            }
        }

        TextView txtcustname = (TextView) findViewById(R.id.textViewName);
        txtcustname.setText(custname);

        TextView txtcustdob = (TextView)findViewById(R.id.textViewDOB);
        txtcustdob.setText(custdob);

        TextView txtcustid = (TextView) findViewById(R.id.textViewID);
        txtcustid.setText(custid);

        final Map<String, Integer> thedate;
        thedate = parsingDate(custdob);

        Calculation calculation = new Calculation(thedate.get("day"),thedate.get("month"), thedate.get("year"));
        Map<String, Integer> result;
        result = calculation.getMap();
        ShowNumbers showNumbers = new ShowNumbers();
        final LinearLayout ll_birtchart = (LinearLayout) findViewById(R.id.cust_birtchart);
        showNumbers.ComposeResult(result,ll_birtchart );

        final ToggleButton tglbutton = (ToggleButton) findViewById(R.id.toggleButton);

        tglbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                TextView tvH1 = (TextView) ll_birtchart.findViewById(R.id.tvH1);
                TableRow tableRow = (TableRow) ll_birtchart.findViewById(R.id.row_hidden1);
                TableRow tableRow1 = (TableRow) ll_birtchart.findViewById(R.id.row_hidden2);
                TableRow tableRow2 = (TableRow) ll_birtchart.findViewById(R.id.row_hidden3);
                if (tglbutton.isChecked()) {
//                            tvH1.setVisibility(View.VISIBLE);
                    tableRow.setVisibility(View.VISIBLE);
                    tableRow1.setVisibility(View.VISIBLE);
                    tableRow2.setVisibility(View.VISIBLE);
                } else {
//                            tvH1.setVisibility(View.INVISIBLE);
                    tableRow.setVisibility(View.GONE);
                    tableRow1.setVisibility(View.GONE);
                    tableRow2.setVisibility(View.GONE);

                }

            }
        });

        SeekBar seekBar = (SeekBar) ll_birtchart.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mDay = thedate.get("day");
            int mMonth = thedate.get("month");
            int mYear = thedate.get("year");
                int tmpYear = 0;

                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    tmpYear = mYear + i;
                    Calculation calculation = new Calculation(mDay, mMonth, tmpYear);
                    Map<String, Integer> result;
                    result = calculation.getMap();
                    ShowNumbers showNumbers = new ShowNumbers();
                    showNumbers.ComposeResult(result, ll_birtchart);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        final String customerID = custid;
        final AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Are you sure you want to DELETE this customer?");
        dlgAlert.setTitle("WARNING");
        dlgAlert.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                NumerologyDBHelper numerologyDBHelper = new NumerologyDBHelper(getBaseContext(), null, null, 0);
                SQLiteDatabase db = numerologyDBHelper.getWritableDatabase();
                String qry = "DELETE FROM " + CustomerDB.CustomerEntry.TABLE_NAME + " where " +
                        CustomerDB.CustomerEntry.COLUMN_NAME_CUST_ID + " = '" + customerID + "'";
                try{
                    db.execSQL(qry);
                    Intent intent = getIntent();
                    setResult(RESULT_OK, intent);
                    Toast.makeText(getApplicationContext(), "Succesfully DELETE", Toast.LENGTH_LONG).show();
                    finish();

                } catch (SQLException e){
                    Toast.makeText(getApplicationContext(), "FAIL to Delete", Toast.LENGTH_LONG).show();

                }

            }
        });
        dlgAlert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dlgAlert.setCancelable(true);

        Button buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlgAlert.create().show();


            }
        });



    }

    private Map<String,Integer> parsingDate(String inputdate){

        Map<String, Integer> dob = new HashMap<String, Integer>();;
        String day, month, year;
        day = inputdate.substring(0,inputdate.indexOf("-"));
        inputdate = inputdate.substring(inputdate.indexOf("-")+1);
        month = inputdate.substring(0,inputdate.indexOf("-"));
        inputdate = inputdate.substring(inputdate.indexOf("-")+1);
        year = inputdate;
        dob.put("day",Integer.parseInt(day));
        dob.put("month", Integer.parseInt(month));
        dob.put("year", Integer.parseInt(year));

        return dob;
    }
}
