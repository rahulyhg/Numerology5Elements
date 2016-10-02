package acesmart.com.numerology5elements;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mylaptop on 9/29/2016.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>{


    Cursor cursor;
    int idxname, idxdob, idxroot, idxgender, idxcustid;
    Context mcontext;
    ItemClickListener clickListener;

    public PeopleAdapter(Cursor c, Context context){
        cursor = c;
        idxname = cursor.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_CUST_NAME);
        idxdob = cursor.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_DATE_OF_BIRTH);
        idxroot = cursor.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_ROOT);
        idxgender = cursor.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_GENDER);
        idxcustid = cursor.getColumnIndex(CustomerDB.CustomerEntry.COLUMN_NAME_CUST_ID);
        this.mcontext = context;
    }

    @Override
    public PeopleAdapter.PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_detail,parent,false);
        return new PeopleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PeopleAdapter.PeopleViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        TextView txtName = holder.txtName;
        TextView txtDOB = holder.txtDOB;
        TextView txtRoot = holder.txtRoot;
        TextView txtCustID = holder.txtID;

        cursor.moveToPosition(position);
        txtName.setText("Name       : " + cursor.getString(idxname));
        txtDOB.setText("Birthdate   : " + cursor.getString(idxdob));
        txtRoot.setText("Root number : " + cursor.getString(idxroot));
        txtCustID.setText("ID : " + cursor.getString(idxcustid));
        String gender = cursor.getString(idxgender);

        if (gender.equals("Male")){
            imageView.setImageResource(R.drawable.man);
        }
        else
        {
            imageView.setImageResource(R.drawable.woman);
        }



    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public class PeopleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView txtName, txtDOB, txtRoot, txtID;
        LinearLayout ll_layout;

        public PeopleViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imgPeople);
            this.txtName = (TextView) itemView.findViewById(R.id.tvCustName);
            this.txtDOB = (TextView) itemView.findViewById(R.id.tvCustDOB);
            this.txtRoot = (TextView) itemView.findViewById(R.id.tvRootNumber);
            this.txtID = (TextView) itemView.findViewById(R.id.tvCustID);
            this.ll_layout = (LinearLayout) itemView.findViewById(R.id.ll_layout);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }


}
