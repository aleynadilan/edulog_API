Feature: Schools Delete

  Scenario Outline: Schools/{id} endpoint'ine gecerli authorization bilgileri ve silinmek istenen id'yi iceren bir DELETE
  request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "schools", <id> path parametrelerini olusturur
    * ApiN kullanicisi delete request gonderir ve donen responsei kaydeder
    * ApiN kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | id |
      | 17 |


  Scenario Outline: schools/{id} endpoint'ine gecersiz authorization bilgileri ve silinmek istenen id'yi iceren bir
  DELETE request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized"
  oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "schools", <id> path parametrelerini olusturur
    * ApiN kullanicisi response bodydeki status codeun '401' ve  errorData bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 123 |
