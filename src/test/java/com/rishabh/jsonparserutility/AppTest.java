package com.rishabh.jsonparserutility;

import com.rishabh.jsonparserutility.responses.pojo.Districts;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws Exception
	 */
	public void testCowinDistrictAPI() throws Exception {
		System.out.println("Executing TC -testCowinDistrictAPI()");
		Districts districts = App.readDistrictsCowin();
		if (districts.districts.size() > 0) {
			System.out.println(districts.districts.get(0).getDistrict_name());
			String district_list = "";
			System.out.println("District List for getAllDistricts() : ");
			for (District district : districts.districts)
				district_list += " " + district.getDistrict_name();
			System.out.println(district_list);
		} else {
			System.out.println("Empty Response for getAllDistricts() ");
		}
	}
	
	public void testTimeAPI() throws Exception  {
		System.out.println("Executing TC -testTimeAPI()");
		TimeData td = App.readTime();
		System.out.println(td.date);
		System.out.println(td.time);
		System.out.println(td.milliseconds_since_epoch);
		
	}
}
