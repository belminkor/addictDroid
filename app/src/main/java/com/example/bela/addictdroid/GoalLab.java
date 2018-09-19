package com.example.bela.addictdroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bela.addictdroid.database.GoalBaseHelper;
import com.example.bela.addictdroid.database.GoalCursorWrapper;
import com.example.bela.addictdroid.database.GoalDbSchema;
import com.example.bela.addictdroid.database.GoalDbSchema.GoalTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.bela.addictdroid.database.GoalDbSchema.GoalTable.*;
import static com.example.bela.addictdroid.database.GoalDbSchema.GoalTable.Cols.*;

public class GoalLab {
    private static GoalLab sGoalLab;
    private Context mContext;
    private static SQLiteDatabase mDatabase;

    public static GoalLab get(Context context) {
        if (sGoalLab == null) {
            sGoalLab = new GoalLab(context);
        }

        return sGoalLab;
    }

    private GoalLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new GoalBaseHelper(mContext)
                .getWritableDatabase();

    }

    public void addGoal(Goal c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(GoalTable.NAME, null, values);
    }

    public List<Goal> getGoals() {
        List<Goal> goals = new ArrayList<>();
        GoalCursorWrapper cursor = queryGoals(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                goals.add(cursor.getGoal());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return goals;
    }

    public static Goal getGoal(UUID id) {
        GoalCursorWrapper cursor = queryGoals(
                GoalTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getGoal();
        } finally {
            cursor.close();
        }
    }

    public void updateGoal(Goal goal) {
        String uuidString = goal.getId().toString();
        ContentValues values = getContentValues(goal);
        mDatabase.update(GoalTable.NAME, values,
                GoalTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    // delete goal
    public void deleteGoal(Goal goal) {
        String uuidString = goal.getId().toString();
        mDatabase.delete(GoalTable.NAME, GoalTable.Cols.UUID + " = ?", new String[] {uuidString});
    }

    private static GoalCursorWrapper queryGoals(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                GoalTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new GoalCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Goal goal) {
        ContentValues values = new ContentValues();
        values.put(UUID, goal.getId().toString());
        values.put(TITLE, goal.getTitle());
        values.put(STARTDATE, goal.getStartDate().getTime());
        values.put(DATE, goal.getDeadlineDate().getTime());
        values.put(SOLVED, goal.isSolved() ? 1 : 0);
        return values;
    }


}
