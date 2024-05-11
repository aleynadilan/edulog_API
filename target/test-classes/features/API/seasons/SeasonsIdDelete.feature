@API
Feature: Sezon Kontrolörü kaldır.

  Scenario Outline: /seasons/{id} endpoint'ine gecerli authorization bilgileri ve silinmek istenen id'yi iceren bir DELETE
  body gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "seasons", <id> path parametrelerini olusturur
    * Api kullanicisi delete request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | id |
      | 12 |


  Scenario Outline: /seasons/{id} endpoint'ine gecersiz authorization bilgileri ve silinmek istenen id'yi iceren bir
  DELETE body gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized"
  oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "seasons", <id> path parametrelerini olusturur
    * Api kullanicisi donen delete responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 12 |


  Scenario Outline: API uzerinden silinmek istenen Sezon Kontrolörü kaydinin silindigi, API uzerinden dogrulanmali.
  (/seasons/{id} endpoint'ine GET request gönderilerek kaydın silindiği doğrulanabilir.)

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "seasons", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi response bodynin bos oldugunu dogrular

    Examples:
      | id |
      | 12 |