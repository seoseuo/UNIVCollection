# JDBC란?

- 자바 언어로 `데이터베이스 프로그래밍`을 하기 위한 라이브러리
- 특정한 DBMS에 종속되지 않는 관련 API를 제공한다.

# JDBC 구조

- `JDBC 드라이버 매니저` : 자바 API에서 지원하며 DBMS를 접근할 수 있는 JDBC 드라이버 로드
- `JDBC 드라이버` : DBMS마다 고유한 JDBC 드라이버를 제공, JDBC 드라이버와 DBMS는 전용 프로토콜로 데이터베이스를 처리
- `DBMS` : 데이터베이스 관리 시스템. 데이터베이스 생성, 삭제, 데이터 생성, 검색, 삭제 등 전담 소프트웨어 시스템

> DBMS : DataBase Management System
> 

# JDBC역할

- 다양한 DBMS에 독립적으로 데이터베이스 프로그래밍을 가능하도록 하는 API 규격
    - 오라클, MySQL,SQLServer,DB2 등 어떤 DBMS를 사용하던지 소스의 수정을 최소화하여 바로 실행
    - JDBC와 함께 JDBC 드라이버도 필요

# JDBC 데이터베이스 프로그래밍 절차

1. java.sql 패키지 임포트   
    1.  `import java.sql.*;`
        
        ```java
        import java.sql.*;
        public class JdbcDriver {
        }
        ```
        
2. DBMS 드라이버를 로드 
    1. `Class.for.Name()`
        
        ```java
        try {
        Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }
        ```
        
        - Class.for.Name()은 동적으로 자바 클래스를 로딩한다.
        - MySQL의 JDBC드라이버 클래스인 `com.mysql.cj.jdbc.Dirver`로드
        - 드라이버 클래스의 이름은 DB의 드라이버마다 다를 수 있다. JDBC드라이버 문서 참조
        - 자동으로 드라이버 인스턴스를 생성하여 DriverManager에 등록
        - 해당 드라이버가 없으면 `ClassNotFoundExcepion`이 발생한다.
            - 철자 틀린 것 없는 지 확인
            - build path에 드라이버 등록 하였는지 확인한다.
3. DB에 연결                      
    1. `Connection getConnection(String url, String id, String pw)` : 해당 URL로 DB에 연결
    
    DriverManager : JDBC 드라이버에 연결시켜주는 클래스
    
    URL 구조
    
    - jdbc protocol : *subprotocol* : **ip:port/dbname**
    
    ```java
    try {
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_dbl?useSSL=false",
    	"root",“111113333“);
    		} catch (SQLException e) {
    	e.printStackTrace();
    }
    ```
    
    **3단계 까지의 코드 합본**
    
    DB URL : "jdbc:mysql://localhost:3306/jdbc_db?useSSL=false”
    
    ```java
    import java.sql.*;
    public class JdbcConnect {
    	public static void main(String[] args) {
    
    		Connection conn=null;
    			String driverName = "com.mysql.jdbc.Driver";
    			String DBName = "jdbc_db";
    			String dbURL = "jdbc:mysql://localhost:3306/" + DBName;
    			String sslStr="?useSSL=false";
    				try {
    				Class.forName("com.mysql.jdbc.Driver");
    				System.out.println("JDBC driver load success");
    				conn = DriverManager.getConnection(dbURL+sslStr
    				, "root","1111133333");
    				System.out.println("DB connection success");
    
    				} catch (ClassNotFoundException e) {
    					System.out.println("JDBC driver load fail !!");
    				} catch (SQLException e) {
    					System.out.println("DB connection fail !!");
    				}
    
    				finally
    				{
    				try
    					{
    
    					if(conn!=null) {
    					conn.close();
    					System.out.println("DB connection close success");
    					}
    
    				}catch (SQLException e) {
    					System.out.println("DB connection close exception !!");
    				}
    		}
    
    	}
    }
    ```
    
4. SQL문 객체 생성            
    1. `prepareSatatement()`
    - Statement 인터페이스
        - SQL문 설정 및 전송
        - Connection 인터페이스의 createStatement()를 통해 얻음
        
        ```java
        Connection con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
        Statement stmt = con.createStatement()
        ```
        
    
    - PreparedStatement 인터페이스
        - SQL문의 구조는 Statement와 동일하나 SQL문의 값들을 변수로 처리함
        - 재사용성, 보안 및 속도 향상
        
        ```java
        String sql = "insert into user values (?, ?, ?,?)";
        
        con = DriverManager.getConnection()
        
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,“apple”);
        pstmt.setString(2,“orange");
        pstmt.setString(3,“melon");
        pstmt.setInt(4,20000);
        ```
        
5. SQL문 전송         
    1. `ResultSet executeQuery(String sql)`
        1. 하나의 ResultSet을 만드는 SQL문에서 사용 executeQuery메소드는 ResultSet객체를 리턴 주로 ***SELECT*** 문을 이용하는 조회에서 사용됨.
    2. `int executeUpdate(String sql)`
        1. ***INSERT, UPDATE, DELETE***등 (DML), ***CREATE,DROP*** 등(DDL)문들을 실행하는데 사용
    3. void close()
        1. Statement객체의 데이터베이스와 JDBC 리소스를 즉시 반환
    
    `데이터 검색 (SELECT)` : executeQuery()
    
    `그 이외` : executeUpdate()
    
    ```java
    stmt.executeUpdate("insert into User values ('apple', 'orange', 'melon');");
    ```
    
    ```java
    resultSet = pstmt.executeQuery();
    ```
    
6. SQL문 결과 받기
    1. `ResultSet` 인터페이스
        1. 검색 시 SQL문 실행 결과가 저장됨.
        
        ![Untitled](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F1cad3874-28e6-407c-a147-e4a4ed5b4747%2FUntitled.png?id=98493362-a7cf-4ffe-8148-cb9f1aaeb467&table=block&spaceId=f02911ff-a5c6-4c9a-ae3e-63ed719e4cfe&width=1670&userId=fc7411bc-598e-431d-b643-0d71559a3db0&cache=v2)
        
    
    - 실질적으로 질의 결과의 자료가 있는 영역과 함께 BOF , EOF 제공
        - 첫 행 자료 이전 : (Before the First Row)에 BOF `Begin Of File`
        - 마지막 행 자료 이후 : (After the Last Row)에 EOF`End Of File`
    - 각각의 행에서 각 칼럼은 ***************************************************************************************칼럼 이름 또는 번호 순***************************************************************************************으로 식별
        - 번호는 1부터 시작
    - ResultSet 에서 모든 데이터를 다 읽어들인 후에는 close()를 호출하여 자원 해제
        
        ![
        ](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fd1d44487-7cf5-4911-90b1-5b969988194e%2FUntitled.png?id=42041786-6813-4077-af17-36ec4f0d1e47&table=block&spaceId=f02911ff-a5c6-4c9a-ae3e-63ed719e4cfe&width=1430&userId=fc7411bc-598e-431d-b643-0d71559a3db0&cache=v2)
        
7. 모든 객체를 해제
    1. `close`
    - 객체가 만들어지는 순서의 역순으로 해제
        - 생성순서
            1. `Connection`
            2. `Statement` or `PreparedStatement`
            3. `ResultSet`
        - 해제 순서는 생성 순서의 역순
    - 해제 시 각 객체마다 예외처리 구문을 넣어줘야 함.
    
    ```java
    if (stmt != null) {
    	try{
    		stmt.close(); 
    		} 
    		catch(SQLException ex) {
    		}
    	}
    		if (con != null) {
    		try {
    		con.close(); 
    		}
    		catch(SQLException ex) {
    	}
    }
    
    ResultSet 과 PrepareStatement도 동일한 방법으로 close해준다.
    ```
    
    # 레코드 삽입
    
    - **테이블을 생성하는 SQL 문장 `create`**
        - 형식 : `CREATE TABLE 테이블명(테이블 내용)`
        - 참고 코드
        
        ```java
        
        try {
        	Class.forName(driverName);
        	con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
        	***stmt = con.createStatement();
        	stmt.executeUpdate("insert into User values ('apple', 'orange', 'melon',20000);");
        	stmt.executeUpdate("insert into User values ('chair', 'desk', 'key',1000);");
        	stmt.executeUpdate("insert into User values ('deck', 'keyboard', 'mouse',0);");***
        	System.out.println("3 rows is inserted");
        }
        ```
        
    - 값 삽입
        - 형식
        
        ```java
        String sql = "insert into user values (?, ?, ?,?)";
        try {
        	
        	DB 연결과정까지 구현
        ------------------------- 
        	***pstmt = con.prepareStatement(sql);
        	pstmt.setString(1,"dog"); 
        	pstmt.setString(2,"cat");
        	pstmt.setString(3,"lion");
        	pstmt.setInt(4,5000);
        	retval=pstmt.executeUpdate();***
        }
        ```
        

# 데이터 검색

- **테이블의 모든 데이터 검색**
    
    ```java
    String SQL = "SELECT * FROM USER";
    Statement stmt = conn.createStatement();
    ResultSet resultSet = smtm.excuteQuery(SQL);
    ```
    
    - Statement의 executeQuery()는 SQL문에 실행하여 결과를 넘겨줌
    - 위의 SQL문의 user 테이블에서 모든 행의 모든 열을 읽어 결과를 resultSet에 저장
    
    ![Untitled]https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F29d37ddd-f662-4065-b0a5-4a070629ae9c%2FUntitled.png?id=d32ac30f-44c9-41d7-a394-6bd70f2a613e&table=block&spaceId=f02911ff-a5c6-4c9a-ae3e-63ed719e4cfe&width=1530&userId=fc7411bc-598e-431d-b643-0d71559a3db0&cache=v2)
    
- **ResultSet에서 데이터를 얻는 방법**
    - 행과 열을 지정
        - 행 : ResultSet의 next()를 이용 이동 및 지정
        - 열: getXXX()를 이용하여 칼럼 이름이나 칼럼 번호를 지정
        
        ![Untitled](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F1e101f79-1938-4999-bb52-7cfc68bf0a1d%2FUntitled.png?id=b1409326-5fc1-42b0-ab3d-9de3b5e6c7ae&table=block&spaceId=f02911ff-a5c6-4c9a-ae3e-63ed719e4cfe&width=1530&userId=fc7411bc-598e-431d-b643-0d71559a3db0&cache=v2)
        
- **특정 열만 검색**
    
    ```java
    ResultSet rs = stmt.executeQuery("SELECT id,addr FROM user");
    ```
    
    - 특정 열만 읽을 경우는 SELECT문을 이용하여 특정 열의 이름 지정
    - id 와 addr 열만 읽을 것 이기 때문에 상단의 코드엔 id,addr만 기입.

- ********************조건 검색********************
    - SELECT문에서 WHERE 절을 이용하여 조건에 맞는 데이터 검색
    
    ```java
    ***String sql = "SELECT addr FROM user WHERE id=?";
    String UserId = "apple";***
    
    try {
    	Class.forName(driverName);
    	con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
    
    	***pstmt = con.prepareStatement(sql);
    	pstmt.setString(1,UserId);
    
    	resultSet = pstmt.executeQuery();
    
    	while(resultSet.next()) {
    		System.out.println(resultSet.getString("addr"));
    	}***
    } catch ~~~~
    ```
    
    - LIKE
    
    ```java
    ***String sql = "SELECT id FROM user WHERE id Like ?";***
    ***String UserId = "_"+"pp"+"%";***
    
    try {
    	Class.forName(driverName);
    	con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
    
    	***pstmt = con.prepareStatement(sql);
    	pstmt.setString(1, UserId);
    
    	resultSet = pstmt.executeQuery();
    
    	while (resultSet.next()) {
    		System.out.println(resultSet.getString("id"));
    	}***
    }
    	
    ```
    
    # 집계함수
    
    | 집계함수 | 설명 |
    | --- | --- |
    | COUNT() | COUNT() 함수는 선택된 필드에서 특정 조건을 만족하는 레코드의 총 개수를 반환 |
    | MIN() | MIN() 함수는 선택된 필드에 저장된 값 중 가장 작은 값을 반환합니다. |
    | MAX() | MAX() 함수는 선택된 필드에 저장된 값 중 가장 큰 값을 반환합니다. |
    | SUM() | SUM() 함수는 선택된 숫자 타입의 필드에 저장된 값의 총 합을 반환 |
    | AVG() | AVG() 함수는 선택된 숫자 타입의 필드에 저장된 값의 평균값을 반환 |

- COUNT

```java
***String sslStr="?useSSL=false";
String sql = "select count(*) from mem";***

try {
	Class.forName(driverName);
	con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
	
	***pstmt = con.prepareStatement(sql);
	resultSet = pstmt.executeQuery();***

	***while (resultSet.next()) {
	System.out.println("count : "+resultSet.getInt(1));
	}***
}
```

- COUNT AS ~

```java
***String sql = "select count(*) as count from mem";***

try {
	Class.forName(driverName);
	con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
	
	***pstmt = con.prepareStatement(sql);
	resultSet = pstmt.executeQuery();***

	***while (resultSet.next()) 
	{
	System.out.println("count : "+resultSet.getString("count"));
	}***
}
```

- AVG AS

```java
***String sql = "select avg(age) as avg_age from mem where age >=?;";
int age=20;***

try {
	Class.forName(driverName);
	con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
	
	***pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, age);

	resultSet = pstmt.executeQuery();

	while (resultSet.next()) 
	{
	System.out.println("avg : "+resultSet.getString("avg_age"));
	}***
}
```

# 데이터 수정

```java
***String sql = "UPDATE user SET pw=? where id=?";
String UserId="apple";
String UserPw="starfruit";

try {***
	Class.forName(driverName);
	con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
	
***pstmt = con.prepareStatement(sql);
	pstmt.setString(1, UserPw);
	pstmt.setString(2, UserId);

	retval = pstmt.executeUpdate();

	System.out.println(retval+" is updated");
}***

```

# 데이터 삭제

```java
***String sql = "SELECT addr FROM user where id=?";
String UserId="apple";***

try {
	Class.forName(driverName);
	con = DriverManager.getConnection(dbURL+sslStr, "root", "1111133333");
	
	***pstmt = con.prepareStatement(sql);
	pstmt.setString(1, UserId);***

	***resultSet = pstmt.executeQuery();***

	***while (resultSet.next()) 
	{
	System.out.println(resultSet.getString("addr"));
	}***
}
```
