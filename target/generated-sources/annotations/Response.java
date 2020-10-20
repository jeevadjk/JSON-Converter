import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
@WebServlet("/validate")
public class Response extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String str[] = request.getParameter("value").toString().split("\n");
		//System.out.println(str.length);
		for(int i = 0; i < str.length; i++)
			str[i].trim();
		String about = str[0].substring(10, str[0].length() - 3);
		String created = str[1].substring(11, str[1].length() - 2);
		String id = str[2].substring(7, str[2].length()-3);
		String likes = str[3].substring(9,str[3].length() - 2);
		String submitted = str[4].substring(14, str[4].length() - 1);
		/*System.out.println("about:"+about);
		System.out.println("created:"+created);
		System.out.println("id:"+id);
		System.out.println("likes:"+likes);
		System.out.println("submitted:"+submitted);*/
		JSONObject obj = new JSONObject();

	    obj.put("about",about);
	    obj.put("created", created);
	    obj.put("id",id);
	    obj.put("likes",likes);
	    obj.put("submitted", submitted);
	    StringWriter out = new StringWriter();
	    obj.writeJSONString(out);
	    String jsonText = out.toString();
	    System.out.print(jsonText);
	}
	
}



/*
{
"about": "Grootan",
"created": 1234567890,
"id": "Grootan_123",
"likes": 4229,
"submitted": [123.00, 1.00] 
 */
