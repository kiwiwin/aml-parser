// Generated from AML.g4 by ANTLR 4.3
package org.tw.aml.antlr4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AMLParser}.
 */
public interface AMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AMLParser#aml}.
	 * @param ctx the parse tree
	 */
	void enterAml(@NotNull AMLParser.AmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link AMLParser#aml}.
	 * @param ctx the parse tree
	 */
	void exitAml(@NotNull AMLParser.AmlContext ctx);
}