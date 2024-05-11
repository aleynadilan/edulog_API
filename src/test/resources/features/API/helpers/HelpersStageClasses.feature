@Dilan
Feature: İlgili Aşamanın sınıfları.

  Scenario Outline: /helpers/stage-classes/{stage} endpoint'ine gecerli authorization bilgileri ve stage verisinin
  bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "stage-classes" ve "<stage>" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi helpers stage classes endpointinden donen response bodynin schema validation dogrulamasini yapar

    Examples:
      | stage      |
      | pre_school |


  Scenario Outline: /helpers/stage-classes/{stage} endpoint'ine gecersiz authorization bilgileri ve stage verisinin
  bulundugu bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "stage-classes" ve "<stage>" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | stage      |
      | pre_school |


  Scenario Outline: /helpers/stage-classes/{stage} endpoint'ine gecerli authorization bilgileri ve stage verisinin
  bulundugu bir GET request gönderildiginde id(x) olaninin response body'de donen bilgileri (isActive, createdAt,
  updatedAt, deletedAt, name, level_key) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "stage-classes" ve "<stage>" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response bodyde branchList arrayinde ki <dataIndex> indexe sahip olanin <value>, "<label>" ve <classId> bilgilerini doğrular.

    Examples:
      | stage      | dataIndex | value | label | classId |
      | pre_school | 1         | 9     | 0/C   | 3       |