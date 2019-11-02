/**
 * 
 */
package vn.edu.hust.soict.afc.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.edu.hust.soict.afc.common.BaseDataClient;
import vn.edu.hust.soict.afc.entities.Station;

/**
 * @author Professor
 *
 */
public class StationService {
	private static BaseDataClient client = new BaseDataClient();

	/**
	 * 
	 * @param stationId
	 * @return
	 */
	public static Station getStationInfo(int stationId) {
		Station station = null;
		String sql = "SELECT station_name, distance FROM station WHERE id = ?";

		try {
			client.open();
			PreparedStatement ps = client.getConnection().prepareStatement(sql);
			ps.setInt(1, stationId);

			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				station = new Station();
				station.setId(stationId);
				station.setStationName(rs.getString("station_name"));
				station.setDistance(rs.getDouble("distance"));
			}
		} catch (SQLException e) {
			/* Ignore */
		}

//		client.close();
		return station;
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Station> getAllStations() {
		List<Station> rList = new ArrayList<>();
		String sql = "SELECT id, station_name, distance FROM station";
		try {
			client.open();
			PreparedStatement ps = client.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Station st = new Station();
				st.setId(rs.getInt("id"));
				st.setStationName(rs.getString("station_name"));
				st.setDistance(rs.getDouble("distance"));

				rList.add(st);
			}
		} catch (SQLException e) {
			/* Ignore */
		}
		return rList;
	}
}