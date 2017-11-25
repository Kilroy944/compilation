PRETTY PRINTER		    Manuel de l'utilisateur

NAME
	whpp - WHILE pretty printer

SYNOPSIS
	whpp [OPTIONS] source

DESCRIPTION
	Met en forme le contenu du fichier source. Celui-ci doit posséder l'extension .wh.

OPTIONS
	-o FICHIER
		Écrit le résultat dans FICHIER.
		Si -o n'est pas spécifiée, le résultat sera écrit dans un fichier ayant le même nom que le fichier d'entrée mais possédant l'extension .whpp.

	-all X	Règle le nombre d'espaces par indentation à X (par défaut 2).

	-if X, -while X, -for X, -foreach X
		Règle le nombre d'indentations à X pour une commande particulière.

	-test	Lance les tests.

	-help	Affiche ce manuel.

SEE ALSO
	whc

AUTHORS
	Vincent Bonhomme - Valentin Conseil - Valention Lion - Karim Oubah - Corentin Roche - Adrien Riou - Adrien Taja
