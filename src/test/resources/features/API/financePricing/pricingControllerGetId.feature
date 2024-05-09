Feature: Finance pricing
   #parametreli Get
  Scenario Outline: API uzerinden olusturulan finance pricing kaydinin olustugu API uzerinden dogrulanmali.
  (Response bodyde dönen id ile /finans/{id} endpoint'ine GET request gönderilerek kayıt oluşturulduğu doğrulanabilir.)

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "finance","school","pricing","pricings",<season> path parametrelerini olusturur
    * ApiN kullanicisi get request gonderir ve donen responsei kaydeder
    * ApiN kullanicisi response body icindeki mesaj bilgisinin "<message>" oldugunu dogrular
    Examples:
      | season |message|
      | 7027 |  success  |



#negatif seneryo yanlış id ile
  Scenario Outline: schools endpoint'ine gecersiz id ile bir GET request gönderildiginde dönen status code'in 401 oldugunu dogrular


    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "finance","school","pricing","pricings",<season> path parametrelerini olusturur
    *  ApiN kullanicisi response hata mesajinin da status code '400',  reason phrase: Bad Request oldugunu dogrular
    Examples:
      | season |
      | 1 |

