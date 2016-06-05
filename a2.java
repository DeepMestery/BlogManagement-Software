package blogManager;

import javax.print.DocFlavor.STRING;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Change 
{
	String Sgrade,Sclass,sno;
	String v1[]=Changemember1();
    String v2[]={"空"};
    String v3[]={"空"};
    public String[] Changemember1()
{
	String Sgra[] = null;
	Connection conn = null;
	Statement stmt = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//查询所有年级----------------------------------------------------
		String sql = "select Sgrade from Stu";
		ResultSet rs = stmt.executeQuery(sql);
		String a[] = new String [100];
		for(int i = 0;i < 100;i++)
		{
			a[i] = "0";
		}
		
		while(rs.next())
		{
			String year = rs.getString(1);
			for(int i = 0;i < 100;i++)
			{
				if(a[i].equals(year))
				{
					break;
				}
				else if(a[i] != "0")
				{
					continue;
				}
				else
				{
					a[i] = year;
					System.out.println(a[i]);
					break;
				}
			}
		}
		
		int count = 0;
		for(int i = 0;i < 100;i++)
		{
			if(a[i] != "0")
			{
				count++;
			}
			else
			{
				break;
			}
		}
		count++;
	    Sgra = new String [count];
		Sgra[0] = "全部";
		for(int i = 1;i < count;i++)
		{
			Sgra[i] = a[i-1];
		}
		
	
			
	}
	catch(Exception e)
	{
		System.out.println("加载失败。");
	}
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sgra;
	
};

	public String[] Changemember2()
{
	Connection conn = null;
	Statement stmt = null;
	String Scla[] = null;
	int count = 0;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照年级来查询相应的班级-------------------------------------------------------
		String gra = Sgrade;
		System.out.println(gra);
		String cla;
		
		
			String sql = "select * from Stu where Sgrade = '"+gra+"'";
			ResultSet rs = stmt.executeQuery(sql);
			String[] a = new String[100];
			for(int i = 0;i < 100;i++)
			{
				a[i] = "0";
			}
			
			while(rs.next())
			{
				cla = rs.getString(2);
				for(int i = 0;i < 100;i++)
				{
					if(a[i].equals(cla))
					{
						break;
					}
					else if(a[i] != "0")
					{
						continue;
					}
					else
					{
						a[i] = cla;
						break;
					}
				}
			}
			
			for(int i = 0;i < 100;i++)
			{
				if(a[i] != "0")
				{
					count++;
				}
				else
				{
					break;
				}
			}
			count++;
		    Scla = new String [count];
			Scla[0] = "全部";
			for(int i = 1;i < count;i++)
			{
				Scla[i] = a[i-1];
			}
		
	
	}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
			
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	
	return Scla;
}

	public String[] Changemember4(String sql)
{
	
	Connection conn = null;
	Statement stmt = null;
	String Sno[] = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照班级来查询相应的学号-----------------------------------------------------
		
		
			
			int count = 0;
			String[] a1=new String[100];
			String[] a2=new String[100];
			String[] a3=new String[100];
			String[] a4=new String[100];
			String[] a5=new String[100];
			String[] a6=new String[100];
			ResultSet rs = null;
			
			
			
				rs = stmt.executeQuery(sql);
				
				for(int i = 0;i < 100;i++)
				{
					a1[i] = "0";
					a2[i] = "0";
					a3[i] = "0";
					a4[i] = "0";
					a5[i] = "0";
					a6[i] = "0";
				}
				
				while(rs.next())
				{
					String sgra=rs.getString(1);
					String scla=rs.getString(2);
					String num = rs.getString(3);
					String name=rs.getString(4);
					String blog=rs.getString(5);
					String score=rs.getString(6);
					for(int i = 0;i < 100;i++)
					{
						if(a3[i]==num)
						{
							break;
						}
						else if(a3[i] != "0")
						{
							continue;
						}
						else
						{
							a1[i] = sgra;
							a2[i] =scla;
							a3[i] =num;
							a4[i] =name;
							a5[i] =blog;
							a6[i] =score;
							
							break;
						}
					}
				}
				
				 count = 0;
				for(int i = 0;i < 100;i++)
				{
					if(a3[i] != "0")
					{
						count++;
					}
					else
					{
						break;
					}
				}
				count++;
				
				String Snum[] = new String [count];
                  
				for(int i = 0;i < count;i++)
				{
					Snum[i] = a3[i];
				}
			
			  String[][] a7=new String[count][6];
			  for(int i=0;i<count-1;i++)
				{
				  a7[i][0]=a1[i];
				  a7[i][1]=a2[i];
				  a7[i][2]=a3[i];
				  a7[i][3]=a4[i];
				  a7[i][4]=a5[i];
				  a7[i][5]=a6[i];
				}
			Object[][] playerInfo = a7;
			String[] Names={"年级","班级","学号","姓名","博客地址","分数"};
			JFrame f=new JFrame();
			JTable table=new JTable(playerInfo,Names);
		    table.setPreferredScrollableViewportSize(new Dimension(550,30));
			JScrollPane scrollPane=new JScrollPane(table);
			//==========================================================
			table.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{   
					if(e.getClickCount() == 1)
			    	{
						int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //获得行位置 
						int col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //获得列位置 
						String sgrade=(String)(table.getValueAt(row,0)); 
						String sclass=(String)(table.getValueAt(row,1)); 
						String sno=(String)(table.getValueAt(row,2)); 
						String sname=(String)(table.getValueAt(row,3)); 
						String sblog=(String)(table.getValueAt(row,4)); 
						String score=(String)(table.getValueAt(row,5)); 
						System.out.println(sgrade+sclass+sno+sname+sblog+score+"1");
						if(sgrade==null) sgrade="无";
						if(sclass==null) sgrade="无";
						if(sno==null) sgrade="无";
						if(sname==null) sgrade="无";
						if(sblog==null) sgrade="无";
						if(score==null) sgrade="无";
						Change4(sgrade,sclass,sno,sname,sblog,score);
			    	}
					else return;
				}
			}
			);
			f.getContentPane().add(scrollPane,BorderLayout.CENTER);
			f.setTitle("Simple Table");
			f.pack();
			f.setVisible(true);
			rs.close();
			 
		}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sno;
  }
	
	public String[] Changemember3()
{
	Connection conn = null;
	Statement stmt = null;
	String Sno[] = null ;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照班级来查询相应的学号-----------------------------------------------------
			String cla = Sclass;
			ResultSet rs=null;
			
			if(cla.equals("全部"))
			{
				 Sno = new String [1];
				Sno[0] = "全部";
				/*
				 * 
				 */
			}
			else
			{
				String sql = "select * from Stu where Sclass = '"+cla+"'";
				rs = stmt.executeQuery(sql);
				String a[]=new String[100];
				for(int i = 0;i < 100;i++)
				{
					a[i] = "0";
				}
				
				while(rs.next())
				{
					String num = rs.getString(3);
					for(int i = 0;i < 100;i++)
					{
						if(a[i].equals(num))
						{
							break;
						}
						else if(a[i] != "0")
						{
							continue;
						}
						else
						{
							a[i] = num;
							break;
						}
					}
				}
				
				int count = 0;
				for(int i = 0;i < 100;i++)
				{
					if(a[i] != "0")
					{
						count++;
					}
					else
					{
						break;
					}
				}
				count++;
				System.out.println(count);
				 Sno = new String [count];
				Sno[0] = "全部";
				for(int i = 1;i < count;i++)
				{
					Sno[i] = a[i-1];
					
				}
			}
			
		rs.close();
	}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sno;
  }

@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Change4(String sgrade1,String sclass1,String sno1,String sname1,String sblog1,String score1)
{
	try
	{
		//================================================================
		System.out.println(sgrade1+sclass1+sno1+sname1+sblog1+score1+"2");
	JFrame frame =new JFrame("信息修改界面");
	Container cont=frame.getContentPane();
	JLabel sgra =new JLabel("年级");
	JLabel scla =new JLabel("班级");
	JLabel sn =new JLabel("学号");
	JLabel sna =new JLabel("姓名");
	JLabel sbl =new JLabel("博客地址");
	JLabel sco =new JLabel("分数");
	JTextField sgrade =new JTextField(sgrade1,30);
	JTextField sclass =new JTextField(sclass1,30);
	JTextField sno =new JTextField(sno1,30);
	JTextField sname =new JTextField(sname1,30);
	JTextField sblog =new JTextField(sblog1,30);
	JTextField score =new JTextField(score1,30);
	//==========================================================================
	String gra=sgrade.getText();
	String cla=sclass.getText(); 
	String num=sno.getText(); 
	String name=sname.getText();
	String blog=sblog.getText();
	String sscore=score.getText();
	System.out.println(gra+cla+num+name+blog+sscore+"3");
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	frame.setLayout(null);
	frame.setSize(600, 300);
	frame.setLocation(500,250);
	sgra.setBounds(10, 5, 80, 30);
	scla.setBounds(110,5, 80, 30);
	sn.setBounds(210,5, 80, 30);
	sna.setBounds(310,5, 80, 30);
	sbl.setBounds(410,5, 80, 30);
	sco.setBounds(510,5, 80, 30);
	sgrade.setBounds(10, 50,80, 30);
	sclass.setBounds(110, 50,80,30);
	sno.setBounds(210, 50,80,30);
	sname.setBounds(310, 50,80,30);
	sblog.setBounds(410, 50,80,30);
	score.setBounds(510, 50,80,30);
	but1.setBounds(110, 100,80,30);
	but2.setBounds(310, 100,80,30);
	sn.setEnabled(false);
	cont.add(sgrade);
	cont.add(sclass);
	cont.add(sno);
	cont.add(sname);
	cont.add(sblog);
	cont.add(score);
	cont.add(sgra);
	cont.add(scla);
	cont.add(sn);
	cont.add(sna);
	cont.add(sbl);
	cont.add(sco);
	cont.add(but1);
	cont.add(but2);	
	frame.setVisible(true);
	
	but1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but1){
			    	String gra=sgrade.getText();
			    	String cla=sclass.getText(); 
			    	String num=sno.getText(); 
			    	String name=sname.getText();
			    	String blog=sblog.getText();
			    	String sscore=score.getText();
			    	System.out.println(gra+cla+num+name+blog+sscore+"4");
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
						String sql = "update Stu set Sgrade='"+gra+"',Sclass='"+cla+"',Sno='"+num
								+"',Sname='"+name+"',Blog='"+blog+"',Score='"+sscore+"'where Sno ='"+num+"'";
						int row = stmt.executeUpdate(sql);
						JFrame J = new JFrame();
						JButton but1=new JButton("确定");	
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
	   });
	   but2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but2){
			    	 frame.setVisible(false);
			    }
		    }
	    });  
	}
	catch(Exception e)
	{
		System.out.println(" ");
	}
}

	public void Change3(){
	JFrame frame =new JFrame("条件筛选界面");
	Container cont=frame.getContentPane();
	JComboBox b3=null;
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	JButton but3=new JButton("返回");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v3=Changemember3();
    sno=v3[0]; 
    b3=new JComboBox(v3);
    b3.setBorder(BorderFactory.createTitledBorder("学号")); 
    b3.setMaximumRowCount(3);

   b3.addItemListener(new ItemListener() 
   {
        public void itemStateChanged(ItemEvent e) 
        {
    	    if(e.getStateChange()==ItemEvent.SELECTED)
    	    {
    		    String item=(String)e.getItem();
    		    sno=item;
    	    }
	    }
    
    });

    but1.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but1){
		    	if(sno.equals("全部"))
		    	{
		    		String sql="select * from Stu where Sclass='"+Sclass+"'";
		    		Changemember4(sql);
		    	}
		    	else
		    	{
		    		String sql="select * from Stu where Sno='"+sno+"'";
		    		Changemember4(sql);

		    	}
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
    but3.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but3){
		    	Change2();
		    }
	    }
     }); 
    frame.setSize(300,200);
    b3.setBounds(75, 5, 150,50);
    but1.setBounds(5, 90, 80,20);
    but2.setBounds(105, 90, 80,20); 
    but3.setBounds(205, 90, 80,20); 
    cont.add(b3);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
    frame.addWindowFocusListener(new WindowAdapter(){
	public void WindowClosing(WindowEvent arg0){
	System.exit(1);
}

});
}
	
	public void Change2()
{
	JFrame frame=new JFrame();
	JComboBox b2=null;
	 Container cont=frame.getContentPane();
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	JButton but3=new JButton("返回");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v2=Changemember2();
	 Sclass=v2[0];
	 b2=new JComboBox(v2);
	 b2.setBorder(BorderFactory.createTitledBorder("班级"));
	 b2.setMaximumRowCount(3);
	 b2.addItemListener(new ItemListener() 
	    {
	        public void itemStateChanged(ItemEvent e) 
	        {
	        	if(e.getStateChange()==ItemEvent.SELECTED)
	        	{
	        		String item=(String)e.getItem();
	        		Sclass=item;
	        	}
	    	}
	        
	    });
	 but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1){
                 if(Sclass.equals("全部"))
                 {
                	 String sql="select * from Stu where Sgrade ='"+Sgrade+"'";
                	 Changemember4(sql);
                 }
                 else
                 {
                	 Change3();
                 }
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
	    but3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but3){
					Change1();
				}
			}
		});
	    frame.setSize(300,200);
	    b2.setBounds(75, 5, 150,50);
	    but1.setBounds(5, 90, 80,20);
	    but2.setBounds(105, 90, 80,20); 
	    but3.setBounds(205, 90, 80,20); 
	    cont.add(b2);
	    cont.add(but1);
	    cont.add(but2);
	    cont.add(but3);
	    frame.setVisible(true);
	
	 
    }

	public void Change1(){
		JFrame frame =new JFrame("条件筛选界面");
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("确定");
		JButton but2=new JButton("取消");
		JButton but3=new JButton("返回");
		frame.setLocation(550, 250);
    	frame.setLayout(null);
        Sgrade=v1[0];
        sno=v3[0];
        b1=new JComboBox(v1);   
        b1.setBorder(BorderFactory.createTitledBorder("年级"));  
        b1.setMaximumRowCount(3); 
        b1.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
        	if(e.getStateChange()==ItemEvent.SELECTED)
             	{
        	    	String item=(String)e.getItem();
        		    Sgrade=item;
        		}
    	    }
        });
    
        but1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==but1){
				//==================================================
				if(Sgrade.equals("全部"))
				{
					String sql="select * from Stu";
					Changemember4(sql);
				}
				else
				{
					Change2();
				}
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
    but3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==but3){
				frame.setVisible(false);
			}
		}
	});
    frame.setSize(300,200);
    b1.setBounds(75, 5, 150,50);
    but1.setBounds(5, 90, 80,20);
    but2.setBounds(105, 90, 80,20); 
    but3.setBounds(205, 90, 80,20); 
    cont.add(b1);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
   
  }

	public  Change()
	{
		JFrame frame =new JFrame("条件筛选界面");
		frame.setLayout(null);
		JLabel Label= new JLabel("是否要进行学生信息查询");
		JButton but1= new JButton("是");
		JButton but2= new JButton("否");
		frame.setSize(200, 200);
		frame.setLocation(550, 250);
		Label.setBounds(20, 5, 150,50);
		 but1.setBounds(5, 90, 80,20);
		 but2.setBounds(100, 90, 80,20);
		 but1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					if(arg0.getSource()==but1){
						Change1();
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
		 frame.add(Label);
		 frame.add( but1);
		 frame.add( but2);
		 frame.setVisible(true);
		 
		 
	}	
}

class Delete 
{

	String Sgrade,Sclass,sno;
	String v1[]=Deletemember1();
    String v2[]={"空"};
    String v3[]={"空"};
	
    public String[] Deletemember1()
    {
	String Sgra[] = null;
	Connection conn = null;
	Statement stmt = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//查询所有年级----------------------------------------------------
		String sql = "select Sgrade from Stu";
		ResultSet rs = stmt.executeQuery(sql);
		String a[] = new String [100];
		for(int i = 0;i < 100;i++)
		{
			a[i] = "0";
		}
		
		while(rs.next())
		{
			String year = rs.getString(1);
			for(int i = 0;i < 100;i++)
			{
				if(a[i].equals(year))
				{
					break;
				}
				else if(a[i] != "0")
				{
					continue;
				}
				else
				{
					a[i] = year;
					System.out.println(a[i]);
					break;
				}
			}
		}
		
		int count = 0;
		for(int i = 0;i < 100;i++)
		{
			if(a[i] != "0")
			{
				count++;
			}
			else
			{
				break;
			}
		}
		count++;
	    Sgra = new String [count];
		Sgra[0] = "全部";
		for(int i = 1;i < count;i++)
		{
			Sgra[i] = a[i-1];
		}
		
	
			
	}
	catch(Exception e)
	{
		System.out.println("加载失败。");
	}
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sgra;
	
};

	public String[] Deletemember2()
{
	Connection conn = null;
	Statement stmt = null;
	String Scla[] = null;
	int count = 0;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照年级来查询相应的班级-------------------------------------------------------
		String gra = Sgrade;
		System.out.println(gra);
		String cla;
		
		
			String sql = "select * from Stu where Sgrade = '"+gra+"'";
			ResultSet rs = stmt.executeQuery(sql);
			String[] a = new String[100];
			for(int i = 0;i < 100;i++)
			{
				a[i] = "0";
			}
			
			while(rs.next())
			{
				cla = rs.getString(2);
				for(int i = 0;i < 100;i++)
				{
					if(a[i].equals(cla))
					{
						break;
					}
					else if(a[i] != "0")
					{
						continue;
					}
					else
					{
						a[i] = cla;
						break;
					}
				}
			}
			
			for(int i = 0;i < 100;i++)
			{
				if(a[i] != "0")
				{
					count++;
				}
				else
				{
					break;
				}
			}
			count++;
		    Scla = new String [count];
			Scla[0] = "全部";
			for(int i = 1;i < count;i++)
			{
				Scla[i] = a[i-1];
			}
		
	
	}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
			
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	
	return Scla;
}

	public String[] Deletemember4(String sql)
{
	
	Connection conn = null;
	Statement stmt = null;
	String Sno[] = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照班级来查询相应的学号--------------------------------------------------	
			int row= stmt.executeUpdate(sql);	
			JFrame J = new JFrame();
			JButton but1=new JButton("确定");
			JButton but2=new JButton("继续删除");
			J.setLayout(null);
			JLabel L = new JLabel("数据库中删除了"+row+"条数据。");
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
						J.setVisible(false);
						Delete1();
					}
				}
			});

			 
		}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sno;
  }
	public String[] Deletemember3()
{
	Connection conn = null;
	Statement stmt = null;
	String Sno[] = null ;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照班级来查询相应的学号-----------------------------------------------------
			String cla = Sclass;
			ResultSet rs=null;
			
			if(cla.equals("全部"))
			{
				 Sno = new String [1];
				Sno[0] = "全部";
				/*
				 * 
				 */
			}
			else
			{
				String sql = "select * from Stu where Sclass = '"+cla+"'";
				rs = stmt.executeQuery(sql);
				String a[]=new String[100];
				for(int i = 0;i < 100;i++)
				{
					a[i] = "0";
				}
				
				while(rs.next())
				{
					String num = rs.getString(3);
					for(int i = 0;i < 100;i++)
					{
						if(a[i].equals(num))
						{
							break;
						}
						else if(a[i] != "0")
						{
							continue;
						}
						else
						{
							a[i] = num;
							break;
						}
					}
				}
				
				int count = 0;
				for(int i = 0;i < 100;i++)
				{
					if(a[i] != "0")
					{
						count++;
					}
					else
					{
						break;
					}
				}
				count++;
				System.out.println(count);
				 Sno = new String [count];
				Sno[0] = "全部";
				for(int i = 1;i < count;i++)
				{
					Sno[i] = a[i-1];
					
				}
			}
			
		rs.close();
	}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sno;
  }
@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Delete3(){
	JFrame frame =new JFrame("条件筛选界面");
	Container cont=frame.getContentPane();
	JComboBox b3=null;
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	JButton but3=new JButton("返回");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v3=Deletemember3();
    sno=v3[0]; 
    b3=new JComboBox(v3);
    b3.setBorder(BorderFactory.createTitledBorder("学号")); 
    b3.setMaximumRowCount(3);

   b3.addItemListener(new ItemListener() 
   {
        public void itemStateChanged(ItemEvent e) 
        {
    	    if(e.getStateChange()==ItemEvent.SELECTED)
    	    {
    		    String item=(String)e.getItem();
    		    sno=item;
    	    }
	    }
    
    });

    but1.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but1){
		    	if(sno.equals("全部"))
		    	{
		    		String sql="delete  from Stu where Sclass='"+Sclass+"'";
		    		Deletemember4(sql);
		    	}
		    	else
		    	{
		    		String sql="delete  from Stu where Sno='"+sno+"'";
		    		Deletemember4(sql);

		    	}
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
    but3.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but3){
		    	Delete2();
		    }
	    }
     }); 
    frame.setSize(300,200);
    b3.setBounds(75, 5, 150,50);
    but1.setBounds(5, 90, 80,20);
    but2.setBounds(105, 90, 80,20); 
    but3.setBounds(205, 90, 80,20); 
    cont.add(b3);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
    frame.addWindowFocusListener(new WindowAdapter(){
	public void WindowClosing(WindowEvent arg0){
	System.exit(1);
}

});
}
	

	public void Delete2()
{
	JFrame frame=new JFrame();
	JComboBox b2=null;
	 Container cont=frame.getContentPane();
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	JButton but3=new JButton("返回");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v2=Deletemember2();
	 Sclass=v2[0];
	 b2=new JComboBox(v2);
	 b2.setBorder(BorderFactory.createTitledBorder("班级"));
	 b2.setMaximumRowCount(3);
	 b2.addItemListener(new ItemListener() 
	    {
	        public void itemStateChanged(ItemEvent e) 
	        {
	        	if(e.getStateChange()==ItemEvent.SELECTED)
	        	{
	        		String item=(String)e.getItem();
	        		Sclass=item;
	        	}
	    	}
	        
	    });
	 but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1){
                 if(Sclass.equals("全部"))
                 {
                	 String sql="delete from Stu where Sgrade ='"+Sgrade+"'";
                	 Deletemember4(sql);
                 }
                 else
                 {
                	 Delete3();
                 }
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
	    but3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but3){
					Delete1();
				}
			}
		});
	    frame.setSize(300,200);
	    b2.setBounds(75, 5, 150,50);
	    but1.setBounds(5, 90, 80,20);
	    but2.setBounds(105, 90, 80,20); 
	    but3.setBounds(205, 90, 80,20); 
	    cont.add(b2);
	    cont.add(but1);
	    cont.add(but2);
	    cont.add(but3);
	    frame.setVisible(true);
	
	 
    }

	public void Delete1()
	{
		JFrame frame =new JFrame("条件筛选界面");
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("确定");
		JButton but2=new JButton("取消");
		JButton but3=new JButton("返回");
    	frame.setLayout(null);
    	frame.setLocation(550, 250);
        Sgrade=v1[0];
        sno=v3[0];
        b1=new JComboBox(v1);   
        b1.setBorder(BorderFactory.createTitledBorder("年级"));  
        b1.setMaximumRowCount(3); 
        b1.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
        	if(e.getStateChange()==ItemEvent.SELECTED)
             	{
        	    	String item=(String)e.getItem();
        		    Sgrade=item;
        		}
    	    }
        });
    
        but1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==but1){
				//==================================================
				if(Sgrade.equals("全部"))
				{
					String sql="delete from Stu";
					Deletemember4(sql);
				}
				else
				{
					Delete2();
				}
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
    but3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==but3){
				frame.setVisible(false);
			}
		}
	});
    frame.setSize(300,200);
    b1.setBounds(75, 5, 150,50);
    but1.setBounds(5, 90, 80,20);
    but2.setBounds(105, 90, 80,20); 
    but3.setBounds(205, 90, 80,20); 
    cont.add(b1);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
    frame.addWindowFocusListener(new WindowAdapter(){
    	public void WindowClosing(WindowEvent arg0){
    	System.exit(1);
    }
   
    });
  }
	public  Delete()
	{
		JFrame frame =new JFrame("删除界面");
		frame.setLayout(null);
		JLabel Label= new JLabel("是否要进行学生信息删除");
		JButton but1= new JButton("是");
		JButton but2= new JButton("否");
		frame.setLocation(550, 250);
		frame.setSize(200, 200);
		 Label.setBounds(20, 5, 150,50);
		 but1.setBounds(5, 90, 80,20);
		 but2.setBounds(100, 90, 80,20);
		 but1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					if(arg0.getSource()==but1){
						Delete1();
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
		 frame.add(Label);
		 frame.add( but1);
		 frame.add( but2);
		 frame.setVisible(true);
		 
		 
	}
}

class Select {
	
	String Sgrade,Sclass,sno;
	String v1[]=Checkmember1();
    String v2[]={"空"};
    String v3[]={"空"};
    public String[] Checkmember1()
{
	String Sgra[] = null;
	Connection conn = null;
	Statement stmt = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//查询所有年级----------------------------------------------------
		String sql = "select Sgrade from Stu";
		ResultSet rs = stmt.executeQuery(sql);
		String a[] = new String [100];
		for(int i = 0;i < 100;i++)
		{
			a[i] = "0";
		}
		
		while(rs.next())
		{
			String year = rs.getString(1);
			for(int i = 0;i < 100;i++)
			{
				if(a[i].equals(year))
				{
					break;
				}
				else if(a[i] != "0")
				{
					continue;
				}
				else
				{
					a[i] = year;
					System.out.println(a[i]);
					break;
				}
			}
		}
		
		int count = 0;
		for(int i = 0;i < 100;i++)
		{
			if(a[i] != "0")
			{
				count++;
			}
			else
			{
				break;
			}
		}
		count++;
	    Sgra = new String [count];
		Sgra[0] = "全部";
		for(int i = 1;i < count;i++)
		{
			Sgra[i] = a[i-1];
		}
		
	
			
	}
	catch(Exception e)
	{
		System.out.println("加载失败。");
	}
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sgra;
	
};

	public String[] Checkmember2()
{
	Connection conn = null;
	Statement stmt = null;
	String Scla[] = null;
	int count = 0;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照年级来查询相应的班级-------------------------------------------------------
		String gra = Sgrade;
		System.out.println(gra);
		String cla;
		
		
			String sql = "select * from Stu where Sgrade = '"+gra+"'";
			ResultSet rs = stmt.executeQuery(sql);
			String[] a = new String[100];
			for(int i = 0;i < 100;i++)
			{
				a[i] = "0";
			}
			
			while(rs.next())
			{
				cla = rs.getString(2);
				for(int i = 0;i < 100;i++)
				{
					if(a[i].equals(cla))
					{
						break;
					}
					else if(a[i] != "0")
					{
						continue;
					}
					else
					{
						a[i] = cla;
						break;
					}
				}
			}
			
			for(int i = 0;i < 100;i++)
			{
				if(a[i] != "0")
				{
					count++;
				}
				else
				{
					break;
				}
			}
			count++;
		    Scla = new String [count];
			Scla[0] = "全部";
			for(int i = 1;i < count;i++)
			{
				Scla[i] = a[i-1];
			}
		
	
	}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
			
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	
	return Scla;
}

	public String[] Checkmember4(String sql)
{
	
	Connection conn = null;
	Statement stmt = null;
	String Sno[] = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照班级来查询相应的学号-----------------------------------------------------
		
		
			
			int count = 0;
			String[] a1=new String[100];
			String[] a2=new String[100];
			String[] a3=new String[100];
			String[] a4=new String[100];
			String[] a5=new String[100];
			String[] a6=new String[100];
			ResultSet rs = null;
			
			
			
				rs = stmt.executeQuery(sql);
				
				for(int i = 0;i < 100;i++)
				{
					a1[i] = "0";
					a2[i] = "0";
					a3[i] = "0";
					a4[i] = "0";
					a5[i] = "0";
					a6[i] = "0";
				}
				
				while(rs.next())
				{
					String sgra=rs.getString(1);
					String scla=rs.getString(2);
					String num = rs.getString(3);
					String name=rs.getString(4);
					String blog=rs.getString(5);
					String score=rs.getString(6);
					for(int i = 0;i < 100;i++)
					{
						if(a3[i]==num)
						{
							break;
						}
						else if(a3[i] != "0")
						{
							continue;
						}
						else
						{
							a1[i] = sgra;
							a2[i] =scla;
							a3[i] =num;
							a4[i] =name;
							a5[i] =blog;
							a6[i] =score;
							
							break;
						}
					}
				}
				
				 count = 0;
				for(int i = 0;i < 100;i++)
				{
					if(a3[i] != "0")
					{
						count++;
					}
					else
					{
						break;
					}
				}
				count++;
				
				String Snum[] = new String [count];
                  
				for(int i = 0;i < count;i++)
				{
					Snum[i] = a3[i];
				}
			
			  String[][] a7=new String[count][6];
			  for(int i=0;i<count-1;i++)
				{
				  a7[i][0]=a1[i];
				  a7[i][1]=a2[i];
				  a7[i][2]=a3[i];
				  a7[i][3]=a4[i];
				  a7[i][4]=a5[i];
				  a7[i][5]=a6[i];
				}
			Object[][] playerInfo = a7;
			String[] Names={"年级","班级","学号","姓名","博客地址","分数"};
			JFrame f=new JFrame();
			JTable table=new JTable(playerInfo,Names);
		    table.setPreferredScrollableViewportSize(new Dimension(550,30));
			JScrollPane scrollPane=new JScrollPane(table);
			//==========================================================
			table.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{   
					if(e.getClickCount() == 1)
			    	{
						int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //获得行位置 
						int col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //获得列位置 
						String cellVal=(String)(table.getValueAt(row,col)); 
						if(col==4)
						{
						    String str="cmd /c start iexplore "+cellVal ;
						    try 
						    {
						    	 Runtime.getRuntime().exec(str);
						    }       
						    catch (IOException e1) 
						    {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						    }
						}
			    	}
					else return;
				}
			}
			);
			f.getContentPane().add(scrollPane,BorderLayout.CENTER);
			f.setTitle("Simple Table");
			f.pack();
			f.setVisible(true);
			rs.close();
			 
		}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sno;
  }

	public String[] Checkmember3()
{
	Connection conn = null;
	Statement stmt = null;
	String Sno[] = null ;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照班级来查询相应的学号-----------------------------------------------------
			String cla = Sclass;
			ResultSet rs=null;
			
			if(cla.equals("全部"))
			{
				 Sno = new String [1];
				Sno[0] = "全部";
				/*
				 * 
				 */
			}
			else
			{
				String sql = "select * from Stu where Sclass = '"+cla+"'";
				rs = stmt.executeQuery(sql);
				String a[]=new String[100];
				for(int i = 0;i < 100;i++)
				{
					a[i] = "0";
				}
				
				while(rs.next())
				{
					String num = rs.getString(3);
					for(int i = 0;i < 100;i++)
					{
						if(a[i].equals(num))
						{
							break;
						}
						else if(a[i] != "0")
						{
							continue;
						}
						else
						{
							a[i] = num;
							break;
						}
					}
				}
				
				int count = 0;
				for(int i = 0;i < 100;i++)
				{
					if(a[i] != "0")
					{
						count++;
					}
					else
					{
						break;
					}
				}
				count++;
				System.out.println(count);
				 Sno = new String [count];
				Sno[0] = "全部";
				for(int i = 1;i < count;i++)
				{
					Sno[i] = a[i-1];
					
				}
			}
			
		rs.close();
	}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sno;
  }

@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Select3(){
	JFrame frame =new JFrame("条件筛选界面");
	Container cont=frame.getContentPane();
	JComboBox b3=null;
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	JButton but3=new JButton("返回");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v3=Checkmember3();
    sno=v3[0]; 
    b3=new JComboBox(v3);
    b3.setBorder(BorderFactory.createTitledBorder("学号")); 
    b3.setMaximumRowCount(3);

   b3.addItemListener(new ItemListener() 
   {
        public void itemStateChanged(ItemEvent e) 
        {
    	    if(e.getStateChange()==ItemEvent.SELECTED)
    	    {
    		    String item=(String)e.getItem();
    		    sno=item;
    	    }
	    }
    
    });

    but1.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but1){
		    	if(sno.equals("全部"))
		    	{
		    		String sql="select * from Stu where Sclass='"+Sclass+"'";
			        Checkmember4(sql);
		    	}
		    	else
		    	{
		    		String sql="select * from Stu where Sno='"+sno+"'";
			        Checkmember4(sql);

		    	}
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
    but3.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but3){
			   Select2();
		    }
	    }
     }); 
    frame.setSize(300,200);
    b3.setBounds(75, 5, 150,50);
    but1.setBounds(5, 90, 80,20);
    but2.setBounds(105, 90, 80,20); 
    but3.setBounds(205, 90, 80,20); 
    cont.add(b3);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
    frame.addWindowFocusListener(new WindowAdapter(){
	public void WindowClosing(WindowEvent arg0){
	System.exit(1);
}

});
}
	
	public void Select2()
{
	JFrame frame=new JFrame();
	JComboBox b2=null;
	 Container cont=frame.getContentPane();
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	JButton but3=new JButton("返回");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v2=Checkmember2();
	 Sclass=v2[0];
	 b2=new JComboBox(v2);
	 b2.setBorder(BorderFactory.createTitledBorder("班级"));
	 b2.setMaximumRowCount(3);
	 b2.addItemListener(new ItemListener() 
	    {
	        public void itemStateChanged(ItemEvent e) 
	        {
	        	if(e.getStateChange()==ItemEvent.SELECTED)
	        	{
	        		String item=(String)e.getItem();
	        		Sclass=item;
	        	}
	    	}
	        
	    });
	 but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1){
                 if(Sclass.equals("全部"))
                 {
                	 String sql="select * from Stu where Sgrade ='"+Sgrade+"'";
                	 Checkmember4(sql);
                 }
                 else
                 {
                  Select3();
                 }
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
	    but3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but3){
					Select1();
				}
			}
		});
	    frame.setSize(300,200);
	    b2.setBounds(75, 5, 150,50);
	    but1.setBounds(5, 90, 80,20);
	    but2.setBounds(105, 90, 80,20); 
	    but3.setBounds(205, 90, 80,20); 
	    cont.add(b2);
	    cont.add(but1);
	    cont.add(but2);
	    cont.add(but3);
	    frame.setVisible(true);
	
	 
    }

	public void Select1(){
		JFrame frame =new JFrame("条件筛选界面");
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("确定");
		JButton but2=new JButton("取消");
		JButton but3=new JButton("返回");
		frame.setLocation(550, 250);
    	frame.setLayout(null);
        Sgrade=v1[0];
        sno=v3[0];
        b1=new JComboBox(v1);   
        b1.setBorder(BorderFactory.createTitledBorder("年级"));  
        b1.setMaximumRowCount(3); 
        b1.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
        	if(e.getStateChange()==ItemEvent.SELECTED)
             	{
        	    	String item=(String)e.getItem();
        		    Sgrade=item;
        		}
    	    }
        });
    
        but1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==but1){
				//==================================================
				if(Sgrade.equals("全部"))
				{
					String sql="select * from Stu";
					Checkmember4(sql);
				}
				else
				{
				Select2();
				}
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
    but3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==but3){
				frame.setVisible(false);
			}
		}
	});
    frame.setSize(300,200);
    b1.setBounds(75, 5, 150,50);
    but1.setBounds(5, 90, 80,20);
    but2.setBounds(105, 90, 80,20); 
    but3.setBounds(205, 90, 80,20); 
    cont.add(b1);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
   
  }

	public  Select()
	{
		JFrame frame =new JFrame("条件筛选界面");
		frame.setLayout(null);
		JLabel Label= new JLabel("是否要进行学生信息查询");
		JButton but1= new JButton("是");
		JButton but2= new JButton("否");
		frame.setSize(200, 200);
		frame.setLocation(550, 250);
		Label.setBounds(20, 5, 150,50);
		 but1.setBounds(5, 90, 80,20);
		 but2.setBounds(100, 90, 80,20);
		 but1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					if(arg0.getSource()==but1){
						Select1();
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
		 frame.add(Label);
		 frame.add( but1);
		 frame.add( but2);
		 frame.setVisible(true);
		 
		 
	}
}

class Sc 
{
	String Sgrade,Sclass,sno;
	String v1[]=Scmember1();
    String v2[]={"空"};
    String v3[]={"空"};
public String[] Scmember1()
{
	String Sgra[] = null;
	Connection conn = null;
	Statement stmt = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//查询所有年级----------------------------------------------------
		String sql = "select Sgrade from Stu";
		ResultSet rs = stmt.executeQuery(sql);
		String a[] = new String [100];
		for(int i = 0;i < 100;i++)
		{
			a[i] = "0";
		}
		
		while(rs.next())
		{
			String year = rs.getString(1);
			for(int i = 0;i < 100;i++)
			{
				if(a[i].equals(year))
				{
					break;
				}
				else if(a[i] != "0")
				{
					continue;
				}
				else
				{
					a[i] = year;
					System.out.println(a[i]);
					break;
				}
			}
		}
		
		int count = 0;
		for(int i = 0;i < 100;i++)
		{
			if(a[i] != "0")
			{
				count++;
			}
			else
			{
				break;
			}
		}
		count++;
	    Sgra = new String [count];
		Sgra[0] = "全部";
		for(int i = 1;i < count;i++)
		{
			Sgra[i] = a[i-1];
		}
		
	
			
	}
	catch(Exception e)
	{
		System.out.println("加载失败。");
	}
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sgra;
	
};

public String[] Scmember2()
{
	Connection conn = null;
	Statement stmt = null;
	String Scla[] = null;
	int count = 0;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照年级来查询相应的班级-------------------------------------------------------
		String gra = Sgrade;
		System.out.println(gra);
		String cla;
		
		
			String sql = "select * from Stu where Sgrade = '"+gra+"'";
			ResultSet rs = stmt.executeQuery(sql);
			String[] a = new String[100];
			for(int i = 0;i < 100;i++)
			{
				a[i] = "0";
			}
			
			while(rs.next())
			{
				cla = rs.getString(2);
				for(int i = 0;i < 100;i++)
				{
					if(a[i].equals(cla))
					{
						break;
					}
					else if(a[i] != "0")
					{
						continue;
					}
					else
					{
						a[i] = cla;
						break;
					}
				}
			}
			
			for(int i = 0;i < 100;i++)
			{
				if(a[i] != "0")
				{
					count++;
				}
				else
				{
					break;
				}
			}
			count++;
		    Scla = new String [count];
			Scla[0] = "全部";
			for(int i = 1;i < count;i++)
			{
				Scla[i] = a[i-1];
			}
		
	
	}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
			
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	
	return Scla;
}

public void Scmember5(String sno,String score)
{
	Connection conn = null;
	Statement stmt = null;
	System.out.println(score);
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(ClassNotFoundException e1)
	{
		System.out.println("加载驱动失败。");
	}
	
	try
	{
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","MYSQL");
		stmt = conn.createStatement();
		String sql = "select * from Stu where Sno ='"+sno+"'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			String str=rs.getString(3);
			if(sno.equals(str))
			{ 
				String str1=rs.getString(6);
				int oldscore = Integer.parseInt(str1);
				int add = Integer.parseInt(score);
				int newscore = oldscore + add;
				String sss =  Integer.toString(newscore);
				System.out.println(sss);
				sql = "update Stu set Score = '"+sss+"' where Sno = '"+sno+"'";
				int row = stmt.executeUpdate(sql);
			    Sc5();
			}
		}
		rs.close();
		
	}
	catch(Exception e)
	{
		System.out.println("数据库操作过程发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch (Exception e) 
	{
		System.out.println("关闭资源过程发生异常。");
	}	

}
public String[] Scmember4(String sql)
{
	
	Connection conn = null;
	Statement stmt = null;
	String Sno[] = null;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照班级来查询相应的学号-----------------------------------------------------
		
		
			int count = 0;
			String[] a1=new String[100];
			String[] a2=new String[100];
			String[] a3=new String[100];
			String[] a4=new String[100];
			String[] a5=new String[100];
			String[] a6=new String[100];
			ResultSet rs = null;
			
			
			
				rs = stmt.executeQuery(sql);
				
				for(int i = 0;i < 100;i++)
				{
					a1[i] = "0";
					a2[i] = "0";
					a3[i] = "0";
					a4[i] = "0";
					a5[i] = "0";
					a6[i] = "0";
				}
				
				while(rs.next())
				{
					String sgra=rs.getString(1);
					String scla=rs.getString(2);
					String num = rs.getString(3);
					String name=rs.getString(4);
					String blog=rs.getString(5);
					String score=rs.getString(6);
					for(int i = 0;i < 100;i++)
					{
						if(a3[i]==num)
						{
							break;
						}
						else if(a3[i] != "0")
						{
							continue;
						}
						else
						{
							a1[i] = sgra;
							a2[i] =scla;
							a3[i] =num;
							a4[i] =name;
							a5[i] =blog;
							a6[i] =score;
							
							break;
						}
					}
				}
				
				 count = 0;
				for(int i = 0;i < 100;i++)
				{
					if(a3[i] != "0")
					{
						count++;
					}
					else
					{
						break;
					}
				}
				count++;
				
				String Snum[] = new String [count];
                  
				for(int i = 0;i < count;i++)
				{
					Snum[i] = a3[i];
				}
			
			  String[][] a7=new String[count][6];
			  for(int i=0;i<count-1;i++)
				{
				  a7[i][0]=a1[i];
				  a7[i][1]=a2[i];
				  a7[i][2]=a3[i];
				  a7[i][3]=a4[i];
				  a7[i][4]=a5[i];
				  a7[i][5]=a6[i];
				}
			Object[][] playerInfo = a7;
			String[] Names={"年级","班级","学号","姓名","博客地址","分数"};
			JFrame f=new JFrame();
			JTable table=new JTable(playerInfo,Names);
		    table.setPreferredScrollableViewportSize(new Dimension(550,30));
			JScrollPane scrollPane=new JScrollPane(table);
			//==========================================================
			table.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{   
					if(e.getClickCount() == 1)
			    	{
						int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //获得行位置 
						int col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //获得列位置 
						String cellVal=(String)(table.getValueAt(row,col)); 
						if(col==4)
						{
						    String str="cmd /c start iexplore "+cellVal ;
						    try 
						    {
						    	 Runtime.getRuntime().exec(str);
						    }       
						    catch (IOException e1) 
						    {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						    }
						   
						    String celsno=(String)(table.getValueAt(row,2));
						    Sc4(celsno);
						}
			    	}
					else return;
				}
			}
			);
			f.getContentPane().add(scrollPane,BorderLayout.CENTER);
			f.setTitle("Simple Table");
			f.pack();
			f.setVisible(true);
			rs.close();
			 
		}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	
	return Sno;
  }
public String[] Scmember3()
{
	Connection conn = null;
	Statement stmt = null;
	String Sno[] = null ;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(Exception e)
	{
		System.out.println("驱动加载失败。");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//按照班级来查询相应的学号-----------------------------------------------------
			String cla = Sclass;
			ResultSet rs=null;
			
			if(cla.equals("全部"))
			{
				 Sno = new String [1];
				Sno[0] = "全部";
				/*
				 * 
				 */
			}
			else
			{
				String sql = "select * from Stu where Sclass = '"+cla+"'";
				rs = stmt.executeQuery(sql);
				String a[]=new String[100];
				for(int i = 0;i < 100;i++)
				{
					a[i] = "0";
				}
				
				while(rs.next())
				{
					String num = rs.getString(3);
					for(int i = 0;i < 100;i++)
					{
						if(a[i].equals(num))
						{
							break;
						}
						else if(a[i] != "0")
						{
							continue;
						}
						else
						{
							a[i] = num;
							break;
						}
					}
				}
				
				int count = 0;
				for(int i = 0;i < 100;i++)
				{
					if(a[i] != "0")
					{
						count++;
					}
					else
					{
						break;
					}
				}
				count++;
				System.out.println(count);
				 Sno = new String [count];
				Sno[0] = "全部";
				for(int i = 1;i < count;i++)
				{
					Sno[i] = a[i-1];
					
				}
			}
			
		rs.close();
	}
	catch(Exception e)
	{
		System.out.println("数据库操作发生异常。");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("关闭资源过程发生异常。");
	}
	return Sno;
  }
public void Sc5(){
	JFrame J = new JFrame();
	JButton but1=new JButton("确定");
	J.setLayout(null);
	JLabel L = new JLabel("提交成功");
	but1.setBounds(40, 110,90,30);
    L.setBounds(70, 5, 200, 100);
	J.setSize(300,200);
    J.setLocation(550, 250);
	J.add(L);
	J.add(but1);
	J.setVisible(true);
	but1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(arg0.getSource()==but1)
			{
				J.setVisible(false);
			}
		}
	});
	
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public String Sc4(String sno)
{
	JFrame frame =new JFrame("打分界面");
	JTextField text=new  JTextField(4);
	Container cont=frame.getContentPane();
	JButton but1=new JButton("提交（停留在该生）");
	JButton but2=new JButton("提交并关闭");
	JButton but3=new JButton("不提交");
	frame.setLayout(null);
	frame.setLocation(1000, 250);
    frame.setSize(360,200);
    text.setBounds(100, 5, 150,50);
    but1.setBounds(5, 90, 160,20);
    but2.setBounds(175, 90, 80,20); 
    but3.setBounds(260, 90, 80,20); 
    cont.add(text);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
   
	but1.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but1){
		    	
		    	String str=text.getText();
		    	Scmember5(sno,str);
		    	frame.setVisible(false);
		    	Sc4(sno);
		    }
		    }
    });
    but2.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but2){
		    	 frame.setVisible(false);
		    	 String str=text.getText();
		    	 Scmember5(sno,str);
		    }
	    }
     });  
    but3.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but3){
			   Sc2();
		    }
	    }
     }); 
    String str=text.getText();
    return str;
}
public void Sc3(){
	JFrame frame =new JFrame("条件筛选界面");
	Container cont=frame.getContentPane();
	
	JComboBox b3=null;
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	JButton but3=new JButton("返回");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v3=Scmember3();
    sno=v3[0]; 
    b3=new JComboBox(v3);
    b3.setBorder(BorderFactory.createTitledBorder("学号")); 
    b3.setMaximumRowCount(3);

   b3.addItemListener(new ItemListener() 
   {
        public void itemStateChanged(ItemEvent e) 
        {
    	    if(e.getStateChange()==ItemEvent.SELECTED)
    	    {
    		    String item=(String)e.getItem();
    		    sno=item;
    	    }
	    }
    
    });

    but1.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but1){
		    	if(sno.equals("全部"))
		    	{
		    		String sql="select * from Stu where Sclass='"+Sclass+"'";
			        Scmember4(sql);
		    	}
		    	else
		    	{
		    		String sql="select * from Stu where Sno='"+sno+"'";
			        Scmember4(sql);

		    	}
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
    but3.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		    if(arg0.getSource()==but3){
			   Sc2();
		    }
	    }
     }); 
    frame.setSize(300,200);
    b3.setBounds(75, 5, 150,50);
    but1.setBounds(5, 90, 80,20);
    but2.setBounds(105, 90, 80,20); 
    but3.setBounds(205, 90, 80,20); 
    cont.add(b3);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
    frame.addWindowFocusListener(new WindowAdapter(){
	public void WindowClosing(WindowEvent arg0){
	System.exit(1);
}

});
}
	

public void Sc2()
{
	JFrame frame=new JFrame();
	JComboBox b2=null;
	 Container cont=frame.getContentPane();
	JButton but1=new JButton("确定");
	JButton but2=new JButton("取消");
	JButton but3=new JButton("返回");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v2=Scmember2();
	 Sclass=v2[0];
	 b2=new JComboBox(v2);
	 b2.setBorder(BorderFactory.createTitledBorder("班级"));
	 b2.setMaximumRowCount(3);
	 b2.addItemListener(new ItemListener() 
	    {
	        public void itemStateChanged(ItemEvent e) 
	        {
	        	if(e.getStateChange()==ItemEvent.SELECTED)
	        	{
	        		String item=(String)e.getItem();
	        		Sclass=item;
	        	}
	    	}
	        
	    });
	 but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1){
                 if(Sclass.equals("全部"))
                 {
                	 String sql="select * from Stu where Sgrade ='"+Sgrade+"'";
                	 Scmember4(sql);
                 }
                 else
                 {
                  Sc3();
                 }
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
	    but3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but3){
					Sc1();
				}
			}
		});
	    frame.setSize(300,200);
	    b2.setBounds(75, 5, 150,50);
	    but1.setBounds(5, 90, 80,20);
	    but2.setBounds(105, 90, 80,20); 
	    but3.setBounds(205, 90, 80,20); 
	    cont.add(b2);
	    cont.add(but1);
	    cont.add(but2);
	    cont.add(but3);
	    frame.setVisible(true);
	
	 
    }

	public void Sc1(){
		JFrame frame =new JFrame("条件筛选界面");
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("确定");
		JButton but2=new JButton("取消");
		JButton but3=new JButton("返回");
		frame.setLocation(550, 250);
    	frame.setLayout(null);
        Sgrade=v1[0];
        sno=v3[0];
        b1=new JComboBox(v1);   
        b1.setBorder(BorderFactory.createTitledBorder("年级"));  
        b1.setMaximumRowCount(3); 
        b1.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent e) 
            {
        	if(e.getStateChange()==ItemEvent.SELECTED)
             	{
        	    	String item=(String)e.getItem();
        		    Sgrade=item;
        		}
    	    }
        });
    
        but1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==but1){
				//==================================================
				if(Sgrade.equals("全部"))
				{
					String sql="select * from Stu";
					Scmember4(sql);
				}
				else
				{
				Sc2();
				}
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
    but3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if(arg0.getSource()==but3){
				frame.setVisible(false);
			}
		}
	});
    frame.setSize(300,200);
    b1.setBounds(75, 5, 150,50);
    but1.setBounds(5, 90, 80,20);
    but2.setBounds(105, 90, 80,20); 
    but3.setBounds(205, 90, 80,20); 
    cont.add(b1);
    cont.add(but1);
    cont.add(but2);
    cont.add(but3);
    frame.setVisible(true);
   
   
   
  }
	public  Sc()
	{
		JFrame frame =new JFrame("条件筛选界面");
		frame.setLayout(null);
		JLabel Label= new JLabel("是否要进行学生博客打分");
		JButton but1= new JButton("是");
		JButton but2= new JButton("否");
		frame.setSize(200, 200);
		frame.setLocation(550, 250);
		 Label.setBounds(20, 5, 150,50);
		 but1.setBounds(5, 90, 80,20);
		 but2.setBounds(100, 90, 80,20);
		 but1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					if(arg0.getSource()==but1){
						Sc1();
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
		 frame.add(Label);
		 frame.add( but1);
		 frame.add( but2);
		 frame.setVisible(true);
		 
		 
	}
}

class add
{
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
		frame.setLayout(new GridLayout(6,2));
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
		frame.setLocation(400, 75);
		frame.setSize(600, 600);
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
						String sql = "Insert into Stu values('"+gra+"','"+cla+"','"+num+"','"+name+"','"+blog+"','0')";
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
//----------------------------------------------------------------------------------
//------------------------------------------------------------------------------

class p2
{	
	public  p2()
	{
		JFrame frame =new JFrame("welcome");
		frame.setLayout(null);
		JLabel t1 =new JLabel("欢迎来到博客管理系统");
		//-----------------------------------
		JButton e1 =new JButton("增加学生信息");
		JButton e2 =new JButton("删除学生信息");
		JButton e3 =new JButton("修改学生信息");
		JButton e4 =new JButton("查询学生信息");
		JButton e5 =new JButton("打分");
		frame.setSize(600, 600);
		frame.setLocation(400, 75);
		t1.setBounds(45,5,150,20);
		e1.setBounds(10, 100, 160, 50);
		e2.setBounds(10, 200, 160, 50);//横坐标，纵坐标，长度，宽度
		e3.setBounds(10, 300, 160, 50);
		e4.setBounds(10, 400, 160, 50);
		e5.setBounds(10, 500, 160, 50);
		//-----------------------------------------------------/
		e1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e1){
				 new	add();
				}
			}
		});
		e2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e2){
					new Delete();
				}
			}
		});
		e3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e3){
					new Change();
				}
			}
		});
		e4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e4){
					new Select();
				}
			}
		});
		e5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e5){
					new Sc();
				}
			}
		});
		
		frame.setSize(600, 600);
		frame.add(t1);
		frame.add(e1);
		frame.add(e2);
		frame.add(e3);
		frame.add(e4);
		frame.add(e5);
		frame.setVisible(true);
	}

}
//-----------------------------------------------------------------------------
//--------------------------------------------------------------------------------
class p1
{
	public p1()
	{
		JFrame frame =new JFrame("welcome");
		frame.setLayout(null);
		JLabel t1 =new JLabel("欢迎来到博客管理系统");
		JButton e1 =new JButton(" 开始");
		JButton e2 =new JButton("使用说明");
		JButton e3 =new JButton("制作人员");
		JButton e4 =new JButton("退出");
		frame.setSize(600, 600);
		frame.setLocation(400, 75);
		t1.setBounds(45,5,150,20);
		e1.setBounds(10, 100, 160, 50);
		e2.setBounds(10, 200, 160, 50);//横坐标，纵坐标，长度，宽度
		e3.setBounds(10, 300, 160, 50);
		e4.setBounds(10, 400, 160, 50);
		
		//-----------------------------------------------------/
		e1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e1){
					new p2();
					frame.setVisible(false);
				}
			}
		});
		e2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e2){
				JFrame frame =new JFrame("使用说明");
				JTextArea jta=new JTextArea(3,20);
				jta.setLineWrap(true);
				JScrollPane scr= new JScrollPane(jta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				jta.setText("   首先感谢各方老师和度娘，在他们的帮助下，我们小组终于将此博客管理软件的基本雏形完成，"
						+ "尽管仍有缺陷和不足，还有几个更强大的功能尚未得到技术保障，但是已能基本满足使用者的需求，达到我们最基本的期待"
						+ "。欢迎使用者能多多提供意见和建议，指出我们的不足，我们会尽力将此软件做得更加尽善尽美。本软件主要具有两大功能："
						+ "\n ① 学生信息管理（包含以下四个功能）：\n a) 增加学生信息：\n   可以向数据库中写入要增加的学生信息，分别要输"
						+ "入该学生的“年级、班级、学号、姓名、博客地址”，输入完成后便可在其他功能中对此学生进行操作。\n b) 修改学生信息："
						+ "\n   可以对数据库中已保存的学生信息进行修改，先通过条件筛选，从而选择出符合条件即要进行修改的对象，之后弹出该学生信息，在想修改的地方进行点击，可进入修改界面，写入数据后，点击确定可进行保存。"
						+ "\n c) 查询学生信息："
						+ "\n   可以对数据库已保存的学生信息进行查询，先通过条件筛选，从而选择出符合条件的对象，之后弹出该学生信息，以表格形式进行查看。"
						+ "\n d) 删除学生信息："
						+ "\n   可以对数据库中已保存的学生信息进行删除，先通过条件筛选，从而选择出符合条件即要进行删除的对象，之后便可直接删除所选对象。"
						+ "\n ②　对学生博客进行评判："
						+ "\n   打分系统："
						+ "\n    可以对数据库中已保存的学生进行打分，先通过条件筛选，选择出符合条件即要进行打分的学生，之后，信息以表格的形式输出"
						+ "，单击要进行评判的博客地址，便可打开相应的博客以及打分框，点击不同的按键可实现不同的结果，分数可保存在数据库中。");
				jta.setEnabled(false);
				jta.setForeground(Color.black);
				jta.setBackground(Color.black);
				frame.add(jta);
		
				frame.setSize(300, 300);
				frame.setLocation(550, 250);
				frame.setVisible(true);
				
				}
			}
		});
		e3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e3){
					JFrame frame =new JFrame("制作人员");
					JTextArea jta=new JTextArea(3,20);
					jta.setLineWrap(true);
					JScrollPane scr= new JScrollPane(jta,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					jta.setText("制作小组：卡密様 \n 组内成员：刘洋、祖浩然  \n使用语言：Java、sql\n使用软件：eclipse、mysql");
					jta.setEnabled(false);
					jta.setForeground(Color.black);
					jta.setBackground(Color.black);
					frame.add(jta);
					
					frame.setSize(300, 300);
					frame.setLocation(550, 250);
					frame.setVisible(true);
				}
			}
		});
		e4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e4){
					frame.setVisible(false);
				}
			}
		});
		
		frame.add(t1);
		frame.add(e1);
		frame.add(e2);
		frame.add(e3);
		frame.add(e4);
		frame.setVisible(true);
	}
}

public class a2 
{
	public static void main(String[] args)
	{
		new p1();
	}
}