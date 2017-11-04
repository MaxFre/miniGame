import javax.imageio.ImageIO;
import javax.swing.*;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;




import java.awt.Color;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;





public class Start extends JPanel{
	 BufferedImage img; 
	 private int bHpLeft = 400;
	 private int PhPLeft = 200;
	 private Font font1 = new Font("SansSerif", Font.BOLD, 30);
	 private Font font2 = new Font("SansSerif", Font.BOLD, 16);
	 private Font font3 = new Font("SansSerif", Font.BOLD, 13);
	 
	 private JLabel lblHeader = new JLabel("      FIGHT!");
	 private JLabel lblPlayer = new JLabel("Player");
	 private JLabel lblopponent = new JLabel("Opponent");
	 private JLabel lblopponentHp = new JLabel("HP:400");
	 private JLabel lblPlayerHp = new JLabel("HP:200");

	 private JTextArea taGameRules = new JTextArea(" Rules are: \n Your suppost to defeat the opponent, you have 3 options to do each round. "
	 		+ "\n First you have Punch, its your basic attack, deals 10 dmg \n to the opponent. Second is HeadPunch, deals 30 dmg to the opponent"
	 		+ "\n but it needs to recharge and that takes 4 Punches. Last\n you have Parry, where you avoid damage. Good luck!");
	 
	 private JButton btnRock = new JButton("Punch");
	 private JButton btnHeadPunch = new JButton("HeadPunch");
	 private JButton btnPary = new JButton("Parry");
	 
	 private JButton btnRestart = new JButton("Restart");
	 
	 private JLabel taInfo = new JLabel();
	 private JLabel taopponentInfo = new JLabel();
	 
	 private String PlayerHpLeft;
	 private String opponentHpLeft;
 
	 private int charged = 3;
	 
	 

	 
	 
	 public Start() {
		 
//		 PaintWindow_GU2 window = new PaintWindow_GU2(240, 220, "opponent", Color.WHITE);		
//		 ImageIcon opponent = new ImageIcon("images/opponent.jpg");
//		 window.addIcon(opponent, 0, 0, true); 
	    
		 
		 
		 taGameRules.setBounds(0,230,410,200);
		 try{
			  img = ImageIO.read(new File("images/boxning.png"));
		  } catch (IOException e){
			  e.printStackTrace();
		  }			
		 taInfo.setBounds(100,60,170,20);
		 taopponentInfo.setBounds(100,80,180,20);
		
		 lblHeader.setBounds(100, 5, 400, 50);
	     lblHeader.setFont(font1);
	     
		 lblPlayer.setBounds(20, 80, 400, 30);
	     lblPlayer.setFont(font2);
	     
	     lblopponent.setBounds(330, 80, 400, 30);
	     lblopponent.setFont(font2);
	     
	     lblopponentHp.setBounds(330, 100, 400, 30);
	     lblopponentHp.setFont(font3);
	     
	     lblPlayerHp.setBounds(20, 100, 400, 30);
	     lblPlayerHp.setFont(font3);
	     
	     btnRestart.setBounds(80, 200, 250, 20);
	     
	     btnRock.setBounds(5, 160, 120, 30);
	     btnHeadPunch.setBounds(135, 160, 120, 30);
	     btnPary.setBounds(270, 160, 120, 30);

	     btnRestart.addActionListener(new gameListener());
	     
	     btnRock.addActionListener( new gameListener() );
	     btnHeadPunch.addActionListener( new gameListener() );
	     btnPary.addActionListener( new gameListener() );
	     
	     setLayout(null);
		 setPreferredSize( new Dimension( 400, 320 ) );
		 
		 add(taInfo);
		 add(taopponentInfo);
		 
		 add(btnRock);
		 add(btnHeadPunch);
		 add(btnPary);
		 
		 add(btnRestart);
		 
		 add(lblopponentHp);
	     add(lblPlayerHp);
	     
		 add(lblHeader);
		 add(lblPlayer);
	     add(lblopponent);

	     add(taGameRules);
	     
	    
	 
	   
	   }
		 
	 
		   
	 
//	 public void opponentDead() {
//		 PaintWindow_GU2 window = new PaintWindow_GU2(240, 220, "opponent", Color.WHITE);
//		 ImageIcon opponentdead = new ImageIcon("images/opponentdead.jpg");
//		 window.addIcon(opponentdead, 0, 0, true);}
//		 
//	
//	 public void opponentAlive() {
//		 PaintWindow_GU2 window = new PaintWindow_GU2(240, 220, "opponent", Color.WHITE);
//		 ImageIcon opponent = new ImageIcon("images/opponent.jpg");
//		 window.addIcon(opponent, 0, 0, true);}
	
	 
	     
		

	    public void showButtons(){
	        btnRock.setEnabled(true);
	        btnHeadPunch.setEnabled(true);
	        btnPary.setEnabled(true);}
	 
	    
	        
	    public void disableButton(){       
	        btnHeadPunch.setEnabled(false);}
	       
	    
	    
	    public void disableAllButtons(){
	        btnRock.setEnabled(false);
	        btnHeadPunch.setEnabled(false);
	        btnPary.setEnabled(false);}
	    
	     public void addListeners(){
	         gameListener listener = new gameListener();
	         btnRock.addActionListener(listener);
	         btnHeadPunch.addActionListener(listener);
	         btnPary.addActionListener(listener);
	         btnRestart.addActionListener(listener);
	     }
	    
	     private class gameListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				String info = null;

				if(e.getSource() == btnRestart){
					lblHeader.setText("      FIGHT!");
					bHpLeft = 400;
					PhPLeft = 200;
					taInfo.setText("");
					lblPlayerHp.setText("HP: 200");
					lblopponentHp.setText("HP: 400");
					taopponentInfo.setText("");
					charged = 3;
					showButtons();}
//					opponentAlive();}
				
				
				
				
				if(e.getSource() == btnRock){
					info = "         You chose Punch";
					taInfo.setText(info);
					
					bHpLeft = bHpLeft - 10;
					
					//CHARGE!
				if(charged<=2){
					charged++;
					disableButton();}
										
				else{ showButtons();}
						
					
					
					
					if(bHpLeft>=0)
					opponentHpLeft = String.valueOf(bHpLeft);
					lblopponentHp.setText("HP:"+opponentHpLeft);
					

					if(PhPLeft>=0){
			         int opponentAtk;
			    	 String opponentInfo = null;
					 Random randAtk = new Random();
					 opponentAtk = randAtk.nextInt(16);  	 
					 opponentInfo = "opponent damaged you with " + opponentAtk;		
					 PhPLeft = PhPLeft - opponentAtk;
					 PlayerHpLeft = String.valueOf(PhPLeft);		    
					 lblPlayerHp.setText("HP:"+ PlayerHpLeft);
					 taopponentInfo.setText(opponentInfo);}
					
					if(PhPLeft<=0 || bHpLeft<=0){
						if(bHpLeft<=0){
						lblHeader.setText("  YOU DID IT!");
//						opponentDead();
						}
						
						
						if(PhPLeft<=0){
							lblHeader.setText("   DEFEAT!");
						}
						disableAllButtons();}
					
					
				}
					
					
				
				if(e.getSource() == btnHeadPunch){
					info = "       You chose HeadPunch";
					taInfo.setText(info);
					
					bHpLeft = bHpLeft - 30;
					
					if(bHpLeft>-20 )
					opponentHpLeft = String.valueOf(bHpLeft);
					lblopponentHp.setText("HP:"+opponentHpLeft);
					
					
					if(charged==3){
						showButtons();
						charged = 0;
						System.out.println(charged);}
						if(charged<3){ disableButton();}

					if(PhPLeft>=0){
			         int opponentAtk;
			    	 String opponentInfo = null;
					 Random randAtk = new Random();
					 opponentAtk = randAtk.nextInt(16);  	 
					 opponentInfo = "opponent damaged you with " + opponentAtk;		
					 PhPLeft = PhPLeft - opponentAtk;
					 PlayerHpLeft = String.valueOf(PhPLeft);		    
					 lblPlayerHp.setText("HP:"+ PlayerHpLeft);

					 taopponentInfo.setText(opponentInfo);
					 
					 
				    PlayerHpLeft = String.valueOf(lblPlayerHp);
					lblPlayerHp.setToolTipText("HP:" + PlayerHpLeft);}
				
				if(PhPLeft<=0 || bHpLeft<=0){
					if(bHpLeft<=0){
					lblHeader.setText("  YOU DID IT!");
//					opponentDead();
					}
					
					if(PhPLeft<=0){
						lblHeader.setText("   DEFEAT!");}
					disableAllButtons();
				}}
				
				
				
				if(e.getSource() == btnPary){
					info = "       You chose Parry";
					taInfo.setText(info);
					opponentHpLeft = String.valueOf(bHpLeft);
					lblopponentHp.setText("HP:"+opponentHpLeft);
					

					PlayerHpLeft = String.valueOf(lblPlayerHp);
					lblPlayerHp.setToolTipText("HP:" + PlayerHpLeft);
					
					 int opponentAtk;
					 String opponentInfo = null;
					 Random randAtk = new Random();
					 opponentAtk = randAtk.nextInt(21);  	 
					 opponentInfo = "  You parried " + opponentAtk + " damage";
					 
					 PlayerHpLeft = String.valueOf(PhPLeft);
					 taopponentInfo.setText(opponentInfo);
					 
					 PlayerHpLeft = String.valueOf(lblPlayerHp);
					 lblPlayerHp.setToolTipText("HP:" + PlayerHpLeft);}
				
			}
			
		
			
			
		}


     
     
	public static void main(String [] args){
		Start start = new Start();
		JFrame frame = new JFrame("Boxing");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Start());
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	    
	    frame.setLocationRelativeTo(null);
	     
        
        JFrame frame2 = new JFrame("Boxers");	
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(new Something2());
		frame2.pack();
		frame2.setVisible(true);
		frame2.setResizable(false);
		frame2.setLocation(753,123);
	}
}
