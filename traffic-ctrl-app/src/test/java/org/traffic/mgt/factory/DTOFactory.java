package org.traffic.mgt.factory;

import org.traffic.mgt.dto.VehicleDetail;

public interface DTOFactory {

	String carDTO ="CAR_DTO";
	
	public  VehicleDetail getNewDTO(String dtoName,String direction, int count, int timePoint);
}
