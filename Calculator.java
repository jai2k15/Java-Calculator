import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame implements ActionListener
{
	JTextField text;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton sum,sub,div,mul;
	JButton del,eq,dot,clr,neg;
	JPanel panel;
	
	Font myFont = new Font("Malgun Gothic",Font.BOLD,25);
	double num1=0,num2=0,result = 0;
	char operator;
	
	public Calculator()
	{
	try{
		text = new JTextField();
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,500);
		//this.setLocation(400,200);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		//Text Field
		text.setBounds(55,40,270,50);
		text.setFont(myFont);
		text.setEditable(false);
		text.setBackground(Color.black);
		text.setForeground(Color.green);
		
		//Buttons
		sum = new JButton("+");
		sub = new JButton("-");
		div = new JButton("/");
		mul = new JButton("x");
		del = new JButton("del");
		eq = new JButton("=");
		clr = new JButton("clear");
		dot = new JButton(".");
		neg = new JButton("(-)");
		
		functionButtons[0] = sum;
		functionButtons[1] = sub;
		functionButtons[2] = div;
		functionButtons[3] = mul;
		functionButtons[4] = del;
		functionButtons[5] = eq;
		functionButtons[6] = clr;
		functionButtons[7] = dot;
		functionButtons[8] = neg;
		
		for(int i=0;i<9;i++)
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for(int i=0;i<10;i++)
		{
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		del.setBounds(55,400,70,45);
		clr.setBounds(135,400,100,45);
		neg.setBounds(265,380,64,50);
		
		//Panel
		panel = new JPanel();
		panel.setBounds(55,100,270,270);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(new Color(205,198,212));
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(sum);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(sub);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(div);
		panel.add(dot);
		panel.add(numberButtons[0]);
		panel.add(eq);
		panel.add(mul);
		
		
		this.add(panel);
		this.add(del);
		this.add(neg);
		this.add(clr);
		this.add(text);
		this.setVisible(true);
		this.getContentPane().setBackground(new Color(202, 188, 188));;
	}catch(Exception e)
	{
		System.out.println(e);
	}	
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<10;i++)
		{
			if(e.getSource()==numberButtons[i])
			{	
				text.setText(text.getText().concat(String.valueOf(i)));	
			}
		}
		if(e.getSource()==dot)
		{	
			text.setText(text.getText().concat("."));	
		}
		if(e.getSource()==sum)
		{	
			num1 = Double.parseDouble(text.getText());
			operator = '+';
			text.setText("");	
		}
		if(e.getSource()==sub)
		{	
			num1 = Double.parseDouble(text.getText());
			operator = '-';
			text.setText("");	
		}
		if(e.getSource()==div)
		{	
			num1 = Double.parseDouble(text.getText());
			operator = '/';
			text.setText("");	
		}
		if(e.getSource()==mul)
		{	
			num1 = Double.parseDouble(text.getText());
			operator = 'x';
			text.setText("");	
		}
		if(e.getSource()==eq)
		{
			num2 = Double.parseDouble(text.getText());
			switch(operator)
			{
				case '+':
					result = num1+num2;
					break;
				case '-':
					result = num1-num2;
					break;
				case 'x':
					result = num1*num2;
					break;
				case '/':
					result = num1/num2;
					break;
			}
			text.setText(String.valueOf(result));
			num1=result;	
		}
		if(e.getSource()==clr)
		{	
			text.setText("");	
		}
		if(e.getSource()==del)
		{	
			String str = text.getText();
			text.setText("");	
			for(int i=0;i<str.length()-1;i++)
			{
				text.setText(text.getText()+str.charAt(i));
			}
		}
		if(e.getSource()==neg)
		{	
			double temp =  Double.parseDouble(text.getText());
			temp *=-1;
			text.setText(String.valueOf(temp));	
		}
		
	}
	public static void main(String ar[])
	{
		new Calculator();
	}
}