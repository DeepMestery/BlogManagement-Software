package bag;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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
		JFrame frame =new JFrame("打分确认");
		frame.setLayout(null);
		JLabel Label= new JLabel("是否要进行学生博客打分");
		JButton but1= new JButton("是");
		JButton but2= new JButton("否");
		Label.setBounds(55, 12, 200,100);
		
		Font f1=new Font("楷体",Font.BOLD,17);
		Font f2=new Font("楷体",Font.BOLD,15);

	    but1.setBounds(40, 110,90,30);
	    but1.setFont(f2);
	    but2.setBounds(160, 110,90,30);
	    but2.setFont(f2);
		Label.setBounds(50, 5, 200,100);
		Label.setFont(f1);
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
		
		
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
		JFrame frame =new JFrame("年级筛选");
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("确定");
		but1.setFont(new Font("楷体",1,14));
		JButton but2=new JButton("取消");
		but2.setFont(new Font("楷体",1,14));
		JButton but3=new JButton("返回");
		but3.setFont(new Font("楷体",1,14));
    	frame.setLayout(null);
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
		
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
        			frame.setVisible(false);
        		}
        	}
        });
        
        b1.setBounds(70, 10, 180,60);
        but1.setBounds(5, 120, 80,30);
        but2.setBounds(105, 120, 80,30); 
        but3.setBounds(205, 120, 80,30); 
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
		JFrame frame=new JFrame("班级筛选");
		JComboBox b2=null;
		Container cont=frame.getContentPane();
		JButton but1=new JButton("确定");
		but1.setFont(new Font("楷体",1,14));
		JButton but2=new JButton("取消");
		but2.setFont(new Font("楷体",1,14));
		JButton but3=new JButton("返回");
		but3.setFont(new Font("楷体",1,14));
		frame.setLayout(null);
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
	
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
					LabelGrade();
				}
			}
		});

        b2.setBounds(70, 10, 180,60);
        but1.setBounds(5, 120, 80,30);
        but2.setBounds(105, 120, 80,30); 
        but3.setBounds(205, 120, 80,30);
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void LabelNumber()
	{
		JFrame frame =new JFrame("学号筛选");
		Container cont=frame.getContentPane();
		JComboBox b3=null;
		JButton but1=new JButton("确定");
		but1.setFont(new Font("楷体",1,14));
		JButton but2=new JButton("取消");
		but2.setFont(new Font("楷体",1,14));
		JButton but3=new JButton("返回");
		but3.setFont(new Font("楷体",1,14));
		frame.setLayout(null);
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
		
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
						frame.setVisible(false);
			    	}
			    	else
			    	{
			    		String sql="select * from Stu where Sno='"+sno+"'";
			    		FunMark(sql);
						frame.setVisible(false);

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

        b3.setBounds(70, 10, 180,60);
        but1.setBounds(5, 120, 80,30);
        but2.setBounds(105, 120, 80,30); 
        but3.setBounds(205, 120, 80,30); 
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
	    JLabel lname =new JLabel("博文名称");
	    lname.setFont(new Font("楷体",1,14));
	    JLabel lscore =new JLabel("博文分数");
	    lscore.setFont(new Font("楷体",1,14));
	    JTextField tname=new  JTextField(10);
		JTextField tscore=new  JTextField(10);
		Container cont=frame.getContentPane();
		JButton but1=new JButton("提交并继续");
		but1.setFont(new Font("楷体",1,13));
		JButton but2=new JButton("提交并关闭");
		but2.setFont(new Font("楷体",1,13));
		JButton but3=new JButton("不提交");
		but3.setFont(new Font("楷体",1,13));
		frame.setLayout(null);
	   
		but1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0){
			    if(arg0.getSource()==but1)
			    {
			    	String bname=tname.getText();
			    	String bscore=tscore.getText();
			    	FunSubmit(sno,bname,bscore);
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
			    	 String bname=tname.getText();
			    	 String score=tscore.getText();
			    	 FunSubmit(sno,bname,score);
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

		frame.setLocation(980, 250);
	    frame.setSize(390,220);
	    lname.setBounds(30, 5, 160,40);
	    tname.setBounds(110, 5, 200,40);

	    lscore.setBounds(30, 60, 160,40);
	    tscore.setBounds(110, 60, 200,40);
	    
	    but1.setBounds(5, 120, 110,20);
	    but2.setBounds(135, 120,110,20); 
	    but3.setBounds(265, 120,110,20); 
	    cont.add(tname);
	    cont.add(lname);
	    cont.add(tscore);
	    cont.add(lscore);
	    cont.add(but1);
	    cont.add(but2);
	    cont.add(but3);
	    frame.setVisible(true);
	   
	    return null;
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
			JFrame f=new JFrame("查询结果");
			f.setBounds(470, 100, 600, 400);
			JTable table=new JTable(playerInfo,Names);
		    table.setPreferredScrollableViewportSize(new Dimension(600,400));
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
							LabelMark(celsno);
					
						}
				    }
						else return;
				}
			});
			table.addMouseMotionListener(new MouseAdapter(){  
			       public void mouseMoved(MouseEvent e) {
			    	   if(e.getPoint().y!=0)
						{
							table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							table .setToolTipText((String) table.getModel().getValueAt(e.getPoint().y/table.getRowHeight(),4));
						}
			    	   else
			    	   {
			    		   table.setCursor(null);
			    		   table .setToolTipText(null);
			    	   }
			           }  
			       }  
			   );

			
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
	
	public void FunSubmit(String sno,String bname,String score1)
	{
		int score=Integer.parseInt(score1);
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
			stmt = conn.createStatement();
			String sql = "insert into score (sno,bname,bscore)  values( '"+sno+"','"+bname+"',"+score+")";
			int row = stmt.executeUpdate(sql);
			
			JFrame J = new JFrame("评分结果");
			JButton but1=new JButton("确定");
			J.setLayout(null);
			sql = "select sum(bscore) from score where sno = '"+sno+"'";
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next())
    		{
    			score = rs.getInt(1);
    		}
			JLabel L = new JLabel(sno+"的总分为："+score);
		    but1.setBounds(90, 110,110,30);
		    but1.setFont(new Font("楷体",Font.BOLD,16));
			L.setBounds(55, 5, 200,100);
			L.setFont(new Font("楷体",1,17));
			J.setSize(320, 220);
			J.setLocation(530, 230);
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
