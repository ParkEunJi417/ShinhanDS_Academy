package racetrack;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceTrack_DAO {
	private static final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private static final String USER = "racetrack";
    private static final String PASSWORD = "1234";
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
	//1. 회원 가입 여부 확인
    public boolean login(String memberId, String password) {
        String sql = "SELECT * FROM members WHERE member_id = ? AND member_pw = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, memberId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // 로그인 성공 시 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
	//2. 회원 등록
    public boolean registerMember(String memberId, String password,int index) {
        String sql = "INSERT INTO members (member_id, member_pw, member_index ,member_cash) VALUES (?, ?, ?, 0.0)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, memberId);
            stmt.setString(2, password);
            stmt.setInt(3, index);
            stmt.executeUpdate();
            System.out.println("회원 등록이 성공적으로 완료되었습니다.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("회원 등록에 실패했습니다. ID가 이미 존재할 수 있습니다.");
            return false;
        }
    }
    
    //3. 금액 충전
    public void recharge(String memberId, double amount) {
    	// 일정 확률로 디도스 공격을 당해서 충전 금액의 일부를 잃음
    	Random random = new Random();
    	boolean ddosPercentage = random.nextDouble() < 0.5;
    	// double finalAmount = amount;
    	if(ddosPercentage) {
    		amount = amount * 0.7;
    		System.out.println("디도스 공격을 당해서 충전 금액의 일부를 잃었습니다.");
    	}
    	
    	String sql = "UPDATE members SET member_cash = member_cash + ? WHERE member_id = ?";
    	try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
               stmt.setDouble(1, amount);
               stmt.setString(2, memberId);
               stmt.executeUpdate();
               System.out.println(amount + "원이 충전되었습니다.");
           } catch (SQLException e) {
               e.printStackTrace();
           }
    }
    
    //4. 계정 조회
    public void getAccountInfo(String memberId) {
    	String sql = "SELECT member_id, member_cash FROM members WHERE member_id = ?";
    	try(Connection conn = getConnection();
    			PreparedStatement stmt = conn.prepareStatement(sql)){
    		stmt.setString(1, memberId);
    		ResultSet rs = stmt.executeQuery();
    		if(rs.next()) {
    			System.out.println("회원 ID:" + rs.getString("member_id"));
    			System.out.println("잔액:" + rs.getDouble("member_cash")+"원");
    		} else {
    			System.out.println("계정을 찾을 수 없습니다.");
    		}
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
    }
    
    //5. 계정 삭제
    public void deleteAccount(String memberId) {
    	String sql = "DELETE FROM members WHERE member_id = ?";
    	try(Connection conn = getConnection();
    			PreparedStatement stmt = conn.prepareStatement(sql)){
    		stmt.setString(1,memberId);
    		int rowsDeleted = stmt.executeUpdate();
    		if(rowsDeleted > 0) {
    			System.out.println("계정이 성공적으로 삭제되었습니다.");
    		} else {
    			System.out.println("계정을 찾을 수 없습니다.");
    		}
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
    }
    
    //6. 경마 보상
    public void startRace(String memberId, int horseId, double bettingAmount) {
    	Random random = new Random();
    	double rate = 0.2 + (random.nextDouble() * 2.1); // 20% ~ 230% 배당률
    	double winings = bettingAmount * rate;
    	
    	// 배팅 기록 삽입 쿼리
    	String sqlInsertBetting = "INSERT INTO betting (batting_id, member_id, horse_id, betting_cash, betting_day) " +
                "VALUES (seq_betting.nextval, ?, ?, ?, sysdate)";
    	
    	// 회원의 잔액 업데이트 쿼리
    	String sqlUpdatebetting = "UPDATE members SET member_cash = member_cash + ? WHERE member_id = ?";
    	
    	try(Connection conn = getConnection();
    			PreparedStatement stmtInsert = conn.prepareStatement(sqlInsertBetting);
    			PreparedStatement stmtUpdateBet = conn.prepareStatement(sqlUpdatebetting)){
    		
    		// 회원의 잔액 업데이트
    		stmtUpdateBet.setDouble(1,winings);
    		stmtUpdateBet.setString(2,memberId);
    		stmtUpdateBet.executeUpdate();
    		System.out.println("배팅 금액: " + bettingAmount + "원, 배당률: " + (rate * 100) + "%, 상금: " + winings + "원이 지급되었습니다.");
    		
    		// 배팅 기록 삽입
    		stmtInsert.setString(1, memberId);
    		stmtInsert.setInt(2, horseId);
    		stmtInsert.setDouble(3, bettingAmount);
    		stmtInsert.executeUpdate();
    		System.out.println("배팅 기록이 저장되었습니다.");
    		
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
    	
    }
    
    
    //7. 모든 경마용 말 조회
    public List<Horse_DTO> getAllHorses(){
    	String sql = "SELECT * FROM horses";
    	List<Horse_DTO> horses = new ArrayList<>();
    	try(Connection conn = getConnection();
    			PreparedStatement stmt = conn.prepareStatement(sql);
    					ResultSet rs = stmt.executeQuery()){
       		while(rs.next()) {
       			int horseId = rs.getInt("horse_id");
       			String horseName = rs.getString("horse_name");
       			horses.add(new Horse_DTO(horseId,horseName));
       		}
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
    	
    	return horses;
    	
    }
    
    //8. 경마 추가
    public void addHorse(int horseId, String horseName) {
    	String sql = "INSERT INTO horses (horse_id, horse_name) VALUES (?, ?)";
    	try (Connection conn = getConnection();
    	         PreparedStatement stmt = conn.prepareStatement(sql)) {
    	        stmt.setInt(1, horseId);
    	        stmt.setString(2, horseName);
    	        stmt.executeUpdate();
    	        System.out.println("경마가 성공적으로 추가되었습니다.");
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        System.out.println("경마 추가에 실패했습니다.");
    	    }
    }
    
    //9. 배팅 기록 조회
    public List<Betting_DTO> getBettingRecords(String memeberId){
    	List<Betting_DTO> records = new ArrayList<>();
    	String sql = "SELECT batting_id, member_id, horse_id, betting_cash, betting_day FROM betting WHERE member_id = ? ORDER BY betting_day DESC";
    	
    	try (Connection conn =getConnection();
    			PreparedStatement stmt = conn.prepareStatement(sql)){
    			stmt.setString(1, memeberId);
    			ResultSet rs = stmt.executeQuery();
    			
    			while(rs.next()) {
    				int bettingId = rs.getInt("batting_id");
    				int horseId = rs.getInt("horse_id");
    				double bettingCash = rs.getDouble("betting_cash");
    				Date bettingDay = rs.getDate("betting_day");
    				
    				// Betting_DTO 타입의 리스트에 배팅 기록 저장
    				records.add(new Betting_DTO(bettingId, memeberId, horseId, bettingCash, bettingDay));
    			}
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return records;
    }
    
}
