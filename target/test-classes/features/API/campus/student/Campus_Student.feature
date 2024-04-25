Feature: Ogrencilerin Toplu Guncelleme Islemi

  Scenario:idleri verilen öğrencilerin field ve value eşleşmelerine göre bulk update yapabilmesi
    Given Mustafa kullanicisi "student" token ile base urli olusturur
    And Mustafa kullanicisi "campus", "student","bulk","update" path parametrelerini olusturur
    And Mustafa kullanicisi body olusturur
    And Mustafa kullanicisi post request gonderir ve donen responsei kaydeder
    Then Mustafa kullanicisi status code 201 oldugunu dogrular
    And Mustafa kullanicisi donen body O zaman yanıtın gövdesi doğrulanır:
      | alan     | değer     |
      | status   | true      |
      | message  | success   |
      | data     |           |
      | statusCode | 200     |

    Scenario: Schema validation Öğrencileri toplu güncelleme işlemi.
      Given Mustafa kullanicisi "student" token ile base urli olusturur
      And Mustafa kullanicisi "campus", "student","bulk","update" path parametrelerini olusturur
      And Mustafa kullanicisi body olusturur
      And Mustafa kullanicisi post request gonderir ve donen responsei kaydeder
      Then Mustafa kullanicisi status code 201 oldugunu dogrular
      And Mustafa kullanicisi request bodynin schema validation dogrulamasini yapar

