package gameeinstellungen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gui extends JPanel implements ActionListener {
	
	Timer time;
	Image img;
	int key;
	int nx,nx2;
	int anzahl = 0;
	int anzahl2 = 0;
	int X_Bild;
	int lauf;
	int right = 0;
	int left = 0;
	int figur_y = 235;
	public static boolean esc =false;
	private Image img2;
	
	public gui(){
		repaint();
		frame.menu.setVisible(false);
		nx=0;
		nx2=690;
		
		key=0;
		lauf=0;
		
		setFocusable(true);
		ImageIcon u = new ImageIcon((getClass().getResource("Hintergrund.jpg")));
		img = u.getImage();
		
		ImageIcon s = new ImageIcon ((getClass().getResource("Menschen.png")));
		img2 = s.getImage();
		
		
		
		
		addKeyListener(new AL());
		
		
		time = new Timer(5,this);
		time.start();
		
	}
	
	public void actionPerformed(ActionEvent e){
		bewegen();
		
		figur_y = Sprung.sprungposition ;
		
		repaint();
		
	}
     
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D f2 =(Graphics2D)g;
		
		f2.drawImage(img, 685-nx2,0,null);
		
		//f2.drawImage(img2, left,figur_y,null);
		f2.drawImage(img2, 50,940, null);
		
		
	}
	
	private int getXBild() {
		// TODO Auto-generated method stub
		return X_Bild;
	}

	public void bewegen () {
		
		if(lauf != -2){
			if(left + lauf <= 75){
				left += lauf;
				
			}else{
		
		
		X_Bild += lauf;
		nx += lauf;
		nx2 += lauf;
			}
		
	}
      if(lauf == -2){
			if(left + lauf <= 0){
				left += lauf;
				
			}else{
		
		
		X_Bild += lauf;
		nx += lauf;
		nx2 += lauf;
			}
		
		}
	}
	private class AL extends KeyAdapter{
		public AL (){
			
		}
			
		
			
		

	    public void keyPressed(KeyEvent e) {
	    	
	    	
	    	key = e.getKeyCode();
	    	if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
	    		lauf = -2;
	    	}
	    	
	    	if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D){
	    		lauf = 2;
	    	}
	    	if(key == KeyEvent.VK_ESCAPE){
	    		
	    		if(esc == false){
	    			frame.manu();
	    			frame.game.setVisible(false);
	    			esc = true;
	    		}
	    		if(esc = true){
	    			esc = false;
	    		}
	    	}
	    	
	    	if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W || key == KeyEvent.VK_SPACE){
	    		Sprung();
	    	}
	    	
	    }
	    	
	    
	
	    	
	    	
	     public void keyReleased(KeyEvent e) {
	    	key = e.getKeyCode();
	    	
	    	if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_A || key == KeyEvent.VK_D || key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
	    		lauf=0;
	    	}
	     }
	     
	     public void Sprung(){
	     new Sprung();
	     
			bewegen();
			
			figur_y = Sprung.sprungposition ;
			
			repaint();
	    	 
	     }
	     
	     
	    
	     }
	}

	
	    	
	    
	
	
	
