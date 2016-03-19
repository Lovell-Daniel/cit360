import edu.byui.cit360.lovell_daniel.controller.ApplicationController;

public class CIT360Client {

	public static void main(String[] args) {
		ApplicationController appController = new ApplicationController();
		appController.handleRequest("menu");
	}

}
