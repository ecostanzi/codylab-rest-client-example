package org.example.codylabrestclient;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.util.TypeUtils;
import org.springframework.web.client.RestClient;

@Slf4j
//@Component
public class StartupClass implements CommandLineRunner {


  @Override
  public void run(String... args) throws Exception {
    RestClient restClient = RestClient.create();

    List<UserDTO> users = restClient.get().uri("http://localhost:8080/users")
        .retrieve()
        .body(new ParameterizedTypeReference<List<UserDTO>>() {});

    for (UserDTO user : users) {
      log.info("Found user {}", user.getEmail());
    };

    UserDTO singleUser = restClient.get().uri("http://localhost:8080/users/{userId}", 1)
        .retrieve()
        .body(UserDTO.class);
  }
}
