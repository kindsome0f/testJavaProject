package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BookList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfName;
	private JTextField tfWriter;
	private JTextField tfMaker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookList frame = new BookList();
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
	public BookList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 181, 301, 244);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblName = new JLabel("제목");
		lblName.setBounds(12, 106, 57, 15);
		contentPane.add(lblName);
		
		JLabel lblWriter = new JLabel("저자");
		lblWriter.setBounds(12, 131, 57, 15);
		contentPane.add(lblWriter);
		
		JLabel lblMaker = new JLabel("출판사");
		lblMaker.setBounds(12, 156, 57, 15);
		contentPane.add(lblMaker);
		
		JButton btnGo = new JButton("관리자");
		btnGo.setBounds(216, 10, 97, 23);
		contentPane.add(btnGo);
		
		tfName = new JTextField();
		tfName.setBounds(81, 103, 116, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfWriter = new JTextField();
		tfWriter.setBounds(81, 128, 116, 21);
		contentPane.add(tfWriter);
		tfWriter.setColumns(10);
		
		tfMaker = new JTextField();
		tfMaker.setBounds(81, 153, 116, 21);
		contentPane.add(tfMaker);
		tfMaker.setColumns(10);
		
		JButton btnScarch = new JButton("검색");
		btnScarch.setBounds(216, 152, 97, 23);
		contentPane.add(btnScarch);
	}
}
