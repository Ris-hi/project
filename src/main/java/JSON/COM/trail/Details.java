package JSON.COM.trail;
import java.util.*;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@SuppressWarnings("unused")
@Path("book")
public class Details 
{
	Repos repo=new Repos(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getDetails(){
		System.out.println("CALL");
		return repo.getBookDetails();
	}
	@GET
	@Path("book-id/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Book getDetail(@PathParam("id") int id) {
		return repo.getBookdetail(id);
	}
	

}
