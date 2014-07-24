// Generated from AML.g4 by ANTLR 4.3
package org.tw.aml.antlr4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AMLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AMLParser#aml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAml(@NotNull AMLParser.AmlContext ctx);
}