package libWH

import "strings"	

type Tree struct {
	Symbol string
	Left  *Tree
	Right *Tree
}
func TreeToNumber ( t *Tree)(int){
	var counter = 0

	for t.Symbol=="" {
    		counter++
    		t = t.Right
	}
	
	return counter
}
func TreeToRange (t *Tree)([] *Tree){
	var tab = [](*Tree){}
	for t.Symbol=="" {
    		tab = append(tab,t.Right)
    		t = t.Right
	}
	return tab
}
func NumberToTree(nb int)(*Tree){
	var t *Tree = &(Tree{"nil",nil,nil})	
	for i := 0; i < nb; i++ {
		t = Cons(&(Tree{"nil",nil,nil}),t)
	}
	return t
}
func Tl(t *Tree)(*Tree){
	if t.Symbol=="" {
		return t.Right
	}
	return &(Tree{"nil",nil,nil})
}
func Hd(t *Tree)(*Tree){
	if t.Symbol=="" {
		return t.Left
	}
	return &(Tree{"nil",nil,nil})
}
func Cons(g *Tree,d *Tree)(*Tree){
	return &(Tree{"",g,d})
}
func IsTrue (t *Tree)(bool){
	if t.Symbol=="nil" {
		return false
	}
	
	return true
}
func Op_or (t1,t2 *Tree)(*Tree){
    if(IsTrue(t1) || IsTrue(t2)){
   	 return &(Tree{"",&(Tree{"nil",nil,nil}),&(Tree{"nil",nil,nil})})
    }
    return &(Tree{"nil",nil,nil})
}
func Op_eg (t1,t2 *Tree)(*Tree){

	if (t1.Symbol != t2.Symbol ) {
		return &(Tree{"nil",nil,nil})	
	}else if (t1.Symbol=="" && t2.Symbol=="") {
	   var x =  Op_eg(t1.Right,t2.Right)
	   var y =  Op_eg(t1.Left,t2.Left)
	
	   if x.Symbol != "nil" && y.Symbol != "nil" {
	  	return &(Tree{"",&(Tree{"nil",nil,nil}),&(Tree{"nil",nil,nil})})
	   }else{
		return &(Tree{"nil",nil,nil})
	   }
	}else{
	  return &(Tree{"",&(Tree{"nil",nil,nil}),&(Tree{"nil",nil,nil})})
	}
}
func Op_not (t *Tree)(*Tree){
    if IsTrue(t){
	return &(Tree{"nil",nil,nil})
    }
	return &(Tree{"",&(Tree{"nil",nil,nil}),&(Tree{"nil",nil,nil})})

}
func Op_and (t1,t2 *Tree)(*Tree){
    if(IsTrue(t1) && IsTrue(t2)){
	return &(Tree{"",&(Tree{"nil",nil,nil}),&(Tree{"nil",nil,nil})})
    }
    return &(Tree{"nil",nil,nil})
}

func TextToTree (s string) (*Tree){
// 3 =  "(cons (nil) (cons (nil) (cons (nil) (nil))))"
// 0 =  (nil) "
//Sensible aux espaces et aux nombres parenthèses
	var treeReturn *Tree
	treeReturn = &(Tree{"",nil,nil})
	 

	if s=="(nil)"{
		return &(Tree{"nil",nil,nil})
	}
	var runes = []rune(s)
	
    	s = string(runes[1:len(s)])
	
	//param gauche
	var x = strings.Index(s,"(")+1
	
	var nbOuv int 
	nbOuv = 1
	var nbFerm int 
	nbFerm = 0
	
	var index int
	index = x
	var c string
	var fin bool
	fin = true 
	for fin {
		c = string(s[index])		
		if c == ")" {
			nbFerm = nbFerm+1
		}
		if c == "(" {
			nbOuv = nbOuv+1
		}
		index = index + 1
		if nbOuv == nbFerm {
			fin = false
		}	
	}
	runes = []rune(s)
	
    	var subLeft = string(runes[x-1:index])
	treeReturn.Left = TextToTree(subLeft)		

	//param droite

	var subRight = string(runes[index+1:len(s)-1])
	treeReturn.Right = TextToTree(subRight)


	return treeReturn	
}

func PrintTree (t *Tree) (string){

	if t.Symbol == "nil" {
		return "nil"
	}
	if t.Symbol != "" {
		return t.Symbol
	}
	var result string
	result = "(cons "
	result += PrintTree(t.Left)	
	result += " "
	result += PrintTree(t.Right)
	result +=")"

	return result
}


