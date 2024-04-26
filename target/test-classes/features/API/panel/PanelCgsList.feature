Feature: Panel Denetleyicisi Şirket Grubu Okul Listesini Alır.

  Scenario: /panel/cgs-list endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde dönen
  status code'in 200 oldugu ve response body'deki message bilgisinin "success", status bilgisinin de true oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "panel", "cgs-list" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * Api kullanicisi response bodydeki status bilgisinin true oldugunu dogrular


  Scenario: /panel/cgs-list endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "panel", "cgs-list" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular


  Scenario Outline: /panel/cgs-list endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
  id(x) olaninin response body'de donen bilgileri (isActive, createdAt, updatedAt, deletedAt, name) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "panel", "cgs-list" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icinde <dataIndex> indexe sahip olanin "<createdAt>", "<updatedAt>" ve "<name>" bilgilerini doğrular.

    Examples:
      | dataIndex | createdAt                | updatedAt                | name       |
      | 0         | 2023-10-02T10:48:29.000Z | 2023-10-02T10:48:29.000Z | HG Holding |



