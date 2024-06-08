package DefaultPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private ScriptEngine engine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorFrame frame = new CalculatorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorFrame() {
		setResizable(false);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Initialize the ScriptEngine
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("nashorn");
        if (engine == null) {
            System.err.println("ScriptEngine initialization failed!");
        }
        
				
		//Create the uneditable textField
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 32, 186, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		//Create the buttons
		JButton btnOne = new JButton("1");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("1");
			}
		});
		btnOne.setBounds(10, 112, 57, 32);
		
		contentPane.add(btnOne);
		
		JButton btnTwo = new JButton("2");
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("2");
			}
		});
		btnTwo.setBounds(77, 112, 57, 32);
		contentPane.add(btnTwo);
		
		JButton btnThree = new JButton("3");
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("3");
			}
		});
		btnThree.setBounds(139, 112, 57, 32);
		contentPane.add(btnThree);	
		
		JButton btnFour = new JButton("4");
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("4");
			}
		});
		btnFour.setBounds(10, 146, 57, 32);
		contentPane.add(btnFour);
		
		JButton btnFive = new JButton("5");
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("5");
			}
		});
		btnFive.setBounds(77, 146, 57, 32);
		contentPane.add(btnFive);
		
		JButton btnSix = new JButton("6");
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("6");
			}
		});
		btnSix.setBounds(139, 146, 57, 32);
		contentPane.add(btnSix);	
		
		JButton btnSeven = new JButton("7");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("7");
			}
		});
		btnSeven.setBounds(10, 180, 57, 32);
		contentPane.add(btnSeven);	
		
		JButton btnEight = new JButton("8");
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("8");
			}
		});
		btnEight.setBounds(77, 180, 57, 32);
		contentPane.add(btnEight);
		
		JButton btnNine = new JButton("9");
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("9");
			}
		});
		btnNine.setBounds(139, 180, 57, 32);
		contentPane.add(btnNine);		
		
		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("0");
			}
		});
		btnZero.setBounds(77, 214, 57, 32);
		contentPane.add(btnZero);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("+");
			}
		});
		btnPlus.setBounds(206, 112, 57, 32);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("-");
			}
		});
		btnMinus.setBounds(206, 146, 57, 32);
		contentPane.add(btnMinus);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateResult();
			}
		});
		btnEqual.setBounds(206, 250, 57, 32);
		contentPane.add(btnEqual);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("*");
			}
		});
		btnMultiply.setBounds(206, 180, 57, 32);
		contentPane.add(btnMultiply);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendTextToTextField("/");
			}
		});
		btnDivide.setBounds(206, 214, 57, 32);
		contentPane.add(btnDivide);
		
		JButton btnClear = new JButton("CE");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnClear.setBounds(77, 250, 57, 32);
		contentPane.add(btnClear);
	}
	
	//Method to append text to textField
	public void appendTextToTextField(String text) {
		textField.setText(textField.getText() + text);
	}
	
	// Method to calculate and display the result
    private void calculateResult() {
        try {
            String expression = textField.getText();
            if (engine == null) {
                throw new NullPointerException("ScriptEngine is not initialized.");
            }
            Object result = engine.eval(expression);
            textField.setText(result.toString());
        } catch (ScriptException e) {
        	textField.setText("Error");
        } catch (NullPointerException e) {
            textField.setText("Script Engine Error");
            System.err.println("ScriptEngine is not initialized properly.");
        }
    }
}
