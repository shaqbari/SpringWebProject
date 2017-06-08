package com.sist.temp;

import java.lang.reflect.Method;
import java.util.*;

import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

/*
 * Tomcat 브라우저 실행시
 * pom.xml 
 * web.xml -> 클래스 생성(servlet, DispatcherServlet) 포털사이트같이 접속자가 많은 경우 DispatcherServlet을 여러개 만들어둬야 한다(like dbPooling)
 * Domain model(Spring4.0 카페, 블로그 기능마다 DispatcherServlet를 따로 만든다.)
 * application-context.xml
 * 
 * 	서버 / 클라이언트 ==> 네트워크 (CS) Http ==> TCP(Socket) ==> Thread Run() :service()
 *                                          Stream(Input, Output)
 *                                                 =====  ======
 *                                                 req    res
 * 
 *      
 *                                                 
 * */
public class MainClass {

	public static void main(String[] args) {
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("입력 : ");// select.do?id=aaa&pwd=1234 입력
			String cmd=scan.next();
			//setPwd=1234 로주면 setPwd()메소드 찾아 입력가능하고 parameter순서 상관없이 입력가능
			
			HandlerMapping hm=new HandlerMapping();
			List<String> list=hm.getList();
			for (String clsName : list) {
				Class cls=Class.forName(clsName);//reflection 클래스 정보 읽기
				//Controller con=(Controller) cls.getAnnotation(Controller.class);
				if (cls.isAnnotationPresent(Controller.class)==false) {//isAnnotationPresent : 어노테이션 존재 여부
					continue;//Controller가 없으면 여기서 멈추고 메모리할당 안하겠다.
				}
				Object obj=cls.newInstance();
				System.out.println(obj);
				
				Method[] methods=cls.getDeclaredMethods();
				for (Method m : methods) {
					//System.out.println(m.getName());
					RequestMapping rm=m.getAnnotation(RequestMapping.class);//getAnnotations면 한메소드에 붙은 여러개의 anno를 가져올수 있다.
					System.out.println(rm.value());//coding한 순서로 출력되지 않는다.
					String str=cmd.substring(0, cmd.lastIndexOf("?"));
					String data=cmd.substring(cmd.lastIndexOf("?")+1);
					String[] datas=data.split("&");
					Map map=new HashMap();
					for (String s : datas) {
						StringTokenizer st=new StringTokenizer(s, "=");
						map.put(st.nextToken(), st.nextToken());
					}							
							
					if (str.equals(rm.value())) {
						m.invoke(obj, map.get("id"), map.get("pwd"));
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
