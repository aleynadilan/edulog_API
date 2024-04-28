Feature: Ogrencilerin Toplu Bilgilerini Indirme
  Scenario: verilen idlerin bilgilerini excel olarak indirme.
    Given Mustafa kullanicisi "student" token ile base urli olusturur
    And Mustafa kullanicisi "campus", "student","parents-widgets" path ve query parametrelerini olusturur
    And Mustafa kullanicisi "campus/student/parents-widgets" icin get request gonderir ve donen responsei kaydeder
    Then Mustafa kullanicisi status code 200 oldugunu dogrular
    And Mustafa kullanicisi "campus/student/widgets" icin schema validation yapar