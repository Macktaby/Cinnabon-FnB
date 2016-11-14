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

	@GET
	@Path("/")
	public String getJSON() {
		return "{\"state\":\"HELLO\"}";
	}

}
