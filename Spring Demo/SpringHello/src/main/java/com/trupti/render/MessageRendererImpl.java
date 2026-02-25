package com.trupti.render;

import com.trupti.provider.MessageProvider;

public class MessageRendererImpl implements MessageRenderer {
	private MessageProvider provider = null;
	
	@Override
	public void render() {
		if(provider == null) {
			throw new RuntimeException("No provide provided");
		}
		String msg = provider.getMessage();
		System.out.println(msg);
	}

	@Override
	public MessageProvider getProvider() {
		return provider;
	}

	@Override
	public void setProvider(MessageProvider provider) {
		this.provider = provider;
	}
}
