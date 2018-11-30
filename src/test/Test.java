package test;

import solution.Solution;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		/*System.out.print(s.lengthOfLongestSubstring("abcabcbb"));*/
		/*int[] nums1={5,8,9};
		int[] nums2={1,3,4,6,7};*/
		//System.out.print(s.findMedianSortedArrays(nums1, nums2));
		
		//int[] nums={-1,5,0,-2,8,9};
		//int[] nums={0,2};
		//int[] nums={-3,0,1,-2};
		//int[] nums={-5,0,2};
		//[2,-5,-2,-4,3]
		//int[] nums={2,-5,-2,-4,3};
		//int[] nums={-2,0,1,-3};
		//int[] nums={6,3,-10,0,2};
		/*int[] nums={-1,-2,-3,0};
		System.out.println(s.maxProduct(nums));*/
		
		/*String str = "LEETCODEISHIRING";
		int numRows = 4;*/
		/*String str = "A";
		int numRows = 1;
		System.out.println(s.convert(str, numRows));*/
		
		/*int x = 1534236469;//120;
		System.out.println(s.reverse(x));*/
		
		//String str = "+-2";//"-000000000000001";//"  0000000000012345678";//"+1";//"   -42";//"-91283472332";
					//-2147483648
		/*System.out.println(s.myAtoi(str));*/
		
		//String s1="aa",p= "a*";
		//String s1="aab",p="c*a*b";
		//String s1="mississippi",p="mis*is*ip*.";
		//String s1="abcd",p="d*";
		//String s1="ab",p=".*c";
		//".*c.*" 这个怎么搞
		//如果出现了 ".*c"  需要判断 s1的尾部字符串是否跟p的尾部字符串相等  但是出现这种 ".*c.*" 这中怎么处理
		//String s1="aaa",p="ab*a*c*a";
		//String s1="a",p="ab*";
		//String s1="aab",p="c*a*b";
		//String s1="aaa",p="aaaa";//这个输出答案错误
		/*String s1="",p="a*b*.*";
		System.out.println(s.isMatch(s1, p));*/
		
		/*int[] height = {1,8,6,2,5,4,8,3,7};//{1,1};
		System.out.println(s.maxArea(height));*/
		
		int num = 1916;
		System.out.println(s.intToRoman(num));
		
	}

}
