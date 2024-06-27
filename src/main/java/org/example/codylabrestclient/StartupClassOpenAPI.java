package org.example.codylabrestclient;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.example.codylabrestclient.client.UsersApi;
import org.example.codylabrestclient.model.UserClientDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StartupClassOpenAPI implements CommandLineRunner {

  private final UsersApi usersApi;
  private final PippoService pippoService;

  public StartupClassOpenAPI(UsersApi usersApi,
      PippoService pippoService) {
    this.usersApi = usersApi;
    this.pippoService = pippoService;
  }

  @Override
  public void run(String... args) throws Exception {

    List<UserClientDTO> users = usersApi.getAllUsers();

    for (UserClientDTO user : users) {
      log.info("Found user {}", user.getEmail());
    };

  }
}
