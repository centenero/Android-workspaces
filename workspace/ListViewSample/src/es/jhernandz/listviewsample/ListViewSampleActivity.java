package es.jhernandz.listviewsample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ListView lv = (ListView)findViewById(R.id.listView);
        ArrayList<ItemCompra> itemsCompra = obtenerItems();
        ItemCompraAdapter adapter = new ItemCompraAdapter(this, itemsCompra);
        lv.setAdapter(adapter);
        
    }
    
    private ArrayList<ItemCompra> obtenerItems() {
    	ArrayList<ItemCompra> items = new ArrayList<ItemCompra>();
    	
    	items.add(new ItemCompra(1, "Patatas", "Tuberculo", "drawable/patatas"));
    	System.out.println("Añadido Patata");
    	//items.add(new ItemCompra(2, "Naranja", "Fruta", "drawable/naranjas"));
    	//items.add(new ItemCompra(1, "Lechuga", "Verdura", "drawable/lechuga"));
    	
    	return items;
    }
}