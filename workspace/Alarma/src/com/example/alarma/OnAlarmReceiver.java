package com.example.alarma;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OnAlarmReceiver extends BroadcastReceiver {
	
    public void onReceive(Context context, Intent intent) {
         Toast.makeText(context, "La Alarma está sonando", Toast.LENGTH_LONG).show();
         //Avisar mediante Vibración o sonido.
         
    }
 }