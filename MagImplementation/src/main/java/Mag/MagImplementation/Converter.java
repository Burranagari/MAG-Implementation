package Mag.MagImplementation;

import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Converter {
	
	public static void main(String[] args) {
		System.out.println( convertJsonToNeo4j("C:\\Users\\yadavd2\\Desktop\\MAG Data\\mag1.txt")); 
//		convertJsonToNeo4j("C:\\Users\\yadavd2\\Desktop\\MAG Data\\mag1.txt");
  }
	
	
	/**
	 * This method takes the file path of input file
	 * and generates an array of Neo4J Statement
	 * @param magFileLocationPath
	 * @return
	 */
  static List<String> convertJsonToNeo4j(String magFileLocationPath) {
	 JSONParser parser = new JSONParser();
	 
	 List<MagDataModel> magDataModelList = new LinkedList<MagDataModel>();	
	 
	 try {
	        Object obj = parser.parse(new FileReader(magFileLocationPath));
	        JSONArray jsonArray = (JSONArray) obj;
	        int length = jsonArray.size();
	        for (int i =0; i< length; i++) {
	            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
	            Set s = jsonObject.entrySet();
	            Iterator iter = s.iterator();
	            LinkedList ll = new LinkedList();
	            LinkedList lm = new LinkedList();
	            while(iter.hasNext()){
	                Map.Entry me = (Map.Entry) iter.next();
	                ll.add(me.getValue());
	                lm.add(me.getKey());
	            }
	            String refStr = ll.get(0).toString();
	            List<String> refArr = (List<String>)(jsonObject.get("references"));
	            List<String> fosArr = (List<String>)(jsonObject.get("fos"));
	            List<String> refUrl = (List<String>)(jsonObject.get("url"));
	            String title = jsonObject.get("title").toString();
	            String lang = jsonObject.get("lang").toString();
	            String id = jsonObject.get("id").toString();
	            String abstr = jsonObject.get("abstract").toString();
	            int year = Integer.parseInt(jsonObject.get("year").toString());
	            
	      
	            MagDataModel magDataModelObj = new MagDataModel();
	            magDataModelObj.setReferences(refArr);
	            magDataModelObj.setYear(year);
	            magDataModelObj.setAbstract(abstr);
	            magDataModelObj.setId(id);
	            magDataModelObj.setFos(fosArr);
	            magDataModelObj.setTitle(title);
	            magDataModelObj.setLang(id);
	            magDataModelObj.setUrl(refUrl);
	            magDataModelList.add(magDataModelObj);
	            }            
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	 return appendNeo4JStatements(magDataModelList);
	}
  
  
  static List<String> appendNeo4JStatements(List<MagDataModel> magDataModelList) {
	  List<String> neo4JStmts = new LinkedList<String>();
	  for (MagDataModel magDataObj : magDataModelList) {
	  String appdendNeoStmt = "WITH count(*) as dummy\n"+
	  "MERGE (a:Node {title: " + magDataObj.getTitle()  +"})\n"+
	  "MERGE (b:Node {lang: " + magDataObj.getLang()  +"})\n"+
	  "MERGE (c:Node {year: " + magDataObj.getYear()  +"})\n"+
	  "MERGE (d:Node {references: " + magDataObj.getReferences()  +"})\n"+
	  "MERGE (e:Node {abstract: " + magDataObj.getAbstract()  +"})\n"+
	  "MERGE (f:Node {url: " + magDataObj.getUrl()  +"})\n"+
	  "MERGE (g:Node {id: " + magDataObj.getId()  +"})\n"+
	  "MERGE (h:Node {fos: " + magDataObj.getFos()  +"})\n"+
	  "CREATE (a)-[:LINK]->(b)";
	  neo4JStmts.add(appdendNeoStmt);
	  }
	  return neo4JStmts;
  }
}
