Feature: Ogrencilerin odeme bilgilerinin alinmasi
  Scenario: Ogrencilerin odeme bilgilerinin alinmasi
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "finance", "school","pricing" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/finance/school/pricing" seklindeki endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir pricings idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student","step_finance","calculate" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/campus/student/step_finance/calculate" icin yeni body olusturur
    Then Mustafa kullanicisi status code 200 oldugunu dogrular
   #And Mustafa kullanicisi "features/API/campus/student/campusstepstudent.json" dosyasi schema validation yapar

#  financePricings: number[] = Öğrencinin listeyebildiği ödemelerin id array'i (Eğitim, Kıyafet vs.)
#  discount: number[] = Öğrencinin listeyebildiği indirimlerin listesi (Kurumsal, Kardeş vs.) Bu Kısımda farklı conditionlar ile indirim hesaplaması yapılıyor
#  student: number = öğrenci id'si