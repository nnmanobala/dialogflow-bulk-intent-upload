package org.chatbot.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "required", "providerId", "authorizationUrl", "tokenUrl", "scopes", "privacyPolicyUrl",
		"grantType" })
public class OAuthLinking {

	@JsonProperty("required")
	private Boolean required = false;
	@JsonProperty("providerId")
	private String providerId = "";
	@JsonProperty("authorizationUrl")
	private String authorizationUrl = "";
	@JsonProperty("tokenUrl")
	private String tokenUrl = "";
	@JsonProperty("scopes")
	private String scopes = "";
	@JsonProperty("privacyPolicyUrl")
	private String privacyPolicyUrl = "";
	@JsonProperty("grantType")
	private String grantType = "AUTH_CODE_GRANT";
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("required")
	public Boolean getRequired() {
		return required;
	}

	@JsonProperty("required")
	public void setRequired(Boolean required) {
		this.required = required;
	}

	@JsonProperty("providerId")
	public String getProviderId() {
		return providerId;
	}

	@JsonProperty("providerId")
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	@JsonProperty("authorizationUrl")
	public String getAuthorizationUrl() {
		return authorizationUrl;
	}

	@JsonProperty("authorizationUrl")
	public void setAuthorizationUrl(String authorizationUrl) {
		this.authorizationUrl = authorizationUrl;
	}

	@JsonProperty("tokenUrl")
	public String getTokenUrl() {
		return tokenUrl;
	}

	@JsonProperty("tokenUrl")
	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	@JsonProperty("scopes")
	public String getScopes() {
		return scopes;
	}

	@JsonProperty("scopes")
	public void setScopes(String scopes) {
		this.scopes = scopes;
	}

	@JsonProperty("privacyPolicyUrl")
	public String getPrivacyPolicyUrl() {
		return privacyPolicyUrl;
	}

	@JsonProperty("privacyPolicyUrl")
	public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
		this.privacyPolicyUrl = privacyPolicyUrl;
	}

	@JsonProperty("grantType")
	public String getGrantType() {
		return grantType;
	}

	@JsonProperty("grantType")
	public void setGrantType(String grantType) {
		this.grantType = grantType;
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