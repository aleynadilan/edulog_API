Feature: Ogrencilerin Toplu Bilgilerini Indirme

  Scenario Outline: /campus/employee/bulk/dowload endpoint'ine gecerli authorization bilgileri ile
  GET request gonderir. Donen status code'un 200 oldugu dogrulanir.
    Given Api kullanicisi "employee" token ile base urli olusturur
    When Api kullanicisi "campus", "employee", "bulk" ve "download" path parametrelerini olusturur
    When Api kullanicisi <ids> ve <ids> query parametrelerini ve body'i olusturur
    #Then Api kullanicisi GET request gonderir ve donen responsei kaydeder
    Then Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | ids | ids |
      | 34  | 37  |
