@API @ml
Feature: Ogrencilerin Toplu Bilgilerini Indirme
  Scenario: verilen idlerin bilgilerini excel olarak indirme.
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student","parents","bulk","download" path ve query parametrelerini olusturur
    #And Mustafa kullanicisi "campus/student/parents/bulk/download?ids=11&ids=22" icin get request gonderir ve donen responsei kaydeder
    And Mustafa kullanicisi "campus/student/parents/bulk/download?ids=11&ids=22" icin post request gonderir ve donen responsei kaydeder
    Then Mustafa kullanicisi status code 200 oldugunu dogrular
