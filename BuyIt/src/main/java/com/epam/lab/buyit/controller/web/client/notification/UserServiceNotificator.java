package com.epam.lab.buyit.controller.web.client.notification;

public class UserServiceNotificator {
	
	public void inform(int id) {
		new NotificatorThread(id).start();
	}
}
