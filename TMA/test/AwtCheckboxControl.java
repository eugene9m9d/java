package test;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
public class AwtCheckboxControl {
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
 
    public AwtCheckboxControl() {
        prepareGUI();
    }
 
    public static void main(String[] args) {
        AwtCheckboxControl awtControlDemo = new AwtCheckboxControl();
        awtControlDemo.showCheckbox();
    }
 
    private void prepareGUI() {
        // Frame 에 대한 셋팅
        mainFrame = new Frame("Java AWT 샘플");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
 
        // 상단에 있는 라벨
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        headerLabel.setText("Control Test : Checkbox");
 
        // 하단 상태값 라벨
        statusLabel = new Label();
        statusLabel.setText("Status Lable");
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);
 
        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());
 
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
 
    private void showCheckbox() {
 
        Checkbox chk1 = new Checkbox("바나나");
        Checkbox chk2 = new Checkbox("감자");
        Checkbox chk3 = new Checkbox("고구마");
 
        chk1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("바나나 Checkbox: " + 
                (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
 
        chk2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("감자 Checkbox: " + 
                (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
 
        chk3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("고구마 Checkbox: " + 
                (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
 
        controlPanel.add(chk1);
        controlPanel.add(chk2);
        controlPanel.add(chk3);
 
        mainFrame.setVisible(true);
    }
}
