Name: Weather Service 

Simple application REST API, where user is asking about current weather (temperature) for an indicated city. If in database exist information about current whether and is no older than 60 minutes program will return info from db. In other case, program is sending query do the external api, saving response in db and showing it to the client. 

Technology: Java, Spring-boot, MySQL (Workbench),  Lombok, Postman 




REST client/server
==================

Utwórz aplikację zwracającą w postaci REST-owego API dane pogodowe dla wskazanego miasta. W zwracanych danych powinna znajdować obecna temperatura. Opcjonalnie prognoza pogody dla kolejnych godzin/dni.

Dane źródłowe powinny być pobierane z zewnętrznego API i cache'owane w bazie danych. Tj. jeśli w ciągu ostatnich 60 minut wystąpiło zapytanie o dane miasto, należy zwrócić dane z bazy. W przeciwnym wypadku należy pobrać dane z zewnętrznego serwera i zapisać je w lokalnej bazie danych.

Opcjonalnie:
Zaimportuj listę dostępnych miast i użyj jej do walidacji zapytania HTTP
