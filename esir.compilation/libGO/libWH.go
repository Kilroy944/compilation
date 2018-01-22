package libWH

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
	return &(Tree{"",&(Tree{"nil",nil,nil}),&(Tree{"nil",nil,nil})})
    }
    return &(Tree{" ",nil,nil})
}
func Op_and (t1,t2 *Tree)(*Tree){
    if(IsTrue(t1) && IsTrue(t2)){
	return &(Tree{"",&(Tree{"nil",nil,nil}),&(Tree{"nil",nil,nil})})
    }
    return &(Tree{"nil",nil,nil})
}
