package org.traffic.mgt.dto;

public class CarDetail implements VehicleDetail{
	
	public CarDetail(String direction, int count, int timePoint) {
		super();
		this.direction = direction;
		this.count = count;
		this.timePoint = timePoint;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTimePoint() {
		return timePoint;
	}

	public void setTimePoint(int timePoint) {
		this.timePoint = timePoint;
	}

	private String direction;
	private int count;
	private int timePoint;
	
	public String getVehicleDetail(){
		return "CarDetail [direction=" + direction + ", count=" + count + ", timePoint=" + timePoint + "]";
	}

	 
}
