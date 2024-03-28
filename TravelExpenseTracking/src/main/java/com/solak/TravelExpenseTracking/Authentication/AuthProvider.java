package com.solak.TravelExpenseTracking.Authentication;

public interface AuthProvider {
	boolean login(String username, String password);
	boolean register(String username, String password);
	void guestMode();
}
