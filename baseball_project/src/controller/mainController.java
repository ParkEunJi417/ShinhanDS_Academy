package controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import dto.PersonDTO;
import dto.RecordGameDTO;
import dto.RecordPerDTO;
import model.BaseballService;
import util.DateUtil;
import view.GameView;
import view.MatchTeamView;
import view.RecordGameView;
import view.RecordPerView;

public class mainController {
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private static final String PHONE_REGEX = "^\\d{3}-\\d{3,4}-\\d{4}$";
	private static final String DATE_REGEX = "^[\\d]{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

	static Scanner sc = new Scanner(System.in);
	static BaseballService bbService = new BaseballService();

	public static void main(String[] args) {
		boolean isStop_main = false;
		boolean isStop_menu = false;
		String id = null;

		while (!isStop_main && !isStop_menu) {
			menuLogout();
			int job_select = Integer.parseInt(sc.nextLine());
			switch (job_select) {
			case 1 -> {
				insertMember(); // 0.회원가입(insert)
			} 
			case 2 -> {
				id = login(); // 0.로그인(select)

				if(id != null && id != "") {
					
					while (!isStop_menu) {
						menuLogin();
						job_select = Integer.parseInt(sc.nextLine());
						switch (job_select) {
						case 1 -> {
							selectGame();} // 1.이번주 야구일정(select)
						case 2 -> {
							insertWatching(id); // 2.직관등록(insert)
						} 
						case 3 -> {
							selectWatching(id); // 3.직관기록(select)
						} 
						case 4 -> {
							deleteWatching(id); // 4.직관삭제(delete)
						} 
						case 5 -> {
							updateMember(id); // 5.정보수정(update)
						}
						case 9 -> {isStop_menu = true;} // 9.종료
						default -> {System.out.println("작업선택 오류. 다시 선택");}
						} // 작은 switch문
					} // 작은 while문
				}
			}
			case 3 -> {selectGame();} // 3.이번주 야구일정
			case 9 -> { isStop_main = true;}
			default -> { System.out.println("작업선택 오류. 다시 선택");}
			} // 큰 switch문
		} // 큰 while문
		sc.close();
		System.out.println("=========프로그램 종료=========");
	}

	// 0.회원가입
	private static void insertMember() {
		PersonDTO person = new PersonDTO();

		System.out.print("아이디>>");
		String person_id = sc.nextLine();

		if (bbService.selectPersonId(person_id) > 0) {
			GameView.display("기가입된 아이디 입니다.");
			return;
		}

		System.out.print("패스워드(최대 20자)>>");
		String person_pw = sc.nextLine();

		if (person_pw.length() > 20) {
			GameView.display("패스워드 최대 20자까지 입니다.");
			return;
		}

		System.out.print("핸드폰번호(###-####-####)>>");
		String person_phone = sc.nextLine();

		if (Pattern.matches(PHONE_REGEX, person_phone) == false) {
			GameView.display("핸드폰 번호 형식이 일치하지 않습니다.");
			return;
		}

		System.out.print("이메일(##@#####.###)>>");
		String person_email = sc.nextLine();

		if (Pattern.matches(EMAIL_REGEX, person_email) == false) {
			GameView.display("이메일 형식이 일치하지 않습니다.");
			return;
		}

		person.setPerson_id(person_id);
		person.setPerson_pw(person_pw);
		person.setPerson_phone(person_phone);
		person.setPerson_email(person_email);

		int result = bbService.insertMember(person);
		GameView.display(result + "건 회원가입 완료!");
	}

	// 0.로그인
	private static String login() {
		String result_id = null;

		System.out.print("아이디>>");
		String person_id = sc.nextLine();

		System.out.print("패스워드>>");
		String person_pw = sc.nextLine();

		PersonDTO info_person = bbService.loginMember(person_id, person_pw);

		if (info_person != null) {
			result_id = info_person.getPerson_id();
			GameView.display(result_id + "님 로그인 성공!");
		} else {
			GameView.display("로그인 실패");
		}
		return result_id;
	}

	// 1.이번주 야구일정
	private static void selectGame() {
		List<RecordGameDTO> gamelist = bbService.selectGameThisWeek();
		RecordGameView.display(gamelist);
	}
	
	// 2.직관등록
	private static void insertWatching(String person_id) {
		System.out.print("등록하고 싶은 일정(yyyy-MM-dd)>>");
		String date = sc.nextLine();
		
		if (Pattern.matches(DATE_REGEX, date) == false) {
			GameView.display("날짜 형식이 일치하지 않습니다.");
			return;
		}
		
		Date game_date = DateUtil.convertSqlDate(DateUtil.convertDate(date));
		
		if(selectByGameDate(game_date) > 0) {
			System.out.print("등록하고 싶은 경기번호>>");
			int game_no = Integer.parseInt(sc.nextLine());

			if (bbService.selectGameNo(person_id, game_no) > 0) {
				GameView.display("기등록된 직관경기 입니다.");
				return;
			}
			
			RecordGameDTO matchTeam = bbService.selectByMatchTeam(game_no,game_date);
			
			if(matchTeam == null) {
				GameView.display("해당 일정에 일치하는 경기번호가 아닙니다.");
				return;
			}
			MatchTeamView.display(matchTeam);
			
			System.out.print("응원한 팀번호>>");
			int watch_team_id = Integer.parseInt(sc.nextLine());
			
			if(matchTeam.getTeam_id_a() != watch_team_id && 
			   matchTeam.getTeam_id_h() != watch_team_id) {
				GameView.display("해당 경기에 일치하는 팀번호가 아닙니다.");
				return;
			}

			if (bbService.insertWatching(person_id, game_no, watch_team_id) != 0)
				System.out.println("직관등록 성공!");
		}
	}

	// 2-1.해당 일자의 경기 일정
	private static int selectByGameDate(Date game_date) {
		List<RecordGameDTO> gamelist = bbService.selectByGameDate(game_date);
		RecordGameView.displayAll(gamelist);
		
		return gamelist.size();
	}

	// 3.직관기록
	private static void selectWatching(String person_id) {
		int count_win=0;
		double winningPersent=0;
		
		List<RecordPerDTO> watchlist = bbService.selectById(person_id);
		RecordPerView.display(watchlist);
		
		for(RecordPerDTO watch:watchlist) {
			boolean isHomeTeam=watch.getTeamid()==watch.getTeam_id_h()?true:false;
			
			// 응원하는 팀이 홈팀일 경우
			if(isHomeTeam) {
				if(watch.getTeam_score_h() > watch.getTeam_score_a()) {
					count_win++;
				}
			} else {
				// 응원하는 팀이 원정팀일 경우
				if(watch.getTeam_score_a() > watch.getTeam_score_h()) {
					count_win++;
				}
			}
		}
		
		if(watchlist.size() != 0)
			winningPersent = (double)count_win/watchlist.size();
		 
		RecordPerView.display(winningPersent);
	}

	// 4.직관삭제
	private static void deleteWatching(String person_id) {
		List<RecordPerDTO> watchlist = bbService.selectById(person_id);
		RecordPerView.displayAll(watchlist);

		if(watchlist.size() > 0) {
			System.out.print("삭제하고 싶은 직관번호>>");
			int watch_no = Integer.parseInt(sc.nextLine());

			int result = bbService.deleteById(watch_no);
			if (result == 0) {
				GameView.display("일치하는 직관번호가 없습니다.");
				return;
			}
				System.out.println("직관삭제 성공!");
		}
	}

	// 5.정보수정
	private static void updateMember(String person_id) {
		PersonDTO person = new PersonDTO();

		System.out.print("패스워드(최대 20자)>>");
		String person_pw = sc.nextLine();

		if (person_pw.length() > 20) {
			GameView.display("패스워드 최대 20자까지 입니다.");
			return;
		}

		System.out.print("핸드폰번호(###-####-####)>>");
		String person_phone = sc.nextLine();

		if (Pattern.matches(PHONE_REGEX, person_phone) == false) {
			GameView.display("핸드폰 번호 형식이 일치하지 않습니다.");
			return;
		}

		System.out.print("이메일(##@#####.###)>>");
		String person_email = sc.nextLine();

		if (Pattern.matches(EMAIL_REGEX, person_email) == false) {
			GameView.display("이메일 형식이 일치하지 않습니다.");
			return;
		}

		person.setPerson_id(person_id);
		person.setPerson_pw(person_pw);
		person.setPerson_phone(person_phone);
		person.setPerson_email(person_email);

		int result = bbService.updateMember(person);
		GameView.display(result + "건 수정됨");
	}

	// 로그아웃 상태시 메뉴
	private static void menuLogout() {
		System.out.println("------------------------------------------");
		System.out.println("1.회원가입 2.로그인 3.이번주 야구일정 9.종료");
		System.out.println("------------------------------------------");
		System.out.print("작업선택>>");
	}

	// 로그인 상태시 메뉴
	private static void menuLogin() {
		System.out.println("------------------------------------------------------------");
		System.out.println("1.이번주 야구일정 2.직관등록 3.직관기록 4.직관삭제 5.정보수정 9.종료");
		System.out.println("------------------------------------------------------------");
		System.out.print("작업선택>>");
	}
}