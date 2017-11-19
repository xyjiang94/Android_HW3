package edu.xyjiangbrandeis.hw2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xinyijiang on 11/9/17.
 */

public class ExpenseTrackerAdapter extends BaseAdapter {

    private List<ExpenseLogEntryData> dataArray;
    private LayoutInflater mInflater;
    private Context mContext;
    private DatabaseHandler mDatabase;

    public ExpenseTrackerAdapter(Context context) {
        mContext = context;

        mDatabase = new DatabaseHandler(mContext);
        dataArray = mDatabase.getAllExpense();

        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return dataArray.size();
    }

    @Override
    public Object getItem(int position) {
        return dataArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.expense_entry, parent, false);

        TextView despTextView = (TextView) rowView.findViewById(R.id.desp);
        TextView timeTextView = (TextView) rowView.findViewById(R.id.time);
        TextView noteTextView = (TextView) rowView.findViewById(R.id.notes);
        Button deleteBtn = (Button) rowView.findViewById(R.id.delete_button);

        ExpenseLogEntryData entry = (ExpenseLogEntryData) getItem(position);

        despTextView.setText(entry.getDesp());
        timeTextView.setText(entry.getTime());
        noteTextView.setText(entry.getNotes());

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExpenseLogEntryData expense = (ExpenseLogEntryData) getItem(position);
                mDatabase.deleteExpense(expense);
                dataArray = mDatabase.getAllExpense();
                notifyDataSetChanged();
            }
        });


        return rowView;
    }

    public void addItem(ExpenseLogEntryData entry) {

        mDatabase.addExpense(entry);

        dataArray = mDatabase.getAllExpense();
        notifyDataSetChanged();
    }
}
