package ttt;

import javax.swing.JFrame;



public class tttMain {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		
		Design_RampPanel panel = new Design_RampPanel();
		panel.setSize(700,410);
		jf.add(panel);
		
		//jf.setSize(921,648);	
		jf.setSize(720,450);
		jf.setResizable(false);
		jf.setVisible(true);
	}

}
