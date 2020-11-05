package com.example.Spring.web.services.example.endpoints;

import com.example.Spring.web.services.example.generatedXSD.GetCountryByCurrencyRequest;
import com.example.Spring.web.services.example.generatedXSD.GetCountryByCurrencyResponse;
import com.example.Spring.web.services.example.generatedXSD.GetCountryRequest;
import com.example.Spring.web.services.example.generatedXSD.GetCountryResponse;
import com.example.Spring.web.services.example.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://com.example";

	private final CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByCurrencyRequest")
	@ResponsePayload
	public GetCountryResponse getCountryByCurrency(@RequestPayload GetCountryByCurrencyRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountryByCurrency(request.getCurrency()));
		return response;
	}
}