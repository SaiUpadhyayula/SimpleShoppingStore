package com.dota2.store.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dota2.store.beans.Hero;
import com.dota2.store.beans.Items;
import com.dota2.store.beans.SetDetails;

public class StoreController {

	List<Hero>					hero	= new ArrayList<Hero>();

	private static Connection	conn;

	// Returns list of all the Heros
	public List<Hero> getHerosList() {

		try {
			conn = DBConnection.connect();

			String sql = "select * from herodetails";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				hero.add(new Hero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			ps.close();
			return hero;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

		
	}

	// Returns list of all the Set Details of the specific Hero ID
	public static List<SetDetails> getSetDetailsList(int id) throws SQLException {

		List<SetDetails> lists = new ArrayList<SetDetails>();

		conn = DBConnection.connect();

		String sql = "select SetID,SetName,SetPrice,SetQuality from setdetails  where heroID = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			lists.add(new SetDetails(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
		}

		ps.close();
		return lists;

	}

	// Returns the list of all the items of the sets of the Hero.
	public static List<Items> getItemDetailsList(int setID) throws SQLException {

		List<Items> itemsList = new ArrayList<Items>();

		conn = DBConnection.connect();

		String sql = "select id.ItemID,id.ItemName,id.ItemPrice,id.ItemQuality from itemdetails as id, referencetable rt where rt.referenceID = id.referenceID and rt.setID= ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, setID);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			itemsList.add(new Items(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
		}

		ps.close();
		return itemsList;
	}

	// Returns the Items of the specific set by the Item ID.
	public static Items getItemsByID(String itemID) throws SQLException {

		Items l = new Items();
		conn = DBConnection.connect();

		String sql = "select ItemName,ItemPrice,ItemQuality from itemdetails where ItemID=?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, itemID);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			l.setItemName(rs.getString(1));
			l.setItemPrice(rs.getDouble(2));
			l.setItemQuality(rs.getString(3));
		}
		ps.close();
		return l;
	}
	
	// Returns the Set Details of the specific hero by Set ID

	public static SetDetails getSetDetailsByID(String setID) throws SQLException {
		
		SetDetails s = new SetDetails();
		conn = DBConnection.connect();
		
		String sql = "select SetName,SetPrice,SetQuality from setdetails where SetID=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, setID);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			s.setSetName(rs.getString(1));
			s.setSetPrice(rs.getDouble(2));
			s.setSetQuality(rs.getString(3));
			s.setSetID(setID);
		}
		ps.close();
		System.out.println(s.getSetName());
		return s;
	}
}
