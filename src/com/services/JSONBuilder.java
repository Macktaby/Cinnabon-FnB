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
		if (id > 0)
			json.put("state", "true");
		else
			json.put("state", "false");

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertIDToJSON(int id, String msg) {

		JSONObject json = new JSONObject();
		json.put("id", id);
		if (id > 0) {
			json.put("state", "true");
			json.put("msg", msg);
		} else {
			json.put("state", "false");
			json.put("error", msg);
		}

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
	public static JSONObject convertImageToJSON(BranchImage image) {
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

	@SuppressWarnings("unchecked")
	public static JSONObject convertCategoriesToJSON(ArrayList<Category> categories) {
		JSONObject json = new JSONObject();

		if (categories == null)
			json.put("state", "false");
		else {
			JSONArray jsonArr = new JSONArray();
			for (Category cat : categories)
				jsonArr.add(convertCategoryToJSON(cat));

			json.put("state", "true");
			json.put("categories", jsonArr);

			return json;
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertCategoryToJSON(Category cat) {
		JSONObject json = new JSONObject();

		if (cat == null)
			json.put("state", "false");
		else {
			json.put("state", "true");
			json.put("id", cat.getCategoryID());
			json.put("name", cat.getCategoryName());
			json.put("items", convertItemsToJSON(cat.getItems()).get("items"));
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertItemsToJSON(List<Item> items) {
		JSONObject json = new JSONObject();

		if (items == null)
			json.put("state", "false");
		else {
			JSONArray jsonArr = new JSONArray();
			for (Item item : items)
				jsonArr.add(convertItemToJSON(item));

			json.put("state", "true");
			json.put("items", jsonArr);

			return json;
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertItemToJSON(Item item) {
		JSONObject json = new JSONObject();

		if (item == null)
			json.put("state", "false");
		else {
			json.put("state", "true");
			json.put("id", item.getItemID());
			json.put("name", item.getItemName());
			json.put("desc", item.getDescription());
			json.put("likes", item.getLikes());
			json.put("dislikes", item.getDislikes());
			json.put("calories", item.getCalories());
			json.put("nPersons", item.getnPersons());
			json.put("ingredients", convertIngredientsToJSON(item.getIngredients()).get("ingredients"));
			json.put("sizes", convertSizesToJSON(item.getSizes()).get("sizes"));
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertSizesToJSON(List<Size> sizes) {
		JSONObject json = new JSONObject();

		if (sizes == null) {
			json.put("state", "false");
		} else {

			JSONArray jsonArr = new JSONArray();
			for (Size size : sizes)
				jsonArr.add(convertSizeToJSON(size));

			json.put("state", "true");
			json.put("sizes", jsonArr);
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertSizeToJSON(Size size) {
		JSONObject json = new JSONObject();

		if (size == null)
			json.put("state", "false");
		else {
			json.put("state", "true");
			json.put("id", size.getSizeID());
			json.put("name", size.getSizeName());
			json.put("price", size.getSizePrice());
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertIngredientsToJSON(List<Ingredient> ingredients) {
		JSONObject json = new JSONObject();

		if (ingredients == null) {
			json.put("state", "false");
		} else {

			JSONArray jsonArr = new JSONArray();
			for (Ingredient ingredient : ingredients)
				jsonArr.add(convertIngredientToJSON(ingredient));

			json.put("state", "true");
			json.put("ingredients", jsonArr);
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertIngredientToJSON(Ingredient ingredient) {
		JSONObject json = new JSONObject();

		if (ingredient == null)
			json.put("state", "false");
		else {
			json.put("state", "true");
			json.put("id", ingredient.getIngredientID());
			json.put("name", ingredient.getIngredientName());
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertReservationsToJSON(ArrayList<Reservation> reservations) {
		JSONObject json = new JSONObject();

		if (reservations == null) {
			json.put("state", "false");
		} else {
			JSONArray jsonArr = new JSONArray();

			for (Reservation reservation : reservations)
				jsonArr.add(convertReservationToJSON(reservation));

			json.put("state", "true");
			json.put("reservations", jsonArr);
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertReservationToJSON(Reservation reservation) {
		JSONObject json = new JSONObject();

		if (reservation == null) {
			json.put("state", "false");
		} else {
			json.put("state", "true");
			json.put("id", reservation.getReservationID());
			json.put("eaterID", reservation.getEaterID());
			json.put("branch", convertBranchToJSON(reservation.getBranch()));
			json.put("nPersons", reservation.getnPersons());
			json.put("start", reservation.getStartTime().toString());
			json.put("end", reservation.getEndTime().toString());
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertReviewsToJSON(ArrayList<Review> reviews) {
		JSONObject json = new JSONObject();

		if (reviews == null) {
			json.put("state", "false");
		} else {

			JSONArray jsonArr = new JSONArray();
			for (Review review : reviews)
				jsonArr.add(convertReviewToJSON(review));

			json.put("state", "true");
			json.put("reviews", jsonArr);
		}

		return json;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject convertReviewToJSON(Review review) {
		JSONObject json = new JSONObject();

		if (review == null)
			json.put("state", "false");
		else {
			json.put("state", "true");
			json.put("id", review.getReviewID());
			json.put("eaterID", review.getEaterID());
			json.put("userName", review.getUserName());
			json.put("body", review.getReviewBody());
			json.put("rating", review.getRating());
			json.put("reviewDate", review.getReviewDate().toString());
		}

		return json;
	}

}