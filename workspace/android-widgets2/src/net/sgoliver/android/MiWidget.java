package net.sgoliver.android;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

public class MiWidget extends AppWidgetProvider {
	@Override
	public void onUpdate(Context context, 
			             AppWidgetManager appWidgetManager, 
			             int[] appWidgetIds) {
		
		//Iteramos la lista de widgets en ejecución
		for (int i = 0; i < appWidgetIds.length; i++) 
		{
			//ID del widget actual
			int widgetId = appWidgetIds[i];

			//Actualizamos el widget actual
			actualizarWidget(context, appWidgetManager, widgetId);
		}
	}
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds)
	{
		//Accedemos a las preferencias de la aplicación
		SharedPreferences prefs = 
			context.getSharedPreferences("WidgetPrefs", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		
		//Eliminamos las preferencias de los widgets borrados
		for(int i=0; i<appWidgetIds.length; i++)
		{
			//ID del widget actual
			int widgetId = appWidgetIds[i];
			
			editor.remove("msg_" + widgetId);
		}
		
		//Aceptamos los cambios
		editor.commit();
		
		super.onDeleted(context, appWidgetIds);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		if (intent.getAction().equals("net.sgoliver.ACTUALIZAR_WIDGET")) {
			
//			//Obtenemos el widget manager y la lista de IDs de nuestro widget
//			ComponentName wgt = 
//				new ComponentName(context, MiWidget.class);
//			
//			AppWidgetManager widgetManager =
//				AppWidgetManager.getInstance(context);
//			
//			int[] appWidgetIds = widgetManager.getAppWidgetIds(wgt);
//			
//			//Actualizamos todos los widgets
//			for(int i=0; i<appWidgetIds.length; i++)
//				actualizarWidget(context, widgetManager, appWidgetIds[i]);
			
			//Obtenemos el ID del widget a actualizar
			int widgetId = intent.getIntExtra(
					AppWidgetManager.EXTRA_APPWIDGET_ID,
					AppWidgetManager.INVALID_APPWIDGET_ID);
			
			//Obtenemos el widget manager de nuestro contexto
			AppWidgetManager widgetManager =
				AppWidgetManager.getInstance(context);

			//Actualizamos el widget
			if (widgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
				actualizarWidget(context, widgetManager, widgetId);
			}
		}
		
		super.onReceive(context, intent);
	}
	
	public static void actualizarWidget(Context context, AppWidgetManager appWidgetManager, int widgetId)
	{
		//Recuperamos el mensaje personalizado para el widget actual
		SharedPreferences prefs = 
			context.getSharedPreferences("WidgetPrefs", Context.MODE_PRIVATE);
		String mensaje = prefs.getString("msg_" + widgetId, "Hora actual:");
		
		//Obtenemos la lista de controles del widget actual
		RemoteViews controles = 
			new RemoteViews(context.getPackageName(), R.layout.miwidget);
		
		//Asociamos los 'eventos' al widget
		Intent intent = new Intent("net.sgoliver.ACTUALIZAR_WIDGET");
		intent.putExtra(
			     AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
		PendingIntent pendingIntent = 
			PendingIntent.getBroadcast(context, widgetId, 
					intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		controles.setOnClickPendingIntent(R.id.BtnActualizar, pendingIntent);
		
		//Actualizamos el mensaje en el control del widget
		controles.setTextViewText(R.id.LblMsg, mensaje);
		
		//Obtenemos la hora actual
		Calendar calendario = new GregorianCalendar();
		String hora = calendario.getTime().toLocaleString();
		
		//Actualizamos la hora en el control del widget
		controles.setTextViewText(R.id.LblHora, hora);
		
		//Notificamos al manager de la actualización del widget actual
		appWidgetManager.updateAppWidget(widgetId, controles);
	}
}
