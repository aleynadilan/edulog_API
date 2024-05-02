Feature: Schools
  # GET
  Scenario: API uzerinden olusturulmak istenen yeni Schools kaydinin olustugu API uzerinden dogrulanmali.
  (Response bodyde dönen schools endpoint'ine GET request gönderilerek kayıt oluşturulduğu doğrulanabilir.)

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "schools" path parametrelerini olusturur
    * ApiN kullanicisi get request gonderir ve donen responsei kaydeder
    * ApiN kullanicisi status codeun 200 oldugunu dogrular

#negatif Scenario
  Scenario: schools endpoint'ine gecersiz authorization bilgileri bir GET request gönderildiginde dönen status code'in 401 ve
  response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * ApiN kullanicisi "invalidToken" token ile base urli olusturur
    * ApiN kullanicisi "schools" path parametrelerini olusturur
    * ApiN kullanicisi response bodydeki status codeun '401' ve  errorData bilgisinin Unauthorized oldugunu dogrular


    #parametrreli Get
  Scenario Outline: API uzerinden olusturulan schools kaydinin olustugu API uzerinden dogrulanmali.
  (Response bodyde dönen id ile /schools/{id} endpoint'ine GET request gönderilerek kayıt oluşturulduğu doğrulanabilir.)

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "schools", <id> path parametrelerini olusturur
    * ApiN kullanicisi get request gonderir ve donen responsei kaydeder
    * ApiN kullanicisi response body icindeki name bilgisinin "<name>" ve id bilgisininde <responseId> oldugunu dogrular

    Examples:
      | id | name   | responseId |
      | 76 | Aleyna | 76         |