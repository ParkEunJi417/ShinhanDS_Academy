package com.baseball.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.baseball.util.DBUtil;

public class BaseballDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;

	// DB에 회원 정보입력
	public int insertPerson(PersonDTO bb) {
		String sql = "insert into person values(?,?,?,?)";
		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sql);

			st.setString(1, bb.getPerson_id());
			st.setString(2, bb.getPerson_pw());
			st.setString(3, bb.getPerson_phone());
			st.setString(4, bb.getPerson_email());

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		return result;
	}

	// 기가입자 확인
	public int selectPersonId(String person_id) {
		String sql = "select count(*) from person where person_id=?";

		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, person_id);
			rs = st.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			result = -1;
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return result;
	}

	// 로그인
	public PersonDTO loginPerson(String person_id, String person_pw) {
		String sql = "select * from person where person_id=?";
		conn = DBUtil.getConnection();
		PersonDTO person = null;

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, person_id);
			rs = st.executeQuery();

			if(rs.next()) {
				String getPass = rs.getString("person_pw");
				if(person_pw.equals(getPass)) {
					person = PersonDTO.builder()
									  .person_id(person_id)
									  .person_pw(person_pw)
									  .build();
				} else {
					person = PersonDTO.builder()
									  .person_id(person_id)	
									  .person_pw("-1")
									  .build();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return person;
	}

	// 이번주 야구일정
	public List<RecordGameDTO> selectGameThisWeek() {
		String sql = """
				select game_no, game_date, away.team_name team_name_a, home.team_name team_name_h,
					   team_score_a, team_score_h, team_id_a, team_id_h
				from game, team away, team home
				where away.team_id = game.team_id_a
				and  home.team_id = game.team_id_h
				and game.game_date>=TRUNC(sysdate,'iw')
				and game.game_date <=TRUNC(sysdate,'iw')+6
				""";

		conn = DBUtil.getConnection();
		List<RecordGameDTO> gamelist = new ArrayList<RecordGameDTO>();

		try {
			st = conn.prepareStatement(sql);

			rs = st.executeQuery();

			while (rs.next()) {
				RecordGameDTO game = makeGame(rs);
				gamelist.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return gamelist;
	}

	// 기등록 직관 경기 확인
	public int selectGameNoById(String person_id, int game_no) {
		String sql = "select count(*) from watching where person_id=? and game_no=?";

		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, person_id);
			st.setInt(2, game_no);
			rs = st.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			result = -1;
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return result;
	}

	// 해당 경기의 매칭팀
	public RecordGameDTO selectByMatchTeam(int game_no, Date game_date) {
		String sql = """
				select away.team_id team_id_a, away.team_name team_name_a,
				home.team_id team_id_h, home.team_name team_name_h
				from game, team away, team home
				where away.team_id = game.team_id_a
				and home.team_id = game.team_id_h
				and game_no = ? and game_date = ?
				""";

		conn = DBUtil.getConnection();
		RecordGameDTO game = new RecordGameDTO();
//		String matchTeam=null;

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, game_no);
			st.setDate(2, game_date);
			rs = st.executeQuery();

			if (rs.next()) {
				game.setTeam_id_a(rs.getInt("team_id_a"));
				game.setTeam_name_a(rs.getString("team_name_a"));
				game.setTeam_id_h(rs.getInt("team_id_h"));
				game.setTeam_name_h(rs.getString("team_name_h"));
				
//				if(rs.getInt("team_id_a") < rs.getInt("team_id_h")) {
//					matchTeam=rs.getInt("team_id_a")+","+rs.getString("team_name_a")+"/"
//							+rs.getInt("team_id_h")+","+rs.getString("team_name_h");
//				}
//				else {
//					matchTeam=rs.getInt("team_id_h")+","+rs.getString("team_name_h")+"/"
//							+rs.getInt("team_id_a")+","+rs.getString("team_name_a");
//				}
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return game;
	}

	// 직관등록
	public int insertWatching(String person_id, int game_no, int watch_team_id) {
		String sql = "insert into watching values(seq_watchNo.NEXTVAL,?,?,?)";
		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sql);

			st.setString(1, person_id);
			st.setInt(2, game_no);
			st.setInt(3, watch_team_id);

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}

		return result;
	}
	
	// 모든 경기 일정
	public List<String> selectAllGameDate () {
		String sql = """
				select distinct game_date from game order by game_date
				""";
		conn = DBUtil.getConnection();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<String> datelist = new ArrayList<>();
		
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
		        String dateString = formatter.format(rs.getDate("game_date"));
				datelist.add(dateString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return datelist;
	}

	// 해당 일자의 경기 출력
	public List<RecordGameDTO> selectByGameDate(Date game_date) {
		String sql = """
				select game_no, game_date, away.team_name team_name_a, home.team_name team_name_h,
				team_score_a, team_score_h, team_id_a, team_id_h
				from game, team away, team home
				where away.team_id = game.team_id_a
				and  home.team_id = game.team_id_h
				and  game_date=?
				""";
		conn = DBUtil.getConnection();
		List<RecordGameDTO> gamelist = new ArrayList<RecordGameDTO>();

		try {
			st = conn.prepareStatement(sql);
			st.setDate(1, game_date);
			rs = st.executeQuery();

			while (rs.next()) {
				RecordGameDTO dept = makeGame(rs);
				gamelist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return gamelist;
	}

	// 해당 id의 직관 기록
	public List<RecordPerDTO> selectById(String person_id) {
		String sql = """
				select watch_no, game_date, 
						away.team_name team_name_a, team_score_a, team_id_a,
						home.team_name team_name_h, team_score_h, team_id_h,
				        team.team_name teamname, watch_team_id teamid
				from watching, game, team away, team home, team
				where watching.game_no=game.game_no
				and away.team_id = game.team_id_a
				and home.team_id = game.team_id_h
                and watching.watch_team_id=team.team_id
				and person_id=?
				order by game_date
				""";
		conn = DBUtil.getConnection();
		List<RecordPerDTO> recordlist = new ArrayList<RecordPerDTO>();

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, person_id);
			rs = st.executeQuery();

			while (rs.next()) {
				RecordPerDTO record = makeRecordPerson(rs);
				recordlist.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return recordlist;
	}

	// 해당 id의 직관 삭제
	public int deleteById(int watch_no) {
		String sql = "delete from watching where watch_no=?";

		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, watch_no);

			result = st.executeUpdate();

		} catch (SQLException e) {
			try {
				conn.rollback(); // DB에 작업한 내용 취소
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		return result;
	}
	
	// 해당 id의 직관들 삭제
	public int deleteWatchingsById(String str_watchNos) {
        StringBuilder placeholders = new StringBuilder();
        String[] watchNos = str_watchNos.split(",");
        
        for (int i = 0; i < watchNos.length; i++) {
            placeholders.append("?");
            if (i < watchNos.length - 1) {
                placeholders.append(", ");
            }
        }
        
		String sql = "delete from watching where watch_no in ("+placeholders+")";

		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			
			for (int i = 0; i < watchNos.length; i++) {
				st.setInt(i + 1, Integer.parseInt(watchNos[i]));
            }
			result = st.executeUpdate();

		} catch (SQLException e) {
			try {
				conn.rollback(); // DB에 작업한 내용 취소
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		return result;
	}
	
	// 회원정보
	public PersonDTO selectPersonInfo(String person_id) {
		String sql = "select * from person where person_id=?";
		PersonDTO person = null;

		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sql);

			st.setString(1, person_id);
			rs = st.executeQuery();

			if (rs.next()) {
				person = PersonDTO.builder()
								  .person_id(rs.getString("person_id"))
								  .person_pw(rs.getString("person_pw"))
								  .person_email(rs.getString("person_email"))
								  .person_phone(rs.getString("person_phone"))
								  .build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		return person;
	}

	// 수정
	public int updatePerson(PersonDTO person) {
		String sql = """
				update person set
					person_pw=?,
					person_phone=?,
					person_email=?
				where person_id=?
				""";
		int result = 0;

		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(sql);
			st.setString(4, person.getPerson_id());
			st.setString(1, person.getPerson_pw());
			st.setString(2, person.getPerson_phone());
			st.setString(3, person.getPerson_email());

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		return result;
	}

	// 경기(Game) DTO
	private static RecordGameDTO makeGame(ResultSet rs) throws SQLException {
		RecordGameDTO game = new RecordGameDTO();

		game.setGame_no(rs.getInt("game_no"));
		game.setGame_date(rs.getDate("game_date"));
		
		game.setTeam_name_a(rs.getString("team_name_a"));
		game.setTeam_score_a(rs.getInt("team_score_a"));
		game.setTeam_id_a(rs.getInt("team_id_a"));
		
		game.setTeam_name_h(rs.getString("team_name_h"));
		game.setTeam_score_h(rs.getInt("team_score_h"));
		game.setTeam_id_h(rs.getInt("team_id_h"));

		return game;
	}

	// 해당 ID의 직관기록 DTO
	private RecordPerDTO makeRecordPerson(ResultSet rs) throws SQLException {
		RecordPerDTO record = new RecordPerDTO();

		record.setWatch_no(rs.getInt("watch_no"));
		record.setGame_date(rs.getDate("game_date"));
		
		record.setTeam_name_a(rs.getString("team_name_a"));
		record.setTeam_score_a(rs.getInt("team_score_a"));
		record.setTeam_id_a(rs.getInt("team_id_a"));
		
		record.setTeam_name_h(rs.getString("team_name_h"));
		record.setTeam_score_h(rs.getInt("team_score_h"));
		record.setTeam_id_h(rs.getInt("team_id_h"));
		
		record.setTeamname(rs.getString("teamname"));
		record.setTeamid(rs.getInt("teamid"));
		
		return record;
	}

}
