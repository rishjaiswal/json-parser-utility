package com.rishabh.jsonparserutility;

import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import com.google.gson.*;
import com.rishabh.jsonparserutility.responses.pojo.*;

public class App {

	/**
	 * Program for Calculating the Net Asset Price for Holding Stock Values at
	 * Particular Date.
	 *
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Executing TC - netAssetAPI()");
			URL HoldingURL = new URL(
					"https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");
			URL PricingURL = new URL(
					"https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing");
			InputStreamReader HSReader = new InputStreamReader(HoldingURL.openStream());
			InputStreamReader PRReader = new InputStreamReader(PricingURL.openStream());
			Gson gson = new Gson();
			Pricing[] pricing = gson.fromJson(PRReader, Pricing[].class);
			Holding[] holding = gson.fromJson(HSReader, Holding[].class);
			String given_date = "20190106";
			Arrays.stream(pricing).forEach(e1 -> {
				if (e1.date.equals(given_date)) {
					Arrays.stream(holding).forEach(e2 -> {
						if (e2.date.equals(given_date)) {
							if ((e1.date).equals(e2.date) && (e1.security).equals(e2.security)) {
								System.out.println("Value on : " + e1.date + " of " + e1.security + " is "
										+ e1.price * e2.quantity);
							}
						}
					});
				}

			});

		} catch (Exception e) {
			System.out.println("Error in Parsing the URL");
			e.printStackTrace();
		}

	}

	/*
	 * Return the Response of Districts for COWIN API having State ID -16
	 */
	public static Districts readDistrictsCowin() throws Exception {
		URL DistrictURL = new URL("https://cdn-api.co-vin.in/api/v2/admin/location/districts/16");
		URLConnection conn = DistrictURL.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0");
		InputStreamReader DSReader = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		Districts districts = gson.fromJson(DSReader, Districts.class);
		return districts;
	}

	/*
	 * Return the Response of Districts for COWIN API having State ID -16
	 */
	public static TimeData readTime() throws Exception {
		URL TimeURL = new URL("http://time.jsontest.com");
		InputStreamReader TimeReader = new InputStreamReader(TimeURL.openStream(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		TimeData td = gson.fromJson(TimeReader, TimeData.class);
		return td;
	}
}
