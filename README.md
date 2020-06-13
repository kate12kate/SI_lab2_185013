# Втора лабораториска вежба по Софтверско инженерство
## Катерина Глигоровска, бр. на индекс 185013
### Група на код:
Ја добив групата број 6
### Control Flow Graph
![Control Flow](https://user-images.githubusercontent.com/44732265/84551798-fc2a4f00-ad0e-11ea-852c-cfe2eddc1691.png)
### Цикломатска комплексност
Цикломатската комплексност на овој код е 7. Истата ја добив со пресметување на бројот на јазли и ребра. Број на јазли N=22, број на ребра E=27. Според формулата E-N+2 = 27-22+2=7.
### Тест случаи според критериумот Every Statement
![excel-every statement](https://user-images.githubusercontent.com/44732265/84552261-6db6cd00-ad10-11ea-9267-c60e9892c1cb.png)
### Тест случаи според критериумот Multiple Condition
Имаме четири if-ови со multiple condition:
1.	If( deg >=0 && deg <360) 
2.	If( min<0 || min>59)
3.	If(sec <0 || sec >59)
4.	 if(min==0 && sec ==0)
( deg >=0 && deg <360)
F && X -> deg < 0 – odi vo else kade sto frla exception
T && F -> deg >= 360. Ako e 360 odi vo else ifot kade sto pravi уште една проверка. Ако е > 360 фрла exception
T && T -> 0<=deg<360 – поминува ifot и оди надоле по програмата
(min < 0 || min>59)
T || X -> min<0 - exception
F || T -> min>59 - exception
F || F -> 0<=min<=59 – ifot не поминува, немаме exception, и одиме надоле по програмата.
(sec <0 || sec >59)
T || X -> sec<0 – exception 
F || T -> sec>59 – exception 
F || F -> 0<=sec<=59 – ifot не поминува, немаме exception, правиме пресметка
(min==0 && sec ==0) – во овој if стигаме само ако deg=360
F && X -> min != 0, sec = anything – ifot Не поминува, имаме еxception
T && F -> min=0, sec != 0 – ifot не поминува, имаме еxception
T && T -> min=0,sec=0 – ifot поминува, немаме еxception, правиме пресметка

### Објаснување на напишаните unit tests
#### За првиот, every statement 

#### За вториот, multiple condition
Можни услови:
1.	If( deg >=0 && deg <360) 
2.	If( min<0 || min>59)
3.	If(sec <0 || sec >59)
4.	 if(min==0 && sec ==0)
- 1.1)	Ако првиот if е false и било што – тогаш: F && X iмаме false 

- 1.2)	 Ако првиот if e true и false – тогаш имаме T && F =FALSE  

- 1.3)	 Ако првиот if e true и true – тогаш: T && T имаме true->  пример deg=50 и сега влегуваме во вториот(2) if и тука имаме следни услови:

- 2.1) ако вториот if e true или било пто тогаш: T || X -> TRUE ( пример deg:50 и min=-43)  тогаш имаме runtimeexception.
      -  2.2) Ако вториот if e False || True, тогаш добиваме TRUE, односно повторно exception
       - 2.3)  Ако вториот if e false || false, тогаш добиваме False, односно имаме на приемр : deg=50, min=45 , сега продолжуваме со третиот if. Тука ги имаме следниве можни услови:
            -- 3.1) ако во третиот If имаме T(true) || X=TRUE -тука имаме exception
            -- 3.2) ако имаме  F || T =TRUE, повторно имаме exception
            -- 3.3) ако имаме F||F тошаш имаме false и ни се изврушува овој if однсоно се пресметува резултатот и се става во листата.

- Доколку падне улосвот 1.1 и 1.2 одиме во else if каде што степените треба да се 360 за да можеме да влеземе во 4-тиот услов. Во 4тиот услов ги имаме следните можности:
- 4.1) ако имаме F&&X=FALSE, т.е ако имаме min=5, тоа не е еднакво на нула и одма ни фрла exception
- 4.2) ако имаме T && F = FALSE, односно ако имаме Min=0 I sec=6, секундите не се нула па повторно имаме exception
- 4.3) ако имаме T &&T =TRUE, и тука се изврушва овој услов односно Min=0 && sec=0 и тој резултат го запишуваме во листата.
- Ако првиот if е false, т.е падне, оди во else if, но ако и овој услов else if(deg==360) е false, oди во последниот else  каде што ни фрла exception.

Во кодот имам функција која се вика testmultiplecondition, во неа ги проверувам сите услови.
