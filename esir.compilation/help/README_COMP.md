COMPILATEUR WHILE VERS GO		    Manuel de l'utilisateur

NAME
	whc - WHILE Compilateur
	

SYNOPSIS
	whc source [OPTIONS] 

DESCRIPTION
	Compile un fichier du langage While vers le langage Go. Le fichier doit posséder l'extension .wh et le compilateur Go doit être accessible 	par la commande go build.

OPTIONS

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

SEE ALSO
	whpp

AUTHORS
	Vincent Bonhomme - Valentin Conseil - Valentin Lion - Karim Oubah - Corentin Roche - Adrien Riou - Adrien Taja
