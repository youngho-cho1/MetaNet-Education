
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;

import test.FileTypeFilter;

public class JavaTest extends JFrame {
	static int cnt = 0;
	TextArea textArea = new TextArea("");
	JFileChooser fs = new JFileChooser(new File(""));
	String fileName = "";
	public JavaTest(){
		Panel panel = new Panel();
		createMenu();
		panel.setLayout(new BorderLayout());
		// 패널 크기 맞춤
		panel.add(textArea);
		add(panel,BorderLayout.CENTER);
		setBounds(200, 200, 500, 500);	
		setVisible(true);

	}
	
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem[] menuItem = new JMenuItem[5];
		String[] itemTitle = {"New File","Open File","Save File","Save As","Exit"};
		JMenu screenMenu = new JMenu("File");
		for(int i=0; i<menuItem.length;i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new MenuActionListener());
			screenMenu.add(menuItem[i]);
			if(i==2) continue;
			if(i==4) continue;
			else screenMenu.addSeparator();
		}
			setJMenuBar(mb);
			mb.add(screenMenu);
	}
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd = e.getActionCommand();
			switch(cmd) {
			case "New File":{
				JOptionPane.showMessageDialog
				(null,"New File");
				textArea.setText("");
				cnt = 0;
				break;
			}
			case "Open File":{
				int ret = fs.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog
					(null,"파일을 선택하세요!");
				} else {
					cnt ++;
					File inFile = fs.getSelectedFile();
					BufferedReader in;
					try {
						in = new BufferedReader(new FileReader(inFile));
						String c;
						textArea.setText("");
						while((c = in.readLine()) != null) {
							textArea.append(c);
						}
						in.close();
					} catch (IOException e3) {
						e3.printStackTrace();
					}
				}
				fileName = fs.getSelectedFile().toString();
				setTitle(fs.getSelectedFile().getName());
				break;
			}
			case "Save File":{
				if(cnt == 0) {
					fs.setDialogTitle("Save a File");
					int result = fs.showSaveDialog(null);
					if(result == JFileChooser.APPROVE_OPTION) {
						String content = textArea.getText();
//						String content = "이것은 버그";
						File file = fs.getSelectedFile();
						try {
							FileWriter fw = new FileWriter(file.getPath() + ".txt");
							System.out.println(file.getPath());
							fw.write(content);
							fw.flush();
							fw.close();
							cnt ++;
							
						}
						catch(Exception er) {
							JOptionPane.showMessageDialog
							(null,er.getMessage());
						}
					}
					
				}else {
					String content = textArea.getText();
					File file = fs.getSelectedFile();
					FileWriter fw;
					try {
						fw = new FileWriter(file.getPath());
						System.out.println(file.getPath());
						System.out.println("content : " + content);
						fw.write(content);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog
						(null,e1.getMessage());
					}
					
				}
				break;
			}
			case "Save As":{
				fs.setDialogTitle("Save a File");
				int result = fs.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					String content = textArea.getText();
					File file = fs.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(file.getPath() + ".txt");
						fw.write(content);
						fw.flush();
						fw.close();
					}
					catch(Exception er) {
						JOptionPane.showMessageDialog
						(null,er.getMessage());
					}
				}
				break;
			}
			case "Exit":{
				JOptionPane.showMessageDialog
				(null,"Exit");
				System.exit(0); 
				break;
			}

			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JavaTest();
	}

}
