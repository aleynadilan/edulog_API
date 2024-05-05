Feature: Ogrenci wizard 1. step
  Scenario: Ogrenci wizard 1. step happy scenario
    Given Mustafa kullanicisi "student" token ile base urli olusturur
    And Mustafa kullanicisi "{{base_url}}campus/student/step_student" icin body olusturur
    And Mustafa kullanicisi "campus", "student","step_student" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}campus/student/step_student" icin post request gonderir ve donen response kaydeder
    Then Mustafa kullanicisi status code 201 oldugunu dogrular
    And Mustafa kullanicisi "features/API/campus/student/campusstepstudent.json" dosyasi schema validation yapar


#   Öğrenci oluşturmak için ilk adım.
#  Kimlik numarası: zorunlu
#  Ad Soyad: zorunlu
#  Yabancı mı değil mi ? : zorunlu
#
#  firstCreate field'ı ilk oluşturulan öğrenciler için geçerlidir. eğer firstCreate true olarak verilmişse öğrencinin zorunlu olan alanları kontrolü atlatılır.
  Scenario: Ogrenci wizard 1. step bos isim negatif senaryo
    Given Mustafa kullanicisi "student" token ile base urli olusturur
    And Mustafa kullanicisi "{{base_url}}campus/student/step_student" bos name ile  body olusturur
    And Mustafa kullanicisi "campus", "student","step_student" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}campus/student/step_student" icin post request gonderir ve donen response kaydeder
    Then Mustafa kullanicisi status code 400 oldugunu dogrular
    And  Mustafa kullanicisi response "name should not be empty" icerdigini dogrular

  Scenario: Ogrenci wizard 1. step bos id number negatif senaryo
    Given Mustafa kullanicisi "student" token ile base urli olusturur
    And Mustafa kullanicisi "{{base_url}}campus/student/step_student" bos id number ile  body olusturur
    And Mustafa kullanicisi "campus", "student","step_student" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}campus/student/step_student" icin post request gonderir ve donen response kaydeder
    Then Mustafa kullanicisi status code 400 oldugunu dogrular
    And  Mustafa kullanicisi response "idNumber must be a number string" icerdigini dogrular

  Scenario: Ogrenci wizard 1. step bos isForeign null negatif senaryo
    Given Mustafa kullanicisi "student" token ile base urli olusturur
    And Mustafa kullanicisi "{{base_url}}campus/student/step_student" isForeign null ile  body olusturur
    And Mustafa kullanicisi "campus", "student","step_student" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}campus/student/step_student" icin post request gonderir ve donen response kaydeder
    Then Mustafa kullanicisi status code 400 oldugunu dogrular
    And  Mustafa kullanicisi response "isForeign must be a boolean value" icerdigini dogrular