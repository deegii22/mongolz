/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongolz.main;

import com.mongolz.integration.ItemGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class Main {

	private final static String[] configFilesGatewayDemo = {
		"/META-INF/spring/integration/common.xml",
<<<<<<< HEAD
            "/META-INF/spring/integration/itemGateway.xml",
			"/META-INF/spring/integration/amqp-item-app-context.xml",
		"/META-INF/spring/integration/jms-highPrice-app-context.xml",
		"/META-INF/spring/integration/jms-moderatePrice-app-context.xml"
=======
			"/META-INF/spring/integration/alertGateway.xml",
			"/META-INF/spring/integration/amqp-alert-app-context.xml",
			"/META-INF/spring/integration/jms-email-app-context.xml",
			"/META-INF/spring/integration/jms-sms-app-context.xml"
>>>>>>> 632e23014270302cb7a6999905d571872393af8a
	};

	ItemGateway itemGateway;
 
	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

//	    RouteOrderGateway itemGateway;


		System.out.println("\n========================================================="
				+ "\n                                                         "
				+ "\n    Welcome to the WAA 545 RouteOrder System!                 "
				+ "\n                                                         "
				+ "\n    For more information please visit:                   "
				+ "\n    REFER to the Slides & your Class NOTES!              "
				+ "\n                                                         "
				+ "\n=========================================================" );
 
 				System.out.println("    Loading Demo...");
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, Main.class);

			    applicationContext.getBean(Main.class).mainInternal(applicationContext);
	  }
	
	    private void mainInternal(ApplicationContext applicationContext) {

	    }

}
