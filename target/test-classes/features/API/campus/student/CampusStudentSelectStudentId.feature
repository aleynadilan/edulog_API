Feature: Campus student select

  Scenario: Campus Student select studentid get islemi
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden base_url-campus-student-:studentId icin rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student" ve :studentId icin path parametrelerini olusturur
    And Mustafa kullanicisi base_url-campus-student-:studentId icin get request gonderir
    Then Mustafa kullanicisi status code 200 oldugunu dogrular

  Scenario: Campus Student select studentid post islemi
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden base_url-campus-student-:studentId icin rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student" ve :studentId path parametrelerini olusturur
    And Mustafa kullanicisi base_url-campus-student-:studentId icin post request gonderir
    Then Mustafa kullanicisi base_url-campus-student-:studentId icin status code 201 oldugunu dogrular


  Scenario: Campus Student select studentid DELETE islemi
    Given Mustafa kullanicisi "employee" token ile base urli olusturur
    And Mustafa kullanicisi "helpers", "students" path parametrelerini olusturur
    And Mustafa kullanicisi "{{base_url}}/helpers/students" endpointi icin get request gonderir ve donen response kaydeder
    And Mustafa kullanicisi donen body govdesinden base_url-campus-student-:studentId icin rastgele bir ogrenci idsini bir degiskene kaydeder
    And Mustafa kullanicisi "campus", "student" ve :studentId path parametrelerini olusturur
    And Mustafa kullanicisi base_url-campus-student-:studentId icin DELETE request gonderir
    Then Mustafa kullanicisi status code 200 oldugunu dogrular