package com.epam.lab.buyit.controller.email.textlines.impl;

import com.epam.lab.buyit.controller.email.textlines.TextLineConteiner;
import com.epam.lab.buyit.controller.email.textlines.TextLineItem;

public class BuyerGreatingLine implements TextLineItem{
	TextLineConteiner textConteiner = null;
	@Override
	public void setTextLineContainer(TextLineConteiner conteiner) {
		textConteiner = conteiner;
		
	}

	@Override
	public String getId() {
		return "buyerGreatingLine";
	}

	@Override
	public String execute() {
		return textConteiner.getBuyerGreatingLine();
	}
	
}
