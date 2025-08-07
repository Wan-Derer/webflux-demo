package com.example.webfluxdemo.config;

import java.util.Optional;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.server.ConnectionInformation;
import reactor.netty.http.server.logging.AccessLog;

@Configuration
public class ConfigWeb {

  @Bean
  public NettyServerCustomizer nettyServerCustomizer() {
    return httpServer -> httpServer
      .wiretap(true)
      .accessLog(true, args -> AccessLog.create(String.format(
          // Кастомный формат (пример)
          "Remote: %s | Method: %s | Path: %s | Status: %s",
          Optional.ofNullable(args.connectionInformation())
            .map(ConnectionInformation::remoteAddress)
            .map(Object::toString)
            .orElse("unknown"),
          args.method(),
          args.uri(),
          args.status()
        ))
      );
  }

}
