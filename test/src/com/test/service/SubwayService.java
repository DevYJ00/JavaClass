package com.test.service;

import java.util.Scanner;

public class SubwayService {

	// 0 1 2 3 4 mod(5)
	private String[] station = { "합정", "홍대입구", "신촌", "이대", "아현" };

	int staIdx = 0; // 시작 역을 위한 인덱스
	String curStation = station[staIdx]; // i는 현재역, 초기화
	String destination = ""; // 목적지 - 변수 초기화 궁금

	// 차량은 총 4량, 각 차량당 탑승가능인원 4명 - 차량은 한번에 4개가 같이다니는데 인원차면 못탐
	int passNum = 4; // 탑승가능 인원 (수정 가능)
	int vehicleNum = 4; // 차량 댓수
	int[] vehicle = new int[vehicleNum];
	// 승객
	String[] cus = new String[passNum];

	// 목적지 현황
	String[][] status = new String[vehicleNum][passNum];

	Scanner scan = new Scanner(System.in);
	// 탑승 시 목적지 지정. 목적지도착 시 자동하차
	// 필요한 함수
	/*
	 * 탑승 join() 탑승 시, 목적지 지정 목적지 도착 시 자동하차 탑승 할 때마다 인원 추가해줘야 함
	 * 
	 */

	public void run()  {
		
		for (int i = 0; i < 3; i++)
			System.out.println();
		System.out.printf("현재역은 %s입니다.\n", curStation);

		System.out.println("=================================");
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.탑승 2.상세보기 3.이동 4.종료");

		switch (scan.nextInt()) {

		case 1:
			join();
			break;
		case 2:
			status();
			break;
		case 3:
			move();
			break;
		case 4 :
			System.exit(0);

		}

		// 하차시키기
//		getOff();

	} // 상세보기 - 몇호차량에 탑승

	private void getOff() {
		// 현재역 == 배열에 담기값 -> 하차
		for (int i = 0; i < status.length; i++) {
			for (int j = 0; j < status[i].length; j++) {
				if (status[i][j] == curStation) {
					System.out.println(status[i][j] + " 역에서 승객 하차합니다.");
					status[i][j] = null;
					vehicle[i]--;
				}
			}
		}
	}

	int choiceVeh = 0;

	public void join() {
		// 탑승가능 현황 출력 (인원 찾으면 탑승불가, 비었으면 탑승가능)
		for (int i = 0; i < 4; i++) {
			if ((vehicle[i] < 4)  ) // vehicle[0] != 4
				System.out.println((i + 1) + "호차 : 탑승가능");
			else
				System.out.println((i + 1) + "호차 : 정원 초과, 다른 호차를 이용하세요.");
			// 몇 호 차량에 탑승할 건지 입력받고
		}
		System.out.println("몇호 차량에 탑승하시겠습니까?");
		System.out.println("1.1호차   2.2호차   3.3호차   4.4호차");
		choiceVeh = scan.nextInt();
		switch (choiceVeh) {
		case 1:
			vehicle[0]++;
			break;
		case 2:
			vehicle[1]++;
			break;
		case 3:
			vehicle[2]++;
			break;
		case 4:
			vehicle[3]++;
			break;
		}

		System.out.println("목적지를 선택해 주세요.");
		// 내가 탑승한 역 제외하고 출력
		for (int i = 0; i < station.length; i++) {
			if (station[i] != curStation)
				System.out.printf("%d. %s ", i, station[i]);
		}
		// 입력값 받기 - 저장 - 해당 역 도착하면 값 기억했다가 하차 알려줘야함... 어렵넹
		destination = station[scan.nextInt()];

		saveDestination();

		run();
	}

	private void saveDestination() {
		// 2중 배열에 목적지 저장 choiceVeh : 차량 번호, destination status

		if (choiceVeh == 1) {
			for (int i = 0; i < status[0].length; i++)
				if (status[0][i] == null) {
					status[0][i] = destination;
					break;
				}

		} else if (choiceVeh == 2) {
			for (int i = 0; i < status[1].length; i++)
				if (status[1][i] == null) {
					status[1][i] = destination;
					break;
				}
		} else if (choiceVeh == 3) {
			for (int i = 0; i < status[2].length; i++)
				if (status[2][i] == null) {
					status[2][i] = destination;
					break;
				}
		} else {
			for (int i = 0; i < status[3].length; i++)
				if (status[3][i] == null) {
					status[3][i] = destination;
					break;
				}
		}

	}

	// 열차 차량 선택 옵션 vechile[i] 선택시 이 값이 ++ , 4가되면 꽉 찾다고 출력

	public void status() { // 차량당 비어있는 공간 출력 - 탑승한 사람 목적지 출력
		for (int i = 0; i < status.length; i++) {
			System.out.print((i + 1 + "호차 : "));
			for (int j = 0; j < status[i].length; j++) {
				if (status[i][j] != null)
					System.out.printf(" [ %s ] ", status[i][j]);
			}
			System.out.println();
		}
		run();
	}

	// 이동시 1개역씩 이동
	/*
	 * 이동 move() 이동 호출 시, 역 하나씩 이동 이동 후 어느 역인지 출력 - 목적지였던 사람있으면 내려주고 - 또 메뉴선택받기
	 */
	public void move() {

		staIdx++;
		staIdx = (staIdx % 5); // 값 보정해주고
		curStation = station[staIdx];
		getOff();
//		System.out.printf("현재역은 %s입니다.", curStation);
		run();

	}
}
