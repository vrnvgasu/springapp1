package ru.springcours;

import org.springframework.stereotype.Component;

// Если не задавать названия в Component, то бин получит id "rockMusic"
//@Component("musicBean")
public class RockMusic implements Music {
//  @Override
  public String getSong() {
    return "Wind cries Marry";
  }
}
