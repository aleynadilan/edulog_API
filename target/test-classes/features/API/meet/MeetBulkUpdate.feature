Feature: Öğrencileri toplu güncelleme işlemi.
  @API
  Scenario: /meet/bulk/update endpoint'ine gecerli authorization bilgileri ve gerekli verileri iceren bir POST body
  gönderildiginde dönen status code'in 201 oldugu dogrulanmali.

    * Api kullanicisi "employee" token ile base urli olusturur
    * Api kullanicisi "meet", "bulk" ve "update" path parametrelerini olusturur
    * Api kullanicisi meet bulk update endpointine gondermek icin gerekli verileri iceren bir post request olusturur
    * Api kullanicisi post request gonderir ve meet bulk update endpointinden donen responsei kaydeder
    * Api kullanicisi meet bulk update endpointinden donen response bodynin schema validation dogrulamasini yapar
