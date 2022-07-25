package shared.request;

import java.util.HashMap;

public class Request {
  private RequestType requestType;
  private HashMap<String, Object> data;

  public Request(RequestType requestType) {
    this.requestType = requestType;

    data = new HashMap<>();
  }

  public RequestType getRequestType() {
    return requestType;
  }

  public void addData(String dataName, Object data) {
    this.data.put(dataName, data);
  }

  public Object getData(String dataName) {
    return this.data.get(dataName);
  }

  @Override
  public String toString() {
    String str = requestType.name();
    for (String string : data.keySet()) {
      str += " " + string;
    }
    return str;
  }
}
