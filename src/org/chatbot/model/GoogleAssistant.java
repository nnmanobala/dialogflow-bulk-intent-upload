package org.chatbot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "googleAssistantCompatible", "project", "welcomeIntentSignInRequired", "startIntents",
		"systemIntents", "endIntentIds", "oAuthLinking", "voiceType", "capabilities", "env", "protocolVersion",
		"autoPreviewEnabled", "isDeviceAgent" })
public class GoogleAssistant {

	@JsonProperty("googleAssistantCompatible")
	private Boolean googleAssistantCompatible = false;
	@JsonProperty("project")
	private String project = "";
	@JsonProperty("welcomeIntentSignInRequired")
	private Boolean welcomeIntentSignInRequired = false;
	@JsonProperty("startIntents")
	private List<Object> startIntents = new ArrayList<Object>();
	@JsonProperty("systemIntents")
	private List<Object> systemIntents = new ArrayList<Object>();
	@JsonProperty("endIntentIds")
	private List<Object> endIntentIds = new ArrayList<Object>();
	@JsonProperty("oAuthLinking")
	private OAuthLinking oAuthLinking = new OAuthLinking();
	@JsonProperty("voiceType")
	private String voiceType = "MALE_1";
	@JsonProperty("capabilities")
	private List<Object> capabilities = new ArrayList<Object>();
	@JsonProperty("env")
	private String env = "";
	@JsonProperty("protocolVersion")
	private String protocolVersion = "v2";
	@JsonProperty("autoPreviewEnabled")
	private Boolean autoPreviewEnabled = false;
	@JsonProperty("isDeviceAgent")
	private Boolean isDeviceAgent = false;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("googleAssistantCompatible")
	public Boolean getGoogleAssistantCompatible() {
		return googleAssistantCompatible;
	}

	@JsonProperty("googleAssistantCompatible")
	public void setGoogleAssistantCompatible(Boolean googleAssistantCompatible) {
		this.googleAssistantCompatible = googleAssistantCompatible;
	}

	@JsonProperty("project")
	public String getProject() {
		return project;
	}

	@JsonProperty("project")
	public void setProject(String project) {
		this.project = project;
	}

	@JsonProperty("welcomeIntentSignInRequired")
	public Boolean getWelcomeIntentSignInRequired() {
		return welcomeIntentSignInRequired;
	}

	@JsonProperty("welcomeIntentSignInRequired")
	public void setWelcomeIntentSignInRequired(Boolean welcomeIntentSignInRequired) {
		this.welcomeIntentSignInRequired = welcomeIntentSignInRequired;
	}

	@JsonProperty("startIntents")
	public List<Object> getStartIntents() {
		return startIntents;
	}

	@JsonProperty("startIntents")
	public void setStartIntents(List<Object> startIntents) {
		this.startIntents = startIntents;
	}

	@JsonProperty("systemIntents")
	public List<Object> getSystemIntents() {
		return systemIntents;
	}

	@JsonProperty("systemIntents")
	public void setSystemIntents(List<Object> systemIntents) {
		this.systemIntents = systemIntents;
	}

	@JsonProperty("endIntentIds")
	public List<Object> getEndIntentIds() {
		return endIntentIds;
	}

	@JsonProperty("endIntentIds")
	public void setEndIntentIds(List<Object> endIntentIds) {
		this.endIntentIds = endIntentIds;
	}

	@JsonProperty("oAuthLinking")
	public OAuthLinking getOAuthLinking() {
		return oAuthLinking;
	}

	@JsonProperty("oAuthLinking")
	public void setOAuthLinking(OAuthLinking oAuthLinking) {
		this.oAuthLinking = oAuthLinking;
	}

	@JsonProperty("voiceType")
	public String getVoiceType() {
		return voiceType;
	}

	@JsonProperty("voiceType")
	public void setVoiceType(String voiceType) {
		this.voiceType = voiceType;
	}

	@JsonProperty("capabilities")
	public List<Object> getCapabilities() {
		return capabilities;
	}

	@JsonProperty("capabilities")
	public void setCapabilities(List<Object> capabilities) {
		this.capabilities = capabilities;
	}

	@JsonProperty("env")
	public String getEnv() {
		return env;
	}

	@JsonProperty("env")
	public void setEnv(String env) {
		this.env = env;
	}

	@JsonProperty("protocolVersion")
	public String getProtocolVersion() {
		return protocolVersion;
	}

	@JsonProperty("protocolVersion")
	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	@JsonProperty("autoPreviewEnabled")
	public Boolean getAutoPreviewEnabled() {
		return autoPreviewEnabled;
	}

	@JsonProperty("autoPreviewEnabled")
	public void setAutoPreviewEnabled(Boolean autoPreviewEnabled) {
		this.autoPreviewEnabled = autoPreviewEnabled;
	}

	@JsonProperty("isDeviceAgent")
	public Boolean getIsDeviceAgent() {
		return isDeviceAgent;
	}

	@JsonProperty("isDeviceAgent")
	public void setIsDeviceAgent(Boolean isDeviceAgent) {
		this.isDeviceAgent = isDeviceAgent;
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