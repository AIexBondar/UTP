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
Do kwiaciarni przychodzą klienci. Klienci mają imiona oraz dysponują jakimś zasobem pieniędzy. Wybierają kwiaty i umieszczają je na wózku sklepowym. Następnie płacą za zawartość wózka i przepakowują ją do pudełka (jakiegoś pudełka na kwiaty).

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

### UTP3
1. zadanie1
Zadanie: ceny przelotów - lambda1

Lista dest zawiera informacje o cenach przelotów w postaci napisów:
```
port_wylotu port_przylotu cena_w_EUR
```
Należy utworzyć listę wynikową, której elementy będą opisywać ceny przelotów do poszczególnych miejsc (tylko) z Warszawy w PLN i wypisać na konsoli jej kolejne elementy.

Aby rozwiązać to zadanie, należy utworzyć sparametryzowaną klasę ListCreator, zawierającą:
statyczną metodę collectFrom (lista)
metodę when
metodę mapEvery
które działają w taki sposób, że symboliczny zapis:
```
 collectFrom(list).when(lambda-1).mapEvery(lambda-2)
```
spowoduje utworzenie listy wynikowej, której elementy stanowią wybrane przez lambda-1 elementy listy list, przekształcone za pomocą podanego lambda-2.

Uwagi: 
w zadaniu nie wolno korzystać z własnych interfejsów,
klasa ListCreator i jej metody powinny działać dla list (źródłowej i docelowej) elementów dowolnego typu.

Programma wyprowadzić na konsolę napisy:
to HAV - price in PLN:	5160
to DPS - price in PLN:	8600
to HKT - price in PLN:	4300

2. zadanie2
Zadanie: ceny przelotów - lambda2

Lista dest zawiera informacje o cenach przelotów w postaci napisów:
```
port_wylotu port_przylotu cena_w_EUR
```
Należy utworzyć listę wynikową, której elementy będą opisywać ceny przelotów do poszczególnych miejsc (tylko) z Warszawy w PLN i wypisać na konsoli jej kolejne elementy, używając następującego programu:
```
public class Main {

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = 
    /*<-- tu należy dopisać fragment
     * przy czym nie wolno używać żadnych własnych klas, jak np. ListCreator
     * ani też żadnych własnych interfejsów
     */

    for (String r : result) System.out.println(r);
  }
}
```
Program ma wyprowadzić na konsolę:
to HAV - price in PLN:	5160
to DPS - price in PLN:	8600
to HKT - price in PLN:	4300
