package edu.xyjiangbrandeis.hw2;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xinyijiang on 11/9/17.
 */

public class ExpenseLogEntryData {
    private String mDesp;
    private String mNotes;
    private String mTime;
    private int mID;

    public ExpenseLogEntryData(String desp, String notes){
        mTime = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        mDesp = desp;
        mNotes = notes;
    }

    public ExpenseLogEntryData(int id, String desp, String notes, String time){
        mID = id;
        mTime = time;
        mDesp = desp;
        mNotes = notes;
    }


    public void setDesp (String desp){
        mDesp = desp;
    }

    public void setNotes (String notes){
        mNotes = notes;
    }

    public void setTime (Date date) {
        mTime = DateFormat.getDateTimeInstance().format(date);
    }

    public String getDesp () {
        return mDesp;
    }

    public String getNotes () {
        return mNotes;
    }

    public String getTime () {
        return mTime;
    }

    public int getID () {
        return mID;
    }

}
