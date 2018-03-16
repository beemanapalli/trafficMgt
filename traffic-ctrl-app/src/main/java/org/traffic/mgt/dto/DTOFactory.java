package org.traffic.mgt.dto;



public class DTOFactory {
	public static final String carDTO ="CAR_DTO";

	public static VehicleDetail getNewDTO(String dtoName,String direction, int count, int timePoint) {
		// TODO Auto-generated method stub
		if (dtoName.equals(carDTO)){
			return new CarDetail( direction,  count,  timePoint);
		}
		return null;

	}

}
