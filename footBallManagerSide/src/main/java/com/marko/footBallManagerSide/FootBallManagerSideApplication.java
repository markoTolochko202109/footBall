package com.marko.footBallManagerSide;

import com.marko.footBallManagerSide.communication.CommunicationPlayer;
import com.marko.footBallManagerSide.communication.CommunicationTeam;
import com.marko.footBallManagerSide.configuration.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FootBallManagerSideApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		CommunicationPlayer communicationPlayer = context.getBean("communicationPlayer", CommunicationPlayer.class);
		CommunicationTeam communicationTeam = context.getBean("communicationTeam", CommunicationTeam.class);





	}
}
