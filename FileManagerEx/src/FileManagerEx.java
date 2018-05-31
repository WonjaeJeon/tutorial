import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/*
 * JTable 파일 요약 정보 구현
 * JTree 파일 디렉토리 위치 구현
 * JPopupMenu 우클릭 메뉴 구현
 * JComboBox 언어 선택 구현
 * File 클래스 이용
 */

public class FileManagerEx extends JFrame {
	
	File f;
	FileFilter ff;
	
	String[] language= {"한국어", "English"};
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	
	JComboBox<String> langSelect=new JComboBox<String>(language);
	
	JLabel lb1=new JLabel("File Manager");
	JLabel space = new JLabel("                                                                                                               ");
	
	JScrollPane scrPane=new JScrollPane();
	
	
	JTree tree;

	
	
	DefaultTreeModel treeModel;

	
	public FileManagerEx() {
		super("File Manager");
		File cDir = new File("C://");
		File[] cFiles;
		FileFilter cFileFilter = new FileFilter() {
			public boolean accept(File cFile) {
				return cFile.isDirectory();
			}
		};
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("내컴퓨터");
		
		cFiles = cDir.listFiles(cFileFilter);
		
		DefaultMutableTreeNode cDrive = new DefaultMutableTreeNode("C드라이브");
		
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		
		if (cFiles.length == 0) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (int c = 0; c < cFiles.length; c++) {
				File cFilename = cFiles[c];
				if (cFilename.toString().contains("$") || cFilename.toString().contains("Recovery")
						|| cFilename.toString().contains("System") || cFilename.toString().contains("Temp")
						|| cFilename.toString().contains("PerfLogs"))
					continue;

				DefaultMutableTreeNode Folders2 = new DefaultMutableTreeNode(cFilename.getName());

				treeModel.insertNodeInto(Folders2, cDrive, 0);
				treeModel.insertNodeInto(cDrive, root, 0);
			}
		}
		
		setVisible(true);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.WEST);
		add(p3, BorderLayout.SOUTH);
		add(p4, BorderLayout.CENTER);
		
		scrPane.setViewportView(p2);
		scrPane.setPreferredSize(new Dimension(150, 100));
		add(scrPane, BorderLayout.WEST);
		
		p3.add(lb1, JPanel.LEFT_ALIGNMENT);
		p3.add(space);
		p3.add(langSelect, JPanel.RIGHT_ALIGNMENT);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		p4.setBackground(Color.GRAY);
		setBackground(Color.lightGray);
		p2.add(tree);
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FileManagerEx();
	}

	
	
}
