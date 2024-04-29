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


  Scenario Outline: /meet/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin bulundugu bir GET
  request gönderildiginde dönen response body'deki datalar (id, isActive, created_at, updated_at, deletedAt, description,
  meetDate, status, isSibling) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "meet", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi response bodydeki data <id>, "<createdAt>", "<updatedAt>", "<meetDate>" ve "<status>" iceriklerini dogrular


    Examples:
      | id | id | createdAt                | updatedAt                | meetDate                 | status       |
      | 1  | 1  | 2024-04-01T10:46:42.573Z | 2024-04-01T10:46:42.573Z | 2024-04-22T21:00:00.000Z | wait_contact |