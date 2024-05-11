Feature: Sunucunun aktif olup olmadığını kontrol edilmesi.

  Scenario: /health-check endpoint'ine bir GET request gönderildiginde dönen status code'in 200 ve
  response body'deki message bilgisinin "up" oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "health-check" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

