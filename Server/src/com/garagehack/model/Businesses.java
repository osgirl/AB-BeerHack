package com.garagehack.model;

import com.garagehack.response.Place;

import java.util.*;

/**
 * @author Maxim Galushka
 */
public class Businesses {

  private Business[] businesses;

  @Override
  public String toString() {
    return "Businesses{" +
      "businesses=" + Arrays.toString(businesses) +
      '}';
  }

  public Business[] getBusinesses() {
    return businesses;
  }

  public void setBusinesses(Business[] businesses) {
    this.businesses = businesses;
  }

  public Businesses() {
  }

  public Businesses(Business[] businesses) {
    this.businesses = businesses;
  }

  public List<Place> places(String type) {
    if (businesses == null || businesses.length == 0) {
      return Collections.emptyList();
    }

    List<Place> places = new ArrayList<>();
    for (Business business : businesses) {
      StringJoiner addressJoiner = new StringJoiner("\n");
      for (String addressBit : business.getLocation().getAddress()) {
        addressJoiner.add(addressBit);
      }

      try {
        places.add(
          new Place(
            business.getName(),
            business.getCategories()[0][0],
            addressJoiner.toString(),
            business.getPhone(),
            business.getLocation().getCoordinate().getLatitude(),
            business.getLocation().getCoordinate().getLongitude(),
            type
          )
        );
      }catch(Exception e){

      }
    }

    return places;
  }
}
