package com.flipkart.conference.room.reservation.system;

import java.util.List;

public class Building {

	private List<InfraManager> infraManagerList;

	public List<InfraManager> getInfraManagerList() {
		return infraManagerList;
	}

	public void setInfraManagerList(List<InfraManager> infraManagerList) {
		this.infraManagerList = infraManagerList;
	}
}
