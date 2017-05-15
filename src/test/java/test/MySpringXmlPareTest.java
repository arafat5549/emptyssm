package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 解析Spring文件
 * @author wyy
 *
 */
public class MySpringXmlPareTest {

	//正则表达式
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream(new File("src/main/resources/spring-context.xml"));
		String content = IOUtils.toString(is);
		System.out.println(content);
		//2.正则 解析 所有${}
		String regex = "\\$\\{(.+)\\}"; //默认贪婪匹配
		String regex2 = "\\$\\{(.+?)\\}"; //+ 一到多次  ?0或者1 - 非贪婪匹配
		Pattern pattern = Pattern.compile(regex2);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			System.out.println(matcher.group(1));//0代表所有组的集合
		}
	}
	/**
	 * 一个数组，“支配者”是在数组中出现频率超过一半的整数，
		例如[3,4,3,2,-1,3,3,3]数值“3”出现过5次，5除以8大于0.5
		所以数值“3”是一个支配者；
		而在这个数组中的支配者出现在数组下标[0,2,4,6,7]
		写一个函数，在给定的整数数组中找出支配者所在的任意一个数组下标，如果一个数组中没有支配者返回-1；
	 */
	@Test
	public void arrayTest(){
		int arr[] = {3,4,3,2,-1,3,3,3};
		//考点1 集合和集合的嵌套
		Map<Integer,List<Integer>> maps =  new HashMap<Integer,List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			int key = arr[i];
			if(maps.containsKey(key)){
				List<Integer> list = maps.get(key);
				list.add(i);
				maps.put(key, list);
			}
			else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				maps.put(key, list);
			}
		}
		//考点2.集合遍历
		for (Integer key : maps.keySet()) {
			List<Integer> value = maps.get(key);
			if(value.size() / (double)arr.length > 0.5)//考点3.整数的乘除
				System.out.println(key+","+value);
		}
		
		
//		for(Integer key:maps.keySet()){
//			Integer value = maps.get(key);
//			if(value / (arr.length*1.0) > 0.5){
//				//System.out.println("###:"+key+","+value);
//				System.out.print("[");
//				for (int i = 0; i < arr.length; i++) {
//					if(key == arr[i]){
//						System.out.print(i+",");
//					}
//				}
//				System.out.println("]");
//			}
//			System.out.println(key+","+value);
//		}
	}
}
