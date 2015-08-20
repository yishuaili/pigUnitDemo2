package com.test.TestProject;

//import org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
//import org.apache.hadoop.fs.Path;
import org.apache.pig.pigunit.Cluster;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.pigunit.pig.PigServer;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;

public class TestPig {
	@Test
	public void testEasy() throws IOException, ParseException, NotFoundException, CannotCompileException{
		
		FixHadoopOnWindows.runFix();
		
		String[] args = {
		        "n=2",
		        };
		 
		    PigTest test = new PigTest("src/test/resources/top_queries.pig", args);
		 
		    String[] input = {
		        "yahoo",
		        "yahoo",
		        "yahoo",
		        "twitter",
		        "facebook",
		        "facebook",
		        "linkedin",
		    };
		 
		    String[] output = {
		        "(yahoo,3)",
		        "(facebook,2)",
		    };
		 
		    test.assertOutput("data", input, "queries_limit", output);
	}
	
	/*
	@Test
	public void testMax() throws IOException, ParseException, NotFoundException, CannotCompileException{
		String[] args = {
				"input=src/test/resources/ratings.dat",
				
		};
		FixHadoopOnWindows.runFix();
		
		
		PigTest test = new PigTest("src/test/resources/pigtest.pig", args);
		
		
		String[] output = {
				"(100.0)",
		};
		
		test.assertOutput("b", output);
		
		
		
		
	}
	*/
}
