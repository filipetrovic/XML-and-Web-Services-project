package ftn.xmlws.soap.web.rest.resource.response;

import java.util.List;

public class ListWrapper {

    private List<?> list;

    public ListWrapper() {

    }

    public ListWrapper(List<?> list) {
        this.list = list;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
