# KALKULATOR

Kalkulator obliczający wartość wyrażenia algebraicznego. Obsługuje operacje takie jak:
+, -, \*, \\ , zmienne i przypisanie zmiennych np. "n = 4, wartosc = 4 * n - 3, wartosc". Obsługuje podstawowe stałe matematyczne. Kalkulator umożliwia także
wczytanie wyrażenia z pliku.

## Użyte technolgie

- Java

## Opis słowny przypadków użycia

### Obliczenie

Użytkownik ma możliwość wpisania w kalkulatorze odpowiedniego równania z dowolną ilością znaków lub zmiennych po ich wcześniejszym przypisaniu. Wyrażenie program obliczy uwzględniając kolejność wykonywania działań matematycznych.

np.
```bash
n = 4, wartosc = 4 * n - 3, wartosc
```

### Wypisanie stałej

Użytkownik ma możliwość sprawdzenia wartości stałej używając wyrażenia:

```bash
@nazwastałej
```
np.
```bash
@pi
@e
```

### Wczytanie równania z pliku

Jest również możliwość wczytania odpowiedniego wyrażenia z pliku txt.

## Diagram przypadków użycia

![Schemat diagramu przypadków użycia](img/diagram_przypadkow.jpg)