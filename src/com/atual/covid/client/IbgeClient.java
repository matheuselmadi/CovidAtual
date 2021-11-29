package com.atual.covid.client;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IbgeClient {

	  private static final String IBGE_GET_ESTADOS = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
	   

	    public static List<String> buscarEstados() {
	    	final DefaultHttpClient httpClient = new DefaultHttpClient();
	        String apiOutput = "";

	        try {
	            HttpGet getRequest = new HttpGet(IBGE_GET_ESTADOS);
	            HttpResponse response = httpClient.execute(getRequest);

	            if (response.getStatusLine().getStatusCode() != 200)
	                throw new RuntimeException("Failed with HTTP error code : " + response.getStatusLine().getStatusCode());

	            apiOutput = EntityUtils.toString(response.getEntity());

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            httpClient.getConnectionManager().shutdown();
	        }

	        return buildListFromJson(apiOutput);
	    }

	    private static List<String> buildListFromJson(String json) {
	        final EstadoIbgeResponse[] estadosIbge = new Gson().fromJson(json, EstadoIbgeResponse[].class);
	        return Arrays.stream(estadosIbge).map(EstadoIbgeResponse::getSigla).collect(Collectors.toList());
	    }
}
