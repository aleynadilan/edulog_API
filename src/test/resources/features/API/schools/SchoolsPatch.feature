Feature: Schools
  Scenario Outline: schools endpoint'ine geçerli authorization bilgileri ve güncellenmesi gereken verileri (isActive, company_id, group_id, name) içeren bir PATCH body gönderildiğinde dönen status code'un 200 olduğu doğrulanmalı.

    * ApiN kullanicisi "employee" token ile base urli olusturur
   * ApiN kullanicisi "schools", <id> path parametrelerini olusturur
    * ApiN kullanicisi schools endpoint'ine gondermek icin "<name>"  verisini iceren bir patch request olusturur
    * ApiN kullanicisi patch request gonderir ve schools endpoint'inden donen response'u kaydeder
    * ApiN kullanicisi status codeun 200 oldugunu dogrular
    * ApiN kullanicisi response body'deki bilgilerin guncellendigini dogrular
    Examples:
      | id | name   |
      | 21 | api patch  |
