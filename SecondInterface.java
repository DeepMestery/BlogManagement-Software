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
		//���ñ���
		super("���͹���ϵͳ");
		//���ô�С
		setSize(900, 506);
		//����λ��
		setLocation(230, 80);
		//����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
		String path = "D:/Work/Java Workspace/BlogManagement/images/SecondBG.jpg";
		// ����ͼƬ
		ImageIcon background = new ImageIcon(path);
		// �ѱ���ͼƬ��ʾ��һ����ǩ����
		JLabel label = new JLabel(background);
		// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		imagePanel.setLayout(null);

		Font f=new Font("����",Font.BOLD,15);
		JButton e1 =new JButton("����ѧ����Ϣ");
		JButton e2 =new JButton("ɾ��ѧ����Ϣ");
		JButton e3 =new JButton("�޸�ѧ����Ϣ");
		JButton e4 =new JButton("��ѯѧ����Ϣ");
		JButton e5 =new JButton("���");
		imagePanel.setSize(600, 600);
		imagePanel.setLocation(400, 75);
	
		e1.setBounds(50, 20, 160, 45);
		e2.setBounds(50, 120, 160, 45);//�����꣬�����꣬���ȣ����
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
