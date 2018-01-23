package main
import (libWH "./libGO"
	"fmt"
	"os"
	"strconv"
)
var s0 *libWH.Tree
var s1 *libWH.Tree
var s2 *libWH.Tree

func main(){
s0=&(libWH.Tree{"nil",nil,nil})
s1=&(libWH.Tree{"toto",nil,nil})
s2=&(libWH.Tree{"totoh",nil,nil})

	nbOut := 5
	if (len(os.Args)-1)>=nbOut {
		i1, err1 := strconv.Atoi(os.Args[1])
		i2, err2 := strconv.Atoi(os.Args[2])
		i3, err3 := strconv.Atoi(os.Args[3])
		i4, err4 := strconv.Atoi(os.Args[4])
		i5, err5 := strconv.Atoi(os.Args[5])

		if err1 == nil && err2 == nil && err3 == nil && err4 == nil && err5 == nil {
			v0,v1,v2,v3,v4:=f9(libWH.NumberToTree(i1),libWH.NumberToTree(i2),libWH.NumberToTree(i3),libWH.NumberToTree(i4),libWH.NumberToTree(i5))
			fmt.Println(libWH.TreeToNumber(v0))
			fmt.Println(libWH.TreeToNumber(v1))
			fmt.Println(libWH.TreeToNumber(v2))
			fmt.Println(libWH.TreeToNumber(v3))
			fmt.Println(libWH.TreeToNumber(v4))
		}else{
			fmt.Println("L'un des arguments n'est pas un nombre")
		}
	}else{
		fmt.Println("Nombre d'arguments incorrect") 
	}
}

func f0(v0 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

vt0 = libWH.Tl(v0)

v0 = vt0


return v0 
}

func f1(v0, v1, v2, v3, v4 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {




return v4,v3,v2,v1,v0 
}

func f2(v0, v1 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var v3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v3
var v4 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v4
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0
var vt1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt1
var vt2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt2
var vt3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt3

vt0 = libWH.Op_eg(s1,s1)

v2 = vt0

vt1 = libWH.Op_eg(s2,s1)

v3 = vt1

vt2 = libWH.Op_eg(v0,v1)

v4 = vt2

vt3 = libWH.Op_eg(v2,v1)

v0 = vt3


return v2,v3,v4,v0 
}

func f3(v0, v1 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var v3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v3
var v4 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v4
var v5 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v5
var v6 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v6
var v7 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v7
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0
var vt1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt1
var vt2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt2
var vt3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt3
var vt4 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt4
var vt5 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt5

vt1 = libWH.Op_and(v0,v1)
vt0 = libWH.Op_or(vt1,v2)

v2 = vt0

vt2 = libWH.Op_or(v2,v1)

v3 = vt2

vt3 = libWH.Op_or(v4,v2)

v5 = vt3

vt4 = libWH.Op_and(v4,v2)

v0 = vt4

vt5 = libWH.Op_and(v6,v7)

v1 = vt5


return v0,v1,v2,v3,v5 
}

func f4(v0 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

for libWH.IsTrue(v0){
   vt0=f0(v0)

   v0 = vt0

}

return v0 
}

func f5(v0, v1 *libWH.Tree) (*libWH.Tree, *libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

var vt1 int
vt1=libWH.TreeToNumber(v0)
for i:=0;i<vt1;i++ {
   vt0=f0(v1)

   v1 = vt0

   v0 = v2

}

return v0,v1 
}

func f6(v0, v1, v2 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree) {

var v3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v3
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

v0 = v1

vt0 = v1

v1 = v2

v0 = vt0

v2 = v3


return v0,v1,v2 
}

func f7(v0, v1 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0


if libWH.IsTrue(v0){
   v0 = v1

}else{
   vt0=f0(v1)
   v0 = vt0

}

return v0 
}

func f8(v0, v1 *libWH.Tree) (*libWH.Tree, *libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

v2 = v1

for _,v0 := range libWH.TreeToRange(v1){
   _ = v0
   vt0=f0(v2)

   v2 = vt0

}

return v2,v0 
}

func f9(v0, v1, v2, v3, v4 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {

var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0
var vt1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt1
var vt2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt2
var vt3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt3
var vt4 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt4

vt0,vt1,vt2,vt3,vt4=f1(v0,v1,v2,v3,v4)

vt0,vt1,vt2,vt3,vt4=f1(v0,v1,v2,v3,v4)

vt0,vt1,vt2,vt3,vt4=f1(v0,v1,v2,v3,v4)

vt0,vt1,vt2,vt3,vt4=f1(v0,v1,v2,v3,v4)

vt0,vt1,vt2,vt3,vt4=f1(v0,v1,v2,v3,v4)

v0 = vt0

v1 = vt1

v2 = vt2

v3 = vt3

v4 = vt4


return v0,v1,v2,v3,v4 
}
