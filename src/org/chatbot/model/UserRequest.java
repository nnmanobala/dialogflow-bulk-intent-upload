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
@JsonPropertyOrder({ "data", "isTemplate", "count", "updated" })
public class UserRequest {

	@JsonProperty("data")
	private List<Datum> data = new ArrayList<Datum>();
	@JsonProperty("isTemplate")
	private Boolean isTemplate = false;
	@JsonProperty("count")
	private Integer count = 0;
	@JsonProperty("updated")
	private Integer updated = 0;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("data")
	public List<Datum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
		this.data = data;
	}

	public void addData(Datum data) {
		this.data.add(data);
	}
	
	@JsonProperty("isTemplate")
	public Boolean getIsTemplate() {
		return isTemplate;
	}

	@JsonProperty("isTemplate")
	public void setIsTemplate(Boolean isTemplate) {
		this.isTemplate = isTemplate;
	}

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	@JsonProperty("updated")
	public Integer getUpdated() {
		return updated;
	}

	@JsonProperty("updated")
	public void setUpdated(Integer updated) {
		this.updated = updated;
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
