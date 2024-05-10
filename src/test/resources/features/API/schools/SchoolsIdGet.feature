Feature: Schools
   #parametreli Get
  @ApiN
  Scenario Outline: API uzerinden olusturulan schools kaydinin olustugu API uzerinden dogrulanmali.
  (Response bodyde dönen id ile /schools/{id} endpoint'ine GET request gönderilerek kayıt oluşturulduğu doğrulanabilir.)

    * ApiN kullanicisi "employee" token ile base urli olusturur
    * ApiN kullanicisi "schools", <id> path parametrelerini olusturur
    * ApiN kullanicisi get request gonderir ve donen responsei kaydeder
    * ApiN kullanicisi response body icindeki name bilgisinin "<name>" ve id bilgisininde <id> oldugunu dogrular
    Examples:
      | id | name   |
      | 23 | api deneme |

#negatif seneryo yanlış id ile
#  Scenario Outline: schools endpoint'ine gecersiz id ile bir GET request gönderildiginde dönen status code'in 401 oldugunu dogrular
#
#
#    * ApiN kullanicisi "employee" token ile base urli olusturur
#    * ApiN kullanicisi "schools", <id> path parametrelerini olusturur
#    * ApiN kullanicisi get request gonderir ve donen responsei kaydeder
#    * ApiN kullanicisi status codeun 401 oldugunu dogrular
#    Examples:
#      | id |
#      | 1741 |
