package predictions;

import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@HandlerChain(file = "serviceHandler.xml")
public class PredictionsSOAP {

	private static final Predictions predictions = new Predictions();
	private static final int MAX_LENGTH = 16;

	@WebMethod
	public List<Prediction> getAll() {
		return predictions.getPredictions();
	}

	@WebMethod
	public Prediction getOne(int id) {
		return predictions.getPrediction(id);
	}

	@WebMethod
	public String create(String who, String what) throws VerbosityException {
		int count = wordCount(what);
		if (count > MAX_LENGTH)
			throw new VerbosityException(count + " is too verbose!", "Max words: " + MAX_LENGTH);

		Prediction p = new Prediction();
		p.setWho(who);
		p.setWhat(what);
		int id = predictions.addPrediction(p);
		String msg = "Prediction " + id + " created.";
		return msg;
	}

	@WebMethod
	public String edit(int id, String who, String what) throws VerbosityException {
		int count = wordCount(what);
		if (count > MAX_LENGTH)
			throw new VerbosityException(count + " is too verbose!", "Max words: " + MAX_LENGTH);

		String msg = "Prediction " + id + " not found.";
		Prediction p = predictions.getPrediction(id);
		if (p != null) {
			if (who != null)
				p.setWho(who);
			if (what != null)
				p.setWhat(what);
			msg = "Prediction " + id + " updated.";
		}
		return msg;
	}

	@WebMethod
	public String delete(int id) {
		String msg = "Prediction " + id + " not found.";
		Prediction p = predictions.getPrediction(id);
		if (p != null) {
			predictions.getMap().remove(id);
			msg = "Prediction " + id + " removed.";
		}
		return msg;
	}

	private int wordCount(String words) {
		if (words == null)
			return -1;
		return words.trim().split("\\s+").length;
	}
}