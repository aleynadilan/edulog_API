Feature: Sınıf Denetleyicisi oluştur.

  Scenario: /classess endpoint'ine gecerli authorization bilgileri ve gerekli verileri (isActive,
  company_id, group_id, school_id, name) iceren bir POST body gönderildiginde dönen status code'in 201
  oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess" path parametrelerini olusturur
    * Api kullanicisi classess endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * Api kullanicisi post request gonderir ve classess endpointinden donen responsei kaydeder
    * Api kullanicisi status codeun 201 oldugunu dogrular
    * Api kullanicisi response bodydeki bilgileri dogrular
    * Api kullanicisi classess post endpointinden donen response bodynin schema validation dogrulamasini yapar


  Scenario: /classess endpoint'ine gecersiz authorization bilgileri ve gerekli verileri (isActive,
  company_id, group_id, school_id, name) iceren bir POST body gönderildiginde dönen status code'in 401 ve
  response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "classess" path parametrelerini olusturur
    * Api kullanicisi classess endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * Api kullanicisi post request gonderir ve classess endpointinden donen responsei kaydeder
    * Api kullanicisi status codeun 401 oldugunu dogrular
    * Api kullanicisi response bodydeki errorData bilgisinin "Unauthorized" oldugunu dogrular


  Scenario Outline: API uzerinden olusturulmak istenen yeni Sınıf Denetleyicisi kaydinin olustugu API uzerinden dogrulanmali.
  (Response bodyde dönen id ile /classess/{id} endpoint'ine GET request gönderilerek kayıt oluşturulduğu doğrulanabilir.)

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess", <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi response body icindeki name bilgisinin "<name>" ve id bilgisininde <responseId> oldugunu dogrular

    Examples:
      | id | name   | responseId |
      | 76 | Aleyna | 76         |


  Scenario: /classess post endpoint'ine gecerli authorization bilgileri ve gerekli verileri (isActive,
  company_id, group_id, school_id, name) iceren bir POST body gönderildiginde dönen status code'in 201
  oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "classess" path parametrelerini olusturur
    * Api kullanicisi classess endpointine gondermek icin gerekli verileri iceren bir POST request olusturur
    * Api kullanicisi POST request gonderir ve classess endpointinden donen responsei kaydeder
    * Api kullanicisi status codeun 201 oldugunu dogrular
    * Api kullanicisi response bodydeki bilgileri dogrular
    * Api kullanicisi classess post endpointinden donen response bodynin schema validation dogrulamasini yapar
