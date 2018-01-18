package main
import (libWH "./libGO"
	"fmt"
	"os"
	 "strconv"
)
var s0 *libWH.Tree

func main(){

	nbOut := 3
	if (len(os.Args)-1)>=nbOut {
		i1, err1 := strconv.Atoi(os.Args[1])
		i2, err2 := strconv.Atoi(os.Args[2])
		i3, err3 := strconv.Atoi(os.Args[3])

		if err1 == nil && err2 == nil && err3 == nil {
			v0,v1,v2,v3:=f1(libWH.NumberToTree(i1),libWH.NumberToTree(i2),libWH.NumberToTree(i3))
			fmt.Println(libWH.TreeToNumber(v0))
			fmt.Println(libWH.TreeToNumber(v1))
			fmt.Println(libWH.TreeToNumber(v2))
			fmt.Println(libWH.TreeToNumber(v3))
		}else{
			fmt.Println("L'un des arguments n'est pas un nombre")
		}
	}else{
		fmt.Println("Nombre d'arguments incorrect") 
	}
}

func f0(v0 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree
_ = vt0

vt0 = libWH.Hd(v0)

v0 = vt0


return v0 
}

func f1(v0, v1, v2 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {

var v3 *libWH.Tree
_ = v3
var v4 *libWH.Tree
_ = v4
var vt0 *libWH.Tree
_ = vt0
var vt1 *libWH.Tree
_ = vt1
var vt2 *libWH.Tree
_ = vt2
var vt3 *libWH.Tree
_ = vt3
var vt4 *libWH.Tree
_ = vt4
var vt5 *libWH.Tree
_ = vt5
var vt6 *libWH.Tree
_ = vt6
var vt7 *libWH.Tree
_ = vt7
var vt8 *libWH.Tree
_ = vt8
var vt9 *libWH.Tree
_ = vt9


if libWH.IsTrue(s0){
   vt0 = C
   vt1 = B
   v0 = v2
   v1 = v1
   vt2 = C
   v0 = v2
   vt3 = A
   vt4 = X
   v1 = v0
   v2 = v3

}else{
   for _,v2 := range libWH.TreeToRange(v0){
      _ = v2
      vt5 = libWH.Cons(v0,v1)

      for i:=0;i<libWH.TreeToNumber(vt5);i++ {
         vt7 = libWH.Op_and(v0,v1)
         vt8 = libWH.Op_or(v0,v1)
         vt6 = libWH.Op_and(vt7,vt8)

         if libWH.IsTrue(vt6){
            for libWH.IsTrue(v0){
            
            }
         }
      }
   }
}
vt9=f0(v0)

v0 = vt9


return v0,v1,v2,v4 
}
