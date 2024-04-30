Feature: Yardımcı Kontrolörlerin Sorumlu Öğrencileri Kazanması.

  Scenario: /helpers/responsible-students endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "responsible-students" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi helpers responsible students endpointinden donen response bodynin schema validation dogrulamasini yapar


  Scenario: /helpers/responsible-students endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "responsible-students" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
