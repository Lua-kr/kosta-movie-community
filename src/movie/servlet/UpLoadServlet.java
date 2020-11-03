package movie.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/UpLoad")
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 폼에서 "multipart/form-data" 설정되면 request로 데이터를 받을수없다
		//cos.jar에서 제공되는 클래스를 이용한다.
		String saveDir=request.getServletContext().getRealPath("/saveProfile");
		int maxSize =1024*1024*100; //100M
		String encoding ="utf-8";
		
		//전송된 데이터 받기
		MultipartRequest m =
				new MultipartRequest
					(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String  name = m.getParameter("name");
		String  subject= m.getParameter("subject");
		String  file =m.getFilesystemName("file");
		String originalFile= m.getOriginalFileName("file");
		
		//파일의 정보
		File f = m.getFile("file");
		long fileSize =f.length();
		
		//view로 이동하기전에 뷰쪽으로 전달될 정보를 저장
		request.setAttribute("name", name);
		request.setAttribute("originalFile", originalFile);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("file", file);
		request.setAttribute("subject", subject);
		request.setAttribute("saveDir", saveDir);
		
		//forward 방식으로 이동
		request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
		
	}

}
