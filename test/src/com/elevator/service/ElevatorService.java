package com.elevator.service;

import java.util.Scanner;

public class ElevatorService {

	Scanner scan = new Scanner(System.in);

	int capacity = 4;
	int[] elvPassenger = new int[capacity];
//	int[] floor = { 1, 2, 3 }; // 1층에서 시작
//	int curFloor = floor[0]; // 현재 층수
	int floor = 1;
	int curFloor = 1;

	boolean progress = true;

	public void run() {
		while (progress) {
			System.out.println("===================");
			System.out.printf("현재 층수는 %d층입니다.\n", curFloor);
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1.탑승 2.이동 3.탑승현황 4.종료");

			switch (scan.nextInt()) {
			case 1:
				board();
				break;
			case 2:
				move();
				break;
			case 3:
				status();
				break;
			case 4:
				progress = false;

			}
		}
	}

	int destination = 0;
	int countPass = 0;

	private void board() {

		if (elvPassenger[0] != 0 && elvPassenger[1] != 0 && elvPassenger[2] != 0 && elvPassenger[3] != 0) { // 좀 더 좋은 코드? for문으로 도는거나 이거말고!
			System.out.println("정원 초과입니다. 탑승이 불가능 합니다.");
			run();
		}

		System.out.println("층 수를 선택해 주세요.");
		System.out.println("1.1층	2.2층	3.3층");
		destination = scan.nextInt();
		// 목적지 층수정보 - 저장 - 해당 층수 하차,
		for (int i = 0; i < capacity; i++) // 비어있는 배열 칸을 좀 더 효율적으로 찾을 방법은 없을까?
			if (elvPassenger[i] == 0) {
				elvPassenger[i] = destination;
				System.out.printf("입력하신 층은 %d층입니다. \n", elvPassenger[i]);
				countPass++; // 탈 때마다 ++
				break; // break 안 걸어주면 입력받은 값 저장했는데도 for문 계속 도니까. 한번 저장하고 나면 멈추도록.
			}

	}

	public void status() {
		System.out.printf("현재 탑승 인원은 %d명 입니다.\n", countPass);
	}

	int dir = 0;
	int floorIdx = 0;

	int topFloor = 3;
	int firstFloor = 1;
	public void move() {
		
		// 방향전환~~~~ <- 좀 수정하기(좀 더 깔끔한 방법 ?) 
		
		if(curFloor == topFloor)
			floor *= -1; // floor = floor*-1
		else if (curFloor == firstFloor)
			floor *= 1;
		
		curFloor += floor;

//		
//		if (dir == 0)
//			floorIdx++;
//		else
//			floorIdx--;
//		curFloor = floor[floorIdx];
//
//		if (curFloor == 3)
//			dir = 1;
//		if (curFloor == 1)
//			dir = 0;

		int getOffN = 0;
		// 해당 층수에 승객 하차시키기
		for (int i = 0; i < 4; i++) {
			if (curFloor == elvPassenger[i]) {
				elvPassenger[i] = 0;
				countPass --;
				getOffN++;
			}
		}
		System.out.printf("현재 층은 %d층입니다. \n", curFloor);
		System.out.printf("%d명이 하차하였습니다. \n", getOffN);
	}

}
