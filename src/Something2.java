import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Something2 extends Component{
	BufferedImage img; 
	BufferedImage img2; 
	
	

	public Something2() {
		
		
	 setPreferredSize( new Dimension( 400, 180 ) );
	  try{
		  
		  img = ImageIO.read(new File("images/boxning.png"));
	  } catch (IOException e){
		  e.printStackTrace();
	  }

	  

	}
	
	
	 




	public void paint(Graphics g){
		 g.drawImage(img,0,-20,null);;
	 }
	 
}
