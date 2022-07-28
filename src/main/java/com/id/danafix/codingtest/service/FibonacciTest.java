package com.id.danafix.codingtest.service;

public class FibonacciTest {

	public static void main(String[] args) {

		int first=0;
		int second=1;
		int hasil=0;
		for (int i = 0; i < 15; i++) {
			
			if(first==0&& second==1) {
				System.out.println(first);
				System.out.println(second);
			}
			hasil=second+first;
			int primaCounter=0;
			
			for (int j = 1; j <= hasil; j++) {
				if(hasil%j==0) {
					primaCounter++;
				}
			}
			System.out.println(primaCounter==2?hasil+" : PRIMA ":hasil);
			first=second;
			second=hasil;
		}
	}

}
