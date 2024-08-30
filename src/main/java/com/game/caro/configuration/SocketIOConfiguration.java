package com.game.caro.configuration;

import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.game.caro.util.JsonUtils;

import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoServerOptions;
import io.socket.socketio.server.SocketIoServer;
import io.socket.socketio.server.SocketIoSocket;

@Configuration
public class SocketIOConfiguration {

   @Bean
   EngineIoServer engineIoServer() {
       var opt = EngineIoServerOptions.newFromDefault();
       opt.setCorsHandlingDisabled(true);
       var eioServer = new EngineIoServer(opt);
       return eioServer;
   }

   @Bean
   SocketIoServer socketIoServer(EngineIoServer eioServer) {
       var sioServer = new SocketIoServer(eioServer);

       var caro = sioServer.namespace("/caro");

       caro.on("connection", args -> {
           var socket = (SocketIoSocket) args[0];

           System.out.println("Client " + socket.getId() + " (" + socket.getInitialHeaders().get("remote_addr") + ") has connected.");
           socket.on("message", args1 -> {

               JSONObject o = (JSONObject) args1[0];

               var messageVo = JsonUtils.toPojoObj(o, MessageVo.class);

               System.out.println("[Client " + socket.getId() + "] " + messageVo);
               socket.send("hello", JsonUtils.toJsonObj(new MessageVo("Server", "Heo khô đi những kỉ niệm xưa kia")));
           });
       });

       return sioServer;
   }

   record MessageVo(String author, String msg) {}

}