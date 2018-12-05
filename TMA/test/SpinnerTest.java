package test;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class SpinnerTest extends JFrame {

	//FIELDS
	private String[] name = {"김철수", "김숙자", "김영희", "김자몽"};
	private JPanel panel = new JPanel();
	private JSpinner spinner;

	//CONSTRUCTOR
	SpinnerTest() {
		setTitle("스피너 예제");
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// List Model
		SpinnerListModel listModel = new SpinnerListModel(name);
		spinner = new JSpinner(listModel);
		panel.add(spinner);

		// Number Model
		SpinnerNumberModel numberModel = new SpinnerNumberModel(3,1,6,1);
		spinner = new JSpinner(numberModel);
		panel.add(spinner);

		// Date Model
		Calendar calendar = Calendar.getInstance(); //갤린더 객체 얻기
		Date value = calendar.getTime(); //현재 시간 얻기
		
		calendar.add(Calendar.YEAR, -50); // 50년 전의 날짜 얻기
		Date start = calendar.getTime(); //50년 전의 날짜를 최소 날짜로 지정
		
		calendar.add(Calendar.YEAR, 100); // 50년 뒤의 날짜 얻기 +50하면 현재날짜가됨.
		Date end = calendar.getTime(); //50년 뒤의 날짜를 최대 날짜로 지정

		SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, Calendar.HOUR_OF_DAY);
		spinner = new JSpinner(dateModel);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "hh:mm")); //날짜 편집기 지정
		panel.add(spinner);

		add(panel);
		setVisible(true);
	}

	//METHODS
	public static void main(String[] args) {
		new SpinnerTest();
	}
}