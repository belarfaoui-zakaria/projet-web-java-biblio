

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Abonnes
 */
@WebServlet("/Abonnes")
public class Abonnes extends HttpServletVersion2 {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	associations.Abonnes abonnes;
    public Abonnes() {
        super();
        abonnes = new associations.Abonnes();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> params = getParams(request);
		String action = params.get("action");
		
		String includeJsp;
		
 
 
		if ("ajouter".equals(action)) {
			includeJsp = "/pages/abonnes/ajouter.jsp";
			request.setAttribute("Title", "Ajouter un Abonne");
		} else {
			includeJsp = "/pages/abonnes/afficher.jsp";
			request.setAttribute("Title", "List des Abonnes");
		}
		
 
		request.setAttribute("includeJspContent", includeJsp);
		request.setAttribute("abonnes", abonnes);

		render("index.jsp", request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> params = getParams(request);
		String action = params.get("action");
		
		HashMap<String, Object> form_request = getFormParameters(request);
		if("ajouter".equals(action)){
			try {
				model.Abonne a = new model.Abonne(); 
				a.setToday();
				a.setRandomId();
				a.setAttributes(form_request);
				System.out.println(a);
				abonnes.add(a);
				abonnes.save();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("delete".equals(action)){
			abonnes.delete( e -> { 
				System.out.println(form_request.get("id"));
				return e.getId().equals(form_request.get("id"));
			});
			abonnes.save();
		}
		
		
		response.sendRedirect("/GestionBibliotheque/Abonnes");
	}

}
