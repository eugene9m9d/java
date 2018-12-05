import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class SettingPanel extends JPanel{
	JList<String> studentlist;
	JCheckBox [] days;
	protected String [] data;
	protected String [] week = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	static final int part1=130, part2=230;
	static final int x=400;
	static final int y=350;
	Data maindata;
	
	JButton next;
	
	SettingPanel(Data _d){
		//data setting
		data = new String[50];
		for(int i=0 ; i<50 ; i++ ) {
			data[i] = new String(""+i);
		}
		maindata = _d;
		
		//location Setting
		
		
		//panel setting
		setLayout(null);
		setBackground(Color.CYAN);
		JPanel c = new JPanel();
		c.setLayout(new BorderLayout());
		c.setSize(x,y);
		c.setLocation((1440-x)/2,(800-y)/2);
		c.setBackground(Color.GRAY);
		JPanel menu = new JPanel();
		menu.setLayout(null);
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//list setting
		JScrollPane studentPane = new JScrollPane();
		studentlist = new JList<String>(data);
		studentPane.setViewportView(studentlist);
		studentPane.setSize(part1,300);
		studentPane.setLocation(0,0);
		studentPane.setBackground(Color.PINK);
		
		//checkbox setting
		days = new JCheckBox[7];
		for( int i=0 ; i<7 ; i++ ) {
			days[i] = new JCheckBox(week[i]);
		}
		JPanel daypanel = new JPanel();
		daypanel.setLayout(new GridLayout(7,1));
		daypanel.setSize(part2-part1,300);
		daypanel.setLocation(part1,0);
		for( int i=0 ; i<7 ; i++ ) {
			daypanel.add(days[i]);
		}
		daypanel.setBackground(Color.ORANGE);
		
		
		//timefield setting
		JPanel timepanel = new JPanel();
		timepanel.setLayout(new FlowLayout());
		timepanel.setSize(400-part2,200);
		timepanel.setLocation(part2,0);
		InputField starttime = new InputField("Start");
		InputField endtime = new InputField("End");
		InputField perhow = new InputField("Per");
		timepanel.add(starttime);
		timepanel.add(endtime);
		timepanel.add(perhow);
		timepanel.setBackground(Color.YELLOW);
		
		//button setting
		next = new JButton("Next");
		next.setLocation(340,270);
		next.setSize(40,20);
		
		//add
		menu.add(studentPane);
		menu.add(daypanel);
		menu.add(timepanel);
		buttonpanel.add(next);
		c.add(menu,BorderLayout.CENTER);
		c.add(buttonpanel,BorderLayout.SOUTH);
		add(c);
	}
	
	class InputField extends JPanel{
		JSpinner hou_sel,min_sel;
		JLabel lab;
		SpinnerNumberModel hou,min;

		InputField(String name){
			setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
			setSize(30,100);
			
			lab = new JLabel(name);
			
			hou = new SpinnerNumberModel(9,0,24,1);
			min = new SpinnerNumberModel(0,0,30,30);
			hou_sel = new JSpinner(hou);
			min_sel = new JSpinner(min);
			
			this.add(lab);
			this.add(hou_sel);
			this.add(new JLabel("시"));
			this.add(min_sel);
			this.add(new JLabel("분"));
		}
	}

}