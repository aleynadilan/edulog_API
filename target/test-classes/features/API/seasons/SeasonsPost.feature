Feature: Sezon Kontrolörü oluştur.

  Scenario: /seasons endpoint'ine gecerli authorization bilgileri ve gerekli verileri (isActive, name) iceren bir POST body
  gönderildiginde dönen status code'in 201 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "seasons" path parametrelerini olusturur
    * Api kullanicisi seasons endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * Api kullanicisi post request gonderir ve seasons endpointinden donen responsei kaydeder
    * Api kullanicisi status codeun 201 oldugunu dogrular
    * Api kullanicisi seasons post endpointinden donen response bodynin schema validation dogrulamasini yapar



  Scenario: /seasons endpoint'ine gecersiz authorization bilgileri ve gerekli verileri (isActive, name) iceren bir POST body
  gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "seasons" path parametrelerini olusturur
    * Api kullanicisi seasons endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * Api kullanicisi post request gonderir ve seasons endpointinden donen responsei kaydeder
    * Api kullanicisi status codeun 401 oldugunu dogrular
    * Api kullanicisi response bodydeki errorData bilgisinin "Unauthorized" oldugunu dogrular


  Scenario Outline: API uzerinden olusturulmak istenen yeni Sezon Kontrolörü kaydinin olustugu API uzerinden dogrulanmali.
  (Response bodyde dönen id ile /seasons/{id} endpoint'ine GET request gönderilerek kayıt oluşturulduğu doğrulanabilir.)

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "seasons", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi response body icindeki name bilgisinin "<name>" ve id bilgisininde <responseId> oldugunu dogrular

    Examples:
      | id | name   | responseId |
      | 11 | Aleyna | 11         |