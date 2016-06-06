package bag;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class FirstInterface extends JFrame
{
   public  FirstInterface()
   {
	   //设置标题
	   super("欢迎来到博客管理系统");
	   //设置大小
	   setSize(900, 506);
	   //设置位置
	   setLocation(230, 80);
	   //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
	   String path = "FirstBG.jpg";
	   // 背景图片
	   ImageIcon background = new ImageIcon(path);
	   // 把背景图片显示在一个标签里面
	   JLabel label = new JLabel(background);
	   // 把标签的大小位置设置为图片刚好填充整个面板
	   label.setBounds(0, 0, this.getWidth(), this.getHeight());
	   // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
	   JPanel imagePanel = (JPanel) this.getContentPane();
	   imagePanel.setOpaque(false);
	   // 把背景图片添加到分层窗格的最底层作为背景
	   imagePanel.setLayout(null);
	   
	   
	   JButton e1 =new JButton("开始");
	   JButton e2 =new JButton("使用说明");
	   JButton e3 =new JButton("制作人员");
	   JButton e4 =new JButton("退出");
	   e1.setBounds(50, 40, 160, 50);
	   e2.setBounds(50, 160, 160, 50);//横坐标，纵坐标，长度，宽度
	   e3.setBounds(50, 280, 160, 50);
	   e4.setBounds(50, 400, 160, 50);
	   e1.setBackground(Color.decode("#CDBE70"));
	   e2.setBackground(Color.decode("#CDBE70"));
	   e3.setBackground(Color.decode("#CDBE70"));
	   e4.setBackground(Color.decode("#CDBE70"));
	   
	   e1.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent arg0){
			   if(arg0.getSource()==e1){
				   new SecondInterface();
				   imagePanel.setVisible(false);
				   }
			   }
		   });
	   
	   e2.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent arg0){
			   if(arg0.getSource()==e2){
				   JFrame frame =new JFrame("制作人员");
				   JTextArea jta=new JTextArea(3,20);
				   jta.setLineWrap(true);
				   @SuppressWarnings("unused")
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
				   jta.setForeground(Color.red);
				   //jta.setBackground(Color.black);
				   frame.add(jta);
				   
				   frame.setSize(500, 400);
				   frame.setLocation(585, 110);
				   frame.setVisible(true);
				   }
			   }
			});
	   
	   e3.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent arg0){
			   if(arg0.getSource()==e3){
				   JFrame frame =new JFrame("制作人员");
				   JTextArea jta=new JTextArea(3,20);
				   jta.setLineWrap(true);
				   @SuppressWarnings("unused")
				JScrollPane scr= new JScrollPane(jta,
						   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				   jta.setText("制作小组：卡密様 \n 组内成员：刘洋、祖浩然  \n使用语言：Java、sql\n使用软件：eclipse、mysql");
				   jta.setEnabled(false);
				   jta.setForeground(Color.black);
				   jta.setBackground(Color.black);
				   frame.add(jta);
						
				   frame.setSize(500, 400);
				   frame.setLocation(585, 110);
				   frame.setVisible(true);
				   }
			   }
			});
	   
	   e4.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent arg0){
			   if(arg0.getSource()==e4){
				   System.exit(0);
			   	}
			   }
			});
	   
	   imagePanel.add(e1);
	   imagePanel.add(e2);
	   imagePanel.add(e3);
	   imagePanel.add(e4);
			
	   this.getLayeredPane().add(e1, new Integer(Integer.MIN_VALUE));
	   this.getLayeredPane().add(e2, new Integer(Integer.MIN_VALUE));
	   this.getLayeredPane().add(e3, new Integer(Integer.MIN_VALUE));
	   this.getLayeredPane().add(e4, new Integer(Integer.MIN_VALUE));
	   this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	   //设置可见
	   this.setResizable(false); 
	   setVisible(true);
	   //点关闭按钮时退出
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   }

}
