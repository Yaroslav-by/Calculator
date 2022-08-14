package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyFrame extends JFrame {

	private JTextField text;
	private double firstDigit;
	private double secondDigit;
	private String operation;
	private boolean isFirstDigitReady = false;
	private boolean isClear = false;
	
	public MyFrame() {
		
		this.setSize(300, 370);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		this.setLayout(new FlowLayout());
		
		JPanel panelText = new JPanel();
		text = new JTextField();
		text.setEditable(false);
		text.setBackground(Color.white);
		text.setPreferredSize(new Dimension(250, 40));
		text.setBorder(new LineBorder(Color.black, 2, true));
		text.setFont(new Font("Palatino", Font.PLAIN, 25));
		panelText.add(text);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setPreferredSize(new Dimension(250, 220));
		panelButtons.setLayout(new GridLayout(4, 4, 10, 10));
		
		JButton b1 = new JButton("1");
		setSettings(b1, true);
		
		JButton b2 = new JButton("2");
		setSettings(b2, true);
		
		JButton b3 = new JButton("3");
		setSettings(b3, true);
		
		JButton bPlus = new JButton("+");
		setSettings(bPlus, false);
		
		JButton b4 = new JButton("4");
		setSettings(b4, true);
		
		JButton b5 = new JButton("5");
		setSettings(b5, true);
		
		JButton b6 = new JButton("6");
		setSettings(b6, true);
		
		JButton bMinus = new JButton("-");
		setSettings(bMinus, false);
		
		JButton b7 = new JButton("7");
		setSettings(b7, true);
		
		JButton b8 = new JButton("8");
		setSettings(b8, true);
		
		JButton b9 = new JButton("9");
		setSettings(b9, true);
		
		JButton bMultiply = new JButton("*");
		setSettings(bMultiply, false);
		
		JButton bCancel = new JButton("C");
		setSettings(bCancel);
		bCancel.addActionListener((e) -> {
			
			text.setText("");
			firstDigit = 0;
			secondDigit = 0;
			operation = null;
			isFirstDigitReady = false;
			isClear = false;
			
		});
		
		JButton b0 = new JButton("0");
		setSettings(b0);
		b0.addActionListener((e) -> {
			
			if (!isFirstDigitReady && !text.getText().equals("")) {
				text.setText(text.getText() + b0.getText());
			} else {
				if (!isClear) {
					text.setText(b0.getText());
					isClear = true;
				} else {
					text.setText(text.getText() + b0.getText());
				}
			}
			
//			if (!text.getText().equals("")) {
//				text.setText(text.getText() + b0.getText());
//			}
			
		});
		
		JButton bEqual = new JButton("=");
		setSettings(bEqual);
		bEqual.addActionListener((e) -> {
			
			secondDigit = Double.parseDouble(text.getText());
			try {				
				switch (operation) {
					case("+"):
						firstDigit = firstDigit + secondDigit;
						text.setText(Double.toString(firstDigit));
						isClear = false;
						break;
					case("-"):
						firstDigit = firstDigit - secondDigit;
						text.setText(Double.toString(firstDigit));
						isClear = false;
						break;
					case("*"):
						firstDigit = firstDigit * secondDigit;
						text.setText(Double.toString(firstDigit));
						isClear = false;
						break;
					case("/"):
						if (secondDigit == 0) {
							throw new ArithmeticException();
						} else {
							firstDigit = firstDigit / secondDigit;
							text.setText(Double.toString(firstDigit));
							isClear = false;
							break;
						}
				}	
			} catch (ArithmeticException E) {
				text.setText("Error! Division by zero!");
			}
			
		});
		
		JButton bDivide = new JButton("/");
		setSettings(bDivide, false);

		panelButtons.add(b1);
		panelButtons.add(b2);
		panelButtons.add(b3);
		panelButtons.add(bPlus);
		panelButtons.add(b4);
		panelButtons.add(b5);
		panelButtons.add(b6);
		panelButtons.add(bMinus);
		panelButtons.add(b7);
		panelButtons.add(b8);
		panelButtons.add(b9);
		panelButtons.add(bMultiply);
		panelButtons.add(bCancel);
		panelButtons.add(b0);
		panelButtons.add(bEqual);
		panelButtons.add(bDivide);
		
		this.add(Box.createRigidArea(new Dimension(300, 10)));
		this.add(panelText);
		this.add(Box.createRigidArea(new Dimension(300, 10)));
		this.add(panelButtons);
		this.setVisible(true);
		
	}
	
	private void setSettings(JButton b) {
		b.setBorder(new LineBorder(Color.black, 2, true));
		b.setBackground(Color.lightGray);
		b.setFocusable(false);
		b.setFont(new Font("Palatino", Font.PLAIN, 25));
	}
	
	private void setSettings(JButton b, boolean isDigit) {
		b.setBorder(new LineBorder(Color.black, 2, true));
		b.setBackground(Color.lightGray);
		b.setFocusable(false);
		b.setFont(new Font("Palatino", Font.PLAIN, 25));
		
		if (isDigit) { //By clicking on a digit
			b.addActionListener((e) -> {
				
				if (!isFirstDigitReady) {
					text.setText(text.getText() + b.getText());
				} else {
					if (!isClear) {
						text.setText(b.getText());
						isClear = true;
					} else {
						text.setText(text.getText() + b.getText());
					}
				}
				
			});
			
		} else {	   //By clicking on a symbol
			b.addActionListener((e) -> {
					
				if (!isClear) {
					firstDigit = Double.parseDouble(text.getText());
					operation = b.getText();
					isFirstDigitReady = true;
				}
				
			});
		}
		
	}
}
