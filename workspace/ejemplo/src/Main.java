import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
 
import javax.swing.JComponent;
import javax.swing.JFrame;
 
public class Main {
 
     public static void main( String[] args ){
          JFrame frame = new JFrame( "Font outline");
          frame.setSize(600, 600);
          frame.getContentPane().setLayout(new BorderLayout( ));
          frame.getContentPane().add( new JComponent(){

               /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent( Graphics g ){
                    Graphics2D g2 = (Graphics2D) g;
                    Font f = new Font( "Arial", Font.BOLD, 200 );
                    g2.setFont(f);
 
                    Shape s = f.createGlyphVector(g2.getFontRenderContext(), "JAVA").getOutline(280, 300);
 
                    g2.setPaint(new GradientPaint( 0.0f, 200.0f, Color.RED, 0.0f, 400.0f, Color.WHITE ));
                    g2.fill(s);
 
                    g2.setColor(Color.BLACK);
                    g2.setStroke( new BasicStroke( 3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, new float[]{ 5.0f, 5.0f, 15.0f, 5.0f}, 0.0f ));
                    g2.draw(s);
 
               }
 
          }, BorderLayout.CENTER);
          frame.setVisible(true);
     }
 
}