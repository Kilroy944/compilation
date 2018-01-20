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

	nbOut := 4
	if (len(os.Args)-1)>=nbOut {
		i1, err1 := strconv.Atoi(os.Args[1])
		i2, err2 := strconv.Atoi(os.Args[2])
		i3, err3 := strconv.Atoi(os.Args[3])
		i4, err4 := strconv.Atoi(os.Args[4])

		if err1 == nil && err2 == nil && err3 == nil && err4 == nil {
			v0,v1,v2,v3:=f1(libWH.NumberToTree(i1),libWH.NumberToTree(i2),libWH.NumberToTree(i3),libWH.NumberToTree(i4))
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

func f1(v0, v1, v2, v3 *libWH.Tree) (*libWH.Tree, *libWH.Tree, *libWH.Tree, *libWH.Tree) {


var vt0 int
vt0=libWH.TreeToNumber(v0)
for i:=0;i<vt0;i++ {
   v0 = s1

}

return v0,v1,v2,v3 
}
