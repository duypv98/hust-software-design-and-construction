/**
 *
 */
package vn.edu.hust.soict.afc.entities;

import java.sql.Timestamp;

/**
 * @author Professor
 *
 */
public class PrepaidTrip {

	private int id;
	private String cardId;
	private int incomeStationId;
	private Timestamp incomeTime;
	private int outcomeStationId;
	private Timestamp outcomeTime;
	private double realFare;
	private boolean onTrip;

	/**
	 *
	 */
	public PrepaidTrip() {

	}

	public PrepaidTrip(int id, String cardId, int incomeStationId, Timestamp incomeTime, int outcomeStationId,
			Timestamp outcomeTime, double realFare, boolean onTrip) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.incomeStationId = incomeStationId;
		this.incomeTime = incomeTime;
		this.outcomeStationId = outcomeStationId;
		this.outcomeTime = outcomeTime;
		this.realFare = realFare;
		this.onTrip = onTrip;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the incomeStationId
	 */
	public int getIncomeStationId() {
		return incomeStationId;
	}

	/**
	 * @param incomeStationId the incomeStationId to set
	 */
	public void setIncomeStationId(int incomeStationId) {
		this.incomeStationId = incomeStationId;
	}

	/**
	 * @return the incomeTime
	 */
	public Timestamp getIncomeTime() {
		return incomeTime;
	}

	/**
	 * @param incomeTime the incomeTime to set
	 */
	public void setIncomeTime(Timestamp incomeTime) {
		this.incomeTime = incomeTime;
	}

	/**
	 * @return the outcomeStationId
	 */
	public int getOutcomeStationId() {
		return outcomeStationId;
	}

	/**
	 * @param outcomeStationId the outcomeStationId to set
	 */
	public void setOutcomeStationId(int outcomeStationId) {
		this.outcomeStationId = outcomeStationId;
	}

	/**
	 * @return the outcomeTime
	 */
	public Timestamp getOutcomeTime() {
		return outcomeTime;
	}

	/**
	 * @param outcomeTime the outcomeTime to set
	 */
	public void setOutcomeTime(Timestamp outcomeTime) {
		this.outcomeTime = outcomeTime;
	}

	/**
	 * @return the realFare
	 */
	public double getRealFare() {
		return realFare;
	}

	/**
	 * @param realFare the realFare to set
	 */
	public void setRealFare(double realFare) {
		this.realFare = realFare;
	}

	/**
	 * @return the onTrip
	 */
	public boolean isOnTrip() {
		return onTrip;
	}

	/**
	 * @param onTrip the onTrip to set
	 */
	public void setOnTrip(boolean onTrip) {
		this.onTrip = onTrip;
	}
}
