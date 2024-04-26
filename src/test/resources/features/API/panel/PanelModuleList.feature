Feature: Panel Denetleyicisi tüm Modüller.

  Scenario: /panel/module-list endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde dönen
  status code'in 200 oldugu ve response body'deki message bilgisinin "success", status bilgisinin de true oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "panel", "module-list" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * Api kullanicisi response bodydeki status bilgisinin true oldugunu dogrular


  Scenario: /panel/module-list endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "panel", "module-list" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular


  Scenario Outline: /panel/module-list endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
  id(x) olaninin response body'de donen bilgileri (isActive, createdAt, updatedAt, deletedAt, name) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "panel", "module-list" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icinde <dataIndex> indexe sahip olanin "<name>" bilgisini doğrular.

    Examples:
      | dataIndex | name                |
      | 0         | Akademik Ders Planı |
