package com.digitalinnovation.livecoding.repository;

import com.digitalinnovation.livecoding.document.MusicBands;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MusicBandsRepository extends CrudRepository<MusicBands, String>{
}
