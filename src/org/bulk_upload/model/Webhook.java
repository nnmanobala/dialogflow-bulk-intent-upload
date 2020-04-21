package org.bulk_upload.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "url", "username", "headers", "available", "useForDomains", "cloudFunctionsEnabled",
		"cloudFunctionsInitialized" })
public class Webhook {

	@JsonProperty("url")
	private String url = "";
	@JsonProperty("username")
	private String username = "";
	@JsonProperty("headers")
	private Headers headers = new Headers();
	@JsonProperty("available")
	private Boolean available = false;
	@JsonProperty("useForDomains")
	private Boolean useForDomains = false;
	@JsonProperty("cloudFunctionsEnabled")
	private Boolean cloudFunctionsEnabled = false;
	@JsonProperty("cloudFunctionsInitialized")
	private Boolean cloudFunctionsInitialized = false;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("headers")
	public Headers getHeaders() {
		return headers;
	}

	@JsonProperty("headers")
	public void setHeaders(Headers headers) {
		this.headers = headers;
	}

	@JsonProperty("available")
	public Boolean getAvailable() {
		return available;
	}

	@JsonProperty("available")
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@JsonProperty("useForDomains")
	public Boolean getUseForDomains() {
		return useForDomains;
	}

	@JsonProperty("useForDomains")
	public void setUseForDomains(Boolean useForDomains) {
		this.useForDomains = useForDomains;
	}

	@JsonProperty("cloudFunctionsEnabled")
	public Boolean getCloudFunctionsEnabled() {
		return cloudFunctionsEnabled;
	}

	@JsonProperty("cloudFunctionsEnabled")
	public void setCloudFunctionsEnabled(Boolean cloudFunctionsEnabled) {
		this.cloudFunctionsEnabled = cloudFunctionsEnabled;
	}

	@JsonProperty("cloudFunctionsInitialized")
	public Boolean getCloudFunctionsInitialized() {
		return cloudFunctionsInitialized;
	}

	@JsonProperty("cloudFunctionsInitialized")
	public void setCloudFunctionsInitialized(Boolean cloudFunctionsInitialized) {
		this.cloudFunctionsInitialized = cloudFunctionsInitialized;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
