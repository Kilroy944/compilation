/**
 * generated by Xtext 2.13.0
 */
package esir.compilation.whdsl.impl;

import esir.compilation.whdsl.Expr;
import esir.compilation.whdsl.ExprCons;
import esir.compilation.whdsl.WhdslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expr Cons</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link esir.compilation.whdsl.impl.ExprConsImpl#getArg1 <em>Arg1</em>}</li>
 *   <li>{@link esir.compilation.whdsl.impl.ExprConsImpl#getArg2 <em>Arg2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExprConsImpl extends MinimalEObjectImpl.Container implements ExprCons
{
  /**
   * The cached value of the '{@link #getArg1() <em>Arg1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg1()
   * @generated
   * @ordered
   */
  protected Expr arg1;

  /**
   * The cached value of the '{@link #getArg2() <em>Arg2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg2()
   * @generated
   * @ordered
   */
  protected Expr arg2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExprConsImpl()
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
    return WhdslPackage.Literals.EXPR_CONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getArg1()
  {
    return arg1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArg1(Expr newArg1, NotificationChain msgs)
  {
    Expr oldArg1 = arg1;
    arg1 = newArg1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WhdslPackage.EXPR_CONS__ARG1, oldArg1, newArg1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArg1(Expr newArg1)
  {
    if (newArg1 != arg1)
    {
      NotificationChain msgs = null;
      if (arg1 != null)
        msgs = ((InternalEObject)arg1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.EXPR_CONS__ARG1, null, msgs);
      if (newArg1 != null)
        msgs = ((InternalEObject)newArg1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.EXPR_CONS__ARG1, null, msgs);
      msgs = basicSetArg1(newArg1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhdslPackage.EXPR_CONS__ARG1, newArg1, newArg1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getArg2()
  {
    return arg2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArg2(Expr newArg2, NotificationChain msgs)
  {
    Expr oldArg2 = arg2;
    arg2 = newArg2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WhdslPackage.EXPR_CONS__ARG2, oldArg2, newArg2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArg2(Expr newArg2)
  {
    if (newArg2 != arg2)
    {
      NotificationChain msgs = null;
      if (arg2 != null)
        msgs = ((InternalEObject)arg2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.EXPR_CONS__ARG2, null, msgs);
      if (newArg2 != null)
        msgs = ((InternalEObject)newArg2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.EXPR_CONS__ARG2, null, msgs);
      msgs = basicSetArg2(newArg2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhdslPackage.EXPR_CONS__ARG2, newArg2, newArg2));
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
      case WhdslPackage.EXPR_CONS__ARG1:
        return basicSetArg1(null, msgs);
      case WhdslPackage.EXPR_CONS__ARG2:
        return basicSetArg2(null, msgs);
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
      case WhdslPackage.EXPR_CONS__ARG1:
        return getArg1();
      case WhdslPackage.EXPR_CONS__ARG2:
        return getArg2();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WhdslPackage.EXPR_CONS__ARG1:
        setArg1((Expr)newValue);
        return;
      case WhdslPackage.EXPR_CONS__ARG2:
        setArg2((Expr)newValue);
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
      case WhdslPackage.EXPR_CONS__ARG1:
        setArg1((Expr)null);
        return;
      case WhdslPackage.EXPR_CONS__ARG2:
        setArg2((Expr)null);
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
      case WhdslPackage.EXPR_CONS__ARG1:
        return arg1 != null;
      case WhdslPackage.EXPR_CONS__ARG2:
        return arg2 != null;
    }
    return super.eIsSet(featureID);
  }

} //ExprConsImpl
