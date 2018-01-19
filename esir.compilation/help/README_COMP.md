COMPILATEUR WHILE		    Manuel de l'utilisateur

NAME
	whc - WHILE Compilateur
	

SYNOPSIS
	whc source [OPTIONS] 

DESCRIPTION
	Compile un fichier en langage While par l'intermédiare du langage Go. Le fichier doit posséder l'extension .wh et le compilateur Go doit être accessible par la commande go build.

OPTIONS

	-o X
		Permet de spécifier le nom des fichiers de sortie
		Si -o n'est pas spécifiée, les fichiers de sortie portent le nom du fichier .wh passé en paramètre 
	-f3a
		Génère un fichier en code 3 adresses du programme While lors de la compilation
	-fGo 
		Génère un fichier en langage Go du programme While lors de la compilation
	-test REP_SOURCE REP_FORMATE
		Que font les tests ????

	-help	Affiche ce manuel.

SEE ALSO
	whpp

AUTHORS
	Vincent Bonhomme - Valentin Conseil - Valention Lion - Karim Oubah - Corentin Roche - Adrien Riou - Adrien Taja
