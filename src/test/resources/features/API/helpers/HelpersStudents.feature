Feature: Yardımcı Denetleyicinin Öğrencilere İsim ve Kimliği Getirmesi.

  Scenario: /helpers/students endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "students" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular


  Scenario: /helpers/students endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "students" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular


  Scenario Outline: /helpers/students endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde id(x) olaninin response body'de donen bilgileri (name ve role name) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "students" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olanin "<name>" bilgisinin doğrular.

    Examples:
      | dataIndex | name           |
      | 5         | Mehmet Kahveci |

