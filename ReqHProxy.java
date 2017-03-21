package cris;

public class ReqHProxy implements cris.ReqH {
  private String _endpoint = null;
  private cris.ReqH reqH = null;
  
  public ReqHProxy() {
    _initReqHProxy();
  }
  
  public ReqHProxy(String endpoint) {
    _endpoint = endpoint;
    _initReqHProxy();
  }
  
  private void _initReqHProxy() {
    try {
      reqH = (new cris.ReqHServiceLocator()).getReqH();
      if (reqH != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reqH)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reqH)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reqH != null)
      ((javax.xml.rpc.Stub)reqH)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cris.ReqH getReqH() {
    if (reqH == null)
      _initReqHProxy();
    return reqH;
  }
  
  public java.lang.String test() throws java.rmi.RemoteException{
    if (reqH == null)
      _initReqHProxy();
    return reqH.test();
  }
  
  public java.lang.String add(int a, int b) throws java.rmi.RemoteException{
    if (reqH == null)
      _initReqHProxy();
    return reqH.add(a, b);
  }
  
  
}
