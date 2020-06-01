package com.inflglen.Test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.infoglen.ConfigMethod;

public class InfoglenTests extends ConfigMethod {

	@Test(priority=1)

	public void question1() {

		objects.test1();

	}

	@Test(priority=2)
	public void question2()   {

		objects.test2();
	}



}
