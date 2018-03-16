package org.traffic.mgt.controller;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import org.traffic.mgt.dto.CarDetail;
import org.traffic.mgt.dto.DTOFactory;
import org.traffic.mgt.dto.VehicleDetail;

public class SignalController {
	private static boolean signal = true;
	private List carQ = new ArrayList();
	private static int nsCarCounter = 0;
	private static int ewCarCounter = 0;

	private static int daySecCounter = 0;
	private String nsSignal;
	private String ewSignal;

	/**
	 * @param beginOfTheDay
	 * @param timeDuration
	 * @param directions
	 */
	public void trafficSignal(boolean beginOfTheDay, double timeDuration, String... directions) {
		int signalSecCounter = 0;
		// daySecCounter++;
		LOOP1: for (; daySecCounter <= timeDuration; daySecCounter++) {
			LOOP2: for (String direction : directions) {

				if (direction.equals("NS_GREEN")) {

					nsSignal = direction;
					if (daySecCounter != 0 && !beginOfTheDay)
						nsCarCounter++;
					/*
					 * After GREEN, first car takes 2 seconds to move, hence we
					 * need to wait for 2 sec, then remove a car from queue
					 */
					if (daySecCounter != 0 && !beginOfTheDay && signalSecCounter >= 2) {
						nsCarCounter--;
					}
					VehicleDetail cd1 = DTOFactory.getNewDTO(DTOFactory.carDTO, "N", nsCarCounter, daySecCounter);
					carQ.add(cd1);
					VehicleDetail cd2 = DTOFactory.getNewDTO(DTOFactory.carDTO, "S", nsCarCounter, daySecCounter);
					carQ.add(cd2);

				}
				if (direction.equals("NS_RED")) {
					nsSignal = direction;
					if (daySecCounter != 0)
						nsCarCounter++;

					VehicleDetail cd1 = DTOFactory.getNewDTO(DTOFactory.carDTO, "N", nsCarCounter, daySecCounter);
					carQ.add(cd1);
					VehicleDetail cd2 = DTOFactory.getNewDTO(DTOFactory.carDTO, "S", nsCarCounter, daySecCounter);
					carQ.add(cd2);

				}
				if (direction.equals("EW_RED")) {
					ewSignal = direction;
					if (daySecCounter != 0)
						ewCarCounter++;
					VehicleDetail cd1 = DTOFactory.getNewDTO(DTOFactory.carDTO, "E", ewCarCounter, daySecCounter);
					carQ.add(cd1);
					VehicleDetail cd2 = DTOFactory.getNewDTO(DTOFactory.carDTO, "W", ewCarCounter, daySecCounter);
					carQ.add(cd2);

				}
				if (direction.equals("EW_GREEN")) {
					ewSignal = direction;
					if (daySecCounter != 0)
						ewCarCounter++;
					/*
					 * After GREEN, first car takes 2 seconds to move, hence we
					 * need to wait for 2 sec, then remove a car from que for
					 * each second.
					 */
					if (signalSecCounter >= 2) {
						ewCarCounter--;
					}
					VehicleDetail cd1 = DTOFactory.getNewDTO(DTOFactory.carDTO, "E", ewCarCounter, daySecCounter);
					carQ.add(cd1);
					VehicleDetail cd2 = DTOFactory.getNewDTO(DTOFactory.carDTO, "W", ewCarCounter, daySecCounter);
					carQ.add(cd2);

				}
			}
			signalSecCounter++;
			showCarQ(carQ, daySecCounter);
			carQ.clear();

			/*
			 * GREEN LIGHT Duration count.
			 */
			if (signalSecCounter > 3) {
				/*
				 * after brake recursive function will be invoked with the
				 * daySecCounter of previous
				 */
				daySecCounter++;
				if (nsSignal.equals("NS_GREEN")) {
					nsSignal = "NS_RED";
				} else if (nsSignal.equals("NS_RED")) {
					nsSignal = "NS_GREEN";
				}
				if (ewSignal.equals("EW_GREEN")) {
					ewSignal = "EW_RED";
				} else if (ewSignal.equals("EW_RED")) {
					ewSignal = "EW_GREEN";
				}

				break; /* break from LOOP1 */
			}
		}
		if (daySecCounter > timeDuration)
			return;
		trafficSignal(false, timeDuration, nsSignal, ewSignal);
	}

	private void showCarQ(List<CarDetail> carQ, int time) {

		out.print(time + ":");

		for (CarDetail cd : carQ) {

			out.print(cd.getDirection() + " = " + cd.getCount() + "; ");

		}
		out.println();

	}

}
