package esir.compilation.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import esir.compilation.services.WhdslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWhdslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SYMBOLE", "RULE_VARIABLE", "RULE_NIL", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'function'", "':'", "'%'", "'read'", "','", "'write'"
    };
    public static final int RULE_STRING=9;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_NIL=6;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=7;
    public static final int RULE_WS=12;
    public static final int RULE_VARIABLE=5;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SYMBOLE=4;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=10;

    // delegates
    // delegators


        public InternalWhdslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWhdslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWhdslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalWhdsl.g"; }



     	private WhdslGrammarAccess grammarAccess;

        public InternalWhdslParser(TokenStream input, WhdslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Program";
       	}

       	@Override
       	protected WhdslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgram"
    // InternalWhdsl.g:64:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalWhdsl.g:64:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalWhdsl.g:65:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalWhdsl.g:71:1: ruleProgram returns [EObject current=null] : ( (lv_function_0_0= ruleFunction ) )* ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_function_0_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:77:2: ( ( (lv_function_0_0= ruleFunction ) )* )
            // InternalWhdsl.g:78:2: ( (lv_function_0_0= ruleFunction ) )*
            {
            // InternalWhdsl.g:78:2: ( (lv_function_0_0= ruleFunction ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalWhdsl.g:79:3: (lv_function_0_0= ruleFunction )
            	    {
            	    // InternalWhdsl.g:79:3: (lv_function_0_0= ruleFunction )
            	    // InternalWhdsl.g:80:4: lv_function_0_0= ruleFunction
            	    {

            	    				newCompositeNode(grammarAccess.getProgramAccess().getFunctionFunctionParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_function_0_0=ruleFunction();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getProgramRule());
            	    				}
            	    				add(
            	    					current,
            	    					"function",
            	    					lv_function_0_0,
            	    					"esir.compilation.Whdsl.Function");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleFunction"
    // InternalWhdsl.g:100:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalWhdsl.g:100:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalWhdsl.g:101:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalWhdsl.g:107:1: ruleFunction returns [EObject current=null] : (otherlv_0= 'function' ( (lv_name_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_definition_3_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:113:2: ( (otherlv_0= 'function' ( (lv_name_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) ) ) )
            // InternalWhdsl.g:114:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) ) )
            {
            // InternalWhdsl.g:114:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) ) )
            // InternalWhdsl.g:115:3: otherlv_0= 'function' ( (lv_name_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getFunctionKeyword_0());
            		
            // InternalWhdsl.g:119:3: ( (lv_name_1_0= RULE_SYMBOLE ) )
            // InternalWhdsl.g:120:4: (lv_name_1_0= RULE_SYMBOLE )
            {
            // InternalWhdsl.g:120:4: (lv_name_1_0= RULE_SYMBOLE )
            // InternalWhdsl.g:121:5: lv_name_1_0= RULE_SYMBOLE
            {
            lv_name_1_0=(Token)match(input,RULE_SYMBOLE,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameSYMBOLETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"esir.compilation.Whdsl.SYMBOLE");
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getColonKeyword_2());
            		
            // InternalWhdsl.g:141:3: ( (lv_definition_3_0= ruleDefinition ) )
            // InternalWhdsl.g:142:4: (lv_definition_3_0= ruleDefinition )
            {
            // InternalWhdsl.g:142:4: (lv_definition_3_0= ruleDefinition )
            // InternalWhdsl.g:143:5: lv_definition_3_0= ruleDefinition
            {

            					newCompositeNode(grammarAccess.getFunctionAccess().getDefinitionDefinitionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_definition_3_0=ruleDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionRule());
            					}
            					set(
            						current,
            						"definition",
            						lv_definition_3_0,
            						"esir.compilation.Whdsl.Definition");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleDefinition"
    // InternalWhdsl.g:164:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalWhdsl.g:164:51: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalWhdsl.g:165:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // InternalWhdsl.g:171:1: ruleDefinition returns [EObject current=null] : ( ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' otherlv_2= '%' ( (lv_output_3_0= ruleOutput ) ) ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_input_0_0 = null;

        EObject lv_output_3_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:177:2: ( ( ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' otherlv_2= '%' ( (lv_output_3_0= ruleOutput ) ) ) )
            // InternalWhdsl.g:178:2: ( ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' otherlv_2= '%' ( (lv_output_3_0= ruleOutput ) ) )
            {
            // InternalWhdsl.g:178:2: ( ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' otherlv_2= '%' ( (lv_output_3_0= ruleOutput ) ) )
            // InternalWhdsl.g:179:3: ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' otherlv_2= '%' ( (lv_output_3_0= ruleOutput ) )
            {
            // InternalWhdsl.g:179:3: ( (lv_input_0_0= ruleInput ) )
            // InternalWhdsl.g:180:4: (lv_input_0_0= ruleInput )
            {
            // InternalWhdsl.g:180:4: (lv_input_0_0= ruleInput )
            // InternalWhdsl.g:181:5: lv_input_0_0= ruleInput
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getInputInputParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_input_0_0=ruleInput();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					set(
            						current,
            						"input",
            						lv_input_0_0,
            						"esir.compilation.Whdsl.Input");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getDefinitionAccess().getPercentSignKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getPercentSignKeyword_2());
            		
            // InternalWhdsl.g:206:3: ( (lv_output_3_0= ruleOutput ) )
            // InternalWhdsl.g:207:4: (lv_output_3_0= ruleOutput )
            {
            // InternalWhdsl.g:207:4: (lv_output_3_0= ruleOutput )
            // InternalWhdsl.g:208:5: lv_output_3_0= ruleOutput
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getOutputOutputParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_output_3_0=ruleOutput();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					set(
            						current,
            						"output",
            						lv_output_3_0,
            						"esir.compilation.Whdsl.Output");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleInput"
    // InternalWhdsl.g:229:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalWhdsl.g:229:46: (iv_ruleInput= ruleInput EOF )
            // InternalWhdsl.g:230:2: iv_ruleInput= ruleInput EOF
            {
             newCompositeNode(grammarAccess.getInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInput=ruleInput();

            state._fsp--;

             current =iv_ruleInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInput"


    // $ANTLR start "ruleInput"
    // InternalWhdsl.g:236:1: ruleInput returns [EObject current=null] : (otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* ) ;
    public final EObject ruleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variables_1_0=null;
        Token otherlv_2=null;
        Token lv_variables_3_0=null;


        	enterRule();

        try {
            // InternalWhdsl.g:242:2: ( (otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* ) )
            // InternalWhdsl.g:243:2: (otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* )
            {
            // InternalWhdsl.g:243:2: (otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* )
            // InternalWhdsl.g:244:3: otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )*
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getInputAccess().getReadKeyword_0());
            		
            // InternalWhdsl.g:248:3: ( (lv_variables_1_0= RULE_VARIABLE ) )
            // InternalWhdsl.g:249:4: (lv_variables_1_0= RULE_VARIABLE )
            {
            // InternalWhdsl.g:249:4: (lv_variables_1_0= RULE_VARIABLE )
            // InternalWhdsl.g:250:5: lv_variables_1_0= RULE_VARIABLE
            {
            lv_variables_1_0=(Token)match(input,RULE_VARIABLE,FOLLOW_10); 

            					newLeafNode(lv_variables_1_0, grammarAccess.getInputAccess().getVariablesVARIABLETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInputRule());
            					}
            					addWithLastConsumed(
            						current,
            						"variables",
            						lv_variables_1_0,
            						"esir.compilation.Whdsl.VARIABLE");
            				

            }


            }

            // InternalWhdsl.g:266:3: (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalWhdsl.g:267:4: otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_9); 

            	    				newLeafNode(otherlv_2, grammarAccess.getInputAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalWhdsl.g:271:4: ( (lv_variables_3_0= RULE_VARIABLE ) )
            	    // InternalWhdsl.g:272:5: (lv_variables_3_0= RULE_VARIABLE )
            	    {
            	    // InternalWhdsl.g:272:5: (lv_variables_3_0= RULE_VARIABLE )
            	    // InternalWhdsl.g:273:6: lv_variables_3_0= RULE_VARIABLE
            	    {
            	    lv_variables_3_0=(Token)match(input,RULE_VARIABLE,FOLLOW_10); 

            	    						newLeafNode(lv_variables_3_0, grammarAccess.getInputAccess().getVariablesVARIABLETerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getInputRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"variables",
            	    							lv_variables_3_0,
            	    							"esir.compilation.Whdsl.VARIABLE");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInput"


    // $ANTLR start "entryRuleOutput"
    // InternalWhdsl.g:294:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // InternalWhdsl.g:294:47: (iv_ruleOutput= ruleOutput EOF )
            // InternalWhdsl.g:295:2: iv_ruleOutput= ruleOutput EOF
            {
             newCompositeNode(grammarAccess.getOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutput=ruleOutput();

            state._fsp--;

             current =iv_ruleOutput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // InternalWhdsl.g:301:1: ruleOutput returns [EObject current=null] : (otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variables_1_0=null;
        Token otherlv_2=null;
        Token lv_variables_3_0=null;


        	enterRule();

        try {
            // InternalWhdsl.g:307:2: ( (otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* ) )
            // InternalWhdsl.g:308:2: (otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* )
            {
            // InternalWhdsl.g:308:2: (otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* )
            // InternalWhdsl.g:309:3: otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )*
            {
            otherlv_0=(Token)match(input,19,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getOutputAccess().getWriteKeyword_0());
            		
            // InternalWhdsl.g:313:3: ( (lv_variables_1_0= RULE_VARIABLE ) )
            // InternalWhdsl.g:314:4: (lv_variables_1_0= RULE_VARIABLE )
            {
            // InternalWhdsl.g:314:4: (lv_variables_1_0= RULE_VARIABLE )
            // InternalWhdsl.g:315:5: lv_variables_1_0= RULE_VARIABLE
            {
            lv_variables_1_0=(Token)match(input,RULE_VARIABLE,FOLLOW_10); 

            					newLeafNode(lv_variables_1_0, grammarAccess.getOutputAccess().getVariablesVARIABLETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutputRule());
            					}
            					addWithLastConsumed(
            						current,
            						"variables",
            						lv_variables_1_0,
            						"esir.compilation.Whdsl.VARIABLE");
            				

            }


            }

            // InternalWhdsl.g:331:3: (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalWhdsl.g:332:4: otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_9); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOutputAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalWhdsl.g:336:4: ( (lv_variables_3_0= RULE_VARIABLE ) )
            	    // InternalWhdsl.g:337:5: (lv_variables_3_0= RULE_VARIABLE )
            	    {
            	    // InternalWhdsl.g:337:5: (lv_variables_3_0= RULE_VARIABLE )
            	    // InternalWhdsl.g:338:6: lv_variables_3_0= RULE_VARIABLE
            	    {
            	    lv_variables_3_0=(Token)match(input,RULE_VARIABLE,FOLLOW_10); 

            	    						newLeafNode(lv_variables_3_0, grammarAccess.getOutputAccess().getVariablesVARIABLETerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getOutputRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"variables",
            	    							lv_variables_3_0,
            	    							"esir.compilation.Whdsl.VARIABLE");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutput"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040002L});

}