

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import associations.Abonnes;
import associations.Oeuvres;

/**
 * Servlet implementation class Emprunts
 */
@WebServlet("/Emprunts")
public class Emprunts extends HttpServletVersion2 {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	associations.Emprunts emprunts = new associations.Emprunts();
    public Emprunts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> params = getParams(request);
		String action = params.get("action");
		
		String includeJsp;
		
		associations.Abonnes abonnes = new associations.Abonnes();
		associations.Oeuvres oeuvres = new associations.Oeuvres();
 
		if ("ajouter".equals(action)) {
			includeJsp = "/pages/emprunts/ajouter.jsp";

			request.setAttribute("Title", "realiser un emprunt");

		} else {
			includeJsp = "/pages/emprunts/afficher.jsp";
			request.setAttribute("Title", "List des Emprunts");
		}
		
 
		request.setAttribute("includeJspContent", includeJsp);
		request.setAttribute("emprunts", emprunts);
		request.setAttribute("abonnes", abonnes);
		request.setAttribute("oeuvres", oeuvres);
		
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
				model.Emprunt a = new model.Emprunt(); 
				a.setToday();
				a.setRandomId();
				a.setAttributes(form_request);
				System.out.println(a);
				emprunts.add(a);
				emprunts.save();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("delete".equals(action)){
			emprunts.delete( e -> { 
				return e.getId().equals(form_request.get("id"));
			});
			emprunts.save();
		}
		
		
		response.sendRedirect("/GestionBibliotheque/Emprunts");
	}

}
