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
//                new Titular("Título 1", "Subtítulo largo 1"),
//                new Titular("Título 2", "Subtítulo largo 2"),
//                new Titular("Título 3", "Subtítulo largo 3"),
//                new Titular("Título 4", "Subtítulo largo 4"),
//                new Titular("Título 5", "Subtítulo largo 5")};
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
