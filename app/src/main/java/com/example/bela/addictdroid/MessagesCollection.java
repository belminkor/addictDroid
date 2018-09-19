package com.example.bela.addictdroid;

import java.util.ArrayList;
import java.util.Random;

public class MessagesCollection {
    ArrayList<MotivationalMessage> messages;

    public MessagesCollection() {
        messages = new ArrayList<MotivationalMessage>();
        messages.add(new MotivationalMessage("I avoid looking forward or backward, and try to keep looking upward.",
                " – Charlotte Brontë"));
        messages.add(new MotivationalMessage("Success is the sum of small efforts, repeated day in and day out.",
                " – Robert Collier"));
        messages.add(new MotivationalMessage("People often say that motivation doesn’t last. Neither does bathing. That’s why we recommend it daily.",
                " – Zig Ziglar"));
        messages.add(new MotivationalMessage("“If we are facing in the right direction, all we have to do is keep on walking.”",
                " – Zen proverb"));
        messages.add(new MotivationalMessage(" “Though no one can go back and make a brand new start, anyone can start from now and make a brand new ending.”",
                " – Carl Bard"));
        messages.add(new MotivationalMessage("“It is by going down into the abyss that we recover the treasures of life. Where you stumble, there lies your treasure.”",
                " – Joseph Campbell"));
        messages.add(new MotivationalMessage("“Sometimes we motivate ourselves by thinking of what we want to become. Sometimes we motivate ourselves by thinking about who we don’t ever want to be again.”",
                "– Shane Niemeyer"));
        messages.add(new MotivationalMessage("People often say that motivation doesn’t last. Neither does bathing. That’s why we recommend it daily.",
                " – Zig Ziglar"));
        messages.add(new MotivationalMessage("Push yourself again and again. Don't give an inch until the final buzzer sounds.",
                " – Larry Bird"));
        messages.add(new MotivationalMessage("If you quit once it becomes a habit. Never quit!",
                " – Michael Jordan"));
        messages.add(new MotivationalMessage("Never let it rest until your good is better and your better is best.",
                " – Tim Duncan"));
        messages.add(new MotivationalMessage("If you're afraid to fail, then probably you're going to fail.",
                " – Kobe Bryant"));
        messages.add(new MotivationalMessage("Believe you can and you’re halfway there.",
                " – Theodore Roosevelt"));
        messages.add(new MotivationalMessage("Success is the sum of small efforts, repeated day in and day out.",
                " – Robert Collier"));
        messages.add(new MotivationalMessage("It always seems impossible until it’s done.",
                " – Nelson Mandela"));
        messages.add(new MotivationalMessage("Life is like riding a bicycle. To keep your balance you must keep moving.",
                " – Albert Einstein"));
        messages.add(new MotivationalMessage("Fall seven times, stand up eight.",
                " – Japanese proverb"));
        messages.add(new MotivationalMessage("The best way out is always through.",
                " – Robert Frost"));
    }

    public MotivationalMessage generateRandomMessage() {
        Random rand = new Random();
        int position = rand.nextInt(messages.size()-1);

        return messages.get(position);
    }
}
