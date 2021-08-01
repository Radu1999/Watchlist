package com.example.movieapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import com.example.movieapp.adapters.ShowAdapter;
import com.example.movieapp.models.Show;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private ShowAdapter mAdapter;
    private List<Show> mShows;
    private int mPosition;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    public void setRequirements(ShowAdapter adapter, List<Show> shows, int position) {
        mAdapter = adapter;
        mShows = shows;
        mPosition = position;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0);
        mShows.get(mPosition).setDate(calendar.getTime());
        AppDatabase.getAppDatabase(getContext()).showDao().update(mShows.get(mPosition));
        mAdapter.notifyDataSetChanged();
    }

}
