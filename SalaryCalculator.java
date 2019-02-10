import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryCalculator 
{
	static double amt;
	static String hoursWeek;
	
	public static void main(String[] args) 
	{
		
		JFrame myFrame = new JFrame("Salary Calculator");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setBounds(600, 300, 370, 250);
		myFrame.setLayout(null);
		myFrame.setResizable(false);
		
		JLabel hours = new JLabel("Hours/Week");
		hours.setBounds(30, 30, 80, 20);
		myFrame.add(hours);
		
		JLabel rate = new JLabel("Hourly Rate");
		rate.setBounds(30, 60, 80, 20);
		myFrame.add(rate);
		
		JTextField hoursTxt = new JTextField("");
		hoursTxt.setBounds(130, 30, 200, 20);
		myFrame.add(hoursTxt);
		
		JTextField rateTxt = new JTextField("");
		rateTxt.setBounds(130, 60, 200, 20);
		myFrame.add(rateTxt);
		
		JCheckBox box = new JCheckBox("Full Time");
		box.setBounds(30, 100, 100, 20);
		myFrame.add(box);
		box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				hoursWeek = "40";
				hoursTxt.setText("");
				if(box.isSelected())
				{
					hoursTxt.setEnabled(false);
				}
				else
				{
					hoursTxt.setEnabled(true);
				}
			}
		});
		
		JLabel salary = new JLabel("Annual Salary: $ ");
		salary.setBounds(30, 150, 500, 30);
		myFrame.add(salary);
		
		
		
		JButton calculate = new JButton("Calculate");
		calculate.setSize(new Dimension(100, 30));
		calculate.setLocation(new Point(180, 100));
		myFrame.add(calculate);
		calculate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rateTxt.getText().equals("") || (!box.isSelected() && hoursTxt.getText().equals("")) || !isNumeric(rateTxt.getText()) ||
						!isNumeric(hoursTxt.getText())||(Double.parseDouble(hoursTxt.getText()) > 168))
				{
					
				}
				else
				{
					if(!box.isSelected())
					{
						hoursWeek = hoursTxt.getText();
					}
					amt = Double.parseDouble(hoursWeek) * Double.parseDouble(rateTxt.getText()) * 52;
					DecimalFormat df = new DecimalFormat("#.##");
					amt = Double.parseDouble(df.format(amt));
					salary.setText("Annual Salary: $ " + amt);
				}
			}
		});
		myFrame.setVisible(true);
	}
	
	private static boolean isNumeric(String str) 
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}

}

