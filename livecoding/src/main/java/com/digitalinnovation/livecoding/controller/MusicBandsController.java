package com.digitalinnovation.livecoding.controller;

import com.digitalinnovation.livecoding.document.MusicBands;
import com.digitalinnovation.livecoding.repository.MusicBandsRepository;
import com.digitalinnovation.livecoding.service.MusicBandsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static com.digitalinnovation.livecoding.constants.MusicBandsConstant.MUSICBANDS_ENDPOINT_LOCAL;

@RestController
@Slf4j

public class MusicBandsController {
  MusicBandsService musicBandsService;

  MusicBandsRepository musicBandsRepository;

  private static final org.slf4j.Logger log =
    org.slf4j.LoggerFactory.getLogger(MusicBandsController.class);

  public MusicBandsController(MusicBandsService musicBandsService, MusicBandsRepository musicBandsRepository) {
    this.musicBandsService = musicBandsService;
    this.musicBandsRepository = musicBandsRepository;
  }

  @GetMapping(MUSICBANDS_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.OK)
  public Flux<MusicBands> getAllItems() {
    log.info("requesting the list off all music bands");
    return musicBandsService.findAll();

  }


  @GetMapping(MUSICBANDS_ENDPOINT_LOCAL + "/{id}")
  public Mono<ResponseEntity<MusicBands>> findByIdHero(@PathVariable String id) {
    log.info("Requesting the hero with id {}", id);
    return musicBandsService.findByIdMusicBand(id)
      .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
      .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping(MUSICBANDS_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<MusicBands> createHero(@RequestBody MusicBands musicBands) {
    log.info("A new Hero was Created");
    return musicBandsService.save(musicBands);

  }

  @DeleteMapping(MUSICBANDS_ENDPOINT_LOCAL + "/{id}")
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
    musicBandsService.deletebyIDMusicBand(id);
    log.info("Deleting the hero with id {}", id);
    return Mono.just(HttpStatus.NOT_FOUND);
  }
}
