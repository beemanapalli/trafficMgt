package org.traffic.mgt;


import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.*;

import org.traffic.mgt.controller.SignalController;
 

public class SignalMgt {

	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double timeDuration = 0;
		try {
			out.println("");
			out.println("***********************************************************************");
			out.println("");
			out.println("Hello...");
			Thread.sleep(600);
			out.println("                     W   E   L   C   O   M   E");
			out.println("");
			out.println("***********************************************************************");
			Thread.sleep(1000);
			out.println("How long you wish this SIGNAL MANAGEMENT SYSTEM to function ");
			Thread.sleep(1000);
			out.println("-Please Entere Time in Seconds here ----------->:");

			out.print("");

			timeDuration = input.nextDouble();
			SignalController sc = new SignalController();

			sc.trafficSignal(true, timeDuration, "NS_GREEN", "EW_RED");
		} catch (InputMismatchException imx) {
			out.println("You have Entered Invalid Input");

		} catch (Exception e) {
			out.println("System has problem");
		}finally{
			input.close();
		}

		System.exit(0);

	}

}
