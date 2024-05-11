@API
Feature: Stage Controller get List
  Scenario: Stage Controller get List
    Given Mustafa kullanicisi "student" token ile base urli olusturur
    And Mustafa kullanicisi base_url-school-stage-list icin path parametrelerini olusturur
    And Mustafa kullanicisi base_url-school-stage-list icin get request yapar
    And Mustafa kullanicisi status code 200 oldugunu assert eder


