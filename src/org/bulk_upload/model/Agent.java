package org.bulk_upload.model;

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
@JsonPropertyOrder({ "description", "language", "shortDescription", "examples", "linkToDocs", "disableInteractionLogs",
		"disableStackdriverLogs", "googleAssistant", "defaultTimezone", "webhook", "isPrivate", "customClassifierMode",
		"mlMinConfidence", "supportedLanguages", "onePlatformApiVersion", "analyzeQueryTextSentiment",
		"enabledKnowledgeBaseNames", "knowledgeServiceConfidenceAdjustment", "dialogBuilderMode",
		"baseActionPackagesUrl" })
public class Agent {

	@JsonProperty("description")
	private String description = "";
	@JsonProperty("language")
	private String language = "en";
	@JsonProperty("shortDescription")
	private String shortDescription = "";
	@JsonProperty("examples")
	private String examples = "";
	@JsonProperty("linkToDocs")
	private String linkToDocs = "";
	@JsonProperty("disableInteractionLogs")
	private Boolean disableInteractionLogs = false;
	@JsonProperty("disableStackdriverLogs")
	private Boolean disableStackdriverLogs = true;
	@JsonProperty("googleAssistant")
	private GoogleAssistant googleAssistant = new GoogleAssistant();
	@JsonProperty("defaultTimezone")
	private String defaultTimezone = "Asia/Almaty";
	@JsonProperty("webhook")
	private Webhook webhook = new Webhook();
	@JsonProperty("isPrivate")
	private Boolean isPrivate = true;
	@JsonProperty("customClassifierMode")
	private String customClassifierMode = "use.after";
	@JsonProperty("mlMinConfidence")
	private Double mlMinConfidence = 0.3;
	@JsonProperty("supportedLanguages")
	private List<Object> supportedLanguages = new ArrayList<Object>();
	@JsonProperty("onePlatformApiVersion")
	private String onePlatformApiVersion = "v2";
	@JsonProperty("analyzeQueryTextSentiment")
	private Boolean analyzeQueryTextSentiment = false;
	@JsonProperty("enabledKnowledgeBaseNames")
	private List<Object> enabledKnowledgeBaseNames = new ArrayList<Object>();
	@JsonProperty("knowledgeServiceConfidenceAdjustment")
	private Double knowledgeServiceConfidenceAdjustment = -0.4;
	@JsonProperty("dialogBuilderMode")
	private Boolean dialogBuilderMode = false;
	@JsonProperty("baseActionPackagesUrl")
	private String baseActionPackagesUrl = "";
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("shortDescription")
	public String getShortDescription() {
		return shortDescription;
	}

	@JsonProperty("shortDescription")
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@JsonProperty("examples")
	public String getExamples() {
		return examples;
	}

	@JsonProperty("examples")
	public void setExamples(String examples) {
		this.examples = examples;
	}

	@JsonProperty("linkToDocs")
	public String getLinkToDocs() {
		return linkToDocs;
	}

	@JsonProperty("linkToDocs")
	public void setLinkToDocs(String linkToDocs) {
		this.linkToDocs = linkToDocs;
	}

	@JsonProperty("disableInteractionLogs")
	public Boolean getDisableInteractionLogs() {
		return disableInteractionLogs;
	}

	@JsonProperty("disableInteractionLogs")
	public void setDisableInteractionLogs(Boolean disableInteractionLogs) {
		this.disableInteractionLogs = disableInteractionLogs;
	}

	@JsonProperty("disableStackdriverLogs")
	public Boolean getDisableStackdriverLogs() {
		return disableStackdriverLogs;
	}

	@JsonProperty("disableStackdriverLogs")
	public void setDisableStackdriverLogs(Boolean disableStackdriverLogs) {
		this.disableStackdriverLogs = disableStackdriverLogs;
	}

	@JsonProperty("googleAssistant")
	public GoogleAssistant getGoogleAssistant() {
		return googleAssistant;
	}

	@JsonProperty("googleAssistant")
	public void setGoogleAssistant(GoogleAssistant googleAssistant) {
		this.googleAssistant = googleAssistant;
	}

	@JsonProperty("defaultTimezone")
	public String getDefaultTimezone() {
		return defaultTimezone;
	}

	@JsonProperty("defaultTimezone")
	public void setDefaultTimezone(String defaultTimezone) {
		this.defaultTimezone = defaultTimezone;
	}

	@JsonProperty("webhook")
	public Webhook getWebhook() {
		return webhook;
	}

	@JsonProperty("webhook")
	public void setWebhook(Webhook webhook) {
		this.webhook = webhook;
	}

	@JsonProperty("isPrivate")
	public Boolean getIsPrivate() {
		return isPrivate;
	}

	@JsonProperty("isPrivate")
	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	@JsonProperty("customClassifierMode")
	public String getCustomClassifierMode() {
		return customClassifierMode;
	}

	@JsonProperty("customClassifierMode")
	public void setCustomClassifierMode(String customClassifierMode) {
		this.customClassifierMode = customClassifierMode;
	}

	@JsonProperty("mlMinConfidence")
	public Double getMlMinConfidence() {
		return mlMinConfidence;
	}

	@JsonProperty("mlMinConfidence")
	public void setMlMinConfidence(Double mlMinConfidence) {
		this.mlMinConfidence = mlMinConfidence;
	}

	@JsonProperty("supportedLanguages")
	public List<Object> getSupportedLanguages() {
		return supportedLanguages;
	}

	@JsonProperty("supportedLanguages")
	public void setSupportedLanguages(List<Object> supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}

	@JsonProperty("onePlatformApiVersion")
	public String getOnePlatformApiVersion() {
		return onePlatformApiVersion;
	}

	@JsonProperty("onePlatformApiVersion")
	public void setOnePlatformApiVersion(String onePlatformApiVersion) {
		this.onePlatformApiVersion = onePlatformApiVersion;
	}

	@JsonProperty("analyzeQueryTextSentiment")
	public Boolean getAnalyzeQueryTextSentiment() {
		return analyzeQueryTextSentiment;
	}

	@JsonProperty("analyzeQueryTextSentiment")
	public void setAnalyzeQueryTextSentiment(Boolean analyzeQueryTextSentiment) {
		this.analyzeQueryTextSentiment = analyzeQueryTextSentiment;
	}

	@JsonProperty("enabledKnowledgeBaseNames")
	public List<Object> getEnabledKnowledgeBaseNames() {
		return enabledKnowledgeBaseNames;
	}

	@JsonProperty("enabledKnowledgeBaseNames")
	public void setEnabledKnowledgeBaseNames(List<Object> enabledKnowledgeBaseNames) {
		this.enabledKnowledgeBaseNames = enabledKnowledgeBaseNames;
	}

	@JsonProperty("knowledgeServiceConfidenceAdjustment")
	public Double getKnowledgeServiceConfidenceAdjustment() {
		return knowledgeServiceConfidenceAdjustment;
	}

	@JsonProperty("knowledgeServiceConfidenceAdjustment")
	public void setKnowledgeServiceConfidenceAdjustment(Double knowledgeServiceConfidenceAdjustment) {
		this.knowledgeServiceConfidenceAdjustment = knowledgeServiceConfidenceAdjustment;
	}

	@JsonProperty("dialogBuilderMode")
	public Boolean getDialogBuilderMode() {
		return dialogBuilderMode;
	}

	@JsonProperty("dialogBuilderMode")
	public void setDialogBuilderMode(Boolean dialogBuilderMode) {
		this.dialogBuilderMode = dialogBuilderMode;
	}

	@JsonProperty("baseActionPackagesUrl")
	public String getBaseActionPackagesUrl() {
		return baseActionPackagesUrl;
	}

	@JsonProperty("baseActionPackagesUrl")
	public void setBaseActionPackagesUrl(String baseActionPackagesUrl) {
		this.baseActionPackagesUrl = baseActionPackagesUrl;
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
