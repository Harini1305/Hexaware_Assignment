package com.juintex.Bank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class AppTest {

    banking b;

    @BeforeAll
    static void connectDB() {
        System.out.println("db connected");
    }

    @BeforeEach
    void check() {
        b = new banking(101, "harini", "harini@gmail.com", 2500);
        assertTrue(b.getBalance() > 500);
    }

    @Test
    void testOpenAccount() {
        assertEquals(2500, b.getBalance());
    }

    @Test
    void testDeposit() {
        b.deposit(1000);
        assertEquals(3500, b.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        boolean result = b.withdraw(200);
        assertTrue(result);
    }

    @Test
    void testWithdrawFail() {
        boolean result = b.withdraw(2000);
        assertFalse(result);
    }

    @AfterEach
    void cleanup() {
        System.out.println("test completed");
    }

    @AfterAll
    static void closeDB() {
        System.out.println("db closed");
    }
}