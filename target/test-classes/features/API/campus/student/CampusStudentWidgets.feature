@API @ml
Feature: campus/student/check-students-familys
  Scenario: Students family
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "campus", "student","widgets" path parametrelerini olusturur
    And Mustafa kullanicisi "campus/student/widgets" icin get request gonderir ve donen response kaydeder
    Then Mustafa kullanicisi status code 200 oldugunu dogrular
    And Mustafa kullanicisi "campus/student/widgets" schema validation yapar
