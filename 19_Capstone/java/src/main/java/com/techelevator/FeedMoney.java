package com.techelevator;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeedMoney {
	LogFile logFile = new LogFile();

		private BigDecimal totalAvail = new BigDecimal(0.00);

		public BigDecimal feedMoney(String money) {
		DateFormat time = new SimpleDateFormat("MM/dd/yyyy\thh:mm:ss aa");
		String datetime = time.format(new Date()).toString();
			
		if (!money.equals("1") && !money.equals("2") && !money.equals("5") && !money.equals("10") && !money.equals("20")) {
			System.out.println("Please enter a valid bill denomination...");
		}
		else {
			BigDecimal addMoney = new BigDecimal(money);
			totalAvail = totalAvail.add(addMoney);
			String totalAvailFormat = String.format("$%.2f", totalAvail);
			System.out.println("Current Money Provided: $" + totalAvail);
			logFile.writeToFile(
					"\n" + datetime + "\tFEED MONEY: $" + addMoney + ".00" + "\t\tBalance: " + totalAvailFormat);
		}

		return totalAvail;

	}
}