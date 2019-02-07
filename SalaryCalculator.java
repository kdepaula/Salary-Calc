import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryCalculator 
{
	
	public static void main(String[] args) 
	{
		JFrame myFrame = new JFrame();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setBounds(600, 300, 600, 400);
		myFrame.setLayout(null);
		
		JLabel hours = new JLabel("Hours/Week");
		hours.setBounds(30, 20, 80, 20);
		myFrame.add(hours);
		
		JLabel rate = new JLabel("Hourly Rate");
		rate.setBounds(30, 60, 80, 20);
		
		JTextField hoursTxt = new JTextField();
		hoursTxt.setBounds(200, 30, 300, 20);
		myFrame.add(hoursTxt);
		
		JTextField rateTxt = new JTextField();
		rateTxt.setBounds(200, 60, 300, 20);
		myFrame.add(rateTxt);
		
		JCheckBox box = new JCheckBox();
		box.setBounds(30, 100, 10, 10);
		myFrame.add(box);
		
		JLabel salary = new JLabel("Annual Salary: $ ");
		
		
		JButton calculate = new JButton("Calculate");
		calculate.setSize(new Dimension(100, 30));
		calculate.setLocation(new Point(230, 100));
		myFrame.add(calculate);
		calculate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				int amt;
				amt = Double.parseDouble(hoursTxt.getText()) * Double.parseDouble(rateTxt.getText()) * 52;
				salary.setText("Annual Salary: $ " + amt);
				
			}
		});
		myFrame.setVisible(true);
	}

}

