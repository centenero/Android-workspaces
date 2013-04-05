package juego.party;

import java.util.ArrayList;

import juego.party.pintar.Draw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class A_Inicio  extends Activity {
	static int MAXDADO = 7;
	Boolean pararTiempo = false;
	int valor= 0;
	final Handler mHandler= new Handler();

	/******************HILO contador CUENTA ATRAS*****************/
	protected void miHilo(){ //1
		Thread t= new Thread(){ //2
			public void run(){//3

				System.out.println("ANTES DEL ENTRAR AL FOR");
				while (pararTiempo != true) { 
					try{//4
						mHandler.post(ejecutarAccion);
						System.out.println("Duermo 1 segundo");
						Thread.sleep(100); // 1000 = 1 segundo
					} // 4
					catch (InterruptedException e){ //5
						e.printStackTrace();
					}// 5
				} //fin del for 
			} //3
		};//2
		t.start();
	}//1

	final Runnable ejecutarAccion = new Runnable() { //1
		public void run(){ //2
			ImageView imagen = (ImageView) findViewById(R.id.imageView1);
			switch(valor) {
			case 0: 
				imagen.setImageResource(R.drawable.azul);
				break;
			case 1: 
				imagen.setImageResource(R.drawable.verde);
				break;
			case 2: 
				imagen.setImageResource(R.drawable.amarillo);
				break;
			case 3: 
				imagen.setImageResource(R.drawable.rojo);
				break;
			case 4: 
				imagen.setImageResource(R.drawable.blanco);
				break;
			case 5: 
				imagen.setImageResource(R.drawable.negro);
				break;
			} // Fin del CASE
			//Sumo uno a la variable y le hago el modulo.
			System.out.println ("VAlor de valor: " + valor);
			valor = (valor +1)%MAXDADO;


		} //2

	}; //1

	/*************FIN HILOS ********************/


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
 
		
		
		/******* BOTON SALIR *************/
		Button bt_salir = (Button)this.findViewById(R.id.bt_Salir);
		bt_salir.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				finish();

			}
		});
		/******* FIN BOTON SALIR *************/
		/****** IR A INSERATR ********/
		Button bt_Insertar = (Button) findViewById(R.id.bt_Insertar);
		bt_Insertar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), InsertarDatos_Activity.class);
				startActivity(intent);

			}
		});
		/****** FIN BOTON INSERTAR *********/
		/****** BOTON INICIAR TIEMPO ********/
		Button bt_Iniciar = (Button) findViewById(R.id.bt_Iniciar);
		bt_Iniciar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				pararTiempo = false;
				miHilo();
			}
		});
		/****** FIN BOTON INICIAR TIEMPO *********/
		/****** BOTON PARAR TIEMPO ********/
		Button bt_Parar = (Button) findViewById(R.id.bt_Parar);
		bt_Parar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				pararTiempo = true;

				//Compruebo el valor que se ha quedado y habilito el boton corresponiente o pantalla
				//HAY QUE HACERLo.
			}
		});

		/****** FIN BOTON PARAR TIEMPO *********/
		
		/****** BOTON dibujar ********/
		Button bt_dibujar = (Button) findViewById(R.id.bt_dibujar);
		bt_dibujar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("PULSADO BOTON DIBUJAR");
				Intent intent2 = new Intent(getApplicationContext(), Draw.class);
				startActivity(intent2);



			}
		});
		
		
		/****** FIN BOTON DIBUJAR *********/
		
		//        System.out.println ("Numero de telefono: " + this.getPhoneNumber());

	}

	
	//    private String getPhoneNumber(){
	//    	  TelephonyManager mTelephonyManager;
	//    	  mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE); 
	//    	  return mTelephonyManager.getLine1Number();
	//    	}
	//    
}
