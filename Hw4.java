import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class Calculator extends JPanel implements ActionListener{
	int w,h;
	int partition;
	int answer=0;
	int flag=1;
	char oper = '+';
	
	String [][] btnlab = {{"7","8","9","C"},
						  {"4","5","6","+"},
						  {"1","2","3","-"},
						  {"0","","","="}};
	JLabel display;
	JPanel buttonpanel;
	JPanel displaypanel;
	JButton [][] btn;
	
	Calculator(int _w, int _h){
		w=_w;
		h=_h;
		partition = h-w;
		
		//System.out.println(""+w+h+partition);
		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		displaypanel = new JPanel();
		displaypanel.setBackground(Color.GRAY);
		
		display = new JLabel("0", SwingConstants.RIGHT);
		display.setBackground(Color.GRAY);
		display.setOpaque(true);
		
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(4,4));
		btn = new JButton[4][4];
		for( int i=0 ; i<4 ; i++ ) {
			for( int j=0 ; j<4 ; j++ ) {
				btn[i][j] = new JButton(btnlab[i][j]);
				btn[i][j].addActionListener(this);
				buttonpanel.add(btn[i][j]);
			}
		}
		
		placing(w,h);
		
		displaypanel.add(display);
		add(displaypanel);
		add(buttonpanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		String str = new String(b.getText());
		int dis=Integer.parseInt(display.getText());
		if( str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")||str.equals("5")||
			str.equals("6")||str.equals("7")||str.equals("8")||str.equals("9")||str.equals("0") ) {
			
			int n =  Integer.parseInt(str);
			if( flag==0 ) {
				dis*=10;
				dis+=n;
			}
			else {
				dis=n;
				flag=0;
			}
			display.setText(""+dis);
			
			System.out.println("c-"+n);
		}
		else if( str.equals("C")) {
			answer=0;
			oper='+';
			flag=1;
			display.setText("0");
		}
		else {
			if( flag==0 ) {
				if(oper=='+') {
					answer+=dis;
				}
				else if(oper=='-') {
					answer-=dis;
				}
			}
			
			if(str.equals("+")) {
				oper='+';
			}
			else if(str.equals("-")) {
				oper='-';
			}

			flag=1;
			display.setText(""+answer);
		}
		
		System.out.println(b.getText());
	}

	void placing(int _w, int _h) {
		w=_w;
		h=_h;
		if( w/3>h/4 ) {
			w=h/4*3;
		}
		else {
			h=w/3*4;
		}
		partition=h-w;
		displaypanel.setSize(w,partition);
		displaypanel.setLocation(0,0);
		displaypanel.setBounds(w*2/45, partition*2/15, w*41/45, partition*11/15);
		
		display.setFont(new Font("Gothic",Font.BOLD,(int)(partition*10/15)));
		display.setPreferredSize(new Dimension(w*41/45, partition*11/15));
		
		buttonpanel.setLocation(0,partition);
		buttonpanel.setSize(w,w);
		Font btnFont = new Font("Gothic",Font.PLAIN,(int)(btn[0][0].getHeight()*7/10));
		for( int i=0 ; i<4 ; i++ ) {
			for( int j=0 ; j<4 ; j++ ) {
				btn[i][j].setFont(btnFont);
			}
		}
		setLocation((_w-w)/2,(_h-h)/2);
		setSize(w,h);
	}
}

public class Hw4 extends JFrame{
	
	Hw4(){
		setTitle("Homework4");
		setSize(450,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int w=getWidth();
		int h=getHeight();
		System.out.println(w+"/"+h);
		
		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(Color.BLACK);
		main.setSize(w,h);
		
		Calculator p = new Calculator(w,h);
		
		main.add(p);
		add(main);
		
		setVisible(true);
		
		p.placing(main.getWidth(),main.getHeight());
		
		main.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				Component c = (Component)e.getSource();
				int w=c.getWidth(),
					h=c.getHeight();
				setTitle("w : "+c.getWidth()+" h : "+c.getHeight());				
//				System.out.println("w : "+c.getWidth()+" h : "+c.getHeight());
//				
//				System.out.println(w+"/"+h);
				p.placing(w,h);
				
			}
		});
	}
	public static void main(String[] args) {
		new Hw4();
	}
}
