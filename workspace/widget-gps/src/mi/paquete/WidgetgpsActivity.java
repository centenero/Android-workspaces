package mi.paquete;

import android.app.Activity;
import android.os.Bundle;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.RemoteViews;

public class WidgetgpsActivity extends AppWidgetProvider {
    
    private static LocationManager lm;
    private static LocationListener locationListener;
    private static String latitud;
    private static String longitud;
    
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
            int[] appWidgetIds) {
        context.startService(new Intent(context, UpdateService.class));
    }
    
    public static class UpdateService extends Service {
        @Override
        public void onStart(Intent intent, int startId) {
            // La vista de nuestro Widget
            RemoteViews updateViews = buildUpdate(this);
            // Todo lo necesario para acceder al GPS
            lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationListener = new MyLocationListener();
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
                    locationListener);
            
            // Hacemos que nuestro widget sea accesible desde el menu del escritorio
            ComponentName thisWidget = new ComponentName(this, WidgetgpsActivity.class);
            AppWidgetManager manager = AppWidgetManager.getInstance(this);
            manager.updateAppWidget(thisWidget, updateViews);
        }

        public RemoteViews buildUpdate(Context context) {
            // Asignamos un layout a nuestra vista y lo actualizamos.
            RemoteViews updateViews = null;
            updateViews = new RemoteViews(context.getPackageName(), R.layout.widget_pantalla);
            updateViews.setTextViewText(R.id.latitud,  latitud);
            updateViews.setTextViewText(R.id.longitud, longitud);

            return updateViews;
        }
        
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
        
        // Esta es la clase que usamos para obtener las coordenadas del GPS
        public class MyLocationListener implements LocationListener {

            public void onLocationChanged(Location location) {
                Double lat = redondear(location.getLatitude(),5);
                latitud = lat.toString();
                Double longi = redondear(location.getLongitude(),5);
                longitud = longi.toString();
            }

            public void onProviderDisabled(String provider) {
                // TODO Auto-generated method stub
                
            }

            public void onProviderEnabled(String provider) {
                // TODO Auto-generated method stub
                
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                // TODO Auto-generated method stub
                
            }
            
            public double redondear(double numero, int decimales ) {
                return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
            }



        }
    }
    
}