package gameeinstellungen;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class frame extends JFrame implements ActionListener {
	
	private JButton schliessen;
	private JButton einstellung;
	private JButton info;
	private JButton ende;
	public static frame menu = new frame ("Menü");
	public static frame escmenu = new frame ("Pausiert");
	public static JFrame game = new JFrame ("Game");
	public static JFrame setings = new JFrame ("Einstellungen");
	
	
	
   public static void main(String[] args)  {
 	   Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       
       int x = dimension.width;
       int y = dimension.height;
       
       int fensterX = (x / 3);
       int fensterY = (y / 4);
	   menu.setLocation(fensterX, fensterY);
	   menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   menu.setSize(400,400);
	   menu.setLocation(fensterX, fensterY);
	   
	   
	   menu.setLayout(null);
	   menu.setVisible(true);
	   
    	
    	
    	
    }
   
   public static void manu(){
	   
 	   Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       
       int x = dimension.width;
       int y = dimension.height;
       
       int fensterX = (x / 3);
       int fensterY = (y / 4);
	   menu.setLocation(fensterX, fensterY);
	   menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   menu.setSize(400,400);
	   
	   
	   menu.setLayout(null);
	   menu.setVisible(true);
	   
	   
   }
   
   public frame (String title) {
	   super(title);
	   
	   schliessen =new JButton("Spiel starten");
	   schliessen.setBounds(120,40,160,40);
	   schliessen.addActionListener(this);
	   add(schliessen);
	   
	   einstellung =new JButton("Einstellungen");
	   einstellung.setBounds(120,120,160,40);
	   einstellung.addActionListener(this);
	   add(einstellung);
	   
	   info =new JButton("Credits");
	   info.setBounds(120,200,160,40);
	   info.addActionListener(this);
	   add(info);
	   
	   ende =new JButton("Ende");
	   ende.setBounds(120,280,160,40);
	   ende.addActionListener(this);
	   add(ende);
	   
   }
   
   
   		
       public static void fenster () {
    	   game.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
    	   game.setVisible(true);
    	   game.add(new gui());
    		
    	   
    	   //public static void auswahl() {
    		   
    	   //}
       }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		  
		   if (e.getSource() == schliessen) {
			   fenster ();
				
				repaint();
			   
		   }
		   
		   if (e.getSource ()  == info ) {
				Object[] options = { "OK"};
				
				JOptionPane.showOptionDialog(null,"Programmiert von Chrislai und rexlNico!","Information",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
				
			}
		   
		   if (e.getSource() == einstellung) {
			   
			   new Options();
		   }
		   if(e.getSource() == ende) {
			   System.exit(0);
		   }
		
		
	}
       
     
        
       }


