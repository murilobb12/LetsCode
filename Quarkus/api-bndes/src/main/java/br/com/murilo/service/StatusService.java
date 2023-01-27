//package br.com.murilo.service;
//
//import org.jboss.logging.Logger;
//import org.jboss.resteasy.specimpl.BuiltResponse;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.ws.rs.core.Response;
//
//@ApplicationScoped
//public class StatusService {
//
//    private static Logger LOG = Logger.getLogger(StatusService.class);
//
//    public void verificaStatus(){
//
//        Response response = new BuiltResponse();
//
//        if (response.getStatus() == 200){
//            LOG.info("OK");
//        }else {
//            LOG.error("ERROR");
//        }
//
//    }
//
//
//}
