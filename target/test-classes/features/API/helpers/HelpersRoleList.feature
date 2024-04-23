Feature: Okulun Rol Listesi.
  @API
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