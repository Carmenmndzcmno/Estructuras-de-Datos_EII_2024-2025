# Estructuras-de-Datos_EII
Entrega de los trabajos de la asignatura de _Estructuras de Datos_ del curso 2024/25 en la EII.
<img width="400" height="200" alt="image_gallery" src="https://github.com/user-attachments/assets/3755ca6f-630e-4e38-a4ed-96b6ec1d3c19" />

## Proyecto 1: Recursividad y Algoritmia [9,79 / 10,00]

## Proyecto 2: Grafos [10,00 / 10,00]

## Proyecto 3: Árboles [6,24 / 10,00]
**Comentarios de retroalimentación que me dieron**:  
BSTree
Nota: 5,8

AVL:
Nota: 5,14

MONTÍCULOS
Nota: 10

Proyecto 3
Nota (a falta de control de plagios): 6,24] 

**Log de la retroalimentación**: 
BSTree:
Nota: 5,8
Falla add
org.opentest4j.AssertionFailedError: expected: <Element to insert is null.> but was: <null>

Fallan recorridos
org.opentest4j.AssertionFailedError: inOrder en arbol:
5
			4
		3
					2
				1
					0
						-1
			-2
				-3
	-4
 ==> expected: <-4	-3	-2	-1	0	1	2	3	4	5	> but was: <	-4	-3	-2	-1	0	1	2	3	4	5>

org.opentest4j.AssertionFailedError: postOrder en arbol:
		[9:9-nueve]
				[8:8-ocho]
			[7:7-siete]
						[6:6-seis]
					[5:5-cinco]
						[4:4-cuatro]
				[3:3-tres]
	[2:2-dos]
[1:1-Uno]
	[0:0-cero]
 ==> expected: <[0:0-cero]	[4:4-cuatro]	[6:6-seis]	[5:5-cinco]	[3:3-tres]	[8:8-ocho]	[7:7-siete]	[9:9-nueve]	[2:2-dos]	[1:1-Uno]	> but was: <	[0:0-cero]	[4:4-cuatro]	[6:6-seis]	[5:5-cinco]	[3:3-tres]	[8:8-ocho]	[7:7-siete]	[9:9-nueve]	[2:2-dos]	[1:1-Uno]>

org.opentest4j.AssertionFailedError: postOrder en arbol:
		90
			80
				70
	60
		50
40
		30
	20
		10
 ==> expected: <10	30	20	50	70	80	90	60	40	> but was: <	10	30	20	50	70	80	90	60	40>

Falla remove
org.opentest4j.AssertionFailedError: expected: <Element to remove is null.> but was: <Nodo nulo>




AVL:
Nota: 5,14
Falla add
org.opentest4j.AssertionFailedError: expected: <Element to insert is null.> but was: <Nodo nulo>


Fallan recorridos
org.opentest4j.AssertionFailedError: postOrder() en arbol:
			200:BF=0
		190:BF=1
	180:BF=0
			170:BF=0
		160:BF=0
			150:BF=0
140:BF=0
			130:BF=0
		120:BF=0
			110:BF=0
	40:BF=0
			30:BF=0
		20:BF=0
			10:BF=0
 ==> expected: <10:BF=0	30:BF=0	20:BF=0	110:BF=0	130:BF=0	120:BF=0	40:BF=0	150:BF=0	170:BF=0	160:BF=0	200:BF=0	190:BF=1	180:BF=0	140:BF=0	> but was: <	10:BF=0	30:BF=0	20:BF=0	110:BF=0	130:BF=0	120:BF=0	40:BF=0	150:BF=0	170:BF=0	160:BF=0	200:BF=0	190:BF=1	180:BF=0	140:BF=0>

org.opentest4j.AssertionFailedError: inOrder() en arbol:
			200:BF=0
		190:BF=1
	180:BF=0
			170:BF=0
		160:BF=0
			150:BF=0
140:BF=0
			130:BF=0
		120:BF=0
			110:BF=0
	040:BF=0
			030:BF=0
		020:BF=0
			010:BF=0
 ==> expected: <010:BF=0	020:BF=0	030:BF=0	040:BF=0	110:BF=0	120:BF=0	130:BF=0	140:BF=0	150:BF=0	160:BF=0	170:BF=0	180:BF=0	190:BF=1	200:BF=0	> but was: <	010:BF=0	020:BF=0	030:BF=0	040:BF=0	110:BF=0	120:BF=0	130:BF=0	140:BF=0	150:BF=0	160:BF=0	170:BF=0	180:BF=0	190:BF=1	200:BF=0>

org.opentest4j.AssertionFailedError: postOrder() en arbol:
			[14:14-catorce]:BF=0
		[13:13-trece]:BF=1
	[12:12-doce]:BF=0
			[11:11-once]:BF=0
		[10:10-diez]:BF=0
			[9:09-nueve]:BF=0
[7:07-siete]:BF=0
		[5:05-cinco]:BF=0
	[3:03-tres]:BF=-1
			[2:02-dos]:BF=0
		[1:01-Uno]:BF=0
			[0:00-cero]:BF=0
 ==> expected: <[0:00-cero]:BF=0	[2:02-dos]:BF=0	[1:01-Uno]:BF=0	[5:05-cinco]:BF=0	[3:03-tres]:BF=-1	[9:09-nueve]:BF=0	[11:11-once]:BF=0	[10:10-diez]:BF=0	[14:14-catorce]:BF=0	[13:13-trece]:BF=1	[12:12-doce]:BF=0	[7:07-siete]:BF=0	> but was: <	[0:00-cero]:BF=0	[2:02-dos]:BF=0	[1:01-Uno]:BF=0	[5:05-cinco]:BF=0	[3:03-tres]:BF=-1	[9:09-nueve]:BF=0	[11:11-once]:BF=0	[10:10-diez]:BF=0	[14:14-catorce]:BF=0	[13:13-trece]:BF=1	[12:12-doce]:BF=0	[7:07-siete]:BF=0>

Falla remove
org.opentest4j.AssertionFailedError: expected: <Element to remove is null.> but was: <Nodo nulo>

org.opentest4j.AssertionFailedError: Arbol anterior:
[11:null]:BF=0
removeNode(new Informacion(11,11-once))Arbol posterior:
[11:null]:BF=0
 ==> expected: <true> but was: <false>

org.opentest4j.AssertionFailedError: remove(190) en arbol:
			200:BF=0
		180:BF=-1
			170:BF=0
	160:BF=1
		150:BF=0
140:BF=0
			130:BF=0
		120:BF=0
			110:BF=0
	40:BF=0
			30:BF=0
		20:BF=0
			10:BF=0
 ==> expected: <false> but was: <true>

org.opentest4j.AssertionFailedError: remove(2) en arbol:
1:BF=-1
	-21:BF=0
 ==> expected: <false> but was: <true>

org.opentest4j.AssertionFailedError: Arbol anterior:
			200:BF=0
		190:BF=1
	180:BF=0
			170:BF=0
		160:BF=0
			150:BF=0
140:BF=0
			130:BF=0
		120:BF=0
			110:BF=0
	040:BF=0
			030:BF=0
		020:BF=0
			010:BF=0
removeNode(140)
Arbol posterior:
			200:BF=0
		190:BF=1
	180:BF=0
			170:BF=0
		160:BF=0
			150:BF=0
130:BF=0
			120:BF=0
		110:BF=1
	040:BF=-1
			030:BF=0
		020:BF=0
			010:BF=0
 ==> expected: <130:BF=0 040:BF=0 020:BF=0 010:BF=0 _ _ 030:BF=0 _ _ 120:BF=-1 110:BF=0 _ _ _ 180:BF=0 160:BF=0 150:BF=0 _ _ 170:BF=0 _ _ 190:BF=1 _ 200:BF=0 _ _ > but was: <130:BF=0 040:BF=-1 020:BF=0 010:BF=0 _ _ 030:BF=0 _ _ 110:BF=1 _ 120:BF=0 _ _ 180:BF=0 160:BF=0 150:BF=0 _ _ 170:BF=0 _ _ 190:BF=1 _ 200:BF=0 _ _ >

org.opentest4j.AssertionFailedError: Arbol anterior:
			[14:14-catorce]:BF=0
		[13:13-trece]:BF=1
	[12:12-doce]:BF=0
			[11:11-once]:BF=0
		[10:10-diez]:BF=0
			[9:09-nueve]:BF=0
[7:07-siete]:BF=0
		[5:05-cinco]:BF=0
	[3:03-tres]:BF=-1
			[2:02-dos]:BF=0
		[1:01-Uno]:BF=0
			[0:00-cero]:BF=0
removeNode(new Informacion(5))
Arbol posterior:
			[14:14-catorce]:BF=0
		[13:13-trece]:BF=1
	[12:12-doce]:BF=0
			[11:11-once]:BF=0
		[10:10-diez]:BF=0
			[9:09-nueve]:BF=0
[7:07-siete]:BF=0
	[3:03-tres]:BF=-3
			[2:02-dos]:BF=0
		[1:01-Uno]:BF=0
			[0:00-cero]:BF=0
 ==> expected: <[7:07-siete]:BF=0 [1:01-Uno]:BF=1 [0:00-cero]:BF=0 _ _ [3:03-tres]:BF=-1 [2:02-dos]:BF=0 _ _ _ [12:12-doce]:BF=0 [10:10-diez]:BF=0 [9:09-nueve]:BF=0 _ _ [11:11-once]:BF=0 _ _ [13:13-trece]:BF=1 _ [14:14-catorce]:BF=0 _ _ > but was: <[7:07-siete]:BF=0 [3:03-tres]:BF=-3 [1:01-Uno]:BF=0 [0:00-cero]:BF=0 _ _ [2:02-dos]:BF=0 _ _ _ [12:12-doce]:BF=0 [10:10-diez]:BF=0 [9:09-nueve]:BF=0 _ _ [11:11-once]:BF=0 _ _ [13:13-trece]:BF=1 _ [14:14-catorce]:BF=0 _ _ >

MONTÍCULOS
Nota: 10
Insertar:
Ok
Sacar:
Ok
Borrar:
Ok
General:
Ok

## Proyecto 4: Tablas Hash [9,42 / 10,00]
**Comentarios de retroalimentación**:  
"HASH

Elementos:

Ok

Exploraciones:

Falla add en cuadrática

org.opentest4j.AssertionFailedError: Tabla antes:

{0};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 1]

 add(11)

Tabla despues:

{0};{_E_};{_E_};{11};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 2]

 ==> expected: <{0};{11};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 2]> but was: <{0};{_E_};{_E_};{11};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};{_E_};[Size: 11 Num.Elems.: 2]>

Redispersión:

Ok

Busquedas:

Ok

General:

Ok

Ev.Continua:

Nota Proyecto 4: 9,42
"# Estructuras-de-Datos_EII_2024-2025" 
