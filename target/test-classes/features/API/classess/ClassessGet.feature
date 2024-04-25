Feature: Sınıf Denetleyicisi Tümünü bul.

  Scenario Outline: /classess endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 200 oldugu ve id(x) olaninin response body'de donen bilgileri
  (year, name) dogrulanmali

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanıcısi response body icinde <dataIndex> indexe sahip olan "<createdAt>", "<updatedAt>" ve "<name>" bilgilerini doğrular.

    Examples:
      | dataIndex | createdAt                | updatedAt                | name |
      | 0         | 2023-12-23T06:23:56.124Z | 2023-12-23T06:23:56.124Z | 12   |


  Scenario: /classess endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "classess" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
