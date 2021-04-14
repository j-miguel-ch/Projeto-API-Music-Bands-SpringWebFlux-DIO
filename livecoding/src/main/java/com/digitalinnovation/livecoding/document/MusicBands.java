package com.digitalinnovation.livecoding.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@DynamoDBTable(tableName ="MusicBands_Api_Table")


public class MusicBands {
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMusicalGenre() {
    return musicalGenre;
  }

  public void setMusicalGenre(String musicalGenre) {
    this.musicalGenre = musicalGenre;
  }

  public int getDisks() {
    return disks;
  }

  public void setDisks(int disks) {
    this.disks = disks;
  }

  @Id
  @DynamoDBHashKey (attributeName = "id")
  private String id;

  @DynamoDBAttribute (attributeName = "name")
  private String name;

  @DynamoDBAttribute (attributeName = "musicalGenre")
  private String musicalGenre;

  @DynamoDBAttribute (attributeName = "disks")
  private int disks;


  public MusicBands(String id, String name, String universe, int films) {
    this.id = id;
    this.name = name;
    this.musicalGenre = musicalGenre;
    this.disks = disks;
  }

}

