Feature: Ogrencilerin Toplu Bilgilerini Indirme
  Scenario: verilen idlerin bilgilerini excel olarak indirme.
    Given Mustafa kullanicisi "student" token ile base urli olusturur
    And Mustafa kullanicisi "campus", "student","bulk","download" path ve query parametrelerini olusturur
    And Mustafa kullanicisi download body olusturur
    And Mustafa kullanicisi get request gonderir ve donen responsei kaydeder
    Then Mustafa kullanicisi status code 200 oldugunu dogrular
