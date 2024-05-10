@Dilan
Feature: Yardımcı Kontrolörün Sezonları alması.

  Scenario Outline: /helpers/seasons endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 200 oldugu ve response body'de donen bilgileri (isActive, createdAt,
  updatedAt, deletedAt, name, seasonStartDate, seasonEndDate) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "seasons" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olan "<createdAt>", "<updatedAt>", "<name>", "<seasonStartDate>" ve "<seasonEndDate>" bilgilerini doğrular.
    * Api kullanicisi helpers seasons endpointinden donen response bodynin schema validation dogrulamasini yapar

    Examples:
      | dataIndex | createdAt                | updatedAt                | name      | seasonStartDate          | seasonEndDate            |
      | 0         | 2023-10-25T07:14:40.077Z | 2023-10-25T07:14:40.077Z | 2023/2024 | 2024-09-17T00:00:00.000Z | 2025-09-17T00:00:00.000Z |


  Scenario: /helpers/seasons endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "seasons" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
