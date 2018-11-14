package xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlErrorHandler implements ErrorHandler {

	/*
	 * Attributs
	 */
	Boolean valide;
	List<SAXParseException> saxParseExceptions;

	/*
	 * Constructeurs
	 */
	public XmlErrorHandler() {
		super();
		this.valide = true;
		this.saxParseExceptions = new ArrayList<>();
	}

	/*
	 * Methodes
	 */

	@Override
	public void error(SAXParseException exception) throws SAXException {
		this.valide = false;
		this.saxParseExceptions.add(exception);
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		this.valide = false;
		this.saxParseExceptions.add(exception);
	}

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		this.valide = false;
		this.saxParseExceptions.add(exception);
	}

	/*
	 * Accesseurs
	 */

	public Boolean isValide() {
		return this.valide;
	}
	
	public List<SAXParseException> getSAXParseExceptions() {
		return this.saxParseExceptions;
	}
}
