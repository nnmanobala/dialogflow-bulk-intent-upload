package org.bulk_upload.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bulk_upload.model.Agent;
import org.bulk_upload.model.ConsolidatedSchema;
import org.bulk_upload.model.Datum;
import org.bulk_upload.model.Info;
import org.bulk_upload.model.Intent;
import org.bulk_upload.model.Message;
import org.bulk_upload.model.Response;
import org.bulk_upload.model.ServerResponse;
import org.bulk_upload.model.UserRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonBuilder {

	private Logger logger = LogManager.getLogger(JsonBuilder.class);

	public void buildAndWriteIntentJson(Intent intent) {

		ConsolidatedSchema schema = constructJson(intent);
		// printJson(serverResponse);

		// Writing to file
		JsonWriter jsonWriter = new JsonWriter();
		jsonWriter.printToFile(schema.getUserRequests(),
				intent.getIntent() + "_usersays_" + ConfigManager.config.getProperty("language") + ".json", true);
		jsonWriter.printToFile(schema.getServerResponse(), intent.getIntent() + ".json", true);
		logger.info("Intent " + intent.getIntent() + " has " + intent.getQuestion().size() + " questions.\n");
	}

	public ConsolidatedSchema constructJson(Intent intent) {
		Datum datum;
		UserRequest userRequest = null;
		List<UserRequest> userRequests = new ArrayList<UserRequest>();
		String intentNumber = String.valueOf(intent.getIntent());
		int numberOfQuestions = 0;
		numberOfQuestions = intent.numberOfQuestions();
		for (int question = 0; question < numberOfQuestions; question++) {
			datum = new Datum();
			datum.setText(intent.getQuestion().get(question));
			userRequest = new UserRequest();
			userRequest.addData(datum);
			userRequests.add(userRequest);
		}
		// printJson(userRequests);
		// Generating server response json string.
		List<Message> messages = new ArrayList<Message>();
		Message message = new Message();
		message.setSpeech(intent.getResponse());
		message.setLang(ConfigManager.config.getProperty("language"));
		messages.add(message);
		Response response = new Response();
		response.setMessages(messages);
		List<Response> responses = new ArrayList<Response>();
		responses.add(response);
		ServerResponse serverResponse = new ServerResponse();
		serverResponse.setResponses(responses);
		serverResponse.setName(intentNumber);
		ConsolidatedSchema schema = new ConsolidatedSchema();
		schema.setServerResponse(serverResponse);
		schema.setUserRequests(userRequests);
		return schema;
	}

	public void buildAndWriteAgentAndInfo() {

		// Building agent.json and package.json files
		JsonWriter jsonWriter = new JsonWriter();
		Agent agent = new Agent();
		agent.setLanguage(ConfigManager.config.getProperty("language"));
		Info versionNumber = new Info();
		agent.getGoogleAssistant().setProject(ConfigManager.config.getProperty("agent.name"));
		jsonWriter.printToFile(agent, "agent.json", false);
		jsonWriter.printToFile(versionNumber, "package.json", false);
	}

	/*
	 * consumes high memory public void buildJson(Map<Integer, Intent> intentMap) {
	 * 
	 * JsonWriter jsonWriter = new JsonWriter(); ConsolidatedSchema schema = null;
	 * for (Integer entry : intentMap.keySet()) {
	 * 
	 * Intent tempIntent = intentMap.get(entry); schema = constructJson(tempIntent);
	 * // printJson(serverResponse); // Writing to file jsonWriter = new
	 * JsonWriter(); jsonWriter.printToFile(schema.getUserRequests(),
	 * tempIntent.getIntent() + "_usersays_en.json", true);
	 * jsonWriter.printToFile(schema.getServerResponse(), tempIntent.getIntent() +
	 * ".json", true);
	 * 
	 * } schema = buildAgentAndInfo(schema);
	 * jsonWriter.printToFile(schema.getAgent(), "agent.json", false);
	 * jsonWriter.printToFile(schema.getVersionNumber(), "package.json", false);
	 * 
	 * }
	 */

	void printJson(Object object) {

		System.out.println("Printing starts here...");
		ObjectMapper Obj = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		String jsonStr;
		try {
			jsonStr = Obj.writeValueAsString(object);
			System.out.println(jsonStr);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
		}

		System.out.println("Printing ends here...");
	}

}
