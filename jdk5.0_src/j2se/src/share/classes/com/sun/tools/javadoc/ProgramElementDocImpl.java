/**
 * @(#)ProgramElementDocImpl.java	1.21 04/04/08
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.tools.javadoc;

import com.sun.javadoc.*;

import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symbol.ClassSymbol;

import com.sun.tools.javac.tree.Tree;

import java.lang.reflect.Modifier;
import java.text.CollationKey;

/**
 * Represents a java program element: class, interface, field,
 * constructor, or method.
 * This is an abstract class dealing with information common to
 * these elements.
 *
 * @see MemberDocImpl
 * @see ClassDocImpl
 *
 * @author Robert Field
 * @author Neal Gafter (rewrite)
 * @author Scott Seligman (generics, enums, annotations)
 */
public abstract class ProgramElementDocImpl
	extends DocImpl implements ProgramElementDoc {

    private final Symbol sym;

    // For source position information.
    Tree tree = null;

    // Cache for getModifiers().
    private int modifiers = -1;

    protected ProgramElementDocImpl(DocEnv env, Symbol sym,
				    String doc, Tree tree) {
	super(env, doc);
	this.sym = sym;
	this.tree = tree;
    }

    void setTree(Tree tree) {
	this.tree = tree;
    }

    /**
     * Subclasses override to identify the containing class
     */
    protected abstract ClassSymbol getContainingClass();

    /**
     * Returns the flags in terms of javac's flags
     */
    abstract protected long getFlags();

    /**
     * Returns the modifier flags in terms of java.lang.reflect.Modifier.
     */
    protected int getModifiers() {
	if (modifiers == -1) {
	    modifiers = DocEnv.translateModifiers(getFlags());
	}
	return modifiers;
    }

    /**
     * Get the containing class of this program element.
     *
     * @return a ClassDocImpl for this element's containing class.
     * If this is a class with no outer class, return null.
     */
    public ClassDoc containingClass() {
        if (getContainingClass() == null) {
	    return null;
	}
        return env.getClassDoc(getContainingClass());
    }

    /**
     * Return the package that this member is contained in.
     * Return "" if in empty package.
     */
    public PackageDoc containingPackage() {
        return env.getPackageDoc(getContainingClass().packge());
    }

    /**
     * Get the modifier specifier integer.
     *
     * @see java.lang.reflect.Modifier
     */
    public int modifierSpecifier() {
	int modifiers = getModifiers();
	if (isMethod() && containingClass().isInterface()) 
	    // Remove the implicit abstract modifier.
	    return modifiers & ~Modifier.ABSTRACT;
	return modifiers;
    }

    /**
     * Get modifiers string.
     * <pre>
     * Example, for:
     *   public abstract int foo() { ... }
     * modifiers() would return:
     *   'public abstract'
     * </pre>
     * Annotations are not included.
     */
    public String modifiers() {
	int modifiers = getModifiers();
	if (isAnnotationTypeElement() ||
		(isMethod() && containingClass().isInterface())) {
	    // Remove the implicit abstract modifier.
	    return Modifier.toString(modifiers & ~Modifier.ABSTRACT);
	} else {
	    return Modifier.toString(modifiers);
	} 
    }

    /**
     * Get the annotations of this program element.
     * Return an empty array if there are none.
     */
    public AnnotationDesc[] annotations() {
	AnnotationDesc res[] = new AnnotationDesc[sym.attributes().length()];
	int i = 0;
	for (Attribute.Compound a : sym.attributes()) {
	    res[i++] = new AnnotationDescImpl(env, a);
	}
	return res;
    }

    /**
     * Return true if this program element is public
     */
    public boolean isPublic() {
	int modifiers = getModifiers();
        return Modifier.isPublic(modifiers);
    }

    /**
     * Return true if this program element is protected
     */
    public boolean isProtected() {
	int modifiers = getModifiers();
        return Modifier.isProtected(modifiers);
    }

    /**
     * Return true if this program element is private
     */
    public boolean isPrivate() {
	int modifiers = getModifiers();
        return Modifier.isPrivate(modifiers);
    }

    /**
     * Return true if this program element is package private
     */
    public boolean isPackagePrivate() {
        return !(isPublic() || isPrivate() || isProtected());
    }

    /**
     * Return true if this program element is static
     */
    public boolean isStatic() {
	int modifiers = getModifiers();
        return Modifier.isStatic(modifiers);
    }

    /**
     * Return true if this program element is final
     */
    public boolean isFinal() {
	int modifiers = getModifiers();
        return Modifier.isFinal(modifiers);
    }

    /**
     * Generate a key for sorting.
     */
    CollationKey generateKey() {
	String k = name();
	// System.out.println("COLLATION KEY FOR " + this + " is \"" + k + "\"");
        return env.doclocale.collator.getCollationKey(k);
    }

}