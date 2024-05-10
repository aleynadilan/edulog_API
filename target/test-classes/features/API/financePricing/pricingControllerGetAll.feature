Feature: Finance pricing
  # GET
  @ApiN
  Scenario: API uzerinden olusturulmak istenen yeni finance pricing kaydinin olustugu API uzerinden dogrulanmali.
  (Response bodyde dönen /finance/school/pricing endpoint'ine GET request gönderilerek kayıt oluşturulduğu doğrulanabilir.)

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "finance" , "school" ,"pricing" path parametrelerini olusturur
    * ApiN kullanicisi get request gonderir ve donen responsei kaydeder
    * ApiN kullanicisi status codeun 200 oldugunu dogrular

#negatif Scenario
  @ApiN
  Scenario: finance pricing endpoint'ine gecersiz authorization bilgileri bir GET request gönderildiginde dönen status code'in 401 ve
  response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * ApiN kullanicisi "invalidToken" token ile base urli olusturur
    * ApiN kullanicisi "finance" , "school" ,"pricing" path parametrelerini olusturur
    * ApiN kullanicisi response bodydeki status codeun '401' ve  errorData bilgisinin Unauthorized oldugunu dogrular

