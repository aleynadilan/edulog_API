@API
Feature: Sezon Kontrolörü Tümünü Bul.

  Scenario Outline: /seasons endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 200 oldugu ve id(x) olaninin response body'de donen bilgileri
  (isActive, createdAt, updatedAt, deletedAt, name, seasonStartDate, seasonEndDate) dogrulanmali

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "seasons" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanıcısi response body icinde <dataIndex> indexe sahip olan "<createdAt>", "<updatedAt>", "<name>", "<seasonStartDate>" ve "<seasonEndDate>" bilgilerini doğrular.
    * Api kullanicisi seasons get endpointinden donen response bodynin schema validation dogrulamasini yapar

    Examples:
      | dataIndex | createdAt                | updatedAt                | name      | seasonStartDate          | seasonEndDate            |
      | 2         | 2024-04-25T11:39:34.500Z | 2024-04-25T11:39:34.500Z | 2024/2025 | 2024-09-17T00:00:00.000Z | 2025-09-17T00:00:00.000Z |


  Scenario: /seasons endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "seasons" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
