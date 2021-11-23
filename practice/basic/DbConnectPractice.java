package practice.basic;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

public class DbConnectPractice {

	public static void main(String[] args) {

		// mysql jar파일(드라이브파일)을 jre system library에 넣어주면서 연결하기. 빌드패스
		// 해당하는 현재 프로젝트에만 연결된 상태. 필요시 프로젝트별로 연결을 해줘야함.

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbctest";
		String userid = "root";
		String passwd = "dovmf5@#$";

		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null; //쿼리문에서 ?을 이용해서 쿼리문을 완성할 수 있는 인터페이스.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("deptno==>");
		int deptNoValue = sc.nextInt();
		System.out.println(deptNoValue);

		try {
			Class.forName(driver);
			System.out.println("드라이브 연결 성공함. ");
			connect = DriverManager.getConnection(url, userid, passwd); // connection 맺기
			stmt = connect.createStatement();
			
			String query = "select deptno, dname, loc from dept";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int deptno = rs.getInt("deptno"); // columnLabel 열이름
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno + " " + dname + " " + loc);
			}

			// emp 테이블에 있는 것 모두 검색하기.
			query = "select * from emp";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");

//				BigDecimal sal = rs.getBigDecimal("sal");
//				BigDecimal comm = rs.getBigDecimal("comm");
//				BigDecimal deptno = rs.getBigDecimal("deptno");
				//double도 됨.
				Double sal = rs.getDouble("sal");
				Double comm = rs.getDouble("comm");
				Double deptno = rs.getDouble("deptno");



				System.out.println(empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+sal+" "+comm+" "+deptno);
			}
			System.out.println("=================2. 삽입하기.================="); // 
			query = "insert into dept(deptno,dname,loc) values(50,'개발','서울')";
			int insertOk = stmt.executeUpdate(query);
			if (insertOk==1) System.out.println("데이터베이스안에 삽입됩니다.");
			// emp테이블 삽입. 
			query = "insert into emp(empno)values(7777)";
			
			System.out.println("=================3. 수정하기.================="); // 
			query = "update dept set dname='서종국' where deptno = 20";
			int updateOk = stmt.executeUpdate(query);
			query = "update emp set sal =sal+(sal*0.1) where sal between 2000 and 3000";
			updateOk = stmt.executeUpdate(query);
			System.out.println("업데이트됩니다."); 
			
			//emp테이블에서 deptno가 30인 사람의 comm을 +100 넣어주기
			query = "update emp set comm = comm+100 where deptno = 30";
			stmt.executeUpdate(query);
			// dept 콘솔로 입력받아 변수에 담아 이를 적용시키기.
			query = "update emp set comm = comm+100 where deptno = ?"; //? 파라미터인덱스. 물음표 여러개 있을시 구분.
			
			pstmt = connect.prepareStatement(query);
			System.out.println(pstmt);
			pstmt.setInt(1, deptNoValue); //첫번째 물음표에 30을 넣어라.
			pstmt.executeUpdate();
			
			// empno가 7839 이거나 job clerk인 것을 sal 10% 증가
			System.out.print("empno==> ");
			int empnoinput=sc.nextInt();
			System.out.print("job==> ");
			String jobinput=sc.next();
			System.out.println(jobinput);
			
			query = "update emp set sal = sal*1.1 where empno= ? or job = ? ";
			
			pstmt = connect.prepareStatement(query);
			System.out.println(pstmt);
			pstmt.setInt(1, empnoinput); //첫번째 물음표에 30을 넣어라.
			pstmt.setString(2, jobinput); //2번째 물음표에 30을 넣어라.
			pstmt.executeUpdate();
			
			// 4. 삭제하기  delete from dept where deptno=? 
			
			query = "delete from dept where deptno=?";
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, 50);
			int deleteOk = pstmt.executeUpdate();
			System.out.println(deleteOk);
			if(deleteOk==1) System.out.println("삭제성공");
			
		} catch (Exception e) {
			System.out.println("드라이브 연결 실패함. ");
			e.printStackTrace();
		}

	}

}
