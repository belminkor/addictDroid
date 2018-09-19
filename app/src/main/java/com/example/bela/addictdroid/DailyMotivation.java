package com.example.bela.addictdroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyMotivation extends AppCompatActivity {

    TextView messageView;
    TextView author;
    MessagesCollection messagesCollection;
    ArrayList<MotivationalMessage> shownMessages;
    Button imGoodButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_motivation);

        messageView = (TextView) findViewById(R.id.message);
        author = (TextView) findViewById(R.id.author);

        messagesCollection = new MessagesCollection();
        shownMessages = new ArrayList<MotivationalMessage>();
        generateFirstMessage();
        final int counter = 0;

        imGoodButton = (Button) findViewById(R.id.imGood);
        imGoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        messageView.setOnTouchListener(new OnSwipeTouchListener(DailyMotivation.this) {

            public void onSwipeRight() {
                Animation toRight = AnimationUtils.loadAnimation(getContext(), R.anim.right_swipe);
                messageView.startAnimation(toRight);
                author.startAnimation(toRight);
                MotivationalMessage motivationalMessage = messagesCollection.generateRandomMessage();
                messageView.setText(motivationalMessage.getMessage());
                author.setText(motivationalMessage.getAuthor());
            }

            public void onSwipeLeft() {
                Animation toLeft = AnimationUtils.loadAnimation(getContext(), R.anim.left_swipe);
                author.startAnimation(toLeft);
                messageView.startAnimation(toLeft);
                MotivationalMessage motivationalMessage = messagesCollection.generateRandomMessage();
                messageView.setText(motivationalMessage.getMessage());
                author.setText(motivationalMessage.getAuthor());
            }


        });
    }

    private void generateFirstMessage(){
        MotivationalMessage motivationalMessage=messagesCollection.generateRandomMessage();
        messageView.setText(motivationalMessage.getMessage());
        author.setText(motivationalMessage.getAuthor());
        shownMessages.add(motivationalMessage);
    }

    public Context getContext() {
        return this;
    }

}
