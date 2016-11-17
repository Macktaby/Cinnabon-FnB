package com.services;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.models.*;

public class JSONBuilder {

	@SuppressWarnings("unchecked")
	public static JSONObject convertStateToJSON(String state) {

		JSONObject json = new JSONObject();
		json.put("state", state);

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertIDToJSON(int id) {

		JSONObject json = new JSONObject();
		json.put("id", id);

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertEaterToJSON(Eater eater) {
		JSONObject json = new JSONObject();

		if (eater == null)
			json.put("state", "false");
		else {
			json.put("state", "true");
			json.put("id", eater.getEaterID());
			json.put("uname", eater.getUserName());
			json.put("email", eater.getEmail());
			json.put("pass", eater.getPassword());
			json.put("phone", eater.getPhone());
			json.put("dateReg", eater.getDateRegistered().toString());
			json.put("state", "true");
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertBranchesToJSON(ArrayList<Branch> branches) {

		JSONObject json = new JSONObject();

		if (branches == null) {
			json.put("state", "false");
		} else {

			JSONArray jsonArr = new JSONArray();
			for (Branch branch : branches)
				jsonArr.add(convertBranchToJSON(branch));

			json.put("state", "true");
			json.put("branches", jsonArr);
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertBranchToJSON(Branch branch) {

		JSONObject json = new JSONObject();

		if (branch == null)
			json.put("state", "false");
		else {
			json.put("state", "true");
			json.put("id", branch.getBranchID());
			json.put("phone", branch.getPhone());
			json.put("location", branch.getLocation());
			json.put("address", branch.getAddress());
			json.put("lng", branch.getLng());
			json.put("lat", branch.getLat());
			json.put("images", convertImagesToJSON(branch.getImages()));
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONArray convertImagesToJSON(List<BranchImage> images) {
		JSONArray jsonArr = new JSONArray();

		for (BranchImage image : images)
			jsonArr.add(convertImageToJSON(image));

		return jsonArr;
	}

	@SuppressWarnings("unchecked")
	private static Object convertImageToJSON(BranchImage image) {
		JSONObject json = new JSONObject();

		json.put("id", image.getImageID());
		json.put("url", image.getURL());

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertRestaurantToJSON(Restaurant rest) {
		JSONObject json = new JSONObject();

		if (rest == null)
			json.put("state", "false");
		else {
			json.put("state", "true");
			json.put("id", rest.getRestaurantID());
			json.put("name", rest.getRestaurantName());
			json.put("desc", rest.getDescription());
			json.put("type", rest.getType());
			json.put("logo", rest.getLogo());
			json.put("hotline", rest.getHotline());
			json.put("rating", rest.getRating());
		}

		return json;
	}

	// @SuppressWarnings("unchecked")
	// public static JSONObject convertProjectsToJSON(ArrayList<Project>
	// projects) {
	// JSONObject json = new JSONObject();
	//
	// if (projects == null) {
	// json.put("state", "false");
	// } else {
	//
	// JSONArray jsonArr = new JSONArray();
	// for (Project project : projects)
	// jsonArr.add(convertProjectToJSON(project));
	//
	// json.put("state", "true");
	// json.put("projects", jsonArr);
	// }
	//
	// return json;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public static JSONObject convertProjectToJSON(Project project) {
	// JSONObject json = new JSONObject();
	//
	// if (project == null)
	// json.put("state", "false");
	// else {
	// json.put("state", "true");
	// json.put("id", project.getProjectID());
	// json.put("name", project.getName());
	// json.put("tech_ref", project.getTechReflection());
	// json.put("mng_ref", project.getMngReflection());
	// json.put("bz_ref", project.getBzReflection());
	// json.put("parent_id", project.getParentID());
	// }
	//
	// return json;
	// }

}