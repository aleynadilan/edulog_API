Feature: Yardımcı Denetleyicilerin Sorumlu Öğretmenler Edinmesi.

  Scenario Outline: /helpers/responsible-teachers endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 200 oldugu ve response body'de donen bilgileri (name) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "responsible-teachers" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olanin "<name>" bilgisini doğrular.

    Examples:
      | dataIndex | name            |
      | 3         | Finans Yönetici |


  Scenario: /helpers/responsible-teachers endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "responsible-teachers" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular
