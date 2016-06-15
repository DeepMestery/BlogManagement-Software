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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class FirstInterface extends JFrame
{
   public  FirstInterface()
   {
	   //���ñ���
	   super("��ӭ�������͹���ϵͳ");
	   //���ô�С
	   setSize(900, 506);
	   //����λ��
	   setLocation(230, 80);
	   //����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�
	   String path = "D:/Work/Java Workspace/BlogManagement/images/FirstBG.jpg";
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
	   
	   Font f=new Font("����",Font.BOLD,17);
	   JButton e1 =new JButton("��ʼ");
	   JButton e2 =new JButton("ʹ��˵��");
	   JButton e3 =new JButton("������Ա");
	   JButton e4 =new JButton("�˳�");
	   e1.setBounds(50, 40, 160, 50);
	   e2.setBounds(50, 160, 160, 50);//�����꣬�����꣬���ȣ����
	   e3.setBounds(50, 280, 160, 50);
	   e4.setBounds(50, 400, 160, 50);
	   e1.setFont(f);
	   e2.setFont(f);
	   e3.setFont(f);
	   e4.setFont(f);
	   e1.setBackground(Color.decode("#CDBE70"));
	   e2.setBackground(Color.decode("#CDBE70"));
	   e3.setBackground(Color.decode("#CDBE70"));
	   e4.setBackground(Color.decode("#CDBE70"));
	   
	   e1.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent arg0){
			   if(arg0.getSource()==e1)
			   {
				   new SecondInterface();
				   imagePanel.setVisible(false);
			   }
		   }
	   });
	   
	   e2.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent arg0){
			   if(arg0.getSource()==e2)
			   {
				   JFrame frame =new JFrame("������Ա");
				   JTextArea jta=new JTextArea(3,20);
				   jta.setLineWrap(true);
				   @SuppressWarnings("unused")
				   JScrollPane scr= new JScrollPane(jta,
						   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				   jta.setText("   ���ȸ�л������ʦ�Ͷ�������ǵİ����£�����С�����ڽ��˲��͹�������Ļ������ͣ�"
								+ "��������ȱ�ݺͲ��㣬������һЩ�ؼ��ļ��������£��Ѿ����Ի�������ʹ���ߵ�����"
								+ "����ӭʹ�����ܶ���ṩ����ͽ��飬ָ�����ǵĲ��㣬���ǻᾡ������������ø��Ӿ��ƾ������������Ҫ���������ܣ�"
								+ "\n �� ѧ����Ϣ�������������ĸ����ܣ���\n a) ����ѧ����Ϣ��\n   ���������ݿ���д��Ҫ���ӵ�ѧ����Ϣ���ֱ�Ҫ��"
								+ "���ѧ���ġ��꼶���༶��ѧ�š����������͵�ַ����������ɺ��������������жԴ�ѧ�����в�����\n b) �޸�ѧ����Ϣ��"
								+ "\n   ���Զ����ݿ����ѱ����ѧ����Ϣ�����޸ģ���ͨ������ɸѡ���Ӷ�ѡ�������������Ҫ�����޸ĵĶ���֮�󵯳���ѧ����Ϣ�������޸ĵĵط����е�����ɽ����޸Ľ��棬д�����ݺ󣬵��ȷ���ɽ��б��档"
								+ "\n c) ��ѯѧ����Ϣ��"
								+ "\n   ���Զ����ݿ��ѱ����ѧ����Ϣ���в�ѯ����ͨ������ɸѡ���Ӷ�ѡ������������Ķ���֮�󵯳���ѧ����Ϣ���Ա����ʽ���в鿴��"
								+ "\n d) ɾ��ѧ����Ϣ��"
								+ "\n   ���Զ����ݿ����ѱ����ѧ����Ϣ����ɾ������ͨ������ɸѡ���Ӷ�ѡ�������������Ҫ����ɾ���Ķ���֮����ֱ��ɾ����ѡ����"
								+ "\n �ڡ���ѧ�����ͽ������У�"
								+ "\n   ���ϵͳ��"
								+ "\n    ���Զ����ݿ����ѱ����ѧ�����д�֣���ͨ������ɸѡ��ѡ�������������Ҫ���д�ֵ�ѧ����֮����Ϣ�Ա�����ʽ���"
								+ "������Ҫ�������еĲ��͵�ַ����ɴ���Ӧ�Ĳ����Լ���ֿ򣬵����ͬ�İ�����ʵ�ֲ�ͬ�Ľ���������ɱ��������ݿ��С�");
				   jta.setEnabled(false);
				   jta.setForeground(Color.black);
				   jta.setBackground(Color.black);
				   frame.add(jta);
				   
				   frame.setSize(620, 453);
				   frame.setLocation(500, 120);
				   frame.setVisible(true);
				   }
			   }
			});
	   
	   e3.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent arg0){
			   if(arg0.getSource()==e3){
				   JFrame frame =new JFrame("������Ա");
				   JTextArea jta=new JTextArea(3,20);
				   jta.setLineWrap(true);
				   @SuppressWarnings("unused")
				JScrollPane scr= new JScrollPane(jta,
						   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				   jta.setText("����С�飺���ܘ� \n ���ڳ�Ա���������Ȼ  \nʹ�����ԣ�Java��sql\nʹ�������eclipse��mysql��exe4j");
				   jta.setEnabled(false);
				   jta.setForeground(Color.black);
				   jta.setBackground(Color.black);
				   frame.add(jta);
				   
				   frame.setSize(620, 453);
				   frame.setLocation(500, 120);
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
	   //���ÿɼ�
	   this.setResizable(false); 
	   setVisible(true);
	   //��رհ�ťʱ�˳�
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   }

}