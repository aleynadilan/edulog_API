Feature: Schools
#Post
  @ApiN
  Scenario: schools endpoint'ine gecerli authorization bilgileri ve gerekli verileri (isActive,
  company_id, group_id,  name) iceren bir POST body gönderildiginde dönen status code'in 201
  oldugu dogrulanmali.

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "schools" path parametrelerini olusturur
    * ApiN kullanicisi schools endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * ApiN kullanicisi post request gonderir ve schools endpointinden donen responsei kaydeder
    * ApiN kullanicisi status codeun 201 oldugunu dogrular
    * ApiN kullanicisi response bodydeki bilgileri dogrular
    * ApiN kullanicisi schools post endpointinden donen response bodynin schema validation dogrulamasini yapar

#negatif Scenario
  @ApiN
  Scenario: schools endpoint'ine gecersiz authorization bilgileri ve gerekli verileri (isActive,
  company_id, group_id,  name) iceren bir POST body gönderildiginde dönen status code'in 401 ve
  response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.
    * ApiN kullanicisi "invalidToken" token ile base urli olusturur
    * ApiN kullanicisi "schools" path parametrelerini olusturur
    * ApiN kullanicisi schools endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * ApiN kullanicisi post request gonderir ve schools endpointinden donen responsei kaydeder
    * ApiN kullanicisi status codeun 401 oldugunu dogrular
    * ApiN kullanicisi response bodydeki errorData bilgisinin "Unauthorized" oldugunu dogrular

