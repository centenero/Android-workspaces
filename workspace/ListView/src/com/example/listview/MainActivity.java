package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        private Titular[] datos =
//            new Titular[]{
//                new Titular("T�tulo 1", "Subt�tulo largo 1"),
//                new Titular("T�tulo 2", "Subt�tulo largo 2"),
//                new Titular("T�tulo 3", "Subt�tulo largo 3"),
//                new Titular("T�tulo 4", "Subt�tulo largo 4"),
//                new Titular("T�tulo 5", "Subt�tulo largo 5")};
        final String[] datos =
            new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
         
        ArrayAdapter<String> adaptador =
            new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, datos);
         
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
         
        lstOpciones.setAdapter(adaptador);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
