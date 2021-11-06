package Numerical_Theorem;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bisection_Theorem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		ArrayList<Float> input = new ArrayList<Float>();

		float a = 0;
		float b = 0;
		for (int i = 0; i < 9; i++) {
			a = i;
			b = i + 1;
			if (function(a) < 0 && function(b) > 0 || function(a) > 0 && function(b) < 0) {
				input.add(a);
				input.add(b);

				break;
			}
		}

		float x1 = (a + b) / 2;
		count++;

		while (true) {
			input.add(x1);
			float last = input.get(input.size() - 1);
			float sec_last = input.get(input.size() - 2);

			DecimalFormat df = new DecimalFormat("0.0000");
			if (df.format(last).equals(df.format(sec_last))) {
				System.out.println(df.format(last));
				break;
			}
			double out_res = function(x1);
			for (int i = input.size() - 1; i >= 0; i--) {
				if (out_res < 0 && function(input.get(i)) > 0) {
					x1 = (x1 + input.get(i)) / 2;
					count++;
					break;
				}
				if (out_res > 0 && function(input.get(i)) < 0) {
					count++;
					x1 = (x1 + input.get(i)) / 2;
					break;
				}
			}
		}
		System.out.println(count);

	}

	public static float function(float x) {
		return x * x * x - 2 * x - 5;
	}

}