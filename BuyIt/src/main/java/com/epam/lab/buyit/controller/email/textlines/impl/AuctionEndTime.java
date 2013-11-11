package com.epam.lab.buyit.controller.email.textlines.impl;

import com.epam.lab.buyit.controller.email.textlines.TextLineConteiner;
import com.epam.lab.buyit.controller.email.textlines.TextLineItem;

public class AuctionEndTime implements TextLineItem{
	TextLineConteiner textConteiner = null;
	@Override
	public void setTextLineContainer(TextLineConteiner conteiner) {
		textConteiner = conteiner;
	}

	@Override
	public String getId() {
		return "endTime";
	}

	@Override
	public String execute() {
		return textConteiner.getAuctionEndTime().substring(0, textConteiner.getAuctionEndTime().length()-5);
	}

}
