package visiteurs;

import java.io.PrintStream;

import meta.modele.Array;
import meta.modele.Attribute;
import meta.modele.Collection;
import meta.modele.Entity;
import meta.modele.Modele;

public class VisitorPrinter implements Visitor {

	/*
	 * Attributs
	 */
	private PrintStream out;

	/*
	 * Constructeur
	 */
	public VisitorPrinter(PrintStream out) {
		this.out = out;
	}

	/*
	 * Merhode de l'interface Visotor
	 */
	@Override
	public void visite(Modele modele) {
		for (Entity entity : modele.getEntities()) {
			entity.accept(this);
		}
	}

	@Override
	public void visite(Entity entity) {
		out.println("public class " + entity.getName());
		if(entity.getSubtype() != null) {
			out.print(" extends " + entity.getSubtype());
		}
		out.println(" {");
		for (Attribute attribute : entity.getAttributes()) {
			attribute.accept(this);
		}
		out.println("\tpublic " + entity.getName() + "() {}");
		this.printAccesseurs(entity);
		out.println("}");
	}

	@Override
	public void visite(Attribute attribute) {
		out.println("\t" + attribute.getType() + " " + attribute.getName() + ";");
	}

	@Override
	public void visite(Collection associationMultiple) {
		out.println("\t" + associationMultiple.getType() + "<" + associationMultiple.getTypeElements() + "> "
				+ associationMultiple.getName() + ";");
	}

	@Override
	public void visite(Array array) {
		out.println("\t" + array.getTypeElements() + "[] " + array.getName() + ";");
	}

	private void printAccesseurs(Entity entity) {
		for (Attribute attribute : entity.getAttributes()) {
			String name = attribute.getName().substring(0, 1).toUpperCase()
					+ attribute.getName().substring(1, attribute.getName().length());
			out.println("\tpublic " + attribute.getType() + " get" + name + "() {");
			out.println("\t\treturn this." + attribute.getName() + ";");
			out.println("\t}");

			out.println("\tpublic void set" + name + "(" + attribute.getType() + " " + attribute.getName() + ") {");
			out.println("\t\tthis." + attribute.getName() + " = " + attribute.getName() + ";");
			out.println("\t}");
		}

	}

}
