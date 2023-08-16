package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AddInfo;
import model.BasicInfo;

public class SearchDAO {
	
	private final String JDBC_URL="jdbc:mysql://localhost/theme";
	private final String DB_USER="root";
	private final String DB_PASS="pass";
	
	@SuppressWarnings("unchecked")
	public List<String>[] findByInfo(BasicInfo basicinfo){
		
		List<String> tList=new ArrayList<>();
		List<String> nList=new ArrayList<>();
		String title=basicinfo.getTitle();
		String sex=basicinfo.getSex();
		String genre=basicinfo.getGenre();
		String freeword=basicinfo.getFreeword();
		
		String sql="select basicinfo.title,basicinfo.name,sex,genre,concat(\n"
				+ "coalesce(freeword1,\"\"),\n"
				+ "coalesce(freeword2,\"\"),\n"
				+ "coalesce(freeword3,\"\"),\n"
				+ "coalesce(freeword4,\"\"),\n"
				+ "coalesce(freeword5,\"\"),\n"
				+ "coalesce(freeword6,\"\"),\n"
				+ "coalesce(freeword7,\"\"),\n"
				+ "coalesce(freeword8,\"\"),\n"
				+ "coalesce(freeword9,\"\"),\n"
				+ "coalesce(freeword10,\"\"))\n"
				+ "as freeword from basicinfo \n"
				+ "join addinfo on (basicinfo.name=addinfo.name  and basicinfo.title=addinfo.title)"
				+ "having";
		List<String> conditions = new ArrayList<>();
        List<Object> parameters = new ArrayList<>();
        
        if (title != null) {
            conditions.add("title like ?");
            parameters.add(title);
        }

        if (sex != null) {
            conditions.add("sex like ?");
            parameters.add(sex);
        }

        if (genre != null) {
            conditions.add("genre like ?");
            parameters.add(genre);
        }

        if (freeword != null) {
            conditions.add("freeword like ?");
            parameters.add(freeword);
        }

        if (conditions.isEmpty()) {
        	sql ="select basicinfo.title,basicinfo.name,sex,genre,concat(\n"
        			+ "coalesce(freeword1,\"\"),\n"
        			+ "coalesce(freeword2,\"\"),\n"
        			+ "coalesce(freeword3,\"\"),\n"
        			+ "coalesce(freeword4,\"\"),\n"
        			+ "coalesce(freeword5,\"\"),\n"
        			+ "coalesce(freeword6,\"\"),\n"
        			+ "coalesce(freeword7,\"\"),\n"
        			+ "coalesce(freeword8,\"\"),\n"
        			+ "coalesce(freeword9,\"\"),\n"
        			+ "coalesce(freeword10,\"\"))\n"
        			+ "as freeword from basicinfo \n"
        			+ "join addinfo on (basicinfo.name=addinfo.name  and basicinfo.title=addinfo.title)";
        	
        } else {
            sql += " " + String.join(" AND ", conditions);
        }

		
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			PreparedStatement pStmt=conn.prepareStatement(sql);
			
			for (int i = 0; i < parameters.size(); i++) {
				pStmt.setObject(i + 1, "%"+parameters.get(i)+"%");
            }

			try (ResultSet rs = pStmt.executeQuery()) {
                while (rs.next()) {
                    String rTitle = rs.getString("title");
                    String rName= rs.getString("name");
                    tList.add(rTitle);
                    nList.add(rName);
                }
            }	
			
			pStmt.close();
			
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		System.out.println("JDBCデータベース接続エラー");
		e.printStackTrace();
		return null;
	}
		return new List[] {tList, nList};
	}
	
	public List<AddInfo> aList(BasicInfo basicinfo){
		List<AddInfo> aList=new ArrayList<>();
		String title=basicinfo.getTitle();
		String name=basicinfo.getName();
		
		String sql="select basicinfo.title as title,basicinfo.name as name,sex,genre,\n"
				+ "freeword1,freeword2,freeword3,freeword4,freeword5,\n"
				+ "freeword6,freeword7,freeword8,freeword9,freeword10\n"
				+ "from basicinfo \n"
				+ "join addinfo on (basicinfo.name=addinfo.name and basicinfo.title=addinfo.title)\n"
				+ "having title like ? or name like ?";
        
        if (title==null) {
        	sql="select basicinfo.title as title,basicinfo.name as name,sex,genre,\n"
    				+ "freeword1,freeword2,freeword3,freeword4,freeword5,\n"
    				+ "freeword6,freeword7,freeword8,freeword9,freeword10\n"
    				+ "from basicinfo \n"
    				+ "join addinfo on (basicinfo.name=addinfo.name and basicinfo.title=addinfo.title)\n";
            
		}
		
        try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1, "%"+title+"%");
			pStmt.setString(2, "%"+name+"%");

			try (ResultSet rs = pStmt.executeQuery()) {
                while (rs.next()) {
                    String rTitle = rs.getString("title");
                    String rName= rs.getString("name");
                    String rSex=rs.getString("sex");
                    String rGenre=rs.getString("genre");
                    String rFreeword1=rs.getString("freeword1");
                    String rFreeword2=rs.getString("freeword2");
                    String rFreeword3=rs.getString("freeword3");
                    String rFreeword4=rs.getString("freeword4");
                    String rFreeword5=rs.getString("freeword5");
                    String rFreeword6=rs.getString("freeword6");
                    String rFreeword7=rs.getString("freeword7");
                    String rFreeword8=rs.getString("freeword8");
                    String rFreeword9=rs.getString("freeword9");
                    String rFreeword10=rs.getString("freeword10");
                    
                    AddInfo addinfo=new AddInfo(rTitle,rName,rSex,rGenre,rFreeword1,rFreeword2,rFreeword3,rFreeword4,rFreeword5,rFreeword6,rFreeword7,rFreeword8,rFreeword9,rFreeword10);
                    
                    aList.add(addinfo);
                }
            }		
			
			pStmt.close();
			
	} catch (SQLException e) {
		// TODO 自動生成された catch ブロック
		System.out.println("JDBCデータベース接続エラー");
		e.printStackTrace();
		return null;
	}
		return aList;
	}
}
