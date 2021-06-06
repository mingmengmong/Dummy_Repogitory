import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		int N,K;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		int idx = 1;
		while(st.hasMoreTokens()){
			int n = Integer.parseInt(st.nextToken());
//			arr[idx] = arr[idx-1] + n;
			arr[idx] = n;
			++idx;
		}
		
		for(int tc=0; tc<K; ++tc){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			double l = e - s + 1;
			double sum = 0;
			for(int i=s; i<=e; ++i) sum += arr[i];
			System.out.printf("%.02f\n", Math.round(100d * sum / l) / 100d);
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}