package mi.paquete;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView_Simple extends Activity {

	ListView lista;
	ArrayAdapter<String> adaptador;
	ArrayList<String> preguntas = new ArrayList<String>();
//	String[] datos = {"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "Proin", "et"};
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        lista = (ListView) findViewById(R.id.ListView01);
       
        String preguntas2 = "VACIO" ;
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
        	preguntas = extras.getStringArrayList("array");
        	preguntas2 = extras.getString("valor");
        }
        System.out.println("VALOR RECOGIDO : " + preguntas);
        System.out.println("VALOR RECOGIDO : " + preguntas.size());
        
        
        
        preguntas.add("HOLA");
        preguntas.add(preguntas2);
        System.out.println("VALOR RECOGIDO : " + preguntas);
        System.out.println("VALOR RECOGIDO : " + preguntas.size());
        // adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, preguntas);
 
        lista.setAdapter(adaptador);
        
        /**********************/
         
        } 
    }

