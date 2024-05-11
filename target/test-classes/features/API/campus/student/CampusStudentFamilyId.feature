@ml
Feature: campus/student
  Scenario: Campus Student Controller delete Family
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "campus", "student","family" ve :familyId path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/campus/student/family/:familyId" icin delete request gonderir ve donen response kaydeder
    Then Mustafa kullanicisi status code 200 oldugunu dogrular
