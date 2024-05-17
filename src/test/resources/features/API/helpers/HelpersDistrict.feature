@helpers
Feature: Yardımcılar Kontrolörünün Bölgeyi alması.

  Scenario Outline: /helpers/district/{countyId} endpoint'ine gecerli authorization bilgileri ve countyId verisinin
  bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "district" ve <countyId> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | countyId |
      | 1105     |


  Scenario Outline: /helpers/district/{countyId} endpoint'ine gecerli authorization bilgileri ve sistemde bulunmayan
  cityId verisinin bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu ve response body'deki
  array'in bos oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "district" ve <countyId> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response body'deki arrayin bos oldugunu dogrular

    Examples:
      | countyId |
      | 55566    |


  Scenario Outline: /helpers/county/{cityId} endpoint'ine gecersiz authorization bilgileri ve cityId verisinin bulundugu
  bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "district" ve <countyId> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | countyId |
      | 1105     |


  Scenario Outline: /helpers/county/{cityId} endpoint'ine gecerli authorization bilgileri ve cityId verisinin bulundugu
  bir GET request gönderildiginde id(x) olaninin response body'de donen bilgileri (isActive, createdAt, updatedAt,
  deletedAt, name, cityId) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "district" ve <countyId> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olan "<createdAt>", "<updatedAt>", "<name>" ve <countyId> bilgilerini doğrular.

    Examples:
      | countyId | dataIndex | createdAt                | updatedAt                | name         | countyId |
      | 1105     | 0         | 2023-12-28T14:42:14.506Z | 2023-12-28T14:42:14.506Z | GÖZTEPE KÖYÜ | 1105     |
