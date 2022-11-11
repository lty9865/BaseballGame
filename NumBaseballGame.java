package Pracpage3;

import java.util.Arrays;
import java.util.Scanner;

public class NumBaseballGame {

	public static void main(String[] args) {
		// 0 ~ 9 정수 3개를 난수로 생성
		// 사용자가 3개의 숫자 입력 
		// 같은 위치에 있으면 Strike 숫자가 존재하나 다른위치에 있으면 Ball 같은 숫자가 전혀 없으면 out
		// 정답을 입력하면 메시지 출력 후 게임 종료

		// 배열 선언
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		int[] input = new int[3];
		int[] answer = new int[3];
		boolean eq;

		for(int i=1; i<num.length; i++) {
			num[i] = i;
		}

		// 배열 셔플
		for(int i=0; i<100; i++) {
			int n = (int)(Math.random() * 10);
			int tmp = num[0];
			num[0] = num[n];
			num[n] = tmp;

		}

		// 배열 추출 및 복사
		System.arraycopy(num, 0, answer, 0, answer.length);
		System.out.println(Arrays.toString(answer));

		// 사용자 입력 (입력값도 같은 숫자 없도록)
		while(true) {

			do {
				System.out.print("Number > ");
				eq = false;
				for(int i=0; i<input.length; i++) {
					input[i] = sc.nextInt();
				}
				if(input[0] == input[1] || input[1] == input[2] || input[2] == input[0]) {
					eq = true;
					System.out.println("잘못 입력하셨습니다.(모두 다른 숫자를 입력해주세요.)");
				}
			} while(eq);

			int ball = 0;
			int strike = 0;

			for(int i=0; i<answer.length; i++) {
				for(int j=0; j<answer.length;) {
					if(input[i] == answer[i]) {
						strike++;
					} else if(input[i] == answer[j] || input[i] == answer[j+1] || input[i] == answer[j+2]) {
						ball++;
					}
					break;
				}
			}
			if(strike == 3) {
				break;
			} else if(strike == 0 && ball == 0) {
				System.out.println("out");
			}else {
				System.out.printf("Strike : %d\tBall : %d\n", strike, ball);
			}
		}
		sc.close();
		System.out.println("축하합니다! 정답입니다.");
	}

}