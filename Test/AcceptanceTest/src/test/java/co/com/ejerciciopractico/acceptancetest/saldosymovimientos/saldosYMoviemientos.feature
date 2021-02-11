Feature: saldos y movimientos
  Scenario: consumir servicio y obtener una respuesta exitosa
    * url 'http://localhost:8080/api/saldosymovimientos'
    * def datarequest = read('datajson/saldosYMovimientosRequest.json')
    * def dataresponse = read('datajson/saldosYMovimientosResponse.json')

    Given request datarequest
    When method GET
    Then status 200


