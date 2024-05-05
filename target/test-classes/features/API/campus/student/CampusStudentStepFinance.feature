Feature: Ogrencilerin odeme bilgilerinin alinmasi
  Scenario: Ogrencilerin odeme bilgilerinin hesaplanmasi
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "finance", "school","pricing" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/finance/school/pricing" seklindeki endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir pricings idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student","step_finance","calculate" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/campus/student/step_finance/calculate" icin yeni body olusturur
    And Mustafa kullanicisi base_url-campus-student-step_finance-calculate icin post request gonderir
    Then Mustafa kullanicisi status code 201 oldugunu dogrular
   #And Mustafa kullanicisi "features/API/campus/student/campusstepstudent.json" dosyasi schema validation yapar

#  financePricings: number[] = Öğrencinin listeyebildiği ödemelerin id array'i (Eğitim, Kıyafet vs.)
#  discount: number[] = Öğrencinin listeyebildiği indirimlerin listesi (Kurumsal, Kardeş vs.) Bu Kısımda farklı conditionlar ile indirim hesaplaması yapılıyor
#  student: number = öğrenci id'si

  Scenario: Ogrencilerin odeme bilgilerinin hesaplanmasi
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "finance", "school","pricing" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/finance/school/pricing" seklindeki endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir pricings idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student","step_finance" path parametrelerini olusturur
    And Mustafa kullanicisi base_url-campus-student-step_finance icin yeni body olusturur
    And Mustafa kullanicisi base_url-campus-student-step_finance icin post request gonderir
    Then Mustafa kullanicisi status code 201 oldugunu dogrular

  Scenario: Ogrencilerin odeme bilgilerinin body olmadan hesaplanmasi negatif senaryo
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "finance", "school","pricing" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/finance/school/pricing" seklindeki endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir pricings idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student","step_finance" path parametrelerini olusturur
    And Mustafa kullanicisi base_url-campus-student-step_finance icin bos body olusturur
    And Mustafa kullanicisi base_url-campus-student-step_finance icin post request gonderir
    Then Mustafa kullanicisi status code 400 oldugunu dogrular
    And Mustafa kullanicisi errorData degerlerinin varligini dogrular

  Scenario: Ogrencilerin odeme bilgilerinin studentid olmadan hesaplanmasi negatif senaryo
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "finance", "school","pricing" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/finance/school/pricing" seklindeki endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden rastgele bir pricings idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student","step_finance" path parametrelerini olusturur
    And Mustafa kullanicisi base_url-campus-student-step_finance icin studentid olmayan body olusturur
    And Mustafa kullanicisi base_url-campus-student-step_finance icin post request gonderir
    Then Mustafa kullanicisi status code 400 oldugunu dogrular
    And Mustafa kullanicisi id olmadan errorData degerlerinin varligini dogrular

