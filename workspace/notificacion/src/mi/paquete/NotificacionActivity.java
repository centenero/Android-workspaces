package mi.paquete;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NotificacionActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
      //Obtenemos una referencia al servicio de notificaciones
      String ns = Context.NOTIFICATION_SERVICE;
      NotificationManager notManager =
          (NotificationManager) getSystemService(ns);
      System.out.println("Canonical: " + NotificationManager.class.getCanonicalName());
      
    //Configuramos la notificación
      int icono = android.R.drawable.stat_sys_warning;
      CharSequence textoEstado = "Alerta!";
      long hora = System.currentTimeMillis();
       
      Notification notif =
          new Notification(icono, textoEstado, hora);
      
        
      
      //Configuramos el Intent
        Context contexto = getApplicationContext();
        CharSequence titulo = "Mensaje de Alerta";
        CharSequence descripcion = "Ejemplo de notificación.";
         
        Intent notIntent = new Intent(contexto,
        		NotificacionActivity.class);
         
        PendingIntent contIntent = PendingIntent.getActivity(
            contexto, 0, notIntent, 0);
         
        notif.setLatestEventInfo(
            contexto, titulo, descripcion, contIntent);

       System.out.println("PASO");
        
    }
}