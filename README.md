# second chance page changing algorithm
Fakultatív feladat: lapcsere megvalósítása
Becsült programozási idő: ~5 óra

A feladatbeküldés általános és FONTOS tudnivalói elolvashatók itt.

Készítsen egy programot Java vagy Python nyelven, amely egy lapcsere-rendszer működését szimulálja!

A program bemeneteként memóriaműveletek során hivatkozott lapok azonosítóit kapja a hivatkozásuk sorrendjében. Kimeneteként a végrehajtott lapcserék eredményeképpen lefoglalt fizikai memóriakeretek azonosítóit és a laphibák számát adja vissza.

A rendszerben 4 memóriakeret található, amelyek kezdetben mind üresek. Az induláskor a lapok a cserehelyen találhatók.

A lapokat számok (1-99), a kereteket betűk (A,B,C és D) jelölik.

Bemenet (standard input, stdin)
Egyetlen sorban a lapokra történő hivatkozások egymástól vesszővel elválasztva. Például:

1,2,3,4,1,5,1
A bemenet végét EOF jelzi (előtte soremelés, üres sor lehet). Ekkor kell a kimenetre kiírni az eredményt.

Kimenet (standard output, stdout)
A kimeneten az első sorban a bemeneti memóriahivatkozások kiszolgálásához lefoglalt memóriakeretek betűjelei szerepelnek a megfelelő sorrendben, szóközök nélkül, egybeírva, majd a következő sorban a laphibák száma. A kiírt eredmények előtt, után üres karakterek, további sorok ne legyenek!
Amennyiben egy memóriahivatkozáshoz nem kellett új keretet foglalni (már a memóriában volt a lap), a kimeneten az adott pozícióban "-" jel jelenik meg.
Ha egy memóriafoglalás nem teljesíthető (nincs szabad keret és egyetlen keret sem szabadítható fel), akkor a kimeneten "*" karakter jelenik meg (a műveletet nem ismétli meg az algoritmus).

Megvalósítandó algoritmus
Újabb esély (SC) lapcsere

A program írja ki az algoritmus szerinti memóriafoglalásokat és a laphibák számát!
Pl. a fenti bemenetre adott válasz:

ABCD-B-
5
