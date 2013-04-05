package androidya.buscaminas;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BuscaMinasActivity extends Activity implements OnTouchListener {

	private Tablero fondo;
	int x,y;
	private Casilla[][] casillas;
	private boolean activo=true;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);        

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);	
		
		LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout1);				
		fondo=new Tablero(this);
		fondo.setOnTouchListener(this);
		layout.addView(fondo);
		casillas=new Casilla[8][8];
		for(int f=0;f<8;f++) {
			for(int c=0;c<8;c++) {
				casillas[f][c]=new Casilla();
			}
		}	
		this.disponerBombas();
		this.contarBombasPerimetro();
	}
	
	public void presionado(View v) {
		casillas=new Casilla[8][8];		
		for(int f=0;f<8;f++) {
			for(int c=0;c<8;c++) {
				casillas[f][c]=new Casilla();
			}
		}			
		this.disponerBombas();
		this.contarBombasPerimetro();
		activo=true;		

		fondo.invalidate();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (activo)
			for(int f=0;f<8;f++) {
				for(int c=0;c<8;c++) {
					if (casillas[f][c].dentro((int)event.getX(),(int)event.getY()))
					{
						casillas[f][c].destapado=true;
						if (casillas[f][c].contenido==80)
						{
							Toast.makeText(this,"Booooooooommmmmmmmmmmm", Toast.LENGTH_LONG).show();
							activo=false;
						}
						else
							if (casillas[f][c].contenido==0)
								recorrer (f, c);
						fondo.invalidate();
					}
				}
			}
		if (gano()  && activo)
		{
			Toast.makeText(this,"Ganaste", Toast.LENGTH_LONG).show();
			activo=false;
		}
		

		return true;
	}    



	private void disponerBombas ()
	{
		int cantidad = 8;
		do
		{
			int fila = (int) (Math.random () * 8);
			int columna = (int) (Math.random () * 8);
			if (casillas[fila] [columna].contenido == 0)
			{
				casillas [fila] [columna].contenido=80;
				cantidad--;
			}
		}
		while (cantidad != 0);
	}

	private boolean gano()
	{
		int cant=0;
		for (int f = 0 ; f < 8 ; f++)
			for (int c = 0 ; c < 8 ; c++)
				if (casillas [f] [c].destapado)
					cant++;
		if (cant==56)
			return true;
		else
			return false;
	}

	private void contarBombasPerimetro ()
	{
		for (int f = 0 ; f < 8 ; f++)
		{
			for (int c = 0 ; c < 8 ; c++)
			{
				if (Casilla [f] [c].contenido==0)
				{
					int cant = contarCoordenada (f, c);
					casillas [f] [c].contenido=cant;
				}
			}
		}
	}

	int contarCoordenada (int fila, int columna)
	{
		int total = 0;
		if (fila - 1 >= 0 && columna - 1 >= 0)
		{
			if (casillas [fila - 1] [columna - 1].contenido == 80)
				total++;
		}
		if (fila - 1 >= 0)
		{
			if (casillas [fila - 1] [columna].contenido == 80)
				total++;
		}
		if (fila - 1 >= 0 && columna + 1 < 8)
		{
			if (casillas [fila - 1] [columna + 1].contenido == 80)
				total++;
		}

		if (columna + 1 < 8)
		{
			if (casillas [fila] [columna + 1].contenido == 80)
				total++;
		}
		if (fila + 1 < 8 && columna + 1 < 8)
		{
			if (casillas [fila + 1] [columna + 1].contenido == 80)
				total++;
		}

		if (fila + 1 < 8)
		{
			if (casillas [fila + 1] [columna].contenido == 80)
				total++;
		}
		if (fila + 1 < 8 && columna - 1 >= 0)
		{
			if (casillas [fila + 1] [columna - 1].contenido == 80)
				total++;
		}
		if (columna - 1 >= 0)
		{
			if (casillas [fila] [columna - 1].contenido == 80)
				total++;
		}
		return total;
	}

	
	 private void recorrer (int fil, int col)
	    {
	        if (fil >= 0 && fil < 8 && col >= 0 && col < 8)
	        {
	            if (casillas [fil] [col].contenido==0)
	            {
	                casillas [fil] [col].destapado=true;
	                casillas [fil] [col].contenido=50;
	                recorrer (fil, col + 1);
	                recorrer (fil, col - 1);
	                recorrer (fil + 1, col);
	                recorrer (fil - 1, col);
	                recorrer (fil - 1, col - 1);
	                recorrer (fil - 1, col + 1);
	                recorrer (fil + 1, col + 1);
	                recorrer (fil + 1, col - 1);
	            }
	            else
	                if (casillas [fil] [col].contenido>=1 &&  casillas [fil][col].contenido<=8)
	                {
	                	casillas [fil] [col].destapado=true;
	                }
	        }
	    }	
}