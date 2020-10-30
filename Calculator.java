package com.calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Calculator {
	// FIELDSs USED
	private JFrame frame; // main frame

	private JTextField output = new JTextField(), output1 = new JTextField();// for results

	private String operand1, operator, operand2, pOperand1 = "", pOperand2 = "", pOperator = "";// for storing opr/op

	private JLayeredPane layeredPane = new JLayeredPane();// LAYERED PANE
	private JPanel standardCalc = new JPanel(), programmerCalc = new JPanel(), allconv = new JPanel(),
			about = new JPanel(), settings = new JPanel(), welcome;// LAYARED PANE PANELS

	// STANDARD KEYBOARD BUTTONS
	private JButton btnNewButton_13 = new JButton("9"), btnNewButton_14 = new JButton("/"),
			btnNewButton_15 = new JButton("*"), btnNewButton_16 = new JButton("X^2"),
			btnNewButton_17 = new JButton("0"), btnNewButton_18 = new JButton("."), btnNewButton_19 = new JButton("%"),
			btnNewButton_20 = new JButton("="), btnNewButton_1 = new JButton("1"), btnNewButton_2 = new JButton("2"),
			btnNewButton_3 = new JButton("3"), btnNewButton_4 = new JButton("D"), btnNewButton_5 = new JButton("C"),
			btnNewButton_6 = new JButton("4"), btnNewButton_7 = new JButton("5"), btnNewButton_8 = new JButton("6"),
			btnNewButton_9 = new JButton("+"), btnNewButton_10 = new JButton("-"), btnNewButton_11 = new JButton("7"),
			btnNewButton_12 = new JButton("8");
	// PROGRAMMER KEYBOARD BUTTONS
	private JButton bt5 = new JButton("0"), bt4 = new JButton("1"), btnC = new JButton("C"), bt6 = new JButton("="),
			bt0 = new JButton("+"), bt1 = new JButton("-"), bt2 = new JButton("*"), bt3 = new JButton("/");

	Event e = new Event(); // EVENT HADLER
	private JPanel head, sideMenu;// for HEAD __ SIDE_MENU

	private JLabel lblCalculator, lblConverter, lblTools, lblCalculatorConvertorBeta, lblWelcome;

	private JPanel standardKeyboard = new JPanel(), binaryKeyboard = new JPanel();

	// CONVERSIONS COMPONENTS
	private JComboBox box1 = new JComboBox();
	private JComboBox box2 = new JComboBox();
	private JButton btnCovert = new JButton("Convert");
	//

	private JButton btnQuickTour = new JButton("Quick Tour");

	public static void main(String[] args) {
		new Calculator();

	}

	public Calculator() {
		try {
//			 set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		operand1 = operator = operand2 = "";
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 550, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		// HEAD
		head = new JPanel();
		frame.getContentPane().add(head, BorderLayout.NORTH);
		head.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblImg = new JLabel();
		lblImg.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				changePanel(welcome);
			}
		});
		lblImg.setIcon(new ImageIcon("C:\\Users\\WAYNE\\Pictures\\androidhome.png"));
		lblImg.setForeground(Color.WHITE);
		head.add(lblImg);
		lblCalculatorConvertorBeta = new JLabel("Calculator Convertor beta v.10");
		lblCalculatorConvertorBeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalculatorConvertorBeta.setForeground(Color.WHITE);
		head.add(lblCalculatorConvertorBeta);
		// END OF HEAD

		// SIDE MENU
		sideMenu = new JPanel();
		frame.getContentPane().add(sideMenu, BorderLayout.WEST);
		GridBagLayout gbl_sideMenu = new GridBagLayout();
		gbl_sideMenu.columnWidths = new int[] { 0, 0 };
		gbl_sideMenu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_sideMenu.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_sideMenu.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		sideMenu.setLayout(gbl_sideMenu);
		// sideMenu.setLayout(new GridBagLayout()); pwedi din

//		CALCULATOR
		lblCalculator = new JLabel("Calculator");
		GridBagConstraints gbc_lblCalculator = new GridBagConstraints();
		gbc_lblCalculator.insets = new Insets(0, 0, 5, 0);
		gbc_lblCalculator.gridx = 0;
		gbc_lblCalculator.gridy = 0;
		sideMenu.add(lblCalculator, gbc_lblCalculator);

		JPanel cal = new JPanel();
		GridBagConstraints gbc_cal = new GridBagConstraints();
		gbc_cal.insets = new Insets(0, 0, 5, 0);
		gbc_cal.fill = GridBagConstraints.BOTH;
		gbc_cal.gridx = 0;
		gbc_cal.gridy = 1;
		sideMenu.add(cal, gbc_cal);
		cal.setLayout(new GridLayout(2, 0, 0, 0));

		JMenuItem mntmStandard = new JMenuItem("Standard");
		mntmStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				standardCalculator();
			}
		});
		cal.add(mntmStandard);

		JMenuItem mntmProgrammer = new JMenuItem("Programmer");
		mntmProgrammer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programmerCalculator();
			}
		});
		cal.add(mntmProgrammer);

//		CONVERTER
		lblConverter = new JLabel("Converter");
		GridBagConstraints gbc_lblConverter = new GridBagConstraints();
		gbc_lblConverter.insets = new Insets(0, 0, 5, 0);
		gbc_lblConverter.gridx = 0;
		gbc_lblConverter.gridy = 2;
		sideMenu.add(lblConverter, gbc_lblConverter);

		JPanel con = new JPanel();
		GridBagConstraints gbc_con = new GridBagConstraints();
		gbc_con.insets = new Insets(0, 0, 5, 0);
		gbc_con.fill = GridBagConstraints.BOTH;
		gbc_con.gridx = 0;
		gbc_con.gridy = 3;
		sideMenu.add(con, gbc_con);
		con.setLayout(new GridLayout(2, 0, 0, 0));

		JMenuItem mntmNumberSystems = new JMenuItem("Number Systems");
		mntmNumberSystems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allConversions(new String[] { "Binary", "Decimal", "Octal", "Hexadecimal" });
			}
		});
		con.add(mntmNumberSystems);

		JMenuItem mntmData = new JMenuItem("Data");
		mntmData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allConversions(new String[] { "Bit", "Byte", "KiloByte", "MegaByte", "GegaByte", "TeraByte" });
			}
		});
		con.add(mntmData);
//		CONVERTER ENDS HERE

//		TOOLS
		lblTools = new JLabel("Tools");
		GridBagConstraints gbc_lblTools = new GridBagConstraints();
		gbc_lblTools.insets = new Insets(0, 0, 5, 0);
		gbc_lblTools.gridx = 0;
		gbc_lblTools.gridy = 4;
		sideMenu.add(lblTools, gbc_lblTools);

		JPanel tools = new JPanel();
		GridBagConstraints gbc_tools = new GridBagConstraints();
		gbc_tools.fill = GridBagConstraints.BOTH;
		gbc_tools.gridx = 0;
		gbc_tools.gridy = 5;
		sideMenu.add(tools, gbc_tools);
		tools.setLayout(new GridLayout(2, 0, 0, 0));

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setHorizontalAlignment(SwingConstants.CENTER);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutPanel();
			}
		});
		tools.add(mntmAbout);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsPanel();
			}
		});
		mntmSettings.setHorizontalAlignment(SwingConstants.CENTER);
		tools.add(mntmSettings);

//		LAYERED PANES
		// layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));

		welcome = new JPanel();
		layeredPane.add(welcome);
		welcome.setLayout(null);
		lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcome.setBounds(63, 71, 296, 98);
		welcome.add(lblWelcome);
		layeredPane.add(standardCalc);
		layeredPane.add(programmerCalc);
		layeredPane.add(allconv);
		layeredPane.add(about);
		layeredPane.add(settings);
		changeTheme(Color.DARK_GRAY, Color.white); // BY DEFAULT IT'S DARK THEME
		frame.setVisible(true);
	}

	private void changePanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	private class Event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();

			if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
				if (!operator.equals(""))
					operand2 = operand2 + s;
				else
					operand1 = operand1 + s;
				output.setText(operand1 + operator + operand2);
			} else if (s.charAt(0) == 'C') {
				operand1 = operator = operand2 = "";
				output.setText(operand1 + operator + operand2);
			} else if (s.charAt(0) == 'D') {
				if (output.getText() != "") {
					StringBuilder newText = new StringBuilder(output.getText());
					newText.deleteCharAt((newText.length() - 1));
					output.setText(newText.toString());

				}
			} else if (s.charAt(0) == '=') {
				double te;
				try { // Might throw an Exception
					if (operator.equals("+"))
						te = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
					else if (operator.equals("-"))
						te = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
					else if (operator.equals("/"))
						te = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
					else if (operator.equals("%"))
						te = (Double.parseDouble(operand1) % Double.parseDouble(operand2));
					else
						te = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
					output.setText(operand1 + operator + operand2 + "=" + te);
					operand1 = Double.toString(te);
				} catch (NumberFormatException x) {
					output.setText("ERROR");
				}
				operator = operand2 = "";
			} else {
				if (operator.equals("") || operand2.equals(""))
					operator = s;
				else {
					double te;
					if (operator.equals("+"))
						te = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
					else if (operator.equals("-"))
						te = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
					else if (operator.equals("/"))
						te = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
					else if (operator.equals("%"))
						te = (Double.parseDouble(operand1) % Double.parseDouble(operand2));
					else
						te = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
					operand1 = Double.toString(te);
					operator = s;
					operand2 = "";
				}
				output.setText(operand1 + operator + operand2);
			}

		}
	}

	void standardCalculator() {
//		CALCULATOR BEGIN

		standardCalc.setLayout(null);

		output.setHorizontalAlignment(SwingConstants.CENTER);
		output.setFont(new Font("Tahoma", Font.BOLD, 15));
		output.setEditable(false);
		output.setBounds(10, 10, 406, 44);
		standardCalc.add(output);
		output.setColumns(10);

		standardKeyboard.setBounds(10, 64, 406, 204);
		standardCalc.add(standardKeyboard);
		standardKeyboard.setLayout(new GridLayout(4, 5, 0, 0));

		standardKeyboard.add(btnNewButton_1);
		standardKeyboard.add(btnNewButton_2);
		standardKeyboard.add(btnNewButton_3);
		standardKeyboard.add(btnNewButton_4);
		standardKeyboard.add(btnNewButton_5);
		standardKeyboard.add(btnNewButton_6);
		standardKeyboard.add(btnNewButton_7);
		standardKeyboard.add(btnNewButton_8);
		standardKeyboard.add(btnNewButton_9);
		standardKeyboard.add(btnNewButton_10);
		standardKeyboard.add(btnNewButton_11);
		standardKeyboard.add(btnNewButton_12);
		standardKeyboard.add(btnNewButton_13);
		standardKeyboard.add(btnNewButton_14);
		standardKeyboard.add(btnNewButton_15);
		standardKeyboard.add(btnNewButton_16);
		standardKeyboard.add(btnNewButton_17);
		standardKeyboard.add(btnNewButton_18);
		standardKeyboard.add(btnNewButton_19);
		standardKeyboard.add(btnNewButton_20);
		// LISTENERS
		btnNewButton_1.addActionListener(e);
		btnNewButton_2.addActionListener(e);
		btnNewButton_3.addActionListener(e);
		btnNewButton_4.addActionListener(e);
		btnNewButton_5.addActionListener(e);
		btnNewButton_6.addActionListener(e);
		btnNewButton_7.addActionListener(e);
		btnNewButton_8.addActionListener(e);
		btnNewButton_9.addActionListener(e);
		btnNewButton_10.addActionListener(e);
		btnNewButton_11.addActionListener(e);
		btnNewButton_12.addActionListener(e);
		btnNewButton_13.addActionListener(e);
		btnNewButton_14.addActionListener(e);
		btnNewButton_15.addActionListener(e);
		btnNewButton_16.addActionListener(e);
		btnNewButton_17.addActionListener(e);
		btnNewButton_18.addActionListener(e);
		btnNewButton_19.addActionListener(e);
		btnNewButton_20.addActionListener(e);

		changePanel(standardCalc);
//		CALCULATOR PANEL ENDS HERE
	}

	void programmerCalculator() {
//		PROGRAMMER CALCULATOR	

		programmerCalc.setLayout(null);
		output1.setHorizontalAlignment(SwingConstants.CENTER);
		output1.setFont(new Font("Tahoma", Font.BOLD, 15));
		output1.setEditable(false);
		output1.setBounds(10, 26, 387, 44);
		programmerCalc.add(output1);
		output1.setColumns(10);

		binaryKeyboard.setBounds(10, 88, 387, 165);
		programmerCalc.add(binaryKeyboard);
		binaryKeyboard.setLayout(new GridLayout(2, 4, 0, 0));

		bt5.addActionListener(e -> output1.setText(output1.getText() + "0"));
		binaryKeyboard.add(bt5);
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output1.setText(output1.getText() + "1");
			}
		});
		binaryKeyboard.add(bt4);
		btnC.addActionListener(e -> {
			output1.setText("");
			pOperand1 = pOperand2 = pOperator = "";
		});
		binaryKeyboard.add(btnC);
		bt6.addActionListener(e -> {
			pOperand2 = output1.getText();
			output1.setText(Integer.toString(Integer.parseInt(pOperand1) + Integer.parseInt(pOperand2)));
		});
		binaryKeyboard.add(bt6);
		bt0.addActionListener(b -> {
			if (pOperand1.equals("")) {
				pOperand1 = output1.getText();
				pOperator = b.getActionCommand();
				output1.setText("");
			}
		});
		binaryKeyboard.add(bt0);
		bt1.addActionListener(e -> {
			if (pOperand1.equals("")) {
				pOperand1 = output1.getText();
				pOperator = e.getActionCommand();
				output1.setText("");
			}
		});

		binaryKeyboard.add(bt1);
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pOperand1.equals("")) {
					pOperand1 = output1.getText();
					pOperator = e.getActionCommand();
					output1.setText("");
				}
			}
		});
		binaryKeyboard.add(bt2);
		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pOperand1.equals("")) {
					pOperand1 = output1.getText();
					pOperator = e.getActionCommand();
					output1.setText("");
				}
			}
		});
		binaryKeyboard.add(bt3);
		changePanel(programmerCalc);
// 		PROGRAMMER CALCULATOR ENDS HERE
	}

	void allConversions(String[] s) {
		// allconv = new JPanel();

		allconv.setLayout(null);
		JLabel lblFrom_1 = new JLabel("From:");
		lblFrom_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFrom_1.setBounds(23, 26, 115, 21);
		allconv.add(lblFrom_1);

		JLabel lblTo_1 = new JLabel("To:");
		lblTo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo_1.setBounds(23, 131, 115, 25);
		allconv.add(lblTo_1);

		box1.removeAllItems();
		box2.removeAllItems();
		for (int i = 0; i < s.length; i++) {
			box1.addItem(s[i]);
			box2.addItem(s[i]);
		}

		box1.setBounds(20, 64, 159, 33);
		allconv.add(box1);
		box2.setBounds(20, 182, 159, 36);
		allconv.add(box2);

		JTextField inputTF = new JTextField(), outputTF = new JTextField();
		inputTF.setBounds(189, 64, 190, 33);
		allconv.add(inputTF);
		inputTF.setColumns(10);
		outputTF.setEditable(false);
		outputTF.setBounds(189, 182, 190, 36);
		allconv.add(outputTF);
		outputTF.setColumns(10);

		btnCovert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCovert.setBounds(189, 119, 190, 33);
		allconv.add(btnCovert);
		btnCovert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((String) box1.getSelectedItem() == "Binary") {
					switch ((String) box2.getSelectedItem()) {
					case "Binary":
						outputTF.setText(inputTF.getText());
						break;
					case "Decimal":
						outputTF.setText(Conversions.binary_to_decimal(inputTF.getText()));
						break;
					case "Octal":
						outputTF.setText(Conversions.binary_to_octal(inputTF.getText()));
						break;
					case "Hexadecimal":
						outputTF.setText(Conversions.binary_to_hexadecima(inputTF.getText()));
						break;

					}
				} else if ((String) box1.getSelectedItem() == "Decimal") {
					switch ((String) box2.getSelectedItem()) {
					case "Binary":
						outputTF.setText(Conversions.decimal_to_binary(Integer.parseInt(inputTF.getText())));
						break;
					case "Decimal":
						outputTF.setText(inputTF.getText());
						break;
					case "Octal":
						outputTF.setText(Conversions.decimal_to_octal(Integer.parseInt(inputTF.getText())));
						break;
					case "Hexadecimal":
						outputTF.setText(Conversions.decimal_to_hexadecimal(Integer.parseInt(inputTF.getText())));
						break;

					}
				} else if ((String) box1.getSelectedItem() == "Octal") {
					switch ((String) box2.getSelectedItem()) {
					case "Binary":
						outputTF.setText(Conversions.octal_to_binary(inputTF.getText()));
						break;
					case "Decimal":
						outputTF.setText(Conversions.octal_to_decimal(Integer.parseInt(inputTF.getText())));
						break;
					case "Octal":
						outputTF.setText(inputTF.getText());
						break;
					case "Hexadecimal":
						outputTF.setText(Conversions.octal_to_hexadecimal(Integer.parseInt(inputTF.getText())));
						break;

					}
				} else {
					switch ((String) box2.getSelectedItem()) {

					}
				}
			}

		});
		changePanel(allconv);
	}

	void aboutPanel() {
//		ABOUT PANEL
		// about = new JPanel();

		about.setLayout(null);

		JPanel content = new JPanel();
		content.setBorder(new TitledBorder(null, "Authors:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		content.setBounds(29, 36, 329, 167);
		about.add(content);
		content.setLayout(null);

		JLabel lblRealwayneAGonzales = new JLabel("Realwayne A. Gonzales");
		lblRealwayneAGonzales.setBounds(77, 16, 246, 48);
		lblRealwayneAGonzales.setHorizontalAlignment(SwingConstants.LEFT);
		content.add(lblRealwayneAGonzales);

		JLabel lblSunshineADela = new JLabel("Sunshine A. Dela Cruz");
		lblSunshineADela.setBounds(77, 64, 246, 48);
		lblSunshineADela.setHorizontalAlignment(SwingConstants.LEFT);
		content.add(lblSunshineADela);

		JLabel lblRevenMaglaque = new JLabel("Reven Maglaque");
		lblRevenMaglaque.setBounds(77, 112, 246, 48);
		lblRevenMaglaque.setHorizontalAlignment(SwingConstants.LEFT);
		content.add(lblRevenMaglaque);
		changePanel(about);
//		ABOUT PANEL ENDS HERE
	}

	void settingsPanel() {
//		SETTINGS PANEL STARTS HERES

		settings.setLayout(null);

		JLabel lblThemes = new JLabel("Themes: ");
		lblThemes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThemes.setBounds(37, 38, 93, 25);
		settings.add(lblThemes);

		JPanel themePanel = new JPanel();
		themePanel.setBounds(37, 73, 353, 56);
		settings.add(themePanel);
		themePanel.setLayout(new GridLayout(3, 1, 0, 0));

		JRadioButton rdbtnDark = new JRadioButton("Dark"), rdbtnLigth = new JRadioButton("Ligth"),
				rdbtnDefault = new JRadioButton("Default");

		rdbtnDark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTheme(Color.DARK_GRAY, Color.white);
			}
		});
		rdbtnLigth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTheme(new Color(47, 79, 79), Color.white);
			}
		});
		rdbtnDark.setSelected(true);
		rdbtnDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeTheme(null, null);
			}
		});
		themePanel.add(rdbtnDark);
		themePanel.add(rdbtnLigth);
		themePanel.add(rdbtnDefault);
		ButtonGroup themeGroup = new ButtonGroup(); // so one button can be selected
		themeGroup.add(rdbtnDark);
		themeGroup.add(rdbtnLigth);
		themeGroup.add(rdbtnDefault);

		btnQuickTour.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuickTour.setBounds(37, 167, 129, 21);
		settings.add(btnQuickTour);

		changePanel(settings);
//		SETTINGS PANEL ENDS HERE	
	}

	void changeTheme(Color backColor, Color foreColor) {

		head.setBackground(backColor);
		head.setForeground(foreColor);
		sideMenu.setBackground(backColor);
		sideMenu.setForeground(foreColor);
		lblCalculator.setBackground(backColor);
		lblCalculator.setForeground(foreColor);
		lblConverter.setBackground(backColor);
		lblConverter.setForeground(foreColor);
		lblTools.setBackground(backColor);
		lblTools.setForeground(foreColor);

		output.setBackground(backColor);
		output.setForeground(foreColor);
		output1.setBackground(backColor);
		output1.setForeground(foreColor);

		btnNewButton_1.setBackground(backColor);
		btnNewButton_1.setForeground(foreColor);
		btnNewButton_2.setBackground(backColor);
		btnNewButton_2.setForeground(foreColor);
		btnNewButton_3.setBackground(backColor);
		btnNewButton_3.setForeground(foreColor);
		btnNewButton_4.setBackground(backColor);
		btnNewButton_4.setForeground(foreColor);
		btnNewButton_5.setBackground(backColor);
		btnNewButton_5.setForeground(foreColor);
		btnNewButton_6.setBackground(backColor);
		btnNewButton_6.setForeground(foreColor);
		btnNewButton_7.setBackground(backColor);
		btnNewButton_7.setForeground(foreColor);
		btnNewButton_8.setBackground(backColor);
		btnNewButton_8.setForeground(foreColor);
		btnNewButton_9.setBackground(backColor);
		btnNewButton_9.setForeground(foreColor);
		btnNewButton_10.setBackground(backColor);
		btnNewButton_10.setForeground(foreColor);
		btnNewButton_11.setBackground(backColor);
		btnNewButton_11.setForeground(foreColor);
		btnNewButton_12.setBackground(backColor);
		btnNewButton_12.setForeground(foreColor);
		btnNewButton_13.setBackground(backColor);
		btnNewButton_13.setForeground(foreColor);
		btnNewButton_14.setBackground(backColor);
		btnNewButton_14.setForeground(foreColor);
		btnNewButton_15.setBackground(backColor);
		btnNewButton_15.setForeground(foreColor);
		btnNewButton_16.setBackground(backColor);
		btnNewButton_16.setForeground(foreColor);
		btnNewButton_17.setBackground(backColor);
		btnNewButton_17.setForeground(foreColor);
		btnNewButton_18.setBackground(backColor);
		btnNewButton_18.setForeground(foreColor);
		btnNewButton_19.setBackground(backColor);
		btnNewButton_19.setForeground(foreColor);
		btnNewButton_20.setBackground(backColor);
		btnNewButton_20.setForeground(foreColor);

		bt0.setBackground(backColor);
		bt0.setForeground(foreColor);
		bt1.setBackground(backColor);
		bt1.setForeground(foreColor);
		bt2.setBackground(backColor);
		bt2.setForeground(foreColor);
		bt3.setBackground(backColor);
		bt3.setForeground(foreColor);
		bt4.setBackground(backColor);
		bt4.setForeground(foreColor);
		bt5.setBackground(backColor);
		bt5.setForeground(foreColor);
		bt6.setBackground(backColor);
		bt6.setForeground(foreColor);
		btnC.setBackground(backColor);
		btnC.setForeground(foreColor);

		box1.setBackground(backColor);
		box1.setForeground(foreColor);
		box2.setBackground(backColor);
		box2.setForeground(foreColor);
		btnCovert.setBackground(backColor);
		btnCovert.setForeground(foreColor);

		lblWelcome.setBackground(foreColor);
		lblWelcome.setForeground(backColor);
		lblCalculatorConvertorBeta.setBackground(backColor);
		lblCalculatorConvertorBeta.setForeground(foreColor);

		btnQuickTour.setBackground(backColor);
		btnQuickTour.setForeground(foreColor);
	}
}
