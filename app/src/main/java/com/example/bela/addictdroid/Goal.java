package com.example.bela.addictdroid;

import java.util.Date;
import java.util.UUID;

public class Goal {

    private UUID mId;
    private String mTitle;
    private Date mStartDate;
    private Date mDeadlineDate;
    private boolean mSolved;

    public Goal() {
        this(UUID.randomUUID());
    }

    public Goal(UUID id) {
        mId = id;
        mDeadlineDate = new Date();
        long date = System.currentTimeMillis();
        mStartDate = new Date(date);
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getDeadlineDate() {
        return mDeadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        mDeadlineDate = deadlineDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
