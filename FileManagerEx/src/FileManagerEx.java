import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

/*
 * JTable 파일 요약 정보 구현
 * JTree 파일 디렉토리 위치 구현
 * JPopupMenu 우클릭 메뉴 구현
 * JComboBox 언어 선택 구현
 * File 클래스 이용
 */

public class FileManagerEx extends JFrame implements WindowListener{
	
	JPanel mainPanel;
	JPanel southPanel;
	JLabel label1;
	JTable fileTable;
	JPopupMenu popup;
	
	String korHead[]= {"이름", "크기", "수정됨"};
	String engHead[]= {"Name", "Size", "Modified"};
	
	String fileInfo[][] = {{"fileName", "fileSize", "fileModifiedDate"},
						{"파일이름", "파일크기", "수정날짜"}};
	
	public FileManagerEx() {
		super("Directory");
	
		mainPanel=new JPanel();
		southPanel=new JPanel();
		
		popup=new JPopupMenu();
		
		label1=new JLabel("File Explorer");
		
		fileTable=new JTable(fileInfo, korHead);
		
		add(mainPanel, BorderLayout.SOUTH);
		
		
		
		mainPanel.add(label1, BorderLayout.WEST);
		
		setSize(400,300);
		setVisible(true);
		setLocation(100,100);
		
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new FileManagerEx();
	}
	
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}

}
