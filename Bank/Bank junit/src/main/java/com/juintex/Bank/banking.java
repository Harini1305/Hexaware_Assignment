package com.juintex.Bank;

public class banking {
	    private int account;
	    private String name;
	    private String email;
	    private double balance;
	    public banking(int account, String name, String email, double balance) {
	        this.account = account;
	        this.name = name;
	        this.email = email;
	        this.balance = balance;
	    }
	    
	    @Override
		public String toString() {
			return "banking [account=" + account + ", name=" + name + ", email=" + email + ", balance=" + balance + "]";
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public void deposit(double amount) {
	        balance += amount;
	    }

	    public boolean withdraw(double amount) {
	        if (balance - amount >= 1500) {
	            balance -= amount;
	            return true;
	        }
	        return false;
	    }

	}
