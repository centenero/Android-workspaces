package org.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AsteroidesActivity extends Activity {
	
	private Button bAcercaDe;
	private Button bConfiguracion;
	private Button bSalir;
	private Intent intento;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bAcercaDe = (Button) findViewById(R.id.button3);
        bConfiguracion = (Button) findViewById(R.id.button2);
        bSalir = (Button) findViewById(R.id.button4);
        
        bAcercaDe.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarAcercaDe();
			}
		});
        
        bConfiguracion.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarPreferencias();
			}
		});
        
        bSalir.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarSalida();
			}
		});
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	mostrarPreferencias();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflanter = getMenuInflater();
    	inflanter.inflate(R.menu.menu, menu);
    	return true;
    }
    
    public void lanzarAcercaDe(){
    	intento = new Intent(this, AcercaDe.class);
    	startActivity(intento);
    }
    
    public void lanzarPreferencias(){
    	this.intento = new Intent(this, Preferencias.class);
		startActivity(this.intento);
    }
    
    public void lanzarSalida(){
    	finish();
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch (item.getItemId()) {
		case R.id.config:
			this.intento = new Intent(this, Preferencias.class);
			startActivity(this.intento);
			break;

		default:
			break;
		}
    	return super.onOptionsItemSelected(item);
    }
    
    public void mostrarPreferencias(){
    	SharedPreferences pref = getSharedPreferences("org.example.asteroides_preferences",MODE_PRIVATE);
    	String s = "Musica: "+pref.getBoolean("musica",true)
    				+", Graficos: "+pref.getString("graficos", "?*");
    	Toast.makeText(this,s,Toast.LENGTH_LONG).show();    	
    }
}