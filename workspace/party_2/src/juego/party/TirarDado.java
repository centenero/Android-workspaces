package juego.party;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class TirarDado extends Activity {


	int contador =3; //Contador para la cuenta Atras.
	final Handler mHandler= new Handler();
	String pregunta = "¿Quien Descubrio America?.";
	String respuesta = "Cristobal Colon.";

	/******************HILO contador CUENTA ATRAS*****************/
	protected void miHilo(){ //1
		Thread t= new Thread(){ //2
			public void run(){//3

				System.out.println("ANTES DEL ENTRAR AL FOR");
				for (contador = 3; contador > -1; contador--) { 
					try{//4
						System.out.println("Duermo 1 segundo");
						mHandler.post(ejecutarAccion);
						Thread.sleep(1000);
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
			//			TextView tiempoRestanteTextView = (TextView) findViewById(R.id.textView_tiempo_restante);
			//	TextView boton = (TextView) findViewById(R.id.bt_tiempo);
			String texto = "Tiempo: " + contador;
			//boton.setText(texto);
			System.out.println(texto);
			//			tiempoRestanteTextView.setText(texto);
			//tiempoRestanteTextView.setBackgroundColor(#ffffffff);
			System.out.println("HOLA SOY UN HILO");

		} //2

	}; //1

	/*************FIN HILOS ********************/

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dado);

	}
}
