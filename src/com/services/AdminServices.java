package com.services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.DAO.*;
import com.models.*;

@Path("/admin")
@Produces(MediaType.TEXT_PLAIN)
public class AdminServices {

	@POST
	@Path("/addBranch")
	public String addBranch(@FormParam("phone") String phone, @FormParam("location") String location,
			@FormParam("address") String address, @FormParam("lng") String lng, @FormParam("lat") String lat) {

		Branch branch = new Branch(0, phone, location, address, lng, lat);

		BranchDAO dao = new BranchDAO();
		int id = dao.addBranch(branch);

		return JSONBuilder.convertIDToJSON(id).toJSONString();
	}

	@POST
	@Path("/updateBranch")
	public String updateBranch(@FormParam("id") int id, @FormParam("phone") String phone,
			@FormParam("location") String location, @FormParam("address") String address, @FormParam("lng") String lng,
			@FormParam("lat") String lat) {

		Branch branch = new Branch(id, phone, location, address, lng, lat);

		BranchDAO dao = new BranchDAO();
		String state = dao.updateBranch(branch);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/deleteBranch")
	public String deleteBranch(@FormParam("id") int id) {

		BranchDAO dao = new BranchDAO();
		String state = dao.deleteBranch(id);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/addBranchImage")
	public String addBranchImage(@FormParam("branchID") int branchID, @FormParam("url") String url) {

		BranchImageDAO dao = new BranchImageDAO();
		int id = dao.addImage(branchID, url);

		return JSONBuilder.convertIDToJSON(id).toJSONString();
	}

	@POST
	@Path("/updateBranchImage")
	public String updateBranchImage(@FormParam("id") int id, @FormParam("branchID") int branchID,
			@FormParam("url") String url) {

		BranchImageDAO dao = new BranchImageDAO();
		String state = dao.updateImage(id, url, branchID);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/deleteBranchImage")
	public String deleteBranchImage(@FormParam("id") int id) {

		BranchImageDAO dao = new BranchImageDAO();
		String state = dao.deleteImage(id);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/addAdmin")
	public String addAdmin(@FormParam("name") String adminName, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("branchID") int branchID) {

		Admin admin = new Admin(0, adminName, email, password, branchID);

		AdminDAO dao = new AdminDAO();
		int id = dao.addAdmin(admin);

		return JSONBuilder.convertIDToJSON(id).toJSONString();
	}

	@POST
	@Path("/updateAdmin")
	public String updateAdmin(@FormParam("id") int id, @FormParam("name") String adminName,
			@FormParam("email") String email, @FormParam("password") String password,
			@FormParam("branchID") int branchID) {

		Admin admin = new Admin(id, adminName, email, password, branchID);

		AdminDAO dao = new AdminDAO();
		String state = dao.updateAdmin(admin);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/deleteAdmin")
	public String deleteAdmin(@FormParam("id") int id) {

		AdminDAO dao = new AdminDAO();
		String state = dao.deleteAdmin(id);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/addCategory")
	public String addCategory(@FormParam("name") String name, @FormParam("branchID") int branchID) {

		Category cat = new Category(0, name, branchID);

		CategoryDAO dao = new CategoryDAO();
		int id = dao.addCategory(cat);

		return JSONBuilder.convertIDToJSON(id).toJSONString();
	}

	@POST
	@Path("/updateCategory")
	public String updateCategory(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("branchID") int branchID) {

		Category cat = new Category(id, name, branchID);

		CategoryDAO dao = new CategoryDAO();
		String state = dao.updateCategory(cat);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/deleteCategory")
	public String deleteCategory(@FormParam("id") int id) {

		CategoryDAO dao = new CategoryDAO();
		String state = dao.deleteCategory(id);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@GET
	@Path("/")
	public String getJson() {
		return "Hello after editing";
	}
}
