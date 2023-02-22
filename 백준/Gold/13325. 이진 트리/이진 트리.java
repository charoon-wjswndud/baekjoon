import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int depth = Integer.parseInt(br.readLine());
		int[] tree = new int[(1 << depth+1) -1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int idx = 1; idx < tree.length; idx++) {
			tree[idx] = Integer.parseInt(st.nextToken());
		}

		recursive(tree, 0);

		int sum = 0;
		for (int weight :
				tree) {
			sum += weight;
		}
		System.out.println(sum);
	}

	public static int recursive(int[] tree, int node) {
		if (tree.length <= (node << 1) + 1) {
			return tree[node];
		}

		int leftNode = (node << 1) + 1;
		int leftWeight = recursive(tree, leftNode);

		int rightNode = (node << 1) + 2;
		int rightWeight = recursive(tree, rightNode);

		if (leftWeight <= rightWeight) {
			tree[leftNode] += rightWeight - leftWeight;
			return tree[node] + rightWeight;
		} else {
			tree[rightNode] += leftWeight - rightWeight;
			return tree[node] + leftWeight;
		}
	}
}
