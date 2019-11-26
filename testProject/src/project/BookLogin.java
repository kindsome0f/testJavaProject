package project;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BookLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField tfPwd;
	private JLabel Label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookLogin frame = new BookLogin();
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
	public BookLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strId = tfId.getText();
				String strPwd = String.valueOf(tfPwd.getPassword());
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn=DB.dbConn();				
					String sql = "SELECT * FROM master WHERE mid=? AND mpw=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, strId);
					pstmt.setString(2, strPwd);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						BookEdit edit = new BookEdit();
						edit.setVisible(true);						
					}else {
						Label.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
					}					
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						if (rs != null) 
							rs.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					try {
						if(pstmt != null)
							pstmt.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					try {
						if(conn != null)
							conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
				}
			}	
		}
	});
		btnLogin.setBounds(210, 57, 97, 78);
		contentPane.add(btnLogin);
		
		tfId = new JTextField();
		tfId.setBounds(12, 58, 161, 21);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(12, 33, 57, 15);
		contentPane.add(lblId);
		
		JLabel lblPwd = new JLabel("패스워드");
		lblPwd.setBounds(12, 89, 57, 15);
		contentPane.add(lblPwd);
		
		tfPwd = new JPasswordField();
		tfPwd.setBounds(12, 114, 161, 21);
		contentPane.add(tfPwd);
		
		Label = new JLabel("");
		Label.setBounds(22, 145, 258, 15);
		contentPane.add(Label);
	}
}
