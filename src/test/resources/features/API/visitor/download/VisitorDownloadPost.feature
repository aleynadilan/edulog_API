Feature: Visitor Download Post
#Post
  @ApiN
  Scenario: /visitor /Download endpoint'ine gecerli authorization bilgileri ve gerekli verileri
  iceren bir POST body gönderildiginde dönen status code'in 201
  oldugu dogrulanmali.

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "visitor" , "download" path parametrelerini olusturur
    * ApiN kullanicisi visitor list endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * ApiN kullanicisi post request gonderir ve visitor list endpointinden donen responsei kaydeder
    * ApiN kullanicisi status codeun 201 oldugunu dogrular

#negatif seneryo
  @ApiN
  Scenario: /visitor /download endpoint'ine gecersiz authorization bilgileri bir Post request gönderildiginde dönen status code'in 401 ve
  response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * ApiN kullanicisi "invalidToken" token ile base urli olusturur
    * ApiN kullanicisi "visitor" , "download" path parametrelerini olusturur
    * ApiN kullanicisi visitor list endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * ApiN kullanicisi post request gonderir ve visitor list endpointinden donen responsei kaydeder
    * ApiN kullanicisi response bodydeki status codeun '401' ve  errorData bilgisinin Unauthorized oldugunu dogrular
