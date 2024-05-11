@API
Feature: Ogrencileri toplu guncelleme islemi

  @TC01
  Scenario: /campus/employee/bulk/update endpoint'ine gecerli authorization bilgileri ile
  POST request gonderir. Donen status code'un 200 oldugu dogrulanir.

    When Api kullanicisi "campus", "employee", "bulk" ve "update" path parametrelerini olusturur
    Given Api kullanicisi "employee" token ile base urli olusturur
    Then Api kullanicisi responce'a gonderecegi body'i olusturur
    Then Api kullanicisi post request gonderir ve donen responsei kaydeder
    Then Api kullanicisi status codeun 201 oldugunu dogrular

  @TC02
  Scenario: /campus/employee/bulk/update endpoint'ine gecersiz authorization bilgileri ile
  POST request gönderir. Donen status code'un 401 oldugu ve body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrular.

    Given Api kullanicisi "invalid" token ile base urli olusturur
    When Api kullanicisi "campus", "employee", "bulk" ve "update" path parametrelerini olusturur
    Then Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular