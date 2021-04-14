package com.digitalinnovation.livecoding.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovation.livecoding.constants.MusicBandsConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovation.livecoding.constants.MusicBandsConstant.REGION_DYNAMO;

public class MusicBandsData {
  public static void main(String[] args) throws Exception {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
      .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
      .build();
    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("MusicBands_Api_Table");

    Item hero = new Item()
      .withPrimaryKey("id", "1")
      .withString("name", "Iron Maiden")
      .withString("musicalGenre", "Heavy Metal")
      .withNumber("disks", 29);

    Item hero2 = new Item()
      .withPrimaryKey("id", "2")
      .withString("name", "AC/DC")
      .withString("musicalGenre", "Hard Rock")
      .withNumber("disks", 20);

    Item hero3 = new Item()
      .withPrimaryKey("id", "4")
      .withString("name", "IRA!")
      .withString("musicalGenre", "Rock Nacional")
      .withNumber("disks", 16);

    PutItemOutcome outcome1 = table.putItem(hero);
    PutItemOutcome outcome2 = table.putItem(hero2);
    PutItemOutcome outcome3 = table.putItem(hero3);

  }

}

