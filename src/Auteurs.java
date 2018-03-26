

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Auteurs
 */
@WebServlet("/Auteurs")
public class Auteurs extends HttpServletVersion2 {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	associations.Auteurs auteurs;
    public Auteurs() {
        super();
        this.auteurs = new associations.Auteurs();
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
			includeJsp = "/pages/auteurs/ajouter.jsp";
			request.setAttribute("Title", "Ajouter un auteur");
		} else {
			includeJsp = "/pages/auteurs/afficher.jsp";
			request.setAttribute("Title", "List des Auteurs");
		}
		
 
		request.setAttribute("includeJspContent", includeJsp);
		request.setAttribute("auteurs", auteurs);

		render("index.jsp", request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HashMap<String, String> params = getParams(request);
		String action = params.get("action");
		System.out.println(action);
		HashMap<String, Object> form_request = getFormParameters(request);
		if("ajouter".equals(action)){
			try {
				model.Auteur a = new model.Auteur(); 
				a.setRandomId();
				a.setAttributes(form_request);
				auteurs.add(a);
				auteurs.save();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("delete".equals(action)){
 
			auteurs.delete( e -> { 
				return e.getId().equals(form_request.get("id"));
			});
			auteurs.save();
		}
		
		
		response.sendRedirect("/GestionBibliotheque/Auteurs");
	}

}
