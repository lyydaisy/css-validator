// $Id: CssFontWeight.java,v 1.1 2012-08-04 21:17:06 ylafon Exp $
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2012.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css21;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssIdent;
import org.w3c.css.values.CssNumber;
import org.w3c.css.values.CssTypes;
import org.w3c.css.values.CssValue;

import java.util.HashMap;

/**
 * @spec http://www.w3.org/TR/2011/REC-CSS2-20110607/fonts.html#propdef-font-weight
 * @version $Revision: 1.1 $
 */
public class CssFontWeight extends org.w3c.css.properties.css.CssFontWeight {

	public static final HashMap<String,CssIdent> allowed_values;
	static final String[] _allowed_values = {"normal", "bold", "bolder", "lighter"};

	static {
		allowed_values = new HashMap<String, CssIdent>(_allowed_values.length);
		for (String s : _allowed_values) {
			allowed_values.put(s, CssIdent.getIdent(s));
		}
	}
    /**
     * Create a new CssFontWeight
     */
    public CssFontWeight() {
    }

    /**
     * Creates a new CssFontWeight
     *
     * @param expression The expression for this property
     * @throws org.w3c.css.util.InvalidParamException
     *          Expressions are incorrect
     */
    public CssFontWeight(ApplContext ac, CssExpression expression, boolean check)
            throws InvalidParamException {
		if (check && expression.getCount() > 1) {
			throw new InvalidParamException("unrecognize", ac);
		}
		setByUser();

		CssValue val;
		char op;

		val = expression.getValue();
		op = expression.getOperator();

		switch (val.getType()) {
			case CssTypes.CSS_NUMBER:
				CssNumber num = (CssNumber) val;
				switch(num.getInt()) {
					case 100:
					case 200:
					case 300:
					case 400:
					case 500:
					case 600:
					case 700:
					case 800:
					case 900:
					   value = num;
						break;
					default:
						throw new InvalidParamException("value",
								val.toString(),
								getPropertyName(), ac);
				}
				break;
			case CssTypes.CSS_IDENT:
				CssIdent ident = (CssIdent) val;
				if (inherit.equals(ident)) {
					value = inherit;
					break;
				}
				value = allowed_values.get(val.toString());
				if (value == null) {
					throw new InvalidParamException("value",
							val.toString(),
							getPropertyName(), ac);
				}
				break;
			default:
				throw new InvalidParamException("value",
						expression.getValue().toString(),
						getPropertyName(), ac);
		}
		expression.next();
    }

    public CssFontWeight(ApplContext ac, CssExpression expression)
            throws InvalidParamException {
        this(ac, expression, false);
    }

}
