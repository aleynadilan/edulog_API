Feature: Sezon Kontrolörü Birini Bul.
  @API
  Scenario Outline: /seasons/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "seasons", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi seasons id endpointinden donen response bodynin schema validation dogrulamasini yapar

    Examples:
      | id |
      | 11 |


  Scenario Outline: /seasons/{id} endpoint'ine gecerli authorization bilgileri ve sistemde bulunmayan
  id verisinin bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu ve response body'nin
  bos oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "seasons", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodynin bos oldugunu dogrular

    Examples:
      | id  |
      | 114 |


  Scenario Outline: /seasons/{id} endpoint'ine gecersiz authorization bilgileri ve id verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "seasons", <id> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 11 |


  Scenario Outline: /seasons/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin bulundugu bir GET
  request gönderildiginde dönen response body'deki datalar (id, isActive, created_at, updated_at, deletedAt, name,
  seasonStartDate, seasonEndDate) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "seasons", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi response bodydeki data <id>, "<createdAt>", "<updatedAt>", "<name>", "<seasonStartDate>" ve "<seasonEndDate>" iceriklerini dogrular


    Examples:
      | id | id | createdAt                | updatedAt                | name   | seasonStartDate          | seasonEndDate            |
      | 11 | 11 | 2024-04-25T14:47:00.192Z | 2024-04-25T14:47:00.192Z | Aleyna | 2024-09-17T00:00:00.000Z | 2025-09-17T00:00:00.000Z |