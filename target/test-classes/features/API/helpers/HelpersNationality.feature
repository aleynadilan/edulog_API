@helpers
Feature: Yardımcı Kontrolörün Vatandaşlık alması.

  Scenario Outline: /helpers/nationality endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 200 oldugu ve response body'de donen bilgileri (isActive, createdAt,
  updatedAt, deletedAt, name) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "nationality" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olanin "<createdAt>", "<updatedAt>" ve "<name>" bilgilerini doğrular.
    * Api kullanicisi helpers nationality endpointinden donen response bodynin schema validation dogrulamasini yapar

    Examples:
      | dataIndex | createdAt                | updatedAt                | name       |
      | 0         | 2024-01-08T12:54:30.955Z | 2024-01-08T12:54:30.955Z | Türkiye    |
      | 2         | 2024-01-08T12:54:30.955Z | 2024-01-08T12:54:30.955Z | Yunanistan |


  Scenario: /helpers/students endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "nationality" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
