package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResizeTest extends JFrame{
	
	ResizeTest(){
		setSize(500,500);
		setTitle("w : "+getWidth()+" h : "+getHeight());
		System.out.println("w : "+this.getWidth()+" h : "+this.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.CYAN);
		
		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(Color.PINK);
		main.setSize(500,500);
		
		System.out.println("w : "+main.getWidth()+" h : "+main.getHeight());
		
		JPanel [][] p = new JPanel[10][10];
		
		for( int i=0 ; i<10 ; i++ ) {
			for( int j=0 ; j<10 ; j++ ) {
				p[i][j] = new JPanel();
				p[i][j].setBackground(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
				p[i][j].setSize(50, 50);
				p[i][j].setLocation(50*i,50*j);
				main.add(p[i][j]);
			}
		}
		
		main.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e){
				Component c = (Component)e.getSource();
				
				setTitle("w : "+c.getWidth()+" h : "+c.getHeight());
				System.out.println("w : "+c.getWidth()+" h : "+c.getHeight());
			}
		});
		
		add(main);
		
		setVisible(true);
		
		int gapX = 500 - main.getWidth();
		int gapY = 500 - main.getHeight();
		System.out.println("X : "+gapX+" Y : "+gapY);
		
		setSize(500+gapX,500+gapY);
	}

	public static void main(String[] args) {
		JFrame f = new ResizeTest();
		//System.out.println("w : "+f.getWidth()+" h : "+f.getHeight());
	}

}
