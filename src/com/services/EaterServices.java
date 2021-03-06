package com.services;

import java.sql.Timestamp;
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
	public String filterBranchesByLocation(@FormParam("location") String location) {

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
		ArrayList<Category> categories = dao.getMenu();

		return JSONBuilder.convertCategoriesToJSON(categories).toJSONString();
	}

	@POST
	@Path("/addReservation")
	public String addReservation(@FormParam("eaterID") int eaterID, @FormParam("branchID") int branchID,
			@FormParam("nPersons") int nPersons, @FormParam("startTime") Timestamp startTime,
			@FormParam("endTime") Timestamp endTime) {

		Reservation res = new Reservation(0, eaterID, nPersons, startTime, endTime);

		ReservationDAO dao = new ReservationDAO();
		int id = dao.addReservation(res, branchID);

		return JSONBuilder.convertIDToJSON(id).toJSONString();
	}

	@POST
	@Path("/updateReservation")
	public String updateReservation(@FormParam("id") int id, @FormParam("eaterID") int eaterID,
			@FormParam("branchID") int branchID, @FormParam("nPersons") int nPersons,
			@FormParam("startTime") Timestamp startTime, @FormParam("endTime") Timestamp endTime) {

		Reservation res = new Reservation(id, eaterID, nPersons, startTime, endTime);

		ReservationDAO dao = new ReservationDAO();
		String state = dao.updateReservation(res, branchID);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/deleteReservation")
	public String deleteReservation(@FormParam("id") int id) {

		ReservationDAO dao = new ReservationDAO();
		String state = dao.deleteReservation(id);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/getReservations")
	public String getReservations(@FormParam("eaterID") int eaterID) {

		ReservationDAO dao = new ReservationDAO();
		ArrayList<Reservation> reservations = dao.getReservations(eaterID);

		return JSONBuilder.convertReservationsToJSON(reservations).toJSONString();
	}

	@POST
	@Path("/addReview")
	public String addReview(@FormParam("body") String body, @FormParam("rating") int rating,
			@FormParam("eaterID") int eaterID) {

		Review review = new Review(0, eaterID, body, rating);

		ReviewDAO dao = new ReviewDAO();
		int id = dao.addReview(review);

		return JSONBuilder.convertIDToJSON(id).toJSONString();
	}

	@POST
	@Path("/updateReview")
	public String updateReview(@FormParam("id") int id, @FormParam("body") String body, @FormParam("rating") int rating,
			@FormParam("eaterID") int eaterID) {

		Review review = new Review(id, eaterID, body, rating);

		ReviewDAO dao = new ReviewDAO();
		String state = dao.updateReview(review);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/deleteReview")
	public String deleteReview(@FormParam("id") int id) {

		ReviewDAO dao = new ReviewDAO();
		String state = dao.deleteReview(id);

		return JSONBuilder.convertStateToJSON(state).toJSONString();
	}

	@POST
	@Path("/getReviews")
	public String getReviews() {

		ReviewDAO dao = new ReviewDAO();
		ArrayList<Review> reviews = dao.getReviews();

		return JSONBuilder.convertReviewsToJSON(reviews).toJSONString();
	}

	@POST
	@Path("/makeOrder")
	public String makeOrder(@FormParam("eaterID") int eaterID, @FormParam("branchID") int branchID,
			@FormParam("orderTime") Timestamp orderTime, @FormParam("items") String itemsDetails) {

		ArrayList<OrderItem> orderItems = parseItemDetails(itemsDetails);

		Order order = new Order(0, eaterID, orderTime, orderItems);

		OrderDAO dao = new OrderDAO();
		int orderID = dao.addOrder(order, branchID);
		if (orderID == 0)
			return JSONBuilder.convertIDToJSON(orderID, "Error Adding the order").toJSONString();

		OrderItemDAO daoOI = new OrderItemDAO();
		String msg = daoOI.addOrderItems(order.getItems(), orderID, branchID);

		return JSONBuilder.convertIDToJSON(orderID, msg).toJSONString();
	}

	private ArrayList<OrderItem> parseItemDetails(String items) {
		ArrayList<OrderItem> orderItems = new ArrayList<>();

		String[] parts = items.split("!");

		for (String part : parts) {
			String[] partDetails = part.split("@");

			int itemID = Integer.parseInt(partDetails[0]);
			int quantity = Integer.parseInt(partDetails[1]);
			int sizeID = Integer.parseInt(partDetails[2]);
			ArrayList<Ingredient> ingredients = parseItemIngredients(partDetails[3]);

			OrderItem orderItem = new OrderItem(0, itemID, sizeID, ingredients, quantity);
			orderItems.add(orderItem);
		}

		return orderItems;
	}

	private ArrayList<Ingredient> parseItemIngredients(String intgredientDetails) {
		ArrayList<Ingredient> ingredients = new ArrayList<>();

		String[] parts = intgredientDetails.split("_");
		for (String ingredient : parts) {
			int ingID = Integer.parseInt(ingredient);
			ingredients.add(new Ingredient(ingID, ""));
		}
		return ingredients;
	}

	@POST
	@Path("/getUserOrders")
	public String getUserOrders(@FormParam("id") int id) {
		OrderDAO dao = new OrderDAO();
		ArrayList<Order> orders = dao.getUserOrders(id);

		return JSONBuilder.convertOrdersToJSON(orders).toJSONString();
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
