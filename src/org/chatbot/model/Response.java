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
@JsonPropertyOrder({ "resetContexts", "affectedContexts", "parameters", "messages", "defaultResponsePlatforms",
		"speech" })
public class Response {

	@JsonProperty("resetContexts")
	private Boolean resetContexts = false;
	@JsonProperty("affectedContexts")
	private List<Object> affectedContexts = new ArrayList<Object>();
	@JsonProperty("parameters")
	private List<Object> parameters = new ArrayList<Object>();
	@JsonProperty("messages")
	private List<Message> messages = new ArrayList<Message>();
	@JsonProperty("defaultResponsePlatforms")
	private DefaultResponsePlatforms defaultResponsePlatforms =  new DefaultResponsePlatforms();
	@JsonProperty("speech")
	private List<Object> speech = new ArrayList<Object>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("resetContexts")
	public Boolean getResetContexts() {
		return resetContexts;
	}

	@JsonProperty("resetContexts")
	public void setResetContexts(Boolean resetContexts) {
		this.resetContexts = resetContexts;
	}

	@JsonProperty("affectedContexts")
	public List<Object> getAffectedContexts() {
		return affectedContexts;
	}

	@JsonProperty("affectedContexts")
	public void setAffectedContexts(List<Object> affectedContexts) {
		this.affectedContexts = affectedContexts;
	}

	@JsonProperty("parameters")
	public List<Object> getParameters() {
		return parameters;
	}

	@JsonProperty("parameters")
	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}

	@JsonProperty("messages")
	public List<Message> getMessages() {
		return messages;
	}

	@JsonProperty("messages")
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@JsonProperty("defaultResponsePlatforms")
	public DefaultResponsePlatforms getDefaultResponsePlatforms() {
		return defaultResponsePlatforms;
	}

	@JsonProperty("defaultResponsePlatforms")
	public void setDefaultResponsePlatforms(DefaultResponsePlatforms defaultResponsePlatforms) {
		this.defaultResponsePlatforms = defaultResponsePlatforms;
	}

	@JsonProperty("speech")
	public List<Object> getSpeech() {
		return speech;
	}

	@JsonProperty("speech")
	public void setSpeech(List<Object> speech) {
		this.speech = speech;
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