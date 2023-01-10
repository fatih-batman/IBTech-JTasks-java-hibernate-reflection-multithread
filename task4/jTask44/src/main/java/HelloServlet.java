

import jakarta.servlet.ServletException;




import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xmlHelper.xmlHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.tomcat.jakartaee.commons.io.IOUtils;
import org.xml.sax.SAXException;

import dataCarrier.DataCarrier;
import dataCarrier.DataCarrierEnum;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pr =  response.getWriter();
		String str = "Merhaba servled dunyasi";
		pr.write(str);
				//pr.append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pr =  response.getWriter();
		String data = request.getReader().lines().collect(Collectors.joining());
		//pr.write(data);
		try {
			DataCarrier dc = xmlHelper.makeOperations(data);
			PrintWriter writer = response.getWriter();
			writer.append("<EXT>");
			//writer.append("<id>" + dc.getValue(DataCarrierEnum.ID).toString() + "</id>");
			writer.append("<name>" + dc.getValue(DataCarrierEnum.NAME).toString() + "</name>");
			writer.append("<surname>" + dc.getValue(DataCarrierEnum.SURNAME).toString() + "</surname>");
			writer.append("</EXT>");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
