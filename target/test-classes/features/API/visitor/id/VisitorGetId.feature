Feature: Visitor Get İd
   #parametreli Get
  @ApiN
  Scenario Outline: API uzerinden olusturulan visitor kaydinin olustugu API uzerinden dogrulanmali.
  (Response bodyde dönen id ile /visitor/{id} endpoint'ine GET request gönderilerek kayıt oluşturulduğu doğrulanabilir.)

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "visitor", <id> path parametrelerini olusturur
    * ApiN kullanicisi get request gonderir ve donen responsei kaydeder
    * ApiN kullanicisi response body icindeki mesaj bilgisinin "<mesaj>" oldugunu dogrular
    Examples:
      | id | mesaj   |
      | 18 | visitor success. |

#negatif seneryo yanlış id ile
  Scenario Outline: schools endpoint'ine gecersiz id ile bir GET request gönderildiginde dönen status code'in 401 oldugunu dogrular

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "visitor", <id> path parametrelerini olusturur
   * ApiN kullanicisi get request gonderir ve donen responsei kaydeder
    * ApiN kullanicisi response hata mesajinin da status code '400', reason phrase: Bad Request oldugunu dogrular
    Examples:
      | id |
      | 174125 |