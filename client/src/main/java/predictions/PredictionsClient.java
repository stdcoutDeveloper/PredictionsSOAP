package predictions;

import java.util.List;

import predictions.clientSOAP.Prediction;
import predictions.clientSOAP.PredictionsSOAP;
import predictions.clientSOAP.PredictionsSOAPService;
import predictions.clientSOAP.VerbosityException_Exception;

public class PredictionsClient {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Usage: PredictionsClient <name> <key>");
			return;
		}
		try {
			new PredictionsClient().runTests(args[0], args[1]);
		} catch (VerbosityException_Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void runTests(String name, String key) throws VerbosityException_Exception {
		PredictionsSOAPService service = new PredictionsSOAPService();
		service.setHandlerResolver(new ClientHandlerResolver(name, key));
		PredictionsSOAP port = service.getPredictionsSOAPPort();

		getTests(port);
		deleteTest(port, 33); // delete the just POSTed prediction
		getAllTest(port); // confirm the POST
		putTest(port);
		getAllTest(port);
		postTest(port);
		getAllTest(port);
	}

	private void getTests(PredictionsSOAP port) {
		getAllTest(port);
		getOneTest(port);
	}

	private void getAllTest(PredictionsSOAP port) {
		msg("getAll");
		List<Prediction> preds = port.getAll();
		for (Prediction pred : preds)
			System.out.println(String.format("%2d: ", pred.getId()) + pred.getWho() + " predicts: " + pred.getWhat());
	}

	private void getOneTest(PredictionsSOAP port) {
		msg("getOne (31)");
		System.out.println(port.getOne(31).getWhat());
	}

	private void postTest(PredictionsSOAP port) throws VerbosityException_Exception {
		msg("postTest");
		String who = "Freddy";
		String what = "foo foo foo foo foo foo foo foo foo foo foo foo foo foo foo foo foo foo.";
		String res = port.create(who, what);
		System.out.println(res);
	}

	private void putTest(PredictionsSOAP port) throws VerbosityException_Exception {
		msg("putTest -- here's the record to be edited");
		getOneTest(port);
		msg("putTest results");
		String who = "FooBarBaz";
		String what = null; // shouldn't change
		int id = 0;
		String res = port.edit(id, who, what);
		System.out.println(res);
		System.out.println("Confirming:");
		Prediction p = port.getOne(31);
		System.out.println(p.getWho());
		System.out.println(p.getWhat());
	}

	private void deleteTest(PredictionsSOAP port, int id) {
		msg("deleteTest");
		String res = port.delete(id);
		System.out.println(res);
	}

	private void msg(String s) {
		System.out.println("\n" + s + "\n");
	}
}
