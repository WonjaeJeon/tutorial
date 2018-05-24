import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

/*
 * JTable ���� ��� ���� ����
 * JTree ���� ���丮 ��ġ ����
 * JPopupMenu ��Ŭ�� �޴� ����
 * JComboBox ��� ���� ����
 * File Ŭ���� �̿�
 */

public class FileManagerEx extends JFrame implements WindowListener{
	
	JPanel mainPanel;
	JPanel southPanel;
	JLabel label1;
	JTable fileTable;
	JPopupMenu popup;
	
	String korHead[]= {"�̸�", "ũ��", "������"};
	String engHead[]= {"Name", "Size", "Modified"};
	
	String fileInfo[][] = {{"fileName", "fileSize", "fileModifiedDate"},
						{"�����̸�", "����ũ��", "������¥"}};
	
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
