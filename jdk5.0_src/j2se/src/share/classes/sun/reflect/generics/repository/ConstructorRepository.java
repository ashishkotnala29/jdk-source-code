/*
 * @(#)ConstructorRepository.java	1.3 04/07/15
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package sun.reflect.generics.repository;

import java.lang.reflect.Type;
import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.parser.SignatureParser;
import sun.reflect.generics.tree.FieldTypeSignature;
import sun.reflect.generics.tree.MethodTypeSignature;
import sun.reflect.generics.tree.TypeSignature;
import sun.reflect.generics.visitor.Reifier;



/**
 * This class represents the generic type information for a constructor.
 * The code is not dependent on a particular reflective implementation.
 * It is designed to be used unchanged by at least core reflection and JDI.
 */
public class ConstructorRepository 
    extends GenericDeclRepository<MethodTypeSignature> {

    private Type[] paramTypes; // caches the generic parameter types info
    private Type[] exceptionTypes; // caches the generic exception types info

 // protected, to enforce use of static factory yet allow subclassing
    protected ConstructorRepository(String rawSig, GenericsFactory f) {
      super(rawSig, f);
    }

    protected MethodTypeSignature parse(String s) {
	return SignatureParser.make().parseMethodSig(s);
    }

    /**
     * Static factory method.
     * @param rawSig - the generic signature of the reflective object
     * that this repository is servicing
     * @param f - a factory that will provide instances of reflective
     * objects when this repository converts its AST
     * @return a <tt>ConstructorRepository</tt> that manages the generic type
     * information represented in the signature <tt>rawSig</tt>
     */
    public static ConstructorRepository make(String rawSig, 
					     GenericsFactory f) {
	return new ConstructorRepository(rawSig, f);
    }

    // public API

 /*
 * When queried for a particular piece of type information, the
 * general pattern is to consult the corresponding cached value.
 * If the corresponding field is non-null, it is returned.
 * If not, it is created lazily. This is done by selecting the appropriate 
 * part of the tree and transforming it into a reflective object
 * using a visitor. 
 * a visitor, which is created by feeding it the factory
 * with which the repository was created.
 */

    public Type[] getParameterTypes(){
	if (paramTypes == null) { // lazily initialize parameter types
	    // first, extract parameter type subtree(s) from AST
	    TypeSignature[] pts = getTree().getParameterTypes();
	    // create array to store reified subtree(s)
	    Type[] ps = new Type[pts.length];
	    // reify all subtrees
	    for (int i = 0; i < pts.length; i++) {
		Reifier r = getReifier(); // obtain visitor
		pts[i].accept(r); // reify subtree
		// extract result from visitor and store it
		ps[i] = r.getResult();
	    }
	    paramTypes = ps; // cache overall result
	}
	return paramTypes.clone(); // return cached result
    }

    public Type[] getExceptionTypes(){
	if (exceptionTypes == null) { // lazily initialize exception types
	    // first, extract exception type subtree(s) from AST
	    FieldTypeSignature[] ets = getTree().getExceptionTypes();
	    // create array to store reified subtree(s)
	    Type[] es = new Type[ets.length];
	    // reify all subtrees
	    for (int i = 0; i < ets.length; i++) {
		Reifier r = getReifier(); // obtain visitor
		ets[i].accept(r); // reify subtree
		// extract result from visitor and store it
		es[i] = r.getResult();
	    }
	    exceptionTypes = es; // cache overall result
	}
	return exceptionTypes.clone(); // return cached result
    }
}

