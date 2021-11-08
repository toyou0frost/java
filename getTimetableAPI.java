package test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static test.login.a;
import static test.login.c;

public class getTimetableAPI {
    // tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
	
	public static String[] perio = new String[34], itrt_cntnt = new String[34], all_ti_ymd = new String[34]; 

	public void main() {
		if(a == null && c == null) {
			a = "2";
			c = "6";		
		}
		try{
				// parsing할 url 지정(API 키 포함해서)
				String url = "https://open.neis.go.kr/hub/hisTimetable?ATPT_OFCDC_SC_CODE=B10&SD_SCHUL_CODE=7010536&CLASS_NM="+c+"&GRADE="+a+"&KEY=a182603233f8472fb15ff5bbb226e0b2&TI_FROM_YMD=20211101&TI_TO_YMD=20211105";
				//System.out.println(url);
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("row");
				System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						Element eElement = (Element) nNode;
						System.out.println("######################");
						perio[temp] = getTagValue("PERIO", eElement);
						itrt_cntnt[temp] = getTagValue("ITRT_CNTNT", eElement);
						all_ti_ymd[temp] = getTagValue("ALL_TI_YMD", eElement);
						//System.out.println(eElement.getTextContent());
						System.out.println("교시  : " + perio[temp]);
						System.out.println("과목  : " + itrt_cntnt[temp]);
						System.out.println("요일 : " + all_ti_ymd[temp]);
					}	// for end
				}	// if end
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
	}	// main end
}	// class end