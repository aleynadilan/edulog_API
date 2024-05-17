@ml
Feature: Ogrencilerin Toplu Bilgilerini Indirme
  Scenario: verilen idlerin bilgilerini excel olarak indirme.
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student","bulk","download" path ve query parametrelerini olusturur
    And Mustafa kullanicisi download body olusturur
    And Mustafa kullanicisi get request gonderir ve donen responsei kaydeder
    Then Mustafa kullanicisi status code 200 oldugunu dogrular
