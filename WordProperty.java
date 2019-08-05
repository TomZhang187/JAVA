package EmotionalAnalysis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;


/*
 * @ Author 张丰‎
 * @ Date 2019‎年‎5‎月‎19‎日
 * @content  读取感情词典与excel表中词汇对比
 */
public class WordProperty {
	
	public static void main(String[] args) throws IOException {
		WordProperty test=new WordProperty();
		test.WordJudge();
	}
		
public void WordJudge() throws IOException{
		ArrayList<String> buffer=new ArrayList();
		//负词典 degrade.txt 正词典 praise.txt
		BufferedReader bf=new BufferedReader(new FileReader("C:\\JAVA\\SisterTest\\praise.txt"));
	 // BufferedReader bf=new BufferedReader(new FileReader("C:\\JAVA\\SisterTest\\degrade.txt"));
		String s=null;
		while((s=bf.readLine())!=null){
			buffer.add(s.trim());
		}
		bf.close();	
		File file=new File("C:/JAVA/SisterTest/new.xls");
		ArrayList<String> str=ReadExcel.readExcel(file);   //调用读取方法，返回评论字符数组
		System.out.println(str.size());
		 int b=0;
		 int c=0;
		for(int i=0;i<str.size();i++){
			String tt=str.get(i);
			 List<Word> words = WordSegmenter.seg(tt);
			 
			
		 for(int j=0;j<words.size();j++){
				 String tt2=words.get(j).getText();
				 for(int x=0;x< buffer.size();x++){
					 String tt3= buffer.get(x);
					 if(tt2.equals(tt3)){
						 b++;
					 }
				 }								 
		 }
			    if(b!=0){
			    	c++;
			    }
			 	b=0;	
		}
		double kk=(double)c/(double)str.size();
		System.out.println("负向百分比："+kk);	
	}

}
