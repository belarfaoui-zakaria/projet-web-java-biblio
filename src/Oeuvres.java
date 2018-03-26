

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Oeuvres
 */
@WebServlet("/Oeuvres")
public class Oeuvres extends HttpServletVersion2 {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	associations.Oeuvres oeuvres;
	associations.Auteurs auteurs;
	
    public Oeuvres() {
        super();
        // TODO Auto-generated constructor stub
        
        oeuvres = new associations.Oeuvres();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HashMap<String, String> params = getParams(request);
		String action = params.get("action");
		
		String includeJsp;
		
		auteurs = new associations.Auteurs();
 
		if ("ajouter".equals(action)) {
			includeJsp = "/pages/oeuvres/ajouter.jsp";
			
			request.setAttribute("id", new Date().getTime());
			request.setAttribute("Title", "Ajouter un oeuvre");

		} else {
			includeJsp = "/pages/oeuvres/afficher.jsp";
			request.setAttribute("Title", "List des Oeuvres");
		}
		
		request.setAttribute("auteurs", auteurs);
		request.setAttribute("includeJspContent", includeJsp);
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
				model.Oeuvre a = new model.Oeuvre(); 
				
				a.setAttributes(form_request); 
				oeuvres.add(a);
				oeuvres.save();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("delete".equals(action)){
			oeuvres.delete( e -> { 
				System.out.println(form_request.get("id"));
				return e.getReference().equals(form_request.get("id"));
			});
			oeuvres.save();
		}
		
		
		response.sendRedirect("/GestionBibliotheque/Oeuvres");
	}

}
