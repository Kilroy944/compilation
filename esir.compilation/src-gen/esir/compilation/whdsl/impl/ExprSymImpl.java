/**
 * generated by Xtext 2.13.0
 */
package esir.compilation.whdsl.impl;

import esir.compilation.whdsl.Expr;
import esir.compilation.whdsl.ExprSym;
import esir.compilation.whdsl.WhdslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expr Sym</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link esir.compilation.whdsl.impl.ExprSymImpl#getArg1 <em>Arg1</em>}</li>
 *   <li>{@link esir.compilation.whdsl.impl.ExprSymImpl#getArg2 <em>Arg2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExprSymImpl extends MinimalEObjectImpl.Container implements ExprSym
{
  /**
   * The default value of the '{@link #getArg1() <em>Arg1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg1()
   * @generated
   * @ordered
   */
  protected static final String ARG1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArg1() <em>Arg1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg1()
   * @generated
   * @ordered
   */
  protected String arg1 = ARG1_EDEFAULT;

  /**
   * The cached value of the '{@link #getArg2() <em>Arg2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg2()
   * @generated
   * @ordered
   */
  protected EList<Expr> arg2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExprSymImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return WhdslPackage.Literals.EXPR_SYM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getArg1()
  {
    return arg1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArg1(String newArg1)
  {
    String oldArg1 = arg1;
    arg1 = newArg1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhdslPackage.EXPR_SYM__ARG1, oldArg1, arg1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expr> getArg2()
  {
    if (arg2 == null)
    {
      arg2 = new EObjectContainmentEList<Expr>(Expr.class, this, WhdslPackage.EXPR_SYM__ARG2);
    }
    return arg2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case WhdslPackage.EXPR_SYM__ARG2:
        return ((InternalEList<?>)getArg2()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case WhdslPackage.EXPR_SYM__ARG1:
        return getArg1();
      case WhdslPackage.EXPR_SYM__ARG2:
        return getArg2();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WhdslPackage.EXPR_SYM__ARG1:
        setArg1((String)newValue);
        return;
      case WhdslPackage.EXPR_SYM__ARG2:
        getArg2().clear();
        getArg2().addAll((Collection<? extends Expr>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case WhdslPackage.EXPR_SYM__ARG1:
        setArg1(ARG1_EDEFAULT);
        return;
      case WhdslPackage.EXPR_SYM__ARG2:
        getArg2().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case WhdslPackage.EXPR_SYM__ARG1:
        return ARG1_EDEFAULT == null ? arg1 != null : !ARG1_EDEFAULT.equals(arg1);
      case WhdslPackage.EXPR_SYM__ARG2:
        return arg2 != null && !arg2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (arg1: ");
    result.append(arg1);
    result.append(')');
    return result.toString();
  }

} //ExprSymImpl
