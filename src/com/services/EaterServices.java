package com.services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.DAO.*;
import com.models.*;

@Path("/eater")
@Produces(MediaType.TEXT_PLAIN)
public class EaterServices {

	@POST
	@Path("/signup")
	public String signup(@FormParam("uname") String userName, @FormParam("pass") String password,
			@FormParam("nickname") String nickName, @FormParam("email") String email,
			@FormParam("phone") String phone) {

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
