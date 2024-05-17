@helpers
Feature: Seçilen Sınıfın Şube/Branşları.

  Scenario Outline: /helpers/branches/{classId} endpoint'ine gecerli authorization bilgileri ve classId verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "branches" ve <classId> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi helpers branches endpointinden donen response bodynin schema validation dogrulamasini yapar

    Examples:
      | classId |
      | 3       |


  Scenario Outline: /helpers/branches/{classId} endpoint'ine gecerli authorization bilgileri ve sistemde bulunmayan
  classId verisinin bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu ve response body'deki
  array'in bos oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "branches" ve <classId> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response body'deki arrayin bos oldugunu dogrular

    Examples:
      | classId |
      | 35      |


  Scenario Outline: /helpers/branches/{classId} endpoint'ine gecersiz authorization bilgileri ve classId verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "branches" ve <classId> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | classId |
      | 3       |


  Scenario Outline: /helpers/branches/{classId} endpoint'ine gecerli authorization bilgileri ve classId verisinin bulundugu
  bir GET request gönderildiginde id(x) olaninin response body'de donen bilgileri (isActive, createdAt, updatedAt,
  deletedAt, name, cityId) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "branches" ve <classId> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olanin "<createdAt>", "<updatedAt>" ve "<name>" bilgilerini doğrular.

    Examples:
      | classId | dataIndex | createdAt                | updatedAt                | name |
      | 3       | 0         | 2023-10-02T11:16:39.000Z | 2023-10-02T11:16:39.000Z | B    |