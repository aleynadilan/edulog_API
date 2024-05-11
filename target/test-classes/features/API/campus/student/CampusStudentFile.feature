@API @ml
Feature: campus/student
  Scenario: Campus Student Controller delete File
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "campus", "student","file" path parametrelerini olusturur
    And Mustafa kullanicisi "/campus/student/file" icin delete request gonderir ve donen response kaydeder
    Then Mustafa kullanicisi status code 200 oldugunu dogrular
