import java.util.Random;
import java.util.Scanner;

public class Main{

    public static boolean isValid(int row, int col, int n, int m){
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static void main(String[] args){
        int n;
        int m;
        int walk = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter room's row: ");
        n = scan.nextInt();
        System.out.print("Enter room's column: ");
        m = scan.nextInt();
        int[][] room = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                room[i][j] = 0;
            }
        }

        Position start = new Position(n/2, m/2);
        Position track = start;
        room[n/2][m/2] += 1;
        Random rand = new Random();
        int direction;

        
        // 0=North  1=Northeast  2=East  3=Southeast  4=South  5=Southwest  6=West  7=Northwest
        for(int i=0; i<50000; i++){
            int cnt = 0;
            direction = rand.nextInt(8);

            //North
            if(isValid(track.row-1, track.col, n, m) && direction == 0){
                track = new Position(track.row-1, track.col);
                room[track.row][track.col] += 1;
                walk++;
            }
            //Northeast
            else if(isValid(track.row-1, track.col+1, n, m) && direction == 1){
                track = new Position(track.row-1, track.col+1);
                room[track.row][track.col] += 1;
                walk++;
            }
            //East
            else if(isValid(track.row, track.col+1, n, m) && direction == 2){
                track = new Position(track.row, track.col+1);
                room[track.row][track.col] += 1;
                walk++;
            }
            //Southeast
            else if(isValid(track.row+1, track.col+1, n, m) && direction == 3){
                track = new Position(track.row+1, track.col+1);
                room[track.row][track.col] += 1;
                walk++;
            }
            //South
            else if(isValid(track.row+1, track.col, n, m) && direction == 4){
                track = new Position(track.row+1, track.col);
                room[track.row][track.col] += 1;
                walk++;
            }
            //Southwest
            else if(isValid(track.row+1, track.col-1, n, m) && direction == 5){
                track = new Position(track.row+1, track.col-1);
                room[track.row][track.col] += 1;
                walk++;
            }
            //West
            else if(isValid(track.row, track.col-1, n, m) && direction == 6){
                track = new Position(track.row, track.col-1);
                room[track.row][track.col] += 1;
                walk++;
            }
            //Northwest
            else if(isValid(track.row-1, track.col-1, n, m) && direction == 7){
                track = new Position(track.row-1, track.col-1);
                room[track.row][track.col] += 1;
                walk++;
            }

            for(int k=0; k<n; k++){
                for(int j=0; j<m; j++){
                    if(room[k][j] != 0){
                        cnt++;
                    }
                }
            }

            if(cnt == n*m) {
                System.out.println("Total number of legal moves that cockroach made: " + walk);
                break;
            }
        }

        System.out.println("Density of the walk:");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
    }
}