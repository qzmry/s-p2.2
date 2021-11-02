package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Calculator {
    private int num;
    private int caler1 = -1;
    private int caler2 = -1;
    private String calor = null;
    private float result = 0;
	JFrame frame = new JFrame("计算器");
	JPanel bJPanel = new JPanel();
	JPanel aPanel = new JPanel(new GridLayout(4, 4, 5, 5));
	JTextField aField = new JTextField(20);
	TextField bField = new TextField(20);
	JButton[] aButtons = new JButton[16];
	public void run(){
		for(int a=0;a<10;a++) {
			aButtons[a] = new JButton(""+a);
		}
		aButtons[10] = new JButton("+");
		aButtons[11] = new JButton("-");
		aButtons[12] = new JButton("*");
		aButtons[13] = new JButton("/");
		aButtons[14] = new JButton(".");
		aButtons[15] = new JButton("=");
		for(int a = 0;a<16;a++) {
			aPanel.add(aButtons[a]);
		}
		for(num = 0;num<16;num++) {
			if(num<10) {
				aButtons[num].setBackground(Color.white);
			}
			else if(num!=15) {
				aButtons[num].setBackground(new Color(232,232,232));
			}
			else {
				aButtons[num].setBackground(new Color(126,192,238));
			}
			aButtons[num].setForeground(Color.black);
			aButtons[num].setBorderPainted(false);
			aButtons[num].setFont(new Font(Font.SERIF, Font.PLAIN, 18));
			aButtons[num].setFocusPainted(false);
			aPanel.add(aButtons[num]);
		}
		
		aField.setEditable(false);
		aField.setFont(new Font("楷体", Font.BOLD, 63));
		aField.setHorizontalAlignment(JTextField.RIGHT);
		aField.setBorder(null);
		aField.setBackground(new Color(181,181,181));
		bJPanel.setLayout(new BorderLayout());
		bJPanel.add(aField);
		
		frame.add(bJPanel,BorderLayout.NORTH);
		frame.add(aPanel,BorderLayout.CENTER);
		aField.setFont(new Font("实验字体",Font.BOLD, 60));
		bField.setFont(new Font("实验字体",Font.BOLD, 20));
		aField.setEditable(false);
		bField.setEditable(false);
		
		
		frame.getContentPane().add("North",bJPanel);
		frame.getContentPane().add("Center",aPanel);
		frame.setLayout(null);
		aPanel.setSize(586, 487);
		aPanel.setLocation(0, 175);
		bJPanel.setSize(586, 175);
	    bJPanel.setLocation(0, 0);
		bJPanel.setBorder(BorderFactory.createMatteBorder(25, 3, 1, 3, new Color(181,181,181)));
		aPanel.setBorder(BorderFactory.createMatteBorder(6, 3, 3, 3, new Color(181,181,181)));
		
		
		//关闭窗口
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//数字
		for(num = 0;num<10;num++) {
			aButtons[num].addActionListener(new ActionListener() {
				int n = num;
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					aField.setText(""+n);
					if(caler1==-1) {
						caler1 = n;
					}
					else {
						caler2 = n;
					}
					if(caler1!=-1&&caler2!=-1&&calor==null) {
						aField.setText("暂只支持一位数运算");
						caler1 = -1;
						caler2 = -1;
						calor = null;
					}
				}
			});
		}
		//符号
		for(num = 0;num<4;num++) {
			aButtons[num+10].addActionListener(new ActionListener() {
			    String nowcalor = aButtons[num+10].getLabel();
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					aField.setText(nowcalor);
					calor = nowcalor;
					if(caler1==-1) {
						aField.setText("语法错误");
						calor = null;
					}
				}
			});
		}
		
		//等号
		aButtons[15].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(calor==null||caler1==-1||caler2==-1) {
					aField.setText("语法错误");
					caler1 = -1;
					caler2 = -1;
					calor = null;
					return;
				}
				switch (calor) {
				case "+":
					result = caler1+caler2;
					aField.setText(""+result);
					break;
				case "-":
					result = caler1-caler2;
					aField.setText(""+result);
					break;
				case "*":
					result = caler1*caler2;
					aField.setText(""+result);
					break;
				case "/":
					result = (float)caler1/caler2;
					aField.setText(""+result);
					break;
				default:
					break;
				}
				caler1 = -1;
				caler2 = -1;
				calor = null;
			}
		});
		
		
		//小数点
		aButtons[14].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aField.setText("功能暂未添加");
			}
		});
		frame.pack();
		frame.setSize(600, 700);
		frame.setLocation(400, 100);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
