# Projet compilation - ESIR 2

# Pretty Printer While

Manuel de l'utilisateur

NAME : whpp - WHILE pretty printer

SYNOPSIS : whpp [OPTIONS] source

DESCRIPTION : Met en forme le contenu du fichier source. Celui-ci doit posséder l'extension .wh.

OPTIONS :

  -o FICHIER Écrit le résultat dans FICHIER. Si -o n'est pas spécifiée, le résultat sera écrit dans un fichier ayant le même nom que le fichier d'entrée mais possédant l'extension .whpp.

  -all X	Règle le nombre d'espaces par indentation à X (par défaut 2).

  -if X, -while X, -for X, -foreach X
    Règle le nombre d'indentations à X pour une commande particulière.

  -test REP_SOURCE REP_FORMATE
    Formate tous les fichiers contenus dans REP_SOURCE et vérifie qu'ils sont égaux à ceux dans REP_FORMATE. Ne modifie pas REP_SOURCE.

  -help	Affiche ce manuel.

# Compilateur While > Go

Manuel de l'utilisateur

NAME : whc - WHILE Compilateur

SYNOPSIS : whc source [OPTIONS]

DESCRIPTION : Compile un fichier du langage While vers le langage Go. Le fichier doit posséder l'extension .wh et le compilateur Go doit être accessible par la commande go build.

OPTIONS :

   -o X
    Permet de spécifier le nom de l'exécutable
    Si -o n'est pas spécifiée, l'exécutable porte le nom du fichier .wh passé en paramètre
    L'exécutable peut prendre en paramètre soit des nombres soit des arbres
    Exemple:
      ./exemple 3
      ./exemple "(cons (nil) (cons (nil) (cons (nil) (nil))))"
      
  -f3a
    Génère le fichier en code 3 adresses du programme While passé en paramètre
    
  -fGo 
    Génère le fichier .go correspondant au programme While passé en paramètre ainsi que la librairie libWH		
    
  -help	Affiche ce manuel.
  
AUTHORS Vincent Bonhomme - Valentin Conseil - Valentin Lion - Karim Oubah - Corentin Roche - Adrien Riou - Adrien Taja

