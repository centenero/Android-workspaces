package com.example.tolkienlibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TolkienLibrary extends Activity {

	final public static String MyKey = "mikey";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Cargo la View que voy a mostrar.
		setContentView(R.layout.main);

		Button next = (Button) findViewById(R.id.Button02);
		//Configuro la acción que va a realizar el botón.
		next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				// Cargamos el Bundle con la coleccion de objetos que pasaremos
				// a la siguiente vista
				Bundle bundle = new Bundle();
				//Envio la variable MyKey a la siguiente vista.
				bundle.putString(MyKey,
						"Esto lo hemos enviado desde la vista principal.");

				// Creamos la vista de Lista de objetos y le pasamos la
				// colecci—n de objetos a mostrar
				Intent myIntent = new Intent(view.getContext(),
						ControladorLista.class);
				myIntent.putExtras(bundle);

				startActivityForResult(myIntent, 0);
			}

		});
	}
}