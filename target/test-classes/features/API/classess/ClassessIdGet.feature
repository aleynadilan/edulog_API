Feature: Sınıf Denetleyicisi Birini Bul.

  Scenario Outline: /classess/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | id |
      | 76 |
      | 24 |


  Scenario Outline: /classess/{id} endpoint'ine gecerli authorization bilgileri ve sistemde bulunmayan
  id verisinin bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu ve response body'nin
  bos oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodynin bos oldugunu dogrular

    Examples:
      | id   |
      | 4587 |


  Scenario Outline: /classess/{id} endpoint'ine gecersiz authorization bilgileri ve id verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "classess", <id> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 76 |


  Scenario Outline: /classess/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin bulundugu bir GET
  request gönderildiginde dönen response body'deki datalar (id, isActive, created_at, updated_at, deletedAt, name, level_key)
  dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi response bodydeki data <id>, "<createdAt>", "<updatedAt>", "<name>" iceriklerini dogrular


    Examples:
      | id | id | createdAt                | updatedAt                | name   |
      | 76 | 76 | 2024-04-24T16:48:48.212Z | 2024-04-24T16:48:48.212Z | Aleyna |
      | 24 | 24 | 2023-12-23T06:23:56.124Z | 2023-12-23T06:23:56.124Z | 9      |