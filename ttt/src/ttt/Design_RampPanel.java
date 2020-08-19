package ttt;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class Design_RampPanel extends JPanel{

	// the 1st part: ramp dimensions
	JPanel panel_1;
	JLabel labelType, labelRatio, labelWidth, labelLength;
	JComboBox comboBoxType;
	JTextField textRatio, textWidth, textLength;
	JLabel l1, l2;
	double ratioValue, widthValue, lengthValue;
	
	// the 2nd part: facility dimensions
	//JPanel panel_2;
	JScrollPane scrollpane;
	String[] facilities;
	String RW = "RW = Ramp Width";
	String RL = "RL = Ramp Length";
	String RS = "RS = Ramp Slope Ratio";
	String D = "D  = Final Depth";
	String BL = "BL = Bottom Length";
	String BW = "BW = Bottom Width";
	String TL = "TL = Top Length";
	String TW = "TW = Top Width";
	String S = "S  = Facility Side Slope";
	// the 3rd part: graph
	JPanel panel_3a, panel3_b;	
	JScrollPane graphScrollpane;
	
	// the 4th part: buttons
	JPanel panel_4;
	JLabel labelNote;
	JButton buttonCancel, buttonOk;
	
	// the layout
	GridBagConstraints gc;	// for the whole panel
	
	// some format of the display
	Font font = new Font("Arial Narrow", Font.PLAIN, 13);
	Font font_1 = new Font("Arial Narrow", Font.PLAIN, 12);
	Font font_2 = new Font("Arial", Font.BOLD, 11);
	DecimalFormat df_0 = new DecimalFormat("0");
	DecimalFormat df_1 = new DecimalFormat("0.0");
	DecimalFormat df_2 = new DecimalFormat("0.00");
	
	public Design_RampPanel() {		
		
		initialData();
		initialElements();
		initialActionListeners();
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		initialLayout();
	}
	
	public void initialData() {
		ratioValue = 0;
		widthValue = 0;
		lengthValue = 0;
		facilities = new String[9];
		facilities[0] = RW;
		facilities[1] = RL;
		facilities[2] = RS;
		facilities[3] = D;
		facilities[4] = BL;
		facilities[5] = BW;
		facilities[6] = TL;
		facilities[7] = TW;
		facilities[8] = S;
		
	}
	
	public void initialElements() {
		initialPanel_1();
		initialPanel_2();
		initialPanel_3();
		initialPanel_4();
		
	}
	
	private void initialPanel_1() {
		// initial elements
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200, 165)); //
		panel_1.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ramp Dimensions"));
		labelType = new JLabel("Ramp Type");
		labelRatio = new JLabel("Ramp Slope Ratio");
		labelWidth = new JLabel("Width");
		labelLength = new JLabel("Length");
		String[] t = {"Perpendicular", "Parallel"};
		comboBoxType = new JComboBox(t);
		comboBoxType.setSelectedIndex(0);
		textRatio = new JTextField("0");
		textRatio.setPreferredSize(new Dimension(55, 25));
		textWidth = new JTextField("0");
		textWidth.setPreferredSize(new Dimension(55, 25));
		textLength = new JTextField("0.0");
		textLength.setEditable(false);
		textLength.setPreferredSize(new Dimension(55, 25));
		l1 = new JLabel("ft");
		l2 = new JLabel("ft");
		// initial layout
		panel_1.setLayout(new GridBagLayout());
		GridBagConstraints gc1 = new GridBagConstraints();
		gc1.anchor = GridBagConstraints.NORTHWEST;
		gc1.insets = new Insets(8, 2, 8, 2);
		
		gc1.gridx = 0;
		gc1.gridy = 0;
		panel_1.add(labelType, gc1);
		gc1.gridy = 1;
		gc1.gridwidth = 2;
		panel_1.add(labelRatio, gc1);
		gc1.gridy = 2;
		panel_1.add(labelWidth, gc1);
		gc1.gridy = 3;
		panel_1.add(labelLength, gc1);
		
		gc1.insets = new Insets(5, 2, 5, 2);
		gc1.gridx = 1;
		gc1.gridy = 0;
		gc1.gridwidth = 3;
		panel_1.add(comboBoxType, gc1);
		
		gc1.gridx = 2;
		gc1.gridy = 1;
		gc1.gridwidth = 1;
		panel_1.add(textRatio, gc1);
		gc1.gridy = 2;
		panel_1.add(textWidth, gc1);
		gc1.gridy = 3;
		panel_1.add(textLength, gc1);
		
		gc1.insets = new Insets(8, 2, 8, 2);
		gc1.gridx = 3;
		gc1.gridy = 2;
		panel_1.add(l1, gc1);
		gc1.gridy = 3;
		panel_1.add(l2, gc1);
		
	}
	
	private void initialPanel_2() {
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(9,1));
		for(int i = 0; i < 9; i++) {
			JLabel l = new JLabel(" " + facilities[i]);
			l.setFont(font_2);
			listPanel.add(l);
		}
		
		scrollpane = new JScrollPane(listPanel);
		scrollpane.setPreferredSize(new Dimension(200, 200));
		scrollpane.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Facility Dimensions"));				
	}

	private void initialPanel_3() {
		
		panel_3a = new JPanel() {
			
			@Override
			public void paint(Graphics g) {               
               // super.paint(g);
                Graphics2D g2 = (Graphics2D) g;               				
             
               // calculateParameters(false);
                
				// draw the graph: above half								
				g2.setStroke(new BasicStroke(3.0f));				
				g2.drawLine(30, 50, 50, 50); // top left line
                g2.drawLine(50, 50, 100, 210);	// left line
                g2.drawLine(100, 210, 425, 210);	// bottom line
                g2.drawLine(400, 210, 450, 50);	// right line
                g2.drawLine(450, 50, 470, 50);	// top right line
              
                
              // draw the graph: bellow half	
                
                // draw the parameters: set the size of the line and string.
                g2.setStroke(new BasicStroke(1.0f));
               // g2.setFont(font_2);
                

            }
		};
		
		
		graphScrollpane = new JScrollPane(panel_3a);
		graphScrollpane.setPreferredSize(new Dimension(450, 360));
	}
	
	private void initialPanel_4() {
		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(600,30));
		labelNote = new JLabel("All dimensions are in feet.");
		labelNote.setPreferredSize(new Dimension(440, 25));
		buttonCancel = new JButton("Cancel");
		buttonCancel.setFont(font);
		buttonCancel.setPreferredSize(new Dimension(70, 25));
		buttonOk = new JButton("OK");
		buttonOk.setFont(font);
		buttonOk.setPreferredSize(new Dimension(70, 25));
		panel_4.add(labelNote);
		panel_4.add(buttonCancel);
		panel_4.add(buttonOk);
	}


	public void initialActionListeners() {
		
	}
	public void initialLayout() {
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.insets = new Insets(2, 5, 2, 5);
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(panel_1, gc);
		gc.gridy = 1;
		add(scrollpane, gc);
		gc.gridy = 2;
		gc.gridwidth = 3;
		add(panel_4, gc);
		gc.insets = new Insets(10, 5, 2, 5);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.gridheight = 2;
		add(graphScrollpane, gc);
		
	}

	
}
