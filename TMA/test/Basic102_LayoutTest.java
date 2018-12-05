package test;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Basic102_LayoutTest extends Frame implements ActionListener {
 CardLayout card = new CardLayout();    // 두개이상의 메소드에서 사용하려고
 Button btnGo;
 Panel pn3;
 
 public Basic102_LayoutTest() {   
  
  //frame을 상속받았기 때문에 setLayout이 바로 사용가능함.
  setLayout(new GridLayout(2, 1));// 전체 레이아웃을 GridLayout으로 설정
  
  //GridLayout(1,1)안에 들어갈 내용 작성
  Panel pn1 = new Panel(); // 컴포넌트(버튼, 텍스트필드, 레이블)를 담을 수 있는 컨테이너 클래스
  Label lbl1 = new Label("bunho:");   // 메세지 출력할때는 Label
  TextField txtBun = new TextField("", 20);   // 키보드로 자료입력할때는 TextField("내용", 길이)
  // Panel 안에 버튼 삽입가능, 세밀한 디자인 할때, 컨테이너(Frame와 같은 용도)
  pn1.add(lbl1);    // Panel은 FlowLayout이 기본 - 좌에서 우로 상에서 하로
   pn1.add(txtBun);
   pn1.setBackground(Color.RED);
   
   Panel pn2 = new Panel();
   Label lbl2 = new Label("irum:");
   TextField txtIrum = new TextField("", 20);
   pn2.add(lbl2);
   pn2.add(txtIrum);
   pn2.setBackground(Color.BLUE);
   
   pn3 = new Panel();  // pn1과 pn2가 CardLayout 형식으로 깔려있다.
   pn3.setLayout(card);   // FlowLayout를 CardLayout으로 변경
   pn3.add("aa", pn1);    // CardLayout는 이름을 줘야 한다. 먼져 나온게 위로 나옴.
   pn3.add("bb", pn2);    // add할때마다 밑에 깔림
   
   //버튼생성
   btnGo = new Button("OK");
   btnGo.addActionListener(this); // ActionListener를 implements 받았기 때문에 this를 사용
   
   //위의 내용들을 pn4 틀에 집어넣음
   Panel pn4 = new Panel();  // "aa"와 "bb"가 있는 CardLayout과 버튼을 넣기위해 기본레이아웃으로
   pn4.add(pn3);
   pn4.add(btnGo);
   
   
   //pn4를 전체 GridLayout(1,1)에 넣음
   add(pn4);    // Frame 0행 에 등록
  
   
   
   //GrindLayout(2,1)에 넣을 내용 작성
   Panel pn5 = new Panel();
   pn5.setLayout(new BorderLayout());
   pn5.setBackground(new Color(255, 255, 0));
   pn5.add(new Label("My name is pn5", Label.CENTER));  // 같은 말
   // pn5.add("Center", new Label("My name is pn5"));   // 같은말
   pn5.add("East", new Label("East"));
   pn5.add("West", new Label("West"));
   pn5.add("North", new Label("North", Label.CENTER));
   pn5.add("South", new Label("South", Label.CENTER));
   
   //pn4를 전체 GridLayout(2,1)에 넣음
  add(pn5);     // Frame 1행 에 등록
  
  //창의 제목표시줄 내용
  setTitle("배치관리자 연습");
  //창의 크기
  setBounds(200, 150, 400, 300);
  //창을 보여줌
  setVisible(true);
  
  //제목표시줄 종료버튼설정
  addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) {
    System.exit(0);
   }
  });
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {  // ActionListener 추상메소드  callback 자동으로 찾아가도록 약속
  // System.out.println(e.getActionCommand());  // getActionCommand 버튼의 라벨을 얻는다. 무슨 버튼을 눌렀는데 알아야할때 사용
  if(e.getActionCommand().equalsIgnoreCase("OK")) {
   btnGo.setLabel("Click");
   card.show(pn3, "bb");
  } else {
   btnGo.setLabel("OK");
   card.show(pn3, "aa");
  }
 }
 
 public static void main(String[] args) {
  new Basic102_LayoutTest();

 }
}