@helpers
Feature: Yardımcı Denetleyicinin Okul Fiyatlarını Alma Öğrencisi.

  Scenario Outline: /helpers/school-pricings-student/{student} endpoint'ine gecerli authorization bilgileri ve student
  verisinin bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "school-pricings-student" ve <student> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | student |
      | 14      |


  Scenario Outline: /helpers/school-pricings-student/{student} endpoint'ine gecersiz authorization bilgileri ve student
  verisinin bulundugu bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "school-pricings-student" ve <student> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | student |
      | 14      |