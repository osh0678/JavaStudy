package com.javalec.ex;

import java.io.StringReader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
--테스트 테이블
CREATE TABLE BIG_TEST
(
  K    VARCHAR2(10) NOT NULL,
  A    VARCHAR2(4000),
  B    VARCHAR2(4000),
  C    VARCHAR2(4000),
  PRIMARY KEY (K)
);
*/
public class BigTest {
  Connection conn = null;
  Statement stmt = null;
  PreparedStatement pstmt = null;

  public BigTest() {
	  System.out.println(Charset.defaultCharset());
    Properties prop = new Properties();
    prop.put("driver", "oracle.jdbc.driver.OracleDriver");
    prop.put("url", "jdbc:oracle:thin:@211.238.138.200:1521:TESTSTD");
    prop.put("user", "tds");
    prop.put("password", "tds");

    try {
      Class.forName(prop.getProperty("driver"));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.exit(-1);
    }

    try {
      conn = DriverManager.getConnection(prop.getProperty("url"), prop);
    } catch(SQLException e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  public void start() {
    try {
      DatabaseMetaData dbmd = conn.getMetaData();
      System.out.println("DB Version : " + dbmd.getDatabaseProductVersion());
      System.out.println("Driver Version : " + dbmd.getDriverVersion());
      System.out.println();
        
      stmt = conn.createStatement();

      String k = "1";

      String a = 
          "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
          "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
          "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
          "서울=연합뉴스) 김가희 기자 = 탤런트 이의정(31)이 갑작스럽게 뇌종양 판정을 받아 12일 곧바로 수술할 예정이다." +
          "이의정의 한 측근은 10일 밤 \"삼성서울병원에 입원중인 이의정이 오늘 뇌종양 판정을 받아 12일로 수술날짜를 잡았다\"고 " +
          "밝히며 \"악성인지, 양성인지 여부는 내일 나오지만 병원측에서 이에 상관없이 수술은 받아야 한다고 했다\"고 전했다." +
          "이의정은 지난달 30일 강원도 원주에서 온미디어가 제작중인 TV용 코믹영화 '사파리' 촬영 도중 심한 두통을 호소해 인근 " +
          "병원으로 옮겨진 후 서울로 와 삼성서울병원에서 정밀 검사를 받았다.이어 이 측근은 \"병원측이 '스트레스성 뇌종양'일 " +
          "가능성이 높다고 말했다고 한다. 요즘 젊은 사람들이 이 병에 걸리는 경우가 꽤 있다고 의정씨에게 설명해줬다\"고 말했다." +
          "이의정은 연기 뿐 아니라 최근에는 온라인 주얼리 쇼핑몰과 충남 천안 소재 대형 쇼핑몰에 옷가게를 내는 등 사업가로도 나서 " +
          "바쁜 시간을 보내고 있다.시트콤 '남자셋 여자셋' '세친구' 등에 출연하며 인기를 모은 이의정은 드라마 '루루공주' '지금은 " +
          "연애중' 등에 출연했고, 라디오 DJ로 오랫동안 활약했으며 음반을 발표하기도 하는 등 만능재주꾼의 면모를 보여왔다. " +
          "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
          "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
          "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
          "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
          "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

      String b = 
          "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" +
          "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" +
          "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" +
          "서울=연합뉴스) 김가희 기자 = 탤런트 이의정(31)이 갑작스럽게 뇌종양 판정을 받아 12일 곧바로 수술할 예정이다." +
          "이의정의 한 측근은 10일 밤 \"삼성서울병원에 입원중인 이의정이 오늘 뇌종양 판정을 받아 12일로 수술날짜를 잡았다\"고 " +
          "밝히며 \"악성인지, 양성인지 여부는 내일 나오지만 병원측에서 이에 상관없이 수술은 받아야 한다고 했다\"고 전했다." +
          "이의정은 지난달 30일 강원도 원주에서 온미디어가 제작중인 TV용 코믹영화 '사파리' 촬영 도중 심한 두통을 호소해 인근 " +
          "병원으로 옮겨진 후 서울로 와 삼성서울병원에서 정밀 검사를 받았다.이어 이 측근은 \"병원측이 '스트레스성 뇌종양'일 " +
          "가능성이 높다고 말했다고 한다. 요즘 젊은 사람들이 이 병에 걸리는 경우가 꽤 있다고 의정씨에게 설명해줬다\"고 말했다." +
          "이의정은 연기 뿐 아니라 최근에는 온라인 주얼리 쇼핑몰과 충남 천안 소재 대형 쇼핑몰에 옷가게를 내는 등 사업가로도 나서 " +
          "바쁜 시간을 보내고 있다.시트콤 '남자셋 여자셋' '세친구' 등에 출연하며 인기를 모은 이의정은 드라마 '루루공주' '지금은 " +
          "연애중' 등에 출연했고, 라디오 DJ로 오랫동안 활약했으며 음반을 발표하기도 하는 등 만능재주꾼의 면모를 보여왔다. " +
          "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" +
          "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" +
          "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" +
          "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB" +
          "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";

      String c = 
          "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
          "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
          "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
          "서울=연합뉴스) 김가희 기자 = 탤런트 이의정(31)이 갑작스럽게 뇌종양 판정을 받아 12일 곧바로 수술할 예정이다." +
          "이의정의 한 측근은 10일 밤 \"삼성서울병원에 입원중인 이의정이 오늘 뇌종양 판정을 받아 12일로 수술날짜를 잡았다\"고 " +
          "밝히며 \"악성인지, 양성인지 여부는 내일 나오지만 병원측에서 이에 상관없이 수술은 받아야 한다고 했다\"고 전했다." +
          "이의정은 지난달 30일 강원도 원주에서 온미디어가 제작중인 TV용 코믹영화 '사파리' 촬영 도중 심한 두통을 호소해 인근 " +
          "병원으로 옮겨진 후 서울로 와 삼성서울병원에서 정밀 검사를 받았다.이어 이 측근은 \"병원측이 '스트레스성 뇌종양'일 " +
          "가능성이 높다고 말했다고 한다. 요즘 젊은 사람들이 이 병에 걸리는 경우가 꽤 있다고 의정씨에게 설명해줬다\"고 말했다." +
          "이의정은 연기 뿐 아니라 최근에는 온라인 주얼리 쇼핑몰과 충남 천안 소재 대형 쇼핑몰에 옷가게를 내는 등 사업가로도 나서 " +
          "바쁜 시간을 보내고 있다.시트콤 '남자셋 여자셋' '세친구' 등에 출연하며 인기를 모은 이의정은 드라마 '루루공주' '지금은 " +
          "연애중' 등에 출연했고, 라디오 DJ로 오랫동안 활약했으며 음반을 발표하기도 하는 등 만능재주꾼의 면모를 보여왔다. " +
          "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
          "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
          "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
          "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" +
          "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC";
      
      stmt.executeUpdate("delete from BIG_TEST where K = '" + k + "' ");
      
//      a += a + a.substring(0, 583);
//      b += b + b.substring(0, 583);
//      c += c + c.substring(0, 583);
      
      a += "A";
      b += "B";
      c += "C";
      
      System.out.println("A : bytes=" + a.getBytes().length + ", UTF8 bytes=" + a.getBytes("UTF8").length);
      System.out.println("B : bytes=" + b.getBytes().length + ", UTF8 bytes=" + b.getBytes("UTF8").length);
      System.out.println("C : bytes=" + c.getBytes().length + ", UTF8 bytes=" + c.getBytes("UTF8").length);
      System.out.println();
      
      pstmt = conn.prepareStatement(
              "insert into BIG_TEST \n" +
              "(K, A, B, C) values \n" +
//              "('" + k + "', '" + escapeSql(a) + "', '" + escapeSql(b) + "', '" + escapeSql(c) + "') "
              "(?, ?, ?, ?) "
      );

      pstmt.setString(1, k);
      
//      pstmt.setCharacterStream(2, new StringReader(a), a.length());
//      pstmt.setCharacterStream(3, new StringReader(b), b.length());
//      pstmt.setCharacterStream(4, new StringReader(c), c.length());
      
      pstmt.setString(2, a);
      pstmt.setString(3, b);
      pstmt.setString(4, c);
      
      pstmt.executeUpdate();
      
      ResultSet rs = null;
      rs = stmt.executeQuery(
              "select substr(A, 1, 10) as A, \n" + 
              "       substr(B, 1, 10) as B, \n" +
              "       substr(C, 1, 10) as C  \n" +
              "from BIG_TEST                 \n" +
              "where K = '" + k + "'         \n"
      );
      
      displayResult(rs);
      System.out.println();
      
      rs = stmt.executeQuery(
              "select lengthb(A) as A, \n" + 
              "       lengthb(B) as B, \n" +
              "       lengthb(C) as C  \n" +
              "from BIG_TEST           \n" +
              "where K = '" + k + "'   \n"
      );
      
      displayResult(rs);
      
    } catch(SQLException se) {
      se.printStackTrace();
    } catch(Exception se) {
      se.printStackTrace();
    } finally {
      try {
        if (pstmt != null) pstmt.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
      } catch (SQLException se) { }
    }
  }
  
  public String escapeSql(String value) {
      if (value == null) return null;
      
      value = replace(value, "'", "''");
//      value = replace(value, "&", "\\&");
      
      return value;
  }

  public String replace(String str, String pattern, String replace) {
    if (str == null) return str;

    int s = 0;
    int e = 0;
    StringBuffer buf = new StringBuffer();

    while ((e = str.indexOf(pattern, s)) >= 0) {
      buf.append(str.substring(s, e));
      buf.append(replace);
      s = e + pattern.length();
    }
    buf.append(str.substring(s));

    return buf.toString();
  }
  
  public void displayResult(ResultSet rs) throws SQLException {
      ResultSetMetaData rsmd = rs.getMetaData();
      
      int[] dspSize = new int[rsmd.getColumnCount()];
      
      // 컬럼명
      for (int i = 0; i < dspSize.length; i++) {
          dspSize[i] = rsmd.getColumnDisplaySize(i + 1);
          String colName = rsmd.getColumnName(i + 1);
          
          System.out.print(fixStr(colName, dspSize[i]) + " ");
      }
      System.out.println();
      
      // 구분선
      for (int i = 0; i < dspSize.length; i++) {
          StringBuffer buf = new StringBuffer();
          for (int j = 0; j < dspSize[i]; j++ ) {
              buf.append('-');
          }
          buf.append(' ');
          
          System.out.print(buf.toString());
      }
      System.out.println();
      
      // 데이타
      while (rs.next()) {
          for (int i = 0; i < dspSize.length; i++) {
              String value = rs.getString(i + 1);
              
              System.out.print(fixStr(value, dspSize[i]) + " ");
          }
          System.out.println();
      }
      
      rs.close();
  }
  
  public String fixStr(String str, int dspSize) {
      if (str == null) str = "";
      
      int size = dspSize - str.length();
      
      if (size > 0) {
          char space = ' ';
          StringBuffer buf = new StringBuffer(str);
          for (int i = 0; i < size; i++) {
              buf.append(space);
          }
          
          str = buf.toString();
      } else if (size < 0) {
          str = str.substring(0, dspSize);
      }
      
      return str;
  }

  public static void main(String[] args) {
    BigTest test = new BigTest();
    test.start();
  }

}
