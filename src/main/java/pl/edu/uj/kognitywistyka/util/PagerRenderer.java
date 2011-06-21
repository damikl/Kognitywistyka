package pl.edu.uj.kognitywistyka.util;

import java.io.IOException;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = "javax.faces.Command", rendererType = "pl.edu.uj.kognitywistyka.Pager")
public class PagerRenderer extends Renderer {
    public void encodeBegin(FacesContext context, UIComponent component)
            throws IOException {
        String id = component.getClientId(context);
        UIComponent parent = component;
        while (!(parent instanceof UIForm))
            parent = parent.getParent();
        String formId = parent.getClientId(context);

        ResponseWriter writer = context.getResponseWriter();
        
        String dataTableId = (String) component.getAttributes().get(
                "dataTableId");
        int showpages = toInt(component.getAttributes().get("showpages"));

        UIData data = (UIData) component.findComponent(dataTableId);
        
        int first = data.getFirst();
        int itemcount = data.getRowCount();
        int pagesize = data.getRows();
        if (pagesize <= 0)
            pagesize = itemcount;
        int pages = itemcount / pagesize;
        if (itemcount % pagesize != 0)
            pages++;
        int currentPage = first / pagesize;
        if (first >= itemcount - pagesize)
            currentPage = pages - 1;
        int startPage = 0;
        int endPage = pages;
        if (showpages > 0) {
            startPage = (currentPage / showpages) * showpages;
            endPage = Math.min(startPage + showpages, pages);
        }
        
        // div.paginacja-box
        writer.startElement("div", component);
        writer.writeAttribute("class", "paginacja-box", null);

        // div.paginacja-prev
        writer.startElement("div", component);
        writer.writeAttribute("class", "paginacja-prev", null);
        writer.startElement("p", component);
        if (currentPage > 0)
            writeLink(writer, component, formId, id, "<", "link1");
        writer.endElement("p");
        writer.endElement("div");
        
        // div.paginacja-next
        writer.startElement("div", component);
        writer.writeAttribute("class", "paginacja-next", null);
        writer.startElement("p", component);
        if (first < itemcount - pagesize)
            writeLink(writer, component, formId, id, ">", "link1");
        writer.endElement("p");
        writer.endElement("div");
        
        // div.paginacja-number
        writer.startElement("div", component);
        writer.writeAttribute("class", "paginacja-number", null);
        
        for (int i = startPage; i < endPage; i++) {
            writer.startElement("span", component);
            if (i == currentPage)
                writer.writeAttribute("class", "paginacja-selected", null);
            //writer.writeText("" + (i + 1), null);
            writeLink(writer, component, formId, id, "" + (i + 1), "link1");
            writer.endElement("span");
        }
        
        writer.endElement("div");
        writer.endElement("div");
        writeHiddenField(writer, component, id);
    }

    private void writeLink(ResponseWriter writer, UIComponent component,
            String formId, String id, String value, String styleClass)
            throws IOException {
        writer.startElement("a", component);
        writer.writeAttribute("href", "#", null);
        writer.writeAttribute("onclick", onclickCode(formId, id, value), null);
        if (styleClass != null)
            writer.writeAttribute("class", styleClass, "styleClass");
        writer.writeText(value, null);
        writer.endElement("a");
    }

    private String onclickCode(String formId, String id, String value) {
        return new StringBuilder().append("document.forms['").append(formId)
                .append("']['").append(id).append("'].value='").append(value)
                .append("'; document.forms['").append(formId)
                .append("'].submit(); return false;").toString();
    }

    private void writeHiddenField(ResponseWriter writer, UIComponent component,
            String id) throws IOException {
        writer.startElement("input", component);
        writer.writeAttribute("type", "hidden", null);
        writer.writeAttribute("name", id, null);
        writer.endElement("input");
    }

    public void decode(FacesContext context, UIComponent component) {
        String id = component.getClientId(context);
        Map<String, String> parameters = context.getExternalContext()
                .getRequestParameterMap();

        String response = (String) parameters.get(id);
        if (response == null || response.equals(""))
            return;

        String dataTableId = (String) component.getAttributes().get(
                "dataTableId");

        UIData data = (UIData) component.findComponent(dataTableId);

        int first = data.getFirst();
        int itemcount = data.getRowCount();
        int pagesize = data.getRows();
        if (pagesize <= 0)
            pagesize = itemcount;

        if (response.equals("<"))
            first -= pagesize;
        else if (response.equals(">"))
            first += pagesize;
        else {
            int page = Integer.parseInt(response);
            first = (page - 1) * pagesize;
        }

        if (first < 0)
            first = 0;
        data.setFirst(first);
    }

    private static int toInt(Object value) {
        if (value == null)
            return 0;
        if (value instanceof Number)
            return ((Number) value).intValue();
        if (value instanceof String)
            return Integer.parseInt((String) value);
        throw new IllegalArgumentException("Cannot convert " + value);
    }
}