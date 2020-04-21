package org.bulk_upload.model;

import java.util.ArrayList;
import java.util.List;

public class ConsolidatedSchema {

	List<UserRequest> userRequests = new ArrayList<UserRequest>();
	ServerResponse serverResponse = new ServerResponse();

	public List<UserRequest> getUserRequests() {
		return userRequests;
	}

	public void setUserRequests(List<UserRequest> userRequests) {
		this.userRequests = userRequests;
	}

	public ServerResponse getServerResponse() {
		return serverResponse;
	}

	public void setServerResponse(ServerResponse serverResponse) {
		this.serverResponse = serverResponse;
	}

}
