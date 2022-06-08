package expedia;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class TEST_CLASS extends JFrame{

	JProgressBar pbObj;
	
//	public TEST_CLASS() {
//		pbObj = new JProgressBar();
//		pbObj.setBounds(50,50,250,30);
//		pbObj.setValue(0);
//		pbObj.setStringPainted(true);
//		this.add(pbObj);
//		this.setSize(450,400);
//		this.setLayout(null);
//	}
	
	
	public TEST_CLASS() { }
	
	public void addText() {
		JFrame f = new JFrame();  
        JTextArea area = new JTextArea();  
        area.setBounds(10, 30, 400, 400);
        area.setText("Welcome to javatpoint");
        f.add(area);
        f.setSize(450,450);  
        f.setLayout(null);  
        f.setVisible(true);
	}
	
	public void createProgress () {
		int i = 0;
		while(i <= 100) {
			pbObj.setValue(i);
			i = i + 5;
			try {
				Thread.sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello world");
		TEST_CLASS frameObject = new TEST_CLASS();
		frameObject.addText();
//		frameObject.setVisible(true);
//		frameObject.createProgress();
		
		
	}

}
