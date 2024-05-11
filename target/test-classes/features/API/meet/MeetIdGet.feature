@API
Feature: Tek Toplantı Verileri.

  Scenario Outline: /meet/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 200 ve response body'deki message bilgisinin "success",
  status bilgisinin de true oldugu dogrulanmali..

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "meet", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * Api kullanicisi response bodydeki status bilgisinin true oldugunu dogrular
    * Api kullanicisi meet id endpointinden donen response bodynin schema validation dogrulamasini yapar

    Examples:
      | id |
      | 1  |


  Scenario Outline: /meet/{id} endpoint'ine gecersiz authorization bilgileri ve id verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "meet", <id> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 1  |
