package cn.edu.shu.cs.jsp.serverforandroid;

import java.util.ArrayList;
import java.util.List;

public class NewsBuilderBean {
	public List<News> getLastNews(){
		List<News> newslist=new ArrayList<News>();
		newslist.add(new News(0,"�϶����ű���",20));
		newslist.add(new News(1,"���㵺֮��",10));
		newslist.add(new News(2,"android 4.4",40));
		newslist.add(new News(3,"ʮ�˴��ٿ�",20));
		return newslist;
		
	}

}
