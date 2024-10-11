import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class PizzaBill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaBill frame = new PizzaBill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PizzaBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 515);
		contentPane = new JPanel();
		contentPane.setToolTipText("Pizza Type");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel statictext = new JLabel(" Bistro Pizza Bill Calculator");
		statictext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		statictext.setBounds(225, 11, 185, 14);
		statictext.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(statictext);
		
		textField = new JTextField();
		textField.setBounds(178, 59, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setBounds(32, 382, 613, 83);
		contentPane.add(jTextArea1);
		
		JButton btnNewButton = new JButton("Generate bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int orderno = Integer.parseInt(textField.getText());
				String custname =textField_1.getText();
				int qty =Integer.parseInt(textField_2.getText());
				double lblRate =0;
				
				
				
				
				
				if(jRadioButton1.isSelected()) {
					lblRate=200;
				}else if (jRadioButton2.isSelected()) {
					lblRate =300;
				}else if(jRadioButton3.isSelected()) {
					lblRate =150;
				}
				
				textField_3.setText(""+lblRate);
				
				
				
				
				
				double topamt = 0;
				if (jCheckBox1.isSelected()) {
				    topamt += 60;
				}
				if (jCheckBox2.isSelected()) {
				    topamt += 30;
				}
				if (jCheckBox3.isSelected()) {
				    topamt += 40;
				}
				if (jCheckBox4.isSelected()) {
				    topamt += 50;
				}
				textField_5.setText("" + topamt);
				
				
				
				
				double totalpayable =(lblRate*qty)+topamt;
				
				textField_4.setText(""+totalpayable);
				
				jTextArea1.setText("Order ID: " + orderno + "\nName: " + custname + "\nPizza Type Rate: "+lblRate +"\nTopping Rate"+topamt+"\nAmount Payable: " + totalpayable);
				} catch (Exception ex) {
					jTextArea1.setText("Error: Please check input values.");;
				}
			}
			
		});
	


		textField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent evt) {
		        char c = evt.getKeyChar();
		        if (!Character.isDigit(c)) {
		            evt.consume(); 
		            jTextArea1.setText("Error: Only numbers are allowed.");
		        }
		    }
		});



		btnNewButton.setBounds(42, 348, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblOrderNo = new JLabel(" Order No.");														
		lblOrderNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOrderNo.setBounds(32, 61, 70, 19);
		contentPane.add(lblOrderNo);
		
		JLabel lblCustomerName = new JLabel(" Customer Name");
		lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerName.setBounds(32, 91, 112, 19);
		contentPane.add(lblCustomerName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(178, 90, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(0, 121, 131, 19);
		contentPane.add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 122, 86, 20);
		contentPane.add(textField_2);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRate.setBounds(388, 58, 30, 19);
		contentPane.add(lblRate);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(534, 59, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAmount.setBounds(388, 91, 51, 19);
		contentPane.add(lblAmount);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(534, 90, 86, 20);
		contentPane.add(textField_4);
		
		JLabel lblCostOfToppings = new JLabel("Cost of Toppings");
		lblCostOfToppings.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostOfToppings.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCostOfToppings.setBounds(375, 121, 138, 19);
		contentPane.add(lblCostOfToppings);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(534, 122, 86, 20);
		contentPane.add(textField_5);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Pizza Type \r\n\r\n\r\n\r\n");
		panel.setBounds(32, 170, 270, 151);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 jRadioButton1 = new JRadioButton("Pan Pizza");
		jRadioButton1.setBounds(22, 30, 135, 23);
		panel.add(jRadioButton1);
		
		 jRadioButton2 = new JRadioButton("Stuffed Crust");
		jRadioButton2.setBounds(22, 56, 135, 23);
		panel.add(jRadioButton2);
		
		
	jRadioButton3 = new JRadioButton("Regular");
		jRadioButton3.setBounds(22, 82, 135, 23);
		panel.add(jRadioButton3);
		
		
		ButtonGroup pizzaGroup= new ButtonGroup();
		pizzaGroup.add(jRadioButton1);
		pizzaGroup.add(jRadioButton2);
		pizzaGroup.add(jRadioButton3);
		
		JLabel lblPizzaType = new JLabel("Pizza Type");
		lblPizzaType.setBounds(10, 0, 71, 19);
		panel.add(lblPizzaType);
		lblPizzaType.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzaType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("Toppings");
		panel_1.setBounds(375, 170, 270, 151);
		contentPane.add(panel_1);
		
	 jCheckBox1 = new JCheckBox("Onion");
		jCheckBox1.setBounds(22, 30, 143, 23);
		panel_1.add(jCheckBox1);
		
		 jCheckBox2 = new JCheckBox("Cheese");
		jCheckBox2.setBounds(22, 56, 143, 23);
		panel_1.add(jCheckBox2);
		
		 jCheckBox3 = new JCheckBox("Tomato");
		jCheckBox3.setBounds(22, 82, 143, 23);
		panel_1.add(jCheckBox3);
		
		 jCheckBox4 = new JCheckBox("Baby Corn");
		jCheckBox4.setBounds(22, 108, 143, 23);
		panel_1.add(jCheckBox4);
		
		JLabel lblToppings = new JLabel("Toppings");
		lblToppings.setHorizontalAlignment(SwingConstants.CENTER);
		lblToppings.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblToppings.setBounds(10, 0, 71, 19);
		panel_1.add(lblToppings);
		
		textField_2.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent evt) {
	            char c = evt.getKeyChar();
	            if (!Character.isDigit(c)) {
	                evt.consume();
	                jTextArea1.setText("Error: Only numbers allowed in Quantity.");
	            }
	        }
	    });
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				jRadioButton1.setSelected(false);
				jRadioButton2.setSelected(false);
				jRadioButton3.setSelected(false);
				jCheckBox1.setSelected(false);
				jCheckBox2.setSelected(false);
				jCheckBox3.setSelected(false);
				jCheckBox4.setSelected(false);
				jTextArea1.setText("");
			}
		});
		btnClear.setBounds(534, 348, 93, 23);
		contentPane.add(btnClear);
	}
}
