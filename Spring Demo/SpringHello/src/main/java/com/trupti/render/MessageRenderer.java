package com.trupti.render;

import com.trupti.provider.MessageProvider;

public interface MessageRenderer {

	void render();

	MessageProvider getProvider();

	void setProvider(MessageProvider provider);

}