package com.game.caro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import jakarta.annotation.PreDestroy;

@Configuration
public class SocketConfiguration {

	private SocketIOServer server;

	@Bean
	public SocketIOServer socketIOServer() {
		com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
		config.setHostname("localhost");
		config.setPort(8090);
        config.setOrigin("*");
		server = new SocketIOServer(config);
		server.start();
		return server;
	}

	@PreDestroy
	public void stopSocketIOServer() {
		this.server.stop();
	}

}