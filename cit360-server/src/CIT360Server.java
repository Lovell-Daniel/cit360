import java.util.ArrayList;

import edu.byui.cit360.lovell_daniel.controller.ApplicationController;
import edu.byui.cit360.lovell_daniel.model.HibernateUtility;

public class CIT360Server {

	public static void main(String[] args) {
		ApplicationController appController = new ApplicationController();
		appController.handleRequest("menu", new ArrayList<String>(0));
	}

}
