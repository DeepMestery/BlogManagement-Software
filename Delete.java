package bag;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Delete 
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

	public String[] Deletemember4(String sql1,String sql2)
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
		
			int row= stmt.executeUpdate(sql2);	
			row+=stmt.executeUpdate(sql1);
			JFrame J = new JFrame("删除成功");
			JButton but1=new JButton("确定");
			JButton but2=new JButton("继续删除");
			J.setLayout(null);
			JLabel L = new JLabel("信息表删除了"+row+"条数据。");
		    but1.setBounds(30, 110,110,30);
		    but1.setFont(new Font("楷体",Font.BOLD,16));
		    but2.setBounds(170, 110,110,30);
		    but2.setFont(new Font("楷体",Font.BOLD,16));
			L.setBounds(55, 5, 200,100);
			L.setFont(new Font("楷体",1,17));
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Delete3()
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
		
		v3=Deletemember3();
		sno=v3[0]; 
		b3=new JComboBox(v3);
		b3.setBorder(BorderFactory.createTitledBorder("学号")); 
		b3.setMaximumRowCount(5);

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
						String sql1="delete  from Stu where Sclass='"+Sclass+"'";
						String sql2 = "delete from score where sno in(select sno from stu where Sclass='"+Sclass+"')";
						Deletemember4(sql1,sql2);
					}
					else
					{
						String sql1="delete  from Stu where Sno='"+sno+"'";
						String sql2 = "delete from score where sno in(select sno from stu where sno='"+sno+"')";
						Deletemember4(sql1,sql2);
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
			public void actionPerformed(ActionEvent arg0)
			{
				if(arg0.getSource()==but3)
				{
					frame.setVisible(false);
					Delete2();
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
			@SuppressWarnings("unused")
			public void WindowClosing(WindowEvent arg0){
				System.exit(1);
			}

		});
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void Delete2()
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
		
		v2=Deletemember2();
		Sclass=v2[0];
		b2=new JComboBox(v2);
		b2.setBorder(BorderFactory.createTitledBorder("班级"));
		b2.setMaximumRowCount(5);
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
						String sql1="delete from Stu where Sgrade ='"+Sgrade+"'";
						String sql2 = "delete from score where sno in(select sno from stu where sgrade='"+Sgrade+"')";
						Deletemember4(sql1,sql2);
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
					Delete1();
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void Delete1()
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
        b1.setMaximumRowCount(5); 
        b1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
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
        				String sql1="delete from Stu";
        				String sql2 = "delete from score";
        				Deletemember4(sql1,sql2);
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
        frame.addWindowFocusListener(new WindowAdapter(){
        	@SuppressWarnings("unused")
        	public void WindowClosing(WindowEvent arg0){
        		System.exit(1);
        	}
        });
	}
	
	public  Delete()
	{
		JFrame frame =new JFrame("删除确认");
		frame.setLayout(null);
		JLabel Label= new JLabel("是否要进行学生信息删除");
		JButton but1= new JButton("是");
		JButton but2= new JButton("否");
		
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
						Delete1();
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
}