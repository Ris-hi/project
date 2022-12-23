package new1.kcs.appIntro;

import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("app-Introduction")
public class appDetailsResource {
   appDetailsRepository repo=new appDetailsRepository(); 
   @GET
   @Produces({ MediaType.APPLICATION_JSON})
   public List<appDetails> getDetails(){
		System.out.print("eheh");   
		return repo.getAppDetails();
		   
	   }
	   
	@GET
	@Path("page/{id}")
	@Produces({MediaType.APPLICATION_JSON,})
	public appDetails getDetail(@PathParam("id") int id) {
		
		return repo.getAppdetail(id);
	}
	@POST
	@Path("page")
	@Consumes({MediaType.APPLICATION_JSON})
	public appDetails createBabe(appDetails a1) {
		 System.out.println(a1);
		 repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("page")
	@Consumes(MediaType.APPLICATION_JSON)
    public appDetails updateBabe(appDetails a1) {
    	 System.out.println(a1);
    	 if(repo.getAppdetail(a1.getId()).getId()==0) {
    		 repo.create(a1);
    	 }
    	 else {
    		 repo.update(a1);
    	 }
		return a1;
    }
	
	@DELETE
	@Path("page/{id}")
	
	public appDetails deleteBabe(@PathParam("id") int id) {
		
	    appDetails a=repo.getAppdetail(id);
	    if(a.getId()!=0) {
	    	repo.delete(id);
	    }
		return a;
	}
}
