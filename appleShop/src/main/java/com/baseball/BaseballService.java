package com.baseball;

import java.sql.Date;
import java.util.List;

//import com.baseball.PersonDTO;
//import com.baseball.RecordPerDTO;

public class BaseballService {
	BaseballDAO bbDAO = new BaseballDAO();

//	// 회원가입
//	public int insertMember(PersonDTO bb) {
//		return bbDAO.insertMember(bb);
//	}
//
//	// 기가입자 확인
//	public int selectPersonId(String person_id) {
//		return bbDAO.selectPersonId(person_id);
//	}
//
//	// 로그인
//	public PersonDTO loginMember(String person_id, String person_pw) {
//		return bbDAO.loginMember(person_id, person_pw);
//	}
	
	// 이번주 야구일정
	public List<RecordGameDTO> selectGameThisWeek(){
		return bbDAO.selectGameThisWeek();
	}

//	// 기등록 직관 경기 확인
//	public int selectGameNo(String person_id, int game_no) {
//		return bbDAO.selectGameNoById(person_id, game_no);
//	}
//
//	// 해당 경기 팀
//	public RecordGameDTO selectByMatchTeam(int game_no, Date game_date) {
//		return bbDAO.selectByMatchTeam(game_no, game_date);
//	}
//	
//	// 직관 등록
//	public int insertWatching(String person_id, int game_no, int watch_team_id) {
//		return bbDAO.insertWatching(person_id, game_no, watch_team_id);
//	}
//
//	// 해당 일자의 경기 일정
//	public List<RecordGameDTO> selectByGameDate(Date game_date) {
//		return bbDAO.selectByGameDate(game_date);
//	}
//
//	// 해당 id의 직관 기록
//	public List<RecordPerDTO> selectById(String person_id) {
//		return bbDAO.selectById(person_id);
//	}
//
//	// 해당 id의 직관 삭제
//	public int deleteById(int watch_no) {
//		return bbDAO.deleteById(watch_no);
//	}
//
//	// 회원정보 수정
//	public int updateMember(PersonDTO bb) {
//		return bbDAO.updateMember(bb);
//	}

}
