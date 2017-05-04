package com.test;

import org.springframework.data.mongodb.core.mapping.Field;

public class SomTest {
	class ZipInfo {
		   String id;
		   String city;
		   String state;
		   @Field("pop") int population;
		   @Field("loc") double[] location;
		}

		class City {
		   String name;
		   int population;
		}

		class ZipInfoStats {
		   String id;
		   String state;
		   City biggestCity;
		   City smallestCity;
		}
}
