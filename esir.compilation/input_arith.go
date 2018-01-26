package main
import (libWH "./libGO"
	"fmt"
	"os"
	"strconv"
)
var s0 libWH.BaseType = nil

func main(){

	nbOut := 1
	if (len(os.Args)-1)>=nbOut {
		i1, err1 := strconv.Atoi(os.Args[1])

		if err1 == nil {
			v0:=f13(libWH.NumberToTree(i1))
			fmt.Println(libWH.TreeToNumber(v0))
		}else{
			fmt.Println("L'un des arguments n'est pas un nombre")
		}
	}else{
		fmt.Println("Nombre d'arguments incorrect") 
	}
}

func f0(v0 libWH.BaseType) (libWH.BaseType) {

var v1 libWH.BaseType = nil
_ = v1
var vt0 libWH.BaseType = nil
_ = vt0


if libWH.IsTrue(v0){
   vt0 = libWH.Cons(s0,s0)
   v1 = vt0

}else{
   v1 = s0

}


return v1 
}

func f1(v0 libWH.BaseType) (libWH.BaseType) {

var v1 libWH.BaseType = nil
_ = v1
var vt0 libWH.BaseType = nil
_ = vt0


if libWH.IsTrue(v0){
   v1 = s0

}else{
   vt0 = libWH.Cons(s0,s0)
   v1 = vt0

}


return v1 
}

func f2(v0 libWH.BaseType) (libWH.BaseType) {

var vt0 libWH.BaseType = nil
_ = vt0

vt0 = libWH.Cons(s0,v0)

v0 = vt0


return v0 
}

func f3(v0 libWH.BaseType) (libWH.BaseType) {

var vt0 libWH.BaseType = nil
_ = vt0

vt0 = libWH.Tl(v0)

v0 = vt0


return v0 
}

func f4(v0, v1 libWH.BaseType) (libWH.BaseType) {

var v2 libWH.BaseType = nil
_ = v2
var vt0 libWH.BaseType = nil
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

func f5(v0, v1 libWH.BaseType) (libWH.BaseType) {

var v2 libWH.BaseType = nil
_ = v2
var vt0 libWH.BaseType = nil
_ = vt0
var vt1 libWH.BaseType = nil
_ = vt1
var vt2 libWH.BaseType = nil
_ = vt2
var vt3 libWH.BaseType = nil
_ = vt3

vt0=f1(v1)

if libWH.IsTrue(vt0){
   v2 = v0

}else{
   vt1=f3(v1)
   vt2=f5(v0,vt1)
   vt3=f2(vt2)
   v2 = vt3

}


return v2 
}

func f6(v0, v1 libWH.BaseType) (libWH.BaseType) {

var v2 libWH.BaseType = nil
_ = v2
var vt0 libWH.BaseType = nil
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

func f7(v0, v1 libWH.BaseType) (libWH.BaseType) {

var v2 libWH.BaseType = nil
_ = v2
var vt0 libWH.BaseType = nil
_ = vt0

v2 = s0

var vt1 int
vt1=libWH.TreeToNumber(v1)
for i:=0;i<vt1;i++ {
   vt0=f4(v0,v2)

   v2 = vt0

}


return v2 
}

func f8(v0, v1 libWH.BaseType) (libWH.BaseType) {

var v2 libWH.BaseType = nil
_ = v2
var vt0 libWH.BaseType = nil
_ = vt0
var vt1 libWH.BaseType = nil
_ = vt1

vt0 = libWH.Cons(s0,s0)

v2 = vt0

var vt2 int
vt2=libWH.TreeToNumber(v1)
for i:=0;i<vt2;i++ {
   vt1=f7(v0,v2)

   v2 = vt1

}


return v2 
}

func f9(v0, v1 libWH.BaseType) (libWH.BaseType, libWH.BaseType) {

var v2 libWH.BaseType = nil
_ = v2
var v3 libWH.BaseType = nil
_ = v3
var v4 libWH.BaseType = nil
_ = v4
var vt0 libWH.BaseType = nil
_ = vt0
var vt1 libWH.BaseType = nil
_ = vt1
var vt2 libWH.BaseType = nil
_ = vt2
var vt3 libWH.BaseType = nil
_ = vt3
var vt4 libWH.BaseType = nil
_ = vt4
var vt5 libWH.BaseType = nil
_ = vt5

v2 = s0

v3 = v0

vt0=f6(v3,v1)

v4 = vt0

vt2=f0(v4)
vt3 = libWH.Op_eg(v3,v1)
vt1 = libWH.Op_or(vt2,vt3)

for libWH.IsTrue(vt1){
   vt4=f2(v2)

   v2 = vt4

   v3 = v4

   vt5=f6(v3,v1)

   v4 = vt5

vt2=f0(v4)
vt3 = libWH.Op_eg(v3,v1)
vt1 = libWH.Op_or(vt2,vt3)

}


return v2,v3 
}

func f10(v0, v1 libWH.BaseType) (libWH.BaseType) {

var v2 libWH.BaseType = nil
_ = v2
var v3 libWH.BaseType = nil
_ = v3
var v4 libWH.BaseType = nil
_ = v4
var vt0 libWH.BaseType = nil
_ = vt0
var vt1 libWH.BaseType = nil
_ = vt1
var vt2 libWH.BaseType = nil
_ = vt2
var vt3 libWH.BaseType = nil
_ = vt3

vt0,vt1=f9(v0,v1)

v2 = vt0

v3 = vt1

vt2=f0(v3)

if libWH.IsTrue(vt2){
   vt3=f10(v1,v3)
   v4 = vt3

}else{
   v4 = v1

}


return v4 
}

func f11(v0 libWH.BaseType) (libWH.BaseType) {

var v1 libWH.BaseType = nil
_ = v1
var vt0 libWH.BaseType = nil
_ = vt0
var vt1 libWH.BaseType = nil
_ = vt1
var vt2 libWH.BaseType = nil
_ = vt2
var vt3 libWH.BaseType = nil
_ = vt3

vt0 = libWH.Cons(s0,s0)

v1 = vt0

vt1=f0(v0)

for libWH.IsTrue(vt1){
   vt2=f3(v0)

   vt3=f7(v1,v0)

   v0 = vt2

   v1 = vt3

vt1=f0(v0)

}


return v1 
}

func f12(v0 libWH.BaseType) (libWH.BaseType) {

var v1 libWH.BaseType = nil
_ = v1
var vt0 libWH.BaseType = nil
_ = vt0
var vt1 libWH.BaseType = nil
_ = vt1
var vt2 libWH.BaseType = nil
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

func f13(v0 libWH.BaseType) (libWH.BaseType) {

var v1 libWH.BaseType = nil
_ = v1
var vt0 libWH.BaseType = nil
_ = vt0
var vt1 libWH.BaseType = nil
_ = vt1
var vt2 libWH.BaseType = nil
_ = vt2
var vt3 libWH.BaseType = nil
_ = vt3
var vt4 libWH.BaseType = nil
_ = vt4
var vt5 libWH.BaseType = nil
_ = vt5
var vt6 libWH.BaseType = nil
_ = vt6
var vt7 libWH.BaseType = nil
_ = vt7
var vt8 libWH.BaseType = nil
_ = vt8

vt0=f1(v0)

if libWH.IsTrue(vt0){
   v1 = s0

}else{
   vt1=f12(v0)

   if libWH.IsTrue(vt1){
      vt2 = libWH.Cons(s0,s0)
      v1 = vt2

   }else{
      vt3=f3(v0)
      vt4=f13(vt3)
      vt5=f3(v0)
      vt6=f3(vt5)
      vt7=f13(vt6)
      vt8=f4(vt4,vt7)
      v1 = vt8

   }

}


return v1 
}
