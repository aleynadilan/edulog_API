Feature: Okulun Rol Listesi.

  Scenario Outline: /helpers/role-list endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 200 oldugu ve response body'de donen bilgileri (isActive, createdAt,
  updatedAt, deletedAt, name) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "role-list" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olan "<name>" ve "<key>" bilgilerini doğrular.

    Examples:
      | dataIndex | name                      | key                                   |
      | 6         | Halkla İlişkiler Yönetici | halklai̇lişkileryönetici1711715023797 |


  Scenario: /helpers/role-list endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "role-list" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
