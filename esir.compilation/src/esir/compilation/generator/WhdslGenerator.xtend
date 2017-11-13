
/*
 * generated by Xtext 2.13.0
 */
package esir.compilation.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import esir.compilation.whdsl.Function
import esir.compilation.whdsl.Program
import esir.compilation.whdsl.Commands
import esir.compilation.whdsl.impl.CommandsImpl
import esir.compilation.whdsl.Exprs
import esir.compilation.whdsl.Command
import esir.compilation.whdsl.Vars
import esir.compilation.whdsl.impl.CommandImpl

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class WhdslGenerator extends AbstractGenerator {

	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : resource.allContents.toIterable.filter(typeof(Program))){
			fsa.generateFile("result_output.whpp",	e.compile())
		}
	}
	def doGenerate (Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context, String sortie) {
		for (e : resource.allContents.toIterable.filter(typeof(Program))){
			fsa.generateFile(sortie, e.compile())
		}
	}
	
	def compile (Program p){'''
		«FOR f : p.function»
		«f.compile()»
		«ENDFOR»
		'''
	}
	
	def compile (Function f){
		'''
		function «f.name»:
		read «FOR param: f.definition.input.variables SEPARATOR ', '»«param»«ENDFOR»%
		«FOR param: f.definition.commands.commands»«param.compile()»;
		«ENDFOR»
		%write «FOR param: f.definition.output.variables SEPARATOR ', '»«param»«ENDFOR»'''
	}
	
	def compile(Command c){
				
		if(c.getNop() != null){
		'''nop'''
		}
		else{
		'''«c.vars.compile()»=:«c.expression.compile()»'''
		}
		
	
	}

	def compile(Vars v){
		'''«v.variable»«FOR param: v.vars »,«param.compile()»«ENDFOR»'''
	}

	

	def compile(Exprs e){
		'''«e.expr»«FOR param: e.exprs»,«param»«ENDFOR»'''
	}
	
	
	
}