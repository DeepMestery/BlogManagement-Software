package bag;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Add{
	public Add()
	{
	    JFrame frame=new JFrame ("���ȷ��");	    
        JLabel label=new JLabel("�Ƿ�Ҫ�������");
	    JButton but1 =new JButton("��");
	    JButton but2 =new JButton("��");
	    frame.setLayout(null);
	    
		Font f1=new Font("����",Font.BOLD,19);
		Font f2=new Font("����",Font.BOLD,16);
		
	    but1.setBounds(40, 110,90,30);
	    but1.setFont(f2);
	    but2.setBounds(160, 110,90,30);
	    but2.setFont(f2);
		label.setBounds(75, 5, 200,100);
		label.setFont(f1);
		
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
	    frame.add(but1);
	    frame.add(but2);
	    frame.add(label);
	    frame.setVisible(true);	     
	    but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1){
					add1();
					frame.setVisible(false);
				}
			}
		});
	    but2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but2){
					frame.setVisible(false);
				}
			}
		});
	}
	
	public void add1()
	{
		Font f1=new Font("����",Font.BOLD,19);
		Font f2=new Font("����",Font.BOLD,16);
		
		JFrame frame =new JFrame("������Ҫ��ӵ�ѧ����Ϣ");
		JLabel t1 =new JLabel("�꼶");
		JLabel t2 =new JLabel("�༶");
		JLabel t3 =new JLabel("ѧ��");
		JLabel t4 =new JLabel("����");
		JLabel t5 =new JLabel("���͵�ַ");
		JTextField Sgrade=new JTextField(30);
		JTextField Sclass=new JTextField(30);
		JTextField Sno=new JTextField(30);
		JTextField Sname=new JTextField(30);
		JTextField Sblog=new JTextField(50);
		
		JButton e1 =new JButton("ȷ��");
		JButton e2 =new JButton("ȡ��");
		frame.setLayout(null);
		t1.setBounds(100, 0, 90, 50);
		t1.setFont(f2);
		t2.setBounds(100, 80, 90, 50);
		t2.setFont(f2);
		t3.setBounds(100, 160, 90, 50);
		t3.setFont(f2);
		t4.setBounds(100, 240, 90, 50);
		t4.setFont(f2);
		t5.setBounds(70, 320, 90, 50);
		t5.setFont(f2);
		Sgrade.setBounds(150, 10, 250, 30);
		Sclass.setBounds(150, 90, 250, 30);
		Sno.setBounds(150, 170, 250, 30);
		Sname.setBounds(150, 250,250, 30);
		Sblog.setBounds(150, 330, 250, 30);
		e1.setBounds(60, 390, 80, 30);
		e1.setFont(f2);
		e2.setBounds(300, 390,  80, 30);
		e2.setFont(f2);
		
		frame.add(t1);
		frame.add(Sgrade);
		frame.add(t2);
		frame.add(Sclass);
		frame.add(t3);
		frame.add(Sno);
		frame.add(t4);
		frame.add(Sname);
		frame.add(t5);
		frame.add(Sblog);
		frame.add(e1);
		frame.add(e2);
		frame.setLocation(500, 110);
		frame.setSize(500, 470);
		frame.setVisible(true);
		
		e1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e1)
				{
					String false1 = "",false2 = "",false3 = "",false4 = "",false5 = "",falseZ = "";
					if(Sgrade.getText().equals("")||Sclass.getText().equals("")||Sno.getText().equals("")||Sname.getText().equals("")||Sblog.getText().equals(""))
					{
						if(Sgrade.getText().equals(""))
						{
							false1 = "�꼶";
							falseZ += false1+"��";
						}
						if(Sclass.getText().equals(""))
						{
							false2 = "�༶";
							falseZ += false2+"��";
						}
						if(Sno.getText().equals(""))
						{
							false3 = "ѧ��";
							falseZ += false3+"��";
						}
						if(Sname.getText().equals(""))
						{
							false4 = "����";
							falseZ += false4+"��";
						}	
						if(Sblog.getText().equals(""))
						{
							false5 = "���͵�ַ";
							falseZ += false5;
						}
						
						JFrame J = new JFrame("������Ϣ");
						JButton but1=new JButton("�������");
						JButton but2=new JButton("ȡ��");
						J.setLayout(null);
						JLabel L = new JLabel(falseZ+"��������ֵ����Ϊ��");
						but1.setBounds(50, 200,110,40);
						but1.setFont(f2);
						but2.setBounds(260, 200,110,40);
						but2.setFont(f2);
						L.setBounds(30, -5, 400, 200);
						J.setSize(480, 300);
						J.setLocation(520, 180);
						J.setFont(f1);
						L.setFont(new Font("����",1,15));
						J.add(L);
						J.add(but1);
						J.add(but2);
						J.setVisible(true);
						
						but1.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0){
								if(arg0.getSource()==but1)
								{
									J.setVisible(false);
									frame.setVisible(true);
								}	
							}		
						});
						but2.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0){
								if(arg0.getSource()==but2)
								{
									J.setVisible(false);
									frame.setVisible(false);
								}
							}
						});
					}
					else
					{
						frame.setVisible(false);
						Connection conn = null;
						Statement stmt = null;
						
						try
						{
							Class.forName("con.mysql.jdbc.Driver");
						}
						catch(Exception e)
						{
							JFrame J = new JFrame();
							JLabel L = new JLabel("��������ʧ�ܡ�");
							J.add(L);
						}
						
						try
						{
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
							stmt = conn.createStatement();
							String gra = Sgrade.getText();
							String cla = Sclass.getText();
							String num = Sno.getText();
							String name = Sname.getText();
							String blog = Sblog.getText();
							String sql = "Insert into Stu values('"+gra+"','"+cla+"','"+num+"','"+name+"','"+blog+"')";
							int row = stmt.executeUpdate(sql);
							JFrame J = new JFrame("��ӳɹ�");
							
							JButton but1=new JButton("ȷ��");
							JButton but2=new JButton("�������");
							J.setLayout(null);
							JLabel L = new JLabel("��Ϣ�������"+row+"������");
						    but1.setBounds(30, 110,110,30);
						    but1.setFont(f2);
						    but2.setBounds(170, 110,110,30);
						    but2.setFont(f2);
							L.setBounds(55, 5, 200,100);
							L.setFont(new Font("����",1,17));
							J.setSize(320, 220);
							J.setLocation(530, 230);
							J.add(L);
							J.add(but1);
							J.add(but2);
							J.setVisible(true);
							but1.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent arg0)
								{
									if(arg0.getSource()==but1)
									{
										frame.setVisible(false);
										J.setVisible(false);
									}
								}
							});
							but2.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent arg0)
								{
									if(arg0.getSource()==but2)
									{
										frame.setVisible(false);
										J.setVisible(false);
										add1();
									}
								}
							});
						}
						catch(Exception e)
						{
							JFrame J = new JFrame();
							JLabel L = new JLabel("���ݿ�������̷������쳣��");
							J.add(L);
						}
						
						try
						{
							stmt.close();
							conn.close();
						}
						catch(Exception e)
						{
							JFrame J = new JFrame();
							JLabel L = new JLabel("�ر����ݿ����ӷ����쳣��");
							J.add(L);
						}
					}
				}
			}
		});
		
		
		e2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e2)
				{
					frame.setVisible(false);
				}
			}
		});
	}
}
	