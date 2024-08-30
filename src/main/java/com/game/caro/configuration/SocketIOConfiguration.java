package com.game.caro.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

import jakarta.annotation.PreDestroy;

@Configuration
public class SocketIOConfiguration { 

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