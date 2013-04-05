package juego.party;

import java.util.ArrayList;
import java.util.Date;

import juego.party.R.id;
import BaseDeDatos.BaseDeDatos;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InsertarDatos_Activity  extends Activity {
	private Spinner spinner1;
	private Spinner spinner2;
	private Spinner spinner3;
	private Spinner spinner4;
	//private Spinner spinner5;
	private SQLiteDatabase db;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datos);
		System.out.println(" Inicio InsertarDAtos Activirty");
		
		
		 BaseDeDatos alumnosBBDD = new BaseDeDatos(this, "dbCuestionario", null, 1);
		 db = alumnosBBDD.getWritableDatabase();
		 
		 Date horaActual = new Date();
		 String hora = horaActual.toString();
		 int i = 0;
		 while (i < 100){
		 ContentValues registro=new ContentValues();
		 registro.put("pregunta","AAAAAAAAAAA" );
//		 registro.put("categoria","ZZZZZZZZZ" );
//		 registro.put("fechaCreacion", hora);
//		 db.insert("preguntalarga", null, registro);
//		 
		 ContentValues registro1=new ContentValues();
		 registro1.put("pregunta","AAAAA"+ i  );
		 registro1.put("categoria","ZZZZZZZZZ" );
//		 
		 db.insert("pregunta", null, registro1);
//		 
		 i++;
		 }
		 System.out.println("Obtener ArrayList");
		 ArrayList<Pregunta> miArray = this.GetPreguntas();
		 System.out.println("Obtener ArrayList2");
		 int x =0;
		 System.out.println("#idMovil########## Pregunta ####### Respuesta ######");
		 while (x < miArray.size()){
			 System.out.println("#"+ miArray.get(x).getId() + "##########" + miArray.get(x).getPregunta() + "#######" + miArray.get(x).getRespuesta() + "######");
			 
			 x++;
		 }
		 
		// Spinner Categoria.
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		// Spinner Tipo de respuesta.
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		// Spinner Numero de respuestas.
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		// Spinner Respuesta Booleana
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		// Spinner Respuesta Booleana
	//	spinner5 = (Spinner) findViewById(R.id.Spinner5);

		String []opciones = new String[6];
		opciones[0]="Mimica";
		opciones[1]="Tararear";
		opciones[2]="Dibujar";
		opciones[3]="Imitar";
		opciones[4]="Adivina lo que piensa";
		opciones[5]="¡Sorpresa!";

		String []tipoRespuesta = new String[3];
		tipoRespuesta[0]="Verdadero o Falso";
		tipoRespuesta[1]="Si o No";
		tipoRespuesta[2]="Varias Opciones";

		String[] numeroRespuesta = new String[3];
		numeroRespuesta[0]="2";
		numeroRespuesta[1]="3";
		numeroRespuesta[2]="4";

		String[] Resp_Boolean = new String[2];
		Resp_Boolean[0]="Verdadero o Sí.";
		Resp_Boolean[1]="Falso o No.";


		// SETEAMOS LOS LAYOUT.
		View layoutMimica = findViewById(R.id.linearLayoutMimica);
		View layoutPregunta = findViewById(R.id.linearLayoutPregunta);
		View layout_V_F_S_N = findViewById(R.id.linearLayout_V_F_S_N);
		View layoutNOpciones = findViewById(R.id.linearLayoutNOpciones);

		layoutMimica.setVisibility(LinearLayout.GONE);
		layoutPregunta.setVisibility(LinearLayout.GONE);
		layout_V_F_S_N.setVisibility(LinearLayout.GONE);
		layoutNOpciones.setVisibility(LinearLayout.GONE);




		/*********************************************
		 * Creacion del Spinner de CATEGORIAS
		 * 
		 ********************************************/


		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
		spinner1.setAdapter(adapter);


		//        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		//                this, R.string.Elige_categoria, android.R.layout.simple_spinner_item);
		//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//        spinner.setAdapter(adapter);
		//Aviso a la clase MyOnItemSelectedListener para que muestre un mensaje.

		spinner1.setOnItemSelectedListener(new onItemSelected(){
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				//        			The parameters of the OnItemClick method are:
				//        			• Arg0:the Spinner, notice that it is of type AdapterView.
				//        			• Arg1: the view that represents the selected item, in this example it will be a TextView
				//        			• Arg2: the position of the selected item.
				//        			• Arg3: the id of the selected item.
				//
				TextView txt=(TextView)findViewById(R.id.textoExplicativo);
				System.out.println("VALOR DE ARG0 " + arg0);
				System.out.println("VALOR DE ARG1 " + arg1);
				System.out.println("VALOR DE ARG2 " + arg2);

				View layoutMimica = findViewById(R.id.linearLayoutMimica);
				View layoutPregunta = findViewById(R.id.linearLayoutPregunta);
				View layout_V_F_S_N = findViewById(R.id.linearLayout_V_F_S_N);
				View layoutNOpciones = findViewById(R.id.linearLayoutNOpciones);
				
				


				switch(arg2) {
				case 0: 
					//  opciones[0]="Mimica";
					System.out.println("Seleccionado MIMICAR");
					txt.setText("HOLA ESTOY DENTRO DE MIMICAR");
					txt.setText(R.string.Descripcion_mimica);


					layoutMimica.setVisibility(LinearLayout.VISIBLE);
					layoutPregunta.setVisibility(LinearLayout.GONE);
					layout_V_F_S_N.setVisibility(LinearLayout.GONE);
					layoutNOpciones.setVisibility(LinearLayout.GONE);

					break;
				case 1: 
					//    				        opciones[1]="Tararear";
					System.out.println("Seleccionado TARAREAR");
					txt.setText("HOLA ESTOY DENTRO DE TARAREAR");
					txt.setText(R.string.Descripcion_Tararear);

					layoutMimica.setVisibility(LinearLayout.VISIBLE);
					layoutPregunta.setVisibility(LinearLayout.GONE);
					layout_V_F_S_N.setVisibility(LinearLayout.GONE);
					layoutNOpciones.setVisibility(LinearLayout.GONE);
					break;
				case 2: 
					//    				        opciones[2]="Dibujar";
					System.out.println("Seleccionado DIBUJAR");
					txt.setText(R.string.Descripcion_Dibujar);

					layoutMimica.setVisibility(LinearLayout.VISIBLE);
					layoutPregunta.setVisibility(LinearLayout.GONE);
					layout_V_F_S_N.setVisibility(LinearLayout.GONE);
					layoutNOpciones.setVisibility(LinearLayout.GONE);
					break;
				case 3: 
					//    				        opciones[3]="Imitar";
					System.out.println("Seleccionado IMITAR");
					txt.setText(R.string.Descripcion_Imitar);

					layoutMimica.setVisibility(LinearLayout.VISIBLE);
					layoutPregunta.setVisibility(LinearLayout.GONE);
					layout_V_F_S_N.setVisibility(LinearLayout.GONE);
					layoutNOpciones.setVisibility(LinearLayout.GONE);
					break;
				case 4: 
					//    				        opciones[4]="Adivina lo que piensa";
					System.out.println("Seleccionado ADIVINA LO QUE PIENSA");
					txt.setText(R.string.Descripcion_Adivina);
					layoutMimica.setVisibility(LinearLayout.GONE);
					layoutPregunta.setVisibility(LinearLayout.VISIBLE);
					layout_V_F_S_N.setVisibility(LinearLayout.VISIBLE);
					layoutNOpciones.setVisibility(LinearLayout.VISIBLE);
					break;
				case 5: 
					//TODO: FALTA PONER el txt.setTetx
					//opciones[5]="¡SORPRESA!";
					System.out.println("Seleccionado ¡Sorpresa!");
					txt.setText(R.string.Descripcion_Adivina);
					layoutMimica.setVisibility(LinearLayout.GONE);
					layoutPregunta.setVisibility(LinearLayout.VISIBLE);
					layout_V_F_S_N.setVisibility(LinearLayout.VISIBLE);
					layoutNOpciones.setVisibility(LinearLayout.VISIBLE);
					break;  
				} // Fin del CASE


			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		/*********************************************
		 * Creacion del Spinner de TIPO DE RESPUESTA.
		 * 
		 ********************************************/

		System.out.println(" Creando adapter2");
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tipoRespuesta);
		spinner2.setAdapter(adapter2);
		System.out.println(" Creando SPINNER2");
		spinner2.setOnItemSelectedListener(new onItemSelected(){
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				//        			The parameters of the OnItemClick method are:
				//        			• Arg0:the Spinner, notice that it is of type AdapterView.
				//        			• Arg1: the view that represents the selected item, in this example it will be a TextView
				//        			• Arg2: the position of the selected item.
				//        			• Arg3: the id of the selected item.
				//
				//TextView txt=(TextView)findViewById(R.id.textoExplicativo);
				System.out.println("VALOR DE ARG0 " + arg0);
				System.out.println("VALOR DE ARG1 " + arg1);
				System.out.println("VALOR DE ARG2 " + arg2);
				View layoutOpciones = findViewById(R.id.linearLayoutNOpciones);
				View layoutV_F_S_N = findViewById(R.id.linearLayout_V_F_S_N);
				View layoutNOpciones = findViewById(R.id.linearLayoutNOpciones);

				switch(arg2) {
				case 0: 
					//   tipoRespuesta[0]="V_F";
					System.out.println("Seleccionado Verdadero o Faslso");
					layoutOpciones.setVisibility(LinearLayout.GONE);
					layoutNOpciones.setVisibility(LinearLayout.GONE);
					layoutV_F_S_N.setVisibility(LinearLayout.VISIBLE);


					break;
				case 1: 
					//    				        tipoRespuesta[1]="S_N";
					System.out.println("Seleccionado Si o No");
					layoutOpciones.setVisibility(LinearLayout.GONE);
					layoutNOpciones.setVisibility(LinearLayout.GONE);
					layoutV_F_S_N.setVisibility(LinearLayout.VISIBLE);


					break;
				case 2: 
					// tipoRespuesta[2]="Varias Opciones";
					System.out.println("Seleccionado Varias Opciones");
					layoutOpciones.setVisibility(LinearLayout.VISIBLE);
					layoutNOpciones.setVisibility(LinearLayout.VISIBLE);
					layoutV_F_S_N.setVisibility(LinearLayout.GONE);


					break;
				} // Fin del CASE


			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		/*********************************************
		 * Creacion del Spinner de NUMERO DE RESPUESTAS 
		 * 
		 ********************************************/
		System.out.println(" Creando adapter3");
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, numeroRespuesta);
		spinner3.setAdapter(adapter3);
		System.out.println(" Creando SPINNER3");


		//        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		//                this, R.string.Elige_categoria, android.R.layout.simple_spinner_item);
		//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//        spinner.setAdapter(adapter);
		//Aviso a la clase MyOnItemSelectedListener para que muestre un mensaje.

		spinner3.setOnItemSelectedListener(new onItemSelected(){
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				//        			The parameters of the OnItemClick method are:
				//        			• Arg0:the Spinner, notice that it is of type AdapterView.
				//        			• Arg1: the view that represents the selected item, in this example it will be a TextView
				//        			• Arg2: the position of the selected item.
				//        			• Arg3: the id of the selected item.
				//
				//TextView txt=(TextView)findViewById(R.id.textoExplicativo);
				System.out.println("VALOR DE ARG0 " + arg0);
				System.out.println("VALOR DE ARG1 " + arg1);
				System.out.println("VALOR DE ARG2 " + arg2);
				//Obtengo los linear layout para darle visibilidad.
				View A = findViewById(R.id.linearLayoutOpcionA);
				View B = findViewById(R.id.linearLayoutOpcionB);
				View C = findViewById(R.id.linearLayoutOpcionC);
				View D = findViewById(R.id.linearLayoutOpcionD);

				switch(arg2) {
				case 0: 
					// 
					System.out.println("Seleccionado 2 respuestas");
					A.setVisibility(LinearLayout.VISIBLE);
					B.setVisibility(LinearLayout.VISIBLE);
					C.setVisibility(LinearLayout.GONE);
					D.setVisibility(LinearLayout.GONE);
					break;
				case 1: 

					System.out.println("Seleccionado 3 respuestas");
					A.setVisibility(LinearLayout.VISIBLE);
					B.setVisibility(LinearLayout.VISIBLE);
					C.setVisibility(LinearLayout.VISIBLE);
					D.setVisibility(LinearLayout.GONE);

					break;
				case 2: 
					//    				        opciones[2]="Dibujar";
					System.out.println("Seleccionado 4 respuestas");
					A.setVisibility(LinearLayout.VISIBLE);
					B.setVisibility(LinearLayout.VISIBLE);
					C.setVisibility(LinearLayout.VISIBLE);
					D.setVisibility(LinearLayout.VISIBLE);
					break;
				} // Fin del CASE


			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		/*********************************************
		 * Creacion del Spinner de RESPUSETA BOOLEANA.
		 * 
		 ********************************************/
		System.out.println(" Creando adapter4");
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Resp_Boolean);
		spinner4.setAdapter(adapter4);
		System.out.println(" Creando SPINNER4");


		//        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		//                this, R.string.Elige_categoria, android.R.layout.simple_spinner_item);
		//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//        spinner.setAdapter(adapter);
		//Aviso a la clase MyOnItemSelectedListener para que muestre un mensaje.

		spinner4.setOnItemSelectedListener(new onItemSelected(){
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				//        			The parameters of the OnItemClick method are:
				//        			• Arg0:the Spinner, notice that it is of type AdapterView.
				//        			• Arg1: the view that represents the selected item, in this example it will be a TextView
				//        			• Arg2: the position of the selected item.
				//        			• Arg3: the id of the selected item.
				//
				//TextView txt=(TextView)findViewById(R.id.textoExplicativo);
				System.out.println("VALOR DE ARG0 " + arg0);
				System.out.println("VALOR DE ARG1 " + arg1);
				System.out.println("VALOR DE ARG2 " + arg2);



				switch(arg2) {
				case 0: 
					// 
					System.out.println("Seleccionado respuestas Verdadero o Si.");

					break;
				case 1: 

					System.out.println("Seleccionado  respuestas Fala o No");


					break;

				} // Fin del CASE


			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
		/******* BOTON SALIR *************/
		Button buttonSalir = (Button)this.findViewById(R.id.buttonSalir);
		buttonSalir.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//finish();
				System.out.println ("Volvemos a la pantalla Anterior.");
				Intent intent = new Intent(getApplicationContext(), A_Inicio.class);
				startActivity(intent);

			}
		});
		/******* FIN BOTON SALIR *************/

		/******* BOTON INSERTAR *************/
		Button buttonInsertar = (Button)this.findViewById(R.id.button_Insertar);
		buttonInsertar.setOnClickListener(new View.OnClickListener() {
			private EditText pregunta;
			
			public void onClick(View v) {
				/*
				 * Analisis de casos.
				 *  1- Comprobar el tipo de respuesta.
				 *  	- Si es booleano.
				 *  	- Si es varias opciones.
				 *  		- Numero de opciones.
				 */
				String selecCategoria=spinner1.getSelectedItem().toString();
				//				opciones[0]="Mimica";
				//				opciones[1]="Tararear";
				//				opciones[2]="Dibujar";
				//				opciones[3]="Imitar";
				//				opciones[4]="Adivina lo que piensa";
				//				opciones[5]="¡Sorpresa!";
			
			if (selecCategoria.equals("Mimica") || selecCategoria.equals("Tararear") ||
					selecCategoria.equals("Imitar") || selecCategoria.equals("Mimica")){
				//Solo tenemos que obtener del usuario un texto. y lo insertarmos en la base de datos.
				
				pregunta = (EditText) findViewById(id.caja_pregunta);
				String selecTipoCategoria =spinner2.getSelectedItem().toString();
								
				 ContentValues registro=new ContentValues();
				 registro.put("pregunta","ZZZZZ2" );
				 registro.put("tipopregunta","nombre" );
				 registro.put("nopciones","colegio" );
				 registro.put("opcion1","nromesa" );
				 registro.put("opcion2","nromesaw" );
				 registro.put("opcion3","nromesa3" );
				 registro.put("opcion4","nromesa4" );
				 registro.put("opcioncorrecta","nromesa" );
				 registro.put("categoria","molona" );
				 db.insert("preguntalarga", null, registro);
				 db.close();

			}
			if (selecCategoria.equals("Adivina lo que piensa") || selecCategoria.equals("¡Sorpresa!")){
				 ContentValues registro=new ContentValues();
				 registro.put("pregunta","ZZZZZ2" );
				 registro.put("tipopregunta","nombre" );
				 registro.put("nopciones","colegio" );
				 registro.put("opcion1","nromesa" );
				 registro.put("opcion2","nromesaw" );
				 registro.put("opcion3","nromesa3" );
				 registro.put("opcion4","nromesa4" );
				 registro.put("opcioncorrecta","nromesa" );
				 registro.put("categoria","molona" );
				 db.insert("preguntalarga", null, registro);
				 db.close();
				 
				 Toast toast = Toast.makeText(null, "Pregunta Insertada2", Toast.LENGTH_SHORT);
				 toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				 toast.show();
				
			}

//			String selecTipoCategoria=spinner2.getSelectedItem().toString();
//			String selecNumRespeusta=spinner3.getSelectedItem().toString();
//			String selecRespuestaBoolean=spinner4.getSelectedItem().toString();

		}
			});
			/******* FIN BOTON SALIR *************/

		

		}
	private ArrayList<Pregunta> GetPreguntas() {
		ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
		 
		System.out.println("Creacion del cursos");
	    Cursor c = db.query("pregunta",
	            new String[] {"idmovil", "pregunta", "categoria"},
	            null, null, null, null, null);
	 
	    //Iteramos a traves de los registros del cursor
	    System.out.println("Me situo en el primer elemento");
	    c.moveToFirst();
	     while (c.isAfterLast() == false) {
	    	 System.out.println("Doy una vuelta");
	    	 Pregunta pregunta = new Pregunta(c.getInt(0), c.getString(1), c.getString(2));
	       // libro.setTitulo(c.getString(1));
	       // libro.setAutor(c.getString(2));
	       // listaLibros.add(libro);
	    	 listaPreguntas.add(pregunta);
	    	 
	       c.moveToNext();
	     }
	     c.close();
	 
	     return listaPreguntas;
		
	}
	

	}


