package ec.come.html4j.component.table.elements;

import static ec.com.html4j.util.Constants.ALIGN;
import static ec.com.html4j.util.Constants.CLASS;
import static ec.com.html4j.util.Constants.DIR;
import static ec.com.html4j.util.Constants.ID;
import static ec.com.html4j.util.Constants.LANG;
import static ec.com.html4j.util.Constants.STYLE;
import static ec.com.html4j.util.Constants.TITLE;
import static ec.com.html4j.util.Constants.VALIGN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ec.com.html4j.generic.HTMLComponent;
import ec.com.html4j.util.tag.TableTag;
import ec.com.html4j.validator.util.ConversorUtil;

public class Tr extends GenericCell {

	private static final long serialVersionUID = -1660494220932306457L;

	private List<HTMLComponent> columns;

	public Tr() {
		this.setColumns(new ArrayList<>());
	}

	public Tr addColumn(HTMLComponent column) {
		getColumns().add(column);
		return this;
	}

	public Tr addColumns(HTMLComponent... columns) {
		getColumns().addAll(Arrays.asList(columns));
		return this;
	}

	@Override
	public String build() {
		StringBuilder builder = new StringBuilder();
		builder.append("<").append(TableTag.TR_TAG + " ");
		builder.append(ConversorUtil.parseItemToHtmlAttribute(ID, this.id));
		builder.append(ConversorUtil.parseItemToHtmlAttribute(CLASS, this.styleClass));
		builder.append(ConversorUtil.parseItemToHtmlAttribute(STYLE, this.styles));
		builder.append(ConversorUtil.parseItemToHtmlAttribute(DIR, this.dir));
		builder.append(ConversorUtil.parseItemToHtmlAttribute(LANG, this.lang));
		builder.append(ConversorUtil.parseItemToHtmlAttribute(TITLE, this.title));
		builder.append(ConversorUtil.parseItemToHtmlAttribute(VALIGN, this.valign));
		builder.append(ConversorUtil.parseItemToHtmlAttribute(ALIGN, this.align));
		builder.append(">");
		for (HTMLComponent td : getColumns())
			builder.append(td.build());
		builder.append("</").append(TableTag.TR_TAG).append(">");
		return builder.toString();
	}

	protected List<HTMLComponent> getColumns() {
		return columns;
	}

	private void setColumns(List<HTMLComponent> columns) {
		this.columns = columns;
	}

}
