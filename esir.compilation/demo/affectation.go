package main
import (libWH "./libGO"
	"fmt"
	"os"
	"strconv"
)
var s0 *libWH.Tree

func main(){
s0=&(libWH.Tree{"nil",nil,nil})

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
		v0,v1,v2:=f0(vi1,vi2,vi3)
		fmt.Println(libWH.TreeToNumber(v0))
		fmt.Println(libWH.PrintTree(v0))
		fmt.Println(libWH.TreeToNumber(v1))
		fmt.Println(libWH.PrintTree(v1))
		fmt.Println(libWH.TreeToNumber(v2))
		fmt.Println(libWH.PrintTree(v2))
	}else{
		fmt.Println("Nombre d'arguments incorrect") 
	}
}

func f0(v0, v1, v2 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree) {

var v3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v3
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

v0 = v3

vt0 = v1

v1 = v2

v0 = vt0

v2 = v3


return v0,v1,v2 
}
