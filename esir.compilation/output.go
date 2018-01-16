package main
import (libWH "./libGO"
	"fmt"
	"os"
)
var s0 *libWH.Tree

func main(){
	v0:=f13(nil)
	fmt.Println(v0)
}

func f0(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree
var vt0 *libWH.Tree


if libWH.IsTrue(v0){
   vt0 = libWH.Cons(s0,s0)
   v1 = vt0

}else{
   v1 = s0

}

return v1 
}

func f1(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree
var vt0 *libWH.Tree


if libWH.IsTrue(v0){
   v1 = s0

}else{
   vt0 = libWH.Cons(s0,s0)
   v1 = vt0

}

return v1 
}

func f2(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree
var vt0 *libWH.Tree
var vt1 *libWH.Tree
var vt2 *libWH.Tree

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

func f3(v0 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree

vt0 = libWH.Cons(s0,v0)

v0 = vt0


return v0 
}

func f4(v0 *libWH.Tree) (*libWH.Tree) {

var vt0 *libWH.Tree

vt0 = libWH.Tl(v0)

v0 = vt0


return v0 
}

func f5(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree
var vt0 *libWH.Tree

v2 = v0

for i:=0;i<libWH.TreeToNumber(v1);i++ {
   vt0=f3(v2)

   v2 = vt0

}

return v2 
}

func f6(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree
var vt0 *libWH.Tree
var vt1 *libWH.Tree
var vt2 *libWH.Tree
var vt3 *libWH.Tree

vt0=f0(v1)

if libWH.IsTrue(vt0){
   v2 = v0

}else{
   vt1=f4(v1)
   vt2=f6(v0,vt1)
   vt3=f3(vt2)
   v2 = vt3

}

return v2 
}

func f7(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree
var vt0 *libWH.Tree

v2 = v0

for i:=0;i<libWH.TreeToNumber(v1);i++ {
   vt0=f4(v2)

   v2 = vt0

}

return v2 
}

func f8(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree
var vt0 *libWH.Tree

v2 = s0

for i:=0;i<libWH.TreeToNumber(v1);i++ {
   vt0=f5(v0,v2)

   v2 = vt0

}

return v2 
}

func f9(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree
var vt0 *libWH.Tree
var vt1 *libWH.Tree

vt0 = libWH.Cons(s0,s0)

v2 = vt0

for i:=0;i<libWH.TreeToNumber(v1);i++ {
   vt1=f8(v0,v2)

   v2 = vt1

}

return v2 
}

func f10(v0, v1 *libWH.Tree) (*libWH.Tree, *libWH.Tree) {

var v2 *libWH.Tree
var v3 *libWH.Tree
var v4 *libWH.Tree
var vt0 *libWH.Tree
var vt1 *libWH.Tree
var vt2 *libWH.Tree

v2 = s0

v3 = v0

vt0=f7(v3,v1)

v4 = vt0

vt1=f1(v4)

for libWH.IsTrue(vt1){
   vt2=f3(v2)

   v2 = vt2

   v3 = v4

}

return v2,v3 
}

func f11(v0, v1 *libWH.Tree) (*libWH.Tree) {

var v2 *libWH.Tree
var v3 *libWH.Tree
var v4 *libWH.Tree
var vt0 *libWH.Tree
var vt1 *libWH.Tree
var vt2 *libWH.Tree
var vt3 *libWH.Tree

vt0,vt1=f10(v0,v1)

v2 = vt0

vt0,vt1=f10(v0,v1)

v3 = vt1

vt2=f1(v3)

if libWH.IsTrue(vt2){
   vt3=f11(v1,v3)
   v4 = vt3

}else{
   v4 = v1

}

return v4 
}

func f12(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree
var vt0 *libWH.Tree
var vt1 *libWH.Tree
var vt2 *libWH.Tree
var vt3 *libWH.Tree

vt0 = libWH.Cons(s0,s0)

v1 = vt0

vt1=f1(v0)

for libWH.IsTrue(vt1){
   vt2=f4(v0)

   v0 = vt2

   vt3=f8(v1,v0)

   v1 = vt3

}

return v1 
}

func f13(v0 *libWH.Tree) (*libWH.Tree) {

var v1 *libWH.Tree
var vt0 *libWH.Tree
var vt1 *libWH.Tree
var vt2 *libWH.Tree
var vt3 *libWH.Tree
var vt4 *libWH.Tree
var vt5 *libWH.Tree
var vt6 *libWH.Tree
var vt7 *libWH.Tree
var vt8 *libWH.Tree
var vt9 *libWH.Tree

vt1=f0(v0)
vt2=f2(v0)
vt0 = libWH.Op_or(vt1,vt2)

if libWH.IsTrue(vt0){
   vt3 = libWH.Cons(s0,s0)
   v1 = vt3

}else{
   vt4=f4(v0)
   vt5=f13(vt4)
   vt6=f4(v0)
   vt7=f4(vt6)
   vt8=f13(vt7)
   vt9=f5(vt5,vt8)
   v1 = vt9

}

return v1 
}
