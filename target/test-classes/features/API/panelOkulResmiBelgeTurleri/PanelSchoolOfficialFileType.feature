Feature: Okul Resmi Dosya Türü Denetleyicisi Tümünü Bul.

  Scenario: /panel/school-official-file-type endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 200, response body'deki message bilgisinin "success", status bilgisinin true
  oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "panel", "school-official-file-type" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * Api kullanicisi response bodydeki status bilgisinin true oldugunu dogrular


  Scenario: /panel/school-official-file-type endpoint'ine gecersiz authorization bilgileri ile bir GET request
  gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "panel", "school-official-file-type" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

  @API
  Scenario Outline: /panel/school-official-file-type endpoint'ine gecerli authorization bilgileri ile bir GET request
  gönderildiginde id(x) olaninin response body'de donen bilgisi (key) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "panel", "school-official-file-type" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olan "<key>" bilgisini dogrular.

    Examples:
      | dataIndex | key      |
      | 2         | internal |