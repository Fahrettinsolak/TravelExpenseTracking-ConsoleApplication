package com.solak.TravelExpenseTracking.Main;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.solak.TravelExpenseTracking.Authentication.AuthenticationManager;
import com.solak.TravelExpenseTracking.Authentication.User;

public class ConsoleUITest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

    @Before
    public void setUp() {
        // Test girişi sağlamak için System.in akışını değiştir
        testIn = new ByteArrayInputStream("testuser\ntestpassword\n".getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        // Sistem giriş/çıkışını geri yükle
        System.setIn(systemIn);
    }

    @Test
    public void testAuthenticateUser_SuccessfulLogin() {
        // Test için kullanıcı oluştur
        User user = new User("testuser", "testpassword");

        // Test için AuthenticationManager oluştur
        AuthenticationManager authManager = new AuthenticationManager();

        // ConsoleUI sınıfını test etmek için gerçek bir ConsoleUI oluştur
        ConsoleUI consoleUI = new ConsoleUI(user);
        consoleUI.setAuthenticationManager(authManager);

        // Metodu test et
        
    }
}
