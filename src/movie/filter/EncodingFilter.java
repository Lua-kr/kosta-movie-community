package movie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.sun.org.apache.xml.internal.security.Init;

@WebFilter(//urlPatterns = {"/encodingResult.jsp", "/encResult"}, 
				urlPatterns = {"/*"},
				  initParams = {@WebInitParam(name="encoding" , value="utf-8")})
public class EncodingFilter implements Filter {

	String enc;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		enc=filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(enc);
		response.setContentType("text/html; UTF-8");
		chain.doFilter(request, response);

	}

}
