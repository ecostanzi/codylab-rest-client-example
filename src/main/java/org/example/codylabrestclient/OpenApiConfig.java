package org.example.codylabrestclient;

import org.example.codylabrestclient.client.UsersApi;
import org.example.codylabrestclient.config.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public UsersApi usersApi(ApplicationProperties applicationProperties) {
    ApiClient apiClient = new ApiClient();
    apiClient.setBasePath(applicationProperties.getBasePath());
    return new UsersApi(apiClient);
  }

  @Bean
  public PippoService pippoService() {
    return new PippoService();
  }

}
