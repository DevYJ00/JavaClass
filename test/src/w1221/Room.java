package w1221;

//파일의 크기를 어떻게 알아낼 것인가 - 실제 업무에서는 라인이 많기 때문에 다양한 방법을 고려해봐야함.
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Room {
 
	private Student stu; // 이거 필요할까? - 필요 없음! 메서드 내부에서 이용할 때는 객체를 생성 후 이용해서 ㄱㅊ
	private Student[] stus;

//composition
	public Room(int size) {
		stus = new Student[size]; // composition
	}

	public Room() {
		this(10); // 기본 10명으로 설정
	}

//	//aggregation 방법
//	public Room(int size) {
//		this.stus = new Student[size];
//	}
//	
//	
//	public void setStu(Student stu) {
//		this.stu = stu;
//	}

	// 학생들을 Student[] 에 추가하는 메서드
	public void load(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		Scanner scan = new Scanner(fis);

		String tmpLine;
		String[] tmpArr;
		int count = 0;
		// 먼저 학생 인스턴스에 담은 다음 -> 학생들 배열에 인스턴스를 담아야 겠지?
		scan.nextLine();
		while (scan.hasNext()) {
			tmpLine = scan.nextLine();
			tmpArr = tmpLine.split(",");
			// 이걸 이제 객체에 담아야하니까 객체 생성
			Student stu = new Student();
			stu.setId((Integer.parseInt(tmpArr[0])));
			stu.setName(tmpArr[1]);

			// 이제 객체를 객체배열에 담아주어야 함. 배열 인덱스 필요하니까
			stus[count] = stu;
			count++;
		}

	}

	// 배열에 담긴 학생들 순서 랜덤하게 섞기
	public void shuffle() {
		Random rand = new Random();
		for (int i = 0; i < 100; i++) { // 100번정도 섞어주면 잘 섞이겠지?
			int ra1 = rand.nextInt(10);
			int ra2 = rand.nextInt(10);
			Student tmp = new Student();
			tmp = stus[ra1];
			stus[ra1] = stus[ra2];
			stus[ra2] = tmp;
		}
	}

	// 학생들 출력하기
	public void print() {

		for (int i = 0; i < stus.length; i++)
//			System.out.printf("아이디 : %d, 이름 : %s\n", stus[i].getId(), stus[i].getName());
//			stu.print();   - Student 클래스의 print( ) 이용하려면 어떻게 해야하지?
		stus[i].print();

	}

	// 학생들 정렬 - 번호 기준 (버블 정렬)
	public void sort() {
		Student tmp;
		for (int j = 0; j < stus.length - 1; j++) {
			for (int i = 0; i < stus.length - 1-j; i++) {
				if (stus[i].getId() > stus[i + 1].getId()) {
					tmp = stus[i];
					stus[i] = stus[i + 1];
					stus[i + 1] = tmp;
				}
			}

		}
	}

}
