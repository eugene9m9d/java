package test;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowLayoutTest extends JFrame{

	FlowLayoutTest(){
		setTitle("FlowLayoutTest");
		setSize(500,500);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lab = new JLabel("test");
		add(lab);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new FlowLayoutTest();
	}

}
