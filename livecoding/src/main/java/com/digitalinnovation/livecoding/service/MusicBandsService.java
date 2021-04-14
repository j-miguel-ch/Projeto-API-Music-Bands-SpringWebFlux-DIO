package com.digitalinnovation.livecoding.service;

import com.digitalinnovation.livecoding.document.MusicBands;
import com.digitalinnovation.livecoding.repository.MusicBandsRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MusicBandsService {
  private final MusicBandsRepository musicBandsRepository;

  public MusicBandsService(MusicBandsRepository musicBandsRepository) {
    this.musicBandsRepository = musicBandsRepository;
  }

  public Flux<MusicBands> findAll(){

    return Flux.fromIterable(this.musicBandsRepository.findAll());
  }

  public  Mono<MusicBands> findByIdMusicBand(String id){

    return  Mono.justOrEmpty(this.musicBandsRepository.findById(id));
  }


  public Mono<MusicBands> save(MusicBands heroes){
    return  Mono.justOrEmpty(this.musicBandsRepository.save(heroes));
  }


  public Mono<Boolean> deletebyIDMusicBand(String id) {
    musicBandsRepository.deleteById(id);
    return Mono.just(true);

  }

}
