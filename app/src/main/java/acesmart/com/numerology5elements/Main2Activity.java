package acesmart.com.numerology5elements;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.Map;
import java.util.Random;

public class Main2Activity extends AppCompatActivity  {

    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */

    static TextView txttimeset, txtdateset;
    static int mYear = 0, mMonth = 0, mDay = 0;
    static Context appContext;
    static int REQUEST_CODE = 10;
    static int itemposition;


    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    TextView txtDate = null, txtName = null;
    RadioButton radioButton = null;
    TextView txtA, txtTime;
    final boolean[] resultempty = {true};
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        appContext = getApplicationContext();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        assert mViewPager != null;
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        assert tabLayout != null;
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create new Birthchart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mViewPager.setCurrentItem(0);
                View currentview = mViewPager.getChildAt(0);
                EditText etname = (EditText)currentview.findViewById(R.id.etName);
                etname.setText("");
                TextView dob = (TextView) currentview.findViewById(R.id.dateOfBirth);
                dob.setText("DD-MM-YYYY");
                LinearLayout linearLayout = (LinearLayout) currentview.findViewById(R.id.ll_fragment);
                linearLayout.setVisibility(View.INVISIBLE);


            }
        });


        int choice = 0;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                choice = 0;
            } else {
                choice = extras.getInt("Choice");
            }
        }

        if (choice > 0)
            mViewPager.setCurrentItem(choice - 1);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main2 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void radioButtonSelected(View view) {
        View rootview = view.getRootView();
        RadioButton radioButton;
        if (view.getId() == R.id.radioButtonMale) {

            radioButton = (RadioButton) rootview.findViewById(R.id.radioButtonFemale);
            radioButton.setChecked(false);
        } else {
            radioButton = (RadioButton) rootview.findViewById(R.id.radioButtonMale);
            radioButton.setChecked(false);
        }
    }

    public void showDatePickerDialog(View view) {
        txtdateset = (TextView) view.findViewById(R.id.dateOfBirth);
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public void showTimePickerDialog(View view) {
        txttimeset = (TextView) view.findViewById(R.id.tvTime);

        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timepicker");
    }

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }




    static public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        public TimePickerFragment() {

        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user

            txttimeset.setText(new StringBuilder().append(pad(hourOfDay)).append(":").append(pad(minute)));
        }
    }

    public static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            txtdateset.setText(day + "-"
                    + (month + 1) + "-" + year);
            mYear = year;
            mMonth = month + 1;
            mDay = day;
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements  ItemClickListener{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        TextView txtDate = null, txtName = null;
        RadioButton radioButton = null;

        private ListView listView;
        TextView txtA, txtTime;


        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Bundle bundle = this.getArguments();
            int i = bundle.getInt(ARG_SECTION_NUMBER);

            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);

            final boolean[] resultempty = {true};

//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            if (i == 1) {
                rootView = inflater.inflate(R.layout.fragment_main2, container, false);
                txtDate = (TextView) rootView.findViewById(R.id.dateOfBirth);
                txtName = (TextView) rootView.findViewById(R.id.etName);
                txtA = (TextView) rootView.findViewById(R.id.tvA);
                radioButton = (RadioButton) rootView.findViewById(R.id.radioButtonMale);
                txtTime = (TextView) rootView.findViewById(R.id.tvTime);
                final LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.ll_fragment);
                linearLayout.setVisibility(View.INVISIBLE);



                final Button btnAnalyze = (Button) rootView.findViewById(R.id.btnAnalyze);
                final View finalRootView = rootView;

                btnAnalyze.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mMonth == 0) {
                            Toast.makeText(getContext(), "BIRTHDATE is EMPTY", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Calculation calculation = new Calculation(mDay, mMonth, mYear);
                        Map<String, Integer> result;
                        result = calculation.getMap();
                        linearLayout.setVisibility(View.VISIBLE);

                        ShowNumbers showNumbers = new ShowNumbers();
                        showNumbers.ComposeResult(result, finalRootView);
                        resultempty[0] = false;

                        final TextView tvroot = (TextView) finalRootView.findViewById(R.id.tvO);
                        final ToggleButton tglbutton = (ToggleButton) finalRootView.findViewById(R.id.toggleButton);

                        tvroot.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent myIntent = new Intent(getContext(),
                                        DisplayDefinition.class);
                                myIntent.putExtra("key", tvroot.getText().toString()); //Optional parameters
                                startActivity(myIntent);

                            }
                        });

                        tglbutton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                View getRoot = v.getRootView();
                                TextView tvH1 = (TextView) finalRootView.findViewById(R.id.tvH1);
                                TableRow tableRow1 = (TableRow) finalRootView.findViewById(R.id.row_hidden2);
                                TableRow tableRow2 = (TableRow) finalRootView.findViewById(R.id.row_hidden3);
                                if (tglbutton.isChecked()) {
                                    tvH1.setVisibility(View.VISIBLE);
                                    tableRow1.setVisibility(View.VISIBLE);
                                    tableRow2.setVisibility(View.VISIBLE);
                                } else {
                                    tvH1.setVisibility(View.INVISIBLE);
                                    tableRow1.setVisibility(View.GONE);
                                    tableRow2.setVisibility(View.GONE);

                                }

                            }
                        });


                    }
                });


                Button btnSave = (Button) rootView.findViewById(R.id.btnSave);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnAnalyze.performClick();

                        if (txtName.getText().toString().equals("")) {
                            txtName.setError("Name is EMPTY, please fill int first");
                            Toast.makeText(getContext(), "NAME is EMPTY", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (mDay == 0) {
                            Toast.makeText(getContext(), "BIRTHDATE is EMPTY", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (resultempty[0]) {
                            Toast.makeText(getContext(), "BIRTHDATE is EMPTY", Toast.LENGTH_LONG).show();

                            return;
                        }
                        String gender = null;
                        if (radioButton.isChecked()) {// meaning Male is selected
                            gender = "Male";
                        } else {
                            gender = "Female";
                        }
                        NumerologyDBHelper numerologyDBHelper = new NumerologyDBHelper(getContext(), null, null, 0);
                        SQLiteDatabase db = numerologyDBHelper.getReadableDatabase();
                        numerologyDBHelper.onCreate(db);
                        final ContentValues contentValues = new ContentValues();
                        int idgen = randInt(1, 1000);
                        contentValues.put(CustomerDB.CustomerEntry.COLUMN_NAME_CUST_ID, idgen);
                        contentValues.put(CustomerDB.CustomerEntry.COLUMN_NAME_CUST_NAME, txtName.getText().toString());
                        contentValues.put(CustomerDB.CustomerEntry.COLUMN_NAME_GENDER, gender);
                        contentValues.put(CustomerDB.CustomerEntry.COLUMN_NAME_DATE_OF_BIRTH, txtDate.getText().toString());
                        contentValues.put(CustomerDB.CustomerEntry.COLUMN_NAME_TIME_OF_BIRTH, txtTime.getText().toString());
                        ShowNumbers showNumbers = new ShowNumbers();


                        TextView tvroot = (TextView) finalRootView.findViewById(R.id.tvO);
                        contentValues.put(CustomerDB.CustomerEntry.COLUMN_NAME_ROOT, tvroot.getText().toString());

                        String result = showNumbers.composeData(finalRootView);
                        contentValues.put(CustomerDB.CustomerEntry.COLUMN_NAME_RESULT, result);
                        db.insert(CustomerDB.CustomerEntry.TABLE_NAME, null, contentValues);
                        db.close();

                        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();
                    }
                });

                SeekBar seekBar = (SeekBar) rootView.findViewById(R.id.seekBar);

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    int tmpYear = 0;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        tmpYear = mYear + i;
                        Calculation calculation = new Calculation(mDay, mMonth, tmpYear);
                        Map<String, Integer> result;
                        result = calculation.getMap();
                        ShowNumbers showNumbers = new ShowNumbers();
                        showNumbers.ComposeResult(result, finalRootView);

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });


            }
            if (i == 2) {
                rootView = inflater.inflate(R.layout.four_digit_layout, container, false);
                Button btn = (Button) rootView.findViewById(R.id.btnCalculate);
                final View finalRootView = rootView;
                final EditText etfirst = (EditText) rootView.findViewById(R.id.etFirst);
                final EditText etsecond = (EditText) rootView.findViewById(R.id.etSecond);
                final EditText etthird = (EditText) rootView.findViewById(R.id.etThird);
                final EditText etfourth = (EditText) rootView.findViewById(R.id.etFourth);


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int mfirst, msecond, mthird, mfourth;
                        EditText tv = (EditText) finalRootView.findViewById(R.id.etFirst);
                        mfirst = Integer.valueOf(tv.getText().toString());
                        tv = (EditText) finalRootView.findViewById(R.id.etSecond);
                        msecond = Integer.valueOf(tv.getText().toString());
                        tv = (EditText) finalRootView.findViewById(R.id.etThird);
                        mthird = Integer.valueOf(tv.getText().toString());
                        tv = (EditText) finalRootView.findViewById(R.id.etFourth);
                        mfourth = Integer.valueOf(tv.getText().toString());

                        Calculation calculation = new Calculation(mfirst, msecond, mthird, mfourth);
                        Map<String, Integer> result;
                        result = calculation.getMap();
                        ScrollView scrollView = (ScrollView) finalRootView.findViewById(R.id.scrlView2);
                        scrollView.setVisibility(View.VISIBLE);

                        ShowNumbers showNumbers = new ShowNumbers();
                        showNumbers.ComposeResult(result, finalRootView);

                        final TextView tvroot = (TextView) finalRootView.findViewById(R.id.tvO);
                        tvroot.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent myIntent = new Intent(getContext(),
                                        DisplayDefinition.class);
                                myIntent.putExtra("key", tvroot.getText().toString()); //Optional parameters
                                startActivity(myIntent);

                            }
                        });

                    }
                });

                final ToggleButton tglbutton = (ToggleButton) finalRootView.findViewById(R.id.toggleButton);

                tglbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TextView tvH1 = (TextView) finalRootView.findViewById(R.id.tvH1);
//                        TableRow tableRow = (TableRow) finalRootView.findViewById(R.id.row_hidden1);
                        TableRow tableRow1 = (TableRow) finalRootView.findViewById(R.id.row_hidden2);
                        TableRow tableRow2 = (TableRow) finalRootView.findViewById(R.id.row_hidden3);
                        if (tglbutton.isChecked()) {
                            tvH1.setVisibility(View.VISIBLE);
//                            tableRow.setVisibility(View.VISIBLE);
                            tableRow1.setVisibility(View.VISIBLE);
                            tableRow2.setVisibility(View.VISIBLE);
                        } else {
                            tvH1.setVisibility(View.INVISIBLE);
//                            tableRow.setVisibility(View.GONE);
                            tableRow1.setVisibility(View.GONE);
                            tableRow2.setVisibility(View.GONE);

                        }

                    }
                });


            }
            if (i == 3) {
                rootView = inflater.inflate(R.layout.people_list, container, false);
                final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.people_recycler_view);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);

                NumerologyDBHelper numerologyDBHelper = new NumerologyDBHelper(Main2Activity.appContext, null, null, 0);
                SQLiteDatabase db = numerologyDBHelper.getReadableDatabase();
                Cursor c = db.rawQuery("SELECT * FROM " + CustomerDB.CustomerEntry.TABLE_NAME, null);
                PeopleAdapter adapter = new PeopleAdapter(c, getContext());
                recyclerView.setAdapter(adapter);
                adapter.setClickListener(this);
//                ScrollView scrollView1 = (ScrollView) rootView.findViewById(R.id.scrlView);
//                scrollView1.setVisibility(View.INVISIBLE);


            }
            return rootView;
        }



        @Override
        public void onClick(View view, int position) {

            TextView txtCustDOB = (TextView) view.findViewById(R.id.tvCustDOB);
            TextView txtName = (TextView) view.findViewById(R.id.tvCustName);
            TextView txtCustID = (TextView) view.findViewById(R.id.tvCustID);
            String custdob = txtCustDOB.getText().toString();
            custdob = custdob.substring(custdob.indexOf(":")+2);
            String custID = txtCustID.getText().toString();
            custID = custID.substring(custID.indexOf(":")+2);
            itemposition = position;

            Intent i = new Intent(getContext(),BirthChart.class);
            i.putExtra("name",txtName.getText().toString());
            i.putExtra("dob",custdob);
            i.putExtra("custid",custID);
            startActivityForResult(i, REQUEST_CODE);



        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE){
                if (resultCode == RESULT_OK){
                    View view = getView();
                    ViewParent viewparent = view.getParent();
                    ViewPager viewPager = (ViewPager) view.getParent();
                    viewPager.setCurrentItem(0);
                    viewPager.refreshDrawableState();

//                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.people_recycler_view);
//                    recyclerView.removeViewAt(itemposition);
//                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
//                    adapter.notifyItemRemoved(itemposition);
//                    adapter.notifyItemRangeChanged(itemposition,adapter.getItemCount());
//                    recyclerView.getAdapter().notifyDataSetChanged();

                }
            }
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "BIRTHCHART";
                case 1:
                    return "QUICKPLOT";
                case 2:
                    return "PEOPLE";
            }
            return null;
        }
    }


}
