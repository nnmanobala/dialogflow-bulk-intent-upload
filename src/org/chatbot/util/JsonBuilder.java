package org.chatbot.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.chatbot.model.Agent;
import org.chatbot.model.Datum;
import org.chatbot.model.Info;
import org.chatbot.model.Intent;
import org.chatbot.model.Message;
import org.chatbot.model.Response;
import org.chatbot.model.ServerResponse;
import org.chatbot.model.UserRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonBuilder {

	private Logger logger = LogManager.getLogger(JsonBuilder.class);

	public void buildJson(Map<Integer, Intent> intentMap) {

		for (Integer entry : intentMap.keySet()) {
			Datum datum;
			UserRequest userRequest = null;
			List<UserRequest> userRequests = new ArrayList<UserRequest>();
			Intent tempIntent = intentMap.get(entry);
			String intentNumber = String.valueOf(tempIntent.getIntent());
			int numberOfQuestions = 0;
			numberOfQuestions = tempIntent.numberOfQuestions();
			for (int question = 0; question < numberOfQuestions; question++) {
				datum = new Datum();
				datum.setText(tempIntent.getQuestion().get(question));
				userRequest = new UserRequest();
				userRequest.addData(datum);
				userRequests.add(userRequest);
			}
//			printJson(userRequests);
			// Generating server response json string.
			List<Message> messages = new ArrayList<Message>();
			Message message = new Message();
			message.setSpeech(tempIntent.getResponse());
			messages.add(message);
			Response response = new Response();
			response.setMessages(messages);
			List<Response> responses = new ArrayList<Response>();
			responses.add(response);
			ServerResponse serverResponse = new ServerResponse();
			serverResponse.setResponses(responses);
			serverResponse.setName(intentNumber);
//			printJson(serverResponse);
			// Generating Agent.json file
			Agent agent = new Agent();
			Info versionNumber = new Info();
			agent.getGoogleAssistant().setProject(ConfigManager.config.getProperty("agent.name"));
			// Writing to file
			JsonWriter jsonWriter = new JsonWriter();
			jsonWriter.printToFile(userRequests, intentNumber + "_usersays_en.json", true);
			jsonWriter.printToFile(serverResponse, intentNumber + ".json", true);
			jsonWriter.printToFile(agent, "agent.json", false);
			jsonWriter.printToFile(versionNumber, "package.json", false);

		}

	}

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
