package bag;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class SecondInterface extends JFrame
{
	public  SecondInterface()
	{
		//设置标题
		super("博客管理系统");
		//设置大小
		setSize(900, 506);
		//设置位置
		setLocation(230, 80);
		//背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
		String path = "D:/Work/Java Workspace/BlogManagement/images/SecondBG.jpg";
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

		Font f=new Font("楷体",Font.BOLD,15);
		JButton e1 =new JButton("增加学生信息");
		JButton e2 =new JButton("删除学生信息");
		JButton e3 =new JButton("修改学生信息");
		JButton e4 =new JButton("查询学生信息");
		JButton e5 =new JButton("打分");
		imagePanel.setSize(600, 600);
		imagePanel.setLocation(400, 75);
	
		e1.setBounds(50, 20, 160, 45);
		e2.setBounds(50, 120, 160, 45);//横坐标，纵坐标，长度，宽度
		e3.setBounds(50, 220, 160, 45);
		e4.setBounds(50, 320, 160, 45);
		e5.setBounds(50, 420, 160, 45);
		e1.setFont(f);
		e2.setFont(f);
		e3.setFont(f);
		e4.setFont(f);
		e5.setFont(f);
		e1.setBackground(Color.decode("#FFD39B"));
		e2.setBackground(Color.decode("#FFD39B"));
		e3.setBackground(Color.decode("#FFD39B"));
		e4.setBackground(Color.decode("#FFD39B"));
		e5.setBackground(Color.decode("#FFD39B"));
		
		
		e1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e1){
					new	Add();
				}
			}
		});
		e2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(arg0.getSource()==e2){
					new	Delete();
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
					new Check();
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
		
		setVisible(true);
		
		this.getLayeredPane().add(e1, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(e2, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(e3, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(e4, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(e5, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imagePanel.setLayout(null);
		this.setResizable(false); 
		imagePanel.setVisible(true);
	}
	
}
