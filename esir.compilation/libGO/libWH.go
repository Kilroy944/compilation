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
func NumberToTree(nb int)(*Tree){
	var t *Tree	
	for i := 0; i < nb; i++ {
		t = Cons(nil,t)
	}
	return t
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
	
	if (t1==nil && t2==nil) {
		return &(Tree{nil,nil})	
	}else if (t1!=nil && t2!=nil) {
	   if Op_eg(t1.Right,t2.Right)!= nil && Op_eg(t1.Left,t2.Left) !=nil {
		return &(Tree{nil,nil})	
	   }else{
		return nil
	   }
	}else{
	  return nil
	}
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
