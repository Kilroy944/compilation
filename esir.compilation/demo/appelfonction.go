package main
import (libWH "./libGO"
	"fmt"
	"os"
	"strconv"
)
var s0 *libWH.Tree

func main(){
s0=&(libWH.Tree{"nil",nil,nil})

	nbOut := 5
	if (len(os.Args)-1)>=nbOut {
		i1, err1 := strconv.Atoi(os.Args[1])
		 _ = i1
		i2, err2 := strconv.Atoi(os.Args[2])
		 _ = i2
		i3, err3 := strconv.Atoi(os.Args[3])
		 _ = i3
		i4, err4 := strconv.Atoi(os.Args[4])
		 _ = i4
		i5, err5 := strconv.Atoi(os.Args[5])
		 _ = i5
		var vi1 = libWH.NumberToTree(i1)
		var vi2 = libWH.NumberToTree(i2)
		var vi3 = libWH.NumberToTree(i3)
		var vi4 = libWH.NumberToTree(i4)
		var vi5 = libWH.NumberToTree(i5)

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

		if err4 != nil {
 			vi4 =  libWH.TextToTree(os.Args[4])
			 _ = i4
		}

		if err5 != nil {
 			vi5 =  libWH.TextToTree(os.Args[5])
			 _ = i5
		}
		v0,v1,v2,v3,v4:=f1(vi1,vi2,vi3,vi4,vi5)
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
	}else{
		fmt.Println("Nombre d'arguments incorrect") 
	}
}

func f0(v0, v1, v2, v3, v4 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {




return v4,v3,v2,v1,v0 
}

func f1(v0, v1, v2, v3, v4 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {

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

vt0,vt1,vt2,vt3,vt4=f0(v0,v1,v2,v3,v4)

v0 = vt0

v1 = vt1

v2 = vt2

v3 = vt3

v4 = vt4


return v0,v1,v2,v3,v4 
}
