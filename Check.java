package bag;

import java.awt.BorderLayout;
import java.awt.Container;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Check {
	
	String Sgrade,Sclass,sno;
	String v1[]=Checkmember1();
    String v2[]={"��"};
    String v3[]={"��"};
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
    		System.out.println("��������ʧ�ܡ�");
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
    		Sgra[0] = "ȫ��";
    		for(int i = 1;i < count;i++)
    		{
    			Sgra[i] = a[i-1];
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("����ʧ�ܡ�");
    	}
    	try
    	{
    		stmt.close();
    		conn.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println("�ر���Դ���̷����쳣��");
    	}	
    	return Sgra;
    }

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
			System.out.println("��������ʧ�ܡ�");
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
			Scla[0] = "ȫ��";
			for(int i = 1;i < count;i++)
			{
				Scla[i] = a[i-1];
			}
		}
		catch(Exception e)
		{
			System.out.println("���ݿ���������쳣��");
		}
			
		try
		{
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("�ر���Դ���̷����쳣��");
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
			System.out.println("��������ʧ�ܡ�");
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
				String score=Integer.toString(rs.getInt(6));
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
			String[] Names={"�꼶","�༶","ѧ��","����","���͵�ַ","�ܷ���"};
			JFrame f=new JFrame("��ѯ���");
			f.setBounds(470, 100, 600, 400);
			JTable table=new JTable(playerInfo,Names);
		    table.setPreferredScrollableViewportSize(new Dimension(600,400));
			JScrollPane scrollPane=new JScrollPane(table);
			
			f.getContentPane().add(scrollPane,BorderLayout.CENTER);
			f.pack();
			f.setVisible(true);
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("���ݿ���������쳣��");
		}
	
		try
		{
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("�ر���Դ���̷����쳣��");
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
			System.out.println("��������ʧ�ܡ�");
		}
		
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
			stmt = conn.createStatement();
		
			String cla = Sclass;
			ResultSet rs=null;
			if(cla.equals("ȫ��"))
			{
				Sno = new String [1];
				Sno[0] = "ȫ��";
			}
			else
			{
				String sql = "select sgrade as �꼶,sclass as �༶,stu.sno as ѧ��, sname as ����,Blog as ���͵�ַ,sum(bscore) as �ܷ��� from stu left join score on stu.sno = score.sno group by stu.sno having Sclass = '"+cla+"'";
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
				Sno[0] = "ȫ��";
				for(int i = 1;i < count;i++)
				{
					Sno[i] = a[i-1];
				}
			}
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("���ݿ���������쳣��");
		}
	
		try
		{
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("�ر���Դ���̷����쳣��");
		}
		return Sno;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void Check3()
	{
		JFrame frame =new JFrame("ѧ��ɸѡ");
		Container cont=frame.getContentPane();
		JComboBox b3=null;
		JButton but1=new JButton("ȷ��");
		but1.setFont(new Font("����",1,14));
		JButton but2=new JButton("ȡ��");
		but2.setFont(new Font("����",1,14));
		JButton but3=new JButton("����");
		but3.setFont(new Font("����",1,14));
		frame.setLayout(null);
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
		
		v3=Checkmember3();
		sno=v3[0]; 
		b3=new JComboBox(v3);
		b3.setBorder(BorderFactory.createTitledBorder("ѧ��")); 
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
					if(sno.equals("ȫ��"))
					{
						String sql="select sgrade as �꼶,sclass as �༶,stu.sno as ѧ��, sname as ����,Blog as ���͵�ַ,sum(bscore) as �ܷ��� from stu left join score on stu.sno = score.sno group by stu.sno having Sclass='"+Sclass+"'";
						Checkmember4(sql);
						frame.setVisible(false);
					}
					else
					{
						String sql="select bno as ������� , bname as ���ı���,bscore as ���ķ��� from score where Sno='"+sno+"'";
						Connection conn = null;
						Statement stmt = null;
						String Sno[] = null;
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
						}
						catch(Exception e)
						{
							System.out.println("��������ʧ�ܡ�");
						}	
					
						try
						{
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
							stmt = conn.createStatement();
						
							int count = 0;
							String[] a1=new String[100];
							String[] a2=new String[100];
							String[] a3=new String[100];
							ResultSet rs = null;
							
							rs = stmt.executeQuery(sql);
							for(int i = 0;i < 100;i++)
							{
								a1[i] = "0";
								a2[i] = "0";
								a3[i] = "0";
							}
							int times = 0;
							
							while(rs.next())
							{
								String bno = Integer.toString(rs.getInt(1));
								String bname=rs.getString(2);
								int gscore=rs.getInt(3);
								String bscore=Integer.toString(gscore);
								a1[times] = bno;
								a2[times] = bname;
								a3[times] = bscore;
								times++;
							}
							String[][] a7=new String[times][3];
							for(int i=0;i<times;i++)
							{
								a7[i][0]=a1[i];
								a7[i][1]=a2[i];
								a7[i][2]=a3[i];
							}
							 
							Object[][] playerInfo = a7;
							String[] Names={"�������","������Ŀ","���ķ���"};
							JFrame f=new JFrame(sno+"�ĸ��˳ɼ�");
							f.setBounds(500, 110, 520, 400);
							JTable table=new JTable(playerInfo,Names);
						    table.setPreferredScrollableViewportSize(new Dimension(520,400));
							JScrollPane scrollPane=new JScrollPane(table);
							
		    				
		    				f.getContentPane().add(scrollPane,BorderLayout.CENTER);
		    				f.setTitle(sno+"�ĸ��˷�����");
		    				f.pack();
		    				f.setVisible(true);
		    				rs.close();
						}
						catch(Exception e)
						{
							System.out.println("���ݿ���������쳣��");
						}
		    		
						try
						{
							stmt.close();
							conn.close();
						}
						catch(Exception e)
						{
							System.out.println("�ر���Դ���̷����쳣��");
						}
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
					Check2();
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void Check2()
	{
		JFrame frame=new JFrame("�༶ɸѡ");
		JComboBox b2=null;
		Container cont=frame.getContentPane();
		JButton but1=new JButton("ȷ��");
		but1.setFont(new Font("����",1,14));
		JButton but2=new JButton("ȡ��");
		but2.setFont(new Font("����",1,14));
		JButton but3=new JButton("����");
		but3.setFont(new Font("����",1,14));
		frame.setLayout(null);
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
	
		v2=Checkmember2();
		Sclass=v2[0];
		b2=new JComboBox(v2);
		b2.setBorder(BorderFactory.createTitledBorder("�༶"));
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
					if(Sclass.equals("ȫ��"))
					{
						String sql="select sgrade as �꼶,sclass as �༶,stu.sno as ѧ��, sname as ����,Blog as ���͵�ַ,sum(bscore) as �ܷ��� from stu left join score on stu.sno = score.sno group by stu.sno having Sgrade ='"+Sgrade+"'";
						Checkmember4(sql);
					}
					else
					{
						Check3();
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
					Check1();
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
	public void Check1()
	{
		JFrame frame =new JFrame("�꼶ɸѡ");
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("ȷ��");
		but1.setFont(new Font("����",1,14));
		JButton but2=new JButton("ȡ��");
		but2.setFont(new Font("����",1,14));
		JButton but3=new JButton("����");
		but3.setFont(new Font("����",1,14));
    	frame.setLayout(null);
		frame.setSize(320, 220);
		frame.setLocation(530, 230);
		
        Sgrade=v1[0];
        sno=v3[0];
        b1=new JComboBox(v1);   
        b1.setBorder(BorderFactory.createTitledBorder("�꼶"));  
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
        			if(Sgrade.equals("ȫ��"))
        			{
        				String sql="select sgrade as �꼶,sclass as �༶,stu.sno as ѧ��, sname as ����,Blog as ���͵�ַ,sum(bscore) as �ܷ��� from stu left join score on stu.sno = score.sno group by stu.sno;";
        				Checkmember4(sql);
        			}
        			else
        			{
        				Check2();
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

	public  Check()
	{
		JFrame frame =new JFrame("�鿴ȷ��");
		frame.setLayout(null);
		JLabel Label= new JLabel("�Ƿ�Ҫ����ѧ����Ϣ��ѯ");
		JButton but1= new JButton("��");
		JButton but2= new JButton("��");
		Font f1=new Font("����",Font.BOLD,17);
		Font f2=new Font("����",Font.BOLD,15);
		

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
					Check1();
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

 