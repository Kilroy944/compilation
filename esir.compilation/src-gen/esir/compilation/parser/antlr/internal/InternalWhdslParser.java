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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SYMBOLE", "RULE_VARIABLE", "RULE_NIL", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'function'", "':'", "'%'", "'read'", "','", "'write'", "';'", "'if'", "'then'", "'else'", "'fi'", "':='", "'for'", "'do'", "'od'", "'while'", "'nop'", "'1'"
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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=7;
    public static final int RULE_WS=12;
    public static final int RULE_VARIABLE=5;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_SYMBOLE=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // InternalWhdsl.g:171:1: ruleDefinition returns [EObject current=null] : ( ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' ( (lv_commands_2_0= ruleCommands ) ) otherlv_3= '%' ( (lv_output_4_0= ruleOutput ) ) ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_input_0_0 = null;

        EObject lv_commands_2_0 = null;

        EObject lv_output_4_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:177:2: ( ( ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' ( (lv_commands_2_0= ruleCommands ) ) otherlv_3= '%' ( (lv_output_4_0= ruleOutput ) ) ) )
            // InternalWhdsl.g:178:2: ( ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' ( (lv_commands_2_0= ruleCommands ) ) otherlv_3= '%' ( (lv_output_4_0= ruleOutput ) ) )
            {
            // InternalWhdsl.g:178:2: ( ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' ( (lv_commands_2_0= ruleCommands ) ) otherlv_3= '%' ( (lv_output_4_0= ruleOutput ) ) )
            // InternalWhdsl.g:179:3: ( (lv_input_0_0= ruleInput ) ) otherlv_1= '%' ( (lv_commands_2_0= ruleCommands ) ) otherlv_3= '%' ( (lv_output_4_0= ruleOutput ) )
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

            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getDefinitionAccess().getPercentSignKeyword_1());
            		
            // InternalWhdsl.g:202:3: ( (lv_commands_2_0= ruleCommands ) )
            // InternalWhdsl.g:203:4: (lv_commands_2_0= ruleCommands )
            {
            // InternalWhdsl.g:203:4: (lv_commands_2_0= ruleCommands )
            // InternalWhdsl.g:204:5: lv_commands_2_0= ruleCommands
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getCommandsCommandsParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_commands_2_0=ruleCommands();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					set(
            						current,
            						"commands",
            						lv_commands_2_0,
            						"esir.compilation.Whdsl.Commands");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getDefinitionAccess().getPercentSignKeyword_3());
            		
            // InternalWhdsl.g:225:3: ( (lv_output_4_0= ruleOutput ) )
            // InternalWhdsl.g:226:4: (lv_output_4_0= ruleOutput )
            {
            // InternalWhdsl.g:226:4: (lv_output_4_0= ruleOutput )
            // InternalWhdsl.g:227:5: lv_output_4_0= ruleOutput
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getOutputOutputParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_output_4_0=ruleOutput();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					set(
            						current,
            						"output",
            						lv_output_4_0,
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
    // InternalWhdsl.g:248:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalWhdsl.g:248:46: (iv_ruleInput= ruleInput EOF )
            // InternalWhdsl.g:249:2: iv_ruleInput= ruleInput EOF
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
    // InternalWhdsl.g:255:1: ruleInput returns [EObject current=null] : (otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* ) ;
    public final EObject ruleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variables_1_0=null;
        Token otherlv_2=null;
        Token lv_variables_3_0=null;


        	enterRule();

        try {
            // InternalWhdsl.g:261:2: ( (otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* ) )
            // InternalWhdsl.g:262:2: (otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* )
            {
            // InternalWhdsl.g:262:2: (otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* )
            // InternalWhdsl.g:263:3: otherlv_0= 'read' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )*
            {
            otherlv_0=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getInputAccess().getReadKeyword_0());
            		
            // InternalWhdsl.g:267:3: ( (lv_variables_1_0= RULE_VARIABLE ) )
            // InternalWhdsl.g:268:4: (lv_variables_1_0= RULE_VARIABLE )
            {
            // InternalWhdsl.g:268:4: (lv_variables_1_0= RULE_VARIABLE )
            // InternalWhdsl.g:269:5: lv_variables_1_0= RULE_VARIABLE
            {
            lv_variables_1_0=(Token)match(input,RULE_VARIABLE,FOLLOW_11); 

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

            // InternalWhdsl.g:285:3: (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalWhdsl.g:286:4: otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getInputAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalWhdsl.g:290:4: ( (lv_variables_3_0= RULE_VARIABLE ) )
            	    // InternalWhdsl.g:291:5: (lv_variables_3_0= RULE_VARIABLE )
            	    {
            	    // InternalWhdsl.g:291:5: (lv_variables_3_0= RULE_VARIABLE )
            	    // InternalWhdsl.g:292:6: lv_variables_3_0= RULE_VARIABLE
            	    {
            	    lv_variables_3_0=(Token)match(input,RULE_VARIABLE,FOLLOW_11); 

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
    // InternalWhdsl.g:313:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // InternalWhdsl.g:313:47: (iv_ruleOutput= ruleOutput EOF )
            // InternalWhdsl.g:314:2: iv_ruleOutput= ruleOutput EOF
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
    // InternalWhdsl.g:320:1: ruleOutput returns [EObject current=null] : (otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_variables_1_0=null;
        Token otherlv_2=null;
        Token lv_variables_3_0=null;


        	enterRule();

        try {
            // InternalWhdsl.g:326:2: ( (otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* ) )
            // InternalWhdsl.g:327:2: (otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* )
            {
            // InternalWhdsl.g:327:2: (otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )* )
            // InternalWhdsl.g:328:3: otherlv_0= 'write' ( (lv_variables_1_0= RULE_VARIABLE ) ) (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )*
            {
            otherlv_0=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getOutputAccess().getWriteKeyword_0());
            		
            // InternalWhdsl.g:332:3: ( (lv_variables_1_0= RULE_VARIABLE ) )
            // InternalWhdsl.g:333:4: (lv_variables_1_0= RULE_VARIABLE )
            {
            // InternalWhdsl.g:333:4: (lv_variables_1_0= RULE_VARIABLE )
            // InternalWhdsl.g:334:5: lv_variables_1_0= RULE_VARIABLE
            {
            lv_variables_1_0=(Token)match(input,RULE_VARIABLE,FOLLOW_11); 

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

            // InternalWhdsl.g:350:3: (otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalWhdsl.g:351:4: otherlv_2= ',' ( (lv_variables_3_0= RULE_VARIABLE ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_10); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOutputAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalWhdsl.g:355:4: ( (lv_variables_3_0= RULE_VARIABLE ) )
            	    // InternalWhdsl.g:356:5: (lv_variables_3_0= RULE_VARIABLE )
            	    {
            	    // InternalWhdsl.g:356:5: (lv_variables_3_0= RULE_VARIABLE )
            	    // InternalWhdsl.g:357:6: lv_variables_3_0= RULE_VARIABLE
            	    {
            	    lv_variables_3_0=(Token)match(input,RULE_VARIABLE,FOLLOW_11); 

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


    // $ANTLR start "entryRuleCommands"
    // InternalWhdsl.g:378:1: entryRuleCommands returns [EObject current=null] : iv_ruleCommands= ruleCommands EOF ;
    public final EObject entryRuleCommands() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommands = null;


        try {
            // InternalWhdsl.g:378:49: (iv_ruleCommands= ruleCommands EOF )
            // InternalWhdsl.g:379:2: iv_ruleCommands= ruleCommands EOF
            {
             newCompositeNode(grammarAccess.getCommandsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCommands=ruleCommands();

            state._fsp--;

             current =iv_ruleCommands; 
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
    // $ANTLR end "entryRuleCommands"


    // $ANTLR start "ruleCommands"
    // InternalWhdsl.g:385:1: ruleCommands returns [EObject current=null] : ( ( (lv_command_0_0= ruleCommand ) ) (otherlv_1= ';' ( (lv_commands_2_0= ruleCommand ) ) )* ) ;
    public final EObject ruleCommands() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_command_0_0 = null;

        EObject lv_commands_2_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:391:2: ( ( ( (lv_command_0_0= ruleCommand ) ) (otherlv_1= ';' ( (lv_commands_2_0= ruleCommand ) ) )* ) )
            // InternalWhdsl.g:392:2: ( ( (lv_command_0_0= ruleCommand ) ) (otherlv_1= ';' ( (lv_commands_2_0= ruleCommand ) ) )* )
            {
            // InternalWhdsl.g:392:2: ( ( (lv_command_0_0= ruleCommand ) ) (otherlv_1= ';' ( (lv_commands_2_0= ruleCommand ) ) )* )
            // InternalWhdsl.g:393:3: ( (lv_command_0_0= ruleCommand ) ) (otherlv_1= ';' ( (lv_commands_2_0= ruleCommand ) ) )*
            {
            // InternalWhdsl.g:393:3: ( (lv_command_0_0= ruleCommand ) )
            // InternalWhdsl.g:394:4: (lv_command_0_0= ruleCommand )
            {
            // InternalWhdsl.g:394:4: (lv_command_0_0= ruleCommand )
            // InternalWhdsl.g:395:5: lv_command_0_0= ruleCommand
            {

            					newCompositeNode(grammarAccess.getCommandsAccess().getCommandCommandParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_command_0_0=ruleCommand();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCommandsRule());
            					}
            					set(
            						current,
            						"command",
            						lv_command_0_0,
            						"esir.compilation.Whdsl.Command");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWhdsl.g:412:3: (otherlv_1= ';' ( (lv_commands_2_0= ruleCommand ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalWhdsl.g:413:4: otherlv_1= ';' ( (lv_commands_2_0= ruleCommand ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCommandsAccess().getSemicolonKeyword_1_0());
            	    			
            	    // InternalWhdsl.g:417:4: ( (lv_commands_2_0= ruleCommand ) )
            	    // InternalWhdsl.g:418:5: (lv_commands_2_0= ruleCommand )
            	    {
            	    // InternalWhdsl.g:418:5: (lv_commands_2_0= ruleCommand )
            	    // InternalWhdsl.g:419:6: lv_commands_2_0= ruleCommand
            	    {

            	    						newCompositeNode(grammarAccess.getCommandsAccess().getCommandsCommandParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_commands_2_0=ruleCommand();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCommandsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"commands",
            	    							lv_commands_2_0,
            	    							"esir.compilation.Whdsl.Command");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleCommands"


    // $ANTLR start "entryRuleCommand"
    // InternalWhdsl.g:441:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // InternalWhdsl.g:441:48: (iv_ruleCommand= ruleCommand EOF )
            // InternalWhdsl.g:442:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
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
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // InternalWhdsl.g:448:1: ruleCommand returns [EObject current=null] : ( ( (lv_cmd_0_0= ruleNop ) ) | ( (lv_cmd_1_0= ruleAffect ) ) | ( (lv_cmd_2_0= ruleIf ) ) | ( (lv_cmd_3_0= ruleFor ) ) | ( (lv_cmd_4_0= ruleWhile ) ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        EObject lv_cmd_0_0 = null;

        EObject lv_cmd_1_0 = null;

        EObject lv_cmd_2_0 = null;

        EObject lv_cmd_3_0 = null;

        EObject lv_cmd_4_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:454:2: ( ( ( (lv_cmd_0_0= ruleNop ) ) | ( (lv_cmd_1_0= ruleAffect ) ) | ( (lv_cmd_2_0= ruleIf ) ) | ( (lv_cmd_3_0= ruleFor ) ) | ( (lv_cmd_4_0= ruleWhile ) ) ) )
            // InternalWhdsl.g:455:2: ( ( (lv_cmd_0_0= ruleNop ) ) | ( (lv_cmd_1_0= ruleAffect ) ) | ( (lv_cmd_2_0= ruleIf ) ) | ( (lv_cmd_3_0= ruleFor ) ) | ( (lv_cmd_4_0= ruleWhile ) ) )
            {
            // InternalWhdsl.g:455:2: ( ( (lv_cmd_0_0= ruleNop ) ) | ( (lv_cmd_1_0= ruleAffect ) ) | ( (lv_cmd_2_0= ruleIf ) ) | ( (lv_cmd_3_0= ruleFor ) ) | ( (lv_cmd_4_0= ruleWhile ) ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt5=1;
                }
                break;
            case RULE_VARIABLE:
                {
                alt5=2;
                }
                break;
            case 21:
                {
                alt5=3;
                }
                break;
            case 26:
                {
                alt5=4;
                }
                break;
            case 29:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalWhdsl.g:456:3: ( (lv_cmd_0_0= ruleNop ) )
                    {
                    // InternalWhdsl.g:456:3: ( (lv_cmd_0_0= ruleNop ) )
                    // InternalWhdsl.g:457:4: (lv_cmd_0_0= ruleNop )
                    {
                    // InternalWhdsl.g:457:4: (lv_cmd_0_0= ruleNop )
                    // InternalWhdsl.g:458:5: lv_cmd_0_0= ruleNop
                    {

                    					newCompositeNode(grammarAccess.getCommandAccess().getCmdNopParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cmd_0_0=ruleNop();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getCommandRule());
                    					}
                    					set(
                    						current,
                    						"cmd",
                    						lv_cmd_0_0,
                    						"esir.compilation.Whdsl.Nop");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWhdsl.g:476:3: ( (lv_cmd_1_0= ruleAffect ) )
                    {
                    // InternalWhdsl.g:476:3: ( (lv_cmd_1_0= ruleAffect ) )
                    // InternalWhdsl.g:477:4: (lv_cmd_1_0= ruleAffect )
                    {
                    // InternalWhdsl.g:477:4: (lv_cmd_1_0= ruleAffect )
                    // InternalWhdsl.g:478:5: lv_cmd_1_0= ruleAffect
                    {

                    					newCompositeNode(grammarAccess.getCommandAccess().getCmdAffectParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cmd_1_0=ruleAffect();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getCommandRule());
                    					}
                    					set(
                    						current,
                    						"cmd",
                    						lv_cmd_1_0,
                    						"esir.compilation.Whdsl.Affect");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWhdsl.g:496:3: ( (lv_cmd_2_0= ruleIf ) )
                    {
                    // InternalWhdsl.g:496:3: ( (lv_cmd_2_0= ruleIf ) )
                    // InternalWhdsl.g:497:4: (lv_cmd_2_0= ruleIf )
                    {
                    // InternalWhdsl.g:497:4: (lv_cmd_2_0= ruleIf )
                    // InternalWhdsl.g:498:5: lv_cmd_2_0= ruleIf
                    {

                    					newCompositeNode(grammarAccess.getCommandAccess().getCmdIfParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cmd_2_0=ruleIf();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getCommandRule());
                    					}
                    					set(
                    						current,
                    						"cmd",
                    						lv_cmd_2_0,
                    						"esir.compilation.Whdsl.If");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalWhdsl.g:516:3: ( (lv_cmd_3_0= ruleFor ) )
                    {
                    // InternalWhdsl.g:516:3: ( (lv_cmd_3_0= ruleFor ) )
                    // InternalWhdsl.g:517:4: (lv_cmd_3_0= ruleFor )
                    {
                    // InternalWhdsl.g:517:4: (lv_cmd_3_0= ruleFor )
                    // InternalWhdsl.g:518:5: lv_cmd_3_0= ruleFor
                    {

                    					newCompositeNode(grammarAccess.getCommandAccess().getCmdForParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cmd_3_0=ruleFor();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getCommandRule());
                    					}
                    					set(
                    						current,
                    						"cmd",
                    						lv_cmd_3_0,
                    						"esir.compilation.Whdsl.For");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalWhdsl.g:536:3: ( (lv_cmd_4_0= ruleWhile ) )
                    {
                    // InternalWhdsl.g:536:3: ( (lv_cmd_4_0= ruleWhile ) )
                    // InternalWhdsl.g:537:4: (lv_cmd_4_0= ruleWhile )
                    {
                    // InternalWhdsl.g:537:4: (lv_cmd_4_0= ruleWhile )
                    // InternalWhdsl.g:538:5: lv_cmd_4_0= ruleWhile
                    {

                    					newCompositeNode(grammarAccess.getCommandAccess().getCmdWhileParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cmd_4_0=ruleWhile();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getCommandRule());
                    					}
                    					set(
                    						current,
                    						"cmd",
                    						lv_cmd_4_0,
                    						"esir.compilation.Whdsl.While");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleExprs"
    // InternalWhdsl.g:559:1: entryRuleExprs returns [EObject current=null] : iv_ruleExprs= ruleExprs EOF ;
    public final EObject entryRuleExprs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExprs = null;


        try {
            // InternalWhdsl.g:559:46: (iv_ruleExprs= ruleExprs EOF )
            // InternalWhdsl.g:560:2: iv_ruleExprs= ruleExprs EOF
            {
             newCompositeNode(grammarAccess.getExprsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExprs=ruleExprs();

            state._fsp--;

             current =iv_ruleExprs; 
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
    // $ANTLR end "entryRuleExprs"


    // $ANTLR start "ruleExprs"
    // InternalWhdsl.g:566:1: ruleExprs returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpr ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpr ) ) )* ) ;
    public final EObject ruleExprs() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_expr_0_0 = null;

        AntlrDatatypeRuleToken lv_exprs_2_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:572:2: ( ( ( (lv_expr_0_0= ruleExpr ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpr ) ) )* ) )
            // InternalWhdsl.g:573:2: ( ( (lv_expr_0_0= ruleExpr ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpr ) ) )* )
            {
            // InternalWhdsl.g:573:2: ( ( (lv_expr_0_0= ruleExpr ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpr ) ) )* )
            // InternalWhdsl.g:574:3: ( (lv_expr_0_0= ruleExpr ) ) (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpr ) ) )*
            {
            // InternalWhdsl.g:574:3: ( (lv_expr_0_0= ruleExpr ) )
            // InternalWhdsl.g:575:4: (lv_expr_0_0= ruleExpr )
            {
            // InternalWhdsl.g:575:4: (lv_expr_0_0= ruleExpr )
            // InternalWhdsl.g:576:5: lv_expr_0_0= ruleExpr
            {

            					newCompositeNode(grammarAccess.getExprsAccess().getExprExprParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_expr_0_0=ruleExpr();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExprsRule());
            					}
            					set(
            						current,
            						"expr",
            						lv_expr_0_0,
            						"esir.compilation.Whdsl.Expr");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWhdsl.g:593:3: (otherlv_1= ',' ( (lv_exprs_2_0= ruleExpr ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalWhdsl.g:594:4: otherlv_1= ',' ( (lv_exprs_2_0= ruleExpr ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_13); 

            	    				newLeafNode(otherlv_1, grammarAccess.getExprsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalWhdsl.g:598:4: ( (lv_exprs_2_0= ruleExpr ) )
            	    // InternalWhdsl.g:599:5: (lv_exprs_2_0= ruleExpr )
            	    {
            	    // InternalWhdsl.g:599:5: (lv_exprs_2_0= ruleExpr )
            	    // InternalWhdsl.g:600:6: lv_exprs_2_0= ruleExpr
            	    {

            	    						newCompositeNode(grammarAccess.getExprsAccess().getExprsExprParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_exprs_2_0=ruleExpr();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExprsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"exprs",
            	    							lv_exprs_2_0,
            	    							"esir.compilation.Whdsl.Expr");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "ruleExprs"


    // $ANTLR start "entryRuleIf"
    // InternalWhdsl.g:622:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // InternalWhdsl.g:622:43: (iv_ruleIf= ruleIf EOF )
            // InternalWhdsl.g:623:2: iv_ruleIf= ruleIf EOF
            {
             newCompositeNode(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIf=ruleIf();

            state._fsp--;

             current =iv_ruleIf; 
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
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // InternalWhdsl.g:629:1: ruleIf returns [EObject current=null] : (otherlv_0= 'if' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'then' ( (lv_cmds1_3_0= ruleCommands ) ) (otherlv_4= 'else' ( (lv_cmds2_5_0= ruleCommands ) ) )? otherlv_6= 'fi' ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_exprs_1_0 = null;

        EObject lv_cmds1_3_0 = null;

        EObject lv_cmds2_5_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:635:2: ( (otherlv_0= 'if' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'then' ( (lv_cmds1_3_0= ruleCommands ) ) (otherlv_4= 'else' ( (lv_cmds2_5_0= ruleCommands ) ) )? otherlv_6= 'fi' ) )
            // InternalWhdsl.g:636:2: (otherlv_0= 'if' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'then' ( (lv_cmds1_3_0= ruleCommands ) ) (otherlv_4= 'else' ( (lv_cmds2_5_0= ruleCommands ) ) )? otherlv_6= 'fi' )
            {
            // InternalWhdsl.g:636:2: (otherlv_0= 'if' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'then' ( (lv_cmds1_3_0= ruleCommands ) ) (otherlv_4= 'else' ( (lv_cmds2_5_0= ruleCommands ) ) )? otherlv_6= 'fi' )
            // InternalWhdsl.g:637:3: otherlv_0= 'if' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'then' ( (lv_cmds1_3_0= ruleCommands ) ) (otherlv_4= 'else' ( (lv_cmds2_5_0= ruleCommands ) ) )? otherlv_6= 'fi'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getIfAccess().getIfKeyword_0());
            		
            // InternalWhdsl.g:641:3: ( (lv_exprs_1_0= ruleExprs ) )
            // InternalWhdsl.g:642:4: (lv_exprs_1_0= ruleExprs )
            {
            // InternalWhdsl.g:642:4: (lv_exprs_1_0= ruleExprs )
            // InternalWhdsl.g:643:5: lv_exprs_1_0= ruleExprs
            {

            					newCompositeNode(grammarAccess.getIfAccess().getExprsExprsParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_14);
            lv_exprs_1_0=ruleExprs();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfRule());
            					}
            					set(
            						current,
            						"exprs",
            						lv_exprs_1_0,
            						"esir.compilation.Whdsl.Exprs");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getIfAccess().getThenKeyword_2());
            		
            // InternalWhdsl.g:664:3: ( (lv_cmds1_3_0= ruleCommands ) )
            // InternalWhdsl.g:665:4: (lv_cmds1_3_0= ruleCommands )
            {
            // InternalWhdsl.g:665:4: (lv_cmds1_3_0= ruleCommands )
            // InternalWhdsl.g:666:5: lv_cmds1_3_0= ruleCommands
            {

            					newCompositeNode(grammarAccess.getIfAccess().getCmds1CommandsParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_15);
            lv_cmds1_3_0=ruleCommands();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfRule());
            					}
            					set(
            						current,
            						"cmds1",
            						lv_cmds1_3_0,
            						"esir.compilation.Whdsl.Commands");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalWhdsl.g:683:3: (otherlv_4= 'else' ( (lv_cmds2_5_0= ruleCommands ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==23) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalWhdsl.g:684:4: otherlv_4= 'else' ( (lv_cmds2_5_0= ruleCommands ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getIfAccess().getElseKeyword_4_0());
                    			
                    // InternalWhdsl.g:688:4: ( (lv_cmds2_5_0= ruleCommands ) )
                    // InternalWhdsl.g:689:5: (lv_cmds2_5_0= ruleCommands )
                    {
                    // InternalWhdsl.g:689:5: (lv_cmds2_5_0= ruleCommands )
                    // InternalWhdsl.g:690:6: lv_cmds2_5_0= ruleCommands
                    {

                    						newCompositeNode(grammarAccess.getIfAccess().getCmds2CommandsParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_cmds2_5_0=ruleCommands();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIfRule());
                    						}
                    						set(
                    							current,
                    							"cmds2",
                    							lv_cmds2_5_0,
                    							"esir.compilation.Whdsl.Commands");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getIfAccess().getFiKeyword_5());
            		

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
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleAffect"
    // InternalWhdsl.g:716:1: entryRuleAffect returns [EObject current=null] : iv_ruleAffect= ruleAffect EOF ;
    public final EObject entryRuleAffect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAffect = null;


        try {
            // InternalWhdsl.g:716:47: (iv_ruleAffect= ruleAffect EOF )
            // InternalWhdsl.g:717:2: iv_ruleAffect= ruleAffect EOF
            {
             newCompositeNode(grammarAccess.getAffectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAffect=ruleAffect();

            state._fsp--;

             current =iv_ruleAffect; 
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
    // $ANTLR end "entryRuleAffect"


    // $ANTLR start "ruleAffect"
    // InternalWhdsl.g:723:1: ruleAffect returns [EObject current=null] : ( ( (lv_vars_0_0= ruleVars ) ) otherlv_1= ':=' ( (lv_exprs_2_0= ruleExprs ) ) ) ;
    public final EObject ruleAffect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_vars_0_0 = null;

        EObject lv_exprs_2_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:729:2: ( ( ( (lv_vars_0_0= ruleVars ) ) otherlv_1= ':=' ( (lv_exprs_2_0= ruleExprs ) ) ) )
            // InternalWhdsl.g:730:2: ( ( (lv_vars_0_0= ruleVars ) ) otherlv_1= ':=' ( (lv_exprs_2_0= ruleExprs ) ) )
            {
            // InternalWhdsl.g:730:2: ( ( (lv_vars_0_0= ruleVars ) ) otherlv_1= ':=' ( (lv_exprs_2_0= ruleExprs ) ) )
            // InternalWhdsl.g:731:3: ( (lv_vars_0_0= ruleVars ) ) otherlv_1= ':=' ( (lv_exprs_2_0= ruleExprs ) )
            {
            // InternalWhdsl.g:731:3: ( (lv_vars_0_0= ruleVars ) )
            // InternalWhdsl.g:732:4: (lv_vars_0_0= ruleVars )
            {
            // InternalWhdsl.g:732:4: (lv_vars_0_0= ruleVars )
            // InternalWhdsl.g:733:5: lv_vars_0_0= ruleVars
            {

            					newCompositeNode(grammarAccess.getAffectAccess().getVarsVarsParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_vars_0_0=ruleVars();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAffectRule());
            					}
            					set(
            						current,
            						"vars",
            						lv_vars_0_0,
            						"esir.compilation.Whdsl.Vars");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getAffectAccess().getColonEqualsSignKeyword_1());
            		
            // InternalWhdsl.g:754:3: ( (lv_exprs_2_0= ruleExprs ) )
            // InternalWhdsl.g:755:4: (lv_exprs_2_0= ruleExprs )
            {
            // InternalWhdsl.g:755:4: (lv_exprs_2_0= ruleExprs )
            // InternalWhdsl.g:756:5: lv_exprs_2_0= ruleExprs
            {

            					newCompositeNode(grammarAccess.getAffectAccess().getExprsExprsParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_exprs_2_0=ruleExprs();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAffectRule());
            					}
            					set(
            						current,
            						"exprs",
            						lv_exprs_2_0,
            						"esir.compilation.Whdsl.Exprs");
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
    // $ANTLR end "ruleAffect"


    // $ANTLR start "entryRuleFor"
    // InternalWhdsl.g:777:1: entryRuleFor returns [EObject current=null] : iv_ruleFor= ruleFor EOF ;
    public final EObject entryRuleFor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFor = null;


        try {
            // InternalWhdsl.g:777:44: (iv_ruleFor= ruleFor EOF )
            // InternalWhdsl.g:778:2: iv_ruleFor= ruleFor EOF
            {
             newCompositeNode(grammarAccess.getForRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFor=ruleFor();

            state._fsp--;

             current =iv_ruleFor; 
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
    // $ANTLR end "entryRuleFor"


    // $ANTLR start "ruleFor"
    // InternalWhdsl.g:784:1: ruleFor returns [EObject current=null] : (otherlv_0= 'for' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od' ) ;
    public final EObject ruleFor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_exprs_1_0 = null;

        EObject lv_cmds_3_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:790:2: ( (otherlv_0= 'for' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od' ) )
            // InternalWhdsl.g:791:2: (otherlv_0= 'for' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od' )
            {
            // InternalWhdsl.g:791:2: (otherlv_0= 'for' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od' )
            // InternalWhdsl.g:792:3: otherlv_0= 'for' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getForAccess().getForKeyword_0());
            		
            // InternalWhdsl.g:796:3: ( (lv_exprs_1_0= ruleExprs ) )
            // InternalWhdsl.g:797:4: (lv_exprs_1_0= ruleExprs )
            {
            // InternalWhdsl.g:797:4: (lv_exprs_1_0= ruleExprs )
            // InternalWhdsl.g:798:5: lv_exprs_1_0= ruleExprs
            {

            					newCompositeNode(grammarAccess.getForAccess().getExprsExprsParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_exprs_1_0=ruleExprs();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForRule());
            					}
            					set(
            						current,
            						"exprs",
            						lv_exprs_1_0,
            						"esir.compilation.Whdsl.Exprs");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getForAccess().getDoKeyword_2());
            		
            // InternalWhdsl.g:819:3: ( (lv_cmds_3_0= ruleCommands ) )
            // InternalWhdsl.g:820:4: (lv_cmds_3_0= ruleCommands )
            {
            // InternalWhdsl.g:820:4: (lv_cmds_3_0= ruleCommands )
            // InternalWhdsl.g:821:5: lv_cmds_3_0= ruleCommands
            {

            					newCompositeNode(grammarAccess.getForAccess().getCmdsCommandsParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_19);
            lv_cmds_3_0=ruleCommands();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForRule());
            					}
            					set(
            						current,
            						"cmds",
            						lv_cmds_3_0,
            						"esir.compilation.Whdsl.Commands");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getForAccess().getOdKeyword_4());
            		

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
    // $ANTLR end "ruleFor"


    // $ANTLR start "entryRuleWhile"
    // InternalWhdsl.g:846:1: entryRuleWhile returns [EObject current=null] : iv_ruleWhile= ruleWhile EOF ;
    public final EObject entryRuleWhile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhile = null;


        try {
            // InternalWhdsl.g:846:46: (iv_ruleWhile= ruleWhile EOF )
            // InternalWhdsl.g:847:2: iv_ruleWhile= ruleWhile EOF
            {
             newCompositeNode(grammarAccess.getWhileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhile=ruleWhile();

            state._fsp--;

             current =iv_ruleWhile; 
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
    // $ANTLR end "entryRuleWhile"


    // $ANTLR start "ruleWhile"
    // InternalWhdsl.g:853:1: ruleWhile returns [EObject current=null] : (otherlv_0= 'while' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od' ) ;
    public final EObject ruleWhile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_exprs_1_0 = null;

        EObject lv_cmds_3_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:859:2: ( (otherlv_0= 'while' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od' ) )
            // InternalWhdsl.g:860:2: (otherlv_0= 'while' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od' )
            {
            // InternalWhdsl.g:860:2: (otherlv_0= 'while' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od' )
            // InternalWhdsl.g:861:3: otherlv_0= 'while' ( (lv_exprs_1_0= ruleExprs ) ) otherlv_2= 'do' ( (lv_cmds_3_0= ruleCommands ) ) otherlv_4= 'od'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getWhileAccess().getWhileKeyword_0());
            		
            // InternalWhdsl.g:865:3: ( (lv_exprs_1_0= ruleExprs ) )
            // InternalWhdsl.g:866:4: (lv_exprs_1_0= ruleExprs )
            {
            // InternalWhdsl.g:866:4: (lv_exprs_1_0= ruleExprs )
            // InternalWhdsl.g:867:5: lv_exprs_1_0= ruleExprs
            {

            					newCompositeNode(grammarAccess.getWhileAccess().getExprsExprsParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_exprs_1_0=ruleExprs();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhileRule());
            					}
            					set(
            						current,
            						"exprs",
            						lv_exprs_1_0,
            						"esir.compilation.Whdsl.Exprs");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getWhileAccess().getDoKeyword_2());
            		
            // InternalWhdsl.g:888:3: ( (lv_cmds_3_0= ruleCommands ) )
            // InternalWhdsl.g:889:4: (lv_cmds_3_0= ruleCommands )
            {
            // InternalWhdsl.g:889:4: (lv_cmds_3_0= ruleCommands )
            // InternalWhdsl.g:890:5: lv_cmds_3_0= ruleCommands
            {

            					newCompositeNode(grammarAccess.getWhileAccess().getCmdsCommandsParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_19);
            lv_cmds_3_0=ruleCommands();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhileRule());
            					}
            					set(
            						current,
            						"cmds",
            						lv_cmds_3_0,
            						"esir.compilation.Whdsl.Commands");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getWhileAccess().getOdKeyword_4());
            		

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
    // $ANTLR end "ruleWhile"


    // $ANTLR start "entryRuleNop"
    // InternalWhdsl.g:915:1: entryRuleNop returns [EObject current=null] : iv_ruleNop= ruleNop EOF ;
    public final EObject entryRuleNop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNop = null;


        try {
            // InternalWhdsl.g:915:44: (iv_ruleNop= ruleNop EOF )
            // InternalWhdsl.g:916:2: iv_ruleNop= ruleNop EOF
            {
             newCompositeNode(grammarAccess.getNopRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNop=ruleNop();

            state._fsp--;

             current =iv_ruleNop; 
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
    // $ANTLR end "entryRuleNop"


    // $ANTLR start "ruleNop"
    // InternalWhdsl.g:922:1: ruleNop returns [EObject current=null] : ( (lv_nop_0_0= 'nop' ) ) ;
    public final EObject ruleNop() throws RecognitionException {
        EObject current = null;

        Token lv_nop_0_0=null;


        	enterRule();

        try {
            // InternalWhdsl.g:928:2: ( ( (lv_nop_0_0= 'nop' ) ) )
            // InternalWhdsl.g:929:2: ( (lv_nop_0_0= 'nop' ) )
            {
            // InternalWhdsl.g:929:2: ( (lv_nop_0_0= 'nop' ) )
            // InternalWhdsl.g:930:3: (lv_nop_0_0= 'nop' )
            {
            // InternalWhdsl.g:930:3: (lv_nop_0_0= 'nop' )
            // InternalWhdsl.g:931:4: lv_nop_0_0= 'nop'
            {
            lv_nop_0_0=(Token)match(input,30,FOLLOW_2); 

            				newLeafNode(lv_nop_0_0, grammarAccess.getNopAccess().getNopNopKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNopRule());
            				}
            				setWithLastConsumed(current, "nop", lv_nop_0_0, "nop");
            			

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
    // $ANTLR end "ruleNop"


    // $ANTLR start "entryRuleVars"
    // InternalWhdsl.g:946:1: entryRuleVars returns [EObject current=null] : iv_ruleVars= ruleVars EOF ;
    public final EObject entryRuleVars() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVars = null;


        try {
            // InternalWhdsl.g:946:45: (iv_ruleVars= ruleVars EOF )
            // InternalWhdsl.g:947:2: iv_ruleVars= ruleVars EOF
            {
             newCompositeNode(grammarAccess.getVarsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVars=ruleVars();

            state._fsp--;

             current =iv_ruleVars; 
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
    // $ANTLR end "entryRuleVars"


    // $ANTLR start "ruleVars"
    // InternalWhdsl.g:953:1: ruleVars returns [EObject current=null] : ( ( (lv_var_0_0= RULE_VARIABLE ) ) (otherlv_1= ',' ( (lv_vars_2_0= RULE_VARIABLE ) ) )* ) ;
    public final EObject ruleVars() throws RecognitionException {
        EObject current = null;

        Token lv_var_0_0=null;
        Token otherlv_1=null;
        Token lv_vars_2_0=null;


        	enterRule();

        try {
            // InternalWhdsl.g:959:2: ( ( ( (lv_var_0_0= RULE_VARIABLE ) ) (otherlv_1= ',' ( (lv_vars_2_0= RULE_VARIABLE ) ) )* ) )
            // InternalWhdsl.g:960:2: ( ( (lv_var_0_0= RULE_VARIABLE ) ) (otherlv_1= ',' ( (lv_vars_2_0= RULE_VARIABLE ) ) )* )
            {
            // InternalWhdsl.g:960:2: ( ( (lv_var_0_0= RULE_VARIABLE ) ) (otherlv_1= ',' ( (lv_vars_2_0= RULE_VARIABLE ) ) )* )
            // InternalWhdsl.g:961:3: ( (lv_var_0_0= RULE_VARIABLE ) ) (otherlv_1= ',' ( (lv_vars_2_0= RULE_VARIABLE ) ) )*
            {
            // InternalWhdsl.g:961:3: ( (lv_var_0_0= RULE_VARIABLE ) )
            // InternalWhdsl.g:962:4: (lv_var_0_0= RULE_VARIABLE )
            {
            // InternalWhdsl.g:962:4: (lv_var_0_0= RULE_VARIABLE )
            // InternalWhdsl.g:963:5: lv_var_0_0= RULE_VARIABLE
            {
            lv_var_0_0=(Token)match(input,RULE_VARIABLE,FOLLOW_11); 

            					newLeafNode(lv_var_0_0, grammarAccess.getVarsAccess().getVarVARIABLETerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVarsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"var",
            						lv_var_0_0,
            						"esir.compilation.Whdsl.VARIABLE");
            				

            }


            }

            // InternalWhdsl.g:979:3: (otherlv_1= ',' ( (lv_vars_2_0= RULE_VARIABLE ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalWhdsl.g:980:4: otherlv_1= ',' ( (lv_vars_2_0= RULE_VARIABLE ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_10); 

            	    				newLeafNode(otherlv_1, grammarAccess.getVarsAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalWhdsl.g:984:4: ( (lv_vars_2_0= RULE_VARIABLE ) )
            	    // InternalWhdsl.g:985:5: (lv_vars_2_0= RULE_VARIABLE )
            	    {
            	    // InternalWhdsl.g:985:5: (lv_vars_2_0= RULE_VARIABLE )
            	    // InternalWhdsl.g:986:6: lv_vars_2_0= RULE_VARIABLE
            	    {
            	    lv_vars_2_0=(Token)match(input,RULE_VARIABLE,FOLLOW_11); 

            	    						newLeafNode(lv_vars_2_0, grammarAccess.getVarsAccess().getVarsVARIABLETerminalRuleCall_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getVarsRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"vars",
            	    							lv_vars_2_0,
            	    							"esir.compilation.Whdsl.VARIABLE");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleVars"


    // $ANTLR start "entryRuleExpr"
    // InternalWhdsl.g:1007:1: entryRuleExpr returns [String current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final String entryRuleExpr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExpr = null;


        try {
            // InternalWhdsl.g:1007:44: (iv_ruleExpr= ruleExpr EOF )
            // InternalWhdsl.g:1008:2: iv_ruleExpr= ruleExpr EOF
            {
             newCompositeNode(grammarAccess.getExprRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpr=ruleExpr();

            state._fsp--;

             current =iv_ruleExpr.getText(); 
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
    // $ANTLR end "entryRuleExpr"


    // $ANTLR start "ruleExpr"
    // InternalWhdsl.g:1014:1: ruleExpr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '1' ;
    public final AntlrDatatypeRuleToken ruleExpr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWhdsl.g:1020:2: (kw= '1' )
            // InternalWhdsl.g:1021:2: kw= '1'
            {
            kw=(Token)match(input,31,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getExprAccess().getDigitOneKeyword());
            	

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
    // $ANTLR end "ruleExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000064200020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});

}