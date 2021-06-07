import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	
	// input field
	static int N, A, T;
	static int[][] arr;
	
	// result
	static int result = Integer.MAX_VALUE;
	
	
	static void dfs(int idx, int[] sumArr, int sumCost){
		if(idx == N) return;
		if(isCheck(sumArr)){
			result = Math.min(sumCost, result);
			return;
		}
		
		for(int i=idx; i<N; ++i){
			for(int j=0; j<A; ++j)
				sumArr[j] += arr[i][j+1];
			dfs(idx+1, sumArr, sumCost + arr[i][0]);
			for(int j=0; j<A; ++j)
				sumArr[j] -= arr[i][j+1];
		}
		
		dfs(idx+1, sumArr, sumCost);
	}
	
	static boolean isCheck(int[] sumArr){
		for(int i=0; i<A; ++i){
			if(sumArr[i] < T) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[N][A+1];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			for(int j=1; j<=A; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr, (ar1, ar2) -> Integer.compare(ar1[0], ar2[0]));
		
		dfs(0, new int[A], 0);
		
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}
