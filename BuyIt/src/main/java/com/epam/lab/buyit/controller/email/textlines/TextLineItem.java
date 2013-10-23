package com.epam.lab.buyit.controller.email.textlines;

public interface TextLineItem {
	void setTextLineContainer(TextLineConteiner conteiner);

	String getId();

	String execute();
}
