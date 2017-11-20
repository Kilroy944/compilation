/**
 * generated by Xtext 2.13.0
 */
package esir.compilation.whdsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Affect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link esir.compilation.whdsl.Affect#getVars <em>Vars</em>}</li>
 *   <li>{@link esir.compilation.whdsl.Affect#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @see esir.compilation.whdsl.WhdslPackage#getAffect()
 * @model
 * @generated
 */
public interface Affect extends EObject
{
  /**
   * Returns the value of the '<em><b>Vars</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vars</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vars</em>' attribute list.
   * @see esir.compilation.whdsl.WhdslPackage#getAffect_Vars()
   * @model unique="false"
   * @generated
   */
  EList<String> getVars();

  /**
   * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
   * The list contents are of type {@link esir.compilation.whdsl.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exprs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exprs</em>' containment reference list.
   * @see esir.compilation.whdsl.WhdslPackage#getAffect_Exprs()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getExprs();

} // Affect
