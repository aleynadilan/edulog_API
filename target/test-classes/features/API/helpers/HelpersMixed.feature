@Dilan
Feature: Yardımcı Denetleyici, Öğrenci Ekleme Yardımcılarını alır.

  Scenario Outline: /helpers/mixed endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 200 oldugu ve response body'de donen bilgileri (isActive, createdAt,
  updatedAt, deletedAt, name) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "mixed" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olan "<createdAt>", "<updatedAt>" ve "<name>" bilgilerini doğrular.

    Examples:
      | dataIndex | createdAt                | updatedAt                | name           |
      | 0         | 2023-12-28T14:42:05.035Z | 2023-12-28T14:42:05.035Z | Adana          |
      | 2         | 2023-12-28T14:42:05.035Z | 2023-12-28T14:42:05.035Z | Afyonkarahisar |


  Scenario: /helpers/mixed endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "mixed" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
