package main
import (libWH "./libGO"
	"fmt"
	"os"
	"strconv"
)
var s0 *libWH.Tree
var s1 *libWH.Tree

func main(){
s0=&(libWH.Tree{"nil",nil,nil})
s1=&(libWH.Tree{"toto",nil,nil})

	nbOut := 3
	if (len(os.Args)-1)>=nbOut {
		i1, err1 := strconv.Atoi(os.Args[1])
		 _ = i1
		i2, err2 := strconv.Atoi(os.Args[2])
		 _ = i2
		i3, err3 := strconv.Atoi(os.Args[3])
		 _ = i3
		var vi1 = libWH.NumberToTree(i1)
		var vi2 = libWH.NumberToTree(i2)
		var vi3 = libWH.NumberToTree(i3)

		if err1 != nil {
 			vi1 =  libWH.TextToTree(os.Args[1])
			 _ = i1
		}

		if err2 != nil {
 			vi2 =  libWH.TextToTree(os.Args[2])
			 _ = i2
		}

		if err3 != nil {
 			vi3 =  libWH.TextToTree(os.Args[3])
			 _ = i3
		}
		v0,v1,v2,v3,v4,v5:=f0(vi1,vi2,vi3)
		fmt.Println(libWH.TreeToNumber(v0))
		fmt.Println(libWH.PrintTree(v0))
		fmt.Println(libWH.TreeToNumber(v1))
		fmt.Println(libWH.PrintTree(v1))
		fmt.Println(libWH.TreeToNumber(v2))
		fmt.Println(libWH.PrintTree(v2))
		fmt.Println(libWH.TreeToNumber(v3))
		fmt.Println(libWH.PrintTree(v3))
		fmt.Println(libWH.TreeToNumber(v4))
		fmt.Println(libWH.PrintTree(v4))
		fmt.Println(libWH.TreeToNumber(v5))
		fmt.Println(libWH.PrintTree(v5))
	}else{
		fmt.Println("Nombre d'arguments incorrect") 
	}
}

func f0(v0, v1, v2 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {

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
var v8 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v8
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
var vt6 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt6
var vt7 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt7
var vt8 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt8

vt2 = libWH.Op_and(v0,v1)
vt1 = libWH.Op_or(vt2,v3)
vt0 = libWH.Op_and(v2,vt1)

v3 = vt0

vt4 = libWH.Op_or(v3,v1)
vt3 = libWH.Op_or(vt4,s1)

v4 = vt3

vt5 = libWH.Op_or(v5,v3)

v6 = vt5

vt6 = libWH.Op_and(v5,v3)

v0 = vt6

vt7 = libWH.Op_and(v7,v8)

v1 = vt7

vt8 = libWH.Op_not(v3)

v2 = vt8


return v0,v1,v3,v4,v6,v2 
}
