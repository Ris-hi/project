package JSON.COM.trail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repos 
{
	Connection con= null;
    List<Book> bkk;
	public Repos() {
		
		 String url="jdbc:mysql://localhost:3306/demo";
	  	 String name="root";
	  	 String pass="14569";
	  	  try {
	  		  Class.forName("com.mysql.jdbc.Driver");
	  	      con=DriverManager.getConnection(url,name,pass);
	  	  
	        }
	  	  catch(Exception e) {
	  		  System.out.println(e);
	  	}
    	bkk=new ArrayList<>();
    	Book b1=new Book();
    	b1.setIdbn(2333);
        List<String> c=new ArrayList<>();	
    	c.add("ROMCOM");
    	c.add("SITCOM");
    	b1.setCatogery(c);
    	
    	b1.setTitle("BOOK OF BIRDS");
    	
    	Editior e=new Editior();
    	e.setFirstName("selena");
    	e.setLastName("kyle");
        Authour a=new Authour();
        a.setFirstName("james");
        a.setLastName("luthor");
        
        b1.setAuthor(a);
    	b1.setEditor(e);
    	bkk.add(b1);
    	System.out.println(b1);
    }

	@SuppressWarnings("unchecked")
	public List<Book> getBookDetails() {
		String sql="select * from books";
		Book bk=new Book();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				
				  bk.setIdbn(rs.getInt(1));
	  			  bk.setCatogery((List<String>) rs.getArray(6));
	  			  Editior e=new Editior();
	  			  e.setFirstName(rs.getString(4));
	  			  e.setLastName(rs.getString(5));
	  			  bk.setEditor(e);
	  			  Authour a=new Authour();
	  			  a.setFirstName(rs.getString(2));
	  			  a.setLastName(rs.getString(3));
	  			  bk.setAuthor(a);   
	  		  }
			    
			bkk.add(bk);
			}
			
		
		catch(Exception e) {
			System.out.println(e);
		}
	    return bkk;
	}

	@SuppressWarnings("unchecked")
	public Book getBookdetail(int id) {
		
		Book bk=new Book();
	  	  String sql = "select * from books where id="+id;
	  	  try {
	  		  Statement st= con.createStatement();
	  		  ResultSet rs=st.executeQuery(sql);
	  		  if(rs.next()) {
	  			  bk.setIdbn(rs.getInt(1));
	  			  bk.setCatogery((List<String>) rs.getArray(6));
	  			  Editior e=new Editior();
	  			  e.setFirstName(rs.getString(4));
	  			  e.setLastName(rs.getString(5));
	  			  bk.setEditor(e);
	  			  Authour a=new Authour();
	  			  a.setFirstName(rs.getString(2));
	  			  a.setLastName(rs.getString(3));
	  			  bk.setAuthor(a);   
	  		  }
	  		  System.out.println("Message: data retrived with id="+id);
	  		  System.out.print("Details:");
	  		  return bk; 
	  	  }
	  	  catch(Exception e) {
	  		  System.out.println(e);
	  	  }
	  	  
	  	 
	  	  
	  	 return new Book();
	}

}
