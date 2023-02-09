package D3;
import java.util.Scanner;
 
/*
문자  의미
.   평지(전차가 들어갈 수 있다.)
*   벽돌로 만들어진 벽
#   강철로 만들어진 벽
-   물(전차는 들어갈 수 없다.)
^   위쪽을 바라보는 전차(아래는 평지이다.)
v   아래쪽을 바라보는 전차(아래는 평지이다.)
<    왼쪽을 바라보는 전차(아래는 평지이다.)
>    오른쪽을 바라보는 전차(아래는 평지이다.)
 
문자  동작
U   Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D   Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L   Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R   Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S   Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 
입력
1
3 7
***....
*-..#**
#<.****
23
SURSSSSUSLSRSSSURRDSRDS
 */
 
public class Solution_1873 { // 상호의 배틀필드
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int [][] deltas = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}};
 
        int T = sc.nextInt();
         
        for (int test = 1; test <= T; test++) {
            int H = sc.nextInt(), W = sc.nextInt();
            char map[][] = new char[H][W];
            int d = 0; //동서남북
            int r=0, c=0; //행 열
             
            for (int i = 0; i < H; i++) {
                String line = sc.next().trim();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                     
                    if(map[i][j] == '>' || map[i][j] =='<' || map[i][j] =='v' || map[i][j] =='^') {//탱크 위치 찾기
                        r=i; c=j; //탱크위치 저장
                        if(map[i][j] == '>') d=0;
                        else if(map[i][j] =='<') d=1;
                        else if(map[i][j] == 'v') d=2;
                        else if(map[i][j] == '^') d=3;
                    }
                }
            }
             
            int N = sc.nextInt();
            String in = sc.next();
            for(int i=0; i<N; i++) {
                char move = in.charAt(i);
                int dx,dy; //이동 좌표
                if(move == 'U' || move == 'D' || move == 'L' || move == 'R') {//입력받은 문자대로 움직이고 바라보는 방향 표시
                    if(move =='U') {
                        d=3;
                        map[r][c] = '^';
                    }else if(move == 'D') {
                        d=2;
                        map[r][c] ='v';
                    }else if(move == 'L') {
                        d=1;
                        map[r][c] = '<';
                    }else if(move == 'R') {
                        d=0;
                        map[r][c] ='>';
                    }
                    dx = r + deltas[d][0];
                    dy = c + deltas[d][1]; //이동 좌표
                    if(dx >= 0 && dy >= 0 && dx < H && dy < W) { // 맵 나갔는지 체크
                        if(map[dx][dy] == '.') { //이동할 곳이 평지일 경우
                            map[dx][dy] = map[r][c]; //탱크 이동 후 좌표에 바라보는 방향 표시
                            map[r][c] = '.'; //있었던 자리 평지로 만들기
                             
                            r=dx; c=dy; //좌표 업데이트
                        }
                    }
                }else if(move == 'S') {
                    dx=r; dy=c; //탱크위치 저장
                    while(true) { //포탄 발사, 벽에 충돌하거나 맵 밖에 나갈때까지
                        dx += deltas[d][0];
                        dy += deltas[d][1];//포탄 이동 좌표
                        if(!(dx>=0 && dy>=0 && dx<H && dy<W) || map[dx][dy] =='#') break; //맵밖, 강철벽 만나면 끝
                        	else if(map[dx][dy] =='*') {//벽돌벽 만나면 부수고 끝
                                map[dx][dy] = '.';
                                break;
                        }
                        
                        
                    }
                }
            }
            System.out.print("#" + test + " ");

            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    System.out.print(map[i][j]);
                }System.out.println();
            }
 
 
        }
    }
 
}