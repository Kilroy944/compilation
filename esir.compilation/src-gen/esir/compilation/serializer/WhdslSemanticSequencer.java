/*
 * generated by Xtext 2.13.0
 */
package esir.compilation.serializer;

import com.google.inject.Inject;
import esir.compilation.services.WhdslGrammarAccess;
import esir.compilation.whdsl.Command;
import esir.compilation.whdsl.Commands;
import esir.compilation.whdsl.Definition;
import esir.compilation.whdsl.Exprs;
import esir.compilation.whdsl.Function;
import esir.compilation.whdsl.Input;
import esir.compilation.whdsl.Output;
import esir.compilation.whdsl.Program;
import esir.compilation.whdsl.Vars;
import esir.compilation.whdsl.WhdslPackage;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class WhdslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private WhdslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == WhdslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case WhdslPackage.COMMAND:
				sequence_Command(context, (Command) semanticObject); 
				return; 
			case WhdslPackage.COMMANDS:
				sequence_Commands(context, (Commands) semanticObject); 
				return; 
			case WhdslPackage.DEFINITION:
				sequence_Definition(context, (Definition) semanticObject); 
				return; 
			case WhdslPackage.EXPRS:
				sequence_Exprs(context, (Exprs) semanticObject); 
				return; 
			case WhdslPackage.FUNCTION:
				sequence_Function(context, (Function) semanticObject); 
				return; 
			case WhdslPackage.INPUT:
				sequence_Input(context, (Input) semanticObject); 
				return; 
			case WhdslPackage.OUTPUT:
				sequence_Output(context, (Output) semanticObject); 
				return; 
			case WhdslPackage.PROGRAM:
				sequence_Program(context, (Program) semanticObject); 
				return; 
			case WhdslPackage.VARS:
				sequence_Vars(context, (Vars) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Command returns Command
	 *
	 * Constraint:
	 *     (nop=NOP | (vars=Vars expression=Exprs))
	 */
	protected void sequence_Command(ISerializationContext context, Command semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Commands returns Commands
	 *
	 * Constraint:
	 *     (commands+=Command commands+=Command*)
	 */
	protected void sequence_Commands(ISerializationContext context, Commands semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Definition returns Definition
	 *
	 * Constraint:
	 *     (input=Input commands=Commands output=Output)
	 */
	protected void sequence_Definition(ISerializationContext context, Definition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, WhdslPackage.Literals.DEFINITION__INPUT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WhdslPackage.Literals.DEFINITION__INPUT));
			if (transientValues.isValueTransient(semanticObject, WhdslPackage.Literals.DEFINITION__COMMANDS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WhdslPackage.Literals.DEFINITION__COMMANDS));
			if (transientValues.isValueTransient(semanticObject, WhdslPackage.Literals.DEFINITION__OUTPUT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WhdslPackage.Literals.DEFINITION__OUTPUT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDefinitionAccess().getInputInputParserRuleCall_0_0(), semanticObject.getInput());
		feeder.accept(grammarAccess.getDefinitionAccess().getCommandsCommandsParserRuleCall_2_0(), semanticObject.getCommands());
		feeder.accept(grammarAccess.getDefinitionAccess().getOutputOutputParserRuleCall_4_0(), semanticObject.getOutput());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Exprs returns Exprs
	 *
	 * Constraint:
	 *     (expr+=Expr exprs+=Expr*)
	 */
	protected void sequence_Exprs(ISerializationContext context, Exprs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Function returns Function
	 *
	 * Constraint:
	 *     (name=SYMBOLE definition=Definition)
	 */
	protected void sequence_Function(ISerializationContext context, Function semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, WhdslPackage.Literals.FUNCTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WhdslPackage.Literals.FUNCTION__NAME));
			if (transientValues.isValueTransient(semanticObject, WhdslPackage.Literals.FUNCTION__DEFINITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WhdslPackage.Literals.FUNCTION__DEFINITION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFunctionAccess().getNameSYMBOLETerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFunctionAccess().getDefinitionDefinitionParserRuleCall_3_0(), semanticObject.getDefinition());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Input returns Input
	 *
	 * Constraint:
	 *     (variables+=VARIABLE variables+=VARIABLE*)
	 */
	protected void sequence_Input(ISerializationContext context, Input semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Output returns Output
	 *
	 * Constraint:
	 *     (variables+=VARIABLE variables+=VARIABLE*)
	 */
	protected void sequence_Output(ISerializationContext context, Output semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Program returns Program
	 *
	 * Constraint:
	 *     function+=Function+
	 */
	protected void sequence_Program(ISerializationContext context, Program semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Vars returns Vars
	 *
	 * Constraint:
	 *     (variable+=VARIABLE vars+=Vars*)
	 */
	protected void sequence_Vars(ISerializationContext context, Vars semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
