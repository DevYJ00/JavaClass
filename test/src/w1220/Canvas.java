package w1220;

class Canvas {

	char[][] buf; // 문제에서 인스턴스 생성 후 사용했으니까 iv로 선언

	Canvas() {
		buf = new char[50][50];
	}

	void drawBoard() {
		for (int i = 0; i < buf.length; i++) {
			for (int j = 0; j < buf[i].length; j++)
				buf[i][j] = '┼';
		}
	}

	void drawLine(int x1, int y1, int x2, int y2) {
		int incli = 0;
		if (x1 > x2) {
			// 기울기를 계산을 하고
			incli = ((y2 - y1) / (x2 - x1));

			if (incli < 1) {
				incli = -1; //기울기가 1미만일때는 int로 0이 되버리니까 -1로 보정
				for (int i = y1; i < y2; i++) {
					for (int j = x2; j < x1; j++) {
						if (i - y1 == incli * (j - x1))
							buf[i - 1][j - 1] = '○';
					}
				}
			} else {
				incli = ((y2 - y1) / (x2 - x1));

				for (int i = y1; i < y2; i++) {
					for (int j = x2; j < x1; j++) {
						if (i - y1 == incli * (j - x1))
							buf[i - 1][j - 1] = '○';
					}
				}
			}
		} else {
			incli = (y2 - y1) / (x2 - x1);
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					if (i - y1 == incli * (j - x1))
						buf[i - 1][j - 1] = '○';
				}
			}
		}
	}

	void print() {
		for (int i = 0; i < buf.length; i++) {
			for (int j = 0; j < buf[i].length; j++)
				System.out.print(buf[i][j]);
			System.out.println();
		}
	}

}
