package bag;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
public class add{
	public add()
	{
	    JFrame frame=new JFrame ("添加界面");	    
        JLabel label=new JLabel("是否要进行添加");
	    JButton but1 =new JButton("YES");
	    JButton but2 =new JButton("NO");
	    frame.setLayout(null);
	    but1.setBounds(40, 110,90,30);
	    but2.setBounds(160, 110,90,30);
	    label.setBounds(90, 5, 200, 100);
		frame.setSize(300,200);
	    frame.setLocation(550, 250);
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
		
		JFrame frame =new JFrame("add");
		JLabel t1 =new JLabel("年级");
		JLabel t2 =new JLabel("班级");
		JLabel t3 =new JLabel("学号");
		JLabel t4 =new JLabel("姓名");
		JLabel t5 =new JLabel("博客地址");
		JTextField Sgrade=new JTextField(30);
		JTextField Sclass=new JTextField(30);
		JTextField Sno=new JTextField(30);
		JTextField Sname=new JTextField(30);
		JTextField Sblog=new JTextField(30);
		JButton e1 =new JButton("确定");
		JButton e2 =new JButton("取消");
		frame.setLayout(null);
		t1.setBounds(10, 30, 70, 30);
		t2.setBounds(90, 30, 70, 30);
		t3.setBounds(170, 30,  70, 30);
		t4.setBounds(250, 30,  70, 30);
		t5.setBounds(330, 30,  70, 30);
		Sgrade.setBounds(10, 90,  70, 30);
		Sclass.setBounds(90,90,  70, 30);
		Sno.setBounds(170, 90,  70, 30);
		Sname.setBounds(250, 90,  70, 30);
		Sblog.setBounds(330, 90,  140, 30);
		e1.setBounds(100, 200, 70, 20);
		e2.setBounds(280, 200,  70, 20);
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
		frame.setLocation(580, 125);
		frame.setSize(500, 300);
		frame.setVisible(true);
		
		e1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				if(arg0.getSource()==e1)
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
						JLabel L = new JLabel("加载驱动失败。");
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
						JFrame J = new JFrame();
						JButton but1=new JButton("确定");
						JButton but2=new JButton("继续添加");
						J.setLayout(null);
						JLabel L = new JLabel("数据库中更新了"+row+"条数据。");
						but1.setBounds(40, 110,90,30);
					    but2.setBounds(160, 110,90,30);
					    L.setBounds(70, 5, 200, 100);
						J.setSize(300,200);
					    J.setLocation(550, 250);
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
						JLabel L = new JLabel("数据库操作过程发生的异常。");
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
						JLabel L = new JLabel("关闭数据库连接发生异常。");
						J.add(L);
					}
				}
				}
			}
		);
		e2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(arg0.getSource()==e2)
				{
					frame.setVisible(false);
				}
			}
		});
	}
}
	