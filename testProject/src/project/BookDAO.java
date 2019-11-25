package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import project.DB;

public class BookDAO {
	public int insertBook(BookDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="INSERT INTO bookstore(name, writer, maker, price, year, amount) "
					+ " VALUES (?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getMaker());
			pstmt.setDouble(4, dto.getPrice());
			pstmt.setString(5, dto.getYear());
			pstmt.setInt(6, dto.getAmount());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public int deleteBook(String name) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DB.dbConn();
			String sql="delete from bookstore where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if (conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;		
	}
	public int updateBook(BookDTO dto) {
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;		
		try {
			conn=DB.dbConn();
			String sql="UPDATE bookstore SET writer=?, maker=?, price=?, year=?, "
					+ " amount=? Where number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getMaker());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getYear());
			pstmt.setInt(5, dto.getAmount());
			pstmt.setString(6, dto.getName());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public Vector searchBook(String name) {
		Vector items=new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select name,writer,maker,price,year,amount "
					+ " from bookstore where name like ? order by name";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+name+"%");
		rs=pstmt.executeQuery();
		while(rs.next()) {
			Vector row=new Vector();
			row.add(rs.getString("name"));
			row.add(rs.getString("writer"));
			row.add(rs.getString("maker"));
			row.add(rs.getInt("price"));
			row.add(rs.getString("year"));
			row.add(rs.getInt("amount"));
			items.add(row);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();	
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return items;
	}
	public Vector listBook(){
		Vector items=new Vector();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DB.dbConn();
			String sql="select name,writer,maker,price,year,amount "
					+ " from bookstore order by name";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector row =new Vector();
				row.add(rs.getString("name"));
				row.add(rs.getString("writer"));
				row.add(rs.getString("maker"));
				row.add(rs.getInt("price"));
				row.add(rs.getString("year"));
				row.add(rs.getInt("amount"));
				items.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}try {
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	return items;
	}
}
