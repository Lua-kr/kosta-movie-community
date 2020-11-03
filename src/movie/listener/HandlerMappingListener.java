package movie.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import movie.controller.Controller;

@WebListener
public class HandlerMappingListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent e)  { }
    
    /**
     *  미리 생성 할 객체를 생성해서 Map에 저장하고
     *  Map을 applicationScope에 저장한다. (=사전초기화)
     * */
    public void contextInitialized(ServletContextEvent e)  { 
    	//conterxt-param정보 가져오기 (web.xml 파일에 <context-param>으로설정 )
    	ServletContext application =e.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	
    	Map< String, Controller> map = new HashMap<String, Controller>();
    	Map< String, Class<?>> clzMap = new HashMap<String, Class<?>>();
    	
    	 /* 미리 생성해야하는 객체에 대한 정보를가지고있는
    	  ~.properties파일을 로딩하기  ( baseName에 확장자는 생략한다.)*/
 
    	ResourceBundle rb =ResourceBundle.getBundle(fileName);
    	for(String key : rb.keySet()) {
    		String value = rb.getString(key);
    		//String 형태인 value를 객체로 만든다.
    		try {
    			Class<?> cls=Class.forName(value);
    			Controller controller =(Controller)cls.newInstance();
    			
    			map.put(key, controller);
    			clzMap.put(key, cls);
    			
			} catch (Exception ex) {
				ex.printStackTrace();
			}//catch
   
    	}//for
    	
    	application.setAttribute("map", map);
    	application.setAttribute("clzMap", clzMap);
    	
    	
    }//initialized
	
}//class




