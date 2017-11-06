package esir.compilation.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWhdslLexer extends Lexer {
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

    public InternalWhdslLexer() {;} 
    public InternalWhdslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalWhdslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalWhdsl.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:11:7: ( 'function' )
            // InternalWhdsl.g:11:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:12:7: ( ':' )
            // InternalWhdsl.g:12:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:13:7: ( 'read' )
            // InternalWhdsl.g:13:9: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:14:7: ( '%' )
            // InternalWhdsl.g:14:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:15:7: ( 'write' )
            // InternalWhdsl.g:15:9: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:16:7: ( ',' )
            // InternalWhdsl.g:16:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "RULE_VARIABLE"
    public final void mRULE_VARIABLE() throws RecognitionException {
        try {
            int _type = RULE_VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:644:15: ( ( 'A' .. 'Z' )* )
            // InternalWhdsl.g:644:17: ( 'A' .. 'Z' )*
            {
            // InternalWhdsl.g:644:17: ( 'A' .. 'Z' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalWhdsl.g:644:18: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VARIABLE"

    // $ANTLR start "RULE_SYMBOLE"
    public final void mRULE_SYMBOLE() throws RecognitionException {
        try {
            int _type = RULE_SYMBOLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:646:14: ( ( 'a' .. 'z' )* )
            // InternalWhdsl.g:646:16: ( 'a' .. 'z' )*
            {
            // InternalWhdsl.g:646:16: ( 'a' .. 'z' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalWhdsl.g:646:17: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SYMBOLE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:648:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalWhdsl.g:648:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalWhdsl.g:648:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalWhdsl.g:648:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalWhdsl.g:648:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalWhdsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:650:10: ( ( '0' .. '9' )+ )
            // InternalWhdsl.g:650:12: ( '0' .. '9' )+
            {
            // InternalWhdsl.g:650:12: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalWhdsl.g:650:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:652:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalWhdsl.g:652:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalWhdsl.g:652:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalWhdsl.g:652:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalWhdsl.g:652:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalWhdsl.g:652:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalWhdsl.g:652:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalWhdsl.g:652:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalWhdsl.g:652:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalWhdsl.g:652:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalWhdsl.g:652:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:654:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalWhdsl.g:654:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalWhdsl.g:654:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalWhdsl.g:654:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:656:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalWhdsl.g:656:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalWhdsl.g:656:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalWhdsl.g:656:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalWhdsl.g:656:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalWhdsl.g:656:41: ( '\\r' )? '\\n'
                    {
                    // InternalWhdsl.g:656:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalWhdsl.g:656:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:658:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalWhdsl.g:658:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalWhdsl.g:658:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalWhdsl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalWhdsl.g:660:16: ( . )
            // InternalWhdsl.g:660:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalWhdsl.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | RULE_VARIABLE | RULE_SYMBOLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=15;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalWhdsl.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // InternalWhdsl.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // InternalWhdsl.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // InternalWhdsl.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // InternalWhdsl.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // InternalWhdsl.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // InternalWhdsl.g:1:46: RULE_VARIABLE
                {
                mRULE_VARIABLE(); 

                }
                break;
            case 8 :
                // InternalWhdsl.g:1:60: RULE_SYMBOLE
                {
                mRULE_SYMBOLE(); 

                }
                break;
            case 9 :
                // InternalWhdsl.g:1:73: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 10 :
                // InternalWhdsl.g:1:81: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 11 :
                // InternalWhdsl.g:1:90: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 12 :
                // InternalWhdsl.g:1:102: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 13 :
                // InternalWhdsl.g:1:118: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 14 :
                // InternalWhdsl.g:1:134: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 15 :
                // InternalWhdsl.g:1:142: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\10\1\23\1\uffff\1\23\1\uffff\1\23\1\uffff\1\10\1\uffff\1\23\1\21\2\uffff\3\21\2\uffff\1\23\1\uffff\1\23\2\uffff\1\23\1\uffff\1\23\1\uffff\1\10\5\uffff\4\23\1\50\2\23\1\uffff\1\53\1\23\1\uffff\1\23\1\56\1\uffff";
    static final String DFA14_eofS =
        "\57\uffff";
    static final String DFA14_minS =
        "\1\0\1\60\1\uffff\1\60\1\uffff\1\60\1\uffff\1\60\1\uffff\1\60\1\101\2\uffff\2\0\1\52\2\uffff\1\60\1\uffff\1\60\2\uffff\1\60\1\uffff\1\60\1\uffff\1\60\5\uffff\7\60\1\uffff\2\60\1\uffff\2\60\1\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\1\uffff\2\172\2\uffff\2\uffff\1\57\2\uffff\1\172\1\uffff\1\172\2\uffff\1\172\1\uffff\1\172\1\uffff\1\172\5\uffff\7\172\1\uffff\2\172\1\uffff\2\172\1\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\uffff\1\6\1\uffff\1\7\2\uffff\1\11\1\12\3\uffff\1\16\1\17\1\uffff\1\10\1\uffff\1\11\1\2\1\uffff\1\4\1\uffff\1\6\1\uffff\1\12\1\13\1\14\1\15\1\16\7\uffff\1\3\2\uffff\1\5\2\uffff\1\1";
    static final String DFA14_specialS =
        "\1\0\14\uffff\1\2\1\1\40\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\21\2\20\2\21\1\20\22\21\1\20\1\21\1\15\2\21\1\4\1\21\1\16\4\21\1\6\2\21\1\17\12\14\1\2\6\21\32\7\3\21\1\12\1\13\1\21\5\11\1\1\13\11\1\3\4\11\1\5\3\11\uff85\21",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\24\24\1\22\5\24",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\4\24\1\27\25\24",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\21\24\1\31\10\24",
            "",
            "\12\25\7\uffff\32\33\4\uffff\1\25\1\uffff\32\25",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\24",
            "\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\0\35",
            "\0\35",
            "\1\36\4\uffff\1\37",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\15\24\1\41\14\24",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\24",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\1\42\31\24",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\10\24\1\43\21\24",
            "",
            "\12\25\7\uffff\32\33\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\2\24\1\44\27\24",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\3\24\1\45\26\24",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\23\24\1\46\6\24",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\23\24\1\47\6\24",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\24",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\4\24\1\51\25\24",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\10\24\1\52\21\24",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\24",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\16\24\1\54\13\24",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\15\24\1\55\14\24",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\24",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | RULE_VARIABLE | RULE_SYMBOLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='f') ) {s = 1;}

                        else if ( (LA14_0==':') ) {s = 2;}

                        else if ( (LA14_0=='r') ) {s = 3;}

                        else if ( (LA14_0=='%') ) {s = 4;}

                        else if ( (LA14_0=='w') ) {s = 5;}

                        else if ( (LA14_0==',') ) {s = 6;}

                        else if ( ((LA14_0>='A' && LA14_0<='Z')) ) {s = 7;}

                        else if ( ((LA14_0>='a' && LA14_0<='e')||(LA14_0>='g' && LA14_0<='q')||(LA14_0>='s' && LA14_0<='v')||(LA14_0>='x' && LA14_0<='z')) ) {s = 9;}

                        else if ( (LA14_0=='^') ) {s = 10;}

                        else if ( (LA14_0=='_') ) {s = 11;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 12;}

                        else if ( (LA14_0=='\"') ) {s = 13;}

                        else if ( (LA14_0=='\'') ) {s = 14;}

                        else if ( (LA14_0=='/') ) {s = 15;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 16;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||LA14_0=='!'||(LA14_0>='#' && LA14_0<='$')||LA14_0=='&'||(LA14_0>='(' && LA14_0<='+')||(LA14_0>='-' && LA14_0<='.')||(LA14_0>=';' && LA14_0<='@')||(LA14_0>='[' && LA14_0<=']')||LA14_0=='`'||(LA14_0>='{' && LA14_0<='\uFFFF')) ) {s = 17;}

                        else s = 8;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_14 = input.LA(1);

                        s = -1;
                        if ( ((LA14_14>='\u0000' && LA14_14<='\uFFFF')) ) {s = 29;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_13 = input.LA(1);

                        s = -1;
                        if ( ((LA14_13>='\u0000' && LA14_13<='\uFFFF')) ) {s = 29;}

                        else s = 17;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}