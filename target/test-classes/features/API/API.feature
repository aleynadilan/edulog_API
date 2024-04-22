Feature: As an administrator
  @API
  Scenario: When a GET request

    * Api kullanicisi "employee" token ile base urli olusturur
    * APi kullanicisi ealth check path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve ealth check endpointinden donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

