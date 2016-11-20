package com.services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.DAO.*;
import com.models.*;

@Path("/eater")
@Produces(MediaType.TEXT_PLAIN)
public class EaterServices {

	@POST
	@Path("/signup")
	public String signup(@FormParam("uname") String userName, @FormParam("pass") String password,
			@FormParam("email") String email, @FormParam("phone") String phone) {

		Eater eater = new Eater(0, userName, email, password, phone);

		EaterDAO dao = new EaterDAO();
		int id = dao.addEater(eater);

		return JSONBuilder.convertIDToJSON(id).toJSONString();
	}

	@POST
	@Path("/login")
	public String login(@FormParam("email") String email, @FormParam("pass") String password) {

		EaterDAO dao = new EaterDAO();
		Eater eater = dao.getEater(email, password);

		return JSONBuilder.convertEaterToJSON(eater).toJSONString();
	}

	@POST
	@Path("/updateProfile")
	public String updateProfile(@FormParam("id") int id, @FormParam("uname") String userName,
			@FormParam("pass") String password, @FormParam("phone") String phone) {

		Eater eater = new Eater(id, userName, "", password, phone);

		EaterDAO dao = new EaterDAO();
		String state = dao.updateEater(eater);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/updatePassword")
	public String updatePassword(@FormParam("id") int id, @FormParam("pass") String password) {

		EaterDAO dao = new EaterDAO();
		String state = dao.updatePassword(password, id);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/getEaterByID")
	public String getEaterByID(@FormParam("id") int id) {

		EaterDAO dao = new EaterDAO();
		Eater eater = dao.getEaterByID(id);

		return JSONBuilder.convertEaterToJSON(eater).toJSONString();
	}

	@POST
	@Path("/getBranches")
	public String getBranches() {

		BranchDAO dao = new BranchDAO();
		ArrayList<Branch> branches = dao.getBranches();

		return JSONBuilder.convertBranchesToJSON(branches).toJSONString();
	}
	@POST
	@Path("/filterBranchesByLocation")
	public String filterBranchesByLocation(@FormParam("location")String location) {

		BranchDAO dao = new BranchDAO();
		ArrayList<Branch> branches = dao.filterBranchesByLocation(location);

		return JSONBuilder.convertBranchesToJSON(branches).toJSONString();
	}
	@POST
	@Path("/getBranchByID")
	public String getBranch(@FormParam("id") int id) {

		BranchDAO dao = new BranchDAO();
		Branch branch = dao.getBranchByID(id);

		return JSONBuilder.convertBranchToJSON(branch).toJSONString();
	}
	
	@POST
	@Path("/getRestaurantInfo")
	public String getRestaurantInfo() {

		RestaurantDAO dao = new RestaurantDAO();
		Restaurant restaurant = dao.getRestaurantInfo();

		return JSONBuilder.convertRestaurantToJSON(restaurant).toJSONString();
	}

	@POST
	@Path("/getMenu")
	public String getMenu() {

		CategoryDAO dao = new CategoryDAO();
		ArrayList<Category> categories= dao.getMenu();

		return JSONBuilder.convertCategoriesToJSON(categories).toJSONString();
	}



	/*********************************************************************************/

	@GET
	@Path("/checkConnection")
	public String checkConnection() {
		Boolean state = DBConnection.getActiveConnection() != null;
		return "{\"state\":\"" + state + "\"}";
	}

	@GET
	@Path("/")
	public String getJSON() {
		return "{\"state\":\"HELLO\"}";
	}

}
