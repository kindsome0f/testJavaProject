package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BookEdit extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfWriter;
	private JTextField tfMaker;
	private JTextField tfPrice;
	private JTextField tfYear;
	private JTextField tfAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookEdit frame = new BookEdit();
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
	public BookEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("제목");
		lblName.setBounds(12, 38, 57, 15);
		contentPane.add(lblName);
		
		JLabel lblWriter = new JLabel("저자");
		lblWriter.setBounds(12, 63, 57, 15);
		contentPane.add(lblWriter);
		
		JLabel lblMaker = new JLabel("출판사");
		lblMaker.setBounds(12, 88, 57, 15);
		contentPane.add(lblMaker);
		
		JLabel lblPrice = new JLabel("가격");
		lblPrice.setBounds(12, 113, 57, 15);
		contentPane.add(lblPrice);
		
		JLabel lblYear = new JLabel("출판일");
		lblYear.setBounds(12, 138, 57, 15);
		contentPane.add(lblYear);
		
		JLabel lblAmount = new JLabel("수량");
		lblAmount.setBounds(12, 163, 57, 15);
		contentPane.add(lblAmount);
		
		tfName = new JTextField();
		tfName.setBounds(81, 35, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfWriter = new JTextField();
		tfWriter.setBounds(81, 60, 116, 21);
		contentPane.add(tfWriter);
		tfWriter.setColumns(10);
		
		tfMaker = new JTextField();
		tfMaker.setBounds(81, 85, 116, 21);
		contentPane.add(tfMaker);
		tfMaker.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(81, 110, 116, 21);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfYear = new JTextField();
		tfYear.setBounds(81, 135, 116, 21);
		contentPane.add(tfYear);
		tfYear.setColumns(10);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(81, 160, 116, 21);
		contentPane.add(tfAmount);
		tfAmount.setColumns(10);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.setBounds(252, 34, 97, 23);
		contentPane.add(btnAdd);
		
		JButton btnIns = new JButton("수정");
		btnIns.setBounds(252, 59, 97, 23);
		contentPane.add(btnIns);
		
		JButton btnDel = new JButton("삭제");
		btnDel.setBounds(252, 84, 97, 23);
		contentPane.add(btnDel);
	}

}
