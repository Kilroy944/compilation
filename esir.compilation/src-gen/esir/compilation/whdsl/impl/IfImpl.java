/**
 * generated by Xtext 2.13.0
 */
package esir.compilation.whdsl.impl;

import esir.compilation.whdsl.Commands;
import esir.compilation.whdsl.Expr;
import esir.compilation.whdsl.If;
import esir.compilation.whdsl.WhdslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link esir.compilation.whdsl.impl.IfImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link esir.compilation.whdsl.impl.IfImpl#getThenCommands <em>Then Commands</em>}</li>
 *   <li>{@link esir.compilation.whdsl.impl.IfImpl#getElseCommands <em>Else Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfImpl extends MinimalEObjectImpl.Container implements If
{
  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected Expr condition;

  /**
   * The cached value of the '{@link #getThenCommands() <em>Then Commands</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenCommands()
   * @generated
   * @ordered
   */
  protected Commands thenCommands;

  /**
   * The cached value of the '{@link #getElseCommands() <em>Else Commands</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseCommands()
   * @generated
   * @ordered
   */
  protected Commands elseCommands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfImpl()
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
    return WhdslPackage.Literals.IF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(Expr newCondition, NotificationChain msgs)
  {
    Expr oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WhdslPackage.IF__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(Expr newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.IF__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.IF__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhdslPackage.IF__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Commands getThenCommands()
  {
    return thenCommands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenCommands(Commands newThenCommands, NotificationChain msgs)
  {
    Commands oldThenCommands = thenCommands;
    thenCommands = newThenCommands;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WhdslPackage.IF__THEN_COMMANDS, oldThenCommands, newThenCommands);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThenCommands(Commands newThenCommands)
  {
    if (newThenCommands != thenCommands)
    {
      NotificationChain msgs = null;
      if (thenCommands != null)
        msgs = ((InternalEObject)thenCommands).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.IF__THEN_COMMANDS, null, msgs);
      if (newThenCommands != null)
        msgs = ((InternalEObject)newThenCommands).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.IF__THEN_COMMANDS, null, msgs);
      msgs = basicSetThenCommands(newThenCommands, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhdslPackage.IF__THEN_COMMANDS, newThenCommands, newThenCommands));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Commands getElseCommands()
  {
    return elseCommands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseCommands(Commands newElseCommands, NotificationChain msgs)
  {
    Commands oldElseCommands = elseCommands;
    elseCommands = newElseCommands;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WhdslPackage.IF__ELSE_COMMANDS, oldElseCommands, newElseCommands);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseCommands(Commands newElseCommands)
  {
    if (newElseCommands != elseCommands)
    {
      NotificationChain msgs = null;
      if (elseCommands != null)
        msgs = ((InternalEObject)elseCommands).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.IF__ELSE_COMMANDS, null, msgs);
      if (newElseCommands != null)
        msgs = ((InternalEObject)newElseCommands).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WhdslPackage.IF__ELSE_COMMANDS, null, msgs);
      msgs = basicSetElseCommands(newElseCommands, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WhdslPackage.IF__ELSE_COMMANDS, newElseCommands, newElseCommands));
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
      case WhdslPackage.IF__CONDITION:
        return basicSetCondition(null, msgs);
      case WhdslPackage.IF__THEN_COMMANDS:
        return basicSetThenCommands(null, msgs);
      case WhdslPackage.IF__ELSE_COMMANDS:
        return basicSetElseCommands(null, msgs);
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
      case WhdslPackage.IF__CONDITION:
        return getCondition();
      case WhdslPackage.IF__THEN_COMMANDS:
        return getThenCommands();
      case WhdslPackage.IF__ELSE_COMMANDS:
        return getElseCommands();
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
      case WhdslPackage.IF__CONDITION:
        setCondition((Expr)newValue);
        return;
      case WhdslPackage.IF__THEN_COMMANDS:
        setThenCommands((Commands)newValue);
        return;
      case WhdslPackage.IF__ELSE_COMMANDS:
        setElseCommands((Commands)newValue);
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
      case WhdslPackage.IF__CONDITION:
        setCondition((Expr)null);
        return;
      case WhdslPackage.IF__THEN_COMMANDS:
        setThenCommands((Commands)null);
        return;
      case WhdslPackage.IF__ELSE_COMMANDS:
        setElseCommands((Commands)null);
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
      case WhdslPackage.IF__CONDITION:
        return condition != null;
      case WhdslPackage.IF__THEN_COMMANDS:
        return thenCommands != null;
      case WhdslPackage.IF__ELSE_COMMANDS:
        return elseCommands != null;
    }
    return super.eIsSet(featureID);
  }

} //IfImpl
