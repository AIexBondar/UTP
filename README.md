# UTP
Uniwersalne techniki progrmowania w javie zadania:

### UTP 1
Zadanie: tabela państw

Przedstawić w tabeli JTable państwa z pliku.

Plik powinien mieć następującą postać:

```
nazwa_kol1<TAB>nazwa_kol2<TAB> ....
nazwa_państwa1<TAB>stolica1<TAB> ludność1 ....

Na przykład:
Name    Capital    Population
Republic of Poland    Warsaw    38500
Chech Republic    Prague    10500 
Kingdom of Spain    Madrid    46599
```

Nalezy zwrócić uwagę, że pola są rozdzielane przez znak tabulacji,  liczba ludności podawana jest w tysiącach.
Plik powinien  znajdować się w katalogu data projektu i mieć nazwę countries.txt

Dodatkowe wymagania:
- kolumny tabeli mają mieć nazwy z  pierwszego wiersza pliku
- dane o ludności mają być traktowane jako liczby
- i pokazywane w tabeli jak liczby
- pokazać w tabeli flagi państw (wymaga modyfikacji pliku państw i dodanie kolumny, pokazującej flagę jako grafikę)
- zapewnić pokazywanie wszystkich państw świata (jakich narzędzi użyjemy, żeby to łatwo zrobić)
- wyróżnić  komórki z liczbą ludności dla państw z ludnością > 20 mln czerwonym kolorem pisma


### UTP2
Napisać aplikację, która symuluje zakupy w kwiaciarni "samoobsługowej".
W kwiaciarni są kwiaty, kwiaty mają swoje nazwy oraz kolory. Ceny kwiatów znajdują się w cenniku.
Do kwiaciarni przychodzą klienci. Klienci mają imiona oraz dysponują jakimś zasobem pieniędzy. Wybierają kwiaty i umieszczają je na wózku sklepowym. Następnie płacą za zawartość wózka i przepakowują ją do pudełka (jakiegoś pudełka na kwiaty :-).


Dodawanie do  programu nowych rodzajów kwiatów  ma byc bardzo łatwe.
Przy dodaniu nowego rodzaju kwiatów nie wolno modyfikować żadnych innych klas programu.
Wymagania dodatkowe:
- należy wykorzystać klasy abstrakcyjne i polimorfizm
- należy zminimalizować kod klas ShoppingCart i Box
- należy zdefiniować klasę PriceList jako singleton (możemy mieć zawsze tylko jeden cennik

Ważne uwagi. 
W kwiaciarni mogą być kwiaty, których zapomniano dodać do cennika. Wtedy przy płaceniu są one usuwane z naszego wózka.
Może się okazać, że klient nie dysponuje odpowiednią kwotą pieniędzy aby zapłacić za całą zawartość wóżka. Wtedy z wózka usuwane są kwiaty, za które klient nie może zapłacić (ale nie pojedyńczo, tylko w kompletach np. po stefan.get(new Lilac(3)) usuwane są te trzy bzy na które Stefan nie ma pieniędzy).
Warto zwrócić uwagę na odpowiednio zdefiniowanie metody toString() w niektórych klasach.

I na koniec: nie przejmujemy się tym, że np. róże mogą mieć wiele kolorów. Dla uproszczenia przyjęliśmy, że róże są czerwone itd.


 
