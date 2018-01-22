package com.anythy.importer;

import com.anythy.importer.service.thread.ThreadTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImporterApplicationTests {

	@Autowired
	ThreadTest threadTest;

	Set<Long> result = new HashSet<>();

	private int threadNum = 1000;
	private CountDownLatch cdl = new CountDownLatch(threadNum);

	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < threadNum; i++) {
			new Thread(new Print()).start();
			cdl.countDown();
		}

		Thread.sleep(8000);
		System.out.println("###########################" + result.size());
	}

	class Print implements Runnable{
		@Override
		public void run() {
			try {
				cdl.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long l = threadTest.print();
			result.add(l);
		}
	}

}
