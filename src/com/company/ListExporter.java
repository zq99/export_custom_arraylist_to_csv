package com.company;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ListExporter {

    /* this class is for exporting any ArrayList
     * with custom objects into a csv file
     */

    private final List<?> arrData;
    private final String fileName;
    private boolean indexRequired=false;
    private boolean headersRequired=true;

    public ListExporter(List<?> arrData, String fileName) {
        this.arrData = arrData;
        this.fileName = fileName;
    }

    public void setIndexRequired(boolean indexRequired) {
        this.indexRequired = indexRequired;
    }

    public void setHeadersRequired(boolean headersRequired) {
        this.headersRequired = headersRequired;
    }

    public void output() throws FileNotFoundException {
        File csvOutputFile = new File(fileName);
        long index = 0;
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            for (Object object : arrData) {
                RowData rowData = getRowData(object);
                if(indexRequired){
                    rowData.addIndex(index);
                }
                if(headersRequired && index == 0){
                    pw.write(rowData.getHeaders());
                }
                pw.write(rowData.getValues());
                index++;
            }
        } catch (IllegalAccessException | IntrospectionException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private RowData getRowData(Object object) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        StringBuilder sbValues = new StringBuilder();
        StringBuilder sbHeaders = new StringBuilder();
        BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
        for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
            String propertyName = propertyDesc.getName();
            if(!propertyName.equals("class")) {
                Object value = propertyDesc.getReadMethod().invoke(object);
                sbValues.append(escapeSpecialCharacters(String.valueOf(value)));
                sbValues.append(sbValues.length() > 0 ? "," : "");
                sbHeaders.append(escapeSpecialCharacters(propertyName));
                sbHeaders.append(sbValues.length() > 0 ? "," : "");
            }
        }
        sbValues.append("\n");
        sbHeaders.append("\n");
        return new RowData(sbHeaders.toString(),sbValues.toString());
    }

    private static class RowData{
        private String headers;
        private String values;

        public RowData(String headers, String values) {
            this.headers = headers;
            this.values = values;
        }

        public String getHeaders() {
            return headers;
        }

        public String getValues() {
            return values;
        }

        public void addIndex(long value){
            this.headers = "_id" + (this.headers.length() > 0 ? "," + this.headers : "");
            this.values = value + (this.values.length() > 0 ? "," + this.values : "");
        }
    }

    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public static void Export(List<?> arrData,String filename){
        try {
            ListExporter listExporter = new ListExporter(arrData,filename);
            listExporter.setHeadersRequired(true);
            listExporter.setIndexRequired(true);
            listExporter.output();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void Export(List<?> arrData,String filename,boolean addHeaders, boolean addIndex){
        try {
            ListExporter listExporter = new ListExporter(arrData,filename);
            listExporter.setHeadersRequired(addHeaders);
            listExporter.setIndexRequired(addIndex);
            listExporter.output();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
