Feature: Kimliğe göre denemeyi al.

  Scenario Outline: /experiment/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "experiment", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * Api kullanicisi response bodydeki status bilgisinin true oldugunu dogrular

    Examples:
      | id |
      | 1  |


  Scenario Outline: /experiment/{id} endpoint'ine gecerli authorization bilgileri ve sistemde bulunmayan
  id verisinin bulundugu bir GET request gönderildiginde dönen status code'in 400 oldugu ve response body'deki
  errorData bilgisinin null oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "experiment", <id> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '400' ve reason phrase bilgisinin Bad Request oldugunu dogrular

    Examples:
      | id   |
      | 1444 |


  Scenario Outline: /experiment/{id} endpoint'ine gecersiz authorization bilgileri ve id verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "experiment", <id> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 1  |


  Scenario Outline: /experiment/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin bulundugu bir GET
  request gönderildiginde dönen response body'deki datalar (id, isActive, created_at, updated_at, deletedAt, name,
  key, type, capacity, image) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "experiment", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi response bodydeki data <id>, "<createdAt>", "<updatedAt>", "<name>", "<key>", "<type>", <capacity> ve "<image>" iceriklerini dogrular


    Examples:
      | id | id | createdAt                | updatedAt                | name                             | key                     | type  | capacity | image                                    |
      | 1  | 1  | 2024-03-14T10:01:17.601Z | 2024-03-14T10:01:17.601Z | 12.Sınıf Fizik Elektrik 2 Deneyi | psychic_8_electricity_2 | class | 15       | https://i.ibb.co/Z8Hhqc9/Group-41683.png |