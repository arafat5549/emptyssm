package guava;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class GuavaTest {

	
	
	@Test
	public void spliterTest(){
		//#---------切分字符串  正则还有类型转换--------------
		String params = "-100,1000,1,2,3,4,5,qyuyu,100,111";
		String ret[] =params.split(",");   //字符串切分-正则-注意点:(正则哪一部分最消耗性能)		
		//注意点:string转int  类型转换需要注意什么(类转换异常)

		//第一种类转换的方式 
		int arr[] = new int[ret.length];
		for (int i = 0; i < arr.length; i++) 
		{
//			int i = 0;
//			if(string == null) {
//	            i = 0;
//	        }
//	        try {
//	            i= Integer.parseInt(string);
//	        } catch (final NumberFormatException nfe) {
//	            i = 0;
//	        }
			//int i = Integer.parseInt(string);
			int value = NumberUtils.toInt(ret[i]);//推荐apache-commons的lang3包
			arr[i] = value;
		}
		
		//Guava转换  ",,,,,1,"
		List<String> parents = Splitter
				.on(",")
				.omitEmptyStrings()
				.trimResults(CharMatcher.DIGIT.negate())
				.splitToList(params);
		System.out.print("操作前:"+parents+",结果:");
		Function<String,Integer> function = new Function<String, Integer>() {		
			@Override
			public Integer apply(String arg0) {
				return NumberUtils.toInt(arg0);
			}
		};
		List<Integer> ints = Lists.transform(parents, function);
		System.out.println(ints);
		
		//#集合过滤 
		
		//#字符串截取
		String url = "assets/include/path/demo.css";
		File file = new File(url);
		System.out.println(file.getName());
		
		//注意点:#正则的两种写法以及性能消耗
		//1.写法1 string自带正则规则
		String regex = "/d\\./d";
		params.matches(regex);
		//2.先编译正则 在执行正则表达式
		Pattern pattern = Pattern.compile(regex);
		pattern.matches(regex, params);
		
	}
	
	@Test
	public void downloadAll(){
		//html //下载它里面所有的资源 # 批量下载
		
		
		//【Jsoup依赖包】处理html
		//1.转换成html树结构
		//2.获取标签 img link script,获取他们的属性
		//3.下载 【Apache-HttpClient依赖包】模拟http请求
		
		/**
		 * 第一步找到和导入需要的jar包 
		 * 
		 * 1.http://mvnrepository.com/search?q=Jsoup （Maven中央仓库找依赖包）
		 * 如果你不了解版本去吧 就找使用的人最多的那个版本
		 */
		
		//.代码开启
		//百度代码例子
		String html  = "";
		File htmlFile = new File("Metronic Shop UI.html");
		try {
			Document doc = Jsoup.parse(htmlFile,"utf-8");//maven会自动帮你管理源代码包和文档包
			//System.out.println(doc.toString());
			
			Set<String> urlSet = new HashSet<String>();
			//Set<String> urlSet = Sets.newHashSet();
			
			Elements eles = doc.getElementsByTag("img");
			for (Element element : eles) {
				//System.out.println(element.attr("src"));
				urlSet.add(element.attr("src"));
			}
			Elements eles2 = doc.getElementsByTag("script");
			for (Element element : eles2) {
				//System.out.println(element.attr("src"));
				urlSet.add(element.attr("src"));
			}
			Elements eles4 = doc.getElementsByTag("link");
			for (Element element : eles4) {
				//System.out.println(element.attr("src"));
				urlSet.add(element.attr("href"));
			}
			
			String prefix = "http://metronic.kp7.cn/";
			for (String url : urlSet) {
				//System.out.println(url);
				if(!url.startsWith("http"))
				{
					String filepath = url.replace("../", "");
					String durl = prefix+filepath;
					System.out.println(durl+","+filepath);
					//HttpDownload.download(prefix+url.replace("../", ""),url.replace("../", ""));
				}
				else{
					
				}
			}
			
//			String url  ="http://metronic.kp7.cn/assets/frontend/pages/img/brands/zara.jpg";
//			String filepath ="assets/frontend/pages/img/brands/zara.jpg";
//			System.out.println(url+","+filepath);
//			HttpDownload.download(url, filepath);
			//url路径分为哪些部分: http://metronic.kp7.cn
			 //localhost:8080/finalssm
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
