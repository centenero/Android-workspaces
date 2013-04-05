package BaseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public class BaseDeDatos extends SQLiteOpenHelper {
	private String sqlCreate2 = "CREATE TABLE pregunta (" +
			"idmovil INTEGER PRIMARY KEY AUTOINCREMENT," +
			"pregunta TEXT, " +
			"categoria TEXT );";
	
	private String sqlCreate = "CREATE TABLE preguntalarga (" +
			"idmovil INTEGER PRIMARY KEY AUTOINCREMENT," +
			"pregunta TEXT, " +
			"tipopregunta TEXT," +
			"nopciones INTEGER," +
			"opcion1 TEXT," +
			"opcion2 TEXT," +
			"opcion3 TEXT," +
			"opcion4 TEXT," +
			"opcioncorrecta TEXT," +
			"fechaCreacion TEXT," +
			"categoria TEXT );";

	//Constructor BaseDeDatos
	public BaseDeDatos(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	public String obtenerPregunta (){

		String valor ="¿Quien gano el Mundial?";
		return valor;
	}

	public String obtenerRespuesta(){

		String valor ="España";
		return valor;
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlCreate);
		db.execSQL(sqlCreate2);
		

	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}


}
