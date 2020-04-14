# FastKotlinApp
Aplikacja kotlinowa na Ubiquitous Computing

Aplikacja posiada 3 ekrany umożliwiające wybranie algorytmu, poznanie fazy i następnej/poprzedniej pełni/nowiu, a także 
możliwość poznania pełni w roku, który przeminał, albo roku, który nadejdzie, ale wtedy i tylko wtedy, gdy rok ten zawiera się
w przedziale <1900;2200> - inne lata bowiem nie są akceptowane.

W projekcie jest jedna kontrowersyjna decyzja - pełnia na ekranie "Pełnie w roku" jest szukana zawsze algorytmem Trygonometrycznym2:
dzięki temu zawsze można wyznaczyć pełnię dla dawnego/przyszłego roku (to nie musi być prawdziwe dla Conwaya i algorytmu prostego).
Po zamianie 22 i 29 linijki w kodzie YearCalculationsActivity.kt na zakomentowaną linijkę powyżej można uzyskać wyznaczone 
pełnie dla innego algorytmu, przy czym te nie muszą (i pewnie nie będą) poprawne, być może nawet nie będą istnieć (lata 1900-1970 
dla algorytmu prostego na przykład)
