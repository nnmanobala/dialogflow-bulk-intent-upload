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
@JsonPropertyOrder({ "name", "auto", "contexts", "responses", "priority", "webhookUsed", "webhookForSlotFilling",
		"fallbackIntent", "events", "conditionalResponses", "condition", "conditionalFollowupEvents" })
public class ServerResponse {

	@JsonProperty("name")
	private String name = "";
	@JsonProperty("auto")
	private Boolean auto = true;
	@JsonProperty("contexts")
	private List<Object> contexts = new ArrayList<Object>();
	@JsonProperty("responses")
	private List<Response> responses = new ArrayList<Response>();
	@JsonProperty("priority")
	private Integer priority = 500000;
	@JsonProperty("webhookUsed")
	private Boolean webhookUsed = false;
	@JsonProperty("webhookForSlotFilling")
	private Boolean webhookForSlotFilling = false;
	@JsonProperty("fallbackIntent")
	private Boolean fallbackIntent = false;
	@JsonProperty("events")
	private List<Object> events = new ArrayList<Object>();
	@JsonProperty("conditionalResponses")
	private List<Object> conditionalResponses = new ArrayList<Object>();
	@JsonProperty("condition")
	private String condition = "";
	@JsonProperty("conditionalFollowupEvents")
	private List<Object> conditionalFollowupEvents = new ArrayList<Object>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("auto")
	public Boolean getAuto() {
		return auto;
	}

	@JsonProperty("auto")
	public void setAuto(Boolean auto) {
		this.auto = auto;
	}

	@JsonProperty("contexts")
	public List<Object> getContexts() {
		return contexts;
	}

	@JsonProperty("contexts")
	public void setContexts(List<Object> contexts) {
		this.contexts = contexts;
	}

	@JsonProperty("responses")
	public List<Response> getResponses() {
		return responses;
	}

	@JsonProperty("responses")
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	@JsonProperty("priority")
	public Integer getPriority() {
		return priority;
	}

	@JsonProperty("priority")
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@JsonProperty("webhookUsed")
	public Boolean getWebhookUsed() {
		return webhookUsed;
	}

	@JsonProperty("webhookUsed")
	public void setWebhookUsed(Boolean webhookUsed) {
		this.webhookUsed = webhookUsed;
	}

	@JsonProperty("webhookForSlotFilling")
	public Boolean getWebhookForSlotFilling() {
		return webhookForSlotFilling;
	}

	@JsonProperty("webhookForSlotFilling")
	public void setWebhookForSlotFilling(Boolean webhookForSlotFilling) {
		this.webhookForSlotFilling = webhookForSlotFilling;
	}

	@JsonProperty("fallbackIntent")
	public Boolean getFallbackIntent() {
		return fallbackIntent;
	}

	@JsonProperty("fallbackIntent")
	public void setFallbackIntent(Boolean fallbackIntent) {
		this.fallbackIntent = fallbackIntent;
	}

	@JsonProperty("events")
	public List<Object> getEvents() {
		return events;
	}

	@JsonProperty("events")
	public void setEvents(List<Object> events) {
		this.events = events;
	}

	@JsonProperty("conditionalResponses")
	public List<Object> getConditionalResponses() {
		return conditionalResponses;
	}

	@JsonProperty("conditionalResponses")
	public void setConditionalResponses(List<Object> conditionalResponses) {
		this.conditionalResponses = conditionalResponses;
	}

	@JsonProperty("condition")
	public String getCondition() {
		return condition;
	}

	@JsonProperty("condition")
	public void setCondition(String condition) {
		this.condition = condition;
	}

	@JsonProperty("conditionalFollowupEvents")
	public List<Object> getConditionalFollowupEvents() {
		return conditionalFollowupEvents;
	}

	@JsonProperty("conditionalFollowupEvents")
	public void setConditionalFollowupEvents(List<Object> conditionalFollowupEvents) {
		this.conditionalFollowupEvents = conditionalFollowupEvents;
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
