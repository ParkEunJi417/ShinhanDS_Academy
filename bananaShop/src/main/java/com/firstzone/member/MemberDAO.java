package com.firstzone.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shinhan.util.DBUtil;

public class MemberDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	String select_login = "select * from members where member_id=?";
	
	public MemberDTO login(String mid, String mpass){
		MemberDTO member = null;
		
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(select_login);
			st.setString(1, mid);
			rs = st.executeQuery();
			
			if(rs.next()) {
				String getPass = rs.getString("member_pass");
				if(mpass.equals(getPass)) {
					member = new MemberDTO(mid, mpass, rs.getString("member_name"), 
							rs.getString("member_email"));
	
				} else {
					member = MemberDTO.builder().member_id("-1").build();
				}
			} else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
}
