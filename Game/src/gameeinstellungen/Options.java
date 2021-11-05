package gameeinstellungen;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.Timer;

import javax.swing.JFrame;

public class Options {

	public static JFrame setings = new JFrame ("Einstellungen");
	
	public Options(){
		
		//addKeyListener(new ALo());
		
		frame.game.setVisible(false);
		frame.escmenu.setVisible(false);
		frame.menu.setVisible(false);
		
 	   setings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
 	   Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        int x = dimension.width;
        int y = dimension.height;
        
        int fensterX = (x / 4);
        int fensterY = (y / 10);
		
        setings.setLocation(fensterX, fensterY);
        setings.setSize(800, 800);
        setings.setVisible(true);
        
		
	}
	
	
    private class ALo extends KeyAdapter{
    	public ALo (){
    		
    	}
        public void keyPressed(KeyEvent e) {
        	int key;
        	boolean esc = true;
        	
        	key = e.getKeyCode();
        	
        	if(key == KeyEvent.VK_ESCAPE){
        		
        		if(esc == false){
        			
        			esc = true;
        		}
        		if(esc = true){
        			if(gui.esc == false){
        				setings.setVisible(false);
        				frame.menu.setVisible(true);
        			}
        			if(gui.esc == true){
        				setings.setVisible(false);
        				frame.escmenu.setVisible(true);
        			}
        			esc = false;
        		}
        	}
        	
        	
        }

         
         
        
         }
    
}
