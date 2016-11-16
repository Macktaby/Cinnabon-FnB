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

	@GET
	@Path("/")
	public String getJson() {
		return "Hello after editing";
	}
}
