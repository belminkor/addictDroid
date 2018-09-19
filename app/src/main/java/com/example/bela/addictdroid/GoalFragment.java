package com.example.bela.addictdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static android.widget.CompoundButton.*;

public class GoalFragment extends Fragment {

    private static final String ARG_GOAL_ID = "goal_id";
    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_DATE = 0;

    private Goal mGoal;
    private EditText mTitleField;
    private TextView mStartDateText;
    private Button mDeadlineDateButton;
    private CheckBox mSolvedCheckbox;

    public static GoalFragment newInstance(UUID goalId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_GOAL_ID, goalId);

        GoalFragment fragment = new GoalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID goalId = (UUID) getArguments().getSerializable(ARG_GOAL_ID);
        mGoal = GoalLab.get(getActivity()).getGoal(goalId);
        setHasOptionsMenu(true);
    }

    // delete goal
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_goal, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_item_delete_goal:
                UUID goalId = (UUID) getArguments().getSerializable(ARG_GOAL_ID);
                GoalLab goalLab = GoalLab.get(getActivity());
                Goal mGoal = GoalLab.getGoal(goalId);
                goalLab.deleteGoal(mGoal);
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_goal, container, false);

        mTitleField = (EditText) v.findViewById(R.id.goal_title);
        mTitleField.setText(mGoal.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStartDateText= (TextView) v.findViewById(R.id.goal_text_start_date);
        // current date
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
        String dateString = sdf.format(date);
        mStartDateText.setText(dateString);
        mGoal.setStartDate(new Date(date));

        mDeadlineDateButton = (Button) v.findViewById(R.id.goal_deadline_date);
        updateDeadlineDate();
        mDeadlineDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment
                        .newInstance(mGoal.getDeadlineDate());
                dialog.setTargetFragment(GoalFragment.this, REQUEST_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });
        //mGoal.setDeadlineDate();

        mSolvedCheckbox = (CheckBox) v.findViewById(R.id.goal_solved);
        mSolvedCheckbox.setChecked(mGoal.isSolved());
        mSolvedCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                mGoal.setSolved(isChecked);
            }
        });

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();

        GoalLab.get(getActivity())
                .updateGoal(mGoal);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mGoal.setDeadlineDate(date);
            updateDeadlineDate();
        }
    }

    private void updateDeadlineDate() {
        mDeadlineDateButton.setText(mGoal.getDeadlineDate().toString());
    }
}
