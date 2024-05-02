Feature: campus/student
  Scenario: Ogrenci wizard 1. step
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
