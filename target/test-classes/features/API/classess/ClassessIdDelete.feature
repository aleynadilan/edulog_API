@class
Feature: Sınıf Denetleyicisi kaldır.

  Scenario Outline: /classess/{id} endpoint'ine gecerli authorization bilgileri ve silinmek istenen id'yi iceren bir DELETE
  body gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess", <id> path parametrelerini olusturur
    * Api kullanicisi delete request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | id |
      | 83 |


  Scenario Outline: /classess/{id} endpoint'ine gecersiz authorization bilgileri ve silinmek istenen id'yi iceren bir
  DELETE body gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized"
  oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "classess", <id> path parametrelerini olusturur
    * Api kullanicisi donen delete responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 83 |


  Scenario Outline: API uzerinden silinmek istenen Sınıf Denetleyicisi kaydinin silindigi, API uzerinden dogrulanmali.
  (/classess/{id} endpoint'ine GET request gönderilerek kaydın silindiği doğrulanabilir.)

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi response bodynin bos oldugunu dogrular

    Examples:
      | id |
      | 83 |