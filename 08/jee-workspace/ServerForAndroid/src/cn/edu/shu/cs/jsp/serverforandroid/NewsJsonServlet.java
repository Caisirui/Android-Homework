package cn.edu.shu.cs.jsp.serverforandroid;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewsXmlBuilder
 */
@WebServlet("/NewsJsonServlet")
public class NewsJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsBuilderBean bean=new NewsBuilderBean();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<News> newslist=bean.getLastNews();
		StringBuilder strBuilder=new StringBuilder();
		strBuilder.append('[');
		for(News news:newslist){
			strBuilder.append('{');
			strBuilder.append("id:").append(news.getId()).append(",");
			strBuilder.append("title:\"").append(news.getTitle()).append("\"").append(",");
			strBuilder.append("timelength:").append(news.getTimelength());
			strBuilder.append("},");
		}
		strBuilder.deleteCharAt(strBuilder.length()-1);
		strBuilder.append(']');		
		request.setAttribute("json", strBuilder.toString());
		request.getRequestDispatcher("/WEB-INF/page/NewsJsonSchema.jsp").forward(request, response);
	}

}
