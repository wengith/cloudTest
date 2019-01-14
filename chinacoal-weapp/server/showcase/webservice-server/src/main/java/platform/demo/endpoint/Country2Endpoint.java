package ins.platform.demo.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ins.platform.demo.ws.countries2.Country;
import ins.platform.demo.ws.countries2.GetCountryRequest;
import ins.platform.demo.ws.countries2.GetCountryResponse;

@Endpoint
public class Country2Endpoint {
	private static final String NAMESPACE_URI = "http://demo.platform.ins/ws/countries2";

	@PayloadRoot(localPart = "getCountryRequest", namespace = NAMESPACE_URI)
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		Country country = new Country();
		country.setCapital("webservice2 Capital of " + request.getName());
		country.setName(request.getName());
		response.setCountry(country);

		return response;
	}
}
