@meet
Feature: Görüşmeler Witgetları.

  Scenario: /meet/widgets endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde dönen
  status code'in 200 oldugu ve response body'deki message bilgisinin "success", status bilgisinin de true oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "meet", "widgets" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanicisi status codeun 200 oldugunu dogrular
    * Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * Api kullanicisi response bodydeki status bilgisinin true oldugunu dogrular
    * Api kullanicisi meet widgets endpointinden donen response bodynin schema validation dogrulamasini yapar


  Scenario: /meet/widgets endpoint'ine gecersiz authorization bilgileri ile bir GET request gönderildiginde
  dönen status code'in 401 ve response body'deki errorData bilgisinin "Unauthorized" oldugu dogrulanmali.

    * Api kullanicisi "invalid" token ile base urli olusturur
    * Api kullanicisi "meet", "widgets" path parametrelerini olusturur
    * Api kullanicisi donen responsei kaydeder, status codeun '401' ve reason phrase bilgisinin Unauthorized oldugunu dogrular


  Scenario Outline: /meet/widgets endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde
  index(x) olaninin response body'de donen bilgileri (key, icon, color, chartType) dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "meet", "widgets" path parametrelerini olusturur
    * Api kullanicisi get request gonderir ve donen responsei kaydeder
    * Api kullanıcısi response body icinde <dataIndex> indexe sahip olanin "<key>", "<icon>", "<color>" ve "<chartType>" bilgilerini doğrular.

    Examples:
      | dataIndex | key              | icon                                                                    | color   | chartType |
      | 0         | public_relations | /icons/edulog_iconset/campuswidgeticon/ziyaretciler/halklailiskiler.svg | #616478 | radialBar |
