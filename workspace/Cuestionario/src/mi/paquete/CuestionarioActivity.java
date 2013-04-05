package mi.paquete;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CuestionarioActivity extends Activity {
	
	private SQLiteDatabase db;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Creo la base de datos.
        DatabaseHelper usdbh = new DatabaseHelper(this, "DBUsuarios2", null, 1);
       
        db = usdbh.getWritableDatabase();
      //Elimino los datos que hay en la base de datos.
        eliminarContenidoTabla();
      //Insertamos 5 usuarios de ejemplo
        for(int i=1; i<=10; i++)
        {
            //Generamos los datos
            String nombre = "Pregunta " + i;
            //Insertamos los datos en la tabla Usuarios
            insertarPregunta(nombre, "respuesta", "categoria");
        }
        
/****************************************************
 * ACTIVIDAD PARA EL BOTON INSERTAR
****************************************************/
       Button bt_Insertar = (Button)this.findViewById(R.id.buttonInsertar);
       bt_Insertar.setOnClickListener(new View.OnClickListener() {
    	   
			public void onClick(View v) {
				System.out.println("Pulsado boton INSERTAR");
				
				String valor_pregunta = findViewById(R.id.editTextPregunta).toString();
				String valor_respuesta = findViewById(R.id.editTextRespuesta).toString();
				String valor_categoria = "categoria";
			//	insertarDatoBBDD(valor_pregunta, valor_respuesta);
				insertarPregunta(valor_pregunta, valor_respuesta, valor_categoria);
				
			}
		});
/****************************************************
* ACTIVIDAD PARA EL BOTON VER
****************************************************/
       Button bt_Ver = (Button)this.findViewById(R.id.buttonVer);
       bt_Ver.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				System.out.println("Pulsado boton VER");
				Intent intent = new Intent(CuestionarioActivity.this, ListView_Simple.class);
				Bundle bund = new Bundle(); //creamos el bundle 
				//Obtengo el Array List que voy a pasar al siguiente ACTIVITY. 
				 ArrayList<String>  valor =  getPreguntaCategoria("categoria");
				 bund.putStringArrayList("array", valor);
				 bund.putString("valor", "GOLA MUNDO");
				//lo añadimos al intent
				 intent.putExtras(bund); 
				//Lanzamos el activity
				startActivity(intent);
		}
		});
       
    }
    
/****************************************************
*METODO INSERTAR PREGUNTA
*****************************************************/
    private void insertarPregunta(String pregunta, String respuesta, String categoria){
    	//INSERT INTO Usuarios VALUES ('Los Angeles', '900', '10-Jan-1999')
        //Insertamos los datos en la tabla Usuario
        db.execSQL("INSERT INTO Usuarios (pregunta, respuesta, categoria) " +
                   "VALUES ('" + pregunta + "', '" + respuesta +"', '" + categoria + "')");
    }
/****************************************************
*METODO OBTENER PREGUNTA ORDENADO POR CATEGORIA.
*Obtener la tabla filtrado por Categoria
*****************************************************/
    private ArrayList<String>  getPreguntaCategoria(String categoria){
    	ArrayList<String> array = new ArrayList<String>();
    	String[] args = new String[] {categoria};
    	Cursor c = db.rawQuery(" SELECT pregunta,respuesta FROM Usuarios WHERE categoria=? ", args);
    	if (c.moveToFirst()) {
    	     //Recorremos el cursor hasta que no haya más registros
    		int i = 0;
    	     do {
    	          String pregunta = c.getString(0);
    	          String respuesta = c.getString(1);
    	          array.add(pregunta);
    	          array.add(respuesta);
    	          
    	          System.out.println(i + "Pregunta: " + pregunta + "Respuesta: "  + respuesta);
    	          i++;
    	     } while(c.moveToNext());
    	}
    return array;	
    }
    
/****************************************************
*METODO ELIMINACION CONTENIDO TABLA.
*Obtener la tabla filtrado por Categoria
*****************************************************/
private void eliminarContenidoTabla (){   	
   	//delete from nombretabla where 1
    db.execSQL("delete from Usuarios where 1");
    }
}
