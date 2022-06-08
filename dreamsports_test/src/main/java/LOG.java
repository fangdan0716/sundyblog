import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

public class LOG {
    public  static  org.slf4j.Logger LOGGER=null;
    public static Logger log(String name){
         LOGGER=LoggerFactory.getLogger(name);
        return  LOGGER;
    }

    public static void main(String[] args) {
       Logger log = LOG.log("LOG");
       log.info("33332");
        log.error("errr");

        //System.out.println(log);
    }

}
