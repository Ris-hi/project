package new1.kcs.appIntro;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class appDetailsRepository {
      
	Connection con= null;
    
    public appDetailsRepository() {
  	  String url="jdbc:mysql://localhost:3306/App";
  	  String name="root";
  	  String pass="";
  	  try {
  		  Class.forName("com.mysql.jdbc.Driver");
  	      con=DriverManager.getConnection(url,name,pass);
  	  
        }
  	  catch(Exception e) {
  		  System.out.println(e);
  	  }
    }

	public List<appDetails> getAppDetails() {
		List<appDetails> adList=new ArrayList<>();
		String sql="select * from app_introduction";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				appDetails a=new appDetails();
				a.setDesc(rs.getString(4));
				a.setTitle(rs.getString(3));
				a.setImg_url(rs.getString(2));
				a.setId(rs.getInt(1));
				adList.add(a);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return adList;
	}

	public appDetails getAppdetail(int id) {
		
		appDetails a=new appDetails();
  	  String sql = "select * from app_introduction where id="+id;
  	  try {
  		  Statement st= con.createStatement();
  		  ResultSet rs=st.executeQuery(sql);
  		  if(rs.next()) {
  			  
  		      a.setId(rs.getInt(1));
  			  a.setImg_url(rs.getString(2));
  			  a.setDesc(rs.getString(4));
  			  a.setTitle(rs.getString(3));
  		  }
  		  System.out.println("Message: data retrived with id="+id);
  		  System.out.print("Details:");
  		  return a; 
  	  }
  	  catch(Exception e) {
  		  System.out.println(e);
  	  }
  	  
  	 
  	  
  	 return new appDetails();
	}

	public void create(appDetails a1) {
		String sql="insert into app_introduction values(?,?,?,?)";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getImg_url());
			st.setString(3, a1.getTitle());
			st.setString(4, a1.getDesc());
			st.executeUpdate();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void update(appDetails a1) {
		String sql="update app_introduction set title=? , desc=? where id=?";
		try {
			PreparedStatement st=con.prepareStatement(sql); 
			st.setInt(3,a1.getId());
			st.setString(2,a1.getDesc());
			st.setString(1,a1.getTitle());
			st.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void delete(int id) {
		String sql="delete from app_introduction where id=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,id);
			st.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
}
