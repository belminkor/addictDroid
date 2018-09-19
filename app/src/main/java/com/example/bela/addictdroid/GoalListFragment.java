package com.example.bela.addictdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class GoalListFragment extends Fragment {

    private RecyclerView mGoalRecyclerView;
    private GoalAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goal_list, container, false);

        mGoalRecyclerView = (RecyclerView) view
                .findViewById(R.id.goal_recycler_view);
        mGoalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_goal_list, menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_goal:
                Goal goal = new Goal();
                GoalLab.get(getActivity()).addGoal(goal);
                Intent intent = GoalPagerActivity
                        .newIntent(getActivity(), goal.getId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        GoalLab goalLab = GoalLab.get(getActivity());
        List<Goal> goals = goalLab.getGoals();

        if (mAdapter == null) {
            mAdapter = new GoalAdapter(goals);
            mGoalRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setGoals(goals);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class GoalHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private Goal mGoal;

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private ImageView mSolvedImageView;

        public GoalHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_goal, parent, false));
            itemView.setOnClickListener(this);
            // on long click listener
            itemView.setOnLongClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.goal_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.goal_date);
            mSolvedImageView = (ImageView) itemView.findViewById(R.id.goal_solved);
        }

        public void bind(Goal goal) {
            mGoal = goal;
            mTitleTextView.setText(mGoal.getTitle());
            mDateTextView.setText(mGoal.getDeadlineDate().toString());
            mSolvedImageView.setVisibility(goal.isSolved() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            Intent intent = GoalPagerActivity.newIntent(getActivity(), mGoal.getId());
            startActivity(intent);
        }

        @Override
        public boolean onLongClick(View view) {
//            Toast.makeText(getContext(),
//                    R.string.app_name,
//                    Toast.LENGTH_SHORT).show();

            return true;
        }
    }



    private class GoalAdapter extends RecyclerView.Adapter<GoalHolder> {

        private List<Goal> mGoals;

        public GoalAdapter(List<Goal> goals) {
            mGoals = goals;
        }

        @Override
        public GoalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new GoalHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(GoalHolder holder, int position) {
            Goal goal = mGoals.get(position);
            holder.bind(goal);
        }

        @Override
        public int getItemCount() {
            return mGoals.size();
        }

        public void setGoals(List<Goal> goals) {
            mGoals = goals;
        }
    }
}
