package libWH

type BaseType interface {
	isBaseType()
}

type Symbol struct {
	name string
}
func (*Symbol) isBaseType() {}

type Tree struct {
	left  BaseType
	right BaseType
}
func (*Tree) isBaseType() {}

var TRUE BaseType = &(Tree{nil,nil})
var FALSE BaseType = nil

func Tl(t BaseType) BaseType {
	switch t.(type) {
		case nil: return nil
		case (*Symbol): return nil
		default: return t.(*Tree).right
	}
}

func Hd(t BaseType) BaseType {
	switch t.(type) {
		case nil: return nil
		case (*Symbol): return nil
		default: return t.(*Tree).left
	}
}

func IsTrue(t BaseType) bool {
	switch t.(type) {
		case nil: return false
		default: return true
	}
}


func Cons(g BaseType, d BaseType) (BaseType) {
	return &(Tree{g,d})
}

func TreeToNumber(t BaseType) (int) {
	switch t.(type) {
		case nil: return 0
		case *Symbol: return 0
		default: return 1 + TreeToNumber(t.(*Tree).right)
	}
}

func TreeToRange(t BaseType) ([] BaseType) {
	var tab = [](BaseType){}
	for true {
		switch t.(type) {
			case nil: break
			case *Symbol: break
			default: 
				tab = append(tab, t.(*Tree).right)
				t = t.(*Tree).right
		}
	}
	return tab
}

func NumberToTree(nb int) (BaseType) {
	var t BaseType = nil
	for i := 0; i < nb; i++ {
		t = Cons(nil, t)
	}
	return t
}

func Op_or(t1 BaseType, t2 BaseType) (BaseType) {
    if (IsTrue(t1) || IsTrue(t2)) {
    	return TRUE
    } else {
    	return FALSE
    }
}

func Op_eg(t1 BaseType, t2 BaseType) (BaseType) {
	if (t1 == nil || t2 == nil) {
		if (t1 == nil && t2 == nil) {
			return TRUE
		} else {
			return FALSE
		}
	} else {
		var t1s, ok1s = t1.(*Symbol)
		var t2s, ok2s = t2.(*Symbol)
		
		if (ok1s && ok2s && (t1s.name == t2s.name)) {
			return TRUE
		} else if (ok1s || ok2s) {
			return FALSE
		} else {
			var left_eg = Op_eg(t1.(*Tree).left, t2.(*Tree).left)
			var right_eg = Op_eg(t1.(*Tree).right, t2.(*Tree).right)
			
			if (IsTrue(left_eg) && right_eg == TRUE) {
				return TRUE
			} else {
				return FALSE
			}
		}
	}
}

func Op_not(t BaseType) (BaseType) {
    if IsTrue(t) {
		return FALSE
    } else {
    	return TRUE
    }
}

func Op_and (t1 BaseType, t2 BaseType) (BaseType) {
    if (IsTrue(t1) && IsTrue(t2)) {
		return TRUE
    } else {
	    return FALSE
    }
}
