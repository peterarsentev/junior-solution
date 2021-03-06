package parsentev.servlets;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO: comment
 * @author parsentev
 * @since 06.05.2016
 */
public class JsonController extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(JsonController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json");
		PrintWriter writer = new PrintWriter(resp.getOutputStream());
		writer.append("[{\"login\":\"test2\", \"email\":\"email2\"}]");
		writer.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserStorage.getInstance().add(new User("", req.getParameter("login"), "", ""));
	}
}
