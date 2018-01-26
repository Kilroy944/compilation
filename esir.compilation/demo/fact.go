package main
import (libWH "./libGO"
	"fmt"
	"os"
	"strconv"
)
var s0 *libWH.Tree

func main(){
s0=&(libWH.Tree{"nil",nil,nil})

	nbOut := 1
	if (len(os.Args)-1)>=nbOut {
		i1, err1 := strconv.Atoi(os.Args[1])
		 _ = i1
		var vi1 = libWH.NumberToTree(i1)

		if err1 != nil {
 			vi1 =  libWH.TextToTree(os.Args[1])
			 _ = i1
		}
		v0:=f12(vi1)
		fmt.Println(libWH.TreeToNumber(v0))
		fmt.Println(libWH.PrintTree(v0))
	}else{
		fmt.Println("Nombre d'arguments incorrect") 
	}
}

func f0(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v1
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0


if libWH.IsTrue(v0){
   vt0 = libWH.Cons(s0,s0)
   v1 = vt0

}else{
   v1 = s0

}


return v1 
}

func f1(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v1
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0


if libWH.IsTrue(v0){
   v1 = s0

}else{
   vt0 = libWH.Cons(s0,s0)
   v1 = vt0

}


return v1 
}

func f2(v0 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

vt0 = libWH.Cons(s0,v0)

v0 = vt0


return v0 
}

func f3(v0 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

vt0 = libWH.Tl(v0)

v0 = vt0


return v0 
}

func f4(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0
var vt1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt1
var vt2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt2
var vt3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt3

vt0=f1(v1)

if libWH.IsTrue(vt0){
   v2 = v0

}else{
   vt1=f3(v1)
   vt2=f4(v0,vt1)
   vt3=f2(vt2)
   v2 = vt3

}


return v2 
}

func f5(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

v2 = s0

var vt1 int
vt1=libWH.TreeToNumber(v1)
for i:=0;i<vt1;i++ {
   vt0=f7(v0,v2)

   v2 = vt0

}


return v2 
}

func f6(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v1
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0
var vt1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt1
var vt2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt2

vt1 = libWH.Cons(s0,s0)
vt0 = libWH.Op_eg(v0,vt1)

if libWH.IsTrue(vt0){
   vt2 = libWH.Cons(s0,s0)
   v1 = vt2

}else{
   v1 = s0

}


return v1 
}

func f7(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

v2 = v0

var vt1 int
vt1=libWH.TreeToNumber(v1)
for i:=0;i<vt1;i++ {
   vt0=f2(v2)

   v2 = vt0

}


return v2 
}

func f8(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0

v2 = v0

var vt1 int
vt1=libWH.TreeToNumber(v1)
for i:=0;i<vt1;i++ {
   vt0=f3(v2)

   v2 = vt0

}


return v2 
}

func f9(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0
var vt1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt1

vt0 = libWH.Cons(s0,s0)

v2 = vt0

var vt2 int
vt2=libWH.TreeToNumber(v1)
for i:=0;i<vt2;i++ {
   vt1=f5(v0,v2)

   v2 = vt1

}


return v2 
}

func f10(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
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
var vt9 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt9

vt0 = libWH.Op_eg(v0,v1)

if libWH.IsTrue(vt0){
   v2 = s0

}else{
	   vt3 = libWH.Op_eg(v0,s0)
	vt2 = libWH.Op_not(vt3)
	   vt5 = libWH.Op_eg(v1,s0)
	vt4 = libWH.Op_not(vt5)
   vt1 = libWH.Op_and(vt2,vt4)

   for libWH.IsTrue(vt1){
         vt6 = libWH.Tl(v0)

         v0 = vt6

         vt7 = libWH.Tl(v1)

         v1 = vt7

	   vt3 = libWH.Op_eg(v0,s0)
	vt2 = libWH.Op_not(vt3)
	   vt5 = libWH.Op_eg(v1,s0)
	vt4 = libWH.Op_not(vt5)
   vt1 = libWH.Op_and(vt2,vt4)

   }
   vt8 = libWH.Op_eg(v0,s0)

   if libWH.IsTrue(vt8){
      v2 = s0

   }else{
      vt9 = libWH.Cons(s0,s0)
      v2 = vt9

   }

}


return v2 
}

func f11(v0, v1 *libWH.Tree) (*libWH.Tree, *libWH.Tree) {

var v2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v2
var v3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v3
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

v2 = s0

v3 = v0

vt1=f10(v3,v1)
vt2 = libWH.Op_eg(v3,v1)
vt0 = libWH.Op_or(vt1,vt2)

for libWH.IsTrue(vt0){
   vt3=f8(v3,v1)

   v3 = vt3

   vt4=f2(v2)

   v2 = vt4

vt1=f10(v3,v1)
vt2 = libWH.Op_eg(v3,v1)
vt0 = libWH.Op_or(vt1,vt2)

}


return v2,v3 
}

func f12(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = v1
var vt0 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt0
var vt1 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt1
var vt2 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt2
var vt3 *libWH.Tree = &(libWH.Tree{"nil",nil,nil})
_ = vt3

vt0 = libWH.Cons(s0,s0)

v1 = vt0

vt1=f0(v0)

for libWH.IsTrue(vt1){
   vt2=f3(v0)

   vt3=f5(v1,v0)

   v0 = vt2

   v1 = vt3

vt1=f0(v0)

}


return v1 
}
