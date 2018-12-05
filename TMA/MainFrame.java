import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

class DetailSettingPanel extends JPanel{
	String [] dummydata;
	JButton prev,next;
	static final int x=800;
	static final int y=500;
	protected String [] week = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	Data maindata;
	
	DetailSettingPanel(Data _d){
		//data setting
		dummydata = new String[10];
		for( int i=0 ; i<10 ; i++ ) {
			dummydata[i] = new String(""+i);
		}
		maindata = _d;
		
		//super setting
		setBackground(Color.PINK);
		setLayout(null);
		
		//menu panel setting
		JPanel c = new JPanel();
		c.setSize(x,y);
		c.setLayout(new BorderLayout());
		c.setLocation((1440-x)/2, (800-y)/2);
		c.setBackground(Color.GRAY);
		JPanel daypanel = new JPanel();
		daypanel.setLayout(new GridLayout(1,8,20,10));
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//component setting
		DayPanel timeset = new DayPanel();
		DayPanel [] eachday = new DayPanel[7];
		for(int i=0 ; i<7 ; i++ ) {
			eachday[i] = new DayPanel(week[i]);
		}
		
		next = new JButton("next");
		prev = new JButton("prev");
		
		//add
		daypanel.add(timeset);
		for( int i=0 ; i<7 ; i++ ) {
			daypanel.add(eachday[i]);
		}
		buttonpanel.add(prev);
		buttonpanel.add(next);
		c.add(daypanel, BorderLayout.CENTER);
		c.add(buttonpanel, BorderLayout.SOUTH);
		add(c);
	}
	
	class DayPanel extends JPanel{
		String name;
		JComboBox [] eachtime;
		int num;
		Time t;
		JSpinner [] hou_sel,min_sel;
		JLabel lab;
		SpinnerNumberModel hou,min;
		
		DayPanel(){
			name = null;
			num = maindata.num;
			hou_sel = new JSpinner[num];
			min_sel = new JSpinner[num];
//			t = new Time[num];
//			for( int i=0 ; i<num ; i++ ) {
//				
//			}
			t = new Time(maindata.start);
			hou = new SpinnerNumberModel(t.hou,0,24,1);
			min = new SpinnerNumberModel(t.min,0,30,30);
			
			setSize(100,500);
			
			JLabel blank = new JLabel(" ");
			JPanel [] eachblock = new JPanel[num];
			for( int i=0 ; i<num ; i++ ) {
				eachblock[i] = new JPanel();
				eachblock[i].setLayout(new GridLayout(2,1));
				hou.setValue(t.hou);
				min.setValue(t.min);
				hou_sel[i] = new JSpinner(hou);
				min_sel[i] = new JSpinner(min);
				t.cal(maindata.per);
				eachblock[i].add(hou_sel[i]);
				eachblock[i].add(min_sel[i]);
			}
			
			setLayout(new GridLayout(num+1,1));
			add(blank);
			for( int i=0 ; i<num ; i++ ) {
				add(eachblock[i]);
			}
			
		}
		@SuppressWarnings("unchecked")
		DayPanel(String _name){
			name = new String(_name);
			
			setSize(100,500);
			
			JLabel lab = new JLabel(_name);
			for( int i=0 ; i<7 ; i++ ) {
				if(name.equals(maindata.week[i].name)  ) {
					num = maindata.num;
					eachtime = new JComboBox[num];
					for( int j=0 ; j<num ; j++ ) {
						eachtime[j] = new JComboBox(maindata.week[i].time[j].studentlist);
					}
				}
			}
			setLayout(new GridLayout(num+1,1));
			add(lab);
			for( int i=0 ; i<num ; i++ ) {
				add(eachtime[i]);
			}
		}
	}
}

class ChoicePanel extends JPanel {
	JButton prev;
	Data maindata;
	
	ChoicePanel(Data _d){
		maindata = _d;
		setBackground(Color.WHITE);
		prev = new JButton("prev");
		add(prev);
		
	}
}

public class MainFrame extends JFrame implements ActionListener {
	CardLayout card = new CardLayout(0,0);
	JPanel MainPanel=null;
	SettingPanel panel01=null;
	DetailSettingPanel panel02=null;
	ChoicePanel panel03=null;
	
	MainFrame(){
		setTitle("TMA");
		setSize(1440,900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Data data = new Data();
		data.testSetting();
		
		MainPanel = new JPanel();
		MainPanel.setSize(1440,900);
		MainPanel.setLayout(card);
		
		panel01 = new SettingPanel(data);
		panel02 = new DetailSettingPanel(data);
		panel03 = new ChoicePanel(data);
		
		MainPanel.add("first",panel01);
		MainPanel.add("second",panel02);
		MainPanel.add("third",panel03);
		
		panel01.next.addActionListener(this);
		panel02.prev.addActionListener(this);
		panel02.next.addActionListener(this);
		panel03.prev.addActionListener(this);
		
		add(MainPanel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//card.show(MainPanel, "second");
		if( e.getSource() == panel01.next || e.getSource() == panel02.next ) {
			card.next(MainPanel);
		}
		else {
			card.previous(MainPanel);
		}
	}
}
