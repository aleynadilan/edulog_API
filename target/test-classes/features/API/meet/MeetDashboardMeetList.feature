@API
Feature: Meet Denetleyici kontrol paneli Meet Listesi.

  Scenario: /meet/dashboard-meet-list endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde dönen
  status code'in 200 oldugu ve response body'deki message bilgisinin "success", status bilgisinin de true oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "meet", "dashboard-meet-list" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * Api kullanicisi response bodydeki status bilgisinin true oldugunu dogrular
    * Api kullanicisi meet dashboard meet list endpointinden donen response bodynin schema validation dogrulamasini yapar


  Scenario: /meet/dashboard-meet-list endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "meet", "dashboard-meet-list" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular


  Scenario Outline: /meet/dashboard-meet-list endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
  index(x) olaninin response body'de donen bilgileri (type, name, date) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "meet", "dashboard-meet-list" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icinde <dataIndex> indexe sahip olan "<type>", "<name>" bilgileri dogrular.

    Examples:
      | dataIndex | type     | name                            |
      | 1         | GÖRÜŞME  | Ergin KOÇAK                     |
      | 2         | ETKİNLİK | Adana Portakal Çiçeği Festivali |
