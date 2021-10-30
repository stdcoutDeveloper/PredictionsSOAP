package predictions;

import javax.xml.ws.Endpoint;

public class PredictionsSOAPPublisher {

	public static void main(String[] args) {
		final String url = "http://localhost:8888/predictions";
		System.out.println("Publishing PredictionsService at endpoint " + url);

		Endpoint.publish(url, new PredictionsSOAP());
	}
}
