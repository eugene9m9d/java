import java.util.StringTokenizer;

public class Data{
	Time start;
	Time end;
	Time per;
	int [] days;
	int num;
	protected String [] studentlist;
	protected String [] weeknamestr = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	DayOfWeek [] week;
	
	Data(){
		studentlist = new String[50];
		days = new int[7];
		for( int i=0 ; i<7 ; i++ ) {
			days[i] = 1;
		}
		week = new DayOfWeek[7];
		for( int i=0 ; i<7 ; i++ ) {
			week[i] = new DayOfWeek(weeknamestr[i]);
		}
	}
	
	void testSetting() {
		int cnt=0;
		num = 6;
		start = new Time(9,0);
		end = new Time(18,0);
		per = new Time(1,30);
		
		String lorem = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		StringTokenizer st = new StringTokenizer(lorem, " ");
		for( int i=0 ; i<50 ; i++ ) {
			studentlist[i] = new String(st.nextToken());
		}
		for( int i=4 ; i<7 ; i++ ) days[i] = 0;
		for( int i=0 ; i<7 ; i++ ) {
			week[i].time = new TimeOfDay[6];
			for( int j=0 ; j<6 ; j++ ) {
				week[i].time[j] = new TimeOfDay();
				week[i].time[j].charge = new String(studentlist[cnt]);
				cnt++;
				week[i].time[j].studentlist = new String[7];
				for( int k=0 ; k<7 ; k++ ) {
					week[i].time[j].studentlist[k] = new String(studentlist[k]);
				}
			}
		}
	}
}

class DayOfWeek{
	String name;
	//String [] charge;
	TimeOfDay [] time;
	int onoff;
	DayOfWeek(String _name){
		name = new String(_name);
	}
	
}
class TimeOfDay {
	String [] studentlist;
	String charge;
	
	TimeOfDay(){
		charge=null;
	}
}

class Time{
	int hou,min;
	
	Time(int _h, int _m){
		hou = _h;
		min = _m;
	}
	Time(Time _t){
		hou = _t.hou;
		min = _t.min;
	}
	
	void cal(int plus_hou, int plus_min) {
		hou += plus_hou;
		min += plus_min;
		hou += (min/60);
		min %= 60;
	}
	void cal(Time plus) {
		hou += plus.hou;
		min += plus.min;
		hou += (min/60);
		min %= 60;
	}
}