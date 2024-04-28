Feature: Ogrencilerin Toplu Bilgilerini Indirme

  Scenario: verilen idlerin bilgilerini excel olarak indirme.

    And Mustafa kullanicisi "campus/student/upload_single_file/:userId" icin post request gonderir ve donen responsei kaydeder
    And Mustafa kullanicisi "campus", "student","upload_single_file" path ve ":userId" query parametrelerini olusturur





