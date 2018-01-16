package libWH
type Tree struct {
	Left  *Tree
	Right *Tree
}
func TreeToNumber ( t *Tree)(int){
	var counter = 0
	for t != nil {
    	counter++
    	t = t.Right
	}
	return counter
}
func TreeToRange (t *Tree)([] *Tree){
	var tab = [](*Tree){}
	for t != nil {
    	tab = append(tab,t.Right)
    	t = t.Right
	}
	return tab
}
func Tl(t *Tree)(*Tree){
	if t!=nil{
		return t.Right
	}
	return nil
}
func Hd(t *Tree)(*Tree){
	if t!=nil{
		return t.Left
	}
	return nil
}
func Cons(g *Tree,d *Tree)(*Tree){
	return &(Tree{g,d})
}
func IsTrue (t *Tree)(bool){
	return t!=nil
}
func Op_or (t1,t2 *Tree)(*Tree){
    if(IsTrue(t1) || IsTrue(t2)){
   	 return &(Tree{nil,nil})
    }
    return nil
}
func Op_eg (t1,t2 *Tree)(*Tree){
	
	


}
func Op_not (t *Tree)(*Tree){
    if IsTrue(t){
   	 return nil
    }
    return &(Tree{nil,nil})
}
func Op_and (t1,t2 *Tree)(*Tree){
    if(IsTrue(t1) && IsTrue(t2)){
   	 return &(Tree{nil,nil})
    }
    return nil
}
