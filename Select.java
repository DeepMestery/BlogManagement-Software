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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Select {
	
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
		
//��ѯ�����꼶----------------------------------------------------
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
		System.out.println("��������ʧ�ܡ�");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//�����꼶����ѯ��Ӧ�İ༶-------------------------------------------------------
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
			Scla[0] = "ȫ��";
			for(int i = 1;i < count;i++)
			{
				Scla[i] = a[i-1];
			}
		
	
	}
	catch(Exception e)
	{
		
		System.out.println("11���ݿ���������쳣��");
	}
			
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("2");
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
		
//���հ༶����ѯ��Ӧ��ѧ��-----------------------------------------------------
		
		
			
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
			JFrame f=new JFrame();
			JTable table=new JTable(playerInfo,Names);
		    table.setPreferredScrollableViewportSize(new Dimension(550,30));
			JScrollPane scrollPane=new JScrollPane(table);
			
			f.getContentPane().add(scrollPane,BorderLayout.CENTER);
			f.setTitle("��ѯ���");
			f.pack();
			f.setVisible(true);
			rs.close();
			 
		}
	catch(Exception e)
	{
		
		System.out.println("12���ݿ���������쳣��");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{
		System.out.println("3");
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
		
//���հ༶����ѯ��Ӧ��ѧ��-----------------------------------------------------
			String cla = Sclass;
			ResultSet rs=null;
			System.out.println("2");
			if(cla.equals("ȫ��"))
			{
				 Sno = new String [1];
				Sno[0] = "ȫ��";
			}
			else
			{
				System.out.println("3");
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
				System.out.println(count);
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
		
		System.out.println("13���ݿ���������쳣��");
	}
	
	try
	{
		stmt.close();
		conn.close();
	}
	catch(Exception e)
	{System.out.println("4");
		System.out.println("�ر���Դ���̷����쳣��");
	}
	return Sno;
  }

@SuppressWarnings({ "unchecked", "rawtypes" })
public void Select3()
{
	JFrame frame =new JFrame("����ɸѡ����");
	Container cont=frame.getContentPane();
	JComboBox b3=null;
	JButton but1=new JButton("ȷ��");
	JButton but2=new JButton("ȡ��");
	JButton but3=new JButton("����");
	frame.setLayout(null);
	
	v3=Checkmember3();
    sno=v3[0]; 
    b3=new JComboBox(v3);
    b3.setBorder(BorderFactory.createTitledBorder("ѧ��")); 
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
		    	if(sno.equals("ȫ��"))
		    	{
		    		String sql="select sgrade as �꼶,sclass as �༶,stu.sno as ѧ��, sname as ����,Blog as ���͵�ַ,sum(bscore) as �ܷ��� from stu left join score on stu.sno = score.sno group by stu.sno having Sclass='"+Sclass+"'";
			        Checkmember4(sql);
		    	}
		    	else
		    	{
		    		String sql="select bname as ���ı���,bscore as ���ķ��� from score where Sno='"+sno+"'";
			        //****************************************************************
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
		    				ResultSet rs = null;
		    				
		    				
		    				
		    					rs = stmt.executeQuery(sql);
		    					
		    					for(int i = 0;i < 100;i++)
		    					{
		    						a1[i] = "0";
		    						a2[i] = "0";
		    					}
		    					
		    					int times = 0;
		    					while(rs.next())
		    					{
		    						
		    						String bname=rs.getString(1);
		    						String score=Integer.toString(rs.getInt(2));
		    						
		    						a1[times] = bname;
		    						a2[times] =score;
		    						times++;
		    					}
		    					
		    				  String[][] a7=new String[times][2];
		    				  for(int i=0;i<times-1;i++)
		    					{
		    					  a7[i][0]=a1[i];
		    					  a7[i][1]=a2[i];
		    					}
		    				Object[][] playerInfo = a7;
		    				String[] Names={"������Ŀ","���ķ���"};
		    				JFrame f=new JFrame();
		    				JTable table=new JTable(playerInfo,Names);
		    			    table.setPreferredScrollableViewportSize(new Dimension(550,30));
		    				JScrollPane scrollPane=new JScrollPane(table);
		    				
		    				f.getContentPane().add(scrollPane,BorderLayout.CENTER);
		    				f.setTitle(sno+"�ĸ��˷�����");
		    				f.pack();
		    				f.setVisible(true);
		    				rs.close();
		    				 
		    			}
		    		catch(Exception e)
		    		{
		    			System.out.println("14");
		    			System.out.println("���ݿ���������쳣��");
		    		}
		    		
		    		try
		    		{
		    			stmt.close();
		    			conn.close();
		    		}
		    		catch(Exception e)
		    		{
		    			System.out.println("5");
		    			System.out.println("�ر���Դ���̷����쳣��");
		    		}
		    		//*********************************************************************

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
    
	frame.setLocation(550, 250);
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
	JButton but1=new JButton("ȷ��");
	JButton but2=new JButton("ȡ��");
	JButton but3=new JButton("����");
	frame.setLayout(null);
	
	v2=Checkmember2();
	 Sclass=v2[0];
	 b2=new JComboBox(v2);
	 b2.setBorder(BorderFactory.createTitledBorder("�༶"));
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
                 if(Sclass.equals("ȫ��"))
                 {
                	
                	 String sql="select sgrade as �꼶,sclass as �༶,stu.sno as ѧ��, sname as ����,Blog as ���͵�ַ,sum(bscore) as �ܷ��� from stu left join score on stu.sno = score.sno group by stu.sno having Sgrade ='"+Sgrade+"'";
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

		frame.setLocation(550, 250);
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
		JFrame frame =new JFrame("����ɸѡ����");
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("ȷ��");
		JButton but2=new JButton("ȡ��");
		JButton but3=new JButton("����");
		frame.setLocation(550, 250);
    	frame.setLayout(null);
        Sgrade=v1[0];
        sno=v3[0];
        b1=new JComboBox(v1);   
        b1.setBorder(BorderFactory.createTitledBorder("�꼶"));  
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
				if(Sgrade.equals("ȫ��"))
				{
					String sql="select sgrade as �꼶,sclass as �༶,stu.sno as ѧ��, sname as ����,Blog as ���͵�ַ,sum(bscore) as �ܷ��� from stu left join score on stu.sno = score.sno group by stu.sno;";
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
		JFrame frame =new JFrame("����ɸѡ����");
		frame.setLayout(null);
		JLabel Label= new JLabel("�Ƿ�Ҫ����ѧ����Ϣ��ѯ");
		JButton but1= new JButton("��");
		JButton but2= new JButton("��");
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

/*
 * 
 * public void Change4(String sgrade1,String sclass1,String sno1,String sname1,String sblog1,String score1)
{
	try
	{
		//================================================================
		System.out.println(sgrade1+sclass1+sno1+sname1+sblog1+score1+"2");
	JFrame frame =new JFrame("��Ϣ�޸Ľ���");
	Container cont=frame.getContentPane();
	JLabel sgra =new JLabel("�꼶");
	JLabel scla =new JLabel("�༶");
	JLabel sn =new JLabel("ѧ��");
	JLabel sna =new JLabel("����");
	JLabel sbl =new JLabel("���͵�ַ");
	JLabel sco =new JLabel("����");
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
	JButton but1=new JButton("ȷ��");
	JButton but2=new JButton("ȡ��");
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
						JLabel L = new JLabel("��������ʧ�ܡ�");
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
						JButton but1=new JButton("ȷ��");	
						J.setLayout(null);
						JLabel L = new JLabel("���ݿ��и�����"+row+"�����ݡ�");
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
}*/
 /*
  * package bag;

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

public class Change 
{

	String Sgrade,Sclass,sno;
	String v1[]=Changemember1();
    String v2[]={"��"};
    String v3[]={"��"};
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
		System.out.println("��������ʧ�ܡ�");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//��ѯ�����꼶----------------------------------------------------
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
		System.out.println("��������ʧ�ܡ�");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//�����꼶����ѯ��Ӧ�İ༶-------------------------------------------------------
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
		System.out.println("��������ʧ�ܡ�");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//���հ༶����ѯ��Ӧ��ѧ��-----------------------------------------------------
		
		
			
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
			String[] Names={"�꼶","�༶","ѧ��","����","���͵�ַ","����"};
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
						int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //�����λ�� 
						int col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //�����λ�� 
						String sgrade=(String)(table.getValueAt(row,0)); 
						String sclass=(String)(table.getValueAt(row,1)); 
						String sno=(String)(table.getValueAt(row,2)); 
						String sname=(String)(table.getValueAt(row,3)); 
						String sblog=(String)(table.getValueAt(row,4)); 
						String score=(String)(table.getValueAt(row,5)); 
						System.out.println(sgrade+sclass+sno+sname+sblog+score+"1");
						if(sgrade==null) sgrade="��";
						if(sclass==null) sgrade="��";
						if(sno==null) sgrade="��";
						if(sname==null) sgrade="��";
						if(sblog==null) sgrade="��";
						if(score==null) sgrade="��";
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
		System.out.println("��������ʧ�ܡ�");
	}
	
	try
	{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?user=root&password=MYSQL&characterEncoding=utf8&useSSL=true");
		stmt = conn.createStatement();
		
//���հ༶����ѯ��Ӧ��ѧ��-----------------------------------------------------
			String cla = Sclass;
			ResultSet rs=null;
			
			if(cla.equals("ȫ��"))
			{
				 Sno = new String [1];
				Sno[0] = "ȫ��";
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
public void Change4(String sgrade1,String sclass1,String sno1,String sname1,String sblog1,String score1)
{
	try
	{
		//================================================================
		System.out.println(sgrade1+sclass1+sno1+sname1+sblog1+score1+"2");
	JFrame frame =new JFrame("��Ϣ�޸Ľ���");
	Container cont=frame.getContentPane();
	JLabel sgra =new JLabel("�꼶");
	JLabel scla =new JLabel("�༶");
	JLabel sn =new JLabel("ѧ��");
	JLabel sna =new JLabel("����");
	JLabel sbl =new JLabel("���͵�ַ");
	JLabel sco =new JLabel("����");
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
	JButton but1=new JButton("ȷ��");
	JButton but2=new JButton("ȡ��");
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
						JLabel L = new JLabel("��������ʧ�ܡ�");
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
						JButton but1=new JButton("ȷ��");	
						J.setLayout(null);
						JLabel L = new JLabel("���ݿ��и�����"+row+"�����ݡ�");
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
	JFrame frame =new JFrame("����ɸѡ����");
	Container cont=frame.getContentPane();
	JComboBox b3=null;
	JButton but1=new JButton("ȷ��");
	JButton but2=new JButton("ȡ��");
	JButton but3=new JButton("����");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v3=Changemember3();
    sno=v3[0]; 
    b3=new JComboBox(v3);
    b3.setBorder(BorderFactory.createTitledBorder("ѧ��")); 
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
		    	if(sno.equals("ȫ��"))
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
	JButton but1=new JButton("ȷ��");
	JButton but2=new JButton("ȡ��");
	JButton but3=new JButton("����");
	frame.setLayout(null);
	frame.setLocation(550, 250);
	v2=Changemember2();
	 Sclass=v2[0];
	 b2=new JComboBox(v2);
	 b2.setBorder(BorderFactory.createTitledBorder("�༶"));
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
                 if(Sclass.equals("ȫ��"))
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
		JFrame frame =new JFrame("����ɸѡ����");
		Container cont=frame.getContentPane();
		JComboBox b1=null;
		JButton but1=new JButton("ȷ��");
		JButton but2=new JButton("ȡ��");
		JButton but3=new JButton("����");
		frame.setLocation(550, 250);
    	frame.setLayout(null);
        Sgrade=v1[0];
        sno=v3[0];
        b1=new JComboBox(v1);   
        b1.setBorder(BorderFactory.createTitledBorder("�꼶"));  
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
				if(Sgrade.equals("ȫ��"))
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
		JFrame frame =new JFrame("����ɸѡ����");
		frame.setLayout(null);
		JLabel Label= new JLabel("�Ƿ�Ҫ����ѧ����Ϣ��ѯ");
		JButton but1= new JButton("��");
		JButton but2= new JButton("��");
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
}*/
  */