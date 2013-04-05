package com.example.alarma;

import com.exercise.AndroidAlarmService.AndroidAlarmService;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent = new Intent(this, OnAlarmReceiver.class);
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE, intent, 1);
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 1);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 1);
        pendingIntent = PendingIntent.getService(AndroidAlarmService.this, 0, myIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (5 * 1000),pendingIntent);
        
//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        
//        Intent intent = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, REQUEST_CODE, intent, 0);
//
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (5 * 1000), sender);
//        Toast.makeText(this, "Alarm set", Toast.LENGTH_LONG).show();
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
