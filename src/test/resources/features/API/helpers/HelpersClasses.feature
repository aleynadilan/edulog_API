Feature: İlgili okulun sınıfları.

  Scenario Outline: /helpers/classes/{seasonId} endpoint'ine gecerli authorization bilgileri ve seasonId verisinin
  bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "classes" ve "<seasonId>" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | seasonId |
      | 1        |


  Scenario Outline: /helpers/classes/{seasonId} endpoint'ine gecerli authorization bilgileri ve sistemde bulunmayan
  seasonId verisinin bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu ve response body'deki
  array'in bos oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "classes" ve "<seasonId>" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response body'deki arrayin bos oldugunu dogrular

    Examples:
      | seasonId |
      | 144444   |


  Scenario Outline: /helpers/classes/{seasonId} endpoint'ine gecersiz authorization bilgileri ve seasonId verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "classes" ve "<seasonId>" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | seasonId |
      | 1        |


  Scenario Outline: /helpers/classes/{seasonId} endpoint'ine gecerli authorization bilgileri ve seasonId verisinin
  bulundugu bir GET request gönderildiginde id(x) olaninin response body'de donen bilgileri (isActive, createdAt,
  updatedAt, deletedAt, name, level_key) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "classes" ve "<seasonId>" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response bodyde ki <dataIndex> indexe sahip olanin "<createdAt>", "<updatedAt>", "<name>" ve "<level_key>" bilgilerini doğrular.

    Examples:
      | seasonId | dataIndex | createdAt                | updatedAt                | name | level_key |
      | 1        | 1         | 2023-12-23T06:23:56.124Z | 2023-12-23T06:23:56.124Z | 1    | 1         |
