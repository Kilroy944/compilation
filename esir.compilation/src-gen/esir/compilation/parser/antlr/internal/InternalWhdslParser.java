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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SYMBOLE", "RULE_VARIABLE", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'function'", "':'", "'read'", "'%'", "'write'", "','"
    };
    public static final int RULE_ID=6;
    public static final int RULE_WS=11;
    public static final int RULE_STRING=8;
    public static final int RULE_VARIABLE=5;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_SYMBOLE=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=7;
    public static final int T__18=18;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

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

                if ( (LA1_0==13) ) {
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
    // InternalWhdsl.g:107:1: ruleFunction returns [EObject current=null] : (otherlv_0= 'function' ( (lv_symbol_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_symbol_1_0=null;
        Token otherlv_2=null;
        EObject lv_definition_3_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:113:2: ( (otherlv_0= 'function' ( (lv_symbol_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) ) ) )
            // InternalWhdsl.g:114:2: (otherlv_0= 'function' ( (lv_symbol_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) ) )
            {
            // InternalWhdsl.g:114:2: (otherlv_0= 'function' ( (lv_symbol_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) ) )
            // InternalWhdsl.g:115:3: otherlv_0= 'function' ( (lv_symbol_1_0= RULE_SYMBOLE ) ) otherlv_2= ':' ( (lv_definition_3_0= ruleDefinition ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getFunctionKeyword_0());
            		
            // InternalWhdsl.g:119:3: ( (lv_symbol_1_0= RULE_SYMBOLE ) )
            // InternalWhdsl.g:120:4: (lv_symbol_1_0= RULE_SYMBOLE )
            {
            // InternalWhdsl.g:120:4: (lv_symbol_1_0= RULE_SYMBOLE )
            // InternalWhdsl.g:121:5: lv_symbol_1_0= RULE_SYMBOLE
            {
            lv_symbol_1_0=(Token)match(input,RULE_SYMBOLE,FOLLOW_5); 

            					newLeafNode(lv_symbol_1_0, grammarAccess.getFunctionAccess().getSymbolSYMBOLETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"symbol",
            						lv_symbol_1_0,
            						"esir.compilation.Whdsl.SYMBOLE");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_6); 

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
    // InternalWhdsl.g:171:1: ruleDefinition returns [EObject current=null] : (otherlv_0= 'read' ( (lv_inoutput_1_0= ruleInOutput ) ) otherlv_2= '%' otherlv_3= '%' otherlv_4= 'write' ( (lv_inoutput2_5_0= ruleInOutput ) ) ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_inoutput_1_0 = null;

        EObject lv_inoutput2_5_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:177:2: ( (otherlv_0= 'read' ( (lv_inoutput_1_0= ruleInOutput ) ) otherlv_2= '%' otherlv_3= '%' otherlv_4= 'write' ( (lv_inoutput2_5_0= ruleInOutput ) ) ) )
            // InternalWhdsl.g:178:2: (otherlv_0= 'read' ( (lv_inoutput_1_0= ruleInOutput ) ) otherlv_2= '%' otherlv_3= '%' otherlv_4= 'write' ( (lv_inoutput2_5_0= ruleInOutput ) ) )
            {
            // InternalWhdsl.g:178:2: (otherlv_0= 'read' ( (lv_inoutput_1_0= ruleInOutput ) ) otherlv_2= '%' otherlv_3= '%' otherlv_4= 'write' ( (lv_inoutput2_5_0= ruleInOutput ) ) )
            // InternalWhdsl.g:179:3: otherlv_0= 'read' ( (lv_inoutput_1_0= ruleInOutput ) ) otherlv_2= '%' otherlv_3= '%' otherlv_4= 'write' ( (lv_inoutput2_5_0= ruleInOutput ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getReadKeyword_0());
            		
            // InternalWhdsl.g:183:3: ( (lv_inoutput_1_0= ruleInOutput ) )
            // InternalWhdsl.g:184:4: (lv_inoutput_1_0= ruleInOutput )
            {
            // InternalWhdsl.g:184:4: (lv_inoutput_1_0= ruleInOutput )
            // InternalWhdsl.g:185:5: lv_inoutput_1_0= ruleInOutput
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getInoutputInOutputParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
            lv_inoutput_1_0=ruleInOutput();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					set(
            						current,
            						"inoutput",
            						lv_inoutput_1_0,
            						"esir.compilation.Whdsl.InOutput");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getPercentSignKeyword_2());
            		
            otherlv_3=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getDefinitionAccess().getPercentSignKeyword_3());
            		
            otherlv_4=(Token)match(input,17,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getWriteKeyword_4());
            		
            // InternalWhdsl.g:214:3: ( (lv_inoutput2_5_0= ruleInOutput ) )
            // InternalWhdsl.g:215:4: (lv_inoutput2_5_0= ruleInOutput )
            {
            // InternalWhdsl.g:215:4: (lv_inoutput2_5_0= ruleInOutput )
            // InternalWhdsl.g:216:5: lv_inoutput2_5_0= ruleInOutput
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getInoutput2InOutputParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_inoutput2_5_0=ruleInOutput();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					set(
            						current,
            						"inoutput2",
            						lv_inoutput2_5_0,
            						"esir.compilation.Whdsl.InOutput");
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


    // $ANTLR start "entryRuleInOutput"
    // InternalWhdsl.g:237:1: entryRuleInOutput returns [EObject current=null] : iv_ruleInOutput= ruleInOutput EOF ;
    public final EObject entryRuleInOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInOutput = null;


        try {
            // InternalWhdsl.g:237:49: (iv_ruleInOutput= ruleInOutput EOF )
            // InternalWhdsl.g:238:2: iv_ruleInOutput= ruleInOutput EOF
            {
             newCompositeNode(grammarAccess.getInOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInOutput=ruleInOutput();

            state._fsp--;

             current =iv_ruleInOutput; 
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
    // $ANTLR end "entryRuleInOutput"


    // $ANTLR start "ruleInOutput"
    // InternalWhdsl.g:244:1: ruleInOutput returns [EObject current=null] : ( ( ( (lv_variable_0_0= RULE_VARIABLE ) ) otherlv_1= ',' ( (lv_inoutput_2_0= ruleInOutput ) ) ) | ( (lv_variable2_3_0= RULE_VARIABLE ) ) ) ;
    public final EObject ruleInOutput() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token otherlv_1=null;
        Token lv_variable2_3_0=null;
        EObject lv_inoutput_2_0 = null;



        	enterRule();

        try {
            // InternalWhdsl.g:250:2: ( ( ( ( (lv_variable_0_0= RULE_VARIABLE ) ) otherlv_1= ',' ( (lv_inoutput_2_0= ruleInOutput ) ) ) | ( (lv_variable2_3_0= RULE_VARIABLE ) ) ) )
            // InternalWhdsl.g:251:2: ( ( ( (lv_variable_0_0= RULE_VARIABLE ) ) otherlv_1= ',' ( (lv_inoutput_2_0= ruleInOutput ) ) ) | ( (lv_variable2_3_0= RULE_VARIABLE ) ) )
            {
            // InternalWhdsl.g:251:2: ( ( ( (lv_variable_0_0= RULE_VARIABLE ) ) otherlv_1= ',' ( (lv_inoutput_2_0= ruleInOutput ) ) ) | ( (lv_variable2_3_0= RULE_VARIABLE ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_VARIABLE) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==18) ) {
                    alt2=1;
                }
                else if ( (LA2_1==EOF||LA2_1==13||LA2_1==16) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalWhdsl.g:252:3: ( ( (lv_variable_0_0= RULE_VARIABLE ) ) otherlv_1= ',' ( (lv_inoutput_2_0= ruleInOutput ) ) )
                    {
                    // InternalWhdsl.g:252:3: ( ( (lv_variable_0_0= RULE_VARIABLE ) ) otherlv_1= ',' ( (lv_inoutput_2_0= ruleInOutput ) ) )
                    // InternalWhdsl.g:253:4: ( (lv_variable_0_0= RULE_VARIABLE ) ) otherlv_1= ',' ( (lv_inoutput_2_0= ruleInOutput ) )
                    {
                    // InternalWhdsl.g:253:4: ( (lv_variable_0_0= RULE_VARIABLE ) )
                    // InternalWhdsl.g:254:5: (lv_variable_0_0= RULE_VARIABLE )
                    {
                    // InternalWhdsl.g:254:5: (lv_variable_0_0= RULE_VARIABLE )
                    // InternalWhdsl.g:255:6: lv_variable_0_0= RULE_VARIABLE
                    {
                    lv_variable_0_0=(Token)match(input,RULE_VARIABLE,FOLLOW_10); 

                    						newLeafNode(lv_variable_0_0, grammarAccess.getInOutputAccess().getVariableVARIABLETerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getInOutputRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"variable",
                    							lv_variable_0_0,
                    							"esir.compilation.Whdsl.VARIABLE");
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,18,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getInOutputAccess().getCommaKeyword_0_1());
                    			
                    // InternalWhdsl.g:275:4: ( (lv_inoutput_2_0= ruleInOutput ) )
                    // InternalWhdsl.g:276:5: (lv_inoutput_2_0= ruleInOutput )
                    {
                    // InternalWhdsl.g:276:5: (lv_inoutput_2_0= ruleInOutput )
                    // InternalWhdsl.g:277:6: lv_inoutput_2_0= ruleInOutput
                    {

                    						newCompositeNode(grammarAccess.getInOutputAccess().getInoutputInOutputParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_inoutput_2_0=ruleInOutput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInOutputRule());
                    						}
                    						set(
                    							current,
                    							"inoutput",
                    							lv_inoutput_2_0,
                    							"esir.compilation.Whdsl.InOutput");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWhdsl.g:296:3: ( (lv_variable2_3_0= RULE_VARIABLE ) )
                    {
                    // InternalWhdsl.g:296:3: ( (lv_variable2_3_0= RULE_VARIABLE ) )
                    // InternalWhdsl.g:297:4: (lv_variable2_3_0= RULE_VARIABLE )
                    {
                    // InternalWhdsl.g:297:4: (lv_variable2_3_0= RULE_VARIABLE )
                    // InternalWhdsl.g:298:5: lv_variable2_3_0= RULE_VARIABLE
                    {
                    lv_variable2_3_0=(Token)match(input,RULE_VARIABLE,FOLLOW_2); 

                    					newLeafNode(lv_variable2_3_0, grammarAccess.getInOutputAccess().getVariable2VARIABLETerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getInOutputRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"variable2",
                    						lv_variable2_3_0,
                    						"esir.compilation.Whdsl.VARIABLE");
                    				

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
    // $ANTLR end "ruleInOutput"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});

}