<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#  Java Prework - Tablice

Pamiętaj aby rozwiązania do zadań umieszczać w odpowiednich plikach `java`, przygotowanych do zadań.  
Zadania dodatkowe nie są obowiązkowe do zaliczenia preworku, lecz postaraj się je wykonać.

#### Zadanie 1

W pliku `Main1.java`

1. Stwórz tablicę z **trzema** elementami np. z liczbami, zmienną z tablicą nazwij `onlyThree`.
2. Następnie wypisz na konsoli po kolei elementy tej tablicy rozdzielając je spacją.
3. Nie korzystaj w tym zadaniu z pętli.

#### Zadanie 2

W pliku `Main2.java` stwórz tablicę z listą swoich ulubionych owoców, zmienną z tablicą nazwij `fruits`.  

Następnie:

1. Wypisz **pierwszy** owoc na stronie wg. wzoru: `Pierwszy owoc to: truskawka`.
2. Wypisz **ostatni** owoc na stronie wg. wzoru: `Ostatni owoc to: malina` (skorzystaj z `length`).
3. W pętli wypisz wszystkie owoce **każdy w nowej linii**  (skorzystaj z `length`).

#### Zadanie 3

W pliku `Main3.java`

1. Stwórz tablicę z 10 dowolnymi liczbami, zmienną z tablicą nazwij `numbers`.
2. Stwórz zmienną  ```sum``` i przypisz do niej liczbę `0`.
3. Za pomocą pętli ```for``` oblicz sumę liczb z tablicy.
4. Wypisz sumę na stronie wg. wzoru: `Suma elementów tablicy to: 381.`

#### Zadanie 4

W pliku `Main4.java`

1. Stwórz tablicę z 10 dowolnymi liczbami, zmienną z tablicą nazwij `numbers`.
2. W pętli ```for``` sprawdź, które są parzyste i wypisz je na stronie **jedna pod drugą**.
3. Dodaj dodatkową zmienną `sumOdd` o wartości `0`.
4. Zmodyfikuj pętlę z pkt.1  w ten sposób aby **dodatkowo** sumowała liczby nieparzyste.
5. Wyświetl dodatkowo na stronie komunikat wg. wzoru: `Suma liczb nieparzystych to: 87.`


#### Zadanie 5

W pliku `Main5.java`

1. Stwórz tablicę z 10 dowolnymi liczbami, zmienną z tablicą nazwij `numbers`.
2. Stwórz zmienną  ```max``` i przypisz do niej `0`.
3. W pętli ```for``` znajdź liczbę, która jest największa, przypisz ją do zmiennej ```max``` i wypisz na stronie.
4. Aby to zrobić przeiteruj tablicę i sprawdź czy aktualny element jest większy o aktualnej wartości `max` i jeśli tak, zaktualizuj zmienną `max`.
5. Sprawdź czy Twój kod będzie działał poprawnie jeśli w tablicy znajdą się **tylko** liczby ujemne.
6. Spróbuj zmodyfikować kod aby działał on uniwersalnie (podpowiedź: wystarczy zmodyfikować 1 linię kodu).

#### Zadanie 6

W pliku `Main6.java`

1. Stwórz tablicę z 10 dowolnymi liczbami, zmienną z tablicą nazwij `numbers`.
2. Wypisz ją od tyłu używając pętli ```for```, każdy element w nowej linii.

#### Zadanie 7 - dodatkowe

W pliku `Main7.java`

1. Stwórz tablicę ze 100 losowymi liczbami z zakresu `0-20`, zmienną z tablicą nazwij `randNumbers`.
2. Użyj do tego pętli `for` - do otrzymania losowej liczby użyj kodu umieszczonego w pliku.
3. Wypisz na stronie wylosowane liczby oddzielone od siebie przecinkiem `18,12,1,3...`.
4. Oblicz sumę liczb z tablicy, wynik przypisz do zmiennej `sum`.
5. Wypisz na stronie, w nowej linii, sumę wg. wzoru: `Suma 100 losowych liczb od 0 do 20 to: 876.`.


#### Zadanie 8 - dodatkowe

W pliku `Main8.java` znajduje się tablica z temperaturami.

1. Temperatura w tablicy zapisana jest w stopniach Celsjusza, zamień ją na stopnie Fahrenheit'a
   `tempCelc * 1.8 + 32`.
2. Aby to zrobić przeiteruj tablicę i nadpisz dany indeks nową obliczoną wartością.
3. Przypisz do zmiennej `avg` średnią temperaturę ze zmienionej tablicy.
4. Wypisz ją na stronie wg. wzoru: `Średnia temperatura to: 3.95`, zaokrąglij liczbę do 2 miejsc po przecinku,
 możesz użyć użyj funkcji: 
 ```java 
 String.format( "%.2f", variableToFormat );
 ```
