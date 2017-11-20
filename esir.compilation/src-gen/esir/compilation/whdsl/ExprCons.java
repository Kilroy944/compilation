/**
 * generated by Xtext 2.13.0
 */
package esir.compilation.whdsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expr Cons</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link esir.compilation.whdsl.ExprCons#getArg1 <em>Arg1</em>}</li>
 *   <li>{@link esir.compilation.whdsl.ExprCons#getArg2 <em>Arg2</em>}</li>
 * </ul>
 *
 * @see esir.compilation.whdsl.WhdslPackage#getExprCons()
 * @model
 * @generated
 */
public interface ExprCons extends EObject
{
  /**
   * Returns the value of the '<em><b>Arg1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg1</em>' containment reference.
   * @see #setArg1(Expr)
   * @see esir.compilation.whdsl.WhdslPackage#getExprCons_Arg1()
   * @model containment="true"
   * @generated
   */
  Expr getArg1();

  /**
   * Sets the value of the '{@link esir.compilation.whdsl.ExprCons#getArg1 <em>Arg1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg1</em>' containment reference.
   * @see #getArg1()
   * @generated
   */
  void setArg1(Expr value);

  /**
   * Returns the value of the '<em><b>Arg2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg2</em>' containment reference.
   * @see #setArg2(Expr)
   * @see esir.compilation.whdsl.WhdslPackage#getExprCons_Arg2()
   * @model containment="true"
   * @generated
   */
  Expr getArg2();

  /**
   * Sets the value of the '{@link esir.compilation.whdsl.ExprCons#getArg2 <em>Arg2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg2</em>' containment reference.
   * @see #getArg2()
   * @generated
   */
  void setArg2(Expr value);

} // ExprCons
