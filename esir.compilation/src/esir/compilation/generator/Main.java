package esir.compilation.generator;


import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import esir.compilation.WhdslStandaloneSetupGenerated;


public class Main {
	
	private static final boolean isDebugMode =true;

	public static void main(String[] args) {
		System.out.println("start");
		Injector injector = new WhdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		main.runGenerator("test.whdsl","sortie.whdsl");
		
		System.out.println("fini");
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private WhdslGenerator generator;

	@Inject 
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(String string,String sortie){
		// Load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createFileURI(string), true);
		

		// Validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				//throw new ErrorException(issue.getMessage());
			}
			System.out.println("gg");
			return;
		}

		// Configure and start the generator
		fileAccess.setOutputPath("./");
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		generator.doGenerate(resource, fileAccess, context, sortie);

		System.out.println("pretty fini");
	}
}