package main
import (libWH "./libGO")
var s0 *libWH.Tree

func main(){
	f1(nil,nil,nil)
}

func f0(v0 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree

vt0 = libWH.Hd(v0)

v0 = vt0


return v0 
}

func f1(v0, v1, v2 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {

var v3 *libWH.Tree
var vt0 *libWH.Tree
var vt1 *libWH.Tree
var vt2 *libWH.Tree
var vt3 *libWH.Tree
var vt4 *libWH.Tree
var vt5 *libWH.Tree
var vt6 *libWH.Tree
var vt7 *libWH.Tree


if libWH.IsTrue(s0){
   vt0 = libWH.Hd(v2)
   v0 = vt0
   vt1 = libWH.Hd(v0)
   vt2 = libWH.Cons(vt1,v1)
   v1 = vt2

}else{
   for _,v2 := range libWH.TreeToRange(v0){
      _ = v2
      vt3 = libWH.Cons(v0,v1)

      for i:=0;i<libWH.TreeToNumber(vt3);i++ {
         vt5 = libWH.Op_and(v0,v1)
         vt6 = libWH.Op_or(v0,v1)
         vt4 = libWH.Op_and(vt5,vt6)

         if libWH.IsTrue(vt4){
            for libWH.IsTrue(v0){
            
            }
         }
      }
   }
}
vt7=f0(v0)

v0 = vt7


return v0,v1,v2,v3 
}
