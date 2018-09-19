package com.example.bela.addictdroid.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.bela.addictdroid.Goal;
import com.example.bela.addictdroid.database.GoalDbSchema.GoalTable;

import java.util.Date;
import java.util.UUID;

public class GoalCursorWrapper extends CursorWrapper {

    public GoalCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Goal getGoal() {
        String uuidString = getString(getColumnIndex(GoalTable.Cols.UUID));
        String title = getString(getColumnIndex(GoalTable.Cols.TITLE));
        long startDate = getLong(getColumnIndex(GoalTable.Cols.STARTDATE));
        long date = getLong(getColumnIndex(GoalTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(GoalTable.Cols.SOLVED));

        Goal goal = new Goal(UUID.fromString(uuidString));
        goal.setTitle(title);
        goal.setStartDate(new Date(startDate));
        goal.setDeadlineDate(new Date(date));
        goal.setSolved(isSolved != 0);

        return goal;
    }
}

