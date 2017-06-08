package com.sist.temp;

import java.lang.reflect.Method;
import java.util.*;

import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

/*
 * Tomcat ������ �����
 * pom.xml 
 * web.xml -> Ŭ���� ����(servlet, DispatcherServlet) ���л���Ʈ���� �����ڰ� ���� ��� DispatcherServlet�� ������ �����־� �Ѵ�(like dbPooling)
 * Domain model(Spring4.0 ī��, ��α� ��ɸ��� DispatcherServlet�� ���� �����.)
 * application-context.xml
 * 
 * 	���� / Ŭ���̾�Ʈ ==> ��Ʈ��ũ (CS) Http ==> TCP(Socket) ==> Thread Run() :service()
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
			System.out.println("�Է� : ");// select.do?id=aaa&pwd=1234 �Է�
			String cmd=scan.next();
			//setPwd=1234 ���ָ� setPwd()�޼ҵ� ã�� �Է°����ϰ� parameter���� ������� �Է°���
			
			HandlerMapping hm=new HandlerMapping();
			List<String> list=hm.getList();
			for (String clsName : list) {
				Class cls=Class.forName(clsName);//reflection Ŭ���� ���� �б�
				//Controller con=(Controller) cls.getAnnotation(Controller.class);
				if (cls.isAnnotationPresent(Controller.class)==false) {//isAnnotationPresent : ������̼� ���� ����
					continue;//Controller�� ������ ���⼭ ���߰� �޸��Ҵ� ���ϰڴ�.
				}
				Object obj=cls.newInstance();
				System.out.println(obj);
				
				Method[] methods=cls.getDeclaredMethods();
				for (Method m : methods) {
					//System.out.println(m.getName());
					RequestMapping rm=m.getAnnotation(RequestMapping.class);//getAnnotations�� �Ѹ޼ҵ忡 ���� �������� anno�� �����ü� �ִ�.
					System.out.println(rm.value());//coding�� ������ ��µ��� �ʴ´�.
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
