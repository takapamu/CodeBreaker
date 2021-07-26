package net.sougetu.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeBreakerFirst {
	public static void main(String[] args)
	{
		String title = "***CodeBreaker";
		String rule = "隠された３つの数字をあてます。\n"
				+ "１つの数字は１から６の間です。\n"
				+ "３つの答えの中に同じ数字はありません。\n"
				+ "入力した数字の"
				+ "位置と数字が当たっていたらヒット、\n"
				+ "数字だけあってたらブローとカウントします。\n"
				+ "全部当てたら(３つともヒットになったら)"
				+ "終了です\n\n";
		int[] answer = new int[3]; 
		int[] input = new int[3];
		
		int hit = 0, blow = 0, count = 0;
		
		//タイトルとルールの表示
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(title);
		System.out.println(rule);
		
		for(int i = 0; i < answer.length; i++)
		{
			boolean flag = false;
			
			answer[i] = (int)(Math.random() * 6 + 1);
			do {
				flag = false;
				for(int j = i - 1; j >= 0; j--)
				{
					if(answer[i] == answer[j])
					{
						flag = true;
						answer[i] = (int)(Math.random() * 6 + 1);
					}
				}
			}while(flag == true);
		}
		
		while(true)
		{
			count++;
			System.out.println("***" + count + "回目 ***");
			for(int i = 0; i < answer.length; i++)
			{
				System.out.println((i + 1) + "個目：");
				try
				{
					input[i] = Integer.parseInt(br.readLine());
				} catch(NumberFormatException e) {
					System.out.println("数値を入力してください");
					i--;
				}catch(IOException e) {
					System.out.println("もう一度入力してください");
					i--;
				}
			}
			
			hit = 0;
			blow = 0;
			for(int i = 0; i < answer.length; i++)
			{
				for(int j = 0; j < answer.length; j++)
				{
					if(i == 0 && input[i] == answer[j])
					{
						hit++;
					}else if(input[i] == answer[j])
					{
						blow++;
					}
				}
			}
			
			System.out.println("ヒット" + hit + "ブロー" + blow);
			if(hit == 3)
			{
				System.out.println("おめでとう");
				break;
			}else
			{
				System.out.println();
			}
		}
	}

}
