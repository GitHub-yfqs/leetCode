package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	/*
	 * 3. ���ظ��ַ�����Ӵ�
	 */
	 public int lengthOfLongestSubstring(String s) {
	        char[] s1=s.toCharArray();
	        Map<Character,Object> map = new HashMap();
	        int length = s1.length;
	        int maxLength = 0;
	        for(int i=0;i<length;i++){
	            int j = 0;
	            if(map.containsKey(s1[i])){
	                j = map.size();
	                i=(Integer)map.get(s1[i]);
	                if(j>maxLength){
	                    maxLength=j;  
	                }
	                map.clear();
	                if(length-i<maxLength){
	                    break;
	                }
	            }else{
	            	map.put(s1[i],i);
	            }
	        }
	        if(map.size()>maxLength){
	            maxLength = map.size();
	        }
	        return maxLength;
	    }
	 /*
	  * 4. Ѱ�����������������λ��
	  */
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	      double median=0;
	      int length1 = nums1.length;
	      int length2 = nums2.length;
	      int length = length1+length2;
    	  int medianIndex = length/2;
	      if(nums1[length1-1]<nums2[0]){
	    	  if(length%2==0){
	    		  if(medianIndex>length1){
	    			  median = (nums2[medianIndex-1-length1]+nums2[medianIndex-length1])/2;
	    		  }else{
	    			  median = (nums1[medianIndex-1]+nums1[medianIndex])/2;
	    		  }
	    	  }else{
	    		  if(medianIndex>length1){
	    			  median = nums2[medianIndex-1-length1];
	    		  }else{
	    			  median = nums1[medianIndex-1];
	    		  }
	    	  }
	      }else if(nums1[0]>nums2[length2-1]){
	    	  if(length%2==0){
	    		  if(medianIndex>length2){
	    			  median = (nums1[medianIndex-1-length2]+nums1[medianIndex-length2])/2;
	    		  }else{
	    			  median = (nums2[medianIndex-1]+nums2[medianIndex])/2;
	    		  }
	    	  }else{
	    		  if(medianIndex>length2){
	    			  median = nums1[medianIndex-1-length2];
	    		  }else{
	    			  median = nums2[medianIndex-1];
	    		  }
	    	  }
	      }else{
	    	  if(length%2==0){
	    		  int flag = 0;
	    		  for(int i=length1;i>0;i--){
	    			  for(int j=1;j<length2;j++){
	    				  if(nums1[i-1]<nums2[j-1]){
	    					  if(i+j==medianIndex){
	    						  median = (nums2[j-1]+(nums2[j]>nums1[i]?nums1[i]:nums2[j]))/2;
	    						  break;
	    					  }
	    					  if(i+j<medianIndex){
	    						  median = (nums2[medianIndex-i-1]+nums2[medianIndex-i])/2;
	    						  break;
	    					  }
	    				  }else{
	    					  if(i+j==medianIndex){
	    						  median = (nums1[i-1]+(nums2[j]>nums1[i]?nums1[i]:nums2[j]))/2;
	    						  break;
	    					  }
	    				  }
	    			  }
	    		  }
	    		
	    	  }else{
	    		  for(int i=1;i<length1;i++){
	    			  for(int j=1;j<length2;j++){
	    				  if(nums1[i-1]<nums2[j-1]){
	    					  if(i+j==medianIndex){
	    						  median = nums2[j-1];
	    						  break;
	    					  }
	    				  }else{
	    					  if(i+j==medianIndex){
	    						  median = nums1[i-1];
	    						  break;
	    					  }
	    				  }
	    			  }
	    		  }
	    		
	    	  }
	      }  
		 return median;
	    }
	 /*
	  * 152. �˻����������
	  */
	 public int maxProduct(int[] nums) {

	        int max = nums[0];
	        int product = nums[0];
	        int product2 = nums[nums.length-1];
	        for(int i =1,j=nums.length-2; i<nums.length;i++,j--){
	        	if(nums[i]==0){
	        		if(max<0){
	        			max=0;
	        		}
	        		if(i+1<nums.length){
	        			i++;
	        			product = nums[i];
	        			max=Math.max(max,nums[i]);
	        		}
	        	}else{
	        		max=Math.max(max,nums[i]);
	        		if(product==0){
	        			product=nums[i];
	        		}else{
	        			product*=nums[i];
		        		max=Math.max(max, product);
	        		}
	        		
	        	}
	        	
	        	if(nums[j]==0){
	        		if(max<0){
	        			max=0;
	        		}
	        		if(j-1>0){
	        			j--;
	        			product2 = nums[j];
	        			max=Math.max(max,nums[j]);
	        		}else{
	        			break;
	        		}
	        	}else{
	        		max=Math.max(max,nums[j]);
	        		if(product2==0){
	        			product2=nums[j];
	        		}else{
	        			product2*=nums[j];
		        		max=Math.max(max,product2);	
	        		}
	        		
	        	}
	            
	        }
	        /*max=Math.max(min, max);*/
	        return max;
	    	 
	 }
	 /*
	  * 6. Z ���α任
	  * ���� 2*numRows-2 ѭ������
	  * 2018/11/23 ͨ��
	  */
	 public String convert(String s, int numRows) {
		 if (s.length()<=numRows) {
			return s;
		}
		 if (1==numRows) {
			return s;
		}
		 StringBuilder []str = new StringBuilder[numRows];
		/*�������ʼ��str�����ǲ��е�
		 *  for (StringBuilder stringBuilder : str) {
			stringBuilder = new StringBuilder();
		}*/
		 for (int i = 0; i < str.length; i++) {
			str[i] = new StringBuilder();
		}
		 for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < (2*numRows-2)&&i < s.length(); j++,i++) {
				if (j<numRows) {
					str[j].append(s.charAt(i));
				}else{
					str[2*numRows-2-j].append(s.charAt(i));
				}
			}
			i--;
		}
		 StringBuilder zString = new StringBuilder();
		 for (StringBuilder stringBuilder : str) {
			zString.append(stringBuilder);
		}
	        return zString.toString();
	    }
	 /*
	  * 7. ������ת
	  * 2018/11/23   ������û��
	  * 2018/11/24  ͨ��
	  */
	 public int reverse(int x) {
		//���������Ȼ�ȡ������λ��  �ڿ�ʼ����
		/* List<Integer> list = new ArrayList<Integer>();
		 double sum = 0;
		 while (x!=0) {
			 list.add(x%10);
			 x=x/10;
		}
		
		
		for (int i = 0; i < list.size(); i++) {
			sum += (int) (list.get(i)*Math.pow(10, list.size()-i-1));
		}
			if (sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE) {
				sum = 0;
			}
			
	        return (int)sum;*/
		 
		 //�Ż�   �����ڻ�ȡĳλ��ֵʱ  ͬ�Ǽ���
		 //���������Ż�   
		 double sum = 0;
		 int num = 0;
		 while (x!=0) {
			num = x%10;
			 x=x/10;
			 sum = sum*10+num;
			 
			 if (sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE) {
					sum = 0;
					break;
				}
		}
		
		 return (int)sum;
	    }
	 /*
	  * 8. �ַ���ת������ (atoi)
	  * 2018/11/25 �賿 00��17  ͨ��
	  * ���˿�����Сʱ  ������
	  */
	 public int myAtoi(String str) {
		 //���� �����ø����������װֵ��
	     long myAtoi = 1;
	     boolean isSymbol = true;//�Ƿ����
	     //ȥ�ո�
	     str = str.trim();
	     //�ж��ַ��Ƿ�Ϊ��
	     if (str.isEmpty()) {
			return 0;
		}
	     //��strת��Ϊchar����
	     char[] strChar = str.toCharArray();
	     //0-9��48-57
	     //���� - 45  ���� + 43
	     //�����һ ���ַ���������  �� ���� ���� �ͷ���0
	     if (strChar[0]!=43&&strChar[0]!=45&&(strChar[0]>57||strChar[0]<48)) {
			return 0;
		}else {
			if (strChar[0]!=45&&strChar[0]!=43) {
				//�ַ������� ת ��������  ��ȥ 48
				myAtoi=strChar[0]-48;
				isSymbol = false;
			}else{
				//�����һ���ַ�Ϊ���� ��ֵ-1
			    //���ֻ��һ������ ����0
				if (strChar.length==1) {
					return 0;
				}
				if (strChar[0]==45) {
					myAtoi=-1;
				} 
				
				
			}
		}
	   //ѭ���ж��ַ��ǲ�������
	     for (int i = 1; i < strChar.length; i++) {
	    	 if (strChar[i]>57||strChar[i]<48) {
                 //�����һ���͵ڶ����ַ����������־ͷ��� 0
                 if(isSymbol){
                     return 0;
                 }else{
                     break;
                 }
	 			
	 		}else {
	 			//���� ���  �����һ���ַ��Ǹ���  �� ���Ǹ���
	 			if (isSymbol) {
	 				//��strChar[i] Ϊ0ʱ  ������������  ��Ҫ���⴦��
	 				if(strChar[i]!=48){
	 					myAtoi=myAtoi*(strChar[i]-48);
	 					isSymbol = false;
	 				}
				}else {
					//���Ϊ����  ����  myAtoi*10-strChar[i]+48
					//���Ϊ����  ����  myAtoi*10+strChar[i]-48
					if (myAtoi>=0) {
						myAtoi = myAtoi*10+strChar[i]-48;
					}else {
						myAtoi = myAtoi*10-strChar[i]+48;
					}
				}
				//System.out.println(strChar[i]-48);
	 			//�������  ���ж���ë�ð�����������
				 if (myAtoi>Integer.MAX_VALUE) {
					 return Integer.MAX_VALUE;
					}
				 //Ϊʲô����û���ж������
				 if (myAtoi<Integer.MIN_VALUE) {
					 return Integer.MIN_VALUE;
					}
			}
		}
	     return (int)myAtoi;		 
	    }
	 /*
	  * 9. ������
	  * 2018/11/25 ͨ��
	  * �����е�ע��  ������Ӱ��Ч��
	  */
	 public boolean isPalindrome(int x) {
		 //�����϶����ǻ�����
		 if (x<0) {
			return false;
		}
		//������� С��10���ڵ���0 ���ǻ�����
		 if (x>=0&&x<10) {
			return true;
		}
		 //ȡ���������λ�����λ���Ƚ�
		 List<Integer> list = new ArrayList<Integer>();
		 //�������ֽ�
		 while (x!=0) {
				list.add(x%10);
				 x=x/10;
			}
		 //1221 212
		 for (int i = 0,j=list.size()-1; i<j; i++,j--) {
			if (list.get(i)!=list.get(j)) {
				return false;
			}
		}
	        return  true;
	    }
	 
	 /*
	  * 10. ������ʽƥ��
	  * 2018/11/25  ���� δͨ��    �߼��е㱬ը
	  * 2018/11/25  19��58 �����߼� 22:58����
	  * 2018/11/26 18��58 �ع����� 21��45����  ���С��
	  */
	 public boolean isMatch(String s, String p) {
		 //'.' ƥ�����ⵥ���ַ���
		 //'*' ƥ���������ǰ���Ԫ�ء�
		 //�Ƚ�s p ���char����
		 char[] sChar = s.toCharArray();
		 char[] pChar = p.toCharArray();
		 //SΪ��  pΪ��
		 if (sChar.length==0&&pChar.length==0) {
			 return true;
		 }
		 //sΪ�� p��Ϊ��
		 if (sChar.length==0&&pChar.length>0) {
			//���pChar.lengthΪ�����ͷ���false
			 if (pChar.length%2==1) {
				 return false;
			 }else{
				 for (int i = 0; i < pChar.length; i=i+2) {
					 if (pChar[i]=='*'||pChar[i+1]!='*') {
						 //.��a-z *
						 /*		a*b*��   true
						ab		false*/
						 return false;
					 }
				 }
				 return true;
			 }
		 }
		 //s��Ϊ�� pΪ��
		 if (sChar.length!=0&&pChar.length==0) {
			 return false;
		 }

		 //s��Ϊ�� p��Ϊ�� �����ص�
		 /* if (s[i]!=p[i]&&p[i]!=.&&p[i]!=*
					&&p[i+1]!=*&&p[i-1]!=*){

						return false;

					}else if(p[i]==*){
						if(p[i-1]!=s[i]&&p[i-1]!=.&&p[i+1]!=s[i]
								&&p[i+1]!=.&&p[i+2]!=*){
								return false;
							}else if(p[i+2]==*){
								if(p[i+3]!=s[i]&&p[i+3]!=.
									&&p[i+4!=*]){
										false
									}
									���p[i+4]==*�ͽ���ѭ��������ж�
									ѭ����ֹ���� ���� false 
												 �������ַ���
												 ��������ѭ������
							}


					}else if(p[i+1]==*){
						if((p[i+2]!=s[i]&&p[i+2]!=.&&p[i+3]!=*)
							||p[i+2]==*){
							return false
						}else if(p[i+3]==*){
								if(p[i+4]!=s[i]&&p[i+4]!=.
									&&p[i+5!=*]){
										false
									}
									���p[i+5]==*�ͽ���ѭ��������ж�
									ѭ����ֹ���� ���� false 
												 �������ַ���
												 ��������ѭ������
								}
					}else if(p[i-1]==*){
						if(p[i-2]!=.){
							return false
						}else{
							ѭ���ж� s[i+1]�Ƿ����p[i]
							ѭ����ֹ����  �������ַ���
						}

					}

					������ж�ȫ��ͨ�� �������ж�
					���s �� p �ַ�����������  
					˵��ƥ������  ����true
					���򷵻�false*/	

		 int i=0,j=0,flag = 0;
		 for (; i < sChar.length&&j < pChar.length; i++,j++) {
			 if (sChar[i]!=pChar[j]&&pChar[j]!='.'&&pChar[j]!='*'
					 &&pChar[j+1]!='*'&&pChar[j-1]!='*'){
				 return false;	
			 }else if(pChar[j]=='*'){
				 if(pChar[j-1]!=sChar[i]&&pChar[j-1]!='.'&&pChar[j+1]!=sChar[i]
						 &&pChar[j+1]!='.'&&pChar[j+2]!='*'){
					 return false;
				 }else if(pChar[j+2]=='*'){
					 
					 if(pChar[j+3]!=sChar[i]&&pChar[j+3]!='.'
							 &&pChar[j+4]!='*'){
						 return false;
					 }else if (pChar[j+4]=='*') {
						 /*���p[i+4]==*�ͽ���ѭ��������ж�
							ѭ����ֹ���� ���� false 
										 �������ַ���
										 ��������ѭ������*/
						 i=i+4;
						 
						 for (int a = i; a < pChar.length-i; a=a+2) {
							 //����ı߽�ֵ���е�����
							 if(pChar[a+1]!=sChar[i]&&pChar[a+1]!='.'
									 &&pChar[j+2]!='*'){
								 return false;
							 }
							
						 }
					}
				 }


			 }else if(pChar[j+1]=='*'){
				 if((pChar[j+2]!=sChar[i]&&pChar[j+2]!='.'&&pChar[j+3]!='*')
						 ||pChar[j+2]=='*'){
					 return false;
				 }else if(pChar[j+3]=='*'){
					 if(pChar[j+4]!=sChar[i]&&pChar[j+4]!='.'
							 &&pChar[j+5]!='*'){
						 return false;
					 }else if (pChar[j+5]=='*') {
						 /*���p[i+5]==*�ͽ���ѭ��������ж�
							ѭ����ֹ���� ���� false 
										 �������ַ���
										 ��������ѭ������*/
						 i=i+5;
						 for (int a = i; a < pChar.length-i; a=a+2) {
							 //����ı߽�ֵ���е�����
							 if(pChar[a+1]!=sChar[i]&&pChar[a+1]!='.'
									 &&pChar[j+2]!='*'){
								 return false;
							 }
							
						 }
					}
					
				 }
			 }else if(pChar[j-1]=='*'){
				 if(pChar[j-2]!='.'){
					 return false;
				 }else{
					
					 for (int a = j,b = i+1; a < pChar.length&&b < sChar.length; a++,b++) {
						 //s   abcaabaan   p  .*aab    false
						 //s   abcaabaab   p  .*aab    true 
						//s�ַ���   abcaabaab   p������ʽ  .*aab.*    true
						//s�ַ���   abcaabaab[a-z]c(n��c)b[a-z](n��a-z���ַ�)a   p������ʽ  .*aab.c*b.*a    ture 
						//s�ַ���    abcaabaab[a-z]c(n��c)b[a-z](n��a-z���ַ�)b   p������ʽ  .*aab.c*b.*a    false 
						 //����Ҫ�жϺöడ   ������������������
						if (pChar[a]==sChar[b]||pChar[a]=='.') {
							flag++;
							if (!(b+1 < sChar.length)) {
								
							}
						}else{
							a-=flag;
							flag = 0;
						}
					}
					 /*ѭ���ж� s[i+1]�Ƿ����p[i]
								ѭ����ֹ����  �������ַ���*/
				 }

			 }
		 }

		 /*������ж�ȫ��ͨ�� �������ж�
			���s �� p �ַ�����������  
			˵��ƥ������  ����true
			���򷵻�false*/
		 if (i >= sChar.length&&j+flag>=pChar.length) {
			 return true;
		 } else {
			 return false;
		 }

	 }
	 /*
	  * 11. ʢ���ˮ������
	  * 2018/11/30
	  */
	 public int maxArea(int[] height) {
	      int i=0,j=height.length-1;
	      System.out.println(height.length);
	      int maxArea = 0;
	      while (i<j) {
	    	//height[j-1]>height[i]?i++:j--;
	    	 if (Math.min(height[i],height[j])*(j-i)>maxArea) {
					maxArea = Math.min(height[i],height[j])*(j-i);
	    		}
	    	if (height[j]>height[i]) {
	    		int pre = height[i];
	    		i++;
	    		while (i<j&&pre>=height[i]) {
					i++;
				}
			}else {
				int pre = height[j];
				j--;
				while (i<j&&pre>=height[j]) {
					j--;
				}
			}
		}
		 return maxArea;
	    }
	 	/*
	 	 * 12. ����ת��������
	 	 * 2018/11/30
	 	 */
	 public String intToRoman(int num) {
		 List<StringBuilder> strlist = new ArrayList();
		 while(num>0){
			 StringBuilder str = new StringBuilder();
			int count = num%10;
			if (count==4||count==9) {
				if (strlist.size()==0) {
					if (count==4) {
						str = str.append("IV");
					}else {
						str = str.append("IX");
					}
				}else if (strlist.size()==1) {
					if (count==4) {
						str = str.append("XL");
					}else {
						str = str.append("XC");
					}
				}else if (strlist.size()==2) {
					if (count==4) {
						str = str.append("CD");
					}else {
						str = str.append("CM");
					}
				}
			} else {
				if (strlist.size()==0) {
					//����5
					if (count>=5) {
						str.append("V");
						count=count-5;
						while (count>0) {
							str.append("I");
							count--;
						}
					}else {
						while (count>0) {
							str.append("I");
							count--;
						}
					}
				}else if (strlist.size()==1) {
						//����5
						if (count>=5) {
							str.append("L");
							count=count-5;
							while (count>0) {
								str.append("X");
								count--;
							}
						}else {
							while (count>0) {
								str.append("X");
								count--;
							}
						}
				}else if (strlist.size()==2) {
						//����5
						if (count>=5) {
							str.append("D");
							count=count-5;
							while (count>0) {
								str.append("C");
								count--;
							}
						}else {
							while (count>0) {
								str.append("C");
								count--;
							}
						}
				}else if (strlist.size()==3) {
					while (count>0) {
						str.append("M");
						count--;
					}
				}
			}
			strlist.add(str);
			num = num/10;
		 }
		 StringBuilder stringBuilder = new StringBuilder();
		 for (int i = strlist.size()-1; i>=0; i--) {
			stringBuilder.append(strlist.get(i));
		}
	        return stringBuilder.toString();
	    }
	 /*
	  * 15. ����֮��
	  */
	   public List<List<Integer>> threeSum(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   Arrays.sort(nums);
		   int j = 0,k = nums.length-1;
		   for (int i=0;i<nums.length;i++) {
			List<Integer> list2 = new ArrayList<>();
			while (j<k) {
				if (j!=i) {
					if (nums[j]+nums[k]>nums[i]) {
						k--;
					}else if (nums[j]+nums[k]<nums[i]) {
						j++;
					}else {
						list2.add(nums[i]);
						list2.add(nums[j]);
						list2.add(nums[k]);
						list.add(list2);
						break;
					} 
				}else {
					j++;
				}
			}
		}
		   return list;
	    }
}
