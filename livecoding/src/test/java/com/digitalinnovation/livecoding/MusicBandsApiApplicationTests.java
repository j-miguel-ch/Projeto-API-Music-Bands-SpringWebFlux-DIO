package com.digitalinnovation.livecoding;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovation.livecoding.constants.MusicBandsConstant.*;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class MusicBandsApiApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Test
  public void getOneMusicBandById(){

    webTestClient.get().uri(MUSICBANDS_ENDPOINT_LOCAL.concat("/{id}"),"10")
      .exchange()
      .expectStatus().isOk()
      .expectBody();


  }

  @Test
  public void getOneMusicBandNotFound(){

    webTestClient.get().uri(MUSICBANDS_ENDPOINT_LOCAL.concat("/{id}"),"10")
      .exchange()
      .expectStatus().isNotFound();

  }

  @Test
  public void deleteMusicBand(){

    webTestClient.delete().uri(MUSICBANDS_ENDPOINT_LOCAL.concat("/{id}"),"1")
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isNotFound()
      .expectBody(Void.class);

  }

}


