// $Id: CssVoiceBalance.java,v 1.1 2013-01-04 15:41:44 ylafon Exp $
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2013.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css;

import org.w3c.css.parser.CssStyle;
import org.w3c.css.properties.css3.Css3Style;
import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssValue;

/**
 * @since CSS3
 */
public class CssVoiceBalance extends CssProperty {

	public CssValue value;

	/**
	 * Create a new CssVoiceBalance
	 */
	public CssVoiceBalance() {
	}

	/**
	 * Creates a new CssVoiceBalance
	 *
	 * @param expression The expression for this property
	 * @throws org.w3c.css.util.InvalidParamException
	 *          Expressions are incorrect
	 */
	public CssVoiceBalance(ApplContext ac, CssExpression expression, boolean check)
			throws InvalidParamException {
		throw new InvalidParamException("value",
				expression.getValue().toString(),
				getPropertyName(), ac);
	}

	public CssVoiceBalance(ApplContext ac, CssExpression expression)
			throws InvalidParamException {
		this(ac, expression, false);
	}

	/**
	 * Returns the value of this property
	 */
	public Object get() {
		return value;
	}


	/**
	 * Returns the name of this property
	 */
	public final String getPropertyName() {
		return "voice-balance";
	}

	/**
	 * Returns true if this property is "softly" inherited
	 * e.g. his value is equals to inherit
	 */
	public boolean isSoftlyInherited() {
		return value.equals(inherit);
	}

	/**
	 * Returns a string representation of the object.
	 */
	public String toString() {
		return value.toString();
	}

	/**
	 * Add this property to the CssStyle.
	 *
	 * @param style The CssStyle
	 */
	public void addToStyle(ApplContext ac, CssStyle style) {
		Css3Style s = (Css3Style) style;
		if (s.cssVoiceBalance != null) {
			style.addRedefinitionWarning(ac, this);
		}
		s.cssVoiceBalance = this;
	}


	/**
	 * Compares two properties for equality.
	 *
	 * @param property The other property.
	 */
	public boolean equals(CssProperty property) {
		return (property instanceof CssVoiceBalance &&
				value.equals(((CssVoiceBalance) property).value));
	}


	/**
	 * Get this property in the style.
	 *
	 * @param style   The style where the property is
	 * @param resolve if true, resolve the style to find this property
	 */
	public CssProperty getPropertyInStyle(CssStyle style, boolean resolve) {
		if (resolve) {
			return ((Css3Style) style).getVoiceBalance();
		} else {
			return ((Css3Style) style).cssVoiceBalance;
		}
	}
}
