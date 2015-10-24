package com.tgbotlibrary.prove;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.tgbotlibrary.interactions.Interaction;
import com.tgbotlibrary.interactions.InteractionAbstract;
import com.tgbotlibrary.interactions.InteractionFactory;
import com.tgbotlibrary.response.Message;

public class HelloWorldInteractionFactory implements InteractionFactory {

	private InteractionAbstract interaction;
	
	@Override
	public Interaction createInteraction(Message message) {
		interaction.setMessage(message);
		return interaction;
		//return new HelloWorldInteraction(message);
	}

	public InteractionAbstract getInteraction() {
		return interaction;
	}

	@Required
	public void setInteraction(InteractionAbstract interaction) {
		this.interaction = interaction;
	}

}
