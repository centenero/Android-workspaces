package mi.paquete;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class Draw extends Activity {
    DrawView drawView;
    private Tablero fondo;
	int x,y;

    public void presionado(View v) {
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set full screen view       
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                         WindowManager.LayoutParams.FLAG_FULLSCREEN);
     //   getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, 
      //          WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        

        drawView = new DrawView(this);
        setContentView(drawView);
        drawView.requestFocus();
    }
	class Tablero extends View {

		public Tablero(Context context) {
			super(context);
		}
		protected void onDraw(Canvas canvas) {
			canvas.drawRGB(0, 0,0 );
			int ancho=0;
			if (canvas.getWidth()<canvas.getHeight())
				ancho=fondo.getWidth();
			else
				ancho=fondo.getHeight();
			int anchocua=ancho/8;
			Paint paint=new Paint();
			paint.setTextSize(20);
			Paint paint2=new Paint();
			paint2.setTextSize(20);
			paint2.setTypeface(Typeface.DEFAULT_BOLD);
			paint2.setARGB(255, 0,0, 255);    		
			Paint paintlinea1=new Paint();
			paintlinea1.setARGB(255,255,255,255);
			int filaact=0;	
		}
	}
    
}