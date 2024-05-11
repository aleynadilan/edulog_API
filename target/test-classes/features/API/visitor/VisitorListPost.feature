Feature: Visitor Post
#Post
  @API
  Scenario: /visitor /list endpoint'ine gecerli authorization bilgileri ve gerekli verileri
  iceren bir POST body gönderildiginde dönen status code'in 201
  oldugu dogrulanmali.

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "visitor" , "list" path parametrelerini olusturur
    * ApiN kullanicisi visitor list endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * ApiN kullanicisi post request gonderir ve visitor list endpointinden donen responsei kaydeder
    * ApiN kullanicisi status codeun 201 oldugunu dogrular
    * ApiN kullanicisi response bodydeki messagen "success" oldugunu dogrular
    * ApiN kullanicisi schools post endpointinden donen response bodynin schema validation dogrulamasini yapar
#negatif seneryo
  @API
  Scenario: /visitor /list endpoint'ine gecersiz authorization bilgileri bir Post request gönderildiginde dönen status code'in 401 ve
  response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * ApiN kullanicisi "invalidToken" token ile base urli olusturur
    * ApiN kullanicisi "visitor" , "list" path parametrelerini olusturur
    * ApiN kullanicisi visitor list endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * ApiN kullanicisi post request gonderir ve visitor list endpointinden donen responsei kaydeder
    * ApiN kullanicisi response bodydeki status codeun '401' ve  errorData bilgisinin Unauthorized oldugunu dogrular
