package com.example.alarma;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OnAlarmReceiver extends BroadcastReceiver {
	
    public void onReceive(Context context, Intent intent) {
         Toast.makeText(context, "La Alarma est� sonando", Toast.LENGTH_LONG).show();
         //Avisar mediante Vibraci�n o sonido.
         
    }
 }