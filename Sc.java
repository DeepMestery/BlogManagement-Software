package bag;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Sc 
{
	String Sgrade,Sclass,sno;
	String v1[]=FunGrade();
    String v2[]={"空"};
    String v3[]={"空"};
    
    public  Sc()
	{
		JFrame frame =new JFrame("条件筛选界面");
		frame.setLayout(null);
		JLabel Label= new JLabel("是否要进行学生博客打分");
		JButton but1= new JButton("是");
		JButton but2= new JButton("否");
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
		Label.setBounds(67, 14, 170,70);
		Label.setFont(new java.awt.Font("Dialog", 1, 14));
		but1.setBounds(35, 120, 100,30);
		but2.setBounds(165, 120, 100,30);
		
		but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1)
				{
					LabelGrade();
					frame.setVisible(false);
				}
			}
		});
		
		but2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but2)
				{
						frame.setVisible(false);
				}
			}
		});
		
		 frame.add(Label);
		 frame.add(but1);
		 frame.add(but2);
		 frame.setVisible(true);

	}
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void LabelGrade()
    {
		JFrame frame = new JFrame("条件筛选界面");
    	frame.setLayout(null);
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("确定");
		JButton but2=new JButton("取消");
		JButton but3=new JButton("返回");
		
        Sgrade=v1[0];
        sno=v3[0];
        b1=new JComboBox(v1);
        b1.setBorder(BorderFactory.createTitledBorder("年级"));
        b1.setMaximumRowCount(3);
        
        b1.addItemListener(new ItemListener(){
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
        		if(arg0.getSource()==but1)
        		{
        			if(Sgrade.equals("全部"))
        			{
        				String sql="select * from Stu";
        				FunMark(sql);
        			}
        			else
        			{
        				LabelClass();
        			}
        			frame.setVisible(false);
        		}
        	}
        });
        
        but2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0)
        	{
        		if(arg0.getSource()==but2)
        		{
        			frame.setVisible(false);
        		}
        	}
        });  
        
        but3.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		if(arg0.getSource()==but3)
        		{
        			frame.setVisible(false);
        		}
        	}
        });

		frame.setSize(320, 220);
		frame.setLocation(530, 230);
        b1.setBounds(75, 5, 150,50);
        but1.setBounds(10, 120, 80,20);
        but2.setBounds(120, 120, 80,20);
        but3.setBounds(220, 120, 80,20);
        cont.add(b1);
        cont.add(but1);
        cont.add(but2);
        cont.add(but3);
        frame.setVisible(true);
        
    }

    public String[] FunGrade()
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
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void LabelClass()
    {
    	JFrame frame=new JFrame();
    	JComboBox b2=null;
    	Container cont=frame.getContentPane();
    	JButton but1=new JButton("确定");
    	JButton but2=new JButton("取消");
    	JButton but3=new JButton("返回");
    	frame.setLayout(null);
    	frame.setLocation(550, 250);
    	v2=FunClass();
    	Sclass=v2[0];
    	b2=new JComboBox(v2);
    	b2.setBorder(BorderFactory.createTitledBorder("班级"));
    	b2.setMaximumRowCount(3);
    	b2.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent e){
	        	if(e.getStateChange()==ItemEvent.SELECTED)
	        	{
	        		String item=(String)e.getItem();
	        		Sclass=item;
	        	}
	    	} 
	    });
    	
    	but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1)
				{
					if(Sclass.equals("全部"))
					{
						String sql="select * from Stu where Sgrade ='"+Sgrade+"'";
						FunMark(sql);
					}
					else
					{
						LabelNumber();
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
					LabelGrade();
					frame.setVisible(false);
				}
			}
		});

		frame.setSize(320, 220);
		frame.setLocation(530, 230);
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

	public String[] FunClass()
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
		
			String gra = Sgrade;
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

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	public void LabelNumber()
	{
		JFrame frame =new JFrame("条件筛选界面");
		Container cont=frame.getContentPane();
		
		JComboBox b3=null;
		JButton but1=new JButton("确定");
		JButton but2=new JButton("取消");
		JButton but3=new JButton("返回");
		frame.setLayout(null);
	    
		v3=FunNumber();
	    sno=v3[0]; 
	    b3=new JComboBox(v3);
	    b3.setBorder(BorderFactory.createTitledBorder("学号")); 
	    b3.setMaximumRowCount(3);

	   b3.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent e){
	    	    if(e.getStateChange()==ItemEvent.SELECTED)
	    	    {
	    		    String item=(String)e.getItem();
	    		    sno=item;
	    	    }
		    }
	    });

	    but1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but1)
			    {
			    	if(sno.equals("全部"))
			    	{
			    		String sql="select * from Stu where Sclass='"+Sclass+"'";
				        FunMark(sql);
			    	}
			    	else
			    	{
			    		String sql="select * from Stu where Sno='"+sno+"'";
			    		FunMark(sql);

			    	}
				    frame.setVisible(false);
			    }
		    }
	    });
	    
	    but2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but2)
			    {
			    	 frame.setVisible(false);
			    }
		    }
	    });  
	    
	    but3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but3)
			    {
				   LabelClass();
				   frame.setVisible(false);
			    }
		    }
	    }); 

		frame.setSize(320, 220);
		frame.setLocation(530, 230);
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
	
	public String[] FunNumber()
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
			
			String cla = Sclass;
			ResultSet rs=null;
			
			if(cla.equals("全部"))
			{
				Sno = new String [1];
				Sno[0] = "全部";
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
	
	public String LabelMark(String sno)
	{
		JFrame frame =new JFrame("打分界面");
	    frame.setAlwaysOnTop(true);
		JTextField text=new  JTextField(4);
		Container cont=frame.getContentPane();
		JButton but1=new JButton("提交（停留在该生）");
		JButton but2=new JButton("提交并关闭");
		JButton but3=new JButton("不提交");
		frame.setLayout(null);
	   
		but1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but1)
			    {
			    	String str=text.getText();
			    	FunSubmit(sno,str);
			    	frame.setVisible(false);
			    	LabelMark(sno);
			    }
		    }
	    });
		
	    but2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but2)
			    {
			    	 frame.setVisible(false);
			    	 String str=text.getText();
			    	 FunSubmit(sno,str);
			    }
		    }
	    });  
	    
	    but3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but3){
				   LabelClass();
			    }
		    }
	     }); 

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
	    String str=text.getText();
	    return str;
	}
	
	public String[] FunMark(String sql)
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
			
			int count = 0;
			String[] a1=new String[100];
			String[] a2=new String[100];
			String[] a3=new String[100];
			String[] a4=new String[100];
			String[] a5=new String[100];
			ResultSet rs = null;
				
			rs = stmt.executeQuery(sql);
			for(int i = 0;i < 100;i++)
			{
				a1[i] = "0";
				a2[i] = "0";
				a3[i] = "0";
				a4[i] = "0";
				a5[i] = "0";
			}
					
			while(rs.next())
			{
				String sgra=rs.getString(1);
				String scla=rs.getString(2);
				String num = rs.getString(3);
				String name=rs.getString(4);
				String blog=rs.getString(5);
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
				
			String[][] a7=new String[count][5];
			for(int i=0;i<count-1;i++)
			{
				a7[i][0]=a1[i];
				a7[i][1]=a2[i];
				a7[i][2]=a3[i];
				a7[i][3]=a4[i];
				a7[i][4]=a5[i];
			}
			Object[][] playerInfo = a7;
			String[] Names={"年级","班级","学号","姓名","博客地址"};
			JFrame f=new JFrame();
			JTable table=new JTable(playerInfo,Names);
			table.setPreferredScrollableViewportSize(new Dimension(550,30));
			JScrollPane scrollPane=new JScrollPane(table);
			
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
								e1.printStackTrace();
							}
							String celsno=(String)(table.getValueAt(row,2));
							FunMark(celsno);
						}
				    }
						else return;
				}
			});
			
			f.getContentPane().add(scrollPane,BorderLayout.CENTER);
			f.setTitle("查询结果");
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
	
	public void LabelSubmit()
	{
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
		but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==but1)
				{
					J.setVisible(false);
				}
			}
		});
	}
	
	public void FunSubmit(String sno,String score)
	{
		Connection conn = null;
		Statement stmt = null;
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
					sql = "update Stu set Score = '"+sss+"' where Sno = '"+sno+"'";
					int row = stmt.executeUpdate(sql);
					LabelSubmit();
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

}
