Feature: Yardımcı Denetleyicinin Çalışan Kimliğine Göre Sorumlu Öğrencileri Alması.

  Scenario Outline: /helpers/responsible-students/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin
  bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "responsible-students" ve <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular

    Examples:
      | id |
      | 16 |


  Scenario Outline: /helpers/responsible-students/{id} endpoint'ine gecerli authorization bilgileri ve sistemde bulunmayan
  id verisinin bulundugu bir GET request gönderildiginde dönen status code'in 200 oldugu ve response body'deki
  array'in bos oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "responsible-students" ve <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response body'deki arrayin bos oldugunu dogrular

    Examples:
      | id |
      | 2  |


  Scenario Outline: /helpers/responsible-students/{id} endpoint'ine gecersiz authorization bilgileri ve id verisinin
  bulundugu bir GET request gönderildiginde dönen status code'in 401 ve response body'deki errorData bilgisinin
  "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "helpers", "responsible-students" ve <id> path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id |
      | 16 |


  Scenario Outline: /helpers/responsible-students/{id} endpoint'ine gecerli authorization bilgileri ve id verisinin
  bulundugu bir GET request gönderildiginde id(x) olaninin response body'de donen bilgileri (isActive, createdAt,
  updatedAt, deletedAt, isBanned, banEndDate, nameId, companyId, groupId, schoolId, testUser, registerType, name,
  isForeign, idNumber, phone, bloodType, email, birthday, gender, cityId, countyId, districtId, nationalityId,
  addressDetail, studentNumber, classId, branchId, seasonId, area, teacherId) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "helpers", "responsible-students" ve <id> path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icindeki <dataIndex> indexe sahip olanin "<createdAt>", "<updatedAt>", <companyId>, <groupId>, <schoolId>, "<registerType>", "<name>", "<idNumber>", "<phone>", "<bloodType>", "<birthday>", "<gender>", <cityId>, <countyId>, <districtId>, "<addressDetail>", "<studentNumber>", <classId>, <branchId>, <seasonId>, <teacherId>  bilgilerini doğrular.

    Examples:
      | id | dataIndex | createdAt                | updatedAt                | companyId | groupId | schoolId | registerType | name       | idNumber    | phone      | bloodType  | birthday   | gender | cityId | countyId | districtId | addressDetail | studentNumber | classId | branchId | seasonId | teacherId |
      | 16 | 0         | 2024-03-30T11:06:44.653Z | 2024-04-03T16:41:17.638Z | 1         | 1       | 1        | yeni_kayit   | Fuat Bulut | 13911820162 | 5777777777 | AB_RH_PLUS | 2020-12-19 | m      | 1      | 1104     | 72         | Sdfgsdh       | 1008          | 1       | 1        | 1        | 16        |
