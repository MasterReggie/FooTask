package edu.csu.etl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorkerThreadTest {
	
	WorkerThread w = new WorkerThread("Source1");
	
	@Before
	public void connect() throws Exception
	{
		w.connect();
	}
	
	@After
	public void disconnect() throws Exception{
		w.disconnect();
	}

	@Test
	public void getCountTest() throws Exception{
		w.clear();
		int count = w.getCount();
		assertEquals(0,count);
	}
	
	@Test
	public void initTest() throws Exception{
		w.clear();
		w.init();
		int count = w.getCount();
		w.clear();
		assertEquals(1000,count);
	}
	
	@Test
	public void getSumValTest() throws Exception{
		w.init();
		int sum = w.getSumVal();
		assertTrue(sum>0);
		w.clear();
	}
	
	@Test
	public void storeSumTest() throws Exception{
		w.init();
		int sum = w.getSumVal();
		int id = w.storeSum(sum);
		assertEquals(sum, w.getStoredSum(id));
		w.clear();
	}
}
