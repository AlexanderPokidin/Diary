package com.pokidin.a.diary.models;

import com.pokidin.a.diary.common.Record;
import com.pokidin.a.diary.contracts.RecordsListContract;

import java.util.ArrayList;
import java.util.List;

public class RecordsListModelImpl implements RecordsListContract.RecordsListModel {
    @Override
    public List<Record> loadRecords() {
        List<Record> mRecords = new ArrayList<>();
        mRecords.add(new Record("Some words!", "Many different words... and numbers... and user`s thoughts. You know what I mean bro"));
        mRecords.add(new Record("A Guided Tour inside a clean architecture code base", "Recently, I released an open-source sample project called MovieNight.\n" +
                "In the past couple of weeks, I got lots of questions regarding the application architecture, so I’ve decided to write this blog post. I’ll describe the different components at play and the relationships between them as well as talk about some of the architecture decisions I’ve made along the way."));
        mRecords.add(new Record("Getting Started with Coroutines on Android", "Threading on Android has been a hard problem since the start. From your first NetworkOnMainThreadException to a laggy RecyclerView, we’ve all had at least one threading issue in our apps."));
        mRecords.add(new Record("Travel Is No Cure for the Mind", "It’s just another day… and you’re just doing what you need to do."));
        mRecords.add(new Record("Security Best Practices: Symmetric Encryption with AES in Java and Android", "In this article I will bring you up to speed on the Advanced Encryption Standard (AES), common block modes, why you need padding and initialization vectors and how to protect your data against modification. Finally I will show you how to easily implement this with Java avoiding most security issues."));
        mRecords.add(new Record("Minimizing your Android app’s bootstrap and why it’s important", "Take a look at the icon above. That’s what you usually see when you open up most of the apps available for your Android powered devices. And usually these “Splash Screens” stay there for a noticeable amount of time depending on your device’s horsepower, connectivity quality and other not so obvious reasons. Do you like it? I hope not (because I certainly don’t like it). And neither do your users."));
        mRecords.add(new Record("Sharing code between local and instrumentation tests", "I would like to talk about sharing code between local and instrumentation test cases. We often use almost similar test data for them. It can be a factory which produces test data for us or predefined set of data. We usually split local and instrumentation test cases into different folders; it means that we should duplicate test data or factories for generating test data."));
        mRecords.add(new Record("The Coming Software Apocalypse", "A small group of programmers wants to change how we code — before catastrophe strikes."));
        mRecords.add(new Record("The ‘this’ keyword in JavaScript, demystified", "When I first started learning JavaScript, it took me some time to understand the this keyword in JavaScript and be able to quickly identify which object does the this keyword point to. I found that the hardest thing about understanding the this keyword is that you usually forget the different cases and situations that you have read about or watched people explain during one or more of the JavaScript courses or resources that you study from. After introducing the arrow functions in ES6, things got more confusing too because arrow functions deal with the this keyword in a different way. I wanted to write this article to state what I have learned and try to explain it in a way that could help anyone who is learning JavaScript and having difficulty understanding the this keyword as I did before."));
        mRecords.add(new Record("I never understood JavaScript closures", "As the title states, JavaScript closures have always been a bit of a mystery to me. I have read multiple articles, I have used closures in my work, sometimes I even used a closure without realizing I was using a closure."));
        mRecords.add(new Record("Kotlin vs Java: What to Choose for Android Development", "Not too long ago, Google unveiled Kotlin as the language of choice for developing apps on Android platform. This announcement has drawn the attention of some of the world’s leading brands and has propelled Kotlin as the new must use a programming language and its popularity has been growing ever since. This has led a lot of specialists to foresee the collapse of Java as we know it as far as mobile development is concerned. We dug a little deeper into the debate between Kotlin and Java so you can see how the two stack up."));
        mRecords.add(new Record("How to Lose an IT Job in 10 Minutes", "Recently I’ve been quite close to getting a job at one of the Big 5. I went through the screening process and the take-home assignment smoothly but I failed to pass one of the final stages, a set of one to one, or two to one, interviews"));
        mRecords.add(new Record("Animate all the things. Transitions in Android", "Hey, Android Developer. I would like to tell you something new about animations. Google finally made a statement with Material Design: animations are not only for iOS. Part of the new concept is Material motion."));
        mRecords.add(new Record("Styling internationalized text in Android", "In a previous article we talked about styling characters or paragraphs in Android using spans. But all the examples used were based on hard coded text, where we knew exactly at which indexes to apply the span. Most of the time, the text we work with comes from resources and is internationalized. So the text we need to style and its positioning within a sentence may change."));
        mRecords.add(new Record("Enabling SQLite FTS in Room 2.1", "I was so very fortunate to be able to attend the Android Dev Summit in Mountain View this week, where one announcement in particular caught my attention: the 2.1 release of the Room library supports full-text search (FTS), a feature I had been looking into for the Japanese-English dictionary app I’ve been working on."));
        mRecords.add(new Record("Drag and reorder RecyclerView items in a user friendly manner", "Even though they feel very basic actions, by-the-book Android coding lacks subtle user-friendliness in the experience. In the following short article, I will demonstrate how you can transform the by-the-book reorder implementation to a user friendly one with just small tweaks."));

        return mRecords;
    }


}
