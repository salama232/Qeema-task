package com.qeema.task.Config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;


@Configuration
public class WebSocketSecurityConfig
      extends AbstractSecurityWebSocketMessageBrokerConfigurer {
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages.anyMessage().permitAll() ;
//        .nullDestMatcher().authenticated()
//        .simpSubscribeDestMatchers("/user/queue/errors").permitAll() 
//        .simpDestMatchers("/app/**").permitAll()
//        .simpSubscribeDestMatchers("/api/**", "/topic/friends/*").permitAll()
//         .simpTypeMatchers(SimpMessageType.CONNECT,SimpMessageType.MESSAGE, SimpMessageType.SUBSCRIBE).permitAll() ;
         //.anyMessage().denyAll();
    }
  //Disable CSRF within WebSockets
    @Override
    protected boolean sameOriginDisabled() {
        return true;
    } 

}
